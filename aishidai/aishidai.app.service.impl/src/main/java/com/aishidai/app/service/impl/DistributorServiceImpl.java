package com.aishidai.app.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.*;
import com.aishidai.app.model.pojo.DistributorDO;
import com.aishidai.app.model.pojo.DistributorDOExample;
import com.aishidai.app.model.query.DistributorQuery;
import com.aishidai.app.service.DistributorService;

@Service
public class DistributorServiceImpl implements DistributorService {
	
    @Autowired
    private DistributorDOMapper distributorDOMapper;
    @Autowired
    private DistributorDOCustomMapper distributorDOCustomMapper;
    
    
    
    public List<DistributorDO> queryDistributorDOList(DistributorQuery query) {
      
    	return distributorDOCustomMapper.selectDistributorDOList(query);
    }
    
    public long queryDistributorDOListCount(DistributorQuery query) {
		return distributorDOCustomMapper.selectDistributorDOListCount(query);
	}
    
    public DistributorDO queryDistributorDOById(long id) {
        return distributorDOMapper.selectByPrimaryKey(id);
    }

    
    public boolean editDistributorDO(DistributorDO distributorDO) {
        return distributorDOMapper.updateByPrimaryKeySelective(distributorDO) > 0;
    }

	
	public List<DistributorDO> queryDistributorDOAll() throws Exception{
		DistributorDOExample example = new DistributorDOExample();
		DistributorDOExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(0);
		return distributorDOMapper.selectByExample(example);
	}

	public List<DistributorDO> queryDistributorDOByDeviceNo(String deviceNo) {
		DistributorDOExample example = new DistributorDOExample();
		DistributorDOExample.Criteria criteria = example.createCriteria();
		criteria.andProvinceNotEqualTo(deviceNo);
		criteria.andStatusEqualTo(0);
        return distributorDOMapper.selectByExample(example);
	}

	
	public List<DistributorDO> queryDistributorDOByNameLike(String distributorName)
			throws Exception {
		
		DistributorDOExample example = new DistributorDOExample();
		DistributorDOExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(0);
		if (StringUtils.isNotBlank(distributorName)) {
			distributorName = "%" + distributorName + "%";
		}
		if (StringUtils.isNotBlank(distributorName)) {
			criteria.andNameLike(distributorName);
		}  
		return distributorDOMapper.selectByExample(example);
	}

    
    
	public List<DistributorDO> selectDistributorDOByUserId(long sysUserId) {

		DistributorDOExample example = new DistributorDOExample();
		DistributorDOExample.Criteria criteria = example.createCriteria();
		criteria.andSysUserIdEqualTo(sysUserId);
		criteria.andStatusEqualTo(0);
		return distributorDOMapper.selectByExample(example);
	}


	public boolean insertDistributorDO(DistributorDO distributorDO)
			throws Exception {
		return distributorDOCustomMapper.insertDistributorDO(distributorDO) >0;
	}
}
