package com.zhezhuo.model.domain;

/**
 * Created by 蝈蝈 on 2016/12/3.
 */
public class ResourceDTO {

    private long id ;
    private long role_res_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRole_res_id() {
        return role_res_id;
    }

    public void setRole_res_id(long role_res_id) {
        this.role_res_id = role_res_id;
    }
}
