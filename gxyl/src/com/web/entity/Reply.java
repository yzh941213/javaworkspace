package com.web.entity;

import java.util.Date;

public class Reply {
	private Integer replyAutoid;
	private Integer commentsAutoid;
	private String content;
	private Date date;
	private Integer personAutoid;
	
	private Comments comments;
	private Person person;
	
	public Integer getReplyAutoid() {
		return replyAutoid;
	}
	public void setReplyAutoid(Integer replyAutoid) {
		this.replyAutoid = replyAutoid;
	}
	public Integer getCommentsAutoid() {
		return commentsAutoid;
	}
	public void setCommentsAutoid(Integer commentsAutoid) {
		this.commentsAutoid = commentsAutoid;
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
	public Comments getComments() {
		return comments;
	}
	public void setComments(Comments comments) {
		this.comments = comments;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
