package com.zhezhuo.web.home.module.screen.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.dao.UsersDAO;
import com.zhezhuo.biz.manager.CraftsmenManager;
import com.zhezhuo.biz.manager.DistributorManager;
import com.zhezhuo.biz.manager.PropertyManager;
import com.zhezhuo.biz.manager.ServicesManager;
import com.zhezhuo.biz.manager.ShopManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.CraftsmenDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.PropertyDO;
import com.zhezhuo.model.entity.ServicesDO;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.entity.SysUsersDO;
import com.zhezhuo.model.entity.UsersDO;
import com.zhezhuo.model.query.ServicesQuery;
import com.zhezhuo.web.home.common.LoginConstant;

/**
 * 预约
 * 
 * @author adrian
 * 
 */
@Controller
@RequestMapping("/manager/services")
public class ServicesController {

	@Autowired
	ServicesManager servicesManager;
	@Autowired
	PropertyManager propertyManager;
	@Autowired
	ShopManager shopManager;
	@Autowired
	CraftsmenManager craftsmenManager;
	@Autowired
	UsersDAO usersDAO;
	@Autowired
	DistributorManager distributorManager;

	/**
	 * 
	 * @param aoData
	 * @return
	 */
	@RequestMapping("/list.do")
	@ResponseBody
	public String queryServicess(@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,
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
		SysUsersDO userDO = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		ServicesQuery query = new ServicesQuery();
		if (userDO.getGroupId() == 2) {
			ShopDO shopDO = (ShopDO) request.getSession().getAttribute(LoginConstant.USER_SHOP_SESSION_KEY);
			query.setShopId(shopDO.getShopsId());
		} else if (userDO.getGroupId() == 4) {
			CraftsmenDO craftsmenDO = (CraftsmenDO) request.getSession()
					.getAttribute(LoginConstant.USER_CRAFTSMEN_SESSION_KEY);
			query.setUsersId(craftsmenDO.getId());
		}
		query.setStartRow(iDisplayStart);
		query.setPageSize(iDisplayLength);

		Result<List<ServicesDO>> result = servicesManager.queryServicesDOList(query);
		List<ServicesDO> list = result.getResult();
		for (int k = 0; k < list.size(); k++) {
			ServicesDO servicesDO = list.get(k);
			
			String services = servicesDO.getServices();
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
					servicesDO.setServicesName(names.substring(1, names.length()));
				}
			}

			if (servicesDO.getApplyId() != null) {
				UsersDO usersDO = usersDAO.queryUserDOById(servicesDO.getApplyId());
				if (usersDO != null) {
					servicesDO.setApplyIdName(usersDO.getUnick());
					Result<DistributorDO> distributorDO = distributorManager
							.queryDistributorDOByDeviceNo(usersDO.getRegisterip());
					if (distributorDO.getResult() != null) {
						servicesDO.setDistributorIdName(distributorDO.getResult().getName());
					}
				}
			}
			if (servicesDO.getShopId() != null) {
				Result<ShopDO> shopDO;
				try {
					shopDO = shopManager.queryShopDOById(servicesDO.getShopId());
					if (shopDO != null && shopDO.getResult() != null) {
						servicesDO.setShopIdName(shopDO.getResult().getShopsName());
						servicesDO.setShopTel(shopDO.getResult().getTelephone() == null ?"无":shopDO.getResult().getTelephone());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if (servicesDO.getServices() != null || servicesDO.getServices().equals("")) {
				Result<PropertyDO> queryProperty = propertyManager.queryPropertyDOById(Long.parseLong(servicesDO.getServices()));
				if (queryProperty.getResult() != null) {
					servicesDO.setServices(queryProperty.getResult().getProName());
				}
			}
			if (servicesDO.getUsersId() != null) {
				Result<CraftsmenDO> craftsmenDO = craftsmenManager.queryCraftsmenDOById(servicesDO.getUsersId());
				if (craftsmenDO.getResult() != null) {
					servicesDO.setUsersIdName(craftsmenDO.getResult().getCraftsmanName());
					servicesDO.setCraftsmenTel(craftsmenDO.getResult().getTelephone() == null ? "无":craftsmenDO.getResult().getTelephone());
				}

			}
		}
		return returnString(result, jsonObject, query);
	}

	/**
	 * 特征详情接口.
	 * 
	 * @param servicesId
	 *            id
	 * @return string
	 */
	@RequestMapping("/detail.do")
	@ResponseBody
	public String queryServicess(@RequestParam(value = "orderId") long orderId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<ServicesDO> result = servicesManager.queryServicesDOById(orderId);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "查询失败");
			return jsonObject.toString();
		}

		jsonObject.put("success", true);
		jsonObject.put("message", "成功");
		jsonObject.put("data", JSONObject.toJSON(result.getResult()));
		return jsonObject.toString();
	}

	/**
	 * 插入或更新接口
	 * 
	 * @param servicesId
	 * @param attrName
	 * @param alias
	 * @param imgPath
	 * @param description
	 * @param parentId
	 * @param hot
	 * @param feature
	 * @return string
	 */
	@RequestMapping(value = { "/edit.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String editServicesDO(@RequestParam(value = "orderId", defaultValue = "0") Long orderId,
			@RequestParam(value = "applyId", defaultValue = "", required = false) Long applyId,
			@RequestParam(value = "endTime", defaultValue = "", required = false) String endTime,
			@RequestParam(value = "created", defaultValue = "", required = false) String created,
			@RequestParam(value = "number", defaultValue = "", required = false) Integer number,
			@RequestParam(value = "result", defaultValue = "", required = false) String result,
			@RequestParam(value = "ordersType", defaultValue = "0", required = false) Integer ordersType,
			@RequestParam(value = "shopId", defaultValue = "", required = false) Long shopId,
			@RequestParam(value = "status") Integer status, @RequestParam(value = "usersId") Long usersId,
			@RequestParam(value = "phone") String phone, @RequestParam(value = "services") String services) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		ServicesDO servicesDO = new ServicesDO();
		servicesDO.setOrderId(orderId);
		servicesDO.setApplyId(applyId);
		servicesDO.setEndTime(endTime);
		servicesDO.setNumber(number);
		servicesDO.setResult(result);
		servicesDO.setOrdersType(ordersType);
		servicesDO.setShopId(shopId);
		// servicesDO.setCreated(created);
		servicesDO.setEndTime(endTime);
		servicesDO.setPhone(phone);
		servicesDO.setServices(services);
		servicesDO.setStatus(status);
		servicesDO.setUsersId(usersId);

		Result<Long> retrn = servicesManager.editServicesDO(servicesDO);
		if (retrn == null || !retrn.isSuccess()) {
			jsonObject.put("message", "数据操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "数据更新成功");
		return jsonObject.toString();
	}

	/**
	 * 更新记录状态(删除)
	 * 
	 * @param servicesId
	 *            id
	 * @param status
	 *            状态
	 * @return success/fail
	 */
	@RequestMapping(value = { "/status.do", "/del.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateServicesDOStatus(@RequestParam("orderId") Long orderId,
			@RequestParam("status") Integer status) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		ServicesDO servicesDO = new ServicesDO();
		servicesDO.setOrderId(orderId);
		servicesDO.setStatus(status);

		Result<Integer> result = servicesManager.updateServicesStatus(servicesDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	/**
	 * 取消预约（店铺或手艺人取消）
	 * 
	 * @param orderId
	 * @param status
	 * @return
	 */
	@RequestMapping(value = { "/cancel.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateServicesDOCancel(@RequestParam("orderId") Long orderId, HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		ServicesDO servicesDO = new ServicesDO();
		servicesDO.setOrderId(orderId);
		// servicesDO.setStatus(status);
		SysUsersDO userDO = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		if (userDO.getGroupId() == 2) {
			servicesDO.setStatus(-2);// 店铺取消
		} else if (userDO.getGroupId() == 4) {
			servicesDO.setStatus(-3);// 艺人取消
		} else {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		Result<Integer> result = servicesManager.updateServicesStatus(servicesDO);
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
	public String queryServicesDOByShopId(@RequestParam(value = "shopId") long shopId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<List<ServicesDO>> result = servicesManager.queryServicesDOByShopId(shopId);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "查询失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "成功");
		jsonObject.put("data", JSONArray.toJSON(result.getResult()));
		return jsonObject.toString();
	}

	public String returnString(Result<List<ServicesDO>> result, JSONObject jsonObject, ServicesQuery query) {
		if (result != null && result.isSuccess()) {
			List<ServicesDO> itemDOList = result.getResult();
			JSONArray itemList = new JSONArray();
			for (ServicesDO servicesDO : itemDOList) {
				JSONObject item = new JSONObject();
				item.put("applyId", servicesDO.getApplyId());
				item.put("applyIdName", servicesDO.getApplyIdName());
				item.put("created", servicesDO.getCreated());
				item.put("endTime", servicesDO.getEndTime());
				item.put("number", servicesDO.getNumber());
				item.put("result", servicesDO.getResult());
				item.put("orderId", servicesDO.getOrderId());
				item.put("shopId", servicesDO.getShopId());
				item.put("shopIdName", servicesDO.getShopIdName());
				item.put("craftsmenTel", servicesDO.getCraftsmenTel());
				item.put("shopTel", servicesDO.getShopTel());
				item.put("usersId", servicesDO.getUsersId());
				item.put("usersIdName", servicesDO.getUsersIdName());
				item.put("status", servicesDO.getStatus());
				item.put("created", servicesDO.getCreated());
				item.put("orderType", servicesDO.getOrdersType());
				item.put("phone", servicesDO.getPhone());
				item.put("services", servicesDO.getServices());
				item.put("servicesName", servicesDO.getServices());
				item.put("distributorIdName", servicesDO.getDistributorIdName());
				itemList.add(item);
			}
			jsonObject.put("iTotalRecords", query.getTotalItem()); // 实际的行数
			jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); // 显示的行数,这个要和上面
			jsonObject.put("aaData", itemList);
			jsonObject.put("success", true);
		} else {
			jsonObject.put("message", "找不到预约记录");
		}
		return jsonObject.toString();
	}
}
