package com.zhezhuo.biz.dao;

import com.zhezhuo.model.entity.ItemSkuDO;

/**
 * Created by Shaka on 15/6/3.
 */
public interface ItemSkuDAO {

    ItemSkuDO queryItemSkuDOByItemId(long itemId);

    Long updateItemSkuById(ItemSkuDO itemSkuDO);

    Long addItemSku(ItemSkuDO itemSkuDO);

}
