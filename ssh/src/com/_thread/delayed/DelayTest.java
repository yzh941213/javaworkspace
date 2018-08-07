package com._thread.delayed;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DelayTest {

    public static void main(String[] args) {

        ItemQueueThread ith = ItemQueueThread.getInstance();
        ith.init();
        Random r = new Random();

        for (int i=0;i<5;i++){
            int a = r.nextInt(20);
            System.out.println("等待时间："+a);
            DataDemo demo = new DataDemo();
            ith.put(a,demo,TimeUnit.SECONDS);
        }


        /**
         * 队列就是将线程塞到一个list中
         * 建立一个守护线程，不断去查询队列出队的线程任务，
         * 拿到一个执行一个，拿不到就进行等待
         *
         * queue 队列
         * executorService 线程池维护任务的开启
         */


    }
}
