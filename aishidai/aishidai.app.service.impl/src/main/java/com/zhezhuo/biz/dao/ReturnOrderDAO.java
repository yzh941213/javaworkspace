package com.zhezhuo.biz.dao;


import com.zhezhuo.model.entity.ReOrderRecordDO;
import com.zhezhuo.model.entity.ReturnOrderDO;
import com.zhezhuo.model.query.ItemQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/19.
 */
public interface ReturnOrderDAO {

    int updateStatus(ReOrderRecordDO reOrderRecordDO);

    List<ReturnOrderDO> queryReturnOrderList(ItemQuery query);

    Integer queryReturnOrderCount(ItemQuery query);

    ReturnOrderDO queryReturnOrdreDetail(long returnOrderId);

    Integer queryReturnOrderStatus(long orderId);
}
