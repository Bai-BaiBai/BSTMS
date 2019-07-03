package com.bank.BSTMS.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bank.BSTMS.interceptor.CrossAllowInterceptor;

/**
 * 将拦截器增加到MVC中
 * @ClassName: WebConfig
 * @Description: 将拦截器增加到MVC中
 * @author BaiZehong
 * @date 2019年7月2日
 * @since JDK 1.8
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private CrossAllowInterceptor crossAllowInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(crossAllowInterceptor);
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
}
