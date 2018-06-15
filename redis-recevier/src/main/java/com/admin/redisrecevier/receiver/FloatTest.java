package com.admin.redisrecevier.receiver;

import java.math.BigDecimal;

public class FloatTest {

    public static void main(String[] args) {

        int i = 10;
        BigDecimal bigDecimal = new BigDecimal(i+"");
        Float f = 13.83f;
        System.out.println(f-i);
    }
}
