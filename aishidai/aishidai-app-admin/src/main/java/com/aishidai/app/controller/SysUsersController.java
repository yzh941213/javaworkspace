package com.aishidai.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aishidai.app.common.LoginConstant;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.CraftsmenDO;
import com.aishidai.app.model.pojo.DistributorDO;
import com.aishidai.app.model.pojo.MakerDO;
import com.aishidai.app.model.pojo.ResourceDO;
import com.aishidai.app.model.pojo.ShopsDO;
import com.aishidai.app.model.pojo.SysUsersDO;
import com.aishidai.app.service.CraftsmenService;
import com.aishidai.app.service.DistributorService;
import com.aishidai.app.service.MakerService;
import com.aishidai.app.service.ShopService;
import com.aishidai.app.service.SysUsersService;
import com.aishidai.app.utils.PasswordHash;
import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping("/manage/user")
public class SysUsersController {

	@Autowired
	private SysUsersService sysUsersService;
	@Autowired
	private DistributorService distributorService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private CraftsmenService craftsmenService;
	@Autowired
	private MakerService makerService;

	
	
	@RequestMapping("/login.do")
	@ResponseBody
	public String login(@RequestParam("userName") String userName, 
						@RequestParam("password") String password,
			HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		Result<SysUsersDO> result = null;
		try {
			result = sysUsersService.loginUser(userName, password);
			if (result != null && result.isSuccess()) {
				
				SysUsersDO user = result.getResult();
				//0为系统管理员 1为经销商 2为店铺 3为创客 4为手艺人 5为供应商
				//将用户登录信息保存在session中
				request.getSession().setAttribute(LoginConstant.USER_SESSION_KEY, user);
				
				if (user.getGroupId() == 1) {
					List<DistributorDO> list  = distributorService.queryDistributorDOBySysUserId(user.getUserId());
					if (!list.isEmpty() && list.size() >= 0) {
						request.getSession().setAttribute(
								LoginConstant.USER_DISTRIBUTOR_SESSION_KEY, list.get(0));
					}
				} else if (user.getGroupId() == 2) {
					List<ShopsDO> list = shopService.queryShopsDOBySysUserId(Integer.valueOf(user.getUserId()+""));
					if (!list.isEmpty() && list.size() >= 0) {
						request.getSession().setAttribute(LoginConstant.USER_SHOP_SESSION_KEY, list.get(0));
					}
					
				} else if (user.getGroupId() == 3) {
					
					List<MakerDO> list = makerService.queryMakerDOBySysUserId(user.getUserId());
					if (!list.isEmpty() && list.size() >= 0) {
						request.getSession().setAttribute(LoginConstant.USER_MAKER_SESSION_KEY, list.get(0));
					}
					
				} else if (user.getGroupId() == 4) {
					
					List<CraftsmenDO> list = craftsmenService.queryCraftsmenDOBySysUserId(user.getUserId());
					if (!list.isEmpty() && list.size() >= 0) {
						request.getSession().setAttribute(LoginConstant.USER_CRAFTSMEN_SESSION_KEY, list.get(0));
					}
				}
				
				JSONObject json = new JSONObject();
				
				json.put("userId", result.getResult().getUserId());
				json.put("userName", result.getResult().getUserName());
				json.put("avater", result.getResult().getAvatar());
				json.put("sex", result.getResult().getSex());
				json.put("nickName", result.getResult().getNickName());
				jsonObject.put("data", json);
				jsonObject.put("success", true);
				jsonObject.put("message", "登录成功");

			} else {
				jsonObject.put("success", false);
				jsonObject.put("message", result.getErrorInfo());
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return jsonObject.toString();
	}
	
	@RequestMapping("/logout.do")
	@ResponseBody
	public String logout(@RequestParam("userId") long userId,
			HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		SysUsersDO userDO = (SysUsersDO) session
				.getAttribute(LoginConstant.USER_SESSION_KEY);
		if (userDO == null) {
			jsonObject.put("success", true);
			jsonObject.put("message", "退出成功");
			return jsonObject.toString();
		}

		try {
			session.removeAttribute(LoginConstant.USER_SESSION_KEY);
			if (userDO.getGroupId() == 1) {
				session.removeAttribute(LoginConstant.USER_DISTRIBUTOR_SESSION_KEY);
			} else if (userDO.getGroupId() == 2) {
				session.removeAttribute(LoginConstant.USER_SHOP_SESSION_KEY);
			} else if (userDO.getGroupId() == 3) {
				session.removeAttribute(LoginConstant.USER_MAKER_SESSION_KEY);
			} else if (userDO.getGroupId() == 4) {
				session.removeAttribute(LoginConstant.USER_CRAFTSMEN_SESSION_KEY);
			}
			session.invalidate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsonObject.put("success", true);
		jsonObject.put("message", "退出成功");
		return jsonObject.toString();
	}
	
	
	@RequestMapping("/queryList.do")
	@ResponseBody
	public String querySysUsers() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		Result<List<SysUsersDO>> result = null;
		try {
			result = sysUsersService.querySysUsersDOList();
			if (result.getResult() != null) {
				jsonObject.put("success", true);
				jsonObject.put("message", "查询成功");
				jsonObject.put("data", result.getResult());
				return jsonObject.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonObject.put("message", "查询失败！");
		jsonObject.put("data", "");
		return jsonObject.toString();
	}

	
	
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	@ResponseBody
	public String addSysUser(
			@RequestParam(value = "userName",required = true) String userName, 
			@RequestParam(value = "password",required = true) String password,
			@RequestParam(value = "name",required = true) String name, 
			@RequestParam(value = "sex",required = true) int sex,
			@RequestParam(value = "nickName", defaultValue = "", required = false) String nickName,
			@RequestParam(value = "avatar", defaultValue = "", required = false) String avatar,
			@RequestParam(value = "email", defaultValue = "", required = false) String email,
			@RequestParam(value = "groupId",required = true) long groupId,
			@RequestParam(value = "mobile",required = true) String mobile) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		SysUsersDO sysUsersDO = null;
		try {
			sysUsersDO = sysUsersService.querySysUsersByUserName(userName);
			if (sysUsersDO != null) {
				jsonObject.put("message", "信息已存在，请核对后重试");
				return jsonObject.toString();
			}
			sysUsersDO = new SysUsersDO();
			
			sysUsersDO.setSex(sex);
			sysUsersDO.setUserName(userName);
			sysUsersDO.setPassword(PasswordHash.createHash(password));
			sysUsersDO.setName(name);
			sysUsersDO.setGroupId(groupId);
			sysUsersDO.setMobile(mobile);
			sysUsersDO.setIsDeleted(0);
			sysUsersDO.setStatus(0);
			sysUsersDO.setCreated(Integer.valueOf((System.currentTimeMillis() / 1000)+""));
			sysUsersDO.setUpdated(Integer.valueOf((System.currentTimeMillis() / 1000)+""));

			Result<Long> result = sysUsersService.addSysUsersDOS(sysUsersDO);
			if (result.getResult().longValue() != -1) {
				jsonObject.put("success", true);
				jsonObject.put("message", "添加成功");
				jsonObject.put("data", sysUsersDO.getUserId());
				return jsonObject.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jsonObject.put("message", "添加失败");
		jsonObject.put("data", -1);
		return jsonObject.toString();
	}
	
	@RequestMapping(value = { "/edit.do"}, method = RequestMethod.POST)
	@ResponseBody
	public String editSysUserInfo(
			@RequestParam(value = "userId", required = true) long userId,
			@RequestParam(value = "feature",required = false) String feature, 
			@RequestParam(value = "newPassword",required = false) String newPassword,
			@RequestParam(value = "name",required = false) String name,
			@RequestParam(value = "nickName",required = false) String nickName,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "avatar",required = false) String avatar,
			@RequestParam(value = "sex", required = false) int sex,
			@RequestParam(value = "mobile",required = false) String mobile) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		Result<Long> result = null;
		try {
			if (userId <= 0) {
				jsonObject.put("message", "参数错误,请重试");
				return jsonObject.toString();
			}

			SysUsersDO sysUsersDO = sysUsersService.queryByPrimaryKey(userId);
			if (sysUsersDO != null) {
				sysUsersDO.setUserId(userId);
				sysUsersDO.setSex(sex);
				if (StringUtils.isNotBlank(newPassword)) {
					sysUsersDO.setPassword(PasswordHash.createHash(newPassword));
				}
				sysUsersDO.setNickName(nickName);
				sysUsersDO.setAvatar(avatar);
				sysUsersDO.setFeature(feature);
				
				sysUsersDO.setEmail(email);
				sysUsersDO.setName(name);
				sysUsersDO.setMobile(mobile);
				sysUsersDO.setUpdated(Integer.valueOf((System.currentTimeMillis() / 1000)+""));
				
				result = sysUsersService.editSysUsersDO(sysUsersDO);
				if (result.getResult().longValue() != -1) {
					jsonObject.put("success", true);
					jsonObject.put("data", userId);
					jsonObject.put("message", "修改成功");
					return jsonObject.toString();
				}
			}else{
				
				jsonObject.put("message", "修改失败，用户不存在");
				jsonObject.put("data", -2);
				return jsonObject.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonObject.put("message", "修改失败");
		jsonObject.put("data", -1);
		return jsonObject.toString();
	}
	
	@RequestMapping(value = { "/remove.do"}, method = RequestMethod.POST)
	@ResponseBody
	public String remove(@RequestParam(value = "userId", required = true) long userId){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		SysUsersDO sysUsersDO = null;
		try {
			sysUsersDO = sysUsersService.queryByPrimaryKey(userId);
			
			if (sysUsersDO != null) {
				sysUsersDO.setIsDeleted(1);
				sysUsersDO.setUpdated(Integer.valueOf((System.currentTimeMillis() / 1000)+""));
				Result<Long> result = sysUsersService.editSysUsersDO(sysUsersDO);
				if (result.getResult().longValue() != -1) {
					jsonObject.put("success", true);
					jsonObject.put("message", "删除成功");
				}
			}else{
				jsonObject.put("message", "用户不存在，请核实");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	

	

	@RequestMapping("/queryDetail.do")
	@ResponseBody
	public String querySysUsersInfoById(
			@RequestParam(value = "userId",required = true) long userId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		SysUsersDO sysUsersDO = null;
		try {
			sysUsersDO = sysUsersService.queryByPrimaryKey(userId);
			if (sysUsersDO != null) {
				JSONObject json = new JSONObject();
				json.put("userId", sysUsersDO.getUserId());
				json.put("userName", sysUsersDO.getUserName());
				json.put("name", sysUsersDO.getName());
				json.put("avater", sysUsersDO.getAvatar());
				json.put("sex", sysUsersDO.getSex());
				json.put("groupId", sysUsersDO.getGroupId());
				json.put("nickName", sysUsersDO.getNickName());
				json.put("mobile", sysUsersDO.getMobile());
				json.put("email", sysUsersDO.getEmail());
				jsonObject.put("data", json);
				jsonObject.put("success", true);
				jsonObject.put("message", "查询成功");

			} else {
				jsonObject.put("success", false);
				jsonObject.put("message", "查询失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@RequestMapping(value = "/queryResource.do", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String querySysUsersResource(
			@RequestParam(value = "userId") long userId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<List<ResourceDO>> result = null;
		try {
			result = sysUsersService.queryResourceDO(userId);
			
			if (result != null && result.isSuccess()) {
				jsonObject.put("data", result.getResult());
				jsonObject.put("success", true);
				jsonObject.put("message", result.getSuccessInfo());
				jsonObject.put("link", result.getObj());
			} else {
				jsonObject.put("message", result.getErrorInfo());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}
	
	
	
	@RequestMapping("/queryByGroupId.do")
	@ResponseBody
	public String querySysUsersByGroupId(
			@RequestParam(value="groupId") Long groupId){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		List<SysUsersDO> list = null;
		try {
			list = sysUsersService.querySysUsersByGroupId(groupId);
			if(list != null){
				jsonObject.put("success", true);
				jsonObject.put("data", list);
				jsonObject.put("message", "查询成功");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonObject.put("message", "查询失败");
		return jsonObject.toString();
	}
	
}
