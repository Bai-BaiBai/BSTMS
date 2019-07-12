package com.bank.BSTMS.serviceImpl;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.bank.BSTMS.pojo.CardInfo;
import com.bank.BSTMS.pojo.UserInfo;
import com.bank.BSTMS.pojo.ValidateCode;
import com.bank.BSTMS.service.CardService;
import com.bank.BSTMS.service.UserService;
import com.bank.BSTMS.service.ValidateCodeService;
import com.bank.BSTMS.util.Constant;
import com.bank.BSTMS.util.ValidateCodeGenerator;

/**
 * 抽象验证码服务类：实现了验证码服务接口
 * 其中save方法是写死的，验证码生成器可以通过setter方法设置
 *send方法需要根据具体第三方接口来实现
 * @ClassName: AbstractValidateCodeService
 * @author BaiZehong
 * @date 2019年7月11日
 * @since JDK 1.8
 */
public abstract class AbstractValidateCodeService implements ValidateCodeService {

	/**
	 *  验证码生成器
	 */
	@Autowired
	private ValidateCodeGenerator validateCodeGenerator;
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private UserService userService;
	
	@Override
	public void create(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		Long cardId = (Long)session.getAttribute(Constant.SESSION_ATTRIBUTE_CARD_ID);
		CardInfo cardInfo = cardService.selectByCardId(cardId);
		UserInfo userInfo = userService.selectByIdNumbers(cardInfo.getIdNumbers());
		String mobile = userInfo.getPhone();
		
		ValidateCode code = validateCodeGenerator.generate();
		save(code, request);
		send(code, mobile);
	}
	
	/**
	 * 将验证码保存到Session中，以供验证
	 * @Title: save
	 * @param code
	 * @param request
	 */
	private void save(ValidateCode code, HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute(Constant.SESSION_VALIDATE_CODE_KEY, code);
	}
	
	/**
	 * 发送短信验证码
	 * @Title: send
	 * @param code
	 */
	protected abstract void send(ValidateCode code, String mobile) throws Exception;

	/**
	 * 对用户填写的短信验证码进行校验
	 */
	@Override
	public boolean validate(HttpServletRequest request, String code) {

		HttpSession session = request.getSession();
		ValidateCode validateCode = (ValidateCode)session.getAttribute(Constant.SESSION_VALIDATE_CODE_KEY);
		
		System.out.println("发送的验证码：" + validateCode.getCode() + "收到的验证码：" + code);
		
		// 如果验证码不一致，验证失败
		if (!code.equals(validateCode.getCode())) {
			session.removeAttribute(Constant.SESSION_VALIDATE_CODE_KEY);
			return false;
		}
		// 如果验证码超时，验证失败
		if (LocalDateTime.now().isAfter(validateCode.getExpireTime())) {
			session.removeAttribute(Constant.SESSION_VALIDATE_CODE_KEY);
			return false;
		}
		
		return true;
	}

	public ValidateCodeGenerator getValidateCodeGenerator() {
		return validateCodeGenerator;
	}

	public void setValidateCodeGenerator(ValidateCodeGenerator validateCodeGenerator) {
		this.validateCodeGenerator = validateCodeGenerator;
	}
	
}
