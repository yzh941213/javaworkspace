package com.zhezhuo.model.query;

import com.zhezhuo.model.Query;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class DeviceQuery extends Query {
	private Long distributorId;
	private String productNo;
	
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public Long getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}
	
}
