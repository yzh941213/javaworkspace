package com.lang.string;

public class IndexOf {


    public static void main(String[] args) {
        String source = "yzh12123";
        String target = "123";
        System.out.println(source.indexOf(target));


        System.out.println(indexOf(source,0,target,0,0));


        System.out.println(indexOf2(source.toCharArray(),
                0,source.length(),target.toCharArray(),0,target.length(),0));

        int i = 0;
        int j = 0;
        j++;
        ++i;

        System.out.println("i:"+i+";j:"+j);

        System.out.println(source.contains("yzh"));
    }


    /**
     * 获取数组下标
     * @param source 资源值
     * @param sourceOffset 资源值起始下标
     * @param target 输出值
     * @param targetOffset 输出值起始下标
     * @param formIndex 从资源值第几位开始比较
     */
    private static int indexOf(String source,int sourceOffset,String target,int targetOffset,int formIndex){
        if (target.length()>source.length()-sourceOffset
                || formIndex>source.length()-target.length()){
            return -1;
        }
        if (sourceOffset<0 || targetOffset<0){
            return -1;
        }
        char[]source_ = source.toCharArray();
        char[]target_ = target.toCharArray();

        for (int i=sourceOffset;i<source_.length;i++){
            int start = targetOffset;
            ok:
            while (start<target_.length){
                if (source_[i] == target_[start]){
                    int j = i;
                    for (;i<source_.length && start<target_.length;){
                        if (source_[i] != target_[start]){
                            break ok;
                        }
                        i++;
                        start++;
                    }
                    return j;
                }
                start++;
            }
        }

        return -1;
    }


    static int indexOf(char[]source,int sourceOffset,int sourceCount,
                       char[]target,int targetOffset,int targetCount,
                       int formIndex){
        if (formIndex>=sourceCount){
            return (targetCount == 0 ? sourceCount:-1);
        }
        if (formIndex<0){
            formIndex = 0;
        }
        if (targetCount == 0){
            return formIndex;
        }

        char first = target[targetOffset];
        //    2 = 0+5-3
        int max = sourceOffset+(sourceCount-targetCount);
        //i = 0+1
        for (int i = sourceOffset+formIndex;i<=max;i++){
            if (source[i] != first){
                while (++i<=max && source[i] != first);//找到一个两个相等值
            }
            if (i<=max){
                int j = i+1;
                int end = j+targetCount-1;
                for (int k = targetOffset+1;j<end && source[j] == target[k];
                        j++,k++);
                if (j == end){
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }


    static int indexOf2(char[]source,int sourceOffset,int sourceCount,
                       char[]target,int targetOffset,int targetCount,
                       int formIndex){
        if (formIndex>sourceCount){
            return -1;
        }
        if (formIndex<0){
            formIndex = 0;
        }
        if (targetCount == 0){
            return formIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset+(sourceCount-targetCount);

        for (int i = formIndex+sourceOffset;i<=max;i++){
            if (source[i] != first){
                while (++i<=max && source[i] != first);
            }
            if (i<=max){
                int j = i+1;
                int end = j+targetCount-1;
                for (int k=targetOffset+1;j<end && source[j] == target[k];k++,j++);
                if (j == end) return i-targetOffset;
            }

        }
        return -1;
    }
}
