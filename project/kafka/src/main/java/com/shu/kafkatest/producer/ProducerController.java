package com.shu.kafkatest.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author liujq
 * @version 1.0.0
 * @description
 * @date 2020/9/11 17:13
 */
@RestController
public class ProducerController {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @RequestMapping(value="message/send" , method= RequestMethod.POST,produces = { "application/json" })
    @Transactional
    public String send(@RequestBody String message) {
/*        Producer<String, Object> producer = null;
        kafkaTemplate.executeInTransaction((new KafkaOperations.OperationsCallback(){
            @Override
            public Object doInOperations(KafkaOperations kafkaOperations) {
                kafkaTemplate.send("topicTEST", message); //使用kafka模板发送信息
                return null;
            }
        }));*/
        kafkaTemplate.send("topicTEST", message); //使用kafka模板发送信息
//        testTemplateSend();
        return "success";
    }

    public void testTemplateSend() {
        //1 发送带有时间戳的消息
        kafkaTemplate.send("topicTEST", 0, System.currentTimeMillis(), String.valueOf(0), "send message with timestamp"+new Date());
/*        //2 使用ProducerRecord发送消息
        ProducerRecord record = new ProducerRecord("topicTEST", "use ProducerRecord to send message");
        kafkaTemplate.send(record);

        //3 使用Spring框架Message类发送消息
        Map map = new HashMap();
        map.put(KafkaHeaders.TOPIC, "topicTEST");
        map.put(KafkaHeaders.PARTITION_ID, 0);
        map.put(KafkaHeaders.MESSAGE_KEY, String.valueOf(0));
        GenericMessage message = new GenericMessage("use Message to send message",new MessageHeaders(map));
        kafkaTemplate.send(message);*/
    }
}
