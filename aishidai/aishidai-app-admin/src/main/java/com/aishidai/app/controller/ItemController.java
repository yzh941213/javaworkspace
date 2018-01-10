package com.aishidai.app.controller;

import com.aishidai.app.dao.AttributeDOMapper;
import com.aishidai.app.dao.ItemDOMapper;
import com.aishidai.app.model.dto.QueryItem;
import com.aishidai.app.model.pojo.AttributeDO;
import com.aishidai.app.model.pojo.AttributeDOExample;
import com.aishidai.app.model.pojo.ItemDO;
import com.aishidai.app.model.pojo.ItemDOExample;
import com.aishidai.app.model.vo.ItemVO;
import com.aishidai.app.service.ItemService;
import com.aishidai.common.json.JsonResult;
import com.aishidai.common.tool.SeparatorTool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {


    @Autowired
    ItemDOMapper  itemDOMapper;

    @Autowired
    AttributeDOMapper attributeDOMapper;

    @GetMapping(value = "list")
    public JsonResult itemList(ItemDO itemDO){
        List<ItemVO> result=new ArrayList<ItemVO>();
        List<ItemVO> list= itemService.itemList(itemDO);
        for (ItemVO itemVO:list){
            AttributeDOExample attributeDOExample=new AttributeDOExample();
            attributeDOExample.createCriteria().andAttributeIdIn(SeparatorTool.idMinusSplit(itemVO.getCategoryId()));
           List<AttributeDO> attrbuteList= attributeDOMapper.selectByExample(attributeDOExample);
           String categoryId="";
           for (AttributeDO attributeDO:attrbuteList){
               categoryId+=attributeDO.getAttrName()+",";

           }
            categoryId = categoryId.substring(0,categoryId.length() - 1);
            itemVO.setCategoryId(categoryId);
            result.add(itemVO);
        }




        return  JsonResult.buildSuccess(result );
    }

    @Autowired
    ItemService itemService;

    @GetMapping(value = "add")
    public JsonResult add(ItemDO itemDO){
        try {
            itemDO.setCreated(new Date());
            itemDO.setUpdated(new Date());
            itemDO.setAudit(0);
            itemDO.setDeleteIs(0);
            return  JsonResult.buildSuccess(itemDOMapper.insert(itemDO));
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }
}
