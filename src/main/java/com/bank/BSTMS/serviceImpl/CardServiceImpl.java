package com.bank.BSTMS.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.BSTMS.exception.BillInsertException;
import com.bank.BSTMS.mapper.CardInfoMapper;
import com.bank.BSTMS.pojo.BillInfo;
import com.bank.BSTMS.pojo.CardInfo;
import com.bank.BSTMS.service.BillService;
import com.bank.BSTMS.service.CardService;
import com.bank.BSTMS.util.Constant;
import com.bank.BSTMS.util.TimeUtil;

/**
 * 
 * @ClassName: CardServiceImpl
 * @Description: 银行卡相关操作服务的实现类
 * @author BaiZehong
 * @date 2019年6月25日
 * @since JDK 1.8
 */
@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardInfoMapper cardInfoMapper;
	
	@Autowired
	private BillService billService;

	/**
	 * 根据银行卡号查卡信息
	 */
	@Override
	public CardInfo selectByCardId(Long cardId) {
		
		return cardInfoMapper.selectByPrimaryKey(cardId);
	}

	/**
	 *存取款操作
	 */
	@Override
	public int updateMoney(int state, Long cardId, double money, String tradeLocation) {
		
		try {
			
			CardInfo cardInfo = selectByCardId(cardId);
			
			// 存款操作,根据state标识判断
			if (state == Constant.SAVE_MONEY_STATE) {
				cardInfo.setAccountBalance(cardInfo.getAccountBalance() + money);
			}
			// 取款操作
			else if (state == Constant.GET_MONEY_STATE) {
				
				// 如果取款金额 小等于 银行卡余额 - 透支额度
				if (money <= cardInfo.getAccountBalance() + cardInfo.getOverdraftBalance()) {
					cardInfo.setAccountBalance(cardInfo.getAccountBalance() - money);
				}
				// 否则取款失败，余额不足
				else {
					return Constant.GET_MONEY_FAILURE;
				}
			}
			
			// 账单表添加记录
			List<Long> cardIds = new ArrayList<Long>();
			cardIds.add(cardId);
			billService.insertBillInfo(cardIds, state, tradeLocation, money);
			
			// 更新账户内金额
			cardInfoMapper.updateByPrimaryKeySelective(cardInfo);
		} catch (Exception e) {
			return Constant.SAVE_MONEY_FAILURE;
		}
		
		return Constant.SAVE_GET_MONEY_SUCCESS;
	}

	/**
	 * 修改密码操作
	 */
	@Override
	public CardInfo updatePassword(Long cardId, int oldPassword, int newPassword) {

		CardInfo cardInfo = cardInfoMapper.selectByPrimaryKey(cardId);
		// 旧密码验证通过，更新密码
		if (oldPassword == cardInfo.getPassword()) {
			cardInfo.setPassword(newPassword);
			cardInfoMapper.updateByPrimaryKeySelective(cardInfo);
			return cardInfo;
		}
		else {
			return null;
		}
	}

	/**
	 * 转账操作
	 */
	@Override
	public CardInfo transfer(Long cardIdFrom, Long cardIdTo, double money, String tradeLocation) {
		
		CardInfo cardInfoFrom = cardInfoMapper.selectByPrimaryKey(cardIdFrom);
		
		// 如果转账金额大于余额
		if (money > cardInfoFrom.getAccountBalance() + cardInfoFrom.getOverdraftBalance()) {
			return null;
		}
		
		CardInfo cardInfoTo = cardInfoMapper.selectByPrimaryKey(cardIdTo);
		cardInfoFrom.setAccountBalance(cardInfoFrom.getAccountBalance() - money);
		cardInfoTo.setAccountBalance(cardInfoTo.getAccountBalance() + money);
		
		// 账单增添记录
		ArrayList<Long> cardIds = new ArrayList<Long>();
		cardIds.add(cardIdFrom);
		cardIds.add(cardIdTo);
		try {
			BillInfo insertedBillInfo = billService.insertBillInfo(cardIds, Constant.TRANSFER_MONEY_STATE, tradeLocation, money);
//			insertedBillInfo.getBillId(); 新增的账单id
		} catch (BillInsertException e) {
			return null;
		}
		
		// 账单添加完成后，更新双方银行卡余额信息 
		cardInfoMapper.updateByPrimaryKeySelective(cardInfoFrom);
		cardInfoMapper.updateByPrimaryKeySelective(cardInfoTo);
		
		return cardInfoFrom;
	}

	/**
	 * 开户服务
	 */
	@Override
	public CardInfo createAccount(String idNumbers, int password, int cardType) {
		
		CardInfo cardInfo = new CardInfo();
		cardInfo.setIdNumbers(idNumbers);
		cardInfo.setPassword(password);
		cardInfo.setCardType(cardType);
		cardInfo.setEndDate(TimeUtil.getCurrentTime());
		
		// 如果是信用卡，设置初始透支额度
		if (cardType == Constant.CREDIT_CARD) {
			cardInfo.setOverdraftBalance(Constant.CREDIT_CARD_INIT_OVERDRAFT_LIMIT);
		}
		// 如果是借记卡，透支额度使用数据库默认值：0
		
		cardInfoMapper.insertSelective(cardInfo);
		// 自增主键已填充在CardInfo对象中，数据库有默认值
		cardInfo = cardInfoMapper.selectByPrimaryKey(cardInfo.getCardId());
		
		return cardInfo;
	}
}
