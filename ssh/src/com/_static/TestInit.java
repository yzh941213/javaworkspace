package com._static;

public class TestInit {

    private static String str;


    static {
        str = "颜智慧";
    }


    public String getStr(){
        return str;
    }
}
