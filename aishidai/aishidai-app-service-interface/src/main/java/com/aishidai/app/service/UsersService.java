package com.aishidai.app.service;


import org.springframework.stereotype.Service;

import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.dto.UsersListDTO;

@Service
public interface UsersService {

    /*Result<List<UsersListDTO>> queryUsersDOList(UsersQuery query);*/

    Result<UsersListDTO> queryUsersDOById(int userId);

    Result<Integer> operatUsersDO(UsersDO usersDO);

   /* Result<Long> addUsersDOS(List<UsersDO> usersDOs);

	List<UsersDO> queryUserDOlist(UsersQuery query) throws Exception;
	
	MemberDO queryMemberDOByUserId(int userId) throws Exception;*/
}
