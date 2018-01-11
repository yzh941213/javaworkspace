package com.aishidai.app.model.pojo;

import java.util.List;


public class ResourceDOCustom extends ResourceDO{
    
	private List<ResourceDO> resourceDOList;

	private long role_res_id;

	private int isTrue;
	    
	public List<ResourceDO> getResourceDOList() {
		return resourceDOList;
	}

	public void setResourceDOList(List<ResourceDO> resourceDOList) {
		this.resourceDOList = resourceDOList;
	}

	public long getRole_res_id() {
		return role_res_id;
	}

	public void setRole_res_id(long role_res_id) {
		this.role_res_id = role_res_id;
	}

	public int getIsTrue() {
		return isTrue;
	}

	public void setIsTrue(int isTrue) {
		this.isTrue = isTrue;
	}
	
	
}