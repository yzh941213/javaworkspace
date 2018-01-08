package com.zhezhuo.biz.dao;

import com.zhezhuo.model.entity.CraftsmenDO;
import com.zhezhuo.model.entity.ItemDO;
import com.zhezhuo.model.query.ItemQuery;

import java.util.List;

/**
 * 操作商品的DAO
 * @author 51147
 *
 */
public interface ItemDAO {
	
	/**
	 * 查询商品列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	//审核
		public int updateItemAudit(ItemDO itemDO) throws Exception;
    List<ItemDO> queryItemDOList(ItemQuery query) throws Exception;
    /**
     * 根据商品的ID查询商品的信息
     * @param itemId
     * @return
     * @throws Exception
     */
    ItemDO queryItemDOById(long itemId) throws Exception;
    /**
     * 修改商品的上下架
     * @param itemDO
     * @return
     * @throws Exception
     */
    int updateItemDOItemStatus(ItemDO itemDO) throws Exception;
    /**
     * 删除和恢复商品
     * @param itemDO
     * @return
     * @throws Exception
     */
    int delItemDO(ItemDO itemDO) throws Exception;
    /**
     * 修改商品的价格状态
     * @param itemDO
     * @return
     * @throws Exception
     */
    int updateItemDOItemsModel(ItemDO itemDO) throws Exception;
    /**
     * 根据商品的ID修改商品的信息
     * @param itemDO
     * @return
     * @throws Exception
     */
    Integer updateItemDOById(ItemDO itemDO) throws Exception;
    /**
     * 插入商品信息
     * @param itemDO
     * @return
     * @throws Exception
     */
    Long insertItemDO(ItemDO itemDO) throws Exception;
    /**
     * 
     * @param itemDO
     * @return
     * @throws Exception
     */
    Integer updateItemDOStock(ItemDO itemDO) throws Exception;
    
    /**
     * 查询回收站中的商品列表
     * @param query
     * @return
     * @throws Exception
     */
	List<ItemDO> queryItemDODelList(ItemQuery query) throws Exception;

}
