package com.bank.BSTMS.service;

import com.bank.BSTMS.pojo.CardInfo;

/**
 * 交易货币服务
 * @ClassName: ExchangeService
 * @Description:交易货币服务
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
public interface ExchangeService {

	/**
	 * 交易货币接口
	 * @Title: exchangeCurrency
	 * @Description: 交易货币接口
	 * @param cardId
	 * @param exchangeRateId
	 * @param money
	 * @param tradeLocation
	 * @return
	 */
	CardInfo exchangeCurrency(Long cardId, int exchangeRateId, double money, String tradeLocation);
}
