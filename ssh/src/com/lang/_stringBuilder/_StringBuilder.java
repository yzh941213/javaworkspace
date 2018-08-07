package com.lang._stringBuilder;

public class _StringBuilder {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append(123);

        System.out.println(sb.codePointAt(0));

        char[]source = new char[]{'1','2','3','4'};
        char[]target = new char[4];
        System.arraycopy(source,0,target,0,3);

        System.out.println(target);
    }





}
