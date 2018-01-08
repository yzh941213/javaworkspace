package com.zhezhuo.biz.dao.impl;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.ReOrderRecordDAO;
import com.zhezhuo.model.entity.ReOrderRecordDO;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/18.
 */
public class ReOrderRecordImpl extends BaseDAO implements ReOrderRecordDAO {


    public Long createRecord(ReOrderRecordDO reOrderRecordDO) {
        return null;
    }

    public List<ReOrderRecordDO> queryRecord(long returnOrderId) {
        return null;
    }

    public ReOrderRecordDO querySendRecord(long returnOrderId) {
        return null;
    }

    public ReOrderRecordDO queryOffRecord(long returnOrderId) {
        return null;
    }

    public ReOrderRecordDO queryRecordByPayId(long returnOrderId) {
        return null;
    }

    public int updatePayId(ReOrderRecordDO reOrderRecordDO) {
        return 0;
    }
}
