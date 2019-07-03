package com.bank.BSTMS.pojo;

/**
 * 前端接收Long型丢失精度，所以使用该类包装一下，将Long的数据转成String
 * @ClassName: CardInfoExtendToString
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author BaiZehong
 * @date 2019年7月2日
 * @since JDK 1.8
 */
public class CardInfoExtendToString extends CardInfo{

	/**
	 * 序列化
	 * @Fields serialVersionUID :序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 父类中cardId转String
	 */
	private String cardIdString;
	/**
	 * 父类对象
	 */
	private CardInfo cardInfo;

	public CardInfoExtendToString(CardInfo cardInfo) {
		
		this.cardInfo = cardInfo;
		this.cardIdString = cardInfo.getCardId().toString();
	}

	public String getCardIdString() {
		return cardIdString;
	}

	public void setCardIdString(String cardIdString) {
		this.cardIdString = cardIdString;
	}

	public CardInfo getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(CardInfo cardInfo) {
		this.cardInfo = cardInfo;
	}
	
}
