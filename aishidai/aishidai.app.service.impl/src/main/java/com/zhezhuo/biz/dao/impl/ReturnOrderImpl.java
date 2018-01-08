package com.zhezhuo.biz.dao.impl;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.ReturnOrderDAO;
import com.zhezhuo.model.entity.ReOrderRecordDO;
import com.zhezhuo.model.entity.ReturnOrderDO;
import com.zhezhuo.model.query.ItemQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/18.
 */
public class ReturnOrderImpl extends BaseDAO implements ReturnOrderDAO {

    public int updateStatus(ReOrderRecordDO reOrderRecordDO) {
        return 0;
    }

    public List<ReturnOrderDO> queryReturnOrderList(ItemQuery query) {
        return null;
    }

    public Integer queryReturnOrderCount(ItemQuery query) {
        return null;
    }

    public ReturnOrderDO queryReturnOrdreDetail(long returnOrderId) {
        return null;
    }

    public Integer queryReturnOrderStatus(long orderId) {
        return null;
    }
}
