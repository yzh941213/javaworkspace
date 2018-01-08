package com.zhezhuo.web.home.module.screen.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.DistributorManager;
import com.zhezhuo.biz.manager.SysUsersManager;
import com.zhezhuo.biz.manager.SysUsersRoleManager;
import com.zhezhuo.biz.util.PasswordHash;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.SysUsersDO;
import com.zhezhuo.model.entity.SysUsersRoleDO;
import com.zhezhuo.model.query.DistributorQuery;

/**
 * Created by 蝈蝈 on 2016/8/17.
 */
@Controller
@RequestMapping("/manager/distributor")
public class DistributorController {

	@Autowired
	DistributorManager distributorManager;

	@Autowired
	SysUsersManager sysUsersManager;

	@Autowired
	SysUsersRoleManager sysUsersRoleManager;
	/**
	 * 
	 * @param aoData
	 * @return
	 */
	@RequestMapping("/list.do")
	@ResponseBody
	public String queryDistributors(
			@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData) {

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

		DistributorQuery query = new DistributorQuery();
		// query.setFlag(flag);
		query.setStartRow(iDisplayStart);
		query.setPageSize(iDisplayLength);

		Result<List<DistributorDO>> result = distributorManager.queryDistributorDOList(query);
		return returnString(result, jsonObject, query);
	}

	@RequestMapping("/all.do")
	@ResponseBody
	public String queryDistributorsAll() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		DistributorQuery query = new DistributorQuery();
		Result<List<DistributorDO>> result = distributorManager.queryDistributorDOAll(query);
		jsonObject.put("success", true);
		jsonObject.put("data", JSONArray.toJSON(result.getResult()));
		return jsonObject.toString();
	}
	
	//根据经销商的名称模糊查询
	@RequestMapping("/queryByDistributorNameLike.do")
	@ResponseBody
	public String queryDistributorByNameLike(@RequestParam(value = "distributorName") String name) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			List<DistributorDO> result = distributorManager.queryDistributorDOByNameLike(name);
			jsonObject.put("success", true);
			jsonObject.put("message", "成功");
			jsonObject.put("data", JSONObject.toJSON(result));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	// 根据经销商的名称模糊查询
	@RequestMapping("/queryDistributorByNameLikeAndSysUserId.do")
	@ResponseBody
	public String queryDistributorByNameLikeAndSysUserId(
			@RequestParam(value = "distributorName") String name,
			@RequestParam(value = "sysUserId") long sysUserId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		List<DistributorDO> result_list1 = new ArrayList<DistributorDO>();
		
		try {
			Result<DistributorDO> result = distributorManager
					.queryDistributorDOBySysUserId(sysUserId);
			// 如果登录的不是经销商，当访问这个接口的时候返回查询失败
			if (result.getResult() == null) {
				 Result<List<SysUsersRoleDO>> result_role = sysUsersRoleManager.querySysUsersRole(sysUserId);
				
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
				result_list1.add(result.getResult());
				jsonObject.put("success", true);
				jsonObject.put("message", "查询成功");
				jsonObject.put("data", JSONObject.toJSON(result_list1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	/**
	 * 特征详情接口.
	 * 
	 * @param distributorId
	 *            id
	 * @return string
	 */
	@RequestMapping("/detail.do")
	@ResponseBody
	public String queryDistributors(@RequestParam(value = "distributorId") long distributorId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<DistributorDO> result = distributorManager.queryDistributorDOById(distributorId);
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
	 * @param distributorId
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
	public String editDistributorDO(@RequestParam(value = "distributorId",required=false) Long distributorId,
			@RequestParam(value = "name", defaultValue = "", required = false) String name,
			@RequestParam(value = "tel", defaultValue = "", required = false) String tel,
			@RequestParam(value = "contactPerson", defaultValue = "", required = false) String contactPerson,
			@RequestParam(value = "contactPhone", defaultValue = "", required = false) String contactPhone,
//			@RequestParam(value = "province", defaultValue = "", required = false) String province,
//			@RequestParam(value = "city", defaultValue = "0", required = false) String city,
			@RequestParam(value = "address", defaultValue = "", required = false) String address,
//			@RequestParam(value = "status", defaultValue = "0", required = false) Integer status,
			@RequestParam(value = "orderPercentage",required=false) Integer orderPercentage,
			@RequestParam(value = "servicePercentage",required=false) Integer servicePercentage,
			@RequestParam(value = "remark") String remark
//			@RequestParam(value = "sysUserId", defaultValue = "", required = false) Long sysUserId 
			){

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		DistributorDO distributorDO = new DistributorDO();
		distributorDO.setId(distributorId);
		distributorDO.setAddress(address);
		//distributorDO.setCity(city);
		distributorDO.setContactPerson(contactPerson);
		distributorDO.setContactPhone(contactPhone);
		// distributorDO.setCreated();
		distributorDO.setName(name);
		//distributorDO.setProvince(province);
		distributorDO.setRemark(remark);
		distributorDO.setStatus(0);
		//distributorDO.setSysUserId(sysUserId);
		distributorDO.setTel(tel);
		distributorDO.setOrderPercentage(orderPercentage);
		distributorDO.setServicePercentage(servicePercentage);
		// distributorDO.setUpdated();
		Result<Long> result = distributorManager.editDistributorDO(distributorDO);
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
	 * 
	 * @param distributorId
	 *            id
	 * @param status
	 *            状态
	 * @return success/fail
	 */
	@RequestMapping(value = { "/status.do", "/del.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateDistributorDOStatus(@RequestParam("distributorId") Long distributorId,
			@RequestParam("status") Integer status) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		DistributorDO distributorDO = new DistributorDO();
		distributorDO.setId(distributorId);
		distributorDO.setStatus(status);
		Result<Integer> result = distributorManager.updateDistributorStatus(distributorDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	public String returnString(Result<List<DistributorDO>> result, JSONObject jsonObject, DistributorQuery query) {
		if (result != null && result.isSuccess()) {
			List<DistributorDO> itemDOList = result.getResult();
			JSONArray itemList = new JSONArray();
			for (DistributorDO distributorDO : itemDOList) {
				JSONObject item = new JSONObject();
				item.put("id", distributorDO.getId());
				item.put("name", distributorDO.getName());
				item.put("tel", distributorDO.getTel());
				item.put("address", distributorDO.getAddress());
				item.put("city", distributorDO.getCity());
				item.put("province", distributorDO.getProvince());
				item.put("contactPerson", distributorDO.getContactPerson());
				item.put("contactPhone", distributorDO.getContactPhone());
				item.put("created", distributorDO.getCreated());
				item.put("updated", distributorDO.getUpdated());
				item.put("remark", distributorDO.getRemark());
				item.put("status", distributorDO.getStatus());
				item.put("sysUserId", distributorDO.getSysUserId());
				item.put("orderPercentage", distributorDO.getOrderPercentage());
				item.put("servicePercentage", distributorDO.getServicePercentage());
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

	@RequestMapping(value = { "/editSysUser.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String editSysUserDO(@RequestParam(value = "entityId",required=false) Long entityId,
			@RequestParam(value = "userId",required=false) Long userId,
			@RequestParam(value = "sysUserName") String sysUserName,
			@RequestParam(value = "sysMobile") String sysMobile,
			@RequestParam(value = "sysPassword") String sysPassword) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			SysUsersDO query = sysUsersManager.querySysUsersByUserName(sysMobile);
			if (query != null) {
				jsonObject.put("message", "该用户名已存在");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SysUsersDO sysUsersDO = new SysUsersDO();
		sysUsersDO.setUserId(userId);
		sysUsersDO.setUserName(sysMobile);
		sysUsersDO.setPassword(PasswordHash.createHash(sysPassword));
		sysUsersDO.setName(sysUserName);
		sysUsersDO.setMobile(sysMobile);
		sysUsersDO.setGroupId(new Long(1));// 0为系统管理员 1为经销商 2为店铺 3为创客 4为手艺人
		sysUsersDO.setCreated(String.valueOf(System.currentTimeMillis() / 1000));
		sysUsersDO.setUpdated(String.valueOf(System.currentTimeMillis() / 1000));
		//Result<Long> result = sysUsersManager.addSysUsersDOS(sysUsersDO);
		Result<Long> result = sysUsersManager.addSysUsersDOAndRole(sysUsersDO,new Long(14));
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "数据操作失败");
			return jsonObject.toString();
		} else {
			DistributorDO distributorDO = new DistributorDO();
			distributorDO.setId(entityId);
			distributorDO.setSysUserId(result.getResult());
			result = distributorManager.updateDistributorSysUserId(distributorDO);
			if (result == null || !result.isSuccess()) {
				jsonObject.put("message", "数据操作失败");
				return jsonObject.toString();
			}
			jsonObject.put("success", true);
			jsonObject.put("message", "数据更新成功");
			// TODO 授权

		}
		return jsonObject.toString();
	}

}