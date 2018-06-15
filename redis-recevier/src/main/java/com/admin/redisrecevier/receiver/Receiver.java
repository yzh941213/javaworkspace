package com.admin.redisrecevier.receiver;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;


/**
 * 消息接收者
 */
public class Receiver {

    private static final Logger log = LoggerFactory.getLogger(Receiver.class);


    private CountDownLatch downLatch;

    @Autowired
    public Receiver(CountDownLatch downLatch){
        this.downLatch = downLatch;
    }

    public void receiveMessage(String message) {
        log.info("Received <" + message + ">");
        downLatch.countDown();
    }
}
