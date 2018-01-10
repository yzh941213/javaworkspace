package com.aishidai.app.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aishidai.app.dao.UsersDOMapper;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.dto.UsersListDTO;
import com.aishidai.app.model.pojo.UsersDO;
import com.aishidai.app.model.query.UsersQuery;
import com.aishidai.app.service.UsersService;

@Transactional
@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersDOMapper usersDOMapper;

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

    
    public Result<UsersListDTO> queryUsersDOById(int userId) {
        Result<UsersListDTO> result = new Result<UsersListDTO>();
        try {
            UsersDO u = usersDOMapper.selectByPrimaryKey(userId);
            
            if (u != null) {
                UsersListDTO uDTO = new UsersListDTO();
                uDTO.setUserId(u.getUserId());
                uDTO.setTrueName(u.getTrueName());
                uDTO.setAvatar(u.getAvatar());
                uDTO.setUname(u.getUname());
                uDTO.setSex(u.getSex());
                uDTO.setStatus(u.getStatus());
                uDTO.setUnick(u.getUnick());
                result.setResult(uDTO);
            }
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            result.setSuccess(false);
            return result;
        }
    }

    
    public Result<Integer> operatUsersDO(UsersDO usersDO) {
        Result<Integer> result = new Result<Integer>();
        try {
            int row = usersDOMapper.updateByPrimaryKeySelective(usersDO);
            if (row >= 0) {
                result.setResult(row);
                result.setSuccess(true);
                return result;
            }
            result.setResult(-1);
            result.setSuccess(false);
            return result;
        } catch (Exception e) {
            logger.info("", e);
            result.setSuccess(false);
            return result;
        }
    }

   
   
    public Result<Long> addUsersDOS(List<UsersDO> usersDOs) {
		return null;
         /*Result<Long> result;
        try {
            result = usersDOMapper.addUsersDO(usersDOs);
            return result;
        } catch (Exception e) {
            logger.info("", e);
            throw new RuntimeException(e.getMessage());
        }*/
    }

	
	/*public List<UsersDO> queryUserDOlist(UsersQuery query) {
		// TODO Auto-generated method stub
		return usersDOMapper.selectUserDOlist(query);
	}

	
	public List<MemberDO> queryMemberList(MemberQuery memberQuery)throws Exception{
		// TODO Auto-generated method stub
		return usersDOMapper.selectMemberList(memberQuery);
	}

	
	public MemberDO queryMemberDOByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return usersDOMapper.selectMemberDOByUserId(userId);
	}*/
}
