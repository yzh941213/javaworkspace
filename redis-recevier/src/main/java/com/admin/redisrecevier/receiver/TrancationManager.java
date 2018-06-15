package com.admin.redisrecevier.receiver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TrancationManager {


    private static String status = "";
    public static void main(String[] args) {

        String lock = "lock";
        TrancationManager trancationManager = new TrancationManager();
        new Thread(()->{
            for (int i=0;i<10;i++){
                trancationManager.print_a(i);
                System.out.println(status);
            }

        }).start();

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        ac.getBean(TrancationManager.class);
       /* new Thread(()->{
            for (int i=0;i<10;i++){
                trancationManager.print_b();
            }
        }).start();*/
    }



    private synchronized void print_a(int i){
        try {
            this.wait(1000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("a:"+i);
        //this.notify();
        status = "a"+i;
    }

    private synchronized void print_b(){
        this.notify();
        System.out.println("b:");
        try {
            this.wait();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
