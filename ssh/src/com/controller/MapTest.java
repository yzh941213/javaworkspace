package com.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

    public static void main(String[] args) {


        Map<Double,String>map = new TreeMap<>();


        map.put(1.0,"颜智慧");
        map.put(3.0,"颜智慧");
        map.put(13.0,"颜智慧");
        map.put(18.0,"颜智慧");
        map.put(6.0,"颜智慧");
        map.put(4.0,"颜智慧");

        System.out.println(map);


        Float f1 = 2.4f;
        Float f2 = 2.2f;

        System.out.println(f1.compareTo(f2));

        Date date = new Date();
        try {
            Thread.sleep(100l);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        Date date1 = new Date();

        System.out.println(date1.compareTo(date));


    }
}
