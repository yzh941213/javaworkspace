package com.aishidai.app.controller;
import com.aishidai.app.model.pojo.TradeOrderDO;
import com.aishidai.app.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private IDemoService demoService;


    @GetMapping(value = "/shopList")
    public TradeOrderDO shopList(String city ){


        return  demoService.shopList(city);
    }

}


