package com.zhezhuo.biz.dao;


import com.zhezhuo.model.entity.ReOrderRecordDO;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/19.
 */
public interface ReOrderRecordDAO {

  Long createRecord(ReOrderRecordDO reOrderRecordDO);

  List<ReOrderRecordDO> queryRecord(long returnOrderId);

  ReOrderRecordDO querySendRecord(long returnOrderId);

  ReOrderRecordDO queryOffRecord(long returnOrderId);

  ReOrderRecordDO queryRecordByPayId(long returnOrderId);

  int updatePayId(ReOrderRecordDO reOrderRecordDO);

}
