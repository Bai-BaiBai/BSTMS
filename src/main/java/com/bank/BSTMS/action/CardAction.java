package com.bank.BSTMS.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.BSTMS.pojo.CardInfo;
import com.bank.BSTMS.service.CardService;
import com.bank.BSTMS.service.ExchangeService;
import com.bank.BSTMS.service.ValidateCodeService;
import com.bank.BSTMS.util.ApiResponse;
import com.bank.BSTMS.util.Constant;

/**
 * 
 * @ClassName: CardAction
 * @Description: 处理有关银行卡操作的请求 ： 存取款、查余额、修改银行卡密码、转账
 * @author BaiZehong
 * @date 2019年6月25日
 * @since JDK 1.8
 */
@RestController
public class CardAction {

	@Autowired
	private CardService cardService;
	
	@Autowired
	private ExchangeService exchangeService;
	
	@Autowired
	private ValidateCodeService validateCodeService;
	
	/**
	 * 
	 * @Title: verifyAccount
	 * @Description: 验证输入的银行卡号是否存在
	 * @param cardId
	 * @return
	 */
	@PostMapping("/verifyAccount")
	public ApiResponse<CardInfo> verifyAccount(@RequestParam Long cardId){
		
		ApiResponse<CardInfo> response = new ApiResponse<CardInfo>();
		CardInfo cardInfo = cardService.selectByCardId(cardId);
		
		if (cardInfo != null) {
			response.setCode(ApiResponse.SUCCESS_CODE);
			response.setData(cardInfo);
		}
		else {
			response.setCode(ApiResponse.ERROR_CODE);
			response.setError(Constant.VERIFY_ACCOUNT_FAILURE_ERROR);
		}
		
		return response;
	}
	
	/**
	 * 
	 * @Title: updateMoney
	 * @Description: 存取款操作，通过state辨识，成功返回银行卡信息；失败返回提示信息
	 * @param money
	 * @param request
	 * @return
	 */
	@PutMapping("/money")
	public ApiResponse<CardInfo> updateMoney(@RequestParam int state,@RequestParam double money,@RequestParam String tradeLocation, HttpServletRequest request){
		
		ApiResponse<CardInfo> response = new ApiResponse<>();
		Long cardId = (Long) request.getSession().getAttribute(Constant.SESSION_ATTRIBUTE_CARD_ID);
		
		int executeResult;
		// 如果存取款操作成功
		if ((executeResult = cardService.updateMoney(state, cardId, money, tradeLocation)) == Constant.SAVE_GET_MONEY_SUCCESS) {
			response.setCode(ApiResponse.SUCCESS_CODE);
			response.setData(cardService.selectByCardId(cardId));
		}
		// 如果失败
		else {
			// 存失败
			if (executeResult == Constant.SAVE_MONEY_FAILURE) {
				response.setError(Constant.SAVE_MONEY_FAILURE_ERROR);
			}
			// 取失败
			else { // executeResult == Constant.GET_MONEY_FAILURE
				response.setError(Constant.GET_MONEY_FAILURE_ERROR);
			}
			response.setCode(ApiResponse.ERROR_CODE);
			
		}
		return response;
	}
	
	/**
	 * 
	 * @Title: queryBalance
	 * @Description: 查询银行卡余额 和 可用余额
	 * @param request
	 * @return
	 */
	@GetMapping("/money")
	public ApiResponse< Map<String, Double> > queryBalance(HttpServletRequest request){
		
		ApiResponse<Map<String, Double>> response = new ApiResponse<Map<String, Double>>();
		Long cardId = (Long) request.getSession().getAttribute(Constant.SESSION_ATTRIBUTE_CARD_ID);
		
		CardInfo cardInfo = cardService.selectByCardId(cardId);
		// 值不为空说明查询成功
		if (cardInfo != null) {
			response.setCode(ApiResponse.SUCCESS_CODE);
			response.setData(new HashMap<String, Double>(2) {
				{
					put("AccountBalance", cardInfo.getAccountBalance());
					put("AvailableBalance", cardInfo.getAccountBalance() + cardInfo.getOverdraftBalance());
				}
			});
		}
		else {
			response.setCode(ApiResponse.ERROR_CODE);
			response.setError(Constant.QUERY_MONEY_FAILURE_ERROR);
		}
		return response;
	}
	
	/**
	 * 
	 * @Title: updatePassword
	 * @Description: 处理修改银行卡密码请求
	 * @param newPassword
	 * @param request
	 * @return
	 */
	@PutMapping("/password")
	public ApiResponse<CardInfo> updatePassword(@RequestParam int oldPassword, @RequestParam int newPassword, @RequestParam String validateCode, HttpServletRequest request){
		
		ApiResponse<CardInfo> response = new ApiResponse<CardInfo>();
		Long cardId = (Long) request.getSession().getAttribute(Constant.SESSION_ATTRIBUTE_CARD_ID);
		
		CardInfo cardInfo = null;
		// 验证码验证通过后，执行更新密码操作
		if (validateCodeService.validate(request, validateCode)) {
			cardInfo = cardService.updatePassword(cardId, oldPassword, newPassword);
		} else {
			response.setCode(ApiResponse.ERROR_CODE);
			response.setError(Constant.VALIDATE_CODE_ERROR);
			return response;
		}
		
		if (cardInfo != null) {
			response.setCode(ApiResponse.SUCCESS_CODE);
			response.setData(cardInfo);
		}
		else {
			response.setCode(ApiResponse.ERROR_CODE);
			response.setError(Constant.UPDATE_PASSWORD_FAILURE_ERROR);
		}
		return response;
	}
	
	/**
	 * 
	 * @Title: transfer
	 * @Description: 处理转账请求
	 * @param cardIdTo
	 * @param money
	 * @param tradeLocation
	 * @param request
	 * @return
	 */
	@PostMapping("/transfer")
	public ApiResponse<CardInfo> transfer(@RequestParam Long cardIdTo, @RequestParam double money,@RequestParam String tradeLocation, HttpServletRequest request){
		
		ApiResponse<CardInfo> response = new ApiResponse<CardInfo>();
		Long cardIdFrom = (Long) request.getSession().getAttribute(Constant.SESSION_ATTRIBUTE_CARD_ID);
		
		// 传入参数：转账卡号(当前登录卡号)、接受卡、转账金额、交易地点
		CardInfo cardInfo = cardService.transfer(cardIdFrom, cardIdTo, money, tradeLocation);
		if (cardInfo != null) {
			response.setCode(ApiResponse.SUCCESS_CODE);
			response.setData(cardInfo);
		}
		else {
			response.setCode(ApiResponse.ERROR_CODE);
			response.setError(Constant.TRANSFER_FAILURE_ERROR);
		}
		return response;
	}
	
	/**
	 * 
	 * @Title: exchangeCurrency
	 * @Description: 处理交易外币请求
	 * @param exchangeRateId
	 * @param money
	 * @param tradeLocation
	 * @param request
	 * @return
	 */
	@PostMapping("/forignCurrency")
	public ApiResponse<CardInfo> exchangeCurrency(@RequestParam int exchangeRateId, @RequestParam double money, @RequestParam String tradeLocation, HttpServletRequest request){
		
		ApiResponse<CardInfo> response = new ApiResponse<CardInfo>();
		Long cardId = (Long) request.getSession().getAttribute(Constant.SESSION_ATTRIBUTE_CARD_ID);
		
		// 传入参数：当前卡号、货币id、金额、交易地点
		CardInfo cardInfo = exchangeService.exchangeCurrency(cardId, exchangeRateId, money, tradeLocation);
		if (cardInfo != null) {
			response.setCode(ApiResponse.SUCCESS_CODE);
			response.setData(cardInfo);
		}
		else {
			response.setCode(ApiResponse.ERROR_CODE);
			response.setError(Constant.EXCHANGE_CURRENCY_FAILURE_ERROR);
		}
		return response;
	}
}
