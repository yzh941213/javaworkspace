package com.aishidai.app.service;

import com.aishidai.app.model.dto.QueryItem;
import com.aishidai.app.model.pojo.ItemDO;
import com.aishidai.app.model.vo.ItemVO;

import java.util.List;

public interface ItemService {


    /**
     * 添加商品
     * @param itemDO
     * @return
     */
    Boolean add(ItemDO itemDO);

    List<ItemVO> itemList(ItemDO itemDO);
}
