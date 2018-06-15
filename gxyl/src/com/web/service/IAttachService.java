package com.web.service;

import java.util.List;

import com.web.entity.Attach;

public interface IAttachService {
	List<Attach> getAttach(Integer newsAutoid);
}
