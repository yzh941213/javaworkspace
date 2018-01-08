package com.zhezhuo.biz.dao;

import com.zhezhuo.model.domain.Size;
import com.zhezhuo.model.domain.SkuDetailDTO;
import com.zhezhuo.model.entity.SkuDO;
import com.zhezhuo.model.entity.TradeOrderDO;
import com.zhezhuo.model.query.ItemQuery;

import java.util.List;

/**
 * Created by Shaka on 15/6/3.
 */
public interface SkuDAO {

    public List<Long> querySkuBySizeColour(ItemQuery itemQuery) throws Exception;

    public List<SkuDO> querySkuDOByItemId(long itemId) throws Exception;

    public Integer updateSkuDOStatus(SkuDO skuDO) throws Exception;

    public Integer updateSkuDO(SkuDO skuDO) throws Exception;

    public Long insertSkuDO(SkuDO skuDO) throws Exception;

    public Integer queryCountStock(long itemId);

    List<SkuDetailDTO> querySkuDetailByItemId(long itemId);

    List<Size> querySkuSize(SkuDetailDTO detailDTO);

    Integer updateStock(TradeOrderDO tradeOrderDO);

    Integer updateSalseVolume(TradeOrderDO tradeOrderDO);

    SkuDO querySkuDO(TradeOrderDO tradeOrderDO);
    
}
