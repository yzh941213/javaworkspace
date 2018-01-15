package com.aishidai.app.model.vo;

import com.aishidai.app.model.pojo.AttributeDO;

import java.util.List;
import java.util.Map;

public class AttributeDetailsVo extends AttributeDO {

   private  Map<Long,List<AttributeDO>> parentArray;

   public Map<Long, List<AttributeDO>> getParentArray() {
      return parentArray;
   }

   public void setParentArray(Map<Long, List<AttributeDO>> parentArray) {
      this.parentArray = parentArray;
   }
   List<Integer> parentIdArray;

   public List<Integer> getParentIdArray() {
      return parentIdArray;
   }

   public void setParentIdArray(List<Integer> parentIdArray) {
      this.parentIdArray = parentIdArray;
   }
}
