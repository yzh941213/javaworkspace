package com.web.service;

import java.util.List;

import com.common.Model;
import com.web.entity.Friend;

public interface IFriendService {
	Friend getFriendByID(Integer friendAutoid);
	List<Friend> getFriendByNum(int number);
	Model<Friend> getFriendByPage(int pageindex, int pagesize);
	Friend create(Friend friend);
	int delete(Integer friendAutoid);
	int modify(Friend friend);
}
