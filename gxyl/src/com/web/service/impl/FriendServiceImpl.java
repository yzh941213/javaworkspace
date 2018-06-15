package com.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.Model;
import com.web.dao.IFriendDao;
import com.web.entity.Friend;
import com.web.service.IFriendService;

public class FriendServiceImpl implements IFriendService {
	private IFriendDao friendDao;
	
	public void setFriendDao(IFriendDao friendDao) {
		this.friendDao = friendDao;
	}

	public Friend create(Friend friend) {
		int result=friendDao.create(friend);
		if(result!=0){
			return getFriendByID(friend.getFriendAutoid());
		}
		return null;
	}

	public int delete(Integer friendAutoid) {
		return friendDao.delete(friendAutoid);
	}

	public Friend getFriendByID(Integer friendAutoid) {
		return friendDao.getFriendByID(friendAutoid);
	}

	public List<Friend> getFriendByNum(int number) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("number", number);
		return friendDao.getFriendByNum(map);
	}

	public Model<Friend> getFriendByPage(int pageindex, int pagesize) {
		pageindex=(pageindex-1)*pagesize;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		List<Friend> list=friendDao.getFriendByPage(map);
		int count=friendDao.getCount(map);
		Model<Friend> model=new Model<Friend>(list, count);
		return model;
	}

	public int modify(Friend friend) {
		return friendDao.modify(friend);
	}

}
