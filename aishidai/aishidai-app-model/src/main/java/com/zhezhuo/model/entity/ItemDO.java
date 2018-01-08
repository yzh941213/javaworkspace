package com.zhezhuo.model.entity;

import java.io.Serializable;

/**
 * Created by 蝈蝈 on 2016/8/22.
 */
public class ItemDO implements Serializable{

    private static final long serialVersionUID = -2133290295703313994L;

    private long itemId;
    private long nameId;
    private String price;
    private String salesPrice;
    private String occasionId;
    private String age;
    private String image;
    private String thumbnail;
    private String categoryId;
    private String itemCode;
    private long userId;
    private String feature;
    private String summary;
    private Integer stock;
    private Integer salseVolume;
    private String created;
	private long supplier;
	private String updated;
    private int recommend;
    private String itemTag;
    private String itemName;
    
    private Integer skuStock;

	private int stratification;
    private String suitImage;

	private String supplierName;
	
	private int itemStatus;
	private int deleteIs;
	private int itemsModel;
	private Integer audit;
	
	
	
    public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

    public long getSupplier() {
		return supplier;
	}

	public void setSupplier(long supplier) {
		this.supplier = supplier;
	}

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getNameId() {
        return nameId;
    }

    public void setNameId(long nameId) {
        this.nameId = nameId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    public int getStratification() {
		return stratification;
	}

	public void setStratification(int stratification) {
		this.stratification = stratification;
	}

	public String getSuitImage() {
		return suitImage;
	}

	public void setSuitImage(String suitImage) {
		this.suitImage = suitImage;
	}
    
    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getOccasionId() {
        return occasionId;
    }

    public void setOccasionId(String occasionId) {
        this.occasionId = occasionId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getStock() {
        if (this.stock == null ) {
            this.stock = 0;
        }
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSalseVolume() {
        if (salseVolume == null) {
            salseVolume = 0;
        }
        return salseVolume;
    }

    public Integer getSkuStock() {
        if (skuStock == null) {
            return 0;
        }
        return skuStock;
    }

    public void setSkuStock(Integer skuStock) {
        this.skuStock = skuStock;
    }

    public void setSalseVolume(Integer salseVolume) {
        this.salseVolume = salseVolume;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public String getItemTag() {
        return itemTag;
    }

    public void setItemTag(String itemTag) {
        this.itemTag = itemTag;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }



    @Override
    public String toString() {
        return "ItemDO{" +
                "itemId=" + itemId +
                ", name='" + nameId + '\'' +
                ", price=" + price +
                ", stratification=" + stratification +
                ", supplier=" + supplier +
                ", suitImage=" + suitImage +
                ", salesPrice=" + salesPrice +
                ", occasionId='" + occasionId + '\'' +
                ", ageId='" + age + '\'' +
                ", image='" + image + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", categoryId=" + categoryId +
                ", deleteIs='" + deleteIs + '\'' +
                ", itemsModel=" + itemsModel +
                ", itemCode='" + itemCode + '\'' +
                ", userId=" + userId +
                ", feature='" + feature + '\'' +
                ", summary='" + summary + '\'' +
                ", stock=" + stock +
                ", salseVolume=" + salseVolume +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", recommend=" + recommend +
                ", itemTag='" + itemTag + '\'' +
                ", itemName='" + itemName + '\'' +
                ", status=" + itemStatus +
                '}';
    }

	public int getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}

	public int getDeleteIs() {
		return deleteIs;
	}

	public void setDeleteIs(int deleteIs) {
		this.deleteIs = deleteIs;
	}

	public int getItemsModel() {
		return itemsModel;
	}

	public void setItemsModel(int itemsModel) {
		this.itemsModel = itemsModel;
	}
}
