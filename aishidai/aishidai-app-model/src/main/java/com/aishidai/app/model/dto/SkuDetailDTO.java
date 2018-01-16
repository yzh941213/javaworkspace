package com.aishidai.app.model.dto;

import com.aishidai.app.model.pojo.ItemSkuDO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/10.
 */
public class SkuDetailDTO extends ItemSkuDO implements Serializable{


    private static final long serialVersionUID = 7141838917549441148L;


    private Long colorId;
    private String colourName;
    private String image;


    private List<Size> sizeList;


    public Long getColorId() {
        return colorId;
    }


    public void setColorId(Long colorId) {
        this.colorId = colorId;
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


}
