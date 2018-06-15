package com.web.dao;

import java.util.List;

import com.web.entity.Attach;

public interface IAttachDao {
	List<Attach> getAttach(Integer newsAutoid);
	int create(List<Attach> list);
	int delete(Integer newsAutoid);
}
