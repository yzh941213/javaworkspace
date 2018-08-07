package com.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class WhileTest {

    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = new Date();
        String d = df.format(date);

        System.out.println(d);
    }




    public void test(int count){
        System.out.println("开始"+count);
        if (count<10){
            //new Thread(()->test(count)).start();
        }

    }
}
