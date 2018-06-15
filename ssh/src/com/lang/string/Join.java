package com.lang.string;

import java.util.Objects;
import java.util.StringJoiner;

public class Join {

    public static void main(String[] args) {

        System.out.println(join("-","yzh","123","yzh"));
    }

    static String join(String join,String...elements){
        Objects.requireNonNull(join);
        Objects.requireNonNull(elements);

        StringJoiner joiner = new StringJoiner(join);
        for (String str:elements){
            joiner.add(str);
        }
        return joiner.toString();
    }
}
