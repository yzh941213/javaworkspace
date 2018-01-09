package com.aishidai.app.controller;

import com.aishidai.app.dao.ItemDOMapper;
import com.aishidai.app.model.pojo.ItemDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;
import java.util.List;

@RestController("item")
public class ItemController {

    @Autowired
    ItemDOMapper itemDOMapper;

    @GetMapping(value = "itemList")
    public ItemDO itemList(String city ){


        return  itemDOMapper.selectByPrimaryKey(1804l);
    }
}
