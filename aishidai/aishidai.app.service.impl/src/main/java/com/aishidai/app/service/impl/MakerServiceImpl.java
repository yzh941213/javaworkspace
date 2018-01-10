package com.aishidai.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.MakerDOMapper;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.DeviceMakerDO;
import com.aishidai.app.model.pojo.MakerDO;
import com.aishidai.app.model.pojo.MakerDOExample;
import com.aishidai.app.model.query.DeviceMakerQuery;
import com.aishidai.app.model.query.MakerQuery;
import com.aishidai.app.service.MakerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MakerServiceImpl implements MakerService {
	@Autowired
	private MakerDOMapper makerDOMapper;

	
	public List<MakerDO> queryMakerDOList(MakerQuery query) {
		Result<List<MakerDO>> result = null;
		try {
			List<MakerDO> list = makerDOMapper.queryMakerDOList(query);
			result = new Result<List<MakerDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<MakerDO>();
			}
			result.setResult(list);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public MakerDO queryMakerDOById(long makerId) {
		Result<MakerDO> result = null;
		try {
			MakerDO makerDO = makerDOMapper.queryMakerDOById(makerId);

			result = new Result<MakerDO>();
			result.setSuccess(true);
			result.setResult(makerDO);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(true);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Long editMakerDO(MakerDO makerDO) {
		Result<Long> result = null;
		try {
			long row = makerDOMapper.editMakerDO(makerDO);
			result = new Result<Long>();
			result.setSuccess(true);
			result.setResult(row);
			if (row == 0) {
				result.setSuccess(false);
				result.setErrorInfo("数据操作失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Integer updateMakerStatus(MakerDO makerDO) {
		Result<Integer> result = null;
		try {
			int row = makerDOMapper.updateMakerDOStatus(makerDO);
			result = new Result<Integer>();
			if (row == 0) {
				result.setSuccess(false);
				return result;
			}
			result.setSuccess(true);
			result.setResult(row);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public List<MakerDO> queryMakerDOByDistributorId(long distributorId) {
		Result<List<MakerDO>> result = null;
		try {
			List<MakerDO> list = makerDOMapper.queryMakerDOByDistributorId(distributorId);
			result = new Result<List<MakerDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<MakerDO>();
			}
			result.setResult(list);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(true);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Long updateMakerSysUserId(MakerDO makerDO) {
		Result<Long> result = null;
		try {
			Long row = makerDOMapper.updateMakerDOSysUserId(makerDO);
			result = new Result<Long>();
			if (row == 0) {
				result.setSuccess(false);
				return result;
			}
			result.setSuccess(true);
			result.setResult(row);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	

	
	public List<MakerDO> queryMakerDOAll(MakerQuery query) {
		Result<List<MakerDO>> result = null;
        try {
            List<MakerDO> list = makerDOMapper.queryMakerDOAll(query);
            result = new Result<List<MakerDO>>();
            if (list.isEmpty() || list == null) {
                list = new ArrayList<MakerDO>();
            }
            result.setResult(list);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setErrorInfo(e.getMessage());
            return result;
        }
        return result;
	}
//审核
	
	public Integer updateMakerAudit(MakerDO makerDO) {
		Result<Integer> result = null;
		try {
			int row = makerDOMapper.updateMakerDOAudit(makerDO);
			result = new Result<Integer>();
			if (row == 0) {
				result.setSuccess(false);
				return result;
			}
			result.setSuccess(true);
			result.setResult(row);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public List<MakerDO> queryMakerDOByNameLike(MakerDO makerDO) throws Exception {
		// TODO Auto-generated method stub
		return makerDOMapper.selectMakerDOByNameLike(makerDO);
	}

	
	public boolean addDeviceMaker(List<DeviceMakerDO> list,long sysUserId,long makerId) throws Exception {
		// TODO Auto-generated method stub
		DeviceMakerDO deviceMakerDO = new DeviceMakerDO();
		long result_row = 0;
		if (makerId == 0) {
			for (int i = 0; i < list.size(); i++) {
				deviceMakerDO = list.get(i);
				deviceMakerDO.setCreateId(sysUserId);
				deviceMakerDO.setDeleteIs(0);
				result_row = makerDOMapper.insetDeviceMaker(deviceMakerDO);
			}
		}else{
			DeviceMakerQuery query = new DeviceMakerQuery();
			query.setMakerId(makerId);
			List<DeviceMakerDO> list_maker = makerDOMapper.selectDeviceMaker(query);
			for (int i = 0; i < list_maker.size(); i++) {
				makerDOMapper.delDeviceMaker(list_maker.get(i));
			}
			for (int i = 0; i < list.size(); i++) {
				deviceMakerDO = list.get(i);
				deviceMakerDO.setCreateId(sysUserId);
				deviceMakerDO.setDeleteIs(0);
				deviceMakerDO.setMakerId(makerId);
				result_row = makerDOMapper.insetDeviceMaker(deviceMakerDO);
			}
		}
		return result_row == 0 ? false:true;
	}

	
	public List<DeviceMakerDO> queryDeviceMaker(DeviceMakerQuery query_maker)
			throws Exception {
		// TODO Auto-generated method stub
		return makerDOMapper.selectDeviceMaker(query_maker);
	}
	
	
	public List<MakerDO> queryMakerDOBySysUserId(Long sysUserId) {
		
		MakerDOExample example = new MakerDOExample();
		MakerDOExample.Criteria criteria = example.createCriteria();
		criteria.andSysUserIdEqualTo(Integer.valueOf(sysUserId+""));
		List<MakerDO> list = makerDOMapper.selectByExample(example);
		return list;
	}
	
}
