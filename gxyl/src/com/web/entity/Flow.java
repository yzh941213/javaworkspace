package com.web.entity;

import java.util.Date;

public class Flow {
	private Integer flowAutoid;
	private Integer fcAutoid;
	private String flowName;
	private String state; //已启用，已停用
	private String flowType;
	private String itemID;
	private String content;
	private String imageUrl;
	private String companyID;
	private String docName;
	private String docPath;
	private String fileName;
	private String filePath;
	private int fileSize;
	private int sortIndex;
	private Date date;
	private Integer personAutoid;
	private String del;
	
	private String items;
	
	private Flowcls flowcls;
	private Person person;
	
	public Integer getFlowAutoid() {
		return flowAutoid;
	}
	public void setFlowAutoid(Integer flowAutoid) {
		this.flowAutoid = flowAutoid;
	}
	public Integer getFcAutoid() {
		return fcAutoid;
	}
	public void setFcAutoid(Integer fcAutoid) {
		this.fcAutoid = fcAutoid;
	}
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFlowType() {
		return flowType;
	}
	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocPath() {
		return docPath;
	}
	public void setDocPath(String docPath) {
		this.docPath = docPath;
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
	public Flowcls getFlowcls() {
		return flowcls;
	}
	public void setFlowcls(Flowcls flowcls) {
		this.flowcls = flowcls;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
