package com.bank.BSTMS.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 处理跨域请求问题，在每个请求的response头中添加允许跨域的Methods、允许跨域的域、允许使用证书验证
 * @ClassName: CrossAllowInterceptor
 * @Description: 处理跨域请求问题，在每个请求的response头中添加允许跨域的Methods、允许跨域的域、允许使用证书验证
 * @author BaiZehong
 * @date 2019年7月2日
 * @since JDK 1.8
 */
@Component
public class CrossAllowInterceptor implements HandlerInterceptor {

	/**
	 * response头没有被添加上
	 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		response.setHeader("Access-Control-Allow-Methods", "POST, GET,PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		response.setHeader("Access-Control-Allow-Credentials", "true");
	}
	*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.setHeader("Access-Control-Allow-Methods", "POST, GET,PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
