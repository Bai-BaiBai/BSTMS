package com.bank.BSTMS.service;

import java.util.List;

import com.bank.BSTMS.pojo.BusinessInfo;
import com.bank.BSTMS.pojo.ExchangeRateInfo;

/**
 * 理财产品、货币交易服务
 * @ClassName: BusinessService
 * @Description: 理财产品、货币交易服务
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
public interface BusinessService {

	/**
	 * 取出全部的理财产品信息
	 * @Title: checkBusinessInfos
	 * @Description: 查看全部的理财产品信息
	 * @return
	 *  
	 */
	List<BusinessInfo> checkBusinessInfos();
	
	/**
	 * 取出全部的汇率信息
	 * @Title: checkExchangeRateInfos
	 * @Description: 查看全部的汇率信息
	 * @return
	 * 
	 */
	List<ExchangeRateInfo> checkExchangeRateInfos();
}
