package com.lang.string;

public class LastIndexOf {

    public static void main(String[] args) {
        String source = "yzh123";
        String target = "123";
        //System.out.println(source.lastIndexOf(target));

        //System.out.println(lastIndexOf(source.toCharArray(),target.toCharArray()));

       // System.out.println(source.lastIndexOf('1'));

        System.out.println(source.lastIndexOf(target));

    }


    static int lastIndexOf(char[] source,char target){
        int i = source.length-1;
        for (;i>=0;i--){
            if (source[i] == target)return i;
        }

        return -1;
    }

    static int lastIndexOf(char[] source,char[] target){
        char last = target[target.length-1];
        for (int i=source.length-1;i>=0;i--){
            if (source[i] != last){
                while (--i>=0 && source[i] != last);
            }
            if (i>=0){
                for (int k=target.length-1;k>=0;k--,i--){
                    if (target[k] != source[i]){
                        break;
                    }
                }
                return i+1;
            }
        }
        return -1;
    }


    static int lastIndexOf(char[] source,int sourceOffset,int sourceCount,
                           char[] target,int targetOffset,int targetCount,
                           int formIndex){
        int rightIndex = sourceCount - targetCount;
        if (formIndex<0){
            return -1;
        }
        /**
         *  char[] 123456
         *  char[] 123
         *  formIndex 4
         *  6-3 = 3
         *  if(4>3)4=3
         */
        //如果位移量大于两数组之间的差值
        if (formIndex>rightIndex){
            formIndex = rightIndex;
        }
        /* Empty string always matches. */
        if (targetCount == 0){
            return formIndex;
        }
        // targetOffset 只能小于等于0
        int strLastIndex = targetOffset + targetCount-1;
        char strLastChar  = target[strLastIndex];
        //min = 0 + 5-1 获取起始比较值
        int min = sourceOffset + targetCount-1;
        // i = 4 +2
        int i = min + formIndex;

        startSearchForLastChar:

        while (true){
            while (i>=min && source[i] != strLastChar ){
                i--;
            }
            //如果source的资源长度小于target长度,比都不用比了
            if (i<min){
                return -1;
            }
            int j = i - 1;
            int start = j - (targetCount - 1);
            int k = strLastIndex - 1;

            while (j>start){
                if (source[j--] != target[k--]){
                    i--;
                    continue startSearchForLastChar;
                }
            }
            return start - sourceOffset+1;
        }
    }
}
