package com.aishidai.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.CommissionMoneyDOMapper;
import com.aishidai.app.dao.TradeOrderDOMapper;
import com.aishidai.app.dao.TradeOrderItemDOMapper;
import com.aishidai.app.model.pojo.CommissionMoneyDO;
import com.aishidai.app.model.pojo.CommissionMoneyDOExample;
import com.aishidai.app.model.pojo.TradeOrderDO;
import com.aishidai.app.model.pojo.TradeOrderDOExample;
import com.aishidai.app.model.pojo.TradeOrderItemDO;
import com.aishidai.app.model.pojo.TradeOrderItemDOExample;
import com.aishidai.app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private TradeOrderDOMapper tradeOrderDOMapper;
	@Autowired
	private CommissionMoneyDOMapper commissionMoneyDOMapper;
	@Autowired
	private TradeOrderItemDOMapper tradeOrderItemDOMapper;
	
	public List<TradeOrderDO> queryAll() {
		return tradeOrderDOMapper.selectByExample(null);
	}


	public List<TradeOrderDO> queryOrderByBuyerUserItem(long id) {
		TradeOrderDOExample example = new TradeOrderDOExample();
		TradeOrderDOExample.Criteria criteria = example.createCriteria();
		criteria.andBuyerUserIdEqualTo(id);
		criteria.andOrderTypeEqualTo(0);
		criteria.andStatusEqualTo(4);
		return tradeOrderDOMapper.selectByExample(example);
	}


	public List<TradeOrderDO> queryOrderByBuyerUserService(long id) {
		TradeOrderDOExample example = new TradeOrderDOExample();
		TradeOrderDOExample.Criteria criteria = example.createCriteria();
		criteria.andBuyerUserIdEqualTo(id);
		criteria.andOrderTypeNotEqualTo(0);
		criteria.andStatusEqualTo(4);
		return tradeOrderDOMapper.selectByExample(example);
	}


	public CommissionMoneyDO queryCommissionMoneyByOrderId(long orderId) {
		CommissionMoneyDOExample example = new CommissionMoneyDOExample();
		CommissionMoneyDOExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<CommissionMoneyDO> list = commissionMoneyDOMapper.selectByExample(example);
		if (list.isEmpty() && list.size() <=0 ) {
			return null;
		}
		return list.get(0);
	}


	public List<TradeOrderItemDO> queryChildOrderItemsList(long orderId) {
		TradeOrderItemDOExample example = new TradeOrderItemDOExample();
		TradeOrderItemDOExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		return tradeOrderItemDOMapper.selectByExample(example);
	}


	public List<TradeOrderDO> queryItems() {
		TradeOrderDOExample example = new TradeOrderDOExample();
		TradeOrderDOExample.Criteria criteria = example.createCriteria();
		criteria.andOrderTypeEqualTo(0);
		criteria.andStatusEqualTo(4);
		return tradeOrderDOMapper.selectByExample(example);
	}
	public List<TradeOrderDO> queryService() {
		TradeOrderDOExample example = new TradeOrderDOExample();
		TradeOrderDOExample.Criteria criteria = example.createCriteria();
		criteria.andOrderTypeNotEqualTo(0);
		criteria.andStatusEqualTo(4);
		return tradeOrderDOMapper.selectByExample(example);
	}
}
