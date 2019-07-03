package com.bank.BSTMS.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.BSTMS.exception.BillInsertException;
import com.bank.BSTMS.mapper.CardInfoMapper;
import com.bank.BSTMS.mapper.ExchangeRateInfoMapper;
import com.bank.BSTMS.pojo.CardInfo;
import com.bank.BSTMS.pojo.ExchangeRateInfo;
import com.bank.BSTMS.service.BillService;
import com.bank.BSTMS.service.ExchangeService;
import com.bank.BSTMS.util.Constant;

/**
 * ExchangeService实现类
 * @ClassName: ExchangeServiceImpl
 * @Description: ExchangeService实现类
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
@Service
public class ExchangeServiceImpl implements ExchangeService {
	
	@Autowired
	private CardInfoMapper cardInfoMapper;
	
	@Autowired
	private ExchangeRateInfoMapper exchangeRateInfoMapper;
	
	@Autowired
	private BillService billService;

	/**
	 * 交易货币服务
	 */
	@Override
	public CardInfo exchangeCurrency(Long cardId, int exchangeRateId, double money, String tradeLocation) {
		
		CardInfo cardInfo = cardInfoMapper.selectByPrimaryKey(cardId);
		ExchangeRateInfo currencyInfo = exchangeRateInfoMapper.selectByPrimaryKey(exchangeRateId);
		
		double availableBalance = cardInfo.getAccountBalance() + cardInfo.getOverdraftBalance();
		double neededMoney = currencyInfo.getExchangeRate() * money;
		
		// 如果账户可用金额大于兑换金额
		if (availableBalance >= neededMoney) {
			List<Long> cardIds = new ArrayList<Long>();
			cardIds.add(cardId);
			
			try {
				// 增添账单记录，操作类型为取款
				billService.insertBillInfo(cardIds, Constant.GET_MONEY_STATE, tradeLocation, neededMoney);
				
				cardInfo.setAccountBalance(cardInfo.getAccountBalance() - neededMoney);
				cardInfoMapper.updateByPrimaryKeySelective(cardInfo);
			} catch (BillInsertException e) {
				return null;
			}
			return cardInfo;
		}
		
		// 账户余额不足
		else {
			return null;
		}
		
	}

}
