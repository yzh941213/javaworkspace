package com.aishidai.app.service.impl;

import com.zhezhuo.biz.dao.AttributeDAO;
import com.zhezhuo.biz.manager.AttributeManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.AttributeDO;
import com.zhezhuo.model.query.AttributeQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class AttributeServiceImpl implements AttributeManager {
    @Autowired
    private AttributeDAO attributeDAO;

    
    public Result<List<AttributeDO>> queryAttributeDOList(AttributeQuery query) {
        Result<List<AttributeDO>> result = null;
        try {
            List<AttributeDO> list = attributeDAO.queryAttributeDOList(query);
            result = new Result<List<AttributeDO>>();
            if (list.isEmpty() || list == null) {
                list = new ArrayList<AttributeDO>();
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

    
    public Result<AttributeDO> queryAttributeDOById(long attributeId) {
        Result<AttributeDO> result = null;
        try {
            AttributeDO attributeDO = attributeDAO.queryAttributeDOById(attributeId);

            result = new Result<AttributeDO>();
            if (attributeDO == null) {
                attributeDO = new AttributeDO();
            } else {
                AttributeDO secondAttrDO = attributeDAO.queryAttributeDOById(attributeDO.getAttributeId());
                attributeDO.setFirstId(secondAttrDO.getParentId());
            }
            result.setSuccess(true);
            result.setResult(attributeDO);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(true);
            result.setErrorInfo(e.getMessage());
            return result;
        }
        return result;
    }

    
    public Result<Long> editAttributeDO(AttributeDO attributeDO) {
        Result<Long> result = null;
        try {
            long row = attributeDAO.editAttributeDO(attributeDO);
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

    
    public Result<Integer> updateAttributeStatus(AttributeDO attributeDO) {
        Result<Integer> result = null;
        try {
            int row = attributeDAO.updateAttributeDOStatus(attributeDO);
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

    
    public Result<List<AttributeDO>> queryAttributeDOByParentId(long parentId) {
        Result<List<AttributeDO>> result = null;
        try {
            List<AttributeDO> list = attributeDAO.queryAttributeDOByParentId(parentId);
            result = new Result<List<AttributeDO>>();
            if (list.isEmpty() || list == null) {
                list = new ArrayList<AttributeDO>();
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


}
