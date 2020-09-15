package com.shu.kafkatest;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

@SpringBootTest
class KafkatestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private AdminClient adminClient;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void testCreateTopic() throws InterruptedException {
        NewTopic topic = new NewTopic("topic.quick.initial2", 1, (short) 1);
        adminClient.createTopics(Arrays.asList(topic));
        Thread.sleep(1000);
    }
    /**
     * 获得主题的信息
     */
    @Test
    public void testSelectTopicInfo() throws ExecutionException, InterruptedException {
        DescribeTopicsResult topicTest = adminClient.describeTopics(Arrays.asList("topic.quick.initial"));
        topicTest.all().get().forEach((k,v)->{
            System.out.println("k: "+k+" ,v: "+v.toString()+"\n");
        });
    }

    @Test
    public void testExecuteInTransaction() throws InterruptedException {
        kafkaTemplate.executeInTransaction(new KafkaOperations.OperationsCallback() {
            @Override
            public Object doInOperations(KafkaOperations kafkaOperations) {
                kafkaOperations.send("topicTEST", "test executeInTransaction");
                throw new RuntimeException("fail");
                //return true;
            }
        });
    }

    @Test
    @Transactional
    public void testTransactionalAnnotation() throws InterruptedException {
        kafkaTemplate.send("topicTEST", "test transactional annotation");
//        throw new RuntimeException("fail");
    }

}
