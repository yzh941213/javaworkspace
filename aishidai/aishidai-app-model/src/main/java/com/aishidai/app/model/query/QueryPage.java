package com.aishidai.app.model.query;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class QueryPage {
	
    private String aoData;
    private Integer status;
    private Integer isDeleted;
    
    
    public String getAoData() {
        return aoData;
    }
    private Integer pageSize;
    private Integer stratRow;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStratRow() {
        return stratRow;
    }

    public void setStratRow(Integer stratRow) {
        this.stratRow = stratRow;
    }

    private String sEcho;

    public String getsEcho() {
        return sEcho;
    }

    public void setsEcho(String sEcho) {
        this.sEcho = sEcho;
    }

    public void setAoData(String aoData) {
        this.aoData = aoData;
        JSONArray jsonArray=JSONArray.parseArray(aoData);
        for (int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject=(JSONObject) jsonArray.get(i);
            System.out.println(jsonObject.get("name")+":"+jsonObject.get("value"));
            if(jsonObject.get("name").toString().endsWith("iDisplayStart")){
                stratRow=Integer.valueOf(jsonObject.get("value").toString());
            }
            if(jsonObject.get("name").toString().endsWith("iDisplayLength")){
                pageSize=Integer.valueOf(jsonObject.get("value").toString());
            }
            if(jsonObject.get("name").toString().endsWith("sEcho")){
                pageSize=Integer.valueOf(jsonObject.get("value").toString());
            }
        }
    }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
}
