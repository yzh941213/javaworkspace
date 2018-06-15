package com.web.entity;

public class Attach {
	private Integer attachAutoid;
	private Integer newsAutoid;
	private String name;
	private String fileName;
	private String filePath;
	private int fileSize;
	
	private News news;

	public Integer getAttachAutoid() {
		return attachAutoid;
	}

	public void setAttachAutoid(Integer attachAutoid) {
		this.attachAutoid = attachAutoid;
	}

	public Integer getNewsAutoid() {
		return newsAutoid;
	}

	public void setNewsAutoid(Integer newsAutoid) {
		this.newsAutoid = newsAutoid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
}
