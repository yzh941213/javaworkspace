package com.aishidai.app.controller;

import com.aishidai.app.dao.AttributeDOMapper;
import com.aishidai.app.dao.ItemDOMapper;
import com.aishidai.app.model.dto.QueryItem;
import com.aishidai.app.model.pojo.ItemDO;
import com.aishidai.app.model.pojo.ItemDOExample;
import com.aishidai.app.service.AttributeService;
import com.aishidai.common.json.JsonResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("attribute")
public class AttributeController {
    @Autowired
    AttributeService attributeService;

    @GetMapping(value = "list")
    public JsonResult list(QueryItem queryItem){


        return  JsonResult.buildSuccess(attributeService.getAllSubclassByAttrId(1));
    }
}
