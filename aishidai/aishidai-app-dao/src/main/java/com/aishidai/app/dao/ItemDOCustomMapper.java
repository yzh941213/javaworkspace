package com.aishidai.app.dao;


import com.aishidai.app.model.query.QueryItem;
import com.aishidai.app.model.vo.ItemVO;

import java.util.List;

public interface ItemDOCustomMapper {
    List<ItemVO> itemList(QueryItem queryItem);

}