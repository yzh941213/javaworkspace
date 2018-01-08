package com.zhezhuo.model;

import java.io.Serializable;

/**
 * Created by Shaka on 15/4/5.
 */
public enum SocialUserEnum implements Serializable {
    Phone(0, "注册"),
    WeiXin(1, "微信"),
    QQ(2, "QQ"),
    WeiBo(3, "新浪微博");

    private int id;
    private String name;

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    SocialUserEnum(int id, String name){
        this.id = id;
        this.name = name;
    }
}
