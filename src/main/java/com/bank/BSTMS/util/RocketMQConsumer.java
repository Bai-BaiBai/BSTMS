package com.bank.BSTMS.util;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;

/**
 * RocketMQ消费者
 * @ClassName: RocketMQConsumer
 * @Description: RocketMQ消费者
 * @author BaiZehong
 * @date 2019年8月9日
 * @since JDK 1.8
 */
public class RocketMQConsumer {

	private DefaultMQPushConsumer consumer;
	
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
				String topic = messageExt.getTopic();
				String tags = messageExt.getTags();
				String body = new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET);
				System.out.println("topic : " + topic + " tag : " + tags + " body: " + body);	
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
	
	public static void main(String[] args) {
		try {
			new RocketMQConsumer();
			System.out.println("------------consumer start --------");
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
