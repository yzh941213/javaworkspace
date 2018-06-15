package com.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.Model;
import com.common.Tools;
import com.web.dao.ICommentsDao;
import com.web.dao.IReplyDao;
import com.web.entity.Comments;
import com.web.service.ICommentsService;

public class CommentsServiceImpl implements ICommentsService {
	private ICommentsDao commentsDao;

	public void setCommentsDao(ICommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}

	private IReplyDao replyDao;

	public void setReplyDao(IReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	public Comments create(Comments comments) {
		int r=commentsDao.create(comments);
		return getCommentsByID(comments.getCommentsAutoid());
	}

	public Model<Comments> getCommentsByPage(int pageindex, int pagesize) {
		pageindex=(pageindex-1)*pagesize;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		List<Comments> list=commentsDao.getCommentsByPage(map);
		int count=commentsDao.getCount(map);
		return new Model<Comments>(list, count);
	}

	public Comments getCommentsByID(Integer commentsAutoid) {
		return commentsDao.getCommentsByID(commentsAutoid);
	}

	public int delete(String autoids) {
		int[] ids=Tools.toArray(autoids, ",");
		if(ids != null){
			for(int commentsAutoid:ids)
				replyDao.deleteByComments(commentsAutoid);
		}
		return commentsDao.delete(ids);
	}

	public int modify(Comments comments) {
		return commentsDao.modify(comments);
	}

	public Model<Comments> getCommentByTitle(int pageindex, int pagesize,
			String title) {
		pageindex=(pageindex-1)*pagesize;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("title", title);
		List<Comments> list=commentsDao.getCommentByTitle(map);
		int count=commentsDao.getCountByTitle(map);
		return new Model<Comments>(list, count);
	}

}
