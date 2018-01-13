package com.aishidai.app.model.custom.po;

import java.io.Serializable;
import java.util.List;

import com.aishidai.app.model.pojo.ResourceDOCustom;
import com.aishidai.app.model.query.Query;


public class Result<T> implements Serializable {
	
    private static final long serialVersionUID = -8226191985294697912L;
    
    private boolean success;//查询是否成功
    private String errorInfo;////错误信息
    private String errorCode;//错误状态码
    private String successInfo;//返回的描述
    
    
    private List<ResourceDOCustom> obj;
    
	public List<ResourceDOCustom> getObj() {
		return obj;
	}

	public void setObj(List<ResourceDOCustom> obj) {
		this.obj = obj;
	}

	private T result;
    private Query query;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public String getSuccessInfo() {
        return successInfo;
    }

    public void setSuccessInfo(String successInfo) {
        this.successInfo = successInfo;
    }
}
