package com.zhezhuo.biz.dao.impl;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.SkuDAO;
import com.zhezhuo.model.domain.Size;
import com.zhezhuo.model.domain.SkuDetailDTO;
import com.zhezhuo.model.entity.SkuDO;
import com.zhezhuo.model.entity.TradeOrderDO;
import com.zhezhuo.model.query.ItemQuery;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by Shaka on 15/6/3.
 */
@Component
public class SkuDAOImpl extends BaseDAO implements SkuDAO {

    public List<Long> querySkuBySizeColour(ItemQuery itemQuery) throws Exception {
        return null;
    }

    public List<SkuDO> querySkuDOByItemId(long itemId) throws Exception {
        return null;
    }

    public Integer updateSkuDOStatus(SkuDO skuDO) throws Exception {
        return null;
    }

    public Integer updateSkuDO(SkuDO skuDO) throws Exception {
        return null;
    }

    public Long insertSkuDO(SkuDO skuDO) throws Exception {
        return null;
    }

    public Integer queryCountStock(long itemId) {
        return null;
    }

    public List<SkuDetailDTO> querySkuDetailByItemId(long itemId) {
        return null;
    }

    public List<Size> querySkuSize(SkuDetailDTO detailDTO) {
        return null;
    }

    public Integer updateStock(TradeOrderDO tradeOrderDO) {
        return null;
    }

    public Integer updateSalseVolume(TradeOrderDO tradeOrderDO) {
        return null;
    }

    public SkuDO querySkuDO(TradeOrderDO tradeOrderDO) {
        return null;
    }
}
