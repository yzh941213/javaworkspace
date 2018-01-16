package com.aishidai.app.model.pojo;

public class AppPanelDO {
    private Long panelId;

    private String panelCode;

    private String panelName;

    private String sorting;

    private String jumpPage;

    private String imgUrl;

    private Integer isShow;

    private Integer isDelete;

    public Long getPanelId() {
        return panelId;
    }

    public void setPanelId(Long panelId) {
        this.panelId = panelId;
    }

    public String getPanelCode() {
        return panelCode;
    }

    public void setPanelCode(String panelCode) {
        this.panelCode = panelCode == null ? null : panelCode.trim();
    }

    public String getPanelName() {
        return panelName;
    }

    public void setPanelName(String panelName) {
        this.panelName = panelName == null ? null : panelName.trim();
    }

    public String getSorting() {
        return sorting;
    }

    public void setSorting(String sorting) {
        this.sorting = sorting == null ? null : sorting.trim();
    }

    public String getJumpPage() {
        return jumpPage;
    }

    public void setJumpPage(String jumpPage) {
        this.jumpPage = jumpPage == null ? null : jumpPage.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}