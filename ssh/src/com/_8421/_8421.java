package com._8421;

public class _8421 {

    public static void main(String[] args) {

        /*
         * 1001
         * 1010
         * 1000
         */
        System.out.println(9&10);

            /*
                1001
                1010
                0011
             */
        System.out.println(9^10);
            /*
             * 1001
             * 1010
               1011
             */
        System.out.println(9|10);

        /*
         * 1001
         * 10
         */
        System.out.println(9>>2);

        /*
         * 1001
         * 100100
         */
        System.out.println(9<<2);
        //System.out.println(true^true);
        // System.out.println(false&true);
        // System.out.println(false|true);
        // int _17 = 17;
        //10 10000
        //10


        /*
         * 10010
         * 100
         * 无符号左移
         */
        System.out.println(18>>>2);


    }
}

/**
 * 10进制转2进制
 * 逢2进一
 * 1 ->1
 * 2 ->10
 * 3 ->11
 * 4 ->100
 * 5 ->101
 * 6 ->110
 * 7 ->111
 * 8 ->1000
 * 9->1001
 * 10->1010
 * 11->1011
 * 12->1100
 * 13->1101
 * 14->1110
 * 15->1111
 * 16->10000
 * 16 =>2^5
 */
