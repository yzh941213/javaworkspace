package com.zhezhuo.biz.dao.impl;

import com.zhezhuo.biz.dao.AttributeDAO;
import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.model.entity.AttributeDO;
import com.zhezhuo.model.query.AttributeQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class AttributeDAOImpl extends BaseDAO implements AttributeDAO {

    public List<AttributeDO> queryAttributeDOList(AttributeQuery query) throws Exception {
       // List<AttributeDO> list = super.getSqlMapClientTemplate().queryForList("attribute.queryAttributeDOList", query);
        //query.setTotalItem((Integer)super.getSqlMapClientTemplate().queryForObject("attribute.queryAttributeDOCount", query.getFlag()));
        return null;
    }


    public AttributeDO queryAttributeDOById(long attributeId) throws Exception {
      //  AttributeDO attributeDO = (AttributeDO) super.getSqlMapClientTemplate().queryForObject("attribute.queryAttributeDOById", attributeId);
        return null;
    }


    public long editAttributeDO(AttributeDO attributeDO) throws Exception {
     /*   long row = 0;
        if (attributeDO.getAttributeId() == 0) {
            row = (Long) super.getSqlMapClientTemplate().insert("attribute.createNewAttributeDO", attributeDO);
        } else {
            row = super.getSqlMapClientTemplate().update("attribute.updateAttributeDO", attributeDO);
        }*/
        return 1;
    }


    public int updateAttributeDOStatus(AttributeDO attributeDO) throws Exception {
       // int row = super.getSqlMapClientTemplate().update("attribute.updateAttributeDOStatus", attributeDO);
        return 1;
    }


    public List<AttributeDO> queryAttributeDOByParentId(long parentId) throws Exception {
       // List<AttributeDO> list =  super.getSqlMapClientTemplate().queryForList("attribute.queryAttributeDOByParentId", parentId);
        return null;
    }

   // @Override
    public String queryAttrNameById(long attributeId) {
       // String attrName = (String) super.getSqlMapClientTemplate().queryForObject("attribute.queryAttrNameById", attributeId);
      //  attrName = (attrName == null ? "" : attrName);
        return null;
    }
}
