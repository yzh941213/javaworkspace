package com.aishidai.app.model.vo;

import com.aishidai.app.model.pojo.ItemSkuDO;

import java.util.List;

public class ItemSkuVO extends ItemSkuDO {
    private List<SkuSize> sizeList;

    public List<SkuSize> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<SkuSize> sizeList) {
        this.sizeList = sizeList;
    }
}
