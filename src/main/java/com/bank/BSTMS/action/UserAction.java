package com.bank.BSTMS.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.BSTMS.pojo.CardInfo;
import com.bank.BSTMS.pojo.CardInfoExtendToString;
import com.bank.BSTMS.pojo.UserInfo;
import com.bank.BSTMS.service.CardService;
import com.bank.BSTMS.service.UserService;
import com.bank.BSTMS.service.ValidateCodeService;
import com.bank.BSTMS.util.ApiResponse;
import com.bank.BSTMS.util.Constant;

/**
 * @ClassName: UserAction
 * @Description: 和用户信息有关的请求：登录、验证姓名身份证电话、开户(增添新的银行卡信息)
 * @author BaiZehong
 * @date 2019年6月25日
 * @since JDK 1.8
 */
@RestController
public class UserAction {

	@Autowired
	private CardService cardService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ValidateCodeService validateCodeService;
	
	/**
	 * 
	 * @Title: login
	 * @Description: 处理登录请求.用户使用银行卡号和密码进行登录
	 * @param id
	 * @param password
	 * @return
	 */
	@PostMapping("/login")
	public ApiResponse<CardInfo> login(@RequestParam Long cardId, @RequestParam int password, HttpServletRequest request){
		
		ApiResponse<CardInfo> response = new ApiResponse<>();
		CardInfo cardInfo = cardService.selectByCardId(cardId);
		
		// 如果能根据cardId查询到银行卡信息并且密码一致，即通过登录验证
		if (cardInfo != null && password == cardInfo.getPassword()) {
			response.setCode(ApiResponse.SUCCESS_CODE);
			response.setData(cardInfo);

			HttpSession session = request.getSession();
			session.setAttribute(Constant.SESSION_ATTRIBUTE_CARD_ID, cardId);
		}
		else {
			response.setCode(ApiResponse.ERROR_CODE);
			response.setError(Constant.LOGIN_FAILURE_ERROR);
		}
		return response;
	}
	
	/**
	 * 
	 * @Title: verifyUser
	 * @Description: 验证姓名、身份证号、手机号
	 * @param idNumbers
	 * @param username
	 * @param phone
	 * @return
	 */
	@PostMapping("/verifyUser")
	public ApiResponse<UserInfo> verifyUser(@RequestParam String idNumbers, @RequestParam String username, @RequestParam String phone){
		
		ApiResponse<UserInfo> response = new ApiResponse<>();
		UserInfo userInfo = userService.verifyUser(idNumbers, username, phone);
		
		if (userInfo != null) {
			response.setCode(ApiResponse.SUCCESS_CODE);
			response.setData(userInfo);
		}
		else {
			response.setCode(ApiResponse.ERROR_CODE);
			response.setError(Constant.VERIFY_USER_FAILURE_ERROR);
		}
		return response;
	}
	
	/**
	 * 
	 * @Title: createAccount
	 * @Description: 处理开户请求：接受参数：已验证的身份证号、初始密码、卡类型；成功时返回新银行卡信息
	 * @param idNumbers
	 * @param password
	 * @param cardType
	 * @return
	 */
	@PostMapping("/createAccount")
	public ApiResponse<CardInfo> createAccount(@RequestParam String idNumbers, 
											   @RequestParam int password, 
											   @RequestParam int cardType 
											   ){
		
		ApiResponse<CardInfo> response = new ApiResponse<CardInfo>();
		CardInfo cardInfo = cardService.createAccount(idNumbers, password, cardType);
		
		if (cardInfo != null) {
			response.setCode(ApiResponse.SUCCESS_CODE);
			CardInfoExtendToString cardInfoExtend = new CardInfoExtendToString(cardInfo);
			response.setData(cardInfoExtend);
		}
		else {
			response.setCode(ApiResponse.ERROR_CODE);
			response.setError(Constant.CREATE_ACCOUNT_FAILURE_ERROR);
		}
		return response;
	}
	
	/**
	 * 处理退卡请求、销毁session
	 * @Title: logout
	 * @Description: 处理退卡请求、销毁session
	 * @param request
	 * @return
	 */
	@GetMapping("/logout")
	public ApiResponse<Object> logout(HttpServletRequest request){
		
		ApiResponse<Object> response = new ApiResponse<Object>();
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.setCode(ApiResponse.SUCCESS_CODE);
		return response;
	}
	
	/**
	 * 发送验证码请求，成功只返回ApiResponse.SuccessCode
	 * @Title: sendsms
	 * @param mobile
	 * @param request
	 * @return
	 */
	@GetMapping("/sendsms")
	public ApiResponse<Object> sendsms(HttpServletRequest request){
		
		ApiResponse<Object> response = new ApiResponse<Object>();
		response.setCode(ApiResponse.SUCCESS_CODE);
		
		try {
			validateCodeService.create(request);
		} catch (Exception e) {
			response.setCode(ApiResponse.ERROR_CODE);
			response.setError(e.getMessage());
		}
		
		return response;
	}
}
