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

import javax.annotation.Resource;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
	
    @Autowired
    private ResourceDOMapper resourceDOMapper;
    @Autowired
    private ResourceDOCustomMapper resourceDOCustomMapper;
    
    private static final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);


    
    public Result<List<ResourceDO>> queryAllResource() {
        Result<List<ResourceDO>> result = new Result<List<ResourceDO>>();
        try {
            List<ResourceDO> firstMenusAll = resourceDOCustomMapper.queryFirstMenu();
            
            for (ResourceDO firstAll: firstMenusAll) {
            	
            	ResourceDOExample example = new ResourceDOExample();
                ResourceDOExample.Criteria criteria = example.createCriteria();
                
                ResourceDOCustom firstAll_ = ((ResourceDOCustom)firstAll);
                
                criteria.andParentidEqualTo(firstAll_.getId());
                
                List<ResourceDO> secMenusAll = resourceDOMapper.selectByExample(example);
                for (ResourceDO secAll: secMenusAll) {
                	 criteria.andParentidEqualTo(secAll.getId());
                    List<ResourceDO> thirdMenusAll = resourceDOMapper.selectByExample(example);
                    for (ResourceDO thirdAll:thirdMenusAll) {
                    	criteria.andParentidEqualTo(thirdAll.getId());
                        List<ResourceDO> fourthMenusAll = resourceDOMapper.selectByExample(example);
                        firstAll_.setResourceDOList(fourthMenusAll);
                    }
                    firstAll_.setResourceDOList(thirdMenusAll);
                }
                firstAll_.setResourceDOList(secMenusAll);
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

		List<ResourceDTO> resourceDOList = resourceDOCustomMapper
				.queryResourceByRoleId(roleId);
		List<ResourceDO> firstMenusAll = resourceDOCustomMapper.queryFirstMenu();

		for (ResourceDO firstAll : firstMenusAll) {
			ResourceDOCustom firstAll_ = ((ResourceDOCustom)firstAll);
			
			for (ResourceDTO resourceDTO : resourceDOList) {
				if (firstAll_.getId().equals(resourceDTO.getId())) {
					firstAll_.setIsTrue(1);
					firstAll_.setRole_res_id(resourceDTO.getRole_res_id());
				}
			}
			ResourceDOExample example = new ResourceDOExample();
			ResourceDOExample.Criteria criteria = example.createCriteria();
			criteria.andParentidEqualTo(firstAll.getId());

			List<ResourceDO> secMenusAll = resourceDOMapper
					.selectByExample(example);
			for (ResourceDO secAll : secMenusAll) {
				ResourceDOCustom secAll_ = ((ResourceDOCustom)secAll);
				for (ResourceDTO resourceDTO : resourceDOList) {
					if (secAll_.getId().equals(resourceDTO.getId())) {
						secAll_.setIsTrue(1);
						secAll_.setRole_res_id(resourceDTO.getRole_res_id());
					}
				}
				criteria.andParentidEqualTo(secAll.getId());
				List<ResourceDO> thirdMenusAll = resourceDOMapper
						.selectByExample(example);

				for (ResourceDO thirdAll : thirdMenusAll) {
					ResourceDOCustom thirdAll_ = ((ResourceDOCustom)thirdAll);
					for (ResourceDTO resourceDTO : resourceDOList) {
						if (thirdAll_.getId().equals(resourceDTO.getId())) {
							thirdAll_.setIsTrue(1);
							thirdAll_.setRole_res_id(resourceDTO
									.getRole_res_id());
						}
					}
					criteria.andParentidEqualTo(thirdAll.getId());
					List<ResourceDO> fourthMenusAll = resourceDOMapper
							.selectByExample(example);
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
					thirdAll_.setResourceDOList(fourthMenusAll);
				}
				secAll_.setResourceDOList(thirdMenusAll);
			}
			firstAll_.setResourceDOList(secMenusAll);
		}
		result.setResult(firstMenusAll);
		result.setSuccess(true);
		result.setSuccessInfo("查询成功");
		return result;
	}
}
