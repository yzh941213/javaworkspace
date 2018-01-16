package com.aishidai.app.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aishidai.app.dao.MemberDOMapper;
import com.aishidai.app.dao.UsersDOMapper;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.dto.UsersListDTO;
import com.aishidai.app.model.pojo.MemberDO;
import com.aishidai.app.model.pojo.MemberDOExample;
import com.aishidai.app.model.pojo.UsersDO;
import com.aishidai.app.model.query.UsersQuery;
import com.aishidai.app.service.UsersService;

@Transactional
@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersDOMapper usersDOMapper;
    @Autowired
    private MemberDOMapper memberDOMapper;

    private static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    
   public Result<List<UsersListDTO>> queryUsersDOList(UsersQuery query) {
	return null;
       /*  Result<List<UsersListDTO>> result = new Result<List<UsersListDTO>>();
        try {
            List<UsersDO> usersDOs = usersDOMapper.queryUserDOList(query);
            query.setTotalItem(usersDOMapper.queryUserDOListCount(query));
            if (usersDOs != null && !usersDOs.isEmpty()) {
                List<UsersListDTO> list = new ArrayList<UsersListDTO>();
                for (UsersDO u : usersDOs) {
                    UsersListDTO listDTO = new UsersListDTO();
                    listDTO.setUserId(u.getUserId());
                    listDTO.setStatus(u.getStatus());
                    listDTO.setTrueName(u.getTrueName());
                    listDTO.setAvatar(u.getAvatar());
                    listDTO.setUname(u.getUname());
                    listDTO.setSex(u.getSex());
                    listDTO.setUnick(u.getUnick());
                    listDTO.setInvitCode(u.getInvitcode());
                    listDTO.setParentId(u.getParentId());
                    if (u.getParentId() != null && u.getParentId() > 0) {
                        String parentName = usersDOMapper.queryParent(u.getParentId()).getTrueName();
                        listDTO.setParentName(parentName == null ? "" : parentName);
                    } else {
                        listDTO.setParentName("");
                    }
                    listDTO.setSubordCount(usersDOMapper.querySubordinate(u.getUserId()).size());
                    list.add(listDTO);
                }
                result.setResult(list);
            }
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            logger.info("", e);
            result.setSuccess(false);
            return result;
        }*/
    }

    
    public UsersListDTO queryUsersDOById(long userId) {

		UsersDO usersDO = usersDOMapper.selectByPrimaryKey(userId);
		UsersListDTO DTO = null;
		if (usersDO != null) {
			DTO = new UsersListDTO();
			DTO.setUserId(usersDO.getUserId());
			DTO.setTrueName(usersDO.getTrueName());
			DTO.setAvatar(usersDO.getAvatar());
			DTO.setUname(usersDO.getUname());
			DTO.setSex(usersDO.getSex());
			DTO.setStatus(usersDO.getStatus());
			DTO.setUnick(usersDO.getUnick());
		}
		return DTO;

    }

    
	

   
   
    public Long addUsersDOS(List<UsersDO> usersDOs) {
		return null;
    }


	


	public List<UsersDO> queryUserDOlist(UsersQuery query) throws Exception {
		
		return null;
	}


	public MemberDO queryMemberDOByUserId1(int userId) throws Exception {
		
		return null;
	}


	public MemberDO queryMemberDOByUserId(int userId) throws Exception {
		
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<UsersDO> queryAll() {
		return usersDOMapper.selectByExample(null);
	}
	
	public boolean editUsersDO(UsersDO usersDO) {
		return usersDOMapper.updateByPrimaryKeySelective(usersDO)>0;
	}

	public List<MemberDO> queryMemberAll() {
		return memberDOMapper.selectByExample(null);
	}


	public MemberDO queryMemberDOByUserId(Long userId) {
		MemberDOExample example = new MemberDOExample();
		MemberDOExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<MemberDO> list = memberDOMapper.selectByExample(example);
		if (list.isEmpty() && list.size() <=0) {
			return null;
		}
		return list.get(0);
	}
	
}
