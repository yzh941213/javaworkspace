package com.aishidai.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.DistributorDOMapper;
import com.aishidai.app.service.DistributorService;

@Service
public class DistributorServiceImpl implements DistributorService {
    @Autowired
    private DistributorDOMapper distributorDOMapper;

  /*  
    public Result<List<DistributorDO>> queryDistributorDOList(DistributorQuery query) {
        Result<List<DistributorDO>> result = null;
        try {
            List<DistributorDO> list = distributorDOMapper.queryDistributorDOList(query);
            result = new Result<List<DistributorDO>>();
            if (list.isEmpty() || list == null) {
                list = new ArrayList<DistributorDO>();
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

    
    public Result<DistributorDO> queryDistributorDOById(long distributorId) {
        Result<DistributorDO> result = null;
        try {
            DistributorDO distributorDO = distributorDOMapper.queryDistributorDOById(distributorId);

            result = new Result<DistributorDO>();
            result.setSuccess(true);
            result.setResult(distributorDO);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(true);
            result.setErrorInfo(e.getMessage());
            return result;
        }
        return result;
    }

    
    public Result<Long> editDistributorDO(DistributorDO distributorDO) {
        Result<Long> result = null;
        try {
            long row = distributorDOMapper.editDistributorDO(distributorDO);
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

    
    public Result<Integer> updateDistributorStatus(DistributorDO distributorDO) {
        Result<Integer> result = null;
        try {
            int row = distributorDOMapper.updateDistributorDOStatus(distributorDO);
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

	
	public Result<Long> updateDistributorSysUserId(DistributorDO distributorDO) {
		Result<Long> result = null;
        try {
            Long row = distributorDOMapper.updateDistributorDOSysUserId(distributorDO);
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

	
	

	
	public Result<List<DistributorDO>> queryDistributorDOAll(DistributorQuery query) {
		Result<List<DistributorDO>> result = null;
        try {
            List<DistributorDO> list = distributorDOMapper.queryDistributorDOAll(query);
            result = new Result<List<DistributorDO>>();
            if (list.isEmpty() || list == null) {
                list = new ArrayList<DistributorDO>();
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

	
	public Result<DistributorDO> queryDistributorDOByDeviceNo(String deviceNo) {
		Result<DistributorDO> result = null;
        try {
            DistributorDO distributorDO = distributorDOMapper.queryDistributorDOByDeviceNo(deviceNo);
            result = new Result<DistributorDO>();
            result.setSuccess(true);
            result.setResult(distributorDO);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(true);
            result.setErrorInfo(e.getMessage());
            return result;
        }
        return result;
	}

	
	public List<DistributorDO> queryDistributorDOByNameLike(String name)
			throws Exception {
		// TODO Auto-generated method stub
		return distributorDOMapper.selectDistributorDOByNameLike(name);
	}
*/
    
    
	public List<DistributorDO> queryDistributorDOBySysUserId(long sysUserId) {

		DistributorDOExample example = new DistributorDOExample();
		DistributorDOExample.Criteria criteria = example.createCriteria();
		criteria.andSysUserIdEqualTo(sysUserId);
		List<DistributorDO> list = distributorDOMapper.selectByExample(example);

		return list;
	}
	
	
}
