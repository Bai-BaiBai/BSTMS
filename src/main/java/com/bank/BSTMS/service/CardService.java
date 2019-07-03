package com.bank.BSTMS.service;

import com.bank.BSTMS.pojo.CardInfo;

/**
 * @ClassName: CardService
 * @Description: 银行卡相关操作的接口
 * 				 1.查询某张卡的所有具体信息：密码、所属人身份证、卡类型、余额
 * 				 2.存取款操作
 * @author BaiZehong
 * @date 2019年6月25日
 * @since JDK 1.8
 */
public interface CardService {

	/**
	 * 查询cardId所对应的具体信息
	 * @Title: selectByCardId
	 * @Description: 
	 * @param cardId
	 * @return
	 */
	CardInfo selectByCardId(Long cardId);
	
	/**
	 * 存取款操作
	 * @Title: updateMoney
	 * @Description: 存取款操作
	 * @param state
	 * @param cardId
	 * @param money
	 * @param tradeLocation
	 * @return
	 */
	int updateMoney(int state, Long cardId, double money, String tradeLocation);
	
	/**
	 * 修改密码，成功返回cardInfo信息，失败返回null
	 * @Title: updatePassword
	 * @Description: 修改密码，成功返回cardInfo信息，失败返回null
	 * @param cardId
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	CardInfo updatePassword(Long cardId, int oldPassword, int newPassword);
	
	/**
	 * 转账操作，内部调用BillService的增添账单方法，转账和账单新增均成功返回当前CardInfo信息；失败返回Null
	 * @Title: transfer
	 * @Description: 转账操作，内部调用BillService的增添账单方法，转账和账单新增均成功返回当前CardInfo信息；失败返回Null
	 * @param cardIdFrom
	 * @param cardIdTo
	 * @param money
	 * @param tradeLocation
	 * @return
	 */
	CardInfo transfer(Long cardIdFrom, Long cardIdTo, double money, String tradeLocation);
	
	/**
	 * 新建账户信息(银行卡)
	 * @Title: createAccount
	 * @Description: 新建账户信息
	 * @param idNumbers
	 * @param password
	 * @param cardType
	 * @return
	 */
	CardInfo createAccount(String idNumbers, int password, int cardType);
}
