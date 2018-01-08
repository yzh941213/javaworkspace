package com.zhezhuo.biz.manager.impl;

import com.zhezhuo.biz.dao.RebateDAO;
import com.zhezhuo.biz.manager.RebateManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.RebateDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Shaka on 15/6/10.
 */
public class RebateManagerImpl implements RebateManager {

    @Autowired
    RebateDAO rebateDAO;

    @Override
    public Result<Long> createRebateDO(RebateDO rebateDO) {
        Result<Long> result = new Result<Long>();
        try {
            Long id = rebateDAO.createRebateDO(rebateDO);
            if (id.longValue() > 0) {
                result.setSuccess(true);
                result.setSuccessInfo("添加成功");
                result.setResult(id);
                return result;
            }
            result.setSuccess(false);
            result.setErrorInfo("添加失败");
            result.setResult(-1l);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setErrorInfo("添加失败");
            result.setResult(-1l);
            return result;
        }
    }

    @Override
    public Result<List<RebateDO>> queryRebates() {
        Result<List<RebateDO>> result = new Result<List<RebateDO>>();
        try {
            List<RebateDO> list = rebateDAO.queryRebates();
            result.setSuccess(true);
            result.setSuccessInfo("查询成功");
            result.setResult(list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setErrorInfo("查询失败");
            result.setResult(null);
            return result;
        }
    }

    @Override
    public Result<Integer> updateRebate(RebateDO rebateDO) {
        Result<Integer> result = new Result<Integer>();
        try {
            Integer id = rebateDAO.updateRebate(rebateDO);
            if (id.intValue() > 0) {
                result.setSuccess(true);
                result.setSuccessInfo("编辑成功");
                result.setResult(id);
                return result;
            }
            result.setSuccess(false);
            result.setErrorInfo("编辑失败");
            result.setResult(-1);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setErrorInfo("编辑失败");
            result.setResult(-1);
            return result;
        }
    }
}
