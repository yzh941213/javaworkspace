package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.Reply;

public interface IReplyDao {
	Reply getReplyByID(Integer replyAutoid);
	List<Reply> getReplyByPage(Map<String, Object> map);
	int getCount(Map<String, Object> map);
	int create(Reply reply);
	
	int deleteByComments(int commentsAutoid);
	
	int delete(int[] autoids);
	int modify(Reply reply);
}
