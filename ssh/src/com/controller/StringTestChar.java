package com.controller;

import java.util.Arrays;

public class StringTestChar {

    public static void main(String[] args) {

        String source = "200000050005";

        //char[]str = new char[]{'0','2'};
        //int i = str[1]-'0';
        //System.out.println(i);

        //System.out.println((1+"").toCharArray()[0]);
        //System.out.println(source(source.toCharArray(),source.length()));

        System.out.println(source.substring(8,12));
    }



    static String source(char[] source){
        if (source.length == 0){

        }

        return "";
    }


    /**
     * 0009=>0010
     * 0099=>0100
     * 0999=>1000
     * 9999=>10000
     * 9989=>9990
     *
     * 当前位为0,上一位进一
     *
     * 0009 99
     * 00 09 10
     */
    static String source(char[]source,int sourceCount){
        boolean isMax = false;
        for (char c:source){
            if (c != '9'){
                isMax = true;
                break;
            }
        }
        if (isMax){
            char[]target = new char[sourceCount];
            char last = source[sourceCount-1];
            if (last == '9'){
                StringBuilder str = new StringBuilder();
                int offset=sourceCount-1;
                for (int k = 0;offset>=0;offset--,k++){
                    if (source[offset]!='9'){
                        str.append(source[offset]);
                        break;
                    }else {
                        str.append(source[offset]);
                    }
                }
                Integer code = Integer.valueOf(str.reverse().toString())+1;
                char[]charCode = code.toString().toCharArray();

                int i=0;
                if (offset>-1){
                    for (;i<offset;i++){
                        target[i]=source[i];
                    }
                }
                for (int k=0;i<sourceCount&k<charCode.length;i++,k++){
                    target[i] = charCode[k];
                }
            }else {
                target = Arrays.copyOf(source,sourceCount);
                Integer r = source[sourceCount-1]-'0';
                target[sourceCount-1] = (++r).toString().toCharArray()[0];
            }
            return new String(target);
        }else {
            Integer code = Integer.valueOf(new String(source))+1;
            return code.toString();
        }
    }
}
