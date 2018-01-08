package com.zhezhuo.model;

import com.zhezhuo.model.util.CacheKeyBuilder;

import java.io.Serializable;

/**
 * Created by Shaka on 15/5/5.
 */
public class MaterialQuery extends Query implements Serializable, CacheKeyBuilder{
    private static final long serialVersionUID = -6100190041745156036L;

    private int categoryId;
    private int stdCategoryId;
    private MaterialSrcEnum materialSrcEnum;

    public void setMaterialSrcEnum(MaterialSrcEnum materialSrcEnum) {
        this.materialSrcEnum = materialSrcEnum;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStdCategoryId() {
        return stdCategoryId;
    }

    public void setStdCategoryId(int stdCategoryId) {
        this.stdCategoryId = stdCategoryId;
    }

    @Override
    public String toString() {
        return "MaterialQuery{" +
                "categoryId=" + categoryId +
                "stdCategoryId=" + stdCategoryId +
                ", userId=" + super.getUserId() +
                ", materialSrcEnum=" + materialSrcEnum +
                ", currentPage=" + getCurrentPage() +
                ", pageSize=" + getPageSize() +
                ", sortField=" + getSortField() +
                ", order=" + getOrder() +
                '}';
    }

    @Override
    public String getCacheKey(Object o) {
        return getCacheKey();
    }

    @Override
    public String getCacheKey() {
        return this.getClass().toString().replaceAll("class ","") + "_" + String.valueOf(this.toString().hashCode());
    }
}
