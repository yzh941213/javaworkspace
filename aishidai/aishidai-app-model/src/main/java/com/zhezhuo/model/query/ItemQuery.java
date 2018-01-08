package com.zhezhuo.model.query;

import com.zhezhuo.model.Query;
import com.zhezhuo.model.util.CacheKeyBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ItemQuery extends Query implements Serializable, CacheKeyBuilder {

    private static final long serialVersionUID = 9007961251280264879L;
    
    private String categoryIds;
    private int categoryId;
    private String tags;
    private String keywords;
    private String search;
    private int recommend;
    private int type; //{}
    private long nameId;
    private String price;
    private String ageId;
    private String sizeId;
    private long colourId;
    private String occasionId;
    private List<Long> skuIds;
    private String itemCode;
    private int condition;
    private long itemId;
    private int itemStatus;
    private String itemName;
    
    
    
    public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getCategoryIds() {
        return categoryIds;
    }

    public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public int getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}

	public void setCategoryIds(String categoryIds) {
        this.categoryIds = categoryIds;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    @Override
    public String getCacheKey(Object o) {
        return getCacheKey();
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    @Override
    public String getCacheKey() {
        return this.getClass().toString().replaceAll("class ", "") + "_" + String.valueOf(this.toString().hashCode());
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getSizeId() {
        return sizeId;
    }

    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
    }

    public long getColourId() {
        return colourId;
    }

    public void setColourId(long colourId) {
        this.colourId = colourId;
    }

    public String getAgeId() {
        return ageId;
    }

    public void setAgeId(String ageId) {
        this.ageId = ageId;
    }

    public String getOccasionId() {
        return occasionId;
    }

    public void setOccasionId(String occasionId) {
        this.occasionId = occasionId;
    }

    public List<Long> getSkuIds() {
        if(skuIds == null){
            return new ArrayList<Long>();
        }
        return skuIds;
    }

    public void setSkuIds(List<Long> skuIds) {
        this.skuIds = skuIds;
    }

    @Override
    public String toString() {
        return "ItemQuery{" +
                "categoryIds='" + categoryIds + '\'' +
                ", tags='" + tags + '\'' +
                ", userId=" + super.getUserId() +
                '}';
    }
}
