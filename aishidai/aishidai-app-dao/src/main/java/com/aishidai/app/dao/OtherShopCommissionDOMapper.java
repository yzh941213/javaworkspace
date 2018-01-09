package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.OtherShopCommissionDO;
import com.aishidai.app.model.pojo.OtherShopCommissionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtherShopCommissionDOMapper {
    int countByExample(OtherShopCommissionDOExample example);

    int deleteByExample(OtherShopCommissionDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(OtherShopCommissionDO record);

    int insertSelective(OtherShopCommissionDO record);

    List<OtherShopCommissionDO> selectByExample(OtherShopCommissionDOExample example);

    OtherShopCommissionDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OtherShopCommissionDO record, @Param("example") OtherShopCommissionDOExample example);

    int updateByExample(@Param("record") OtherShopCommissionDO record, @Param("example") OtherShopCommissionDOExample example);

    int updateByPrimaryKeySelective(OtherShopCommissionDO record);

    int updateByPrimaryKey(OtherShopCommissionDO record);
}