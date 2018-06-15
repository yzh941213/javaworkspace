package com.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.Model;
import com.common.Tools;
import com.web.dao.IReplyDao;
import com.web.entity.Reply;
import com.web.service.IReplyService;

public class ReplyServiceImpl implements IReplyService {
	private IReplyDao replyDao;
	
	public void setReplyDao(IReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	public Reply create(Reply reply) {
		int result=replyDao.create(reply);
		return getReplyByID(reply.getReplyAutoid());
	}

	public Reply getReplyByID(Integer replyAutoid) {
		return replyDao.getReplyByID(replyAutoid);
	}

	public Model<Reply> getReplyByPage(int pageindex, int pagesize, Integer commentsAutoid) {
		pageindex=(pageindex-1)*pagesize;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("commentsAutoid", commentsAutoid);
		List<Reply> list=replyDao.getReplyByPage(map);
		int count=replyDao.getCount(map);
		return new Model<Reply>(list, count);
	}

	public int delete(String autoids) {
		int[] ids=Tools.toArray(autoids, ",");
		return replyDao.delete(ids);
	}

	public int modify(Reply reply) {
		
		return replyDao.modify(reply);
	}

}
