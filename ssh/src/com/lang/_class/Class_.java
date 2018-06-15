package com.lang._class;

public class Class_ {

    public static void main(String[] args) {

        try {

            System.out.println(17&8);

           System.out.println(Class.forName("java.lang.String").toGenericString());
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
