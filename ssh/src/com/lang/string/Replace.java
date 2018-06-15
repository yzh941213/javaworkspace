package com.lang.string;

public class Replace {

    public static void main(String[] args) {
        String source = "yzhyzhyzh123";
        char oldChar = 'z';
        char newChar = 'h';

        System.out.println(source.replace(oldChar,newChar));

        System.out.println(replace(source,oldChar,newChar));
    }

    static String replace(String source,char oldChar,char newChar){
        char[]chars = source.toCharArray();
        int i = -1;
        char[]buf = new char[chars.length];
        while (++i<chars.length){
            buf[i] = chars[i] == oldChar ? newChar : chars[i];
        }
        return new String(buf);
    }
}
