package com.web.service;

import com.common.Model;
import com.web.entity.Comments;

public interface ICommentsService {
	Comments getCommentsByID(Integer commentsAutoid);
	Comments create(Comments comments);
	Model<Comments> getCommentsByPage(int pageindex, int pagesize);
	
	int modify(Comments comments);
	
	int delete(String autoids);
	
	Model<Comments> getCommentByTitle(int pageindex, int pagesize,String title);
}
