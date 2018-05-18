package com.aceios.bilibili.common.jms;

import com.aceios.bilibili.common.config.JmsConfirguration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component
public class JmsReceiver {
    
    @JmsListener(destination = JmsConfirguration.QUEUE_NAME)
    public void receiveByQueue(String message) {
        System.out.println("接收队列消息:" + message);
    }
    
    @JmsListener(destination = JmsConfirguration.TOPIC_NAME)
    public void receiveByTopic(String message) {
        System.out.println("接收主题消息:" + message);
    }
}