package com.jdk1_8;

import com.dao.TestDao;
import com.entity.Test;
import com.service.RedisService;
import com.service.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestStream {

    private long t, u;
    @Autowired
    private TestDao testDao;

    private Long test(BinaryOperator<Long> b) {
        return b.apply(t, u);
    }

    public static void main(String[] args) {

      /*  TestStream t = new TestStream();
        t.t = 1; t.u=2;
        BinaryOperator<Long>b = (x,y)->x+y;
        System.out.println(t.test(b));*/

        MathOperation mathOperation = (x,y)->{return x+y;};//这是MathOperation接口的实现
        System.out.println(mathOperation.add(3,2));//这是具体的实现调用

        GreetingService greetingService = (message)->System.out.println("hello"+message);
        //GreetingService greetingService2 = (a,b)->System.out.println(a+b);



        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        }).start();

        Function function = new Function() {
            @Override
            public Object apply(Object o) {
                return null;
            }
        };

        function = (o)->null;

        DoubleFunction doubleFunction =
                (d)->{
            Double dou = new Double(222);
            System.out.println(dou);
            return dou;
        };
        doubleFunction.apply(22);

        Supplier supplier = ()->{
            return null;
        };

        Map<String,String> map = new HashMap<>();
        map.put("name","yanzhihui");
        map.put("value","huyishu");
        Set<String> list = new HashSet<>();
        map.forEach(
                (str,obj)-> {
                    list.add(obj);
                }
        );
        list.forEach(System.out::println);

        new Thread(()->{
            try {
                Thread.sleep(10000);
                System.out.println("颜智慧");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }).start();


        RedisService redisService = new RedisServiceImpl();
        redisService.say("颜智慧");

    }

    interface MathOperation {

        int add(int a, int b);

    }

    interface GreetingService {
        void sayMessage(String message);
    }



}
