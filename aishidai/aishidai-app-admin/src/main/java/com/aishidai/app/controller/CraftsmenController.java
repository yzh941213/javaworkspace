package com.aishidai.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.aishidai.app.model.pojo.ShopsDO;
import com.aishidai.app.model.pojo.SysUsersDO;
import com.aishidai.app.model.query.CraftsmenQuery;
import com.aishidai.app.service.CraftsmenService;
import com.aishidai.app.service.DistributorService;
import com.aishidai.app.service.ShopService;
import com.aishidai.app.service.SysUsersService;
import com.aishidai.app.util.PhotoUtil;
import com.aishidai.app.utils.PasswordHash;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


@Controller
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
	@Autowired
	private PropertyService propertyService;
	/**
	 * 
	 * @param aoData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.do")
	@ResponseBody
	public String queryCraftsmens(
			@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,
			HttpServletRequest request) {

		int iDisplayStart = 0; // 起始索引
		int iDisplayLength = 0; // 每页显示的行数
		String sEcho = "";
		
		if (!aoData.equals("")) {
			JSONArray jsonarray = JSONArray.parseArray(aoData);
			for (int i = 0; i < jsonarray.size(); i++) {
				JSONObject obj = (JSONObject) jsonarray.get(i);
				if (obj.get("name").equals("sEcho")) {
					sEcho = obj.get("value").toString();
				}
				if (obj.get("name").equals("iDisplayStart")) {
					iDisplayStart = obj.getIntValue("value");
				}
				if (obj.get("name").equals("iDisplayLength")) {
					iDisplayLength = obj.getIntValue("value");
				}
			}
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("pageSize", iDisplayLength);
		jsonObject.put("sEcho", sEcho);
		jsonObject.put("success", false);

		CraftsmenQuery query = new CraftsmenQuery();
		query.setStartRow(iDisplayStart);
		query.setPageSize(iDisplayLength);
		query.setSortField("id");
		query.setOrder("desc");
		SysUsersDO sysUsersDO = (SysUsersDO) request.getSession().getAttribute(
				LoginConstant.USER_SESSION_KEY);
		
		if (sysUsersDO.getGroupId() == 1) {
			DistributorDO distributorDO = (DistributorDO) request.getSession().getAttribute(LoginConstant.USER_DISTRIBUTOR_SESSION_KEY);
			if (distributorDO != null) {
				query.setDistributorId(distributorDO.getId());
			}
		} else if (sysUsersDO.getGroupId() == 2) {
			ShopsDO shopDO = (ShopsDO) request.getSession().getAttribute(
					LoginConstant.USER_SHOP_SESSION_KEY);
			if (shopDO != null) {
				query.setShopsId(shopDO.getShopsId());
			} else {
				throw new Exception("服务器开小差了");
			}
		}

		Result<List<CraftsmenDO>> result = craftsmenService.queryCraftsmenDOList(query);
		
		List<CraftsmenDO> list = result.getResult();
		for (int k = 0; k < list.size(); k++) {
			
			CraftsmenDO craftsmenDO = list.get(k);
			
			if (craftsmenDO.getDistributorId() != null) {
				Result<DistributorDO> result1 = distributorService
						.queryDistributorDOById(craftsmenDO.getDistributorId());
				if (result1.getResult() != null) {
					craftsmenDO.setDistributorIdName(result1.getResult()
							.getName());
				}
			}
			
			
			if (craftsmenDO.getShopsId() != null) {
				Result<ShopDO> result2 = shopManager
						.queryShopDOById(craftsmenDO.getShopsId());
				if (result2.getResult() != null) {
					craftsmenDO.setShopsIdName(result2.getResult()
							.getShopsName());
				}
			}else{
				
				craftsmenDO.setShopsIdName("无");
			}
			
			String services = craftsmenDO.getServiceId();
			if (services != null) {
				String[] arr = services.split("-");
				String names = "";
				for (int i = 1; i < arr.length; i++) {
					Result<PropertyDO> r = propertyManager
							.queryPropertyDOById(new Long(arr[i]));
					if (r.getResult() != null) {
						names = names + "," + r.getResult().getProName();
					}
				}
				if (names.length() > 1) {
					craftsmenDO.setServiceIdName(names.substring(1,
							names.length()));
				}
			}
			String titleId = craftsmenDO.getTitleId();
			if (titleId != null) {
				String[] arr = titleId.split("-");
				String names = "";
				for (int i = 1; i < arr.length; i++) {
					Result<PropertyDO> r = propertyManager
							.queryPropertyDOById(new Long(arr[i]));
					if (r.getResult() != null) {
						names = names + "," + r.getResult().getProName();
					}
				}
				if (names.length() > 1) {
					craftsmenDO.setTitleIdName(names.substring(1,
							names.length()));
				}
			}
		}
		return returnString(result, jsonObject, query);
	}
	
	
	
	public String returnString(List<CraftsmenDO> list,
			JSONObject jsonObject, CraftsmenQuery query) {
		if (list.isEmpty() && list.size() >= 0) {
			JSONArray itemList = new JSONArray();
			for (CraftsmenDO craftsmenDO : list) {
				JSONObject item = new JSONObject();
				item.put("id", craftsmenDO.getId());
				item.put("shopsId", craftsmenDO.getShopsId());
				item.put("shopsIdName", craftsmenDO.getShopName());
				item.put("craftsmanName", craftsmenDO.getCraftsmanName());
				item.put("distributorId", craftsmenDO.getDistributorId());
				item.put("distributorIdName",craftsmenDO.getDistributorName());
				item.put("craftsmanUrl", craftsmenDO.getCraftsmanUrl());
				item.put("skill", craftsmenDO.getSkill());
				item.put("telephone", craftsmenDO.getTelephone());
				item.put("titleId", craftsmenDO.getTitleId());
				item.put("titleIdName", craftsmenDO.getTitleName());
				item.put("province", craftsmenDO.getProvince());
				item.put("city", craftsmenDO.getCity());
				item.put("address", craftsmenDO.getAddress());
				item.put("isDeleted", craftsmenDO.getIsDeleted());
				item.put("sysUserId", craftsmenDO.getSysUserId());
				item.put("serviceId", craftsmenDO.getServiceId());
				item.put("serviceIdName", craftsmenDO.getServiceName());
				item.put("created", craftsmenDO.getCreated());
				item.put("updated", craftsmenDO.getUpdated());
				item.put("status", craftsmenDO.getStatus());
				item.put("wechat", craftsmenDO.getWechat());
				item.put("audit", craftsmenDO.getAudit());
				itemList.add(item);
			}
			jsonObject.put("iTotalRecords", query.getTotalItem()); 
			jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); 
			jsonObject.put("aaData", itemList);
			jsonObject.put("success", true);
		} else {
			jsonObject.put("message", "未搜索到数据，请稍后重试");
		}
		return jsonObject.toString();
	}
	
	
	/**
	 * 查询详细信息
	 */
	@RequestMapping("/queryDetail.do")
	@ResponseBody
	public String queryCraftsmens(
			@RequestParam(value = "craftsmenId") long craftsmenId) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		CraftsmenDO craftsmenDO = craftsmenService
				.queryByPrimaryKey(craftsmenId);
		if (craftsmenDO == null) {
			jsonObject.put("message", "信息不存在，请核对后重试");
			return jsonObject.toString();
		}
		Long shopId = craftsmenDO.getShopsId();
		try {
			if (shopId != null) {
				ShopsDO shop = shopService.queryShopsDOById(shopId);
				String shopName = shop.getShopsName();
				craftsmenDO.setShopName(shopName);
				jsonObject.put("message", "查询成功");
				jsonObject.put("type", "shops");

			} else {
				jsonObject.put("message", "商铺名称不存在");
				craftsmenDO.setShopName("无");
				jsonObject.put("type", "");
			}
			jsonObject.put("success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonObject.put("data", JSONObject.toJSON(craftsmenDO));
		return jsonObject.toString();
	}
	
	@RequestMapping(value = { "/save.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String addCraftsmenDO(
			@RequestParam(value = "shopsId", defaultValue = "", required = false) Long shopsId,
			@RequestParam(value = "craftsmanName",required = true) String craftsmanName,
			@RequestParam(value = "distributorId", required = true) Long distributorId,
			@RequestParam(value = "craftsmanUrl", defaultValue = "", required = false) String craftsmanUrl,
			@RequestParam(value = "skill", defaultValue = "0", required = false) String skill,
			@RequestParam(value = "telephone",required = true) String telephone,
			@RequestParam(value = "titleId", required = false) String titleId,
			@RequestParam(value = "province", required = false) String province,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "area", required = false) String area,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "reserveNumber", required = false) Integer reserveNumber,
			@RequestParam(value = "serviceId", required = false) String serviceId,
			@RequestParam(value = "wechat", required = false) String wechat,
			@RequestParam(value = "status", required = true) Integer status,
			HttpServletRequest request) {

		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		List<CraftsmenDO> list = craftsmenService.queryCraftsmenExist(craftsmanName,telephone);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTelephone().endsWith(telephone)
				&& list.get(i).getCraftsmanName().equals(craftsmanName)) {
				jsonObject.put("message", "该手艺人信息已存在，请核对后重试！");
	            return jsonObject.toString();
			}
		}
		
		
		CraftsmenDO craftsmenDO = new CraftsmenDO();
		craftsmenDO.setAddress(address);
		craftsmenDO.setCity(city);
		craftsmenDO.setArea(area);
		craftsmenDO.setCraftsmanName(craftsmanName);
		
		if (craftsmanUrl != null && !"".equals(craftsmanUrl)) {
			craftsmanUrl = PhotoUtil.addPhoto(craftsmanUrl);
		}
		
		craftsmenDO.setCraftsmanUrl(craftsmanUrl);
		
		craftsmenDO.setDistributorId(Integer.valueOf(distributorId+""));
		craftsmenDO.setIsDeleted((byte)0);
		
		craftsmenDO.setProvince(province);
		
		if (StringUtils.isNotBlank(serviceId)) {
			serviceId = "-" + serviceId + "-";
		}
		craftsmenDO.setServiceId(serviceId);
		
		craftsmenDO.setShopsId(shopsId);

		
		craftsmenDO.setSkill(skill);
		craftsmenDO.setStatus(status);
		
		craftsmenDO.setTelephone(telephone);
		craftsmenDO.setWechat(wechat);
		
		if (StringUtils.isNotBlank(titleId)) {
			titleId = "-" + titleId + "-";
		}
		craftsmenDO.setTitleId(titleId);

		Long result = craftsmenService.insertCraftsmenDO(craftsmenDO);
		
		if (result.longValue() <= 0) {
			jsonObject.put("message", "数据插入失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "数据插入成功");
		
		return jsonObject.toString();
	}
	
	@RequestMapping(value = { "/edit.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String editCraftsmenDO(
			@RequestParam(value = "craftsmenId", required = true) Long craftsmenId,
			@RequestParam(value = "shopsId", defaultValue = "", required = false) Long shopsId,
			@RequestParam(value = "craftsmanName",required = true) String craftsmanName,
			@RequestParam(value = "distributorId", defaultValue = "0", required = false) Long distributorId,
			@RequestParam(value = "craftsmanUrl", defaultValue = "", required = false) String craftsmanUrl,
			@RequestParam(value = "skill", defaultValue = "0", required = false) String skill,
			@RequestParam(value = "telephone",required = true) String telephone,
			@RequestParam(value = "titleId", required = false) String titleId,
			@RequestParam(value = "province", required = false) String province,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "area", required = false) String area,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "serviceId", required = false) String serviceId,
			@RequestParam(value = "wechat", required = false) String wechat,
			@RequestParam(value = "status", required = false) Integer status,
			HttpServletRequest request) {

		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		CraftsmenDO craftsmenDO = craftsmenService.queryByPrimaryKey(craftsmenId);
		if (craftsmenDO != null) {
			if (craftsmenDO.getTelephone().equals(telephone) 
					&& craftsmenDO.getCraftsmanName().equals(craftsmanName)) {
				
			}else{
				List<CraftsmenDO> list = craftsmenService.queryCraftsmenExist(craftsmanName,telephone);
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getTelephone().endsWith(telephone)
						&& list.get(i).getCraftsmanName().equals(craftsmanName)) {
						jsonObject.put("message", "该手艺人信息已存在，请核对后重试！");
			            return jsonObject.toString();
					}
				}
			}
		}
		
		craftsmenDO.setAddress(address);
		craftsmenDO.setCity(city);
		craftsmenDO.setArea(area);
		craftsmenDO.setCraftsmanName(craftsmanName);
		
		if (craftsmanUrl != null && !"".equals(craftsmanUrl)) {
			craftsmanUrl = PhotoUtil.addPhoto(craftsmanUrl);
		}
		craftsmenDO.setCraftsmanUrl(craftsmanUrl);
		craftsmenDO.setDistributorId(Integer.valueOf(distributorId+""));
		craftsmenDO.setProvince(province);
		
		if (StringUtils.isNotBlank(serviceId)) {
			serviceId = "-" + serviceId + "-";
		}
		craftsmenDO.setServiceId(serviceId);
		
		craftsmenDO.setShopsId(shopsId);

		craftsmenDO.setSkill(skill);
		craftsmenDO.setStatus(status);
		
		craftsmenDO.setTelephone(telephone);
		craftsmenDO.setWechat(wechat);
		if (StringUtils.isNotBlank(titleId)) {
			titleId = "-" + titleId + "-";
		}
		craftsmenDO.setTitleId(titleId);

		Long result = craftsmenService.editCraftsmenDO(craftsmenDO);
		if (result.longValue() <= 0) {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}
	
	
	@RequestMapping(value = { "/editStatus.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String editStatus(@RequestParam("id") Long id,
			@RequestParam("status") Integer status) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		CraftsmenDO craftsmenDO = craftsmenService.queryByPrimaryKey(id);
		if (craftsmenDO != null) {
			craftsmenDO.setStatus(status);
			long result = craftsmenService.editCraftsmenDO(craftsmenDO);
			if (result <= 0 ) {
				jsonObject.put("message", "操作失败");
				return jsonObject.toString();
			}
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	@RequestMapping(value = { "/editAudit.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String editAudit(@RequestParam("id") Long id,
			@RequestParam("audit") Integer audit) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		CraftsmenDO craftsmenDO = craftsmenService.queryByPrimaryKey(id);
		if (craftsmenDO != null) {
			craftsmenDO.setAudit(audit);
			long result = craftsmenService.editCraftsmenDO(craftsmenDO);
			if (result <= 0 ) {
				jsonObject.put("message", "操作失败");
				return jsonObject.toString();
			}
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	
	@RequestMapping(value = { "/remove.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateCraftsmenDOIsDeleted(@RequestParam("id") Long id,
			@RequestParam("isDeleted") byte isDeleted) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		CraftsmenDO craftsmenDO = craftsmenService.queryByPrimaryKey(id);
		if (craftsmenDO != null) {
			craftsmenDO.setIsDeleted(isDeleted);
			long result = craftsmenService.editCraftsmenDO(craftsmenDO);
			if (result <= 0 ) {
				jsonObject.put("message", "操作失败");
				return jsonObject.toString();
			}
		}else{
			jsonObject.put("message", "数据不存在，请核实后重试");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "删除成功");
		return jsonObject.toString();
	}
	
	@RequestMapping("/queryCraftsmenDOByDistributorId.do")
	@ResponseBody
	public String queryCraftsmenDOByDistributorId(
			@RequestParam(value = "distributorId") long distributorId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		List<CraftsmenDO> list = craftsmenService
				.queryCraftsmenDOByDistributorId(distributorId);
		jsonObject.put("success", true);
		jsonObject.put("message", "成功");
		jsonObject.put("data", JSONArray.toJSON(list));
		return jsonObject.toString();

	}
	
	@RequestMapping(value = { "/queryShopsAndOtherShopsList.do" })
	@ResponseBody
	public String queryShopName(@RequestParam(value = "userId") Long userId) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

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
		jsonObject.put("success", true);
		jsonObject.put("message", "查询成功");

		return jsonObject.toString();
	}
	

	@RequestMapping(value = { "/addUserInfo.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String addUserInfo(@RequestParam(value = "craftsmenId") Long craftsmenId,
			@RequestParam(value = "userName") String userName,
			@RequestParam(value = "mobile") String mobile,
			@RequestParam(value = "name",required = false) String name,
			@RequestParam(value = "password") String password) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		try {
			SysUsersDO sysUsersDO = sysUsersService.querySysUsersByUserName(userName);
					
			if (sysUsersDO != null) {
				jsonObject.put("message", "该用户名已存在,请核对后重试");
				return jsonObject.toString();
			}

			sysUsersDO.setUserName(userName);
			sysUsersDO.setPassword(PasswordHash.createHash(password));
			sysUsersDO.setName(name);
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
					craftsmenDO.setSysUserId(Integer.valueOf(result.getResult()+""));
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
