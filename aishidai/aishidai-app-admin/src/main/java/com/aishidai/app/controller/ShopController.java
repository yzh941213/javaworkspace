package com.zhezhuo.web.home.module.screen.manager;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.AttributeManager;
import com.zhezhuo.biz.manager.DeviceManager;
import com.zhezhuo.biz.manager.DistributorManager;
import com.zhezhuo.biz.manager.PropertyManager;
import com.zhezhuo.biz.manager.ShopManager;
import com.zhezhuo.biz.manager.SysUsersManager;
import com.zhezhuo.biz.util.PasswordHash;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.AttributeDO;
import com.zhezhuo.model.entity.DeviceDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.PropertyDO;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.entity.SysUsersDO;
import com.zhezhuo.model.query.ShopQuery;
import com.zhezhuo.web.home.common.LoginConstant;
import com.zhezhuo.web.util.PhotoUtil;

/**
 * 
 * @author 51147
 *
 */
@Controller
@RequestMapping("/manager/shop")
public class ShopController {

	@Autowired
	private ShopManager shopManager;
	@Autowired
	private SysUsersManager sysUsersManager;
	@Autowired
	private PropertyManager propertyManager;
	@Autowired
	private AttributeManager attributeManager;
	@Autowired
	private DistributorManager distributorManager;
	@Autowired
	private DeviceManager deviceManager;
	
	/**
	 * 查询店铺列表
	 * @return
	 */
	@RequestMapping(value = "/shopList.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String queryShops(@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,
			                 @RequestParam(value = "order", defaultValue = "desc", required = false) String order,
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

		ShopQuery query = new ShopQuery();
		query.setStartRow(iDisplayStart);
		query.setPageSize(iDisplayLength);
		
		query.setOrder(order);
		query.setSortField("shopsId");
		
		SysUsersDO sysUsersDO = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		Result<List<ShopDO>> result = null;
		try {
		    //登录用户为经销商
			if(sysUsersDO.getGroupId()==1){
				DistributorDO distributorDO = (DistributorDO) request.getSession()
						.getAttribute(LoginConstant.USER_DISTRIBUTOR_SESSION_KEY);
				query.setDistributorId(distributorDO.getId());
				
				result = shopManager.queryShopDOByDistributorId(query);
				
			//登录的用户为管理员
			}else if(sysUsersDO.getGroupId()==0){
				result = shopManager.queryShopDOList(query);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		List<ShopDO> list = result.getResult();
		for (int k = 0; k < list.size(); k++) {
			ShopDO shopDO = list.get(k);
			if (shopDO.getDistributorId() != null) {
				Result<DistributorDO> r = distributorManager.queryDistributorDOById(shopDO.getDistributorId());
				if (r.getResult() != null) {
					shopDO.setDistributorIdName(r.getResult().getName());
				}
			}
			
			long deviceId = shopDO.getDeviceId();//得到设备的ID号
			if (deviceId != 0) {
				Result<DeviceDO> result_device = deviceManager.queryDeviceDOById(deviceId);
				if (result_device.getResult() != null) {
					DeviceDO result_deviceDO = result_device.getResult();
					shopDO.setDeviceNum(result_deviceDO.getProductNo());
				}
			}
			
			
			String services = shopDO.getServices();
			if (services != null) {
				String[] arr = services.split("-");
				String names = "";
				for (int i = 1; i < arr.length; i++) {
					Result<PropertyDO> r = propertyManager.queryPropertyDOById(new Long(arr[i]));
					if (r.getResult() != null) {
						names = names + "," + r.getResult().getProName();
					}
				}
				if (names.length() > 1) {
					shopDO.setServicesName(names.substring(1, names.length()));
				}
			}
			
			
			String servicesType = shopDO.getServicesType();
			if (servicesType != null) {
				String[] arr = servicesType.split("-");
				String names = "";
				for (int i = 1; i < arr.length; i++) {
					Result<AttributeDO> r = attributeManager.queryAttributeDOById(new Long(arr[i]));
					if (r.getResult() != null) {
						names = names + "," + r.getResult().getAttrName();
					}
				}
				if (names.length() > 1) {
					shopDO.setServicesTypeName(names.substring(1, names.length()));
				}
			}
		}
		return returnString(result, jsonObject, query);
	}
	
	/**
	 * 查询异业列表
	 * @return
	 */
	@RequestMapping(value = "/otherShopList.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String queryOtherShops(@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,
			                 @RequestParam(value = "order", defaultValue = "desc", required = false) String order,
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

		ShopQuery query = new ShopQuery();
		query.setStartRow(iDisplayStart);
		query.setPageSize(iDisplayLength);
		
		query.setOrder(order);
		query.setSortField("shopsId");
		SysUsersDO sysUsersDO = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		Result<List<ShopDO>> result = null;
		try {
		    //登录用户为经销商
			if(sysUsersDO.getGroupId()==1){
				DistributorDO distributorDO = (DistributorDO) request.getSession()
						.getAttribute(LoginConstant.USER_DISTRIBUTOR_SESSION_KEY);
				query.setDistributorId(distributorDO.getId());
				
				result = shopManager.queryOtherShopDOByDistributorId(query);
				
			//登录的用户为管理员
			}else if(sysUsersDO.getGroupId()==0){
				result = shopManager.queryOtherShopDOList(query);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
				
		List<ShopDO> list = result.getResult();
		for (int k = 0; k < list.size(); k++) {
			ShopDO shopDO = list.get(k);
			if (shopDO.getDistributorId() != null) {
				Result<DistributorDO> r = distributorManager.queryDistributorDOById(shopDO.getDistributorId());
				if (r.getResult() != null) {
					shopDO.setDistributorIdName(r.getResult().getName());
				}
			}
			String services = shopDO.getServices();
			if (services != null) {
				String[] arr = services.split("-");
				String names = "";
				for (int i = 1; i < arr.length; i++) {
					Result<PropertyDO> r = propertyManager.queryPropertyDOById(new Long(arr[i]));
					if (r.getResult() != null) {
						names = names + "," + r.getResult().getProName();
					}
				}
				if (names.length() > 1) {
					shopDO.setServicesName(names.substring(1, names.length()));
				}
			}
			String servicesType = shopDO.getServicesType();
			if (servicesType != null) {
				String[] arr = servicesType.split("-");
				String names = "";
				for (int i = 1; i < arr.length; i++) {
					Result<AttributeDO> r = attributeManager.queryAttributeDOById(new Long(arr[i]));
					if (r.getResult() != null) {
						names = names + "," + r.getResult().getAttrName();
					}
				}
				if (names.length() > 1) {
					shopDO.setServicesTypeName(names.substring(1, names.length()));
				}
			}
		}
		return returnString(result, jsonObject, query);
	}
	
	
	/**
	 * 查询店铺详情.
	 */
	@RequestMapping(value = "/detail.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String queryShops(@RequestParam(value = "shopsId") long shopsId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<ShopDO> result = null;
		try {
			result = shopManager.queryShopDOById(shopsId);
			
			if (result.getResult().getDeviceIs() == 0) {
				long deviceId = result.getResult().getDeviceId();//得到设备的ID号
		        if (deviceId != 0) {
		          Result<DeviceDO> result_device = deviceManager.queryDeviceDOById(deviceId);
		          DeviceDO result_deviceDO = result_device.getResult();
		          jsonObject.put("deviceNum", result_deviceDO.getProductNo());
		        }
			}
			
			
			if (result == null || !result.isSuccess()) {
				jsonObject.put("message", "查询失败");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "成功");
		jsonObject.put("data", JSONObject.toJSON(result.getResult()));
		return jsonObject.toString();
	}
	
	/**
	 * 用户根据店铺，名称模糊查询，这是总部使用的
	 */
	@RequestMapping("/queryByNameshopLike.do")
	@ResponseBody
	public String queryByNameshopLike(@RequestParam(value = "shopName") String shopsName){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		List<ShopDO> list = null;
		try {
			list = shopManager.queryByNameshopLike(shopsName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonObject.put("success", true);
		jsonObject.put("message", "查询成功");
		jsonObject.put("data", JSONObject.toJSON(list));
		return jsonObject.toString();
	}
	
	/**
	 * 用户根据店铺，名称模糊查询，这是经销商使用的
	 */
	@RequestMapping("/queryByNameShopLike.do")
	@ResponseBody
	public String queryByNameShopLike(@RequestParam(value = "shopName") String shopsName,
			@RequestParam(value = "sysUserId") Long sysUserId){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		Result<DistributorDO> distributorDO = distributorManager.queryDistributorDOBySysUserId(sysUserId);
		if (distributorDO.getResult() == null) {
			jsonObject.put("success", true);
			jsonObject.put("message", "查询失败");
			return jsonObject.toString();
		}
		
		ShopQuery query = new ShopQuery();
		query.setDistributorId(distributorDO.getResult().getId());
		query.setShopsName(shopsName);
		List<ShopDO> list = null;
		try {
			list = shopManager.queryByNameShopLike(query);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonObject.put("success", true);
		jsonObject.put("message", "查询成功");
		jsonObject.put("data", JSONObject.toJSON(list));
		return jsonObject.toString();
	}
	
	/**
	 * 用户根据异业店铺，名称模糊查询，这是经销商使用的
	 */
	@RequestMapping("/queryByNameOtherShopLike.do")
	@ResponseBody
	public String queryByNameOthershopLike(
				@RequestParam(value = "otherShopName") String shopsName,
				@RequestParam(value = "sysUserId") Long sysUserId){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		Result<DistributorDO> distributorDO = distributorManager.queryDistributorDOBySysUserId(sysUserId);
		if (distributorDO.getResult() == null) {
			jsonObject.put("success", true);
			jsonObject.put("message", "查询失败");
			return jsonObject.toString();
		}
		
		
		List<ShopDO> list = null;
		ShopQuery query = new ShopQuery();
		query.setDistributorId(distributorDO.getResult().getId());
		query.setShopsName(shopsName);
		try {
			list = shopManager.queryByNameOthershopLike(query);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "查询成功");
		jsonObject.put("data", JSONObject.toJSON(list));
		return jsonObject.toString();
	}
	
	/**
	 *根据商铺对应的用户ID,查询商铺信息
	 */
	@RequestMapping("/queryShopBySysUserId.do")
	@ResponseBody
	public String queryShopDOBySysUserId(@RequestParam(value = "sysUserId") long sysUserId){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<ShopDO> result = null;
		try {
			result = shopManager.queryShopDOBySysUserId(sysUserId);
			if (result == null || !result.isSuccess()) {
				jsonObject.put("message", "查询失败");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jsonObject.put("success", true);
		jsonObject.put("message", "成功");
		jsonObject.put("data", JSONObject.toJSON(result.getResult()));
		return jsonObject.toString();
	}
	
	/**
	 * 插入或更新店铺信息(end)
	 */
	@RequestMapping(value = {"/edit.do" ,"/save.do"}, method = RequestMethod.POST)
	@ResponseBody
	public String editShopDO(@RequestParam(value = "shopsId", required = false ,defaultValue="0") Long shopsId,
			@RequestParam(value = "shopsName") String shopsName,
			@RequestParam(value = "wechatUrl", defaultValue = "", required = false) String wechatUrl,
			@RequestParam(value = "introduce", defaultValue = "", required = false) String introduce,
			@RequestParam(value = "shopsUrl", defaultValue = "", required = false) String shopsUrl,
			@RequestParam(value = "telephone") String telephone,
			@RequestParam(value = "address", defaultValue = "0", required = false) String address,
			@RequestParam(value = "province", defaultValue = "0", required = false) String province,
			@RequestParam(value = "city", defaultValue = "0", required = false) String city,
			@RequestParam(value = "area", defaultValue = "0", required = false) String area,
			@RequestParam(value = "activity", defaultValue = "", required = false) String activity,
			@RequestParam(value = "servicesType", defaultValue = "", required = false) String servicesType,
			@RequestParam(value = "services", defaultValue = "", required = false) String services,
			@RequestParam(value = "status", required = false) Integer status,
			@RequestParam(value = "remark", required = false) String remark,
			@RequestParam(value = "shopHoursOpen") String shopHoursOpen,
			@RequestParam(value = "shopHoursClose") String shopHoursClose, 
			@RequestParam(value = "hot") Integer hot,
			@RequestParam(value = "distributorId",required=false,defaultValue ="0") long distributorId,//经销商的ID
			@RequestParam(value = "deviceId",required=false) long deviceId,//设备的ID
			@RequestParam(value = "deviceNum",required=false,defaultValue ="") String deviceNum,//设备的ID
			@RequestParam(value = "deviceIs",required=false,defaultValue ="1") int deviceIs,//是否存在设备，默认为不存在
			HttpServletRequest request) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		if (deviceIs == 0) {
			ShopQuery query = new ShopQuery();
			
			//先查询用户需要绑定的设备是否是已经绑定到其他店铺
			try {
				Result<List<ShopDO>> queryShopDOList = shopManager.queryShopDOList(query);
				
				List<ShopDO> list = queryShopDOList.getResult();
				
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getDeviceId() == deviceId) {
						jsonObject.put("success", false);
						jsonObject.put("message", "该设备已经绑定其他店铺，请核实后重试。");
						return jsonObject.toString();
					}
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		ShopDO shopDO = null;
		SysUsersDO sysUsersDO = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		//登录的人员为经销商
		if (sysUsersDO.getGroupId() == 1) {
			//先加入判断，辨别出是做的添加还是修改的操作。
			if (shopsId != 0) {
				Result<ShopDO> result = null;
				try {
					result = shopManager.queryShopDOById(shopsId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				shopDO = result.getResult();
				//如果是修改就不设置distributorId
			}else{
				shopDO = new ShopDO();

				DistributorDO distributorDO = (DistributorDO) request.getSession()
						.getAttribute(LoginConstant.USER_DISTRIBUTOR_SESSION_KEY);

				if (distributorDO != null) {
					distributorId = distributorDO.getId();
					shopDO.setDistributorId(distributorId);
				} else {
					jsonObject.put("success", false);
					jsonObject.put("message", "对不起，操作错误，请核实后重试！");
					return jsonObject.toString();
				}
			}
		//登录的人员为管理员
		}else if(sysUsersDO.getGroupId() == 0){
			//先加入判断，辨别出是做的添加还是修改的操作。
			if (shopsId != 0) {
				Result<ShopDO> result = null;
				try {
					result = shopManager.queryShopDOById(shopsId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				shopDO = result.getResult();
				//如果是修改就不设置distributorId
			}else{
				shopDO = new ShopDO();

				if (distributorId != 0) {
					shopDO.setDistributorId(distributorId);
				} else {
					jsonObject.put("success", false);
					jsonObject.put("message", "对不起，参数错误，请核实后重试！");
					return jsonObject.toString();
				}
			}
		}else{
			jsonObject.put("success", false);
			jsonObject.put("message", "操作失败，请联系管理员处理，谢谢！");
			return jsonObject.toString();
		}
		
		shopDO.setShopsId(shopsId);
		shopDO.setShopsName(shopsName);
		shopDO.setIntroduce(introduce);
		
		if (shopsUrl != null && !"".equals(shopsUrl)) {
			shopsUrl = PhotoUtil.addPhoto(shopsUrl);
		}
		
		shopDO.setShopsUrl(shopsUrl);
		shopDO.setTelephone(telephone);
		shopDO.setAddress(address);
		shopDO.setProvince(province);
		shopDO.setCity(city);
		shopDO.setArea(area);
		shopDO.setActivity(activity);
		shopDO.setStatus(status);
		shopDO.setWechatUrl(wechatUrl);
		shopDO.setShopHoursOpen(shopHoursOpen);
		shopDO.setShopHoursClose(shopHoursClose);
		shopDO.setDeviceIs(deviceIs);
		if (deviceIs == 0) {
			shopDO.setDeviceId(deviceId);	
			shopDO.setDeviceNum(deviceNum);
		}else{
			shopDO.setDeviceId(0L);
			shopDO.setDeviceNum("");
		}
		
		shopDO.setHot(hot);

		if (StringUtils.isNotBlank(services)) {
			services = "-" + services + "-";
		}
		if (StringUtils.isNotBlank(servicesType)) {
			servicesType = "-" + servicesType + "-";
		}
		shopDO.setServices(services);
		shopDO.setServicesType(servicesType);
		shopDO.setIsDeleted(0);
		Result<Long> result = null;
		try {
			result = shopManager.editShopDO(shopDO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	
	
	/**
	 * 修改店铺的状态，是否为可预约(end)
	 */
	@RequestMapping(value = { "/status.do"}, method = RequestMethod.POST)
	@ResponseBody
	public String updateShopDOStatus(@RequestParam("shopsId") Long shopsId, 
									 @RequestParam("status") Integer status) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		ShopDO shopDO = new ShopDO();
		shopDO.setShopsId(shopsId);
		shopDO.setStatus(status);
		
		Result<Integer> result = null;
		try {
			result = shopManager.editShopStatus(shopDO);
			if (result == null || !result.isSuccess()) {
				jsonObject.put("message", "操作失败");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}
	
	/**
	 * 审核
	 * @param shopsId，店铺id(end)
	 * @param audit，审核状态（0正在审核中，1审核已通过，默认为0）
	 * @return
	 */
	@RequestMapping(value = { "/audit.do"}, method = RequestMethod.POST)
	@ResponseBody
	public String updateShopDOAudit(@RequestParam("shopsId") Long shopsId, 
									@RequestParam("audit") Integer audit) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		ShopDO shopDO = new ShopDO();
		shopDO.setShopsId(shopsId);
		shopDO.setAudit(audit);

		Result<Integer> result = null;
		try {
			result = shopManager.editShopAudit(shopDO);
			if (result == null || !result.isSuccess()) {
				jsonObject.put("message", "操作失败");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}
	
	/**
	 * 删除和恢复店铺(end)
	 * @param shopsId
	 * @param isDeleted
	 * @return
	 */
	@RequestMapping(value = { "/del.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateShopDODeleted(@RequestParam("shopsId") Long shopsId,
			@RequestParam("isDeleted") Integer isDeleted) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		ShopDO shopDO = new ShopDO();
		shopDO.setShopsId(shopsId);
		shopDO.setIsDeleted(isDeleted);

		Result<Integer> result = null;
		try {
			result = shopManager.editShopIsDeleted(shopDO);
			if (result == null || !result.isSuccess()) {
				jsonObject.put("message", "操作失败");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	
	/**
	 * 不知道什么用
	 * @param request
	 * @return
	 */
	@RequestMapping("/unemployed.do")
	@ResponseBody
	public String queryShopDOUnemployed(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		DistributorDO dDO = (DistributorDO) request.getSession().getAttribute(LoginConstant.USER_DISTRIBUTOR_SESSION_KEY);
		Result<List<ShopDO>> result = null;
		try {
		if (dDO != null) {
			// SysUsersDO sysUsersDO = (SysUsersDO)
			// request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
			ShopDO shopDO = new ShopDO();
			shopDO.setDistributorId(dDO.getId());
			
			result = shopManager.queryShopDOUnemployed(shopDO);
			
			
			if (result == null || !result.isSuccess()) {
				jsonObject.put("message", "查询失败");
				return jsonObject.toString();
			}
			jsonObject.put("success", true);
			jsonObject.put("message", "成功");
			jsonObject.put("data", JSONArray.toJSON(result.getResult()));
			
		} else {
			jsonObject.put("success", true);
			jsonObject.put("message", "成功");
			jsonObject.put("data", JSONArray.toJSON(null));
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	/**
	 * 返回量化过的列表
	 * @param result
	 * @param jsonObject
	 * @param query
	 * @return
	 */
	public String returnString(Result<List<ShopDO>> result, JSONObject jsonObject, ShopQuery query) {
		if (result != null && result.isSuccess()) {
			List<ShopDO> itemDOList = result.getResult();
			JSONArray itemList = new JSONArray();
			for (ShopDO shopDO : itemDOList) {
				JSONObject item = new JSONObject();

				item.put("shopsId", shopDO.getShopsId());
				item.put("shopsName", shopDO.getShopsName());
				item.put("distributorId", shopDO.getDistributorId());
				item.put("distributorIdName", shopDO.getDistributorIdName());
				item.put("introduce", shopDO.getIntroduce());
				item.put("shopsUrl", shopDO.getShopsUrl());
				item.put("telephone", shopDO.getTelephone());
				item.put("province", shopDO.getProvince());
				item.put("city", shopDO.getCity());
				item.put("activity", shopDO.getActivity());
				item.put("address", shopDO.getAddress());
				item.put("created", shopDO.getCreated());
				item.put("updated", shopDO.getUpdated());
				item.put("status", shopDO.getStatus());
				item.put("reserveNumber", shopDO.getReserveNumber());
				item.put("sysUserId", shopDO.getSysUserId());
				item.put("shopHoursOpen", shopDO.getShopHoursOpen());
				item.put("shopHoursClose", shopDO.getShopHoursClose());
				item.put("isDeleted", shopDO.getIsDeleted());
				item.put("services", shopDO.getServices());
				item.put("servicesName", shopDO.getServicesName());
				item.put("hot", shopDO.getHot());
				item.put("deviceNum", shopDO.getDeviceNum());//设备编号
				item.put("deviceIs", shopDO.getDeviceIs());
				item.put("sysUserId", shopDO.getSysUserId());
				item.put("audit", shopDO.getAudit());
				itemList.add(item);
			}
			jsonObject.put("iTotalRecords", query.getTotalItem()); // 实际的行数
			jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); // 显示的行数,这个要和上面
			jsonObject.put("aaData", itemList);
			jsonObject.put("success", true);
		} else {
			jsonObject.put("message", "找不到宝贝");
		}
		return jsonObject.toString();
	}
		
	/**
	 * 插入或更新接口(创建系统用户账号)
	 */
	@RequestMapping(value = { "/editSysUser.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String editSysUserDO(@RequestParam(value = "entityId") Long entityId,
			@RequestParam(value = "sysUserName") String sysUserName,
			@RequestParam(value = "sysMobile") String sysMobile,
			@RequestParam(value = "sysPassword") String sysPassword) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			SysUsersDO sysUsersDO = sysUsersManager.querySysUsersByUserName(sysMobile);
			if (sysUsersDO != null) {
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
		sysUsersDO.setGroupId(new Long(2));// 0为系统管理员 1为经销商 2为店铺 3为创客 4为手艺人
		sysUsersDO.setCreated(String.valueOf(System.currentTimeMillis() / 1000));
		sysUsersDO.setUpdated(String.valueOf(System.currentTimeMillis() / 1000));
		//Result<Long> result = sysUsersManager.addSysUsersDOS(sysUsersDO);
		Result<Long> result = sysUsersManager.addSysUsersDOAndRole(sysUsersDO,new Long(16));
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "数据操作失败");
			return jsonObject.toString();
		} else {
			ShopDO shopDO = new ShopDO();
			shopDO.setShopsId(entityId);
			shopDO.setSysUserId(result.getResult());
			try {
				result = shopManager.editShopSysUserId(shopDO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
