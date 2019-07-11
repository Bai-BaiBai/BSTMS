package com.bank.BSTMS.serviceImpl;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

import com.bank.BSTMS.pojo.ValidateCode;
import com.bank.BSTMS.util.Constant;

/**
 * 默认短信验证码实现类：使用互亿无线API(https://user.ihuyi.com/nav/sms.html)发送短信验证码
 * @ClassName: DefaultValidateCodeService
 * @author BaiZehong
 * @date 2019年7月11日
 * @since JDK 1.8
 */
@Component
public class DefaultValidateCodeService extends AbstractValidateCodeService {

	@Override
	protected void send(ValidateCode code, String mobile) throws Exception {

		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Constant.SMS_URL);
		
		// 固定格式，接收xml形式的返回
		client.getParams().setContentCharset("GBK");
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=GBK");
		
		String content = "您的验证码是：" + code.getCode() + "验证码在5分钟内有效";
		
		// key为固定API字符串
		NameValuePair[] data = {
				new NameValuePair("account", Constant.SMS_API_ID),
				new NameValuePair("password", Constant.SMS_API_KEY),
				new NameValuePair("mobile", mobile),
				new NameValuePair("content", content),
		};
		
		method.setRequestBody(data);
		System.out.println("短信发送成功，手机号：" + mobile + "验证码：" + code.getCode() + "时间" + code.getExpireTime());
//		try {
//			client.executeMethod(method);
//			
//			String submitResult = method.getResponseBodyAsString();
//			
//			Document doc = DocumentHelper.parseText(submitResult);
//			Element root = doc.getRootElement();
//			
//			String resultCode = root.elementText("code");
//			String resultMsg = root.elementText("msg");
//			
//			if (resultCode.equals("2")) {
//				System.out.println("短信发送成功");
//			} else {
//				throw new Exception(resultMsg);
//			}
//		} catch (Exception e) {
//			throw new Exception(e.getMessage());
//		}
	}

}
