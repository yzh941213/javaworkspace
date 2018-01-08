package com.zhezhuo.model.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/10.
 */
public class SkuDetailDTO implements Serializable{


    private static final long serialVersionUID = 7141838917549441148L;
    private long colourId;
    private String colourName;
    private String image;
    private long itemId;

    private List<Size> sizeList;

    public long getColourId() {
        return colourId;
    }

    public void setColourId(long colourId) {
        this.colourId = colourId;
    }

    public String getColourName() {
        return colourName;
    }

    public void setColourName(String colourName) {
        this.colourName = colourName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Size> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<Size> sizeList) {
        this.sizeList = sizeList;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }
}
