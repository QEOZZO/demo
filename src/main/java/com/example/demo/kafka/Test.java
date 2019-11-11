package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * kafka测试
 */
@Controller
@RequestMapping("kafka")
public class Test {

    @Autowired
    KafkaSender kafkaSender;

    @GetMapping("/test")
    public void testKafka(){
        for (int i = 0; i < 30; i++) {
            //调用消息发送类中的消息发送方法
            kafkaSender.send();
        }
    }

}
