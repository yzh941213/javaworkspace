package com.web.entity;

public class Flowcls {
	private Integer fcAutoid;
	private String fcName;
	private String content;
	private String image;
	private int sortIndex;
	private String url;
	public Integer getFcAutoid() {
		return fcAutoid;
	}
	public void setFcAutoid(Integer fcAutoid) {
		this.fcAutoid = fcAutoid;
	}
	public String getFcName() {
		return fcName;
	}
	public void setFcName(String fcName) {
		this.fcName = fcName;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getSortIndex() {
		return sortIndex;
	}
	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
