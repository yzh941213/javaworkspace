package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ServicesDO;
import com.aishidai.app.model.pojo.ServicesDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServicesDOMapper {
    int countByExample(ServicesDOExample example);

    int deleteByExample(ServicesDOExample example);

    int deleteByPrimaryKey(Long serviceId);

    int insert(ServicesDO record);

    int insertSelective(ServicesDO record);

    List<ServicesDO> selectByExample(ServicesDOExample example);

    ServicesDO selectByPrimaryKey(Long serviceId);

    int updateByExampleSelective(@Param("record") ServicesDO record, @Param("example") ServicesDOExample example);

    int updateByExample(@Param("record") ServicesDO record, @Param("example") ServicesDOExample example);

    int updateByPrimaryKeySelective(ServicesDO record);

    int updateByPrimaryKey(ServicesDO record);
}