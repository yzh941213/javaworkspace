package com.service;


import com.entity.Test;

import java.util.List;

public interface RedisService {

    /**
     * 获取所有list的集合
     * @return
     */
    List<Test> listTest();

    void add();

    /**
     * jdk1.8提供在接口能实现一个默认方法
     * 关键字 default
     * @param hello
     */
    default void say(String hello){
        System.out.println(hello);
    }

    default int edit(int id){
        return id;
    }
}
