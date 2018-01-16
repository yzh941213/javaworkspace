package com.aishidai.app.service.impl;

import com.aishidai.app.dao.ItemDOCustomMapper;
import com.aishidai.app.dao.ItemDOMapper;
import com.aishidai.app.model.pojo.ItemDO;
import com.aishidai.app.model.query.QueryItem;
import com.aishidai.app.model.vo.ItemVO;
import com.aishidai.app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    public Long count(QueryItem queryItem) {
        return itemDOCustomMapper.count(queryItem);
    }

    @Autowired
    ItemDOMapper itemDOMapper;

    @Autowired
    ItemDOCustomMapper itemDOCustomMapper;
    public Long add(ItemDO itemDO) {
        itemDOMapper.insert(itemDO);
        return itemDO.getItemId();
    }

    public List<ItemVO> itemList(QueryItem queryItem) {
        return itemDOCustomMapper.itemList(queryItem);
    }

    public ItemDO getById(Long itemId) {
        return itemDOMapper.selectByPrimaryKey(itemId);
    }
}
