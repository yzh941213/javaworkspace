package com.aishidai.app.service.impl;
import com.aishidai.app.dao.TradeOrderDOMapper;
import com.aishidai.app.model.pojo.TradeOrderDO;
import com.aishidai.app.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService implements IDemoService {
    @Autowired
    private TradeOrderDOMapper tradeOrderDOMapper;


    @Transactional
    public TradeOrderDO shopList(String city){



        return tradeOrderDOMapper.selectByPrimaryKey(Long.valueOf(city));
    }
}
