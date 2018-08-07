package com.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyTest {

    public static void main(String[] args) {

        System.out.println(33.0/100);
        System.out.println((0.333*1000)%1);
        /**
         * 3 100
         * 100-3
         *
         */
        BigDecimal bigDecimal = new BigDecimal(2);
        BigDecimal bigDecimal2 = new BigDecimal(3);
        System.out.println(bigDecimal.divide(bigDecimal2,2,RoundingMode.HALF_UP));


        Double d = 2.3363;

        System.out.println(new BigDecimal(d).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());



        System.out.println();
    }




    private static String test(int price){
        if (price<=0){
            return "0";
        }else if (price%100 == 0){
            return String.valueOf(price/100);
        }else {
            /**
             * 1 获取int的长度
             * 2 price小于100的时候 为price增加0.
             * 3 price%10==0 0. price/10 else 0.price
             * 4 当price大于100时
             */
        }

        return "";
    }
}
