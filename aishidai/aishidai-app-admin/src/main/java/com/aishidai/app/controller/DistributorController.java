package com.aishidai.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.CraftsmenDOCustom;
import com.aishidai.app.model.pojo.DistributorDO;
import com.aishidai.app.model.pojo.SysUsersDO;
import com.aishidai.app.model.query.CraftsmenQuery;
import com.aishidai.app.model.query.DistributorQuery;
import com.aishidai.app.service.DistributorService;
import com.aishidai.app.service.SysUsersRoleService;
import com.aishidai.app.service.SysUsersService;
import com.aishidai.app.utils.PasswordHash;
import com.aishidai.common.json.JsonResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


@RestController
@RequestMapping("/manage/distributor")
public class DistributorController {

	@Autowired
	private DistributorService distributorService;
	@Autowired
	private SysUsersService sysUsersService;
	@Autowired
	private SysUsersRoleService sysUsersRoleService;
	
	@RequestMapping("/queryAll")
	public String queryDistributorAll() {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			List<DistributorDO> list = distributorService.queryDistributorDOAll();
			jsonObject.put("success", true);
			jsonObject.put("data", JSONArray.toJSON(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	@GetMapping("/queryAllPage")
	public String queryDistributorAllPage(DistributorQuery distributorQuery){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		long userId = distributorQuery.getUserId();
		try {
			List<DistributorDO> list = new ArrayList<DistributorDO>();
			//先判断是否是  // 0为系统管理员 1为经销商 2为店铺 3为创客 4为手艺人
			//总部查询全部的
			if (sysUsersService.queryByPrimaryKey(userId).getGroupId() == 0) {
				list = distributorService.queryDistributorDOList(distributorQuery);
				jsonObject.put("data", JsonResult.buildPaging(list, distributorQuery.getsEcho(),
						(long)distributorService.queryDistributorDOListCount(distributorQuery)));
				jsonObject.put("success", true);
				jsonObject.put("message", "查询成功");
				//经销商查询自己下面的
			}else{
				jsonObject.put("message", "您的身份不正确，请核对后重试！");
				jsonObject.put("message", "查询失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	@RequestMapping("/queryByDistributorNameLike")
	public String queryDistributorByNameLike(
			@RequestParam(value = "distributorName") String distributorName) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			List<DistributorDO> list = distributorService.queryDistributorDOByNameLike(distributorName);
			jsonObject.put("success", true);
			jsonObject.put("message", "查询成功");
			jsonObject.put("data", JSONObject.toJSON(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	
	/*@RequestMapping("/queryDistributorByNameLikeAndUserId.do")
	
	public String queryDistributorByNameLikeAndUserId(
			@RequestParam(value = "distributorName") String name,
			@RequestParam(value = "userId") long userId) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		List<DistributorDO> result_list1 = new ArrayList<DistributorDO>();
		
		try {
			List<DistributorDO> list = distributorService.selectDistributorDOByUserId(userId);
			// 如果登录的不是经销商，当访问这个接口的时候返回查询失败
			if (!list.isEmpty() && list.size() >= 0) {
				 Result<List<SysusersRoleDO>> result_role = sysUsersRoleService.querySysUsersRole(userId);
				
				if (result_role.getResult().size()<=0 || result_role.getResult().isEmpty()) {
					jsonObject.put("success", true);
					jsonObject.put("message", "查询失败，请稍后重试");
				}else{
					for (int i = 0; i < result_role.getResult().size(); i++) {
						if (result_role.getResult().get(i).getRoleId() == 18) {
							List<DistributorDO> result_list = distributorManager
									.queryDistributorDOByNameLike(name);
							jsonObject.put("success", true);
							jsonObject.put("message", "查询成功");
							jsonObject.put("data", JSONObject.toJSON(result_list));
							return jsonObject.toString();
						}
					}
				}
			} else {
				jsonObject.put("success", false);
				jsonObject.put("message", "查询失败，请稍后重试");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}*/

	
	@RequestMapping("/queryDetail")
	public String queryDistributors(
			@RequestParam(value = "distributorId") long distributorId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			DistributorDO distributorDO = distributorService
					.queryDistributorDOById(distributorId);
			if (distributorDO == null) {
				jsonObject.put("message", "信息不存在，请核实后重试");
				return jsonObject.toString();
			}
			jsonObject.put("success", true);
			jsonObject.put("message", "查询成功");
			jsonObject.put("data", JSONObject.toJSON(distributorDO));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
	public String editDistributorDO(DistributorDO distributorDO){

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			if (distributorDO == null) {
				jsonObject.put("message", "操作失败");
				return jsonObject.toString();
			} else {
				distributorDO.setUpdated(new Date());
				if (distributorService.editDistributorDO(distributorDO)) {
					jsonObject.put("success", true);
					jsonObject.put("message", "操作成功");
				}else{
					jsonObject.put("message", "操作失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addDistributorDO(DistributorDO distributorDO){

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			if (distributorDO != null && distributorDO.getName() != null
					&& distributorDO.getTel() != null) {

				distributorDO.setStatus(0);
				distributorDO.setCreated(new Date());
				distributorDO.setUpdated(new Date());

				if (distributorService.insertDistributorDO(distributorDO)) {
					jsonObject.put("success", true);
					jsonObject.put("message", "操作成功");
					return jsonObject.toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("message", "操作失败");
		return jsonObject.toString();
	}
	
	
	
	@RequestMapping(value = { "/remove" }, method = RequestMethod.POST)
	public String editDistributorDOStatus(
			@RequestParam("distributorId") long distributorId,
			@RequestParam("status") int status) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			DistributorDO distributorDO = distributorService
					.queryDistributorDOById(distributorId);
			if (distributorDO != null) {
				distributorDO.setStatus(status);
				if (distributorService.editDistributorDO(distributorDO)) {
					jsonObject.put("success", true);
					jsonObject.put("message", "操作成功");
					return jsonObject.toString();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonObject.put("message", "操作失败");
		return jsonObject.toString();
	}
	
	
	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	public String addUser(
			@RequestParam(value = "id",required =true) long id,
			@RequestParam(value = "userName",required =true) String userName,
			@RequestParam(value = "mobile",required =true) String mobile,
			@RequestParam(value = "name",required =false) String name,
			@RequestParam(value = "password",required =true) String password) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			SysUsersDO SUDO = sysUsersService.querySysUsersByUserName(userName);
					
			if (SUDO != null) {
				jsonObject.put("message", "该用户名已存在,请核对后重试");
				return jsonObject.toString();
			}
			SysUsersDO sysUsersDO = new SysUsersDO();
			sysUsersDO.setUserName(userName);
			sysUsersDO.setPassword(PasswordHash.createHash(password));
			sysUsersDO.setStatus(0);
			sysUsersDO.setName(name);
			sysUsersDO.setIsDeleted(0);
			sysUsersDO.setMobile(mobile);
			sysUsersDO.setGroupId(new Long(1));//
			sysUsersDO.setCreated(Integer.valueOf((System.currentTimeMillis() / 1000)+""));
			sysUsersDO.setUpdated(Integer.valueOf((System.currentTimeMillis() / 1000)+""));
			
			Result<Long> result = sysUsersService.addSysUsersDOAndRole(
					sysUsersDO, new Long(17));
			
			if (result == null || !result.isSuccess()) {
				jsonObject.put("message", "数据操作失败");
				return jsonObject.toString();
			} else {
				DistributorDO distributorDO = distributorService.queryDistributorDOById(id);
				if (distributorDO != null) {
					distributorDO.setSysUserId(result.getResult());
				}
				if (!distributorService.editDistributorDO(distributorDO)) {
					jsonObject.put("message", "添加失败");
					return jsonObject.toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "添加成功");
		return jsonObject.toString();
	}
}
