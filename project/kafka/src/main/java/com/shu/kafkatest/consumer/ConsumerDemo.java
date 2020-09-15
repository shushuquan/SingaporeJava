package com.shu.kafkatest.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author liujq
 * @version 1.0.0
 * @description
 * @date 2020/9/11 17:16
 */
@Component
public class ConsumerDemo {
    @KafkaListener(topics = "topicTEST")
    public void listen (ConsumerRecord<?, ?> record){
        System.out.printf("topic is %s, offset is %d, timestamp is %s, value is %s \n", record.topic(), record.offset(), record.timestamp(),record.value());
    }
}
