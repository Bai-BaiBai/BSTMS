package com.bank.BSTMS.util;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;
import com.bank.BSTMS.pojo.ValidateCode;
import com.bank.BSTMS.serviceImpl.DefaultValidateCodeService;

/**
 * RocketMQ消费者
 * @ClassName: RocketMQConsumer
 * @Description: RocketMQ消费者
 * @author BaiZehong
 * @date 2019年8月9日
 * @since JDK 1.8
 */
@Component
public class RocketMQConsumer {

	private DefaultMQPushConsumer consumer;
	
	@Autowired
	private DefaultValidateCodeService codeService;
	
	private RocketMQConsumer() throws MQClientException {
		
		this.consumer = new DefaultMQPushConsumer(Constant.CONSUMER_GROUP_NAME);
		this.consumer.setNamesrvAddr(Constant.ROCKETMQ_ADDR);
		this.consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
		this.consumer.subscribe(Constant.TOPIC, Constant.TAG);
		this.consumer.registerMessageListener(new MessageListener());
		this.consumer.start();
	}
	
	/**
	 * 内部类，用于注册消息队列监听
	 * @ClassName: MessageListener
	 * @Description: 内部类，用于注册消息队列监听
	 * @author BaiZehong
	 * @date 2019年8月9日
	 * @since JDK 1.8
	 */
	class MessageListener implements MessageListenerConcurrently{

		@Override
		public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
			
			MessageExt messageExt = msgs.get(0); //发的是单条消息，所以只有一条
			
			try {
				
				String body = new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET);
				@SuppressWarnings("unchecked")
				Map<String, Object> map = FastJsonUtils.convertJSONToObject(body, Map.class);
				ValidateCode code = (ValidateCode) map.get("code");
				String mobile = (String) map.get("mobile");
				
				codeService.send(code, mobile);
				
			} catch (Exception e) {
				e.printStackTrace();
				int reconsumeTimes = messageExt.getReconsumeTimes();
				if (reconsumeTimes == 3) {
					// 记录日志、补偿
					return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				}
				return ConsumeConcurrentlyStatus.RECONSUME_LATER;
			}
			return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
		}
		
	}

	/*
	public static void main(String[] args) {
		try {
			new RocketMQConsumer();
			System.out.println("------------consumer start --------");
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}
