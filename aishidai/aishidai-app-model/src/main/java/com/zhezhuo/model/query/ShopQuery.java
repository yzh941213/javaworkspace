package com.zhezhuo.model.query;

import com.zhezhuo.model.Query;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class ShopQuery extends Query {
	
	private Long distributorId;//经销商的ID
	private String shopsName;
	private Long makerId;
	
	public String getShopsName() {
		return shopsName;
	}

	public void setShopsName(String shopsName) {
		this.shopsName = shopsName;
	}

	public Long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}

	public Long getMakerId() {
		return makerId;
	}

	public void setMakerId(Long makerId) {
		this.makerId = makerId;
	}

}
