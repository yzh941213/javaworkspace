package com.aishidai.app.service;

import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.UsersListDTO;
import com.zhezhuo.model.entity.MemberDO;
import com.zhezhuo.model.entity.UsersDO;
import com.zhezhuo.model.query.MemberQuery;
import com.zhezhuo.model.query.UsersQuery;

/**
 * Created by 蝈蝈 on 2016/9/19.
 */
public interface UsersService {

    Result<List<UsersListDTO>> queryUsersDOList(UsersQuery query);

    Result<UsersListDTO> queryUsersDOById(long userId);

    Result<Integer> operatUsersDO(UsersDO usersDO);

    Result<Long> addUsersDOS(List<UsersDO> usersDOs);

	List<UsersDO> queryUserDOlist(UsersQuery query) throws Exception;

	List<MemberDO> queryMemberList(MemberQuery memberQuery) throws Exception;
	
	MemberDO queryMemberDOByUserId(int userId) throws Exception;
}
