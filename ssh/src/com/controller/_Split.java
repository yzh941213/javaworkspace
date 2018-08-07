package com.controller;

import com.alibaba.fastjson.JSON;

import java.util.Map;

public class _Split {

    public static void main(String[] args) {
       String str = "{\"country\":\"China\",\"gender\":1,\"province\":\"Shandong\",\"city\":\"Heze\",\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/lHmEUAG6nfibZLmSHZ4eib6w4b03kaUWcBnWytjAoaWzYfp4YWg7mN3VXMczyssZQliabibMicporEDKEqkicLNgC3qw/132\",\"nickName\":\"尘\",\"language\":\"zh_CN\"}";

        Map<String,Object>map = (Map<String, Object>) JSON.parse(str);


        System.out.println(map);
    }


    protected void test(){

    }


    private String name;

    public _Split(String name) {
        this.name = name;
    }
}
