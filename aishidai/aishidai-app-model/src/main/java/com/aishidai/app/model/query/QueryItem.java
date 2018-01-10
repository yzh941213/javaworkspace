package com.aishidai.app.model.query;

/**
 * hanfeihu 项目列表查询
 */
public class QueryItem extends QueryPage {
    private String cid ;
    private String recommend="0";
    private String categoryId;
    private String order="desc";
    private String itemId;
    private String itemName;
    private int itemStatus=-8;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
