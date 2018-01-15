package com.aishidai.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.CraftsmenDO;
import com.aishidai.app.model.pojo.CraftsmenDOCustom;
import com.aishidai.app.model.pojo.DistributorDO;
import com.aishidai.app.model.pojo.ShopsDO;
import com.aishidai.app.model.pojo.SysUsersDO;
import com.aishidai.app.model.query.CraftsmenQuery;
import com.aishidai.app.service.CraftsmenService;
import com.aishidai.app.service.DistributorService;
import com.aishidai.app.service.ShopService;
import com.aishidai.app.service.SysUsersService;
import com.aishidai.app.util.PhotoUtil;
import com.aishidai.app.utils.PasswordHash;
import com.aishidai.common.json.JsonResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


@RestController
@RequestMapping("/manage/craftsmen")
public class CraftsmenController {

	private static final Logger log = LoggerFactory.getLogger(CraftsmenController.class); 
	@Autowired
	private CraftsmenService craftsmenService;
	@Autowired
	private SysUsersService sysUsersService;
	@Autowired
	private DistributorService distributorService;
	@Autowired
	private ShopService shopService;
	
	/**
	 * 查询详细信息
	 */
	@RequestMapping("/queryDetail")
	public String queryCraftsmens(
			@RequestParam(value = "craftsmenId") long craftsmenId) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			CraftsmenDOCustom cc = craftsmenService.queryByPrimaryKeyCustom(craftsmenId);
			if (cc == null) {
				jsonObject.put("message", "信息不存在，请核对后重试");
				return jsonObject.toString();
			}
			if (cc.getShopsId() != null && cc.getShopsId().longValue() != 0) {
				cc.setShopName(shopService.queryShopsDOById(cc.getShopsId()) != null ? shopService
						.queryShopsDOById(cc.getShopsId()).getShopsName() : "无");
				jsonObject.put("type", "shops");
			}
			jsonObject.put("message", "查询成功");
			jsonObject.put("success", true);
			jsonObject.put("data", JSONObject.toJSON(cc));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject.toString();
	}
	
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String addCraftsmenDO(CraftsmenDO craftsmenDO,
			@RequestParam(value = "userId") long userId) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			if (craftsmenDO == null || craftsmenDO.getCraftsmanName() == null
					&& craftsmenDO.getTelephone() == null) {
				jsonObject.put("message", "参数不正确，请核对后重试");
				return jsonObject.toString();
			}

			List<CraftsmenDO> list = craftsmenService.queryCraftsmenExist(
					craftsmenDO.getCraftsmanName(), craftsmenDO.getTelephone());

			if (!list.isEmpty() && list.size() >= 0) {
				jsonObject.put("message", "该手艺人信息已存在，请核对后重试！");
				return jsonObject.toString();
			}
			
			//判断是经销商和店铺以及总部的身份
			
			
			//先判断是否是  // 0为系统管理员 1为经销商 2为店铺 3为创客 4为手艺人
			//总部添加
			if (sysUsersService.queryByPrimaryKey(userId).getGroupId() == 0) {
				if (craftsmenDO.getDistributorId().longValue() == 0 
						&& craftsmenDO.getShopsId().longValue() == 0) {
					jsonObject.put("message", "请至少输入一位其上级");
					return jsonObject.toString();
				}
				this.insertCraftsmenUtil(craftsmenDO);
				
			//经销商添加
			}else if(sysUsersService.queryByPrimaryKey(userId).getGroupId() == 1){
				craftsmenDO.setDistributorId(userId);
				this.insertCraftsmenUtil(craftsmenDO);
			//店铺添加
			}else if(sysUsersService.queryByPrimaryKey(userId).getGroupId() == 2){
				//查出来店铺的经销商
				craftsmenDO.setDistributorId(shopService.queryShopsDOByUserId(userId).get(0).getDistributorId());
				craftsmenDO.setShopsId(userId);
				this.insertCraftsmenUtil(craftsmenDO);
			}else{
				jsonObject.put("message", "您的身份不正确，请核对后重试！");
				return jsonObject.toString();
			}

			if (!craftsmenService.insertCraftsmenDO(craftsmenDO)) {
				jsonObject.put("message", "数据插入失败");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "数据插入成功");
		
		return jsonObject.toString();
	}
	
	public void insertCraftsmenUtil(CraftsmenDO craftsmenDO){
		if (craftsmenDO.getCraftsmanUrl() != null
				&& !"".equals(craftsmenDO.getCraftsmanUrl())) {
			String craftsmanUrl = PhotoUtil.addPhoto(craftsmenDO
					.getCraftsmanUrl());
			craftsmenDO.setCraftsmanUrl(craftsmanUrl);
		}

		craftsmenDO.setIsDeleted(0);
		craftsmenDO.setAudit(0);
		craftsmenDO.setStar(3);
		if (StringUtils.isNotBlank(craftsmenDO.getServiceId())) {
			String serviceId = "-" + craftsmenDO.getServiceId() + "-";
			craftsmenDO.setServiceId(serviceId);
		}

		if (StringUtils.isNotBlank(craftsmenDO.getTitleId())) {
			String titleId = "-" + craftsmenDO.getTitleId() + "-";
			craftsmenDO.setTitleId(titleId);
		}
		craftsmenDO.setCreated(new Date());
		craftsmenDO.setUpdated(new Date());
	}
	
	
	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
	public String editCraftsmenDO(CraftsmenDO craftsmenDO) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			if (craftsmenDO == null || craftsmenDO.getCraftsmanName() == null
					|| craftsmenDO.getTelephone() == null
					|| craftsmenDO.getId() == null) {
				jsonObject.put("message", "参数不正确，请核对后重试");
				return jsonObject.toString();
			}

			CraftsmenDO CDO = craftsmenService.queryByPrimaryKey(craftsmenDO
					.getId());

			
			List<CraftsmenDO> list = craftsmenService.queryCraftsmenExist(
					craftsmenDO.getCraftsmanName(),
					craftsmenDO.getTelephone());
			if (!list.isEmpty() && list.size() >= 0 
					&& CDO.getId().longValue() != list.get(0).getId().longValue()) {
				jsonObject.put("message", "该手艺人信息已存在，请核对后重试！");
				return jsonObject.toString();
			}
			

			if (craftsmenDO.getCraftsmanUrl() != null
					&& !"".equals(craftsmenDO.getCraftsmanUrl())) {
				String craftsmanUrl = PhotoUtil.addPhoto(craftsmenDO
						.getCraftsmanUrl());
				craftsmenDO.setCraftsmanUrl(craftsmanUrl);
			}

			if (StringUtils.isNotBlank(craftsmenDO.getServiceId())) {
				String serviceId = "-" + craftsmenDO.getServiceId() + "-";
				craftsmenDO.setServiceId(serviceId);
			}

			if (StringUtils.isNotBlank(craftsmenDO.getTitleId())) {
				String titleId = "-" + craftsmenDO.getTitleId() + "-";
				craftsmenDO.setTitleId(titleId);
			}
			craftsmenDO.setUpdated(new Date());

			if (!craftsmenService.editCraftsmenDO(craftsmenDO)) {
				jsonObject.put("message", "操作失败");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}
	
	@RequestMapping(value = { "/editStatus" }, method = RequestMethod.POST)
	public String editStatus(@RequestParam("id") Long id,
			@RequestParam("status") Integer status) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			CraftsmenDO craftsmenDO = craftsmenService.queryByPrimaryKey(id);

			if (craftsmenDO != null) {
				craftsmenDO.setStatus(status);
				if (!craftsmenService.editCraftsmenDO(craftsmenDO)) {
					jsonObject.put("message", "操作失败");
					return jsonObject.toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	@RequestMapping(value = { "/editAudit" }, method = RequestMethod.POST)
	public String editAudit(@RequestParam("id") long id,
			@RequestParam("audit") int audit) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {

			CraftsmenDO craftsmenDO = craftsmenService.queryByPrimaryKey(id);

			if (craftsmenDO != null) {
				craftsmenDO.setAudit(audit);
				if (!craftsmenService.editCraftsmenDO(craftsmenDO)) {
					jsonObject.put("message", "操作失败");
					return jsonObject.toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	
	@RequestMapping(value = { "/remove" }, method = RequestMethod.POST)
	public String updateCraftsmenDOIsDeleted(@RequestParam("id") long id,
			@RequestParam("isDeleted") int isDeleted) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			CraftsmenDO craftsmenDO = craftsmenService.queryByPrimaryKey(id);
			if (craftsmenDO != null) {
				craftsmenDO.setIsDeleted(isDeleted);

				if (!craftsmenService.editCraftsmenDO(craftsmenDO)) {
					jsonObject.put("message", "操作失败");
					return jsonObject.toString();
				}

			} else {
				jsonObject.put("message", "数据不存在，请核实后重试");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "删除成功");
		return jsonObject.toString();
	}
	
	//根据登录人不同，查询其下面的手艺人
	
	@RequestMapping("/queryCraftsmenDOByRank")
	public String queryCraftsmenDOByDistributorId(CraftsmenQuery craftsmenQuery) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		long userId = craftsmenQuery.getUserId();
		try {
			List<CraftsmenDOCustom> list = new ArrayList<CraftsmenDOCustom>();
			//先判断是否是  // 0为系统管理员 1为经销商 2为店铺 3为创客 4为手艺人
			//总部查询全部的
			if (sysUsersService.queryByPrimaryKey(userId).getGroupId() == 0) {
				list = craftsmenService.queryCraftsmenDOList(craftsmenQuery);
				craftsmenQuery.setIsDeleted(0);
				this.addNameDS(list);
				jsonObject.put("data", JsonResult.buildPaging(list, craftsmenQuery.getsEcho(),
						(long)craftsmenService.selectCraftsmenDOListCount(craftsmenQuery)));
			//经销商查询自己下面的
			}else if(sysUsersService.queryByPrimaryKey(userId).getGroupId() == 1){
				craftsmenQuery.setDistributorId(
						distributorService.selectDistributorDOByUserId(userId).get(0).getId());
				craftsmenQuery.setIsDeleted(0);
				list = craftsmenService.queryCraftsmenDOList(craftsmenQuery);
				this.addNameS(list);
				jsonObject.put("data", JsonResult.buildPaging(list, craftsmenQuery.getsEcho(),
						(long)craftsmenService.selectCraftsmenDOListCount(craftsmenQuery)));
			//店铺查询属于自己的
			}else if(sysUsersService.queryByPrimaryKey(userId).getGroupId() == 2){
				craftsmenQuery.setShopsId(
						shopService.queryShopsDOByUserId(userId).get(0).getShopsId());
				craftsmenQuery.setIsDeleted(0);
				list = craftsmenService.queryCraftsmenDOList(craftsmenQuery);
				jsonObject.put("data", JsonResult.buildPaging(list, craftsmenQuery.getsEcho(),
						(long)craftsmenService.selectCraftsmenDOListCount(craftsmenQuery)));
			}else{
				jsonObject.put("message", "您的身份不正确，请核对后重试！");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "查询成功");
		return jsonObject.toString();
	}
	
	private void addNameS(List<CraftsmenDOCustom> list) throws Exception {
		for (CraftsmenDOCustom cdoc : list) {
			cdoc.setDistributorName(shopService.queryShopsDOById(cdoc.getShopsId()) 
					== null?"无":shopService.queryShopsDOById(cdoc.getShopsId()).getShopsName());
		}
	}

	public void addNameDS(List<CraftsmenDOCustom> list) throws Exception {
		for (CraftsmenDOCustom cdoc : list) {
			cdoc.setDistributorName(distributorService.queryDistributorDOById(cdoc.getDistributorId()) 
					== null?"无":distributorService.queryDistributorDOById(cdoc.getDistributorId()).getName());
		
			cdoc.setDistributorName(shopService.queryShopsDOById(cdoc.getShopsId()) 
					== null?"无":shopService.queryShopsDOById(cdoc.getShopsId()).getShopsName());
		}
	}

	@RequestMapping(value = { "/queryShopsAndOtherShopsList" })
	public String queryShopName(@RequestParam(value = "userId") Long userId) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		try {
			List<DistributorDO> list = distributorService
					.selectDistributorDOByUserId(userId);

			if (list.isEmpty() || list.size() <= 0) {
				jsonObject.put("data", "");
				jsonObject.put("message", "账号不正确，请核对后重试");
			} else {
				Long distributorId = list.get(0).getId();

				List<ShopsDO> list_shops = shopService
						.selectShopBydistributorId(distributorId);
				JSONArray result_list = new JSONArray();
				for (ShopsDO shopDO : list_shops) {
					JSONObject shop = new JSONObject();
					shop.put("shopId", shopDO.getShopsId());
					shop.put("shopsName", shopDO.getShopsName());
					result_list.add(shop);
				}
				jsonObject.put("data", result_list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "查询成功");

		return jsonObject.toString();
	}
	

	@RequestMapping(value = { "/addUserInfo" }, method = RequestMethod.POST)
	public String addUserInfo(@RequestParam(value = "craftsmenId") Long craftsmenId,
			@RequestParam(value = "userName") String userName,
			@RequestParam(value = "mobile") String mobile,
			@RequestParam(value = "name",required = false) String name,
			@RequestParam(value = "password") String password) {

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
			sysUsersDO.setName(name);
			sysUsersDO.setIsDeleted(0);
			sysUsersDO.setStatus(0);
			sysUsersDO.setMobile(mobile);
			sysUsersDO.setGroupId(new Long(4));//默认创建的用户的分组是手艺人
			sysUsersDO.setCreated(Integer.valueOf((System.currentTimeMillis() / 1000)+""));
			sysUsersDO.setUpdated(Integer.valueOf((System.currentTimeMillis() / 1000)+""));
			
			Result<Long> result = sysUsersService.addSysUsersDOAndRole(
					sysUsersDO, new Long(17));
			
			if (result == null || !result.isSuccess()) {
				jsonObject.put("message", "数据操作失败");
				return jsonObject.toString();
			} else {
				CraftsmenDO craftsmenDO = craftsmenService.queryByPrimaryKey(craftsmenId);
				if (craftsmenDO != null) {
					craftsmenDO.setSysUserId(Long.valueOf(result.getResult()+""));
				}
				long result_ = craftsmenService.addCraftsmenSysUser(craftsmenDO);
				if (result_ <= 0) {
					jsonObject.put("message", "添加失败");
					return jsonObject.toString();
				}
				jsonObject.put("success", true);
				jsonObject.put("message", "添加成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
}
