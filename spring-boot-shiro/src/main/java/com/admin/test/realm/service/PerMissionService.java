package com.admin.test.realm.service;

import org.apache.shiro.authz.Permission;

public interface PerMissionService {

    Permission createPermission(Permission permission);

    void deletePermission(Long permissionId);
}
