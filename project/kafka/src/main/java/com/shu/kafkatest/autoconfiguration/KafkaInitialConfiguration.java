package com.shu.kafkatest.autoconfiguration;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liujq
 * @version 1.0.0
 * @description
 * @date 2020/9/15 15:24
 */
@Configuration
public class KafkaInitialConfiguration {

    //创建TopicName为topic.quick.initial的Topic并设置分区数为8以及副本数为1
    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("topic.quick.initial",8, (short) 1 );
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> props = new HashMap<>();
        //配置Kafka实例的连接地址
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.228.128:9090");
        KafkaAdmin admin = new KafkaAdmin(props);
        return admin;
    }

    @Bean
    public AdminClient adminClient() {
        return AdminClient.create(kafkaAdmin().getConfigurationProperties());
    }

    /*@Bean
    public ProducerFactory<String, Object> producerFactory() {
        DefaultKafkaProducerFactory<String, Object> factory = new DefaultKafkaProducerFactory<>(producerConfigs());
        factory.transactionCapable();
        factory.setTransactionIdPrefix("tran-");
        return factory;
    }

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.228.128:9090");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<String, Object>(producerFactory());
    }

    @Bean
    public KafkaTransactionManager transactionManager(ProducerFactory producerFactory) {
        KafkaTransactionManager manager = new KafkaTransactionManager(producerFactory);
        return manager;
    }
*/
}