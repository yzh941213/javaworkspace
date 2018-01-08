package com.zhezhuo.biz.manager.impl;

import com.mysql.jdbc.StringUtils;
import com.zhezhuo.biz.dao.AttributeDAO;
import com.zhezhuo.biz.dao.ItemDAO;
import com.zhezhuo.biz.dao.SkuDAO;
import com.zhezhuo.biz.dao.SysUsersDAO;
import com.zhezhuo.biz.manager.CacheManager;
import com.zhezhuo.biz.manager.ItemManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ItemDO;
import com.zhezhuo.model.entity.SkuDO;
import com.zhezhuo.model.query.ItemQuery;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Shaka on 15/6/10.
 */
public class ItemManagerImpl implements ItemManager {

	@Resource
	private ItemDAO itemDAO;
	@Resource
	private CacheManager cacheManager;
	@Resource
	private SkuDAO skuDAO;
	@Resource
	private AttributeDAO attributeDAO;
	@Autowired
	private SysUsersDAO sysUsersDAO;

	private static String CacheKeyPrefix = "item";

	@Override
	public Result<List<ItemDO>> queryItemDOList(ItemQuery query) throws Exception{
		Result<List<ItemDO>> result = new Result<List<ItemDO>>();
		List<ItemDO> itemDOs = itemDAO.queryItemDOList(query);
		for (ItemDO itemDO : itemDOs) {
			if (itemDO.getSupplier() != 0) {
				itemDO.setSupplierName(sysUsersDAO.querySysUsersById(
						itemDO.getSupplier()).getName());
			}
		}
		result.setSuccess(true);
		result.setResult(itemDOs);
		return result;
	}

	@Override
	public Result<ItemDO> queryItemDOById(long itemId)  throws Exception{
		Result<ItemDO> result = new Result<ItemDO>();
		ItemDO itemDO = itemDAO.queryItemDOById(itemId);
		if (itemDO == null) {
			result.setResult(null);
			result.setSuccess(true);
			return result;
		}
		result.setSuccess(true);
		result.setResult(itemDO);
		return result;
	}

	
	@Override
	public Result<Integer> updateItemDOItemStatus(ItemDO itemDO)
			throws Exception {
		Result<Integer> result = new Result<Integer>();
		ItemDO query = itemDAO.queryItemDOById(itemDO.getItemId());
		
		if (query == null) {
			result.setErrorInfo("该商品不存在!");
			result.setResult(-1);
			result.setSuccess(false);
			return result;
		}
		if (StringUtils.isNullOrEmpty(query.getCategoryId())
				|| StringUtils.isNullOrEmpty(query.getImage())
				|| StringUtils.isNullOrEmpty(query.getItemCode())
				|| StringUtils.isNullOrEmpty(query.getItemName())
				|| StringUtils.isNullOrEmpty(query.getSalesPrice())
				|| StringUtils.isNullOrEmpty(query.getPrice())) {
			result.setErrorInfo("商品信息不完整!");
			result.setResult(-1);
			result.setSuccess(false);
			return result;
		}
		if (itemDO.getItemStatus() == 1) {
			
		}else{
			List<SkuDO> skuDOs = skuDAO.querySkuDOByItemId(itemDO.getItemId());
			
			if (skuDOs.isEmpty() || skuDOs.size() <= 0) {
				result.setErrorInfo("sku信息不完整,请先补全sku!");
				result.setResult(-1);
				result.setSuccess(false);
				return result;
			}
		}
		
		
		int row = itemDAO.updateItemDOItemStatus(itemDO);
		if (row <= 0) {
			result.setSuccess(false);
			return result;
		}
		result.setSuccess(true);
		result.setResult(row);
		return result;
	}
	
	
	@Override
	public Result<Long> editItemDO(ItemDO itemDO) throws Exception {
		
		Result<Long> result = new Result<Long>();
		long row = 0;
		if (itemDO.getItemId() == 0) {
			//默认商品是不删除的
			itemDO.setDeleteIs(0);
			//默认为正常价商品
			itemDO.setItemsModel(0);
			//默认新建商品为下架的
			itemDO.setItemStatus(1);
			row = itemDAO.insertItemDO(itemDO);
		} else {
			row = itemDAO.updateItemDOById(itemDO);
		}
		//结果小于等于0的话，代表更新或者插入动作失败
		if (row <= 0) {
			result.setSuccess(false);
			return result;
		}
		result.setSuccess(true);
		result.setResult(itemDO.getItemId());
		return result;
	}

	@Override
	public Result<Integer> delItemDO(ItemDO itemDO) throws Exception {
		// TODO Auto-generated method stub
		Result<Integer> result = new Result<Integer>();
		ItemDO query = itemDAO.queryItemDOById(itemDO.getItemId());
		if (query == null) {
			result.setErrorInfo("该商品不存在!");
			result.setResult(-1);
			result.setSuccess(false);
			return result;
		}
		int row = itemDAO.delItemDO(itemDO);
			
		if (row <= 0) {
			result.setSuccess(false);
			return result;
		}
		result.setSuccess(true);
		result.setResult(row);
		return result;
	}

	@Override
	public Result<Integer> updateItemsModel(ItemDO itemDO) throws Exception {
		// TODO Auto-generated method stub
		Result<Integer> result = new Result<Integer>();
		ItemDO query = itemDAO.queryItemDOById(itemDO.getItemId());
		if (query == null) {
			result.setErrorInfo("该商品不存在!");
			result.setResult(-1);
			result.setSuccess(false);
			return result;
		}
		int row = itemDAO.updateItemDOItemsModel(itemDO);
			
		if (row <= 0) {
			result.setSuccess(false);
			return result;
		}
		
		result.setSuccess(true);
		result.setResult(row);
		return result;
	}

	@Override
	public Result<List<ItemDO>> queryItemDODelList(ItemQuery query) throws Exception {
		// TODO Auto-generated method stub
		Result<List<ItemDO>> result = new Result<List<ItemDO>>();
		List<ItemDO> itemDOs = itemDAO.queryItemDODelList(query);
		for (ItemDO itemDO : itemDOs) {
			if (itemDO.getSupplier() != 0) {
				itemDO.setSupplierName(sysUsersDAO.querySysUsersById(
						itemDO.getSupplier()).getName());
			}
		}
		result.setSuccess(true);
		result.setResult(itemDOs);
		return result;
	}
//审核
	@Override
	public Result<Integer> updateItemAudit(ItemDO itemDO) {
		Result<Integer> result = null;
		try {
			int row = itemDAO.updateItemAudit(itemDO);
			result = new Result<Integer>();
			if (row == 0) {
				result.setSuccess(false);
				return result;
			}
			result.setSuccess(true);
			result.setResult(row);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}
}
