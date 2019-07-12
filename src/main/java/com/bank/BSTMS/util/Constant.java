package com.bank.BSTMS.util;

/**
 * 常量字段
 * @ClassName: Constant
 * @Description: 常量字段
 * @author BaiZehong
 * @date 2019年6月27日
 * @since JDK 1.8
 */
public interface Constant {
	
	/**
	 * 逻辑判断过程中所使用的状态码
	 */
	
	/**
	 * 短信发送接口URL
	 */
	public static final String SMS_URL = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	public static final String SMS_API_ID = "C86066574";
	public static final String SMS_API_KEY = "5ab817a10d08cfe8e82c7aaeafae9b94";
	public static final int VALIDATE_CODE_COUNT = 6;
	public static final int VALIDATE_CODE_EXPIRE_TIME = 300;
	String VALIDATE_CODE_ERROR = "验证码错误或已失效";
	
	/**
	 *  登录成功存在session里的银行卡号
	 */
	String SESSION_ATTRIBUTE_CARD_ID = "cardId";
	public static final String SESSION_VALIDATE_CODE_KEY = "validateCode";
	
	
	/**
	 * 存款动作标识
	 */
	public static final int SAVE_MONEY_STATE = 1;
	/**
	 * 取款动作标识
	 */
	public static final int GET_MONEY_STATE = 2;
	/**
	 * 转账动作标识
	 */
	public static final int TRANSFER_MONEY_STATE = 3;
	
	/**
	 * 存取款成功标识
	 */
	public static final int SAVE_GET_MONEY_SUCCESS = 1;
	/**
	 * 存款失败标识
	 */
	public static final int SAVE_MONEY_FAILURE = 2;
	/**
	 *  取款失败标识
	 */
	public static final int GET_MONEY_FAILURE = 3;
	
	/**
	 *  借记卡
	 */
	public static final int DEBIT_CARD = 1;
	/**
	 *  信用卡
	 */
	public static final int CREDIT_CARD = 2;
	
	/**
	 *  信用卡初始透支额度
	 */
	public static final double CREDIT_CARD_INIT_OVERDRAFT_LIMIT = 1000;

	/**
	 * 返回给前端页面的提示信息
	 */
	/**
	 *  银行卡号不存在提示
	 */
	String VERIFY_ACCOUNT_FAILURE_ERROR = "账户不存在";
	/**
	 * 登录失败错误提示
	 */
	String LOGIN_FAILURE_ERROR = "用户名或密码错误";
	/**
	 * 存款失败提示
	 */
	String SAVE_MONEY_FAILURE_ERROR = "存款失败";
	/**
	 * 取款失败提示
	 */
	String GET_MONEY_FAILURE_ERROR = "取款失败，余额不足";
	/**
	 *  查询余额失败提示
	 */
	String QUERY_MONEY_FAILURE_ERROR = "查询失败，请稍后重试";
	/**
	 * 更改密码失败提示
	 */
	String UPDATE_PASSWORD_FAILURE_ERROR = "密码错误，修改密码失败";
	/**
	 *  转账失败提示
	 */
	String TRANSFER_FAILURE_ERROR = "转账失败，余额不足";
	/**
	 *  验证用户信息失败提示
	 */
	String VERIFY_USER_FAILURE_ERROR = "无效的用户信息";
	/**
	 *  开户失败提示
	 */
	String CREATE_ACCOUNT_FAILURE_ERROR = "开户失败";
	/**
	 *  货币交易失败提示
	 */
	String EXCHANGE_CURRENCY_FAILURE_ERROR = "交易失败,余额不足";
	
	/**
	 * 数据库存储字段、添加账单记录时使用
	 */
	String AFFAIR_TYPE_SAVE = "存款";
	String AFFAIR_TYPE_GET = "取款";
	String AFFAIR_TYPE_TRANSFER = "转账";
}
