package com.web.entity;

import java.util.Date;

public class Comments {
	private Integer commentsAutoid;
	private String title;
	private String content;
	private Date date;
	private Integer personAutoid;
	private Person person;
	
	private int count;
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Integer getCommentsAutoid() {
		return commentsAutoid;
	}
	public void setCommentsAutoid(Integer commentsAutoid) {
		this.commentsAutoid = commentsAutoid;
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
