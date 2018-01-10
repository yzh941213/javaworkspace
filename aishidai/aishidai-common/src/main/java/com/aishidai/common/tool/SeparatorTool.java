package com.aishidai.common.tool;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SeparatorTool {

    public static List idMinusSplit(String ids) {
        String[] arry= ids.split("-");
        List list=new ArrayList();
        for (String str:arry){
            if(StringUtils.isEmpty(str)){
                continue;
            }

            list.add(Integer.valueOf(str));
        }

        return list;
    }

    public static void main(String[] args) {
        idMinusSplit("-1-2-3-");
    }
}
