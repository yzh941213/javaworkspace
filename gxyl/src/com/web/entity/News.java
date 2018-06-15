package com.web.entity;

import java.util.Date;

public class News {
	private Integer newsAutoid;
	private Integer newsClsAutoid;
	private String title;
	private String content;
	private String image;
	private int sortIndex;
	private Date date;
	private Integer personAutoid;
	private int showIndex;
	
	private String attachs;//只用来传值
	
	private NewsCls newsCls;
	private Person person;
	
	public Integer getNewsAutoid() {
		return newsAutoid;
	}
	public void setNewsAutoid(Integer newsAutoid) {
		this.newsAutoid = newsAutoid;
	}
	public Integer getNewsClsAutoid() {
		return newsClsAutoid;
	}
	public void setNewsClsAutoid(Integer newsClsAutoid) {
		this.newsClsAutoid = newsClsAutoid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getPersonAutoid() {
		return personAutoid;
	}
	public void setPersonAutoid(Integer personAutoid) {
		this.personAutoid = personAutoid;
	}
	public int getShowIndex() {
		return showIndex;
	}
	public void setShowIndex(int showIndex) {
		this.showIndex = showIndex;
	}
	public String getAttachs() {
		return attachs;
	}
	public void setAttachs(String attachs) {
		this.attachs = attachs;
	}
	public NewsCls getNewsCls() {
		return newsCls;
	}
	public void setNewsCls(NewsCls newsCls) {
		this.newsCls = newsCls;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
