package com.aishidai.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.ResourceDOCustomMapper;
import com.aishidai.app.dao.ResourceDOMapper;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.dto.ResourceDTO;
import com.aishidai.app.model.pojo.ResourceDO;
import com.aishidai.app.model.pojo.ResourceDOCustom;
import com.aishidai.app.model.pojo.ResourceDOExample;
import com.aishidai.app.service.ResourceService;


import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
	
    @Autowired
    private ResourceDOMapper resourceDOMapper;
    @Autowired
    private ResourceDOCustomMapper resourceDOCustomMapper;
    
    private static final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);


    
	public Result<List<ResourceDOCustom>> queryAllResource() {
		Result<List<ResourceDOCustom>> result = new Result<List<ResourceDOCustom>>();
		try {
			List<ResourceDOCustom> firstMenusAll = resourceDOCustomMapper
					.queryFirstMenu();

			for (ResourceDOCustom firstAll : firstMenusAll) {

				List<ResourceDOCustom> secMenusAll = resourceDOCustomMapper
						.queryAllMenuByParentId(firstAll.getId());
				for (ResourceDOCustom secAll : secMenusAll) {
					List<ResourceDOCustom> thirdMenusAll = resourceDOCustomMapper
							.queryAllMenuByParentId(secAll.getId());
					for (ResourceDOCustom thirdAll : thirdMenusAll) {

						List<ResourceDOCustom> fourthMenusAll = resourceDOCustomMapper
								.queryAllMenuByParentId(thirdAll.getId());
						thirdAll.setResourceDOList(fourthMenusAll);
					}
					secAll.setResourceDOList(thirdMenusAll);
				}
				firstAll.setResourceDOList(secMenusAll);
			}
			result.setResult(firstMenusAll);
			result.setSuccess(true);
			result.setSuccessInfo("查询成功");
			return result;
		} catch (Exception e) {
			result.setResult(null);
			result.setSuccess(false);
			result.setSuccessInfo("查询失败");
			return result;
		}
	}

    
	public Result<List<ResourceDOCustom>> queryAllResourceByRoleId(long roleId) {

		Result<List<ResourceDOCustom>> result = new Result<List<ResourceDOCustom>>();

		List<ResourceDTO> resourceDOList = resourceDOCustomMapper.queryResourceByRoleId(roleId);
		List<ResourceDOCustom> firstMenusAll = resourceDOCustomMapper.queryFirstMenu();

		for (ResourceDOCustom firstAll : firstMenusAll) {
			for (ResourceDTO resourceDTO : resourceDOList) {
				if (firstAll.getId().equals(resourceDTO.getId())) {
					firstAll.setIsTrue(1);
					firstAll.setRole_res_id(resourceDTO.getRole_res_id());
				}
			}
			
			List<ResourceDOCustom> secMenusAll = resourceDOCustomMapper.queryAllMenuByParentId(firstAll.getId());
			
			for (ResourceDOCustom secAll : secMenusAll) {
				for (ResourceDTO resourceDTO : resourceDOList) {
					if (secAll.getId().equals(resourceDTO.getId())) {
						secAll.setIsTrue(1);
						secAll.setRole_res_id(resourceDTO.getRole_res_id());
					}
				}
				List<ResourceDOCustom> thirdMenusAll = 
						resourceDOCustomMapper.queryAllMenuByParentId(secAll.getId());
				for (ResourceDOCustom thirdAll : thirdMenusAll) {
					for (ResourceDTO resourceDTO : resourceDOList) {
						if (thirdAll.getId().equals(resourceDTO.getId())) {
							thirdAll.setIsTrue(1);
							thirdAll.setRole_res_id(resourceDTO
									.getRole_res_id());
						}
					}
					
					
					List<ResourceDOCustom> fourthMenusAll = 
							resourceDOCustomMapper.queryAllMenuByParentId(thirdAll.getId());
					
					for (ResourceDO fourthAll : fourthMenusAll) {
						ResourceDOCustom fourthAll_ = ((ResourceDOCustom)fourthAll);
						for (ResourceDTO resourceDTO : resourceDOList) {
							if (fourthAll_.getId().equals(resourceDTO.getId())) {
								fourthAll_.setIsTrue(1);
								fourthAll_.setRole_res_id(resourceDTO
										.getRole_res_id());
							}
						}
					}
					thirdAll.setResourceDOList(fourthMenusAll);
				}
				secAll.setResourceDOList(thirdMenusAll);
			}
			firstAll.setResourceDOList(secMenusAll);
		}
		result.setResult(firstMenusAll);
		result.setSuccess(true);
		result.setSuccessInfo("查询成功");
		return result;
	}
}
