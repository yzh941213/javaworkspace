package com.zhezhuo.biz.manager;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.ReportDTO;
import com.zhezhuo.model.entity.ShopDO;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public interface ReportManager {

	public Result<ReportDTO> querySysReport();

	public Result<ReportDTO> queryDistributorReport(Long id);

	public Result<ReportDTO> queryShopReport(ShopDO shopDO);

	public Result<ReportDTO> queryMakerReport(Long id);

	public Result<ReportDTO> queryCraftsmenReport(Long id);

}
