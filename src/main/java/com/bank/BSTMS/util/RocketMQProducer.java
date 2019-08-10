package com.bank.BSTMS.util;

import java.util.UUID;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * RocketMQ生产者
 * @ClassName: RocketMQProducer
 * @Description: RocketMQ生产者
 * @author BaiZehong
 * @date 2019年8月9日
 * @since JDK 1.8
 */
public class RocketMQProducer {
	
	/**
	 * producer
	 */
	private DefaultMQProducer producer;
	
	/**
	 * 
	 * 创建一个新的实例 RocketMQProducer 并 start
	 *
	 * @throws MQClientException
	 */
	private RocketMQProducer() throws MQClientException {
		
		this.producer = new DefaultMQProducer(Constant.PRODUCER_GROUP_NAME);
		this.producer.setNamesrvAddr(Constant.ROCKETMQ_ADDR);
		this.producer.setRetryTimesWhenSendFailed(0);
		this.producer.setSendMsgTimeout(10000);
		this.producer.start();
	}
	
	/**
	 * 对外开放接口，发送Message
	 * @Title: sendMessage
	 * @Description: 对外开放接口，发送Message
	 * @param message
	 * @return
	 * @throws MQClientException
	 * @throws RemotingException
	 * @throws MQBrokerException
	 * @throws InterruptedException
	 */
	public SendResult sendMessage(Message message) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
		
		SendResult result = null;
		result = this.producer.send(message);
		
		return result;
	}
	
	public void start() {
		if (this.producer != null) {
			try {
				this.producer.start();
			} catch (MQClientException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		if (this.producer != null) {
			this.producer.shutdown();
		}
	}

	public static void main(String[] args) {
		try {
			RocketMQProducer producer = new RocketMQProducer();
			System.out.println("------------producer start --------");
			for (int i = 0; i < 5; i++) {
				Message message = new Message();
				message.setBody(("test_message " + i).getBytes() );
				message.setKeys(UUID.randomUUID().toString() + "$" + TimeUtil.getCurrentTime());
				message.setTopic(Constant.TOPIC);
				message.setTags(Constant.TAG);
				SendResult sendResult = producer.sendMessage(message);
				System.err.println(sendResult);
				
				Thread.sleep(3000);
			}
			producer.shutdown();
			System.out.println("------------producer shutdown --------");
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemotingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MQBrokerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
