package com.lang.string;

public class StringCompareToTest {

    public static void main(String[] args) {
        System.out.println(compareTo("Yzh123","yzh123"));

        //System.out.println("yzh123".compareTo("yzh12 3"));

        System.out.println(compare("Yzh123","yzh123"));

    }


    private static int compareTo(String value,String value2){
        int lim = Math.min(value.length(),value2.length());

        char v1[] = value.toCharArray();
        char v2[] = value2.toCharArray();
        int k = 0;
        while (k<lim){
           if (v1[k] != v2[k]){
            return v1[k] - v2[k];
           }
            k++;
        }
        return value.length()-value2.length();
    }


    private static int compare(String s1,String s2){
        int kim = Math.min(s1.length(),s2.length());
        int k = 0;
        while (k<kim){
            char[]c1 = s1.toCharArray();
            char[]c2 = s2.toCharArray();
            if (c1[k]!=c2[k]){
                char c1Up = Character.toUpperCase(c1[k]);
                char c2Up = Character.toUpperCase(c2[k]);
                if (c1Up != c2Up){
                    char c1Low = Character.toLowerCase(c1[k]);
                    char c2Low = Character.toLowerCase(c2[k]);
                    if (c1Low!=c2Low){
                        return c1Low-c2Low;
                    }
                }
            }
            k++;
        }

        return s1.length()-s2.length();
    }
}
