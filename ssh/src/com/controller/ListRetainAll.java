package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListRetainAll {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        list1.add(1);
        list2.add(2);
        list2.add(5);
        list2.add(6);
        list2.add(1);
        list1.retainAll(list2);
        System.out.print(list1);






    }
}
