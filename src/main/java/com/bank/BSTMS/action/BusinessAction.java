package com.bank.BSTMS.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.BSTMS.pojo.BusinessInfo;
import com.bank.BSTMS.pojo.ExchangeRateInfo;
import com.bank.BSTMS.service.BusinessService;
import com.bank.BSTMS.util.ApiResponse;

/**
 * 处理查询理财产品、查询汇率请求
 * @ClassName: BusinessAction
 * @Description: 处理查询理财产品、查询汇率请求
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
@RestController
public class BusinessAction {
	
	@Autowired
	BusinessService businessService;
	
	/**
	 * 
	 * @Title: checkBusinessInfo
	 * @Description: 获取全部的理财产品信息
	 * @return
	 */
	@GetMapping("/businessInfo")
	public ApiResponse< List<BusinessInfo> > checkBusinessInfo(){
		
		ApiResponse< List<BusinessInfo> > response = new ApiResponse<List<BusinessInfo>>();
		
		// 查询全部理财产品信息
		List<BusinessInfo> businessInfos = businessService.checkBusinessInfos();
		response.setCode(ApiResponse.SUCCESS_CODE);
		response.setData(businessInfos);
		
		return response;
	}
	
	/**
	 * 
	 * @Title: checkExchangeRate
	 * @Description: 获取全部的汇率信息
	 * @return
	 */
	@GetMapping("/exchangeRate")
	public ApiResponse< List<ExchangeRateInfo> > checkExchangeRate(){
		
		ApiResponse< List<ExchangeRateInfo> > response = new ApiResponse<List<ExchangeRateInfo>>();
		
		// 查询全部汇率信息
		List<ExchangeRateInfo> exchangeRateInfos = businessService.checkExchangeRateInfos();
		response.setCode(ApiResponse.SUCCESS_CODE);
		response.setData(exchangeRateInfos);
		
		return response;
	}

}
