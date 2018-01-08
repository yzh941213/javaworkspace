package com.aishidai.app.model.pojo;

import java.util.Date;

public class AppVersionDO {
    private Integer id;

    private String downloadUrl;

    private String versionNum;

    private String describe;

    private String type;

    private Date created;

    private Date updated;

    private Byte update;

    private Byte forceUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl == null ? null : downloadUrl.trim();
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum == null ? null : versionNum.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Byte getUpdate() {
        return update;
    }

    public void setUpdate(Byte update) {
        this.update = update;
    }

    public Byte getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(Byte forceUpdate) {
        this.forceUpdate = forceUpdate;
    }
}