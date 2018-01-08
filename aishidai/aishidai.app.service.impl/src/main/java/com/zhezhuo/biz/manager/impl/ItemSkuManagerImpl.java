package com.zhezhuo.biz.manager.impl;

import com.zhezhuo.biz.dao.ItemSkuDAO;
import com.zhezhuo.biz.manager.ItemSkuManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ItemSkuDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Shaka on 15/6/10.
 */
public class ItemSkuManagerImpl implements ItemSkuManager {

    @Autowired
    ItemSkuDAO itemSkuDAO;

    Logger logger = LoggerFactory.getLogger(ItemSkuManagerImpl.class);


    @Override
    public Result<ItemSkuDO> queryItemSkuByItemId(long itemId) {
        Result<ItemSkuDO> result = new Result<ItemSkuDO>();
        try {
            ItemSkuDO itemSkuDO = itemSkuDAO.queryItemSkuDOByItemId(itemId);
            result.setResult(itemSkuDO);
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            result.setSuccess(false);
            return result;
        }
    }

    @Override
    public Result<Long> editItemSku(ItemSkuDO itemSkuDO) {
        Result<Long> result = new Result<Long>();
        long row = 0;
        try {
            if (itemSkuDO.getSkuId() > 0) {
               row =  itemSkuDAO.updateItemSkuById(itemSkuDO);
            } else {
               row =  itemSkuDAO.addItemSku(itemSkuDO);
            }
            if (row > 0) {
                result.setResult(itemSkuDO.getSkuId());
                result.setSuccess(true);
                return result;
            }
            result.setResult(-1l);
            result.setSuccess(false);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            result.setResult(-1l);
            result.setSuccess(false);
            return result;
        }
    }
}