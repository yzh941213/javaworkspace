package com.aishidai.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aishidai.app.common.LoginConstant;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.message.ResultMessage;
import com.aishidai.app.model.pojo.DeviceDO;
import com.aishidai.app.model.pojo.DistributorDO;
import com.aishidai.app.model.pojo.ShopsDO;
import com.aishidai.app.model.pojo.ShopsDOCustom;
import com.aishidai.app.model.pojo.SysUsersDO;
import com.aishidai.app.model.query.QueryShop;
import com.aishidai.app.model.query.ShopsQuery;
import com.aishidai.app.service.AttributeService;
import com.aishidai.app.service.DeviceService;
import com.aishidai.app.service.DistributorService;
import com.aishidai.app.service.PropertyService;
import com.aishidai.app.service.ShopService;
import com.aishidai.app.service.SysUsersService;
import com.aishidai.app.util.PhotoUtil;
import com.aishidai.app.utils.PasswordHash;
import com.aishidai.common.json.JsonResult;
import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/manage/shops")
public class ShopController {

	@Autowired
	private ShopService shopService;
	@Autowired
	private SysUsersService sysUsersService;
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private AttributeService attributeService;
	@Autowired
	private DistributorService distributorService;
	@Autowired
	private DeviceService deviceService;
	

	@RequestMapping(value = { "/shopList" })
	@ResponseBody
	public JsonResult shopList(QueryShop queryShop, HttpSession httpSession) {
		SysUsersDO sysUsersDO=(SysUsersDO)httpSession.getAttribute(LoginConstant.USER_SESSION_KEY);
		if(sysUsersDO!=null){
			//0为系统管理员 1为经销商 2为店铺 3为创客 4为手艺人 5为供应商
			//如果是总部账号
			if(sysUsersDO.getGroupId()!=0){
				queryShop.setSysUserId(sysUsersDO.getUserId());
			}
			List<ShopsDO> list = shopService.shopList(queryShop);

			return JsonResult.buildPaging(list, queryShop.getsEcho(), 116l);
		}else{
			return JsonResult.buildError(ResultMessage.LOGIN_NO);
		}

	}
	
	
	//查询店铺表的表
	@GetMapping(value="queryShopsListByRank")
	public String queryShopsListByRank(ShopsQuery shopsQuery){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		long userId = shopsQuery.getUserId();
		try {
			List<ShopsDOCustom> list = new ArrayList<ShopsDOCustom>();
			//先判断是否是  // 0为系统管理员 1为经销商 2为店铺 3为创客 4为手艺人
			//总部查询全部的
			if (sysUsersService.queryByPrimaryKey(userId).getGroupId() == 0) {
				shopsQuery.setIsDeleted(0);
				list = shopService.queryShopsDOList(shopsQuery);
				this.addName(list);
				jsonObject.put("data", JsonResult.buildPaging(list, shopsQuery.getsEcho(),
						(long)shopService.queryShopsDOListCount(shopsQuery)));
			//经销商查询自己下面的
			}else if(sysUsersService.queryByPrimaryKey(userId).getGroupId() == 1){
				shopsQuery.setDistributorId(
						distributorService.selectDistributorDOByUserId(userId).get(0).getId());
				shopsQuery.setIsDeleted(0);
				list = shopService.queryShopsDOList(shopsQuery);
				this.addName(list);
				jsonObject.put("data", JsonResult.buildPaging(list, shopsQuery.getsEcho(),
						(long)shopService.queryShopsDOListCount(shopsQuery)));
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
	
	private void addName(List<ShopsDOCustom> list) throws Exception {
		for (ShopsDOCustom shopsDOCustom : list) {
			shopsDOCustom.setDistributorName(
					distributorService.queryDistributorDOById(shopsDOCustom.getDistributorId()).getName());
		}
	}


	/**
	 * 查询店铺详情
	 */
	@RequestMapping(value = "/queryDetail",method={RequestMethod.GET,RequestMethod.POST})
	public String queryShops(@RequestParam(value = "shopsId") long shopsId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			ShopsDOCustom entity = shopService.queryShopsDOById(shopsId);
			entity.setDistributorName(
					distributorService.queryDistributorDOById(entity.getDistributorId()).getName());
			if (entity.getDeviceIs() == 0) {
				long deviceId = entity.getDeviceId();//得到设备的ID号
	            DeviceDO device = deviceService.queryDeviceDOById(deviceId);
	            if (device == null) {
	            	  entity.setDeviceNum("无");
				}else{
					  entity.setDeviceNum(device.getProductNo());
				}
			}
			jsonObject.put("success", true);
			jsonObject.put("message", "查询成功");
			jsonObject.put("data", entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonObject.put("message", "查询失败");
		}
		return jsonObject.toString();
	}
	
	/**
	 * 用户根据店铺名称模糊查询，这是总部使用的(仅用于店铺)
	 */
	@RequestMapping("/queryByNameHqSNLike")
	public String queryByNameHqSNLike(@RequestParam(value = "name",required = true) String name){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			List<ShopsDO> list = shopService.queryByNameHqSNLike(name);
			jsonObject.put("success", true);
			jsonObject.put("message", "查询成功");
			jsonObject.put("data", JSONObject.toJSON(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	/**
	 * 用户根据店铺名称模糊查询，这是总部使用的(仅用于异业店铺)
	 */
	@RequestMapping("/queryByNameHqOSNLike")
	public String queryByNameHqOSNLike(@RequestParam(value = "name",required = true) String name){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			List<ShopsDO> list = shopService.queryByNameHqOSNLike(name);
			jsonObject.put("success", true);
			jsonObject.put("message", "查询成功");
			jsonObject.put("data", JSONObject.toJSON(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	/**
	 * 用户根据店铺名称模糊查询,这是经销商使用的(仅用于店铺)
	 */
	@RequestMapping("/queryByNameSNLike")
	public String queryByNameSNLike(@RequestParam(value = "name") String name,
			@RequestParam(value = "userId") long userId){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			List<DistributorDO> list = distributorService.selectDistributorDOByUserId(userId);
			if (list.isEmpty() && list.size() <= 0 ) {
				jsonObject.put("success", false);
				jsonObject.put("message", "查询失败");
				return jsonObject.toString();
			}
			ShopsDO shopsDO = new ShopsDO();
			shopsDO.setShopsName(name);
			shopsDO.setDistributorId(list.get(0).getId());
			List<ShopsDO> list_shops = shopService.queryByNameSNLike(shopsDO);
			jsonObject.put("success", true);
			jsonObject.put("message", "查询成功");
			jsonObject.put("data", JSONObject.toJSON(list_shops));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	/**
	 * 用户根据异业店铺名称模糊查询，这是经销商使用的
	 */
	@RequestMapping("/queryByNameOSNLike")
	public String queryByNameOSNLike(
				@RequestParam(value = "name") String name,
				@RequestParam(value = "userId") Long userId){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			List<DistributorDO> list = distributorService.selectDistributorDOByUserId(userId);
			if (list.isEmpty() && list.size() <= 0 ) {
				jsonObject.put("success", false);
				jsonObject.put("message", "查询失败");
				return jsonObject.toString();
			}
			ShopsDO shopsDO = new ShopsDO();
			shopsDO.setShopsName(name);
			shopsDO.setDistributorId(list.get(0).getId());
			List<ShopsDO> list_shops = shopService.queryByNameOSNLike(shopsDO);
			jsonObject.put("success", true);
			jsonObject.put("message", "查询成功");
			jsonObject.put("data", JSONObject.toJSON(list_shops));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	/**
	 *根据商铺对应的登录用户ID,查询商铺信息
	 */
	@RequestMapping("/queryShopByUserId")
	public String queryShopByUserId(@RequestParam(value = "userId") long userId){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			List<ShopsDO> list = shopService.queryShopsDOByUserId(userId);
			if (list.isEmpty() && list.size()<= 0) {
				jsonObject.put("message", "查询失败");
				return jsonObject.toString();
			}
			jsonObject.put("success", true);
			jsonObject.put("message", "查询成功");
			jsonObject.put("data", JSONObject.toJSON(list.get(0)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	
	@RequestMapping(value = {"/save"}, method = RequestMethod.POST)
	public String addShopsDO(ShopsDO shopsDO,
				@RequestParam(value = "userId", required =true) long userId) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			if (shopsDO != null && shopsDO.getDeviceIs() == 0) {
				// 先查询用户需要绑定的设备是否是已经绑定到其他店铺
				List<ShopsDO> list_shops = shopService
						.queryShopsDOByDeviceId(shopsDO.getDeviceId());
				if (!list_shops.isEmpty() && !(list_shops.size() <= 0)) {
					jsonObject.put("success", false);
					jsonObject.put("message", "该设备已经绑定其他店铺，请核实后重试。");
					return jsonObject.toString();
				}
			}
			// 先判断是否是经销商添加的
			if (shopsDO.getDistributorId() == 0) {
				if (sysUsersService.queryByPrimaryKey(userId) != null
						&& sysUsersService.queryByPrimaryKey(userId)
								.getGroupId() != 0) {
					// 创建者必须是经销商或者总部账号
					jsonObject.put("message", "对不起，您没有相关权限，请联系管理员处理");
					return jsonObject.toString();
				} else {
					shopsDO.setCreated(new Date());
					shopsDO.setUpdated(new Date());
					shopsDO.setIsDeleted(0);
					shopsDO.setAudit(0);
					if (shopsDO.getShopsUrl() != null
							&& !"".equals(shopsDO.getShopsUrl())) {
						shopsDO.setShopsUrl(PhotoUtil.addPhoto(shopsDO
								.getShopsUrl()));
					}
					if (StringUtils.isNotBlank(shopsDO.getServices())) {
						shopsDO.setServices("-" + shopsDO.getServices() + "-");
					}
					if (StringUtils.isNotBlank(shopsDO.getServicesType())) {
						shopsDO.setServicesType("-" + shopsDO.getServicesType()
								+ "-");
					}
					if (shopService.insertShops(shopsDO)) {
						jsonObject.put("success", true);
						jsonObject.put("message", "操作成功");
					}else{
						jsonObject.put("message", "操作失败");
					}
				}
			} else {
				shopsDO.setCreated(new Date());
				shopsDO.setUpdated(new Date());
				shopsDO.setIsDeleted(0);
				shopsDO.setAudit(0);
				shopsDO.setDistributorId(userId);

				if (shopsDO.getShopsUrl() != null
						&& !"".equals(shopsDO.getShopsUrl())) {
					shopsDO.setShopsUrl(PhotoUtil.addPhoto(shopsDO
							.getShopsUrl()));
				}
				if (StringUtils.isNotBlank(shopsDO.getServices())) {
					shopsDO.setServices("-" + shopsDO.getServices() + "-");
				}
				if (StringUtils.isNotBlank(shopsDO.getServicesType())) {
					shopsDO.setServicesType("-" + shopsDO.getServicesType()
							+ "-");
				}
				if (shopService.insertShops(shopsDO)) {
					jsonObject.put("success", true);
					jsonObject.put("message", "操作成功");
				}else{
					jsonObject.put("message", "操作失败");
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return jsonObject.toString();
	}

	
	@RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
	public String editShopsDO(ShopsDO shopsDO,
			@RequestParam(value = "userId", required =true) long userId){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			if (shopsDO != null && shopsDO.getDeviceIs() == 0) {
				// 先查询用户需要绑定的设备是否是已经绑定到其他店铺
				List<ShopsDO> list_shops = shopService
						.queryShopsDOByDeviceId(shopsDO.getDeviceId());
				if (!list_shops.isEmpty() && !(list_shops.size() <= 0) 
						&& list_shops.get(0).getShopsId().longValue() != shopsDO.getShopsId().longValue()) {
					jsonObject.put("success", false);
					jsonObject.put("message", "该设备已经绑定其他店铺，请核实后重试。");
					return jsonObject.toString();
				}
			}
			
			if (shopsDO.getDistributorId() == 0) {
				if (sysUsersService.queryByPrimaryKey(userId) != null
						&& sysUsersService.queryByPrimaryKey(userId)
								.getGroupId() != 0) {
					// 创建者必须是经销商或者总部账号
					jsonObject.put("message", "对不起，您没有相关权限，请联系管理员处理");
					return jsonObject.toString();
				} else {
					shopsDO.setUpdated(new Date());
					if (shopsDO.getShopsUrl() != null
							&& !"".equals(shopsDO.getShopsUrl())) {
						shopsDO.setShopsUrl(PhotoUtil.addPhoto(shopsDO
								.getShopsUrl()));
					}
					if (StringUtils.isNotBlank(shopsDO.getServices())) {
						shopsDO.setServices("-" + shopsDO.getServices() + "-");
					}
					if (StringUtils.isNotBlank(shopsDO.getServicesType())) {
						shopsDO.setServicesType("-" + shopsDO.getServicesType()
								+ "-");
					}
					if (shopService.editShopsDO(shopsDO)) {
						jsonObject.put("success", true);
						jsonObject.put("message", "操作成功");
					}else{
						jsonObject.put("message", "操作失败");
					}
				}
			} else {
				shopsDO.setUpdated(new Date());

				if (shopsDO.getShopsUrl() != null
						&& !"".equals(shopsDO.getShopsUrl())) {
					shopsDO.setShopsUrl(PhotoUtil.addPhoto(shopsDO
							.getShopsUrl()));
				}
				if (StringUtils.isNotBlank(shopsDO.getServices())) {
					shopsDO.setServices("-" + shopsDO.getServices() + "-");
				}
				if (StringUtils.isNotBlank(shopsDO.getServicesType())) {
					shopsDO.setServicesType("-" + shopsDO.getServicesType()
							+ "-");
				}
				if (shopService.editShopsDO(shopsDO)) {
					jsonObject.put("success", true);
					jsonObject.put("message", "操作成功");
				}else{
					jsonObject.put("message", "操作失败");
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	@RequestMapping(value = { "/audit"}, method = RequestMethod.POST)
	public String updateShopDOAudit(@RequestParam("shopsId") long shopsId, 
									@RequestParam("audit") int audit) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			ShopsDO shopsDO = new ShopsDO();
			shopsDO.setShopsId(shopsId);
			shopsDO.setAudit(audit);
			
			if (!shopService.editShopsDO(shopsDO)) {
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
	
	@RequestMapping(value = { "/remove" }, method = RequestMethod.POST)
	public String removeShopDODeleted(@RequestParam("shopsId") long shopsId,
			@RequestParam("isDeleted") int isDeleted) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			ShopsDO shopsDO = new ShopsDO();
			shopsDO.setShopsId(shopsId);
			shopsDO.setIsDeleted(isDeleted);
			if (!shopService.editShopsDO(shopsDO)) {
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
	
	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	public String addUser(@RequestParam(value = "shopsId") long shopsId,
			@RequestParam(value = "userName") String userName,
			@RequestParam(value = "mobile") String mobile,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			SysUsersDO SUDO = sysUsersService.querySysUsersByUserName(userName);
			if (SUDO != null) {
				jsonObject.put("message", "该用户名已存在");
				return jsonObject.toString();
			}

			SysUsersDO sysUsersDO = new SysUsersDO();
			sysUsersDO.setUserName(userName);
			sysUsersDO.setPassword(PasswordHash.createHash(password));
			sysUsersDO.setName(name);
			sysUsersDO.setIsDeleted(0);
			sysUsersDO.setStatus(0);
			sysUsersDO.setMobile(mobile);
			sysUsersDO.setGroupId(new Long(2));// 0为系统管理员 1为经销商 2为店铺 3为创客 4为手艺人
			sysUsersDO.setCreated(Integer.valueOf(System.currentTimeMillis()
					/ 1000 + ""));
			sysUsersDO.setUpdated(Integer.valueOf(System.currentTimeMillis()
					/ 1000 + ""));
			Result<Long> result = sysUsersService.addSysUsersDOAndRole(
					sysUsersDO, new Long(16));
			if (result == null || !result.isSuccess()) {
				jsonObject.put("message", "数据操作失败");
				return jsonObject.toString();
			} else {
				ShopsDO shopsDO = new ShopsDO();
				shopsDO.setShopsId(shopsId);
				shopsDO.setSysUserId(result.getResult());
				if (shopService.editShopsDO(shopsDO)) {
					jsonObject.put("success", true);
					jsonObject.put("message", "操作成功");
				} else {
					jsonObject.put("message", "操作失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
}
