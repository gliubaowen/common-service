/**
 * 
 */
package com.ibm.common.service.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiuBaoWen
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketMQConsumerTest {

//	private static final Logger log = LoggerFactory.getLogger(CommonServiceApplication.class);

	@Test
	public void testSyncProducer() throws Exception {
		// Instantiate with a producer group name.
		DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
		// Specify name server addresses.
		producer.setNamesrvAddr("localhost:9876");
		// Launch the instance.
		producer.start();
		for (int i = 0; i < 100; i++) {
			// Create a message instance, specifying topic, tag and message body.
			Message msg = new Message("TopicTest" /* Topic */, "TagA" /* Tag */,
					("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
			);
			// Call send message to deliver message to one of brokers.
			SendResult sendResult = producer.send(msg);
			System.out.printf("%s%n", sendResult);
		}
		// Shut down once the producer instance is not longer in use.
		producer.shutdown();
	}

	@Test
	public void testAsyncProducer() throws Exception {
		// Instantiate with a producer group name.
		DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
		// Specify name server addresses.
		producer.setNamesrvAddr("localhost:9876");
		// Launch the instance.
		producer.start();
		producer.setRetryTimesWhenSendAsyncFailed(0);
		for (int i = 0; i < 100; i++) {
			final int index = i;
			// Create a message instance, specifying topic, tag and message body.
			Message msg = new Message("TopicTest", "TagA", "OrderID188",
					"Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
			producer.send(msg, new SendCallback() {
				@Override
				public void onSuccess(SendResult sendResult) {
					System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
				}

				@Override
				public void onException(Throwable e) {
					System.out.printf("%-10d Exception %s %n", index, e);
					e.printStackTrace();
				}
			});
		}
		// Shut down once the producer instance is not longer in use.
		producer.shutdown();
	}

	@Test
	public void testOnewayProducer() throws Exception {

		// Instantiate with a producer group name.
		DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
		// Specify name server addresses.
		producer.setNamesrvAddr("localhost:9876");
		// Launch the instance.
		producer.start();
		for (int i = 0; i < 100; i++) {
			// Create a message instance, specifying topic, tag and message body.
			Message msg = new Message("TopicTest" /* Topic */, "TagA" /* Tag */,
					("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
			);
			// Call send message to deliver message to one of brokers.
			producer.sendOneway(msg);

		}
		// Shut down once the producer instance is not longer in use.
		producer.shutdown();
	}

}
