package com.web.service;

import com.common.Model;
import com.web.entity.Reply;

public interface IReplyService {
	Reply getReplyByID(Integer replyAutoid);
	Model<Reply> getReplyByPage(int pageindex, int pagesize, Integer commentsAutoid);
	Reply create(Reply reply);
	
	int delete(String autoids);
	int modify(Reply reply);
}
