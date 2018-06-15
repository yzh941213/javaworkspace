package com.web.entity;

public class Item {
	private Integer itemAutoid;
	private Integer flowAutoid;
	private String itemName;
	private int subID;
	private String content;
	private String keywords;
	private String imageUrl;
	private int sortIndex;
	private String flowName;
	private String del;
	private Flow flow;

	public Integer getItemAutoid() {
		return itemAutoid;
	}

	public void setItemAutoid(Integer itemAutoid) {
		this.itemAutoid = itemAutoid;
	}

	public Integer getFlowAutoid() {
		return flowAutoid;
	}

	public void setFlowAutoid(Integer flowAutoid) {
		this.flowAutoid = flowAutoid;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getSubID() {
		return subID;
	}

	public void setSubID(int subID) {
		this.subID = subID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public Flow getFlow() {
		return flow;
	}

	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	
}
