package com.zhezhuo.biz.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.UsersDAO;
import com.zhezhuo.biz.manager.impl.SendMsgManagerImpl;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.MemberDO;
import com.zhezhuo.model.entity.UsersDO;
import com.zhezhuo.model.query.MemberQuery;
import com.zhezhuo.model.query.UsersQuery;

/**
 * Created by 蝈蝈 on 2016/9/19.
 */
public class UsersDAOImpl extends BaseDAO implements UsersDAO {

	public List<UsersDO> queryUserDOList(UsersQuery query) {
		return null;
	}

	public int queryUserDOListCount(UsersQuery query) {
		return 0;
	}

	public UsersDO queryUserDOById(long userId) {
		return null;
	}

	public List<UsersDO> querySubordinate(long userId) {
		return null;
	}

	public UsersDO queryUserDOByInviteCode(String inviteCode) {
		return null;
	}

	public UsersDO queryParent(long parentId) {
		return null;
	}

	public Integer operateUserDO(UsersDO usersDO) {
		return null;
	}

	public Integer updateInvitCode(UsersDO usersDO) {
		return null;
	}

	public Result<Long> addUsersDO(List<UsersDO> usersDOS) throws Exception {
		return null;
	}

	public int querySubordinateCount(long userId) {
		return 0;
	}

	public String queryParentName(long parentId) {
		return null;
	}

	public List<String> queryAndroidClientId() {
		return null;
	}

	public List<String> queryIOSClientId() {
		return null;
	}

	public Long queryUsersCount() {
		return null;
	}

	public Long queryUsersCountByDistributor(Long id) {
		return null;
	}

	public Long queryUsersCountByShop(Long shopsId) {
		return null;
	}

	public Long queryUsersCountByMaker(Long id) {
		return null;
	}

	public List<UsersDO> selectUserDOlist(UsersQuery query) {
		return null;
	}

	public List<MemberDO> selectMemberList(MemberQuery memberQuery) throws Exception {
		return null;
	}

	public MemberDO selectMemberDOByUserId(int userId) throws Exception {
		return null;
	}
}
