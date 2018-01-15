package com.aishidai.app.model.pojo;

public class AppPanelContentDO {
    private Long panelContentId;

    private String imgUrl;

    private String title;

    private String isH5;

    private String hrefPage;

    private String sorting;

    private Long panelId;

    private Integer contentType;

    public Long getPanelContentId() {
        return panelContentId;
    }

    public void setPanelContentId(Long panelContentId) {
        this.panelContentId = panelContentId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIsH5() {
        return isH5;
    }

    public void setIsH5(String isH5) {
        this.isH5 = isH5 == null ? null : isH5.trim();
    }

    public String getHrefPage() {
        return hrefPage;
    }

    public void setHrefPage(String hrefPage) {
        this.hrefPage = hrefPage == null ? null : hrefPage.trim();
    }

    public String getSorting() {
        return sorting;
    }

    public void setSorting(String sorting) {
        this.sorting = sorting == null ? null : sorting.trim();
    }

    public Long getPanelId() {
        return panelId;
    }

    public void setPanelId(Long panelId) {
        this.panelId = panelId;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }
}