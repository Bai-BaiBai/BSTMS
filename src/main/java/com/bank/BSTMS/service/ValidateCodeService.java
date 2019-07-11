package com.bank.BSTMS.service;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * 验证码抽象接口
 * @ClassName: ValidateCodeService
 * @author BaiZehong
 * @date 2019年7月11日
 * @since JDK 1.8
 */
public interface ValidateCodeService {

	/**
	 * 创建校验码
	 * @Title: create
	 * @param request
	 * @throws Exception
	 */
	void create(HttpServletRequest request, String mobile) throws Exception;
	
	/**
	 * 校验验证码
	 * @Title: validate
	 * @param request
	 * @return
	 */
	boolean validate(HttpServletRequest request, String code);
}
