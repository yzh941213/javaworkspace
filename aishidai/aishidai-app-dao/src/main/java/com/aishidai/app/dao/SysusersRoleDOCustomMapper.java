package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.SysusersRoleDO;

public interface SysusersRoleDOCustomMapper {
    
    
    long isSuperAdmin(String userId);
    
    long insertSysusersRoleDO(SysusersRoleDO record);
    
}