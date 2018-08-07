package com.lang._float;

import sun.misc.FloatingDecimal;

import java.math.BigDecimal;

public class _Float {

    public static void main(String[] args) {

        //Float.toHexString(1.22f);


       System.out.println(Float.toString(1.22f));

       System.out.println(test());
    }


    private static int test(){
        BigDecimal bigDecimal = new BigDecimal(Float.toString(0.2f));
        BigDecimal bigDecimal1 = new BigDecimal("100");
        return bigDecimal.multiply(bigDecimal1).intValue();
    }
}
