package com.web.entity;

public class Ware {
	private Integer wareAutoid;
	private String wareName;
	private String fileName;
	private String filePath;
	private String type;
	
	public Integer getWareAutoid() {
		return wareAutoid;
	}
	public void setWareAutoid(Integer wareAutoid) {
		this.wareAutoid = wareAutoid;
	}
	public String getWareName() {
		return wareName;
	}
	public void setWareName(String wareName) {
		this.wareName = wareName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
