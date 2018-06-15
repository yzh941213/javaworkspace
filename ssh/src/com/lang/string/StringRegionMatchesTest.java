package com.lang.string;

public class StringRegionMatchesTest {

    public static void main(String[] args) {

        System.out.println("Yzh".regionMatches(0,"yzh",0,1));

        System.out.println(regionMatches("yzh123",0,"yzh123",0,3));

        System.out.println("1234".startsWith("23",2));

        while (true);

    }



    private static boolean regionMatches(String value,int toffSet,String other,int oofSet,int len){
        if (toffSet < 0 || oofSet< 0
                || toffSet>value.length()-len//这里的处理是为了防止下标越界
                || oofSet>other.length()-len){
            return false;
        }
        while (len-->0){
            if (value.toCharArray()[toffSet++]!=other.toCharArray()[oofSet++]){
                return false;
            }
        }
        return true;
    }



    private static boolean startsWith(String value,int toffset,String other){
        int k = 0;
        int pc = other.length();
        int to = toffset;
        if (toffset < 0 || to>value.length()-pc){//短路功能,如果长度都不相等,剩下的也不用比了
            return false;
        }
        while (--pc>=0){
            if (value.toCharArray()[toffset++] != other.toCharArray()[k++]){
                return false;
            }
        }

        return true;
    }
}
