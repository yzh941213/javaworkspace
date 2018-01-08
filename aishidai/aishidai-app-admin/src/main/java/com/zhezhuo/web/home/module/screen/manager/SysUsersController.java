package com.zhezhuo.web.home.module.screen.manager;

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

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.CacheManager;
import com.zhezhuo.biz.manager.CraftsmenManager;
import com.zhezhuo.biz.manager.DistributorManager;
import com.zhezhuo.biz.manager.MakerManager;
import com.zhezhuo.biz.manager.ShopManager;
import com.zhezhuo.biz.manager.SysUsersManager;
import com.zhezhuo.biz.util.PasswordHash;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.CraftsmenDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.entity.ResourceDO;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.entity.SysUsersDO;
import com.zhezhuo.web.home.common.LoginConstant;

/**
 * Created by 蝈蝈 on 2016/10/8.
 */
@Controller
@RequestMapping("/manager/admin")
public class SysUsersController {

	@Autowired
	private SysUsersManager sysUsersManager;
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private DistributorManager distributorManager;
	@Autowired
	private ShopManager shopManager;
	@Autowired
	private CraftsmenManager craftsmenManager;
	@Autowired
	private MakerManager makerManager;

	@RequestMapping("/query.do")
	@ResponseBody
	public String querySysUsers() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		Result<List<SysUsersDO>> result = sysUsersManager.querySysUsersDOList();
		if (result != null && result.isSuccess()) {
			jsonObject.put("success", true);
			jsonObject.put("message", "query success");
			jsonObject.put("data", result.getResult());
			return jsonObject.toString();
		}
		jsonObject.put("message", "query failed");
		jsonObject.put("data", "");
		return jsonObject.toString();
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	@ResponseBody
	public String addSysUser(@RequestParam("userName") String userName, 
			@RequestParam("password") String password,
			@RequestParam("name") String name, 
			@RequestParam(value = "sex", defaultValue = "0") int sex,
			@RequestParam(value = "groupId", defaultValue = "0") long groupId,
			@RequestParam(value = "mobile", defaultValue = "") String mobile) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		try {
			SysUsersDO query = sysUsersManager.querySysUsersByUserName(userName);
			if (query != null) {
				jsonObject.put("message", "该用户名已存在");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		SysUsersDO sysUsersDO = new SysUsersDO();
		sysUsersDO.setSex(sex);
		sysUsersDO.setUserName(userName);
		sysUsersDO.setPassword(PasswordHash.createHash(password));
		sysUsersDO.setName(name);
		sysUsersDO.setGroupId(groupId);
		sysUsersDO.setMobile(mobile);
		sysUsersDO.setCreated(String.valueOf(System.currentTimeMillis() / 1000));
		sysUsersDO.setUpdated(String.valueOf(System.currentTimeMillis() / 1000));

		Result<Long> result = sysUsersManager.addSysUsersDOS(sysUsersDO);
		if (result != null && result.isSuccess()) {
			jsonObject.put("success", true);
			jsonObject.put("message", "query success");
			jsonObject.put("data", sysUsersDO.getUserId());
			return jsonObject.toString();
		}
		jsonObject.put("message", "query failed");
		jsonObject.put("data", -1);
		return jsonObject.toString();
	}

	@RequestMapping(value = { "/edit.do", "/own.do", "/del.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateSysUserInfo(@RequestParam(value = "userId", defaultValue = "0") long userId,
			@RequestParam(value = "newPassword", defaultValue = "", required = false) String newPassword,
			@RequestParam(value = "name", defaultValue = "", required = false) String name,
			@RequestParam(value = "nickName", defaultValue = "", required = false) String nickName,
			@RequestParam(value = "email", defaultValue = "", required = false) String email,
			@RequestParam(value = "status", defaultValue = "0", required = false) int status,
			@RequestParam(value = "sex", defaultValue = "0", required = false) int sex,
			@RequestParam(value = "mobile", defaultValue = "", required = false) String mobile,
			@RequestParam(value = "isDeleted", defaultValue = "0", required = false) int isDeleted) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		if (userId <= 0) {
			jsonObject.put("message", "参数错误");
			return jsonObject.toString();
		}

		SysUsersDO sysUsersDO = new SysUsersDO();
		sysUsersDO.setUserId(userId);
		sysUsersDO.setSex(sex);
		if (StringUtils.isNotBlank(newPassword)) {
			sysUsersDO.setPassword(PasswordHash.createHash(newPassword));
		}
		sysUsersDO.setNickName(nickName);
		sysUsersDO.setEmail(email);
		sysUsersDO.setStatus(status);
		sysUsersDO.setIsDeleted(isDeleted);
		sysUsersDO.setName(name);
		sysUsersDO.setMobile(mobile);
		sysUsersDO.setUpdated(String.valueOf(System.currentTimeMillis() / 1000));

		Result<Long> result = sysUsersManager.updateSysUsersDO(sysUsersDO);
		if (result != null && result.isSuccess()) {
			jsonObject.put("success", true);
			jsonObject.put("message", "操作成功");
			jsonObject.put("data", sysUsersDO.getUserId());
			return jsonObject.toString();
		}
		jsonObject.put("message", "query failed");
		jsonObject.put("data", -1);
		return jsonObject.toString();
	}

	@RequestMapping("/login.do")
	@ResponseBody
	public String login(@RequestParam(value = "userId",
	defaultValue = "0", required = false) long userId,
			@RequestParam("userName") String userName, @RequestParam("password") String password,
			HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<SysUsersDO> result = sysUsersManager.loginAdmin(userName, password);

		if (result != null && result.isSuccess()) {
			
			SysUsersDO user = result.getResult();
			//0为系统管理员 1为经销商 2为店铺 3为创客 4为手艺人 5为供应商
			//将用户登录信息保存在session中
			request.getSession().setAttribute(LoginConstant.USER_SESSION_KEY, user);
			
			if (user.getGroupId() == 1) {
				Result<DistributorDO> rDo = distributorManager.queryDistributorDOBySysUserId(user.getUserId());
				request.getSession().setAttribute(LoginConstant.USER_DISTRIBUTOR_SESSION_KEY, rDo.getResult());
			} else if (user.getGroupId() == 2) {
				Result<ShopDO> rDo;
				try {
					rDo = shopManager.queryShopDOBySysUserId(user.getUserId());
					request.getSession().setAttribute(LoginConstant.USER_SHOP_SESSION_KEY, rDo.getResult());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (user.getGroupId() == 3) {
				Result<MakerDO> rDo = makerManager.queryMakerDOBySysUserId(user.getUserId());
				request.getSession().setAttribute(LoginConstant.USER_MAKER_SESSION_KEY, rDo.getResult());
			} else if (user.getGroupId() == 4) {
				Result<CraftsmenDO> rDo = craftsmenManager.queryCraftsmenDOBySysUserId(user.getUserId());
				request.getSession().setAttribute(LoginConstant.USER_CRAFTSMEN_SESSION_KEY, rDo.getResult());
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
			jsonObject.put("loginSuccess", false);
			jsonObject.put("success", true);
			jsonObject.put("message", result.getErrorInfo());
		}
		return jsonObject.toString();
	}

	@RequestMapping("/out.do")
	@ResponseBody
	public String logout(@RequestParam("userId") long userId, HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		SysUsersDO userDO = (SysUsersDO) session.getAttribute(LoginConstant.USER_SESSION_KEY);
		cacheManager.invaild("adminId" + userId);
		if (userDO == null) {
			jsonObject.put("success", true);
			jsonObject.put("message", "success");
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
		jsonObject.put("message", "success");
		return jsonObject.toString();
	}

	@RequestMapping("/detail.do")
	@ResponseBody
	public String querySysUsersInfoById(
			@RequestParam(value = "userId", defaultValue = "0", required = false) long userId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<SysUsersDO> result = sysUsersManager.querySysUserInfoById(userId);

		if (result != null && result.isSuccess()) {
			JSONObject json = new JSONObject();
			json.put("userId", result.getResult().getUserId());
			json.put("userName", result.getResult().getUserName());
			json.put("name", result.getResult().getName());
			json.put("avater", result.getResult().getAvatar());
			json.put("sex", result.getResult().getSex());
			
			json.put("groupId", result.getResult().getGroupId());
			json.put("nickName", result.getResult().getNickName());
			json.put("mobile", result.getResult().getMobile());
			json.put("email", result.getResult().getEmail());
			jsonObject.put("data", json);
			jsonObject.put("success", true);
			jsonObject.put("message", "query success");

		} else {
			jsonObject.put("success", false);
			jsonObject.put("message", "query failed");
		}
		return jsonObject.toString();
	}

	@RequestMapping("/resource.do")
	@ResponseBody
	public String querySysUsersResource(@RequestParam(value = "userId") long userId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<List<ResourceDO>> result = sysUsersManager.queryResourceDO(userId);
		if (result != null && result.isSuccess()) {
			jsonObject.put("data", result.getResult());
			jsonObject.put("success", true);
			jsonObject.put("message", result.getSuccessInfo());
			jsonObject.put("link", result.getObj());
		} else {
			jsonObject.put("message", result.getErrorInfo());
		}
		return jsonObject.toString();
	}
	
	@RequestMapping("/queryByGroupId")
	@ResponseBody
	public String querySysUsersByGroupId(@RequestParam(value="groupId") Long groupId){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		List<SysUsersDO> list = sysUsersManager.querySysUsersByGroupId(groupId);
		if(list!=null){
			jsonObject.put("success", true);
			jsonObject.put("data", list);
			jsonObject.put("message", "查询成功");
			return jsonObject.toString();
		}
		jsonObject.put("message", "查询失败");
		return jsonObject.toString();
	}
	
}
