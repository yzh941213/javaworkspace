package com.aishidai.app.model.dto;

import java.io.Serializable;

/**
 * Created by 蝈蝈 on 2016/9/19.
 */
public class SubordinateDTO implements Serializable{


    private static final long serialVersionUID = 3867175557313351722L;
    private int userId;
    private String uname;
    private String unike;
    private int sex;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUnike() {
        return unike;
    }

    public void setUnike(String unike) {
        this.unike = unike;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
