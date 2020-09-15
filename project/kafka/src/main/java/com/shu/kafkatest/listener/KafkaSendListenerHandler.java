package com.shu.kafkatest.listener;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.ProducerListener;

/**
 * @author liujq
 * @version 1.0.0
 * @description
 * @date 2020/9/15 17:03
 */

@Configuration
public class KafkaSendListenerHandler implements ProducerListener {
    private static final Logger log = LoggerFactory.getLogger(KafkaSendListenerHandler.class);


    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        log.info("监听消息发送成功...");
        String key = (String)producerRecord.key();
        log.info("key : " + key);
        log.info("Message send success : " + producerRecord.toString());
        log.info("-----------------------------");
    }

    @Override
    public void onError(ProducerRecord producerRecord, Exception exception) {

    }
}
