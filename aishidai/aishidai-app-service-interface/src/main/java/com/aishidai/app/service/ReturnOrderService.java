package com.aishidai.app.service;


import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ReOrderRecordDO;
import com.zhezhuo.model.entity.ReturnOrderDO;
import com.zhezhuo.model.query.ItemQuery;

import java.util.List;

/**
 * Created by Shaka on 15/6/3.
 */
public interface ReturnOrderService {

    Result<Long> operateStatus(ReOrderRecordDO reOrderRecordDO);

    List<ReOrderRecordDO> queryRecord(long returnOrderId);

    List<ReturnOrderDO> queryReturnOrderList(ItemQuery query);

    ReturnOrderDO queryReturnOrderDetail(long returnOrderId);

}
