package com.aishidai.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.zhezhuo.biz.dao.UsersDAO;
import com.zhezhuo.biz.manager.UsersManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.SubordinateDTO;
import com.zhezhuo.model.domain.UsersListDTO;
import com.zhezhuo.model.entity.MemberDO;
import com.zhezhuo.model.entity.UsersDO;
import com.zhezhuo.model.query.MemberQuery;
import com.zhezhuo.model.query.UsersQuery;

/**
 * Created by 蝈蝈 on 2016/9/19.
 */
public class UsersServiceImpl implements UsersManager{

    @Autowired
    UsersDAO usersDAO;

    private Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    
    public Result<List<UsersListDTO>> queryUsersDOList(UsersQuery query) {
        Result<List<UsersListDTO>> result = new Result<List<UsersListDTO>>();
        try {
            List<UsersDO> usersDOs = usersDAO.queryUserDOList(query);
            query.setTotalItem(usersDAO.queryUserDOListCount(query));
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
                        String parentName = usersDAO.queryParent(u.getParentId()).getTrueName();
                        listDTO.setParentName(parentName == null ? "" : parentName);
                    } else {
                        listDTO.setParentName("");
                    }
                    listDTO.setSubordCount(usersDAO.querySubordinate(u.getUserId()).size());
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
        }
    }

    
    public Result<UsersListDTO> queryUsersDOById(long userId) {
        Result<UsersListDTO> result = new Result<UsersListDTO>();
        try {
            UsersDO u = usersDAO.queryUserDOById(userId);
            List<UsersDO> subs = usersDAO.querySubordinate(userId);
            if (u != null) {
                UsersListDTO uDTO = new UsersListDTO();
                uDTO.setUserId(u.getUserId());
                uDTO.setTrueName(u.getTrueName());
                uDTO.setAvatar(u.getAvatar());
                uDTO.setUname(u.getUname());
                uDTO.setSex(u.getSex());
                uDTO.setStatus(u.getStatus());
                uDTO.setUnick(u.getUnick());
                uDTO.setParentId(u.getParentId());
                uDTO.setInvitCode(u.getInvitcode());
                uDTO.setParentName(usersDAO.queryParent(u.getParentId()).getTrueName());
                uDTO.setSubordCount(usersDAO.querySubordinate(u.getUserId()).size());
                if (subs != null && !subs.isEmpty()){
                    List<SubordinateDTO> list = new ArrayList<SubordinateDTO>();
                    for (UsersDO sub : subs) {
                       SubordinateDTO sDTO = new SubordinateDTO();
                       sDTO.setUname(sub.getUname());
                       sDTO.setSex(sub.getSex());
                       sDTO.setUnike(sub.getUnick());
                       sDTO.setUserId(sub.getUserId());
                       list.add(sDTO);
                    }
                    uDTO.setSubordinates(list);
                }
                result.setResult(uDTO);
            }
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            logger.info("", e);
            result.setSuccess(false);
            return result;
        }
    }

    
    public Result<Integer> operatUsersDO(UsersDO usersDO) {
        Result<Integer> result = new Result<Integer>();
        try {
            int row = usersDAO.operateUserDO(usersDO);
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

    @Transactional
    
    public Result<Long> addUsersDOS(List<UsersDO> usersDOs) {
        Result<Long> result;
        try {
            result = usersDAO.addUsersDO(usersDOs);
            return result;
        } catch (Exception e) {
            logger.info("", e);
            throw new RuntimeException(e.getMessage());
        }
    }

	
	public List<UsersDO> queryUserDOlist(UsersQuery query) {
		// TODO Auto-generated method stub
		return usersDAO.selectUserDOlist(query);
	}

	
	public List<MemberDO> queryMemberList(MemberQuery memberQuery)throws Exception{
		// TODO Auto-generated method stub
		return usersDAO.selectMemberList(memberQuery);
	}

	
	public MemberDO queryMemberDOByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return usersDAO.selectMemberDOByUserId(userId);
	}
}
