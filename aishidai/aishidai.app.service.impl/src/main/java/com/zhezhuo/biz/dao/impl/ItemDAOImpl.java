package com.zhezhuo.biz.dao.impl;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.ItemDAO;
import com.zhezhuo.model.entity.ItemDO;
import com.zhezhuo.model.query.ItemQuery;

import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by Shaka on 15/6/3.
 */
@Component
public class ItemDAOImpl extends BaseDAO implements ItemDAO {

    public int updateItemAudit(ItemDO itemDO) throws Exception {
        return 0;
    }

    public List<ItemDO> queryItemDOList(ItemQuery query) throws Exception {
        return null;
    }

    public ItemDO queryItemDOById(long itemId) throws Exception {
        return null;
    }

    public int updateItemDOItemStatus(ItemDO itemDO) throws Exception {
        return 0;
    }

    public int delItemDO(ItemDO itemDO) throws Exception {
        return 0;
    }

    public int updateItemDOItemsModel(ItemDO itemDO) throws Exception {
        return 0;
    }

    public Integer updateItemDOById(ItemDO itemDO) throws Exception {
        return null;
    }

    public Long insertItemDO(ItemDO itemDO) throws Exception {
        return null;
    }

    public Integer updateItemDOStock(ItemDO itemDO) throws Exception {
        return null;
    }

    public List<ItemDO> queryItemDODelList(ItemQuery query) throws Exception {
        return null;
    }
}
