package com.zhezhuo.model.query;

import com.zhezhuo.model.Query;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class CraftsmenQuery extends Query {
	
	private Long distributorId;
	private Long makerId;
	private Long shopsId;
	private Long otherShopsId;

	public Long getOtherShopsId() {
		return otherShopsId;
	}

	public void setOtherShopsId(Long otherShopsId) {
		this.otherShopsId = otherShopsId;
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

	public Long getShopsId() {
		return shopsId;
	}

	public void setShopsId(Long shopsId) {
		this.shopsId = shopsId;
	}

}
