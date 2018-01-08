package com.zhezhuo.web.home.module.screen.manager;


import java.util.List;

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
import com.zhezhuo.biz.manager.CommissionManager;
import com.zhezhuo.biz.manager.DistributorManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.HqCommissionDO;
import com.zhezhuo.model.entity.MakerCommissionDetailDO;
import com.zhezhuo.model.entity.OtherShopCommissionDO;
import com.zhezhuo.model.entity.ShopCommissionDO;
import com.zhezhuo.model.query.HqCommissionQuery;
import com.zhezhuo.model.query.OtherShopCommissionQuery;
import com.zhezhuo.model.query.ShopCommissionQuery;
import com.zhezhuo.web.util.Tools;

@RequestMapping(value="/commission")
@Controller
public class CommisssionController {

	private static final Logger log = LoggerFactory.getLogger(CommisssionController.class);
	
	@Autowired
	private CommissionManager commissionManager;
	@Autowired
	private DistributorManager distributorManager;
	
	/**
	 * 
	 * 经销商查询店铺分成列表
	 * @param SYSUserId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/listShopC.do" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String queryShopCommissionList(
			@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,
			@RequestParam(value="sysUserId") long sysUserId){
			
			JSONArray jsonarray = JSONArray.parseArray(aoData);
			
			//下面开始写分页
			int iDisplayStart = 0; // 起始索引
			int iDisplayLength = 0; // 每页显示的行数
			String sEcho = null;//
			
			//读出前台给传过来的相关数据
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
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("pageSize", iDisplayLength);
			jsonObject.put("sEcho", sEcho);
			jsonObject.put("success", false);
			
			Result<DistributorDO> result = distributorManager.queryDistributorDOBySysUserId(sysUserId);
			//如果登录的不是经销商，当访问这个接口的时候返回查询失败
			if (result == null) {
				jsonObject.put("success", true);
				jsonObject.put("message", "查询失败");
				return jsonObject.toString();
			}
			
			
			ShopCommissionQuery query = new ShopCommissionQuery();
			
			//设置起始页
			query.setStartRow(iDisplayStart);
			//设置每页的个数
			query.setPageSize(iDisplayLength);
			query.setDistributorId(result.getResult().getId());
			try {
				List<ShopCommissionDO> RSD = commissionManager.queryShopCommissionList(query);
				int count = commissionManager.queryShopCommissionCount(query);
				jsonObject.put("iTotalRecords", count); 
	            jsonObject.put("iTotalDisplayRecords",count); 
	            jsonObject.put("data", RSD);
	            jsonObject.put("success", true);
				jsonObject.put("message", "查询成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return jsonObject.toString();
	}
	
	/**
	 * 经销商查询异业分成列表
	 * @param SYSUserId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/listOtherShopC.do" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String queryOtherShopCommissionList(
			@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,
			@RequestParam(value="sysUserId") long sysUserId){
			
			JSONArray jsonarray = JSONArray.parseArray(aoData);
			//下面开始写分页
			int iDisplayStart = 0; // 起始索引
			int iDisplayLength = 0; // 每页显示的行数
			String sEcho = null;//
			
			//读出前台给传过来的相关数据
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
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("pageSize", iDisplayLength);
			jsonObject.put("sEcho", sEcho);
			jsonObject.put("success", false);
			
			Result<DistributorDO> result = distributorManager.queryDistributorDOBySysUserId(sysUserId);
			//如果登录的不是经销商，当访问这个接口的时候返回查询失败
			if (result == null) {
				jsonObject.put("success", true);
				jsonObject.put("message", "查询失败");
				return jsonObject.toString();
			}
			
			
			
			OtherShopCommissionQuery query = new OtherShopCommissionQuery();
			query.setDistributorId(result.getResult().getId());
			//设置起始页
			query.setStartRow(iDisplayStart);
			//设置每页的个数
			query.setPageSize(iDisplayLength);
			
			try {
				List<OtherShopCommissionDO> RSD = commissionManager.queryOtherShopCommissionList(query);

				int count = commissionManager.queryOtherShopCommissionCount(query);
				jsonObject.put("iTotalRecords", count); 
	            jsonObject.put("iTotalDisplayRecords",count); 
	            jsonObject.put("data", RSD);
	            jsonObject.put("success", true);
				jsonObject.put("message", "查询成功");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return jsonObject.toString();
	}
	
	/**
	 * 总部查询店铺分成列表
	 * @param SYSUserId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/listHqShopC.do" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String queryShopCommissionListbByHq(
			@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData){
			
			JSONArray jsonarray = JSONArray.parseArray(aoData);
			
			//下面开始写分页
			int iDisplayStart = 0; // 起始索引
			int iDisplayLength = 0; // 每页显示的行数
			String sEcho = null;//
			
			//读出前台给传过来的相关数据
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
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("pageSize", iDisplayLength);
			jsonObject.put("sEcho", sEcho);
			jsonObject.put("success", false);
			
			
			ShopCommissionQuery query = new ShopCommissionQuery();
			
			//设置起始页
			query.setStartRow(iDisplayStart);
			//设置每页的个数
			query.setPageSize(iDisplayLength);
			
			try {
				List<ShopCommissionDO> RSD = commissionManager.queryShopCommissionListbByHq(query);
				int count = commissionManager.queryShopCommissionCountByHq(query);
				
				jsonObject.put("iTotalRecords", count); 
	            jsonObject.put("iTotalDisplayRecords",count); 
	            jsonObject.put("data", RSD);
	            jsonObject.put("success", true);
				jsonObject.put("message", "查询成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return jsonObject.toString();
	}
	/**
	 * 总部查询异业分成列表
	 * @param SYSUserId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/listHqOtherShopC.do" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String queryOtherShopCommissionListbByHq(
			@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData){
			
			JSONArray jsonarray = JSONArray.parseArray(aoData);
			
			//下面开始写分页
			int iDisplayStart = 0; // 起始索引
			int iDisplayLength = 0; // 每页显示的行数
			String sEcho = null;//
			
			//读出前台给传过来的相关数据
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
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("pageSize", iDisplayLength);
			jsonObject.put("sEcho", sEcho);
			jsonObject.put("success", false);
			
			OtherShopCommissionQuery query = new OtherShopCommissionQuery();
			//设置起始页
			query.setStartRow(iDisplayStart);
			//设置每页的个数
			query.setPageSize(iDisplayLength);
			
			try {
				List<OtherShopCommissionDO> RSD = commissionManager.queryOtherShopCommissionListByHq(query);
				int count = commissionManager.queryOtherShopCommissionCountByHq(query);
				
				jsonObject.put("iTotalRecords", count); 
	            jsonObject.put("iTotalDisplayRecords",count); 
	            jsonObject.put("data", RSD);
	            jsonObject.put("success", true);
				jsonObject.put("message", "查询成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		return jsonObject.toString();
	}
	
	/**
	 * 总部查询分成列表
	 * @param SYSUserId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/listHqC.do" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String queryHqCommissionList(
			@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData){
			
			JSONArray jsonarray = JSONArray.parseArray(aoData);
			//下面开始写分页
			int iDisplayStart = 0; // 起始索引
			int iDisplayLength = 0; // 每页显示的行数
			String sEcho = null;//
			
			//读出前台给传过来的相关数据
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
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("pageSize", iDisplayLength);
			jsonObject.put("sEcho", sEcho);
			jsonObject.put("success", false);
			
			HqCommissionQuery query = new HqCommissionQuery();
			//设置起始页
			query.setStartRow(iDisplayStart);
			//设置每页的个数
			query.setPageSize(iDisplayLength);
			
			try {
				List<OtherShopCommissionDO> RSD = commissionManager.queryHqCommissionList(query);
				int count = commissionManager.queryHqCommissionCount(query);
				jsonObject.put("iTotalRecords", count); 
	            jsonObject.put("iTotalDisplayRecords",count); 
	            jsonObject.put("data", RSD);
	            jsonObject.put("success", true);
				jsonObject.put("message", "查询成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return jsonObject.toString();
	}
	
	/**
	 * 查询异业分成详情
	 */
	@RequestMapping(value = "/otherShopCommissionDetail.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String queryOtherShops(@RequestParam(value = "id") String id) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		OtherShopCommissionDO result = null;
		List<MakerCommissionDetailDO> list = null;
		try {
			//查询基础的数据
			result = commissionManager.queryOtherShopCommissionDOById(id);
			if (result.getOtherShopId() != null) {
				//查询关联的数据
				list = commissionManager.queryMakerCommissionDOByOtherShopId(result.getOtherShopId());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "查询成功");
		jsonObject.put("data", JSONObject.toJSON(result));
		jsonObject.put("list", JSONObject.toJSON(list));
		return jsonObject.toString();
	}
	
	/**
	 * 查询店铺分成详情.
	 */
	@RequestMapping(value = "/shopCommissionDetail.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String queryShops(@RequestParam(value = "id") String id) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		ShopCommissionDO result = null;
		List<MakerCommissionDetailDO> list = null;
		try {
			result = commissionManager.queryShopCommissionDOById(id);
			
			if (result.getShopId() != null) {
				//查询关联的数据
				list = commissionManager.queryMakerCommissionDOByShopId(result.getShopId());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonObject.put("success", true);
		jsonObject.put("message", "查询成功");
		jsonObject.put("data", JSONObject.toJSON(result));
		jsonObject.put("list", JSONObject.toJSON(list));
		
		return jsonObject.toString();
	}
	/**
	 * 总部查询经销商分成详细
	 **/
	@RequestMapping(value = "/hqCommissionDetail.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String queryHqcommission(@RequestParam(value = "id") String id) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		HqCommissionDO result = null;
		try {
			result = commissionManager.queryHqCommissionDOById(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonObject.put("success", true);
		jsonObject.put("message", "查询成功");
		jsonObject.put("data", JSONObject.toJSON(result));
		
		return jsonObject.toString();
	}
	
	/**
	 *删除异业分成 
	 **/
	@RequestMapping(value = "/delOtherShopCommission.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String delOtherShopCommission(@RequestParam(value = "id") String id,
								   @RequestParam(value="del") int del) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		OtherShopCommissionDO result_otherShop = null;
		List<MakerCommissionDetailDO> result_maker_list= null;
		try {
			
			result_otherShop = commissionManager.queryOtherShopCommissionDOById(id);
			
			if (result_otherShop != null) {
				
				result_maker_list = commissionManager.queryMakerCommissionDOByShopId(result_otherShop.getOtherShopId());
				
				if (result_maker_list.isEmpty() || result_maker_list.size() <= 0 ) {
					result_otherShop.setDeleteIs(del);
					//
					int row = commissionManager.delOtherShopCommissionDO(result_otherShop);
					if (row != 0) {
						jsonObject.put("success", true);
						jsonObject.put("message", "删除成功");
					}else{
						jsonObject.put("success", true);
						jsonObject.put("message", "删除失败");
					}
				}else{
					for (MakerCommissionDetailDO makerCommissionDetailDO : result_maker_list) {
						makerCommissionDetailDO.setDeleteIs(del);
						commissionManager.delMakerCommissionDetailDO(makerCommissionDetailDO);
					}
					result_otherShop.setDeleteIs(del);
					int row = commissionManager.delOtherShopCommissionDO(result_otherShop);
					if (row != 0) {
						jsonObject.put("success", true);
						jsonObject.put("message", "删除成功");
					}else{
						jsonObject.put("success", true);
						jsonObject.put("message", "删除失败");
					}
				}
			}else{
				jsonObject.put("success", true);
				jsonObject.put("message", "删除失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	/**
	 *删除店铺分成 
	 **/
	@RequestMapping(value = "/delShopCommission.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String delShopCommission(@RequestParam(value = "id") String id,
								   @RequestParam(value="del") int del) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		ShopCommissionDO result_shop = null;
		List<MakerCommissionDetailDO> result_maker_list= null;
		
		try {
			
			result_shop = commissionManager.queryShopCommissionDOById(id);
			
			if (result_shop != null) {
				result_maker_list = commissionManager.queryMakerCommissionDOByShopId(result_shop.getShopId());
				if (result_maker_list.isEmpty() || result_maker_list.size() <= 0 ) {
					result_shop.setDeleteIs(del);
					int row = commissionManager.delShopCommissionDO(result_shop);
					if (row != 0) {
						jsonObject.put("success", true);
						jsonObject.put("message", "删除成功");
					}else{
						jsonObject.put("success", true);
						jsonObject.put("message", "删除失败");
					}
				}else{
					for (MakerCommissionDetailDO makerCommissionDetailDO : result_maker_list) {
						makerCommissionDetailDO.setDeleteIs(del);
						commissionManager.delMakerCommissionDetailDO(makerCommissionDetailDO);
					}
					result_shop.setDeleteIs(del);
					int row = commissionManager.delShopCommissionDO(result_shop);
					if (row != 0) {
						jsonObject.put("success", true);
						jsonObject.put("message", "删除成功");
					}else{
						jsonObject.put("success", true);
						jsonObject.put("message", "删除失败");
					}
				}
			}else{
				jsonObject.put("success", true);
				jsonObject.put("message", "删除失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	/**
	 *删除创客分成 
	 **/
	@RequestMapping(value = "/delMakerCommission.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String delMakerCommission(@RequestParam(value = "id") String id,
								   @RequestParam(value="del") int del) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		MakerCommissionDetailDO result = null;
		try {
			result = commissionManager.queryMakerCommissionDetailDOById(id);
			if (result != null) {
				result.setDeleteIs(del);
				int result_row = commissionManager.delMakerCommissionDetailDO(result);
				if (result_row != 0) {
					jsonObject.put("success", true);
					jsonObject.put("message", "删除成功");
				}else{
					jsonObject.put("success", true);
					jsonObject.put("message", "删除失败");
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	/**
	 * 删除总部分成
	 **/
	@RequestMapping(value = "/delHqCommission.do",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String delHqCommission(@RequestParam(value = "id") String id,
								   @RequestParam(value="del") int del) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		HqCommissionDO result = null;
		try {
			result = commissionManager.queryHqCommissionDOById(id);
			if (result != null) {
				result.setDeleteIs(del);
				int result_row = commissionManager.delHqCommissionDO(result);
				if (result_row != 0) {
					jsonObject.put("success", true);
					jsonObject.put("message", "删除成功");
				}else{
					jsonObject.put("success", true);
					jsonObject.put("message", "删除失败");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	/**
	 * 总部添加经销商分成
	 */
	@ResponseBody
	@RequestMapping(value="/addHqCommission.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String addHqCommission(
			@RequestParam(value = "distributorCommission") int distributorCommission,
			@RequestParam(value = "hQCommission") int hQCommission,
			@RequestParam(value = "sysUserId") long sysUserId,
			@RequestParam(value = "distributorId") long distributorId,
			@RequestParam(value = "distributorName") String distributorName){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		int total = hQCommission + distributorCommission;
		
		if (total != 100) {
			jsonObject.put("message", "您提交的分成数据不合理，请检查后提交");
			return jsonObject.toJSONString();
		}
		try {
			HqCommissionDO HQC = new HqCommissionDO();
				
			HQC.setId(Tools.getGuid());
			HQC.setCreateId(sysUserId);
			HQC.setHqCommission(hQCommission);
			HQC.setDeleteIs(0);
			HQC.setDistributorId(distributorId);
			HQC.setDistributorName(distributorName);
			HQC.setDistributorCommission(distributorCommission);
			commissionManager.addHqCommissionDO(HQC);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "添加成功");
		return jsonObject.toJSONString();
	}
	/**
	 * 添加异业店铺分成
	 */
	@ResponseBody
	@RequestMapping(value="/addOtherShopCommission.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String addOtherShopCommission(
			@RequestParam(value = "otherShopCommission") int otherShopCommission,
			@RequestParam(value = "makerCommission") int makerCommission,
			@RequestParam(value = "barbershopCommission") int barbershopCommission,
			@RequestParam(value = "distributorCommission") int distributorCommission,
			@RequestParam(value = "type") int type,
			@RequestParam(value = "otherShopId") long otherShopId,
			@RequestParam(value = "sysUserId") long sysUserId,
			@RequestParam(value="shopId") long shopId,
			@RequestParam(value="shopName") String shopName,
			@RequestParam(value = "otherShopName") String otherShopName,
			@RequestParam(value = "makerValue",required=false) String makerValue){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		int total = otherShopCommission + makerCommission + barbershopCommission + distributorCommission;
		if (total != 100) {
			jsonObject.put("message", "您提交的分成数据不合理，请检查后提交");
			return jsonObject.toJSONString();
		}
		Result<DistributorDO> result = distributorManager.queryDistributorDOBySysUserId(sysUserId);
		//如果登录的不是经销商，当访问这个接口的时候返回查询失败
		if (result == null) {
			jsonObject.put("success", true);
			jsonObject.put("message", "查询失败");
			return jsonObject.toString();
		}
		
		//针对用户提交的数据，判断是否已经存在，如果已经存在的话，就返回禁止添加
		//先根据异业店铺ID查询是否已经存在分成的数据
		try {
			
			OtherShopCommissionDO OSDO = commissionManager.queryOtherShopCommissionDOByOtherShopId(otherShopId);
			
			if (OSDO != null) {
				if (OSDO.getType() == type ) {
					jsonObject.put("success", true);
					jsonObject.put("message", "对不起，数据已经存在。请核对后再添加");
					return jsonObject.toJSONString();
				}
			}
			OSDO = new OtherShopCommissionDO();
				
			OSDO.setId(Tools.getGuid());
			OSDO.setBarbershopCommission(barbershopCommission);
			OSDO.setCreateId(sysUserId);
			OSDO.setType(type);//服务的类型
			OSDO.setDeleteIs(0);
			OSDO.setShopId(shopId);
			OSDO.setShopName(shopName);
			OSDO.setOtherShopId(otherShopId);
			OSDO.setOtherShopCommission(otherShopCommission);
			OSDO.setOtherShopName(otherShopName);
			OSDO.setMakerCommission(makerCommission);
			OSDO.setDistributorId(result.getResult().getId());
			OSDO.setDistributorName(result.getResult().getName());
			OSDO.setDistributorCommission(distributorCommission);
			if (makerValue != null) {
				commissionManager.insetMakerCommissionDetailDOOtherShop(makerValue, otherShopId,sysUserId);
			}
			commissionManager.insetOtherShopCommissionDO(OSDO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "添加成功");
		
		return jsonObject.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/addShopCommission.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String addShopCommission(
			@RequestParam(value = "makerCommission") int makerCommission,
			@RequestParam(value = "barbershopCommission") int barbershopCommission,
			@RequestParam(value = "distributorCommission") int distributorCommission,
			@RequestParam(value = "type") int type,
			@RequestParam(value = "shopId") long shopId,
			@RequestParam(value = "sysUserId") long sysUserId,
			@RequestParam(value = "shopName") String shopName,
			@RequestParam(value = "makerValue",required = false) String makerValue){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		int total = distributorCommission + makerCommission+barbershopCommission;
		
		if (total != 100) {
			jsonObject.put("message", "您提交的分成数据不合理，请检查后提交。");
			return jsonObject.toJSONString();
		}
		Result<DistributorDO> result = distributorManager.queryDistributorDOBySysUserId(sysUserId);
		//如果登录的不是经销商，当访问这个接口的时候返回查询失败
		if (result == null) {
			jsonObject.put("success", true);
			jsonObject.put("message", "查询失败");
			return jsonObject.toString();
		}
		try {
			ShopCommissionDO SDO = commissionManager.queryShopCommissionDOByShopId(shopId);
			if (SDO != null) {
				if (SDO.getType() == type ) {
					jsonObject.put("success", true);
					jsonObject.put("message", "对不起，数据已经存在。请核对后再添加");
					return jsonObject.toJSONString();
				}
			}
			SDO = new ShopCommissionDO();
			SDO.setId(Tools.getGuid());
			SDO.setBarbershopCommission(barbershopCommission);
			SDO.setCreateId(sysUserId);
			SDO.setType(type);
			SDO.setDeleteIs(0);
			SDO.setShopId(shopId);
			SDO.setShopName(shopName);
			SDO.setMakerCommission(makerCommission);
			SDO.setDistributorId(result.getResult().getId());
			SDO.setDistributorName(result.getResult().getName());
			SDO.setDistributorCommission(distributorCommission);
			if (makerValue != null) {
				commissionManager.insetMakerCommissionDetailDOShop(makerValue, shopId,sysUserId);
			}
			commissionManager.insetShopCommissionDO(SDO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "添加成功");
		return jsonObject.toJSONString();
	}
	/**
	 * 经销商修改异业店铺的分成
	 */
	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping(value="/editOtherShopcommission.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String editOtherShopcommission(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "otherShopCommission") int otherShopCommission,
			@RequestParam(value = "makerValue",required=false) String makerValue,
			@RequestParam(value = "barbershopCommission") int barbershopCommission,
			@RequestParam(value = "distributorCommission") int distributorCommission,
			@RequestParam(value="makerCommission") int makerCommission,
			@RequestParam(value = "sysUserId") long sysUserId){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		int total = distributorCommission + makerCommission+barbershopCommission+otherShopCommission;
		
		if (total != 100) {
			jsonObject.put("message", "您提交的分成数据不合理，请检查后提交");
			return jsonObject.toJSONString();
		}
		try {
			OtherShopCommissionDO OSCD = commissionManager.queryOtherShopCommissionDOById(id);
			List<MakerCommissionDetailDO> list = commissionManager.queryMakerCommissionDOByOtherShopId(OSCD.getOtherShopId());
			if (OSCD == null) {
				
				jsonObject.put("message", "抱歉，请稍后重试！  ");
				return jsonObject.toJSONString();
			}else{
				if (list.isEmpty() || list.size() <= 0) {
					//原先下面没有值，传过来的值为空
					if (makerValue.equals("") || makerValue == null) {
						OSCD.setBarbershopCommission(barbershopCommission);
						OSCD.setCreateId(sysUserId);
						OSCD.setOtherShopCommission(otherShopCommission);
						OSCD.setDistributorCommission(distributorCommission);
						OSCD.setMakerCommission(makerCommission);
						
						int row = commissionManager.editOtherShopCommissionDO(OSCD);
						if (row != 0) {
							jsonObject.put("success", true);
							jsonObject.put("message", "修改成功");
						}else{
							jsonObject.put("success", true);
							jsonObject.put("message", "修改失败");
						}
					}else{
						//下面没有值，穿过的值不为空
						OSCD.setBarbershopCommission(barbershopCommission);
						OSCD.setCreateId(sysUserId);
						OSCD.setOtherShopCommission(otherShopCommission);
						OSCD.setDistributorCommission(distributorCommission);
						OSCD.setMakerCommission(makerCommission);
						
						int row = commissionManager.editOtherShopCommissionDO(OSCD);
						commissionManager.insetMakerCommissionDetailDOOtherShop(makerValue, OSCD.getOtherShopId(),sysUserId);
						
						if (row != 0) {
							jsonObject.put("success", true);
							jsonObject.put("message", "修改成功");
						}else{
							jsonObject.put("success", true);
							jsonObject.put("message", "修改失败");
						}
					}
				}else{
					//下面是原先就有创客，但是传过来的创客的值空
					if (makerValue.equals("") || makerValue == null) {
						
						OSCD.setBarbershopCommission(barbershopCommission);
						OSCD.setCreateId(sysUserId);
						OSCD.setOtherShopCommission(otherShopCommission);
						OSCD.setDistributorCommission(distributorCommission);
						OSCD.setMakerCommission(makerCommission);
						for (MakerCommissionDetailDO makerCommissionDetailDO : list) {
							commissionManager.removeMakerCommissionDetailDO(makerCommissionDetailDO);
						}
						
						int row = commissionManager.editOtherShopCommissionDO(OSCD);
						
						if (row != 0) {
							jsonObject.put("success", true);
							jsonObject.put("message", "修改成功");
						}else{
							jsonObject.put("success", true);
							jsonObject.put("message", "修改失败");
						}
						
					}else{
						//下面是原先就有创客，并且传过来的值不为空——采用的方案是，将原先的删除。然后将新的存上去
						OSCD.setBarbershopCommission(barbershopCommission);
						OSCD.setCreateId(sysUserId);
						OSCD.setOtherShopCommission(otherShopCommission);
						OSCD.setDistributorCommission(distributorCommission);
						OSCD.setMakerCommission(makerCommission);
						
						for (MakerCommissionDetailDO makerCommissionDetailDO : list) {
							commissionManager.removeMakerCommissionDetailDO(makerCommissionDetailDO);
						}
						
						int row = commissionManager.editOtherShopCommissionDO(OSCD);
						
						commissionManager.insetMakerCommissionDetailDOOtherShop(makerValue, OSCD.getOtherShopId(),sysUserId);
						if (row != 0) {
							jsonObject.put("success", true);
							jsonObject.put("message", "修改成功");
						}else{
							jsonObject.put("success", true);
							jsonObject.put("message", "修改失败");
						}
						jsonObject.put("success", true);
						jsonObject.put("message", "修改成功");
						
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return jsonObject.toJSONString();
	}
	/**
	 * 经销商修改店铺的分成
	 * @return
	 */
	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping(value="/editShopcommission.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String editShopcommission(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "makerValue",required=false) String makerValue,
			@RequestParam(value = "barbershopCommission") int barbershopCommission,
			@RequestParam(value = "distributorCommission") int distributorCommission,
			@RequestParam(value = "makerCommission") int makerCommission,
			@RequestParam(value = "sysUserId") long sysUserId){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		int total = distributorCommission + makerCommission + barbershopCommission;
		
		if (total != 100) {
			
			jsonObject.put("message", "您提交的分成数据不合理，请检查后提交");
			
			return jsonObject.toJSONString();
		}
		ShopCommissionDO SCDO = null;
		try {
			 SCDO = commissionManager.queryShopCommissionDOById(id);
			List<MakerCommissionDetailDO> list = commissionManager.queryMakerCommissionDOByShopId(SCDO.getShopId());
			
			if (SCDO == null){				
				jsonObject.put("message", "抱歉，请稍后重试！");
				return jsonObject.toJSONString();
				
			}else{
				if (list.isEmpty() || list.size() <= 0) {
					//原先下面没有值，传过来的值为空
					if (makerValue.equals("") || makerValue == null) {
						SCDO.setBarbershopCommission(barbershopCommission);
						SCDO.setCreateId(sysUserId);
						SCDO.setDistributorCommission(distributorCommission);
						SCDO.setMakerCommission(makerCommission);
						
						int row = commissionManager.editShopCommissionDO(SCDO);
						if (row != 0) {
							jsonObject.put("success", true);
							jsonObject.put("message", "修改成功");
						}else{
							jsonObject.put("success", true);
							jsonObject.put("message", "修改失败");
						}
					}else{
						//下面没有值，穿过的值不为空
						
						SCDO.setBarbershopCommission(barbershopCommission);
						SCDO.setCreateId(sysUserId);
						SCDO.setDistributorCommission(distributorCommission);
						SCDO.setMakerCommission(makerCommission);
						commissionManager.insetMakerCommissionDetailDOShop(makerValue, SCDO.getShopId(),sysUserId);
						int row = commissionManager.editShopCommissionDO(SCDO);
						if (row != 0) {
							jsonObject.put("success", true);
							jsonObject.put("message", "修改成功");
						}else{
							jsonObject.put("success", true);
							jsonObject.put("message", "修改失败");
						}
					}
					
			
				}else{
					//下面是原先就有创客，但是传过来的创客的值空
					if (makerValue.equals("") || makerValue == null) {
						
						SCDO.setBarbershopCommission(barbershopCommission);
						SCDO.setCreateId(sysUserId);
						SCDO.setDistributorCommission(distributorCommission);
						SCDO.setMakerCommission(makerCommission);
						
						for (MakerCommissionDetailDO makerCommissionDetailDO : list) {
							commissionManager.removeMakerCommissionDetailDO(makerCommissionDetailDO);
						}
						
						int row = commissionManager.editShopCommissionDO(SCDO);
						if (row != 0) {
							jsonObject.put("success", true);
							jsonObject.put("message", "修改成功");
						}else{
							jsonObject.put("success", true);
							jsonObject.put("message", "修改失败");
						}
						
					}else{
						//下面是原先就有创客，并且传过来的值不为空
						SCDO.setBarbershopCommission(barbershopCommission);
						SCDO.setCreateId(sysUserId);
						SCDO.setDistributorCommission(distributorCommission);
						SCDO.setMakerCommission(makerCommission);
						for (MakerCommissionDetailDO makerCommissionDetailDO : list) {
							commissionManager.removeMakerCommissionDetailDO(makerCommissionDetailDO);
						}
						commissionManager.insetMakerCommissionDetailDOShop(makerValue, SCDO.getShopId(),sysUserId);
						int row = commissionManager.editShopCommissionDO(SCDO);
						if (row != 0) {
							jsonObject.put("success", true);
							jsonObject.put("message", "修改成功");
						}else{
							jsonObject.put("success", true);
							jsonObject.put("message", "修改失败");
						}
					}
				}	
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return jsonObject.toJSONString();	
	}
	
	/**
	 * 总部修改经销商分成
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/editHqCommission.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public String editHqCommission(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "distributorCommission") int distributorCommission,
			@RequestParam(value = "hqCommission") int hqCommission,
			@RequestParam(value = "sysUserId") long sysUserId){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		HqCommissionDO HCD = null;
		try {
			HCD = commissionManager.queryHqCommissionDOById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
		if (HCD == null ) {
			
			jsonObject.put("message", "抱歉,操作错误,请稍后重试！");
			return jsonObject.toJSONString();
		}else{
			    HCD.setDistributorCommission(distributorCommission);
				HCD.setCreateId(sysUserId);
				HCD.setHqCommission(hqCommission);
				
				try {
					int result = commissionManager.editHqCommissionDO(HCD); 
					if (result != 0) {
						jsonObject.put("success", true);
						jsonObject.put("message", "修改成功");
					}else{
						jsonObject.put("success", true);
						jsonObject.put("message", "修改失败");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return jsonObject.toJSONString();
		}
	}
}
