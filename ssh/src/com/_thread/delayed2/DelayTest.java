package com._thread.delayed2;


import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DelayTest {

    public static void main(String[] args) {
        ItemQueueThread iqh = ItemQueueThread.getInstance();
        iqh.init();
        Random r = new Random();
        for (int i=0;i<5;i++){
            int a = r.nextInt(100);
            System.out.println("延时时间："+a);
            iqh.put(a,new DataDemo(),i+"");
        }
        iqh.remove("1");
    }
}
