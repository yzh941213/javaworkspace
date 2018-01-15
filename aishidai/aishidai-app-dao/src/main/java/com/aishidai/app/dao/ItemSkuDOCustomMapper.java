package com.aishidai.app.dao;


import com.aishidai.app.model.vo.ItemVO;

public interface ItemSkuDOCustomMapper {
     ItemVO getMaxMinPricByItemId(Long itemId);
}