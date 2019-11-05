/**
 * 
 */
package com.lbw.common.service.rocketmq.consumer;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lbw.common.service.CommonServiceApplication;

/**
 * RocketMQ Consumer config
 * 
 * @author LiuBaoWen
 *
 */
@Configuration
public class RocketMQConsumerConfig {

	private static final Logger log = LoggerFactory.getLogger(CommonServiceApplication.class);

	@Value("${mq.rocketmq.producer-group}")
	private String producerGroup;

	@Value("${mq.rocketmq.namesrv-addr}")
	private String namesrvAddr;

	/**
	 * consumer services bean
	 * 
	 * @author LiuBaoWen
	 * @throws Exception
	 */
	@Bean
	public void consumer() throws Exception {
		// Instantiate with specified consumer group name.
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(producerGroup);

		// Specify name server addresses.
		consumer.setNamesrvAddr(namesrvAddr);

		// Subscribe one more more topics to consume.
		consumer.subscribe("TopicTest", "*");
		// Register callback to execute on arrival of messages fetched from brokers.
		consumer.registerMessageListener(new MessageListenerConcurrently() {

			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				log.info("{} Receive New Messages: {}", Thread.currentThread().getName(), msgs);
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});

		// Launch the consumer instance.
		consumer.start();

		log.info("RocketMQ Consumer Started.");
	}

}
