package com.zhezhuo.biz.dao;


import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.MemberDO;
import com.zhezhuo.model.entity.UsersDO;
import com.zhezhuo.model.query.MemberQuery;
import com.zhezhuo.model.query.UsersQuery;

/**
 * Created by 蝈蝈 on 2016/9/19.
 */
public interface UsersDAO {

    List<UsersDO> queryUserDOList(UsersQuery query);

    int queryUserDOListCount(UsersQuery query);

    UsersDO queryUserDOById(long userId);

    List<UsersDO> querySubordinate(long userId);

    UsersDO queryUserDOByInviteCode(String inviteCode);

    UsersDO queryParent(long parentId);

    Integer operateUserDO(UsersDO usersDO);

    Integer updateInvitCode(UsersDO usersDO);

    Result<Long> addUsersDO(List<UsersDO> usersDOS) throws Exception;

    int querySubordinateCount(long userId);

    String queryParentName(long parentId);

    List<String> queryAndroidClientId();

    List<String> queryIOSClientId();

	Long queryUsersCount();

	Long queryUsersCountByDistributor(Long id);

	Long queryUsersCountByShop(Long shopsId);

	Long queryUsersCountByMaker(Long id);

	List<UsersDO> selectUserDOlist(UsersQuery query);

	List<MemberDO> selectMemberList(MemberQuery memberQuery) throws Exception;
	
	MemberDO selectMemberDOByUserId(int userId) throws Exception;
}
