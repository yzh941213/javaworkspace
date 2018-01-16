package com.aishidai.app.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.dto.UsersListDTO;
import com.aishidai.app.model.pojo.MemberDO;
import com.aishidai.app.model.pojo.UsersDO;
import com.aishidai.app.model.query.UsersQuery;

@Service
public interface UsersService {

    UsersListDTO queryUsersDOById(long userId);

    boolean editUsersDO(UsersDO usersDO);

	List<UsersDO> queryAll();

    Long addUsersDOS(List<UsersDO> usersDOs);

	List<UsersDO> queryUserDOlist(UsersQuery query) throws Exception;
	
	MemberDO queryMemberDOByUserId(int userId) throws Exception;

	List<MemberDO> queryMemberAll();

	MemberDO queryMemberDOByUserId(Long userId);
}
