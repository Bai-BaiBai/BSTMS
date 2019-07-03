package com.bank.BSTMS.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.BSTMS.exception.BillInsertException;
import com.bank.BSTMS.mapper.BillInfoMapper;
import com.bank.BSTMS.pojo.BillInfo;
import com.bank.BSTMS.service.BillService;
import com.bank.BSTMS.util.Constant;
import com.bank.BSTMS.util.TimeUtil;

/**
 * BillService实现类
 * @ClassName: BillServiceImpl
 * @Description: BillService实现类
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillInfoMapper billInfoMapper;

	/**
	 * 
	 * @Title: insertBillInfo
	 * @Description: 账单增添记录方法， state标识是事务类型
	 * @param cardIds ： list[0]为事务发起方卡号(登录卡号)，list[1]为事务接受方。存取款只有发起方
	 * @param state
	 * @param tradeLocation
	 * @return 新建账单记录成功则返回该条记录，失败抛出异常
	 * @throws BillInsertException 
	 */
	@Override
	public BillInfo insertBillInfo(List<Long> cardIds, int state, String tradeLocation, double money) throws BillInsertException {
		
		BillInfo billInfo = new BillInfo();
		// 发起方
		billInfo.setCardIdFrom(cardIds.get(0));
		// 地点
		billInfo.setTradeLocation(tradeLocation);
		// 时间
		billInfo.setTradeTime(TimeUtil.getCurrentTime());
		// 金额
		billInfo.setTradeBalance(money);
		
		// 如果是转账操作
		if (state == Constant.TRANSFER_MONEY_STATE) {
			// 接受方
			billInfo.setCardIdTo(cardIds.get(1));
			// 事务类型：转账
			billInfo.setAffairType(Constant.AFFAIR_TYPE_TRANSFER);
		}
		// 如果是存取款操作
		else {
			// 取款
			if (state == Constant.GET_MONEY_STATE) {
				// 事务类型：取款
				billInfo.setAffairType(Constant.AFFAIR_TYPE_GET);
			}
			// 存款
			else if (state == Constant.SAVE_MONEY_STATE){
				// 事务类型：存款
				billInfo.setAffairType(Constant.AFFAIR_TYPE_SAVE);
			}
		}
		billInfoMapper.insertSelective(billInfo);
		
		// 判断是否成功
		if (billInfo.getBillId() != null) {
			// billId已经填充
			return billInfo;
		}
		else {
			throw new BillInsertException("账单添加失败");
		}
	}

}
