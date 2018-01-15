package com.aishidai.app.service;


import com.aishidai.app.model.pojo.ItemDO;
import com.aishidai.app.model.query.QueryItem;
import com.aishidai.app.model.vo.ItemVO;

import java.util.List;

public interface ItemService {


    /**
     * 添加商品
     * @param itemDO
     * @return
     */
    Long add(ItemDO itemDO);

    List<ItemVO> itemList(QueryItem  queryItem);

    ItemDO getById(Long itemId);
}
