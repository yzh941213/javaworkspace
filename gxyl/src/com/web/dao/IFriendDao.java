package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.Friend;

public interface IFriendDao {
	Friend getFriendByID(Integer friendAutoid);
	List<Friend> getFriendByNum(Map<String, Object> map);
	List<Friend> getFriendByPage(Map<String, Object> map);
	int getCount(Map<String, Object> map);
	int create(Friend friend);
	int delete(Integer friendAutoid);
	int modify(Friend friend);
}
