package com.aishidai.app.model.pojo;

import java.util.Date;

public class HqCommissionDO {
    private Long id;

    private Integer hqCommission;

    private Integer distributorCommission;

    private String distributorName;

    private Long distributorId;

    private Long createId;

    private String createName;

    private Date created;

    private Date updated;

    private Integer isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}