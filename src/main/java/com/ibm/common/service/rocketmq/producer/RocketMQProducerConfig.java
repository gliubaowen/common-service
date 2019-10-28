/**
 * 
 */
package com.ibm.common.service.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibm.common.service.CommonServiceApplication;

/**
 * @author LiuBaoWen
 *
 */
@Configuration
public class RocketMQProducerConfig {

	private static final Logger log = LoggerFactory.getLogger(CommonServiceApplication.class);

	@Value("${mq.rocketmq.producer-group}")
	private String producerGroup;

	@Value("${mq.rocketmq.namesrv-addr}")
	private String namesrvAddr;

	@Value("${mq.rocketmq.retry}")
	private int retry;

	@Bean
	public DefaultMQProducer producer() throws Exception {
		// Instantiate with a producer group name.
		DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
		// Specify name server addresses.
		producer.setNamesrvAddr(namesrvAddr);
		// Launch the instance.
		producer.start();
		producer.setRetryTimesWhenSendAsyncFailed(retry);
		log.info("RocketMQ SyncMQProducer Started.");
		return producer;
	}

}
