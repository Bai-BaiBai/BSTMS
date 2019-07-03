package com.bank.BSTMS.service;

import java.util.List;

import com.bank.BSTMS.exception.BillInsertException;
import com.bank.BSTMS.pojo.BillInfo;

/**
 * 账单相关服务
 * @ClassName: BillService
 * @Description: 账单相关服务
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
public interface BillService {

	/**
	 *  用于新建账单信息
	 * @Title: insertBillInfo
	 * @Description: 新建账单信息，参数为 银行卡号，事务类型，交易地点， 交易金额	
	 * @param cardIds ： cardIds[0]为交易发起方卡号，cardIds[1]为交易接收方卡号
	 * @param state ： 事务类型参照Constant
	 * @param tradeLocation
	 * @param money
	 * @return
	 * @throws BillInsertException
	 * 
	 *
	 */
	BillInfo insertBillInfo(List<Long> cardIds, int state, String tradeLocation, double money) throws BillInsertException;

}
