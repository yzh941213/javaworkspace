package com._8421;

public class _8421_2 {

    public static void main(String[] args) {


        int a = 5;
        int b = 6;

        /**
         * a 101
         * b 110
         * 一 011
         * 011 | 011
         * 101 | 110
         * 二 110 101
         * 101  110
         * 011  011
         */

        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a);
        System.out.println(b);
        //System.out.println(a);
    }
}
