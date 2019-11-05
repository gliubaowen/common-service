/**
 * 
 */
package com.lbw.common.service.shell.command;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.lbw.common.service.CommonServiceApplication;

/**
 * @author LiuBaoWen
 *
 */
@ShellComponent
public class RocketMQProducerCommands {

	private static final Logger log = LoggerFactory.getLogger(CommonServiceApplication.class);

	@Autowired
	private DefaultMQProducer producer;

	/**
	 * sendSingleMsg
	 * 
	 * @author LiuBaoWen
	 * @return
	 */
	@ShellMethod(value = "DefaultMQProducer sendMsg.", key = "sendMsg")
	public void sendMsg() throws Exception {
		Message msg = new Message("TopicTest" /* Topic */, "TagA" /* Tag */,
				("Hello RocketMQ " + 1).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
		);
		// Call send message to deliver message to one of brokers.
		SendResult sendResult = producer.send(msg);
		log.info("{}", sendResult);
	}

	/**
	 * syncSendMsg
	 * 
	 * @author LiuBaoWen
	 * @return
	 */
	@ShellMethod(value = "DefaultMQProducer syncSendMsg.", key = "syncSendMsg")
	public void syncSendMsg() throws Exception {
		for (int i = 0; i < 10; i++) {
			// Create a message instance, specifying topic, tag and message body.
			Message msg = new Message("TopicTest" /* Topic */, "TagA" /* Tag */,
					("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
			);
			// Call send message to deliver message to one of brokers.
			SendResult sendResult = producer.send(msg);
			log.info("{}", sendResult);
		}
	}

	/**
	 * asyncSendMsg
	 * 
	 * @author LiuBaoWen
	 * @return
	 */
	@ShellMethod(value = "DefaultMQProducer asyncSendMsg.", key = "asyncSendMsg")
	public void asyncSendMsg() throws Exception {
		for (int i = 0; i < 10; i++) {
			final int index = i;
			// Create a message instance, specifying topic, tag and message body.
			Message msg = new Message("TopicTest", "TagA", "OrderID188",
					"Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
			producer.send(msg, new SendCallback() {
				@Override
				public void onSuccess(SendResult sendResult) {
					log.info("{}  OK {}", index, sendResult.getMsgId());
				}

				@Override
				public void onException(Throwable e) {
					log.info("{}  Exception {}", index, e);
					log.error("msg:{}, err:{}", e.getMessage(), e.getStackTrace());
				}
			});
		}
	}

	/**
	 * onewaySendMsg
	 * 
	 * @author LiuBaoWen
	 * @return
	 */
	@ShellMethod(value = "DefaultMQProducer onewaySendMsg.", key = "onewaySendMsg")
	public void onewaySendMsg() throws Exception {
		for (int i = 0; i < 10; i++) {
			// Create a message instance, specifying topic, tag and message body.
			Message msg = new Message("TopicTest" /* Topic */, "TagA" /* Tag */,
					("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
			);
			// Call send message to deliver message to one of brokers.
			producer.sendOneway(msg);
		}
	}

}
