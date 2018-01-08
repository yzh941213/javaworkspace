package com.zhezhuo.biz.manager;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.CraftsmenDO;
import com.zhezhuo.model.entity.ItemDO;
import com.zhezhuo.model.query.ItemQuery;

import java.util.List;

/**
 * Created by Shaka on 15/6/3.
 */
public interface ItemManager {

	/**
	 * 查询商品列表
	 */
	Result<List<ItemDO>> queryItemDOList(ItemQuery query) throws Exception;

	/**
	 * 根据商品的ID查询商品的信息
	 */
	Result<ItemDO> queryItemDOById(long itemId) throws Exception;

	/**
	 * 修改商品的信息
	 */
	Result<Long> editItemDO(ItemDO itemDO) throws Exception;

	/**
	 * 编辑商品的上下架
	 * 
	 * @param itemDO
	 * @return
	 * @throws Exception
	 */
	Result<Integer> updateItemDOItemStatus(ItemDO itemDO) throws Exception;

	/**
	 * 删除和恢复商品
	 * 
	 * @param itemDO
	 * @return
	 * @throws Exception
	 */
	Result<Integer> delItemDO(ItemDO itemDO) throws Exception;

	/**
	 * 调整商品的价格模式
	 * 
	 * @param itemDO
	 * @return
	 * @throws Exception
	 */
	Result<Integer> updateItemsModel(ItemDO itemDO) throws Exception;
	//审核
		public Result<Integer> updateItemAudit(ItemDO itemDO);

	/**
	 * 查询在回收站中的商品
	 * 
	 * @param query
	 * @return
	 */
	Result<List<ItemDO>> queryItemDODelList(ItemQuery query) throws Exception;

}
