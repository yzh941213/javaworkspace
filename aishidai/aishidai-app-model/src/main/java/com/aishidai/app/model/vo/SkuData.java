package com.aishidai.app.model.vo;

import com.aishidai.app.model.dto.SkuDetailDTO;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

public class SkuData {
    private List<SkuDetailDTO> skuDetailList;



    private String data;

    public List<SkuDetailDTO> getSkuDetailList() {
        return skuDetailList;
    }

    public void setSkuDetailList(List<SkuDetailDTO> skuDetailList) {
        this.skuDetailList = skuDetailList;
    }

    public String getData() {


        return data;
    }

    public void setData(String data) {

        skuDetailList= (List<SkuDetailDTO>) JSONArray.parse(data);
        this.data = data;
    }
}
