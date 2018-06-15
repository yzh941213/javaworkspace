package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.Comments;

public interface ICommentsDao {
	Comments getCommentsByID(Integer commentsAutoid);
	int create(Comments comments);
	List<Comments> getCommentsByPage(Map<String, Object> map);
	int getCount(Map<String, Object> map);
	
	int modify(Comments comments);
	int delete(int[] autoids);
	
	List<Comments> getCommentByTitle(Map<String, Object> map);
	int getCountByTitle(Map<String, Object> map);
	
}
