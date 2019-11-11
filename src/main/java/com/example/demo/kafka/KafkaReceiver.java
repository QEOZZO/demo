package com.example.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {"summer"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            try {
                Thread.sleep(2000);
                log.info("------------------消费的message =" + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
