package com.zhezhuo.web.home.module.screen.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.zhezhuo.biz.manager.DeviceManager;
import com.zhezhuo.biz.manager.DistributorManager;
import com.zhezhuo.biz.manager.MakerManager;
import com.zhezhuo.biz.manager.ShopManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.DeviceDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.entity.SysUsersDO;
import com.zhezhuo.model.query.DeviceQuery;
import com.zhezhuo.web.home.common.LoginConstant;


@Controller
@RequestMapping("/manager/device")
public class DeviceController {

	@Autowired
	private DeviceManager deviceManager;
	@Autowired
	private ShopManager shopManager;
	@Autowired
	private MakerManager makerManager;
	@Autowired
	private DistributorManager distributorManager;
	
	
	/**
	 * 
	 * @param aoData
	 * @return
	 */
	@RequestMapping("/list.do")
	@ResponseBody
	public String queryDevices(@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,
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

		DeviceQuery query = new DeviceQuery();
		SysUsersDO userDO = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		// 不同角色用户查询不同数据
		if (userDO.getGroupId() == 1) {
			DistributorDO distributorDO = (DistributorDO) request.getSession()
					.getAttribute(LoginConstant.USER_DISTRIBUTOR_SESSION_KEY);
			query.setDistributorId(distributorDO.getId());
		} 
		query.setStartRow(iDisplayStart);
		query.setPageSize(iDisplayLength);

		Result<List<DeviceDO>> result = deviceManager.queryDeviceDOList(query);
		List<DeviceDO> list = result.getResult();
		for (int k = 0; k < list.size(); k++) {
			DeviceDO deviceDO = list.get(k);
			if (deviceDO != null) {
				if (deviceDO.getDistributorId() != null) {
					Result<DistributorDO> r = distributorManager.queryDistributorDOById(deviceDO.getDistributorId());
					if (r.getResult() != null) {
						deviceDO.setDistributorIdName(r.getResult().getName());
					}
				}
				try {
					ShopDO shop = shopManager.queryByDeviceId(deviceDO.getId());
					if (shop != null) {
						deviceDO.setShopIdName(shop.getShopsName());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return returnString(result, jsonObject, query);
	}
	
	/**
	 * 商铺查询设备编号
	 */
	@RequestMapping(value="/deviceList.do",method={RequestMethod.GET})
	@ResponseBody
	public String deviceList() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			Result<List<DeviceDO>> result = deviceManager.queryDeviceList();
			jsonObject.put("success", true);
			jsonObject.put("message", "查询成功");
			jsonObject.put("data", JSONObject.toJSON(result.getResult()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	/**
	 * 商铺查询设备编号
	 */
	@RequestMapping("/listByshop.do")
	@ResponseBody
	public String queryByshop(@RequestParam(value = "shopId") long shopId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		//先通过shopId
		//查询出来，店铺
		try {
			Result<ShopDO> result_shop = shopManager.queryShopDOById(shopId);
			if (result_shop.getResult() != null) {
				Result<DeviceDO> result = deviceManager.queryDeviceDOById(result_shop.getResult().getDeviceId());
				jsonObject.put("success", true);
				jsonObject.put("message", "成功");
				jsonObject.put("data", JSONObject.toJSON(result.getResult()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	
	@RequestMapping("/DeviceListLike.do")
	@ResponseBody
	public String listLike(@RequestParam(value = "deviceNum") String deviceNum) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<List<DeviceDO>> result = deviceManager.queryDeviceDOLike(deviceNum);
		jsonObject.put("success", true);
		jsonObject.put("message", "成功");
		jsonObject.put("data", JSONObject.toJSON(result.getResult()));
		return jsonObject.toString();
	}
	
	@RequestMapping("/hQdeviceListLike.do")
	@ResponseBody
	public String hQlistLike(@RequestParam(value = "deviceNum") String deviceNum,
			                 @RequestParam(value = "sysUserId") long sysUserId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
	
		//先拿着登录人Id,查询是否是经销商
		Result<DistributorDO> result_dis = distributorManager.queryDistributorDOBySysUserId(sysUserId);
		if (result_dis.getResult() != null) {
			DeviceQuery query = new DeviceQuery();
			query.setDistributorId(result_dis.getResult().getId());
			query.setProductNo(deviceNum);
			Result<List<DeviceDO>> result = deviceManager.queryHqDeviceDOLike(query);
			jsonObject.put("success", true);
			jsonObject.put("message", "成功");
			jsonObject.put("data", JSONObject.toJSON(result.getResult()));
		}else{
			jsonObject.put("success", false);
			jsonObject.put("message", "查询失败");
			return jsonObject.toString();
		}
		return jsonObject.toString();
	}
	
	/**
	 * 特征详情接口.
	 * 
	 * @param deviceId
	 *            id
	 * @return string
	 */
	@RequestMapping("/detail.do")
	@ResponseBody
	public String queryDevices(@RequestParam(value = "deviceId") long deviceId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<DeviceDO> result = deviceManager.queryDeviceDOById(deviceId);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "查询失败");
			return jsonObject.toString();
		}
		if (result.getResult().getDistributorId() != null) {
			Result<DistributorDO> r = distributorManager.queryDistributorDOById(result.getResult().getDistributorId());
			if (r.getResult() != null) {
				result.getResult().setDistributorIdName(r.getResult().getName());
			}
		}
		try {
			ShopDO shop = shopManager.queryByDeviceId(deviceId);
			if (shop != null) {
				result.getResult().setShopIdName(shop.getShopsName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//TODO
		//这个位置是要另外查表
		jsonObject.put("success", true);
		jsonObject.put("message", "成功");
		jsonObject.put("data", JSONObject.toJSON(result.getResult()));
		return jsonObject.toString();
	}
	
	/**
	 * 插入或更新接口
	 * 
	 */
	@RequestMapping(value = { "/edit.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String editDeviceDO(
			@RequestParam(value = "deviceId", required = false) Long deviceId,
			@RequestParam(value = "productNo" ,required = false) String productNo,//设备编号
			@RequestParam(value = "manufactureDate", required = false) String manufactureDate,//生产时间
			@RequestParam(value = "startDate", required = false) String startDate,//启用时间
			@RequestParam(value = "remark") String remark,
			@RequestParam(value = "distributorId", required = false) Long distributorId,
			@RequestParam(value = "mac", required = false) String mac,
			HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		DeviceDO deviceDO = new DeviceDO();
		deviceDO.setId(deviceId);
		Result<DeviceDO> result1 = deviceManager.queryDeviceDOByProductNo(productNo);
		if (deviceId == null) {
			if (result1.getResult() != null) {
				jsonObject.put("message", "设备编号已经存在");
				return jsonObject.toString();
			}
		} else {
			if (result1.getResult() != null && !result1.getResult().getProductNo().equals(productNo)) {
				jsonObject.put("message", "设备编号已经存在");
				return jsonObject.toString();
			}
		}
		deviceDO.setProductNo(productNo);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if (StringUtils.isNotBlank(manufactureDate)) {
			try {
				date = sdf.parse(manufactureDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		deviceDO.setManufactureDate(date);
		if (StringUtils.isNotBlank(startDate)) {
			try {
				deviceDO.setStartDate(sdf.parse(startDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		deviceDO.setStatus(0);
		deviceDO.setRemark(remark);
		if (distributorId == null) {
			DistributorDO distributorDO = (DistributorDO) request.getSession()
					.getAttribute(LoginConstant.USER_DISTRIBUTOR_SESSION_KEY);
			distributorId = distributorDO.getId();
		}
		deviceDO.setDistributorId(distributorId);
		deviceDO.setMac(mac);
		Result<Long> result = deviceManager.editDeviceDO(deviceDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "数据失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	/**
	 * 更新记录状态(删除)
	 */
	@RequestMapping(value = { "/status.do","/del.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateDeviceDOStatus(@RequestParam("deviceId") Long id, @RequestParam("status") Integer status) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		DeviceDO deviceDO = new DeviceDO();
		deviceDO.setId(id);
		deviceDO.setStatus(status);

		Result<Integer> result = deviceManager.updateDeviceStatus(deviceDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	@RequestMapping(value = { "/invest.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateDeviceDOInvest(@RequestParam("deviceId") Long deviceId, @RequestParam("shopId") Long shopId,
			HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		MakerDO makerDO = (MakerDO) request.getSession().getAttribute(LoginConstant.USER_MAKER_SESSION_KEY);
		DeviceDO deviceDO = new DeviceDO();
		deviceDO.setId(deviceId);

		Result<Integer> result = deviceManager.updateDeviceDOInvest(deviceDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	@RequestMapping(value = { "/investDrop.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateDeviceDOInvestDrop(@RequestParam("deviceId") Long deviceId) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		DeviceDO deviceDO = new DeviceDO();
		deviceDO.setId(deviceId);

		Result<Integer> result = deviceManager.updateDeviceDOInvestDrop(deviceDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	
	
	
	/**
	 * 查询经销商下面的设备
	 * @param distributorId
	 * @return
	 */
	@RequestMapping("/child.do")
	@ResponseBody
	public String queryDeviceDOByDistributorId(@RequestParam(value = "distributorId") long distributorId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<List<DeviceDO>> result = deviceManager.queryDeviceDOByDistributorId(distributorId);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "查询失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "成功");
		jsonObject.put("data", JSONArray.toJSON(result.getResult()));
		return jsonObject.toString();

	}

	
	
	
	@RequestMapping("/unemployed.do")
	@ResponseBody
	public String queryDeviceDOUnemployed(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		MakerDO makerDO = (MakerDO) request.getSession().getAttribute(LoginConstant.USER_MAKER_SESSION_KEY);
		Result<List<DeviceDO>> result = null;
		if (makerDO != null) {
			// SysUsersDO sysUsersDO = (SysUsersDO)
			// request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
			DeviceDO deviceDO = new DeviceDO();
			deviceDO.setDistributorId(makerDO.getDistributorId());
			// deviceDO.setMakerId(sysUsersDO.getUserId());
			result = deviceManager.queryDeviceDOUnemployed(deviceDO);
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
		return jsonObject.toString();
	}

	public String returnString(Result<List<DeviceDO>> result, JSONObject jsonObject, DeviceQuery query) {
		if (result != null && result.isSuccess()) {
			List<DeviceDO> itemDOList = result.getResult();
			JSONArray itemList = new JSONArray();
			for (DeviceDO deviceDO : itemDOList) {
				JSONObject item = new JSONObject();

				item.put("id", deviceDO.getId());
				item.put("productNo", deviceDO.getProductNo());
				item.put("manufactureDate", deviceDO.getManufactureDate());
				item.put("startDate", deviceDO.getStartDate());
				item.put("province", deviceDO.getProvince());
				item.put("city", deviceDO.getCity());
				item.put("remark", deviceDO.getRemark());
				item.put("distributorId", deviceDO.getDistributorId());
				item.put("distributorIdName", deviceDO.getDistributorIdName());
				item.put("makerIdName", deviceDO.getMakerIdName());
				item.put("shopIdName", deviceDO.getShopIdName());
				item.put("mac", deviceDO.getMac());
				item.put("status", deviceDO.getStatus());
				item.put("created", deviceDO.getCreated());
				item.put("updated", deviceDO.getUpdated());

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

}
