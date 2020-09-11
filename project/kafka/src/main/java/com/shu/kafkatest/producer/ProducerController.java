package com.shu.kafkatest.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public String send(@RequestBody String message) {
        System.out.println(message);
        kafkaTemplate.send("topicTEST", message); //使用kafka模板发送信息
        return "success";
    }
}
