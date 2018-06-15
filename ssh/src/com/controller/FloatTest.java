package com.controller;

import java.util.regex.Pattern;

public class FloatTest {

    public static void main(String[] args) {

        String partern = "[\\d]+\\.[\\d]";

        Float f = 200.0f;
        System.out.println(f%1==0);
        System.out.println(f.toString());
        System.out.println("200.1".matches(partern));

    }
}
