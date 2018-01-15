package com.aishidai.app.service;

import com.aishidai.app.model.pojo.ItemSkuDO;
import com.aishidai.app.model.vo.ItemVO;

public interface ItemSkuService {

    Boolean add(ItemSkuDO itemSkuDO);
    Boolean update(ItemSkuDO itemSkuDO);

    /**
     * 获取 某个商品的价格区间
     * @param itemId
     * @return
     */
   ItemVO getMaxMinPricByItemId(Long itemId);
}
