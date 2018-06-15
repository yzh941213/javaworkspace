package com.lang._byte;

public class Byte {

    public static void main(String[] args) {

         final java.lang.Byte cache[] = new java.lang.Byte[-(-128) + 127 + 1];

        // System.out.println(cache.length);

        //System.out.println(java.lang.Byte.valueOf((byte) 1));

        //radix 表示几进制 最小为2进制
        //System.out.println(java.lang.Byte.parseByte("12",0));

        System.out.println(java.lang.Byte.toUnsignedInt((byte)22));

        java.lang.Byte b = 1;

        System.out.println(b&0xff);



    }
}
