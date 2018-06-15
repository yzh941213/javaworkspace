package com.web.service.impl;

import java.util.List;

import com.web.dao.IAttachDao;
import com.web.entity.Attach;
import com.web.service.IAttachService;

public class AttachServiceImpl implements IAttachService {
	private IAttachDao attachDao;
	
	public void setAttachDao(IAttachDao attachDao) {
		this.attachDao = attachDao;
	}

	public List<Attach> getAttach(Integer newsAutoid) {
		return attachDao.getAttach(newsAutoid);
	}

}
