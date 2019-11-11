package com.example.demo.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Properties props = new Properties();
		props.put("bootstrap.servers", "127.0.0.1:2181");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		org.apache.kafka.clients.producer.Producer<String, String> producer = new KafkaProducer<>(props);
		for (int i = 0; i < 5; i++) {
			//同步方式发送消息
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("topic-replica-zhuge2", 0, Integer.toString(i), Integer.toString(i));
			/*Future<RecordMetadata> result = producer.send(producerRecord);
			//等待消息发送成功的同步阻塞方法
			RecordMetadata metadata = result.get();
			System.out.println("同步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-"
			        + metadata.partition() + "|offset-" + metadata.offset());*/

			//异步方式发送消息
			producer.send(producerRecord, new Callback() {
				@Override
				public void onCompletion(RecordMetadata metadata, Exception exception) {
					if (exception != null) {
						System.err.println("发送消息失败：" + exception.getStackTrace());
						
					}
					if (metadata != null) {
						System.out.println("异步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-"
						        + metadata.partition() + "|offset-" + metadata.offset());
					}
				}
			});
			
			
			//送积分
			//fdfddfdasf
		}

		producer.close();
	}
}
