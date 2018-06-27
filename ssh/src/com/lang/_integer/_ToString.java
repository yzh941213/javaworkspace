package com.lang._integer;

public class _ToString {

    public static void main(String[] args) {

        //_max();
        System.out.println(Integer.toString(-123));


        //System.out.println(_stringSize(-800));

        System.out.println(_toString(-3256));

        System.out.println(Integer.toString(88,8));
    }


    private static void _max(){

        System.out.println(Integer.toUnsignedString(64,2));

        /*
         *   10
         * 1010
         * 1000
         */
        System.out.println(2^10);



        System.out.println(322*103>>>10);


        /**
         * 32 * 10 = 320
         * 30*10 + 2*10
         * 1010
         * 32 >>3
         * 32 >>1
         * 100000000
         * 1000000
         */
    }


    /**
     * 默认十进制
     */
    private static String _toString(int str){
        char first ='0';
        int len = str < 0 ? _stringSize(-str)+1 :_stringSize(str);
        if (str<0){
            first = '-';
            str = -str;
        }
        char[] buf = new char[len];
        int q;
        for (;;){
            q = (str*52429)>>>19;//q=str/10
            int result = str-(q*10);//result = str-(q*10)
            buf[--len] = digits[result];
            str = q;
            if (len == 0)break;
        }
        if (first != '0'){
            buf[0]=first;
        }
        return new String(buf);
    }


    private static int _stringSize(int str){
        int i = 0;
        while (sizeTable[i++]<=str){

        }
        return i;
    }

    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };

    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };
}
