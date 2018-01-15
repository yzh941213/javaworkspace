package com.aishidai.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.SubsiteDOCustomMapper;
import com.aishidai.app.dao.SubsiteDOMapper;
import com.aishidai.app.model.pojo.SubsiteDO;
import com.aishidai.app.model.pojo.SubsiteDOExample;
import com.aishidai.app.model.query.SubsiteQuery;
import com.aishidai.app.service.SubsiteService;


@Service
public class SubsiteServiceImpl implements SubsiteService {

	@Autowired
	private SubsiteDOMapper subsiteDOMapper;
	@Autowired
	private SubsiteDOCustomMapper subsiteDOCustomMapper;
	
	public boolean editSubsite(SubsiteDO subsiteDO) throws Exception {
		return subsiteDOMapper.updateByPrimaryKeySelective(subsiteDO) > 0 ;
	}
	
	public SubsiteDO querySubsiteBysubNum(String subNum) throws Exception {
		
		SubsiteDOExample example = new SubsiteDOExample();
		SubsiteDOExample.Criteria  criteria = example.createCriteria();
		criteria.andSubNumberEqualTo(subNum);
		List<SubsiteDO> list = subsiteDOMapper.selectByExample(example);
		if (list.isEmpty() && list.size()<=0) {
			return null;
		}
		return list.get(0);
	}
	
	
	public List<SubsiteDO> querySubsiteByshopsIdList(SubsiteQuery query) throws Exception {
		return subsiteDOMapper.selectByExample(null);
	}

	
	public List<SubsiteDO> querySubsiteListAll(SubsiteQuery query)throws Exception  {
		List<SubsiteDO> list = subsiteDOMapper.selectByExample(null);
		return list;
	}
}
