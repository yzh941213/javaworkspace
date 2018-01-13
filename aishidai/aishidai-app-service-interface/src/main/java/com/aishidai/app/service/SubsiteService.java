package com.aishidai.app.service;


import java.util.List;

import com.aishidai.app.model.pojo.SubsiteDO;
import com.aishidai.app.model.query.SubsiteQuery;

public interface SubsiteService {

	boolean editSubsite(SubsiteDO subsiteDO) throws Exception;
	
	SubsiteDO querySubsiteBysubNum(String subNUM) throws Exception;
	
	List<SubsiteDO> querySubsiteByshopsIdList(SubsiteQuery query) throws Exception;
	
	List<SubsiteDO> querySubsiteListAll(SubsiteQuery query) throws Exception;
	
}
