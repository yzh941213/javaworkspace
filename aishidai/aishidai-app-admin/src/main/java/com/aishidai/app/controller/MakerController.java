/*package com.aishidai.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aishidai.app.model.pojo.DeviceDO;
import com.aishidai.app.model.pojo.DeviceMakerDO;
import com.aishidai.app.model.pojo.MakerDO;
import com.aishidai.app.model.query.DeviceMakerQuery;
import com.aishidai.app.service.DistributorService;
import com.aishidai.app.service.MakerService;
import com.aishidai.app.service.SysUsersService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping("/manage/maker")
public class MakerController {

	@Autowired
	private MakerService makerService;
	@Autowired
	private SysUsersService sysUsersService;
	@Autowired
	private DistributorService distributorService;
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public String queryMakers(@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,HttpServletRequest request) {

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

		MakerQuery query = new MakerQuery();
		query.setStartRow(iDisplayStart);
		query.setPageSize(iDisplayLength);
		
		SysUsersDO sysUsersDO = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		
		if(sysUsersDO.getGroupId()==1){
			DistributorDO distributorDO = (DistributorDO) request.getSession()
					.getAttribute(LoginConstant.USER_DISTRIBUTOR_SESSION_KEY);
			query.setDistributorId(distributorDO.getId());
		}
		Result<List<MakerDO>> result = makerManager.queryMakerDOList(query);
		for (int k = 0; k < result.getResult().size(); k++) {
			MakerDO makerDO = result.getResult().get(k);
			if (makerDO.getDistributorId() != null) {
				Result<DistributorDO> r = distributorManager.queryDistributorDOById(makerDO.getDistributorId());
				if (r.getResult() != null) {
					makerDO.setDistributorIdName(r.getResult().getName());
				}
			}
		}
		return returnString(result, jsonObject, query);
	}

	
	@RequestMapping("/queryDetail.do")
	@ResponseBody
	public String queryDetail(
			@RequestParam(value = "makerId") long makerId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		try {
			
			MakerDO makerDO = makerService.queryMakerDOById(makerId);
			
			DeviceMakerQuery query_maker = new DeviceMakerQuery();
			
			if (makerDO != null) {
				query_maker.setMakerId(makerId);
				List<DeviceDO> list = new ArrayList<DeviceDO>();
				
				List<DeviceMakerDO> list_dm = makerService.queryDeviceMaker(query_maker);
				for (int i = 0; i < list_dm.size(); i++) {
					DeviceDO result_device = deviceService.queryDeviceDOById(list_dm.get(i).getDeviceId());
					if (result_device.getResult() != null) {
						OtherDeviceDO deviceDO = new OtherDeviceDO();
						deviceDO.setId(result_device.getResult().getId());
						deviceDO.setName(result_device.getResult().getProductNo());
						list.add(deviceDO);
					}
				}
				result.getResult().setDeviceList(list);
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
	*//**
	 * 根据创客名称模糊查询
	 * @param makerId
	 * @return
	 *//*
	@RequestMapping("/queryMakerByNameLike.do")
	@ResponseBody
	public String queryMakers(@RequestParam(value = "makerName") String makerName,
			@RequestParam(value="sysUserId") Long sysUserId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		Result<DistributorDO> distributorDO = distributorManager.queryDistributorDOBySysUserId(sysUserId);
		if (distributorDO == null) {
			jsonObject.put("success", true);
			jsonObject.put("message", "查询失败");
			return jsonObject.toString();
		}
		
		try {
			MakerDO makerDO = new MakerDO();
			makerDO.setDistributorId(distributorDO.getResult().getId());
			makerDO.setName(makerName);
			List<MakerDO> result = makerManager.queryMakerDOByNameLike(makerDO);
			jsonObject.put("success", true);
			jsonObject.put("message", "成功");
			jsonObject.put("data", JSONObject.toJSON(result));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}

	*//**
	 * 插入或更新接口
	 *//*
	@RequestMapping(value = { "/edit.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String editMakerDO(@RequestParam(value = "makerId",required=false,defaultValue="0") Long makerId,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "distributorId", defaultValue = "", required = false) Long distributorId,
			@RequestParam(value = "mobile", defaultValue = "", required = false) String mobile,
			@RequestParam(value = "remark", defaultValue = "", required = false) String remark,
			@RequestParam(value = "data", defaultValue = "") String data,
			@RequestParam(value = "sysUserId", defaultValue = "",required = true) long sysUserId,
			HttpServletRequest request) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		//禁止信息一样的创客创建
		if (makerId == 0) {
			MakerQuery query = new MakerQuery();
			
			Result<List<MakerDO>> queryMakerDOAll = makerManager.queryMakerDOAll(query);
			for (int i = 0; i < queryMakerDOAll.getResult().size(); i++) {
				if (queryMakerDOAll.getResult().get(i).getMobile().equals(mobile) 
						&& queryMakerDOAll.getResult().get(i).getName().equals(name)) {
					    jsonObject.put("message", "该创客信息已存在，请核对后重试！");
			            return jsonObject.toString();
				}
			}
		}
		
		//先将传过来的数据格式化成需要的数据
		List<DeviceMakerDO> list = null;
        try {
            list = JSONArray.parseArray(data, DeviceMakerDO.class);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("message", "参数错误");
            jsonObject.put("data", -1);
            return jsonObject.toString();
        }
        if (list == null || list.isEmpty()) {
            jsonObject.put("message", "参数错误");
            jsonObject.put("data", -1);
            return jsonObject.toString();
        }
        Result<MakerDO> result_maker = makerManager.queryMakerDOById(makerId);
        
        MakerDO makerDO = null;
        if (result_maker.getResult() != null) {
        	makerDO = result_maker.getResult();
		}else{
			makerDO = new MakerDO();
			makerDO.setId(makerId);
		}
		
		if (distributorId == null) {
			DistributorDO distributorDO = (DistributorDO) request.getSession()
					.getAttribute(LoginConstant.USER_DISTRIBUTOR_SESSION_KEY);
			distributorId = distributorDO.getId();
		}
		makerDO.setDistributorId(distributorId);
		makerDO.setMobile(mobile);
		makerDO.setName(name);
		makerDO.setRemark(remark);
		makerDO.setStatus(0);
		Result<Long> result = makerManager.editMakerDO(makerDO);
		
		//上面的数据插入成功之后，再将其他数据插入进去
		try {
			boolean bool = makerManager.addDeviceMaker(list,sysUserId,makerDO.getId());
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
	

	*//**
	 * 更新记录状态(删除)
	 * 
	 * @param makerId
	 *            id
	 * @param status
	 *            状态
	 * @return success/fail
	 *//*
	@RequestMapping(value = { "/status.do","/del.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateMakerDOStatus(@RequestParam("makerId") Long makerId, @RequestParam("status") Integer status) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		MakerDO makerDO = new MakerDO();
		makerDO.setId(makerId);
		makerDO.setStatus(status);

		Result<Integer> result = makerManager.updateMakerStatus(makerDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	
	@RequestMapping(value = { "/audit.do"}, method = RequestMethod.POST)
	@ResponseBody
	public String updateShopDOAudit(@RequestParam("makerId") Long makerId, 
									@RequestParam("audit") Integer audit) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		MakerDO makerDO = new MakerDO();
		makerDO.setId(makerId);
		makerDO.setAudit(audit);

		Result<Integer> result = null;
		try {
			result = makerManager.updateMakerAudit(makerDO);
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
	@RequestMapping("/child.do")
	@ResponseBody
	public String queryMakerDOByParentId(@RequestParam(value = "parentId") long distributorId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<List<MakerDO>> result = makerManager.queryMakerDOByDistributorId(distributorId);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "查询失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "成功");
		jsonObject.put("data", JSONArray.toJSON(result.getResult()));
		return jsonObject.toString();

	}

	public String returnString(Result<List<MakerDO>> result, JSONObject jsonObject, MakerQuery query) {
		if (result != null && result.isSuccess()) {
			List<MakerDO> itemDOList = result.getResult();
			JSONArray itemList = new JSONArray();
			for (MakerDO makerDO : itemDOList) {
				JSONObject item = new JSONObject();
				item.put("id", makerDO.getId());
				item.put("distributorId", makerDO.getDistributorId());
				item.put("distributorIdName", makerDO.getDistributorIdName());
				item.put("name", makerDO.getName());
				item.put("created", makerDO.getCreated());
				item.put("updated", makerDO.getUpdated());
				item.put("mobile", makerDO.getMobile());
				item.put("remark", makerDO.getRemark());
				item.put("sysUserId", makerDO.getSysUserId());
				item.put("orderPercentage", makerDO.getOrderPercentage());
				item.put("servicePercentage", makerDO.getServicePercentage());
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
	public String editSysUserDO(@RequestParam(value = "entityId") Long entityId,
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
		sysUsersDO.setUserName(sysMobile);
		sysUsersDO.setPassword(PasswordHash.createHash(sysPassword));
		sysUsersDO.setName(sysUserName);
		sysUsersDO.setMobile(sysMobile);
		sysUsersDO.setGroupId(new Long(3));// 0为系统管理员 1为经销商 2为店铺 3为创客 4为手艺人
		sysUsersDO.setCreated(String.valueOf(System.currentTimeMillis() / 1000));
		sysUsersDO.setUpdated(String.valueOf(System.currentTimeMillis() / 1000));
		// Result<Long> result = sysUsersManager.addSysUsersDOS(sysUsersDO);
		Result<Long> result = sysUsersManager.addSysUsersDOAndRole(sysUsersDO, new Long(15));
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "数据操作失败");
			return jsonObject.toString();
		} else {
			MakerDO makerDO = new MakerDO();
			makerDO.setId(entityId);
			makerDO.setSysUserId(result.getResult());
			result = makerManager.updateMakerSysUserId(makerDO);
			if (result == null || !result.isSuccess()) {
				jsonObject.put("message", "数据操作失败");
				return jsonObject.toString();
			}
			jsonObject.put("success", true);
			jsonObject.put("message", "数据更新成功");
		}
		return jsonObject.toString();
	}

	
	@RequestMapping("/all.do")
	@ResponseBody
	public String queryMakersAll(@RequestParam(value = "distributorId", required = false) Long distributorId,
			HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		SysUsersDO sysUsersDO = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		if (distributorId == null) {
			if (sysUsersDO.getGroupId() == 1) {
				DistributorDO distributorDO = (DistributorDO) request.getSession()
						.getAttribute(LoginConstant.USER_DISTRIBUTOR_SESSION_KEY);
				distributorId = distributorDO.getId();
			}
		}

		MakerQuery query = new MakerQuery();
		query.setDistributorId(distributorId);
		Result<List<MakerDO>> result = makerManager.queryMakerDOAll(query);
		jsonObject.put("success", true);
		jsonObject.put("data", JSONArray.toJSON(result.getResult()));
		return jsonObject.toString();
	}

}
*/