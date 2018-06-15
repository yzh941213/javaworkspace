package com.jdk1_8;

import com.entity.Test;

import java.sql.Timestamp;
import java.time.Clock;
import java.util.*;

public class TestFunction {

    public static void main(String[] args) {

        List<String>list = Arrays.asList("颜智慧","huyishu","菜穗子");
        Collections.sort(list,String::compareTo);

        list.forEach(System.out::println);
        System.out.println(Optional.ofNullable(list).isPresent());

        List<Test>testList = new ArrayList<>();
        Test test = new Test();
        test.setName("颜智慧");
        test.setCreatetime(new Timestamp(System.currentTimeMillis()));
        test.setId(1);
        Test test1 = new Test();
        test1.setName("菜穗子");
        test1.setCreatetime(new Timestamp(System.currentTimeMillis()));
        test1.setId(2);
        testList.add(test);
        testList.add(test1);

        testList.forEach(t ->
            System.out.println(t.getName()+"===="+t.getCreatetime()+"==="+t.getId())
        );


       // Collections.sort(list,(a,b)-> b.compareTo(a));


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        },1000);


        new Thread(()->{

        }).start();


        Clock clock = Clock.systemDefaultZone();
        clock.millis();


    }

}
