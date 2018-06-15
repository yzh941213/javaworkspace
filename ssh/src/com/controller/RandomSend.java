package com.controller;

import java.util.Random;

public class RandomSend {

    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());

        Random random = new Random(2);
        Random random1 = new Random(2);

        System.out.println(random.nextInt());
        System.out.println(random1.nextInt());

    }
}
