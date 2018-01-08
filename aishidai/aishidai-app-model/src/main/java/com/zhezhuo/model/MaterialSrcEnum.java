package com.zhezhuo.model;

/**
 * Created by Shaka on 15/5/5.
 */
public enum MaterialSrcEnum {
    UserfFavorite(0, "用户收藏"),
    Shop(1, "商城"),
    Undified(99, "未定义");

    private int id;
    private String name;
    MaterialSrcEnum(int id, String name){
        this.id = id;
        this.name = name;
    }
}
