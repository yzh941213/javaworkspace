package com.aishidai.common.json;

import com.github.pagehelper.PageInfo;

import java.security.PublicKey;
import java.util.List;

public class JsonResult{

    public  Object aaData;
    public Long iTotalDisplayRecords;
    public Long   iTotalRecords;
    public int  pageSize=10;
    public String    sEcho;
    public String message;
    public Boolean success;

    public static JsonResult buildSuccess(Object aaData){
        JsonResult jsonResult=new JsonResult();
        jsonResult.aaData=aaData;

        jsonResult.success=true;
        return jsonResult;
    }
    public  static JsonResult buildPaging(List list){
        JsonResult jsonResult=new JsonResult();
        PageInfo p=new PageInfo(list);
        jsonResult.aaData=p.getList();
        jsonResult.iTotalRecords=p.getTotal();
        jsonResult.iTotalDisplayRecords=p.getTotal();
        return jsonResult;
    }

    public static JsonResult buidException(Throwable throwable){
        JsonResult jsonResult=new JsonResult();
        jsonResult.success=false;
        jsonResult.message=throwable.getMessage();
        return jsonResult;
    }

    public Object getAaData() {
        return aaData;
    }

    public void setAaData(Object aaData) {
        this.aaData = aaData;
    }

    public Long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public Long getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(Long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getsEcho() {
        return sEcho;
    }

    public void setsEcho(String sEcho) {
        this.sEcho = sEcho;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
