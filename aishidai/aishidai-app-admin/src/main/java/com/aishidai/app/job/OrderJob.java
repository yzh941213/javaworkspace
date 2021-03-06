package com.aishidai.app.job;

import com.aishidai.app.service.OrderJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



/**
 * 扫描订单状态 30分钟 自动关闭 15自动收获  30天自动好评
 */
@Component
public class OrderJob {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    OrderJobService orderJobService;
    @Scheduled(cron = "0 0/1 * * * ?")
    public void statusCheck(){
        orderJobService.ordersStatusCanning();
        logger.info("==========每分钟1次=======");
    }
}
