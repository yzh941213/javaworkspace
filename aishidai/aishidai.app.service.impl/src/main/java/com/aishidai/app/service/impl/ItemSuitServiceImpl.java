package com.aishidai.app.service.impl;

import com.aishidai.app.dao.ItemSuitDOMapper;
import com.aishidai.app.model.pojo.ItemSuitDO;
import com.aishidai.app.model.pojo.ItemSuitDOExample;
import com.aishidai.app.service.ItemSuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemSuitServiceImpl implements ItemSuitService {
    @Autowired
    ItemSuitDOMapper itemSuitDOMapper;
    public Boolean delByItemId(Long itemId) {
        ItemSuitDOExample itemSuitDOExample=new ItemSuitDOExample();
        itemSuitDOExample.createCriteria().andItemIdEqualTo(itemId);
        return itemSuitDOMapper.deleteByExample(itemSuitDOExample)>0;
    }
}
