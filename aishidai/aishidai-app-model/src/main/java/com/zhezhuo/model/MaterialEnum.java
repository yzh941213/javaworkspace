package com.zhezhuo.model;

import java.io.Serializable;

/**
 * Created by Shaka on 15/4/1.
 */
public enum  MaterialEnum implements Serializable {
    QunZi(0, "裙子"),
    LianYiQun(1, "连衣裙"),
    TXu(2, "T恤");

    private int id;
    private String name;
    MaterialEnum(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}



