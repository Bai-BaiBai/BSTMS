package com.bank.BSTMS.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.bank.BSTMS.pojo.ValidateCode;

/**
 * 验证码生成器
 * @ClassName: ValidateCodeGenerator
 * @author BaiZehong
 * @date 2019年7月11日
 * @since JDK 1.8
 */
@Component
public class ValidateCodeGenerator {

	public ValidateCode generate() {
		
		String code = RandomStringUtils.randomNumeric(Constant.VALIDATE_CODE_COUNT);
		return new ValidateCode(code, Constant.VALIDATE_CODE_EXPIRE_TIME);
	}
}
