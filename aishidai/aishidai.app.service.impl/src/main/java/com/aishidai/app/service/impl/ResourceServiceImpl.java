package com.aishidai.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.ResourceDOMapper;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.dto.ResourceDTO;
import com.aishidai.app.service.ResourceService;

import javax.annotation.Resource;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Resource
    private ResourceDOMapper resourceDOMapper;


    Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);


    
    public Result<List<ResourceDO>> queryAllResource() {
        Result<List<ResourceDO>> result = new Result<List<ResourceDO>>();
        try {
            List<ResourceDO> firstMenusAll = resourceDOMapper.queryFirstMenu();
            
            for (ResourceDO firstAll: firstMenusAll) {
            	
            	ResourceDOExample example = new ResourceDOExample();
                ResourceDOExample.Criteria criteria = example.createCriteria();
                criteria.andParentidEqualTo(firstAll.getId());
                
                List<ResourceDO> secMenusAll = resourceDOMapper.selectByExample(example);
                for (ResourceDO secAll: secMenusAll) {
                	 criteria.andParentidEqualTo(secAll.getId());
                    List<ResourceDO> thirdMenusAll = resourceDOMapper.selectByExample(example);
                    for (ResourceDO thirdAll:thirdMenusAll) {
                    	criteria.andParentidEqualTo(thirdAll.getId());
                        List<ResourceDO> fourthMenusAll = resourceDOMapper.selectByExample(example);
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

    
	public Result<List<ResourceDO>> queryAllResourceByRoleId(long roleId) {

		Result<List<ResourceDO>> result = new Result<List<ResourceDO>>();

		List<ResourceDTO> resourceDOList = resourceDOMapper
				.queryResourceByRoleId(roleId);
		List<ResourceDO> firstMenusAll = resourceDOMapper.queryFirstMenu();

		for (ResourceDO firstAll : firstMenusAll) {
			for (ResourceDTO resourceDTO : resourceDOList) {
				if (firstAll.getId().equals(resourceDTO.getId())) {
					firstAll.setIsTrue(1);
					firstAll.setRole_res_id(resourceDTO.getRole_res_id());
				}
			}
			ResourceDOExample example = new ResourceDOExample();
			ResourceDOExample.Criteria criteria = example.createCriteria();
			criteria.andParentidEqualTo(firstAll.getId());

			List<ResourceDO> secMenusAll = resourceDOMapper
					.selectByExample(example);
			for (ResourceDO secAll : secMenusAll) {

				for (ResourceDTO resourceDTO : resourceDOList) {
					if (secAll.getId().equals(resourceDTO.getId())) {
						secAll.setIsTrue(1);
						secAll.setRole_res_id(resourceDTO.getRole_res_id());
					}
				}
				criteria.andParentidEqualTo(secAll.getId());
				List<ResourceDO> thirdMenusAll = resourceDOMapper
						.selectByExample(example);

				for (ResourceDO thirdAll : thirdMenusAll) {
					for (ResourceDTO resourceDTO : resourceDOList) {
						if (thirdAll.getId().equals(resourceDTO.getId())) {
							thirdAll.setIsTrue(1);
							thirdAll.setRole_res_id(resourceDTO
									.getRole_res_id());
						}
					}
					criteria.andParentidEqualTo(thirdAll.getId());
					List<ResourceDO> fourthMenusAll = resourceDOMapper
							.selectByExample(example);
					for (ResourceDO fourthAll : fourthMenusAll) {
						for (ResourceDTO resourceDTO : resourceDOList) {
							if (fourthAll.getId().equals(resourceDTO.getId())) {
								fourthAll.setIsTrue(1);
								fourthAll.setRole_res_id(resourceDTO
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
