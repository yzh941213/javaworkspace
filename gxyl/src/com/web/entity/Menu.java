package com.web.entity;

public class Menu {
	private Integer menuAutoid;
	private String title;
	private String iconUrl;
	private String navigateUrl;
	private String webUrl;
	private Integer isWeb;
	private String model;
	private int parentID;
	private int sortIndex;
	
	public Integer getMenuAutoid() {
		return menuAutoid;
	}
	public void setMenuAutoid(Integer menuAutoid) {
		this.menuAutoid = menuAutoid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public String getNavigateUrl() {
		return navigateUrl;
	}
	public void setNavigateUrl(String navigateUrl) {
		this.navigateUrl = navigateUrl;
	}
	public String getWebUrl() {
		return webUrl;
	}
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	public Integer getIsWeb() {
		return isWeb;
	}
	public void setIsWeb(Integer isWeb) {
		this.isWeb = isWeb;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getParentID() {
		return parentID;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	public int getSortIndex() {
		return sortIndex;
	}
	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}
}
