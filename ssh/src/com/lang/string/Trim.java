package com.lang.string;

public class Trim {

    public static void main(String[] args) {

        String source = "  2011448/r";

        //去除字符串两边的空格
        System.out.println(source.trim());

        //System.out.println(trim(source.toCharArray()));
    }


    static String trim(char[] source){
        int i = 0;
        int end = source.length;
        while (i<end && source[i] <= ' '){
            i++;
        }
        while ((i<end) && source[end-1] <= ' '){
            end--;
        }

        return (i>0 || end<source.length) ? new String(source).substring(i,end) : new String(source);
    }
}
