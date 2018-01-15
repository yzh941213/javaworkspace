package com.aishidai.app.service.impl;

import com.aishidai.app.dao.ItemSkuDOCustomMapper;
import com.aishidai.app.dao.ItemSkuDOMapper;
import com.aishidai.app.dao.ItemSuitDOMapper;
import com.aishidai.app.model.pojo.ItemSkuDO;
import com.aishidai.app.model.pojo.ItemSkuDOExample;
import com.aishidai.app.model.pojo.ItemSuitDO;
import com.aishidai.app.model.vo.ItemVO;
import com.aishidai.app.service.ItemSkuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ItemSkuServiceImpl implements ItemSkuService{
    public List<ItemSkuDO> list(ItemSkuDO itemSkuDO) {

        return null;
    }

    public Boolean delByItemId(Long itemId) {
        ItemSkuDOExample itemSkuDOExample=new ItemSkuDOExample();
        itemSkuDOExample.createCriteria().andItemIdEqualTo(itemId);
        itemSkuDOMapper.deleteByExample(itemSkuDOExample);
        return true;
    }

    public List<ItemSkuDO> getByItem(Long itemId) {
        ItemSkuDOExample itemSkuDOExample=new ItemSkuDOExample();
        itemSkuDOExample.createCriteria().andItemIdEqualTo(itemId);
        return itemSkuDOMapper.selectByExample(itemSkuDOExample);
    }

    @Autowired
    ItemSkuDOCustomMapper itemSkuDOCustomMapper;
    public ItemVO getMaxMinPricByItemId(Long itemId) {
        return itemSkuDOCustomMapper.getMaxMinPricByItemId(itemId);
    }

    @Autowired
    ItemSkuDOMapper itemSkuDOMapper;

    @Autowired
    ItemSuitDOMapper itemSuitDOMapper;
    public Boolean add(ItemSkuDO itemSkuDO) {
       Integer result= itemSkuDOMapper.insert(itemSkuDO);
       Integer suitResult=0;
       if(!StringUtils.isEmpty(itemSkuDO.getSuitImage())){
           //插入suit
           ItemSuitDO itemSuitDO=new ItemSkuDO();
           itemSuitDO.setSkuId(itemSkuDO.getSkuId());
           itemSuitDO.setItemId(itemSkuDO.getItemId());
           itemSuitDO.setSuitImage(itemSkuDO.getSuitImage());
           suitResult= itemSuitDOMapper.insert(itemSuitDO);


       }
        return result>0 & suitResult>0;
    }

    public Boolean update(ItemSkuDO itemSkuDO) {
        return itemSkuDOMapper.updateByPrimaryKey(itemSkuDO)>0;
    }
}
