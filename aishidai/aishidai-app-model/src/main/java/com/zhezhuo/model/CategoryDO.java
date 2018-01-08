package com.zhezhuo.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Shaka on 15/5/31.
 */
public class CategoryDO implements Serializable{
	
    private static final long serialVersionUID = -4862292977002502657L;
    private int id;
    private int parentId;
    private CategoryDO parent;
    private String name;
    private String alias;
    private String image;
    private String desc;
    private String categoryPath;
    private int flag;
    private int status;
    private List<CategoryDO> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public CategoryDO getParent() {
        return parent;
    }

    public void setParent(CategoryDO parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<CategoryDO> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryDO> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "CategoryDO{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", image='" + image + '\'' +
                ", desc='" + desc + '\'' +
                ", categoryPath='" + categoryPath + '\'' +
                ", flag=" + flag +
                ", status=" + status +
                '}';
    }
}
