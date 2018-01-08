package com.aishidai.app.service.impl;

import com.zhezhuo.biz.dao.PropertyDAO;
import com.zhezhuo.biz.manager.PropertyManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.PropertyDO;
import com.zhezhuo.model.query.PropertyQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class PropertyServiceImpl implements PropertyManager {

    @Autowired
    private PropertyDAO propertyDAO;


    public Result<List<PropertyDO>> queryPropertyDOList(PropertyQuery query) {
        Result<List<PropertyDO>> result = new Result<List<PropertyDO>>();
        try {
            List<PropertyDO> list = propertyDAO.queryPropertyDOList(query);
            result.setResult(list);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrorInfo(e.getMessage());
            result.setSuccess(false);
            return result;
        }
        return result;
    }


    public Result<PropertyDO> queryPropertyDOById(long propertyId) {
        Result<PropertyDO> result = new Result<PropertyDO>();
        try {
            PropertyDO propertyDO = propertyDAO.queryPropertyDOById(propertyId);
            result.setResult(propertyDO);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrorInfo(e.getMessage());
            result.setSuccess(false);
            return result;
        }
        return result;
    }


    public Result<Integer> updatePropertyDOStatus(PropertyDO propertyDO) {
        Result<Integer> result = new Result<Integer>();
        try {
            int row = propertyDAO.updatePropertyDOStatus(propertyDO);
            result.setResult(row);
            result.setSuccess(true);
            if (row <= 0) {
                result.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrorInfo(e.getMessage());
            result.setSuccess(false);
            return result;
        }
        return result;
    }


    public Result<Long> editPropertyDO(PropertyDO propertyDO) {
        Result<Long> result = new Result<Long>();
        long row;
        try {
            if (propertyDO.getPropertyId() == 0) {
                row = propertyDAO.insertPropertyDO(propertyDO);
            } else {
                row = propertyDAO.updatePropertyDO(propertyDO);
            }
            result.setResult(row);
            result.setSuccess(true);
            if (row <= 0) {
                result.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrorInfo(e.getMessage());
            result.setSuccess(false);
            return result;
        }
        return result;
    }


	public Result<List<PropertyDO>> queryPropertyDOByParentId(long parentId) {
		Result<List<PropertyDO>> result = new Result<List<PropertyDO>>();
        try {
            List<PropertyDO> list = propertyDAO.queryPropertyDOByParentId(parentId);
            result.setResult(list);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrorInfo(e.getMessage());
            result.setSuccess(false);
            return result;
        }
        return result;
	}
}
