package com.zhezhuo.model.entity;

import java.io.Serializable;

/**
 * Created by 蝈蝈 on 2016/11/22.
 */
public class RoleDO implements Serializable {


    private static final long serialVersionUID = 7023915038370512959L;
    private Long id;
    private String name;
    private Long createrId;
    private String description;
    private String created;
    private String updated;
    private String nick;
    private String feature;
    private int isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        if (name == null) {
            return  "";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    public String getDescription() {
        if (description == null) {
            return "";
        }
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
