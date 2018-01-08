package com.zhezhuo.biz.manager.impl;

import com.zhezhuo.biz.dao.ItemDAO;
import com.zhezhuo.biz.dao.SkuDAO;
import com.zhezhuo.biz.manager.CacheManager;
import com.zhezhuo.biz.manager.SkuManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.SkuDetailDTO;
import com.zhezhuo.model.entity.SkuDO;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Shaka on 15/6/10.
 */
public class SkuManagerImpl implements SkuManager {
    @Resource
    private SkuDAO skuDAO;

    @Resource
    private ItemDAO itemDAO;

    @Resource
    private CacheManager cacheManager;

    private static String CacheKeyPrefix = "sku";


    @Override
    public Result<List<SkuDetailDTO>> querySkuDOList(long itemId) {
        Result<List<SkuDetailDTO>> result = new Result<List<SkuDetailDTO>>();
        try {
            List<SkuDetailDTO> skuDetailDTOs = skuDAO.querySkuDetailByItemId(itemId);
            if (skuDetailDTOs == null || skuDetailDTOs.isEmpty()) {
                result.setSuccess(false);
                result.setErrorInfo("查询失败");
                return result;
            }
            for (SkuDetailDTO dto : skuDetailDTOs) {
                dto.setSizeList(skuDAO.querySkuSize(dto));
            }
            result.setResult(skuDetailDTOs);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setErrorInfo(e.getMessage());
            return result;
        }
        return result;
    }

    @Override
    public Result<Integer> updateSkuDOStatus(SkuDO skuDO) {
        Result<Integer> result = new Result<Integer>();
        try {
            int row = skuDAO.updateSkuDOStatus(skuDO);
            if (row <= 0) {
                result.setSuccess(false);
                return result;
            }
            result.setSuccess(true);
            result.setResult(row);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            return result;
        }
        return result;
    }

    @Transactional
    @Override
    public Result<Integer> editSkuDO(List<SkuDO> skuDOs, long itemId) throws Exception {

        Result<Integer> result = new Result<Integer>();
        long row1, row2;
        try {
            //1.insert/update sku
            for (SkuDO skuDO:skuDOs) {
                skuDO.setItemId(itemId);
//                skuDO.setImage(image);
                if (skuDO.getSkuId() == 0) {
                    row1 = skuDAO.insertSkuDO(skuDO);
                } else {
                    row1 = skuDAO.updateSkuDO(skuDO);
                }
                if (row1 <= 0) { //操作失败
                    throw new RuntimeException();
                }
            }


            //2.update item stock
            /*ItemDO itemDO = new ItemDO();
            itemDO.setItemId(itemId);*/
//            int stock = 0;

            /*List<SkuDO> skuDOs = skuDAO.querySkuDOByItemId(skuDO.getItemId());*/

            /*if (skuDOs != null && !skuDOs.isEmpty()) {
                for (SkuDO sku : skuDOs) {
                    JSONArray jsonArray = JSONArray.parseArray(sku.getSizeId());
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject skuSizeObj = jsonArray.getJSONObject(i);
                        stock += skuSizeObj.getInteger("stock");
                    }
                }
            }*/
            /*itemDO.setStock(skuDAO.queryCountStock(itemId));
            row2 = itemDAO.updateItemDOStock(itemDO);
            if (row2 <= 0) { //操作失败
                throw new RuntimeException();
            }*/
            result.setSuccess(true);
            result.setResult(0);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }
}