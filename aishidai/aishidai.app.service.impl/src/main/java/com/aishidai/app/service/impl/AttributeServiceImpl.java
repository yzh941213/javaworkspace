package com.aishidai.app.service.impl;

import com.aishidai.app.dao.AttributeDOCustomMapper;
import com.aishidai.app.dao.AttributeDOMapper;
import com.aishidai.app.model.message.ResultMessage;
import com.aishidai.app.model.pojo.AttributeDO;
import com.aishidai.app.model.pojo.AttributeDOExample;
import com.aishidai.app.model.query.QueryAttrbute;

import com.aishidai.app.model.vo.AttributeDetailsVo;
import com.aishidai.app.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.*;

@Service
public class AttributeServiceImpl implements AttributeService {
    public List<AttributeDO> getAll() {
        return attributeDOCustomMapper.getAll();
    }

    public List<AttributeDO> queryList(QueryAttrbute queryAttrbute) {
        return attributeDOCustomMapper.queryList(queryAttrbute);
    }

    @Transactional
    public Boolean del(Long attributeId) {
      List<AttributeDO> list=  getAllSubclassByAttrId(attributeId);
      for (AttributeDO attributeDO:list){
          attributeDO.setStatus(1);
          attributeDOMapper.updateByPrimaryKeySelective(attributeDO);
      }
        AttributeDO attr=new AttributeDO();
        attr.setAttributeId(attributeId);
        attr.setStatus(1);
        attributeDOMapper.updateByPrimaryKeySelective(attr);
        attributeDOMapper.selectByPrimaryKey(attributeId);
        return true;
    }

    public List<AttributeDO> queryByObj(QueryAttrbute queryAttrbute) {
        return attributeDOCustomMapper.queryByObj(queryAttrbute);
    }
   public List<AttributeDO>  getByParentId(Integer parentId){
       QueryAttrbute queryAttrbute=new QueryAttrbute();
       queryAttrbute.setParentId(parentId);
      return attributeDOCustomMapper.queryByObj(queryAttrbute);
    }
    public AttributeDetailsVo getDetailsById(Long attributeId) {
        AttributeDetailsVo attributeDetailsVo=new AttributeDetailsVo();
        AttributeDO attributeDO=  attributeDOMapper.selectByPrimaryKey(attributeId);
        Map<Long,List<AttributeDO>> parentArray=new HashMap<Long, List<AttributeDO>>();
        List<Integer> list=new ArrayList<Integer>();
        list.add(Integer.valueOf(attributeId+""));
        parentArray.put(Long.valueOf(attributeId) ,getByParentId(Integer.valueOf(attributeId+"") ));
        Integer parentId=attributeDO.getParentId();
        while (parentId!=0){
            AttributeDO parenAttr=attributeDOMapper.selectByPrimaryKey(Long.valueOf(parentId));
            list.add(parentId);
            parentArray.put(Long.valueOf(parentId) ,getByParentId(parentId));
            parentId=   parenAttr.getParentId();
        }

        attributeDetailsVo.setParentArray(parentArray);
        attributeDetailsVo.setParentIdArray(list);
        attributeDetailsVo.setAttributeId(attributeDO.getAttributeId());
        attributeDetailsVo.setAttrName(attributeDO.getAttrName());

        attributeDetailsVo.setDescription(attributeDO.getDescription());

        attributeDetailsVo.setHot(attributeDO.getHot());

        attributeDetailsVo.setParentId(attributeDO.getParentId());

        attributeDetailsVo.setImgPath(attributeDO.getImgPath());

        attributeDetailsVo.setCategory(attributeDO.getCategory());

        attributeDetailsVo.setDeviceShop(attributeDO.getDeviceShop());
        attributeDetailsVo.setStratification(attributeDO.getStratification());
        return attributeDetailsVo;
    }

    public Long queryListCount(QueryAttrbute queryAttrbute) {
        return attributeDOCustomMapper.queryListCount(queryAttrbute);
    }

    @Autowired
    AttributeDOMapper attributeDOMapper;

    @Autowired
    AttributeDOCustomMapper attributeDOCustomMapper;
    public List<AttributeDO> getAllSubclassByAttrId(Long attributeId) {


        return attributeDOCustomMapper.getAllSubclassByAttrId(attributeId);
    }

    public Boolean update(AttributeDO attributeDO) {
        //更新的时候 本级  不能挂在 子级下
        List<AttributeDO> list= getAllSubclassByAttrId(attributeDO.getAttributeId());
        for (AttributeDO attributeDO1:list){

                Assert.isTrue(!attributeDO1.getParentId().equals(attributeDO.getParentId()), ResultMessage.ATTR_UPDATE_ERROR);


        }
        return attributeDOMapper.updateByPrimaryKeySelective(attributeDO)>0;
    }

    public AttributeDO getById(Long attributeId) {
        return attributeDOMapper.selectByPrimaryKey(attributeId);
    }

    public Boolean add(AttributeDO attributeDO) {
        attributeDO.setCreated(new Date());
        attributeDO.setUpdated(new Date());
        attributeDO.setStatus(0);
        attributeDO.setStratification(0);
        attributeDO.setDeviceShop(0);//默认不显示
        attributeDO.setHot(1);//默认不推
        AttributeDOExample attributeDOExample=new AttributeDOExample();
        attributeDOExample.createCriteria().andAttrNameEqualTo(attributeDO.getAttrName()).andParentIdEqualTo(attributeDO.getParentId());

        Assert.isTrue(attributeDOMapper.selectByExample(attributeDOExample).size()==0, ResultMessage.ATTR_NAME_REPEAT);


        return attributeDOMapper.insert(attributeDO)>0;
    }
}
