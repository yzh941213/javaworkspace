package com.zhezhuo.web.home.module.screen.manager;

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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.CraftsmenManager;
import com.zhezhuo.biz.manager.DistributorManager;
import com.zhezhuo.biz.manager.PropertyManager;
import com.zhezhuo.biz.manager.ShopManager;
import com.zhezhuo.biz.manager.SysUsersManager;
import com.zhezhuo.biz.util.PasswordHash;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.CraftsmenDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.entity.PropertyDO;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.entity.SysUsersDO;
import com.zhezhuo.model.query.CraftsmenQuery;
import com.zhezhuo.model.query.MakerQuery;
import com.zhezhuo.web.home.common.LoginConstant;
import com.zhezhuo.web.util.PhotoUtil;


@Controller
@RequestMapping("/manager/craftsmen")
public class CraftsmenController {

	private static final Logger log = LoggerFactory.getLogger(CraftsmenController.class); 
	@Autowired
	private CraftsmenManager craftsmenManager;
	@Autowired
	private SysUsersManager sysUsersManager;
	@Autowired
	private DistributorManager distributorManager;
	@Autowired
	private ShopManager shopManager;
	@Autowired
	private PropertyManager propertyManager;
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
			HttpServletRequest request) throws Exception {

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
			ShopDO shopDO = (ShopDO) request.getSession().getAttribute(
					LoginConstant.USER_SHOP_SESSION_KEY);
			if (shopDO != null) {
				query.setShopsId(shopDO.getShopsId());
			} else {
				throw new Exception("服务器开小差了");
			}
		}

		Result<List<CraftsmenDO>> result = craftsmenManager.queryCraftsmenDOList(query);
		
		List<CraftsmenDO> list = result.getResult();
		for (int k = 0; k < list.size(); k++) {
			
			CraftsmenDO craftsmenDO = list.get(k);
			
			if (craftsmenDO.getDistributorId() != null) {
				Result<DistributorDO> result1 = distributorManager
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
	public String returnString(Result<List<CraftsmenDO>> result,
			JSONObject jsonObject, CraftsmenQuery query) {
		if (result != null && result.isSuccess()) {
			List<CraftsmenDO> itemDOList = result.getResult();
			JSONArray itemList = new JSONArray();
			for (CraftsmenDO craftsmenDO : itemDOList) {
				JSONObject item = new JSONObject();
				item.put("id", craftsmenDO.getId());
				item.put("shopsId", craftsmenDO.getShopsId());

				
				item.put("shopsIdName", craftsmenDO.getShopsIdName());
				
				item.put("craftsmanName", craftsmenDO.getCraftsmanName());
				item.put("distributorId", craftsmenDO.getDistributorId());
				item.put("distributorIdName",craftsmenDO.getDistributorIdName());
				item.put("craftsmanUrl", craftsmenDO.getCraftsmanUrl());
				item.put("skill", craftsmenDO.getSkill());
				item.put("telephone", craftsmenDO.getTelephone());
				item.put("titleId", craftsmenDO.getTitleId());
				item.put("titleIdName", craftsmenDO.getTitleIdName());
				item.put("province", craftsmenDO.getProvince());
				item.put("city", craftsmenDO.getCity());
				item.put("address", craftsmenDO.getAddress());
				item.put("reserveNumber", craftsmenDO.getReserveNumber());
				item.put("isDeleted", craftsmenDO.getIsDeleted());
				item.put("sysUserId", craftsmenDO.getSysUserId());
				item.put("serviceId", craftsmenDO.getServiceId());
				item.put("serviceIdName", craftsmenDO.getServiceIdName());
				item.put("created", craftsmenDO.getCreated());
				item.put("updated", craftsmenDO.getUpdated());
				item.put("status", craftsmenDO.getStatus());
				item.put("wechat", craftsmenDO.getWechat());
				item.put("orderPercentage", craftsmenDO.getOrderPercentage());
				item.put("servicePercentage",craftsmenDO.getServicePercentage());
				item.put("audit", craftsmenDO.getAudit());
				itemList.add(item);
			}
			jsonObject.put("iTotalRecords", query.getTotalItem()); // 实际的行数
			jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); // 显示的行数,这个要和上面
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
	@RequestMapping("/detail.do")
	@ResponseBody
	public String queryCraftsmens(
			@RequestParam(value = "craftsmenId") long craftsmenId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<CraftsmenDO> result = craftsmenManager
				.queryCraftsmenDOById(craftsmenId);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "查询失败");
			return jsonObject.toString();
		}
		Long shopId = result.getResult().getShopsId();
		Long otherShopId = result.getResult().getOtherShopsId();
		
		if (shopId != null) {
			Result<ShopDO> m;
			try {
				m = shopManager.queryShopDOById(shopId);
				String shopName = m.getResult().getShopsName();
				result.getResult().setShopsIdName(shopName);
				jsonObject.put("message", "成功");
				jsonObject.put("type", "shops");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			jsonObject.put("message", "商铺名称不存在");
			result.getResult().setShopsIdName("无");
			jsonObject.put("type", "");
		}
		jsonObject.put("success", true);

		jsonObject.put("data", JSONObject.toJSON(result.getResult()));
		return jsonObject.toString();
	}
	
	/**
	 * 添加或修改手艺人接口
	 */
	@RequestMapping(value = { "/edit.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String editCraftsmenDO(
			@RequestParam(value = "craftsmenId", required = false,defaultValue="0") Long craftsmenId,
			@RequestParam(value = "shopsId", defaultValue = "", required = false) Long shopsId,
			@RequestParam(value = "introduce", defaultValue = "", required = false) String introduce,
			@RequestParam(value = "craftsmanName", defaultValue = "", required = false) String craftsmanName,
			@RequestParam(value = "distributorId", defaultValue = "0", required = false) Long distributorId,
			@RequestParam(value = "craftsmanUrl", defaultValue = "", required = false) String craftsmanUrl,
			@RequestParam(value = "skill", defaultValue = "0", required = false) String skill,
			@RequestParam(value = "telephone", defaultValue = "", required = false) String telephone,
			@RequestParam(value = "titleId", required = false) String titleId,
			@RequestParam(value = "province", required = false) String province,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "area", required = false) String area,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "reserveNumber", required = false) Integer reserveNumber,
			@RequestParam(value = "isDeleted", required = false ,defaultValue="0") Integer isDeleted,
			@RequestParam(value = "serviceId", required = false) String serviceId,
			@RequestParam(value = "wechat", required = false) String wechat,
			@RequestParam(value = "status", required = false) Integer status,
			HttpServletRequest request) {

		//不允许信息一样的手艺人创建
		
		//禁止信息一样的创客创建
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		if (craftsmenId == 0) {
			CraftsmenQuery query = new CraftsmenQuery();
			Result<List<CraftsmenDO>> queryCraftsmenDOList = craftsmenManager.queryCraftsmenDOList(query);
			for (int i = 0; i < queryCraftsmenDOList.getResult().size(); i++) {
				if (queryCraftsmenDOList.getResult().get(i).getTelephone().endsWith(telephone)
					&& queryCraftsmenDOList.getResult().get(i).getCraftsmanName().equals(craftsmanName)) {
					jsonObject.put("message", "该手艺人信息已存在，请核对后重试！");
		            return jsonObject.toString();
				}
			}
		}
		
		
		CraftsmenDO craftsmenDO = new CraftsmenDO();
		craftsmenDO.setId(craftsmenId);
		craftsmenDO.setAddress(address);
		craftsmenDO.setCity(city);
		craftsmenDO.setArea(area);
		craftsmenDO.setCraftsmanName(craftsmanName);
		
		if (craftsmanUrl != null && !"".equals(craftsmanUrl)) {
			craftsmanUrl = PhotoUtil.addPhoto(craftsmanUrl);
		}
		craftsmenDO.setCraftsmanUrl(craftsmanUrl);
		SysUsersDO userDO = (SysUsersDO) request.getSession().getAttribute(
				LoginConstant.USER_SESSION_KEY);
		if (distributorId == 0) {
			if (userDO.getGroupId() == 1) {
				DistributorDO distributorDO = (DistributorDO) request
						.getSession().getAttribute(
								LoginConstant.USER_DISTRIBUTOR_SESSION_KEY);
				distributorId = distributorDO.getId();
			}
		}
		craftsmenDO.setDistributorId(distributorId);
		craftsmenDO.setIntroduce(introduce);
		craftsmenDO.setIsDeleted(isDeleted);
		craftsmenDO.setProvince(province);
		craftsmenDO.setReserveNumber(reserveNumber);
		if (StringUtils.isNotBlank(serviceId)) {
			serviceId = "-" + serviceId + "-";
		}
		craftsmenDO.setServiceId(serviceId);
		
		if (shopsId == null) {
			if (userDO.getGroupId() == 2) {
				ShopDO shopDO = (ShopDO) request.getSession().getAttribute(
						LoginConstant.USER_SHOP_SESSION_KEY);
				shopsId = shopDO.getShopsId();
				System.out.println("===" + shopsId);
			}
		}
		craftsmenDO.setShopsId(shopsId);

		
		craftsmenDO.setSkill(skill);
		craftsmenDO.setStatus(status);
		craftsmenDO.setIsDeleted(isDeleted);
		
		craftsmenDO.setTelephone(telephone);
		craftsmenDO.setWechat(wechat);
		if (StringUtils.isNotBlank(titleId)) {
			titleId = "-" + titleId + "-";
		}
		craftsmenDO.setTitleId(titleId);

		Result<Long> result = craftsmenManager.editCraftsmenDO(craftsmenDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "数据操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "数据更新成功");
		return jsonObject.toString();
	}
	
	
	/**
	 * 更新记录状态(删除)
	 */
	@RequestMapping(value = { "/status.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateCraftsmenDOStatus(@RequestParam("id") Long id,
			@RequestParam("status") Integer status) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		CraftsmenDO craftsmenDO = new CraftsmenDO();
		craftsmenDO.setId(id);
		craftsmenDO.setStatus(status);

		Result<Integer> result = craftsmenManager
				.updateCraftsmenStatus(craftsmenDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	
	
	/**
	 * 审核
	 * @return
	 */
	@RequestMapping(value = { "/audit.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateShopDOAudit(@RequestParam("id") Long id,
			@RequestParam("audit") Integer audit) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		CraftsmenDO craftsmenDO = new CraftsmenDO();
		craftsmenDO.setId(id);
		craftsmenDO.setAudit(audit);

		Result<Integer> result = craftsmenManager
				.updateCraftsmenAudit(craftsmenDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	
	@RequestMapping(value = { "/del.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateCraftsmenDOIsDeleted(@RequestParam("id") Long id,
			@RequestParam("isDeleted") Integer isDeleted) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		CraftsmenDO craftsmenDO = new CraftsmenDO();
		craftsmenDO.setId(id);
		craftsmenDO.setIsDeleted(isDeleted);

		Result<Integer> result = craftsmenManager
				.updateCraftsmenIsDeleted(craftsmenDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	
	@RequestMapping("/child.do")
	@ResponseBody
	public String queryCraftsmenDOByParentId(
			@RequestParam(value = "distributorId") long distributorId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<List<CraftsmenDO>> result = craftsmenManager
				.queryCraftsmenDOByDistributorId(distributorId);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "查询失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "成功");
		jsonObject.put("data", JSONArray.toJSON(result.getResult()));
		return jsonObject.toString();

	}
	
	
	/**
	 * 查询商铺（包含异业和普通）名称
	 */
	@RequestMapping(value = { "/queryShopsAndOtherShopsList.do" })
	@ResponseBody
	public String queryShopName (
			@RequestParam(value = "sysUserId") Long sysUserId) throws Exception {
		JSONObject jsonObject = new JSONObject();
		Result<DistributorDO> result1 = distributorManager
				.queryDistributorDOBySysUserId(sysUserId);
		if (result1.getResult() == null || result1.getResult().getId() == null) {
			jsonObject.put("aaData", "该用户不是经销商");
		} else {
			Long distributorId = result1.getResult().getId();
			//查询出来的是所有此经销商下面的普通店铺
			Result<List<ShopDO>> result = shopManager
					.queryShopNameBydistributorId(distributorId);// 理发店
			List<ShopDO> itemDOList = result.getResult();
			JSONArray itemList = new JSONArray();
			for (ShopDO shopDO : itemDOList) {
				JSONObject shops = new JSONObject();
				shops.put("shopId", shopDO.getShopsId());
				shops.put("shopsName", shopDO.getShopsName());
				itemList.add(shops);
			}
			jsonObject.put("aaData", itemList);
		}
		jsonObject.put("success", true);
		
		return jsonObject.toString();
	}
	

	@RequestMapping(value = { "/editSysUser.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String editSysUserDO(
			@RequestParam(value = "entityId") Long entityId,
			@RequestParam(value = "sysUserName") String sysUserName,
			@RequestParam(value = "sysMobile") String sysMobile,
			@RequestParam(value = "sysPassword") String sysPassword) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			SysUsersDO query = sysUsersManager
					.querySysUsersByUserName(sysMobile);
			if (query != null) {
				jsonObject.put("message", "该用户名已存在");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SysUsersDO sysUsersDO = new SysUsersDO();
		sysUsersDO.setUserName(sysMobile);
		sysUsersDO.setPassword(PasswordHash.createHash(sysPassword));
		sysUsersDO.setName(sysUserName);
		sysUsersDO.setMobile(sysMobile);
		sysUsersDO.setGroupId(new Long(4));// 0为系统管理员 1为经销商 2为店铺 3为创客 4为手艺人
		sysUsersDO
				.setCreated(String.valueOf(System.currentTimeMillis() / 1000));
		sysUsersDO
				.setUpdated(String.valueOf(System.currentTimeMillis() / 1000));
		//
		Result<Long> result = sysUsersManager.addSysUsersDOAndRole(sysUsersDO,
				new Long(17));
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "数据操作失败");
			return jsonObject.toString();
		} else {
			CraftsmenDO craftsmenDO = new CraftsmenDO();
			craftsmenDO.setId(entityId);
			craftsmenDO.setSysUserId(result.getResult());
			result = craftsmenManager.updateCraftsmenSysUserId(craftsmenDO);
			if (result == null || !result.isSuccess()) {
				jsonObject.put("message", "数据操作失败");
				return jsonObject.toString();
			}
			jsonObject.put("success", true);
			jsonObject.put("message", "数据更新成功");
		}
		return jsonObject.toString();
	}
}
