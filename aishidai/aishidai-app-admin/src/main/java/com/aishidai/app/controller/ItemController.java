package com.aishidai.app.controller;

import com.aishidai.app.dao.AttributeDOMapper;
import com.aishidai.app.dao.ItemDOMapper;
import com.aishidai.app.model.pojo.*;
import com.aishidai.app.model.query.QueryItem;
import com.aishidai.app.model.vo.ItemVO;
import com.aishidai.app.service.ItemService;
import com.aishidai.common.json.JsonResult;
import com.aishidai.common.tool.SeparatorTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("manage/item")
public class ItemController {


    @Autowired
    ItemDOMapper  itemDOMapper;

    @Autowired
    AttributeDOMapper attributeDOMapper;

    @GetMapping(value = "list")
    public JsonResult itemList(QueryItem queryItem){


        List<ItemVO> result=new ArrayList<ItemVO>();
        List<ItemVO> list= itemService.itemList(queryItem);
        for (ItemVO itemVO:list){
            String categoryId="";
            List list1=  SeparatorTool.idMinusSplit(itemVO.getCategoryId());
            if(list1.size()!=0) {
                AttributeDOExample attributeDOExample = new AttributeDOExample();
                attributeDOExample.createCriteria().andAttributeIdIn(list1);
                List<AttributeDO> attrbuteList = attributeDOMapper.selectByExample(attributeDOExample);

                for (AttributeDO attributeDO : attrbuteList) {
                    categoryId += attributeDO.getAttrName() + ",";

                }
                categoryId = categoryId.substring(0,categoryId.length() - 1);
            }

            itemVO.setCategoryId(categoryId);
            result.add(itemVO);
        }




        return  JsonResult.buildPaging(result ,queryItem.getsEcho(),116l);
    }

    @Autowired
    ItemService itemService;

    @GetMapping(value = "add")
    public JsonResult add(ItemDO itemDO){
        try {
            itemDO.setCreated(new Date());
            itemDO.setUpdated(new Date());
            itemDO.setAudit(0);
            itemDO.setIsDelete(0);
            return  JsonResult.buildSuccess(itemDOMapper.insert(itemDO));
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }
}
