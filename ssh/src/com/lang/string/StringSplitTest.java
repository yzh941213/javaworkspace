package com.lang.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSplitTest {

    private final char value[];

    public static void main(String[] args) {
        String split = "2017,2019,2098,300,3,";
        String regex = "201";
        System.out.println(split.toCharArray());
        System.out.println(Arrays.asList(split.split(regex)));
        //StringSplitTest.stringTest(split,regex);
        //System.out.println(regex.charAt(0)-'0');

        System.out.println(Math.min(0,1));
    }

    StringSplitTest(){
        this.value = "".toCharArray();
    }

   private static void stringTest(String split,String regex){
       char[]chars = split.toCharArray();
       List<String>stringList = new ArrayList<>();
       int begin = 0;
       int end = 0;
       for (int i=0;i<chars.length;i++){
           if (regex.length() == 1){
               if (chars[i] == regex.toCharArray()[0]){
                   end = i;//0
                   if (begin>0)begin++;
                   stringList.add(split.substring(begin,end));
                   begin = end;
               }
           }else {

           }

       }

      System.out.println(split.indexOf(0,0));

       /*while ((end = split.indexOf(split,end))!=-1){

       }*/

       System.out.println(stringList);
    }
}
