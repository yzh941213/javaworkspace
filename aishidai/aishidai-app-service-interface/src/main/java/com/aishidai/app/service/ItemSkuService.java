package com.aishidai.app.service;


import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ItemSkuDO;

/**
 * Created by Shaka on 15/6/3.
 */
public interface ItemSkuService {

    Result<ItemSkuDO> queryItemSkuByItemId(long itemId);

    Result<Long> editItemSku(ItemSkuDO itemSkuDO);

}
