package com.zhezhuo.model.entity;

import java.util.Date;

public class HqCommission {
    private String id;

    private Integer hqCommission;

    private Integer distributorCommission;

    private String distributorName;

    private Long distributorId;

    private Long createId;

    private String createName;

    private Date created;

    private Date updated;

    private Integer deleteIs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getHqCommission() {
        return hqCommission;
    }

    public void setHqCommission(Integer hqCommission) {
        this.hqCommission = hqCommission;
    }

    public Integer getDistributorCommission() {
        return distributorCommission;
    }

    public void setDistributorCommission(Integer distributorCommission) {
        this.distributorCommission = distributorCommission;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName == null ? null : distributorName.trim();
    }

    public Long getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
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

    public Integer getDeleteIs() {
        return deleteIs;
    }

    public void setDeleteIs(Integer deleteIs) {
        this.deleteIs = deleteIs;
    }
}