package com.zhezhuo.model;

import java.io.Serializable;

/**
 * Created by Shaka on 15/4/1.
 */
public enum FigureEnum implements Serializable{
    XiongWei(0, "胸围"),
    YaoWei(1, "腰围"),
    TunWei(2, "臀围");

    private int id;
    private String name;
    FigureEnum(int id, String name){
        this.id = id;
        this.name = name;
    }
}


