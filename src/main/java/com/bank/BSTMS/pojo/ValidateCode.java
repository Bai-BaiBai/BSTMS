package com.bank.BSTMS.pojo;

import java.time.LocalDateTime;

/**
 * 验证码信息类：验证码、过期时间
 * @ClassName: ValidateCode
 * @author BaiZehong
 * @date 2019年7月11日
 * @since JDK 1.8
 */
public class ValidateCode {

	private String code;
	private LocalDateTime expireTime;
	
	public ValidateCode(String code, int seconds) {
		super();
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(seconds);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}
	
	
	
}
