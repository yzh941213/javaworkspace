package com.zhezhuo.biz.manager.impl;

import com.zhezhuo.biz.dao.MakerDAO;
import com.zhezhuo.biz.manager.MakerManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.DeviceMakerDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.query.DeviceMakerQuery;
import com.zhezhuo.model.query.MakerQuery;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class MakerManagerImpl implements MakerManager {
	@Autowired
	private MakerDAO makerDAO;

	@Override
	public Result<List<MakerDO>> queryMakerDOList(MakerQuery query) {
		Result<List<MakerDO>> result = null;
		try {
			List<MakerDO> list = makerDAO.queryMakerDOList(query);
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

	@Override
	public Result<MakerDO> queryMakerDOById(long makerId) {
		Result<MakerDO> result = null;
		try {
			MakerDO makerDO = makerDAO.queryMakerDOById(makerId);

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

	@Override
	public Result<Long> editMakerDO(MakerDO makerDO) {
		Result<Long> result = null;
		try {
			long row = makerDAO.editMakerDO(makerDO);
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

	@Override
	public Result<Integer> updateMakerStatus(MakerDO makerDO) {
		Result<Integer> result = null;
		try {
			int row = makerDAO.updateMakerDOStatus(makerDO);
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

	@Override
	public Result<List<MakerDO>> queryMakerDOByDistributorId(long distributorId) {
		Result<List<MakerDO>> result = null;
		try {
			List<MakerDO> list = makerDAO.queryMakerDOByDistributorId(distributorId);
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

	@Override
	public Result<Long> updateMakerSysUserId(MakerDO makerDO) {
		Result<Long> result = null;
		try {
			Long row = makerDAO.updateMakerDOSysUserId(makerDO);
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

	@Override
	public Result<MakerDO> queryMakerDOBySysUserId(Long sysUserId) {
		Result<MakerDO> result = null;
		try {
			MakerDO makerDO = makerDAO.queryMakerDOBySysUserId(sysUserId);
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

	@Override
	public Result<List<MakerDO>> queryMakerDOAll(MakerQuery query) {
		Result<List<MakerDO>> result = null;
        try {
            List<MakerDO> list = makerDAO.queryMakerDOAll(query);
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
	@Override
	public Result<Integer> updateMakerAudit(MakerDO makerDO) {
		Result<Integer> result = null;
		try {
			int row = makerDAO.updateMakerDOAudit(makerDO);
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

	@Override
	public List<MakerDO> queryMakerDOByNameLike(MakerDO makerDO) throws Exception {
		// TODO Auto-generated method stub
		return makerDAO.selectMakerDOByNameLike(makerDO);
	}

	@Override
	public boolean addDeviceMaker(List<DeviceMakerDO> list,long sysUserId,long makerId) throws Exception {
		// TODO Auto-generated method stub
		DeviceMakerDO deviceMakerDO = new DeviceMakerDO();
		long result_row = 0;
		if (makerId == 0) {
			for (int i = 0; i < list.size(); i++) {
				deviceMakerDO = list.get(i);
				deviceMakerDO.setCreateId(sysUserId);
				deviceMakerDO.setDeleteIs(0);
				result_row = makerDAO.insetDeviceMaker(deviceMakerDO);
			}
		}else{
			DeviceMakerQuery query = new DeviceMakerQuery();
			query.setMakerId(makerId);
			List<DeviceMakerDO> list_maker = makerDAO.selectDeviceMaker(query);
			for (int i = 0; i < list_maker.size(); i++) {
				makerDAO.delDeviceMaker(list_maker.get(i));
			}
			for (int i = 0; i < list.size(); i++) {
				deviceMakerDO = list.get(i);
				deviceMakerDO.setCreateId(sysUserId);
				deviceMakerDO.setDeleteIs(0);
				deviceMakerDO.setMakerId(makerId);
				result_row = makerDAO.insetDeviceMaker(deviceMakerDO);
			}
		}
		return result_row == 0 ? false:true;
	}

	@Override
	public List<DeviceMakerDO> queryDeviceMaker(DeviceMakerQuery query_maker)
			throws Exception {
		// TODO Auto-generated method stub
		return makerDAO.selectDeviceMaker(query_maker);
	}
	
}
