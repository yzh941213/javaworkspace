package com.web.entity;

public class Soft {
	private Integer softAutoid;
	private Integer clsID;
	private String content;
	private String softName;
	private String fileName;
	private int fileSize;
	private String filePath;
	
	public Integer getSoftAutoid() {
		return softAutoid;
	}
	public void setSoftAutoid(Integer softAutoid) {
		this.softAutoid = softAutoid;
	}
	public Integer getClsID() {
		return clsID;
	}
	public void setClsID(Integer clsID) {
		this.clsID = clsID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSoftName() {
		return softName;
	}
	public void setSoftName(String softName) {
		this.softName = softName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
