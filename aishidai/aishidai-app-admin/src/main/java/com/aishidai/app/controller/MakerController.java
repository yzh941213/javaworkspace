package com.aishidai.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.DeviceDO;
import com.aishidai.app.model.pojo.DeviceDOCustom;
import com.aishidai.app.model.pojo.DeviceMakerDO;
import com.aishidai.app.model.pojo.DistributorDO;
import com.aishidai.app.model.pojo.MakerDO;
import com.aishidai.app.model.pojo.MakerDOCustom;
import com.aishidai.app.model.pojo.SysUsersDO;
import com.aishidai.app.service.DeviceMakerServiec;
import com.aishidai.app.service.DeviceService;
import com.aishidai.app.service.DistributorService;
import com.aishidai.app.service.MakerService;
import com.aishidai.app.service.SysUsersService;
import com.aishidai.app.utils.PasswordHash;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


@RequestMapping("/manage/maker")
@RestController
public class MakerController {

	@Autowired
	private MakerService makerService;
	@Autowired
	private SysUsersService sysUsersService;
	@Autowired
	private DistributorService distributorService;
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private DeviceMakerServiec deviceMakerDOServiec;
	
	@RequestMapping("/queryDetail")
	public String queryDetail(@RequestParam(value = "makerId") long makerId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			MakerDOCustom makerDOCustom = makerService.queryMakerDOById(makerId);
			if (makerDOCustom != null) {
				List<DeviceMakerDO> list = deviceMakerDOServiec
						.selectByMakerId(makerDOCustom.getId());
				for (int i = 0; i < list.size(); i++) {
					DeviceDO device = deviceService.queryDeviceDOById(list.get(i).getDeviceId());
					List<DeviceDOCustom> list_set = new ArrayList<DeviceDOCustom>();
					if (device != null) {
						DeviceDOCustom deviceDO = new DeviceDOCustom();
						deviceDO.setId(device.getId());
						deviceDO.setProductNo(device.getProductNo());
						list_set.add(deviceDO);
					}
				}
				makerDOCustom.setDeviceList(list);
			}
			jsonObject.put("success", true);
			jsonObject.put("message", "成功");
			jsonObject.put("data", JSONObject.toJSON(makerDOCustom));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	
	
	@RequestMapping("/queryMakerByNameLike")
	public String queryMakerByNameLike(
			@RequestParam(value = "makerName") String makerName,
			@RequestParam(value="userId") long userId) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			//登录的人为系统账号,查询全部的
			if (sysUsersService.queryByPrimaryKey(userId).getGroupId() != null 
					&& sysUsersService.queryByPrimaryKey(userId).getGroupId() == 0) {
				List<MakerDO> list_maker = makerService.queryMakerDOAll();
				jsonObject.put("success", true);
				jsonObject.put("message", "查询成功");
				jsonObject.put("data", JSONObject.toJSON(list_maker));
				
				//登录账号为经销商
			}else if(sysUsersService.queryByPrimaryKey(userId).getGroupId() != null 
					&& sysUsersService.queryByPrimaryKey(userId).getGroupId() == 1){
				
				List<DistributorDO> list = distributorService.selectDistributorDOByUserId(userId);
				
				if (list.isEmpty() && list.size() <= 0) {
					jsonObject.put("message", "查询失败");
					jsonObject.put("data", null);
					return jsonObject.toString();
				}
				MakerDO makerDO = new MakerDO();
				makerDO.setDistributorId(list.get(0).getId());
				makerDO.setName(makerName);
				List<MakerDO> list_maker = makerService.queryMakerDOByNameLike(makerDO);
				jsonObject.put("success", true);
				jsonObject.put("message", "查询成功");
				jsonObject.put("data", JSONObject.toJSON(list_maker));
			}else{
				jsonObject.put("success", false);
				jsonObject.put("message", "查询失败,身份不对，请核对身份后重试");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String saveMakerDO(MakerDO maker,
			@RequestParam(value = "data", defaultValue = "") String data,
			@RequestParam(value = "userId", required =true) long userId) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		//禁止信息一样的创客创建
		try {
			List<MakerDO> list_maker_all = makerService.queryMakerDOAll();
			for (int i = 0; i < list_maker_all.size(); i++) {
				if (maker != null 
						&&list_maker_all.get(i).getMobile().equals(maker.getMobile()) 
						&& list_maker_all.get(i).getName().equals(maker.getName())) {
					
					    jsonObject.put("message", "信息已存在，请核对后重试！");
			            return jsonObject.toString();
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		try {
			// 先判断是否是经销商添加的
			if (maker.getDistributorId() == 0) {
				if (sysUsersService.queryByPrimaryKey(userId) != null
						&& sysUsersService.queryByPrimaryKey(userId)
								.getGroupId() != 0) {
					// 创建者必须是经销商或者总部账号
					jsonObject.put("message", "对不起，您没有相关权限，请联系管理员处理");
					return jsonObject.toString();
				}else{
					maker.setCreated(new Date());
					maker.setUpdated(new Date());
					maker.setStatus(0);
					long result = makerService.insertMaker(maker);
					if (result > 0) {
						if (makerService.addDeviceMaker(list, userId,result)) {
							jsonObject.put("success", true);
							jsonObject.put("message", "操作成功");
						}else{
							jsonObject.put("message", "操作失败");
						}
					}
				}
			} else {
				maker.setCreated(new Date());
				maker.setUpdated(new Date());
				maker.setStatus(0);
				maker.setDistributorId(userId);
				long result = makerService.insertMaker(maker);
				if (result > 0) {
					if (makerService.addDeviceMaker(list, userId,result)) {
						jsonObject.put("success", true);
						jsonObject.put("message", "操作成功");
					}else{
						jsonObject.put("message", "操作失败");
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
	public String editMaker(MakerDO maker,
			@RequestParam(value = "data", defaultValue = "") String data,
			@RequestParam(value = "userId", required = true) long userId) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		//禁止信息一样的创客创建
		try {
			List<MakerDO> list_maker_all = makerService.queryMakerDOAll();
			for (int i = 0; i < list_maker_all.size(); i++) {
				if (maker != null 
						&& list_maker_all.get(i).getId().longValue() != maker.getId().longValue()
						&& list_maker_all.get(i).getMobile().equals(maker.getMobile()) 
						&& list_maker_all.get(i).getName().equals(maker.getName())) {
					
					    jsonObject.put("message", "信息已存在，请核对后重试！");
			            return jsonObject.toString();
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		try {
			
			maker.setUpdated(new Date());
			maker.setStatus(0);
			if (makerService.editMakerDO(maker)) {
				if (makerService.editDeviceMaker(list, userId,maker.getId())) {
					jsonObject.put("success", true);
					jsonObject.put("message", "操作成功");
				}else{
					jsonObject.put("message", "操作失败");
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	@RequestMapping(value = {"/remove" }, method = RequestMethod.POST)
	public String updateMakerDOStatus(@RequestParam("makerId") long makerId, 
			@RequestParam("status") int status) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			MakerDO makerDO = makerService.queryMakerDOById(makerId);
			if ( makerDO != null) {
				makerDO.setStatus(status);
				if (makerService.editMakerDO(makerDO)) {
					jsonObject.put("success", true);
					jsonObject.put("message", "操作成功");
				}else{
					jsonObject.put("message", "操作失败");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	
	@RequestMapping(value = { "/audit"}, method = RequestMethod.POST)
	public String updateShopDOAudit(@RequestParam("makerId") long makerId, 
									@RequestParam("audit") int audit) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			MakerDO makerDO = makerService.queryMakerDOById(makerId);
			if ( makerDO != null) {
				makerDO.setAudit(audit);
				if (makerService.editMakerDO(makerDO)) {
					jsonObject.put("success", true);
					jsonObject.put("message", "操作成功");
				}else{
					jsonObject.put("message", "操作失败");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	
	@RequestMapping("/queryByDistributorId")
	public String queryByDistributorId(
			@RequestParam(value = "distributorId") long distributorId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			List<MakerDO> list = makerService
					.queryMakerDOByDistributorId(distributorId);

			jsonObject.put("success", true);
			jsonObject.put("message", "查询成功");
			jsonObject.put("data", JSONArray.toJSON(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	public String addUser(
			@RequestParam(value = "makerId") long makerId,
			@RequestParam(value = "userName") String userName,
			@RequestParam(value = "mobile") String mobile,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			SysUsersDO sudo = sysUsersService.querySysUsersByUserName(userName);
			if (sudo != null) {
				jsonObject.put("message", "该用户名已存在，请核对后重试");
				return jsonObject.toString();
			}
		
		SysUsersDO sysUsersDO = new SysUsersDO();
		sysUsersDO.setUserName(userName);
		sysUsersDO.setPassword(PasswordHash.createHash(password));
		sysUsersDO.setName(name);
		sysUsersDO.setIsDeleted(0);
		sysUsersDO.setStatus(0);
		sysUsersDO.setMobile(mobile);
		sysUsersDO.setGroupId(new Long(3));
		sysUsersDO.setCreated(Integer.valueOf(System.currentTimeMillis()/1000+""));
		sysUsersDO.setUpdated(Integer.valueOf(System.currentTimeMillis()/1000+""));
		
		Result<Long> result = sysUsersService.addSysUsersDOAndRole(sysUsersDO, new Long(15));
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "数据操作失败");
			return jsonObject.toString();
		} else {
			MakerDO makerDO = new MakerDO();
			makerDO.setId(makerId);
			makerDO.setSysUserId(result.getResult());
			if (makerService.editMakerDO(makerDO)) {
				jsonObject.put("success", true);
				jsonObject.put("message", "操作成功");
			}else{
				jsonObject.put("message", "操作失败");	
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
		
	}

	
	@RequestMapping("/queryAll")
	public String queryMakersAll() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			List<MakerDO> list = makerService.queryMakerDOAll();
			jsonObject.put("success", true);
			jsonObject.put("data", JSONArray.toJSON(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

}
