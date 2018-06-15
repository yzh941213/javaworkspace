package com.lang._class;

import java.lang.reflect.AnnotatedType;

public class Class_ {

    public static void main(String[] args) {

        try {

            System.out.println("");
            Class<?>stringClass = Class.forName("java.lang.String");
            System.out.println(stringClass.toGenericString());

            //获取父类
            for (AnnotatedType type :stringClass.getAnnotatedInterfaces()){
                System.out.println(type.getType().getTypeName());
            }

            System.out.println(stringClass.getName());
            System.out.println();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}

