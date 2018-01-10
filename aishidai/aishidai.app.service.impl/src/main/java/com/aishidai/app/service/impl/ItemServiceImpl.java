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

    @Autowired
    ItemDOMapper itemDOMapper;

    @Autowired
    ItemDOCustomMapper itemDOCustomMapper;
    public Boolean add(ItemDO itemDO) {
        return itemDOMapper.insert(itemDO)>0;
    }

    public List<ItemVO> itemList(QueryItem queryItem) {
        return itemDOCustomMapper.itemList(queryItem);
    }
}
