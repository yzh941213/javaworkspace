package com.aishidai.app.service;



import org.springframework.stereotype.Service;

import com.aishidai.app.model.dto.UsersListDTO;
import com.aishidai.app.model.pojo.UsersDO;

@Service
public interface UsersService {

    /*Result<List<UsersListDTO>> queryUsersDOList(UsersQuery query);*/

    UsersListDTO queryUsersDOById(long userId);

    boolean operatUsersDO(UsersDO usersDO);

   /* Result<Long> addUsersDOS(List<UsersDO> usersDOs);

	List<UsersDO> queryUserDOlist(UsersQuery query) throws Exception;
	
	MemberDO queryMemberDOByUserId(int userId) throws Exception;*/
}
