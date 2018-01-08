package com.zhezhuo.model.query;

import com.zhezhuo.model.Query;

public class ServicesOrdersQuery extends Query {

	private Long buyerUserId;
	
	public long getBuyerUserId() {
		return buyerUserId;
	}
	public void setBuyerUserId(Long buyerUserId) {
		this.buyerUserId = buyerUserId;
	}
 	
}
