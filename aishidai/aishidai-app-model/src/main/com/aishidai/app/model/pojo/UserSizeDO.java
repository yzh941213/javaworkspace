package com.aishidai.app.model.pojo;

public class UserSizeDO {
    private Long sizeId;

    private Long userId;

    private String name;

    private String height;

    private String weight;

    private String waist;

    private String hip;

    private String bust;

    private String shoulder;

    private String thigh;

    private String neck;

    private String upperArm;

    private String lowerArm;

    private String feature;

    private Long created;

    private Long updated;

    private Byte isDeleted;

    private Byte isDefault;

    private String modCount;

    private String rephotograph;

    private String scanImes;

    private String proportion;

    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist == null ? null : waist.trim();
    }

    public String getHip() {
        return hip;
    }

    public void setHip(String hip) {
        this.hip = hip == null ? null : hip.trim();
    }

    public String getBust() {
        return bust;
    }

    public void setBust(String bust) {
        this.bust = bust == null ? null : bust.trim();
    }

    public String getShoulder() {
        return shoulder;
    }

    public void setShoulder(String shoulder) {
        this.shoulder = shoulder == null ? null : shoulder.trim();
    }

    public String getThigh() {
        return thigh;
    }

    public void setThigh(String thigh) {
        this.thigh = thigh == null ? null : thigh.trim();
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck == null ? null : neck.trim();
    }

    public String getUpperArm() {
        return upperArm;
    }

    public void setUpperArm(String upperArm) {
        this.upperArm = upperArm == null ? null : upperArm.trim();
    }

    public String getLowerArm() {
        return lowerArm;
    }

    public void setLowerArm(String lowerArm) {
        this.lowerArm = lowerArm == null ? null : lowerArm.trim();
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature == null ? null : feature.trim();
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    public String getModCount() {
        return modCount;
    }

    public void setModCount(String modCount) {
        this.modCount = modCount == null ? null : modCount.trim();
    }

    public String getRephotograph() {
        return rephotograph;
    }

    public void setRephotograph(String rephotograph) {
        this.rephotograph = rephotograph == null ? null : rephotograph.trim();
    }

    public String getScanImes() {
        return scanImes;
    }

    public void setScanImes(String scanImes) {
        this.scanImes = scanImes == null ? null : scanImes.trim();
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion == null ? null : proportion.trim();
    }
}