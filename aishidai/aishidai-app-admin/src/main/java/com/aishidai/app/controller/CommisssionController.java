package com.aishidai.app.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aishidai.app.model.pojo.HqCommissionDO;
import com.aishidai.app.model.pojo.MakerCommissionDetailDO;
import com.aishidai.app.model.pojo.OtherShopCommissionDO;
import com.aishidai.app.model.pojo.OtherShopCommissionDOCustom;
import com.aishidai.app.model.pojo.ShopCommissionDO;
import com.aishidai.app.model.pojo.ShopCommissionDOCustom;
import com.aishidai.app.model.query.OtherShopCommissionQuery;
import com.aishidai.app.model.query.ShopCommissionQuery;
import com.aishidai.app.service.CommissionService;
import com.aishidai.app.service.DistributorService;
import com.aishidai.app.service.SysUsersService;
import com.aishidai.common.json.JsonResult;
import com.alibaba.fastjson.JSONObject;

@RequestMapping(value="/manage/commission")
@RestController
public class CommisssionController {

	private static final Logger log = LoggerFactory.getLogger(CommisssionController.class);
	
	@Autowired
	private CommissionService commissionService;
	@Autowired
	private DistributorService distributorService;
	@Autowired
	private SysUsersService sysUsersService;
	
	@GetMapping(value="queryShopsCommissionListByRank")
	public String queryShopsCommissionListByRank(ShopCommissionQuery query){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		long userId = query.getUserId();
		try {
			List<ShopCommissionDOCustom> list = new ArrayList<ShopCommissionDOCustom>();
			//先判断是否是  // 0为系统管理员 1为经销商 2为店铺 3为创客 4为手艺人
			//总部查询全部的
			if (sysUsersService.queryByPrimaryKey(userId).getGroupId() == 0) {
				query.setIsDeleted(0);
				list = commissionService.queryShopCommissionDOList(query);
				this.addNameS(list);
				jsonObject.put("data", JsonResult.buildPaging(list, query.getsEcho(),
						(long)commissionService.queryShopCommissionDOListCount(query)));
			//经销商查询自己下面的
			}else if(sysUsersService.queryByPrimaryKey(userId).getGroupId() == 1){
				query.setDistributorId(
						distributorService.selectDistributorDOByUserId(userId).get(0).getId());
				query.setIsDeleted(0);
				list = commissionService.queryShopCommissionDOList(query);
				this.addNameS(list);
				jsonObject.put("data", JsonResult.buildPaging(list, query.getsEcho(),
						(long)commissionService.queryShopCommissionDOListCount(query)));
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
	
	private void addNameS(List<ShopCommissionDOCustom> list) throws Exception {
		for (ShopCommissionDOCustom bean : list) {
			bean.setDistributorName(
					distributorService.queryDistributorDOById(bean.getDistributorId()).getName());
		}
	}
	
	@GetMapping(value="queryOtherShopsCommissionListByRank")
	public String queryOtherShopsCommissionListByRank(OtherShopCommissionQuery query){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		long userId = query.getUserId();
		try {
			List<OtherShopCommissionDOCustom> list = new ArrayList<OtherShopCommissionDOCustom>();
			//先判断是否是  // 0为系统管理员 1为经销商 2为店铺 3为创客 4为手艺人
			//总部查询全部的
			if (sysUsersService.queryByPrimaryKey(userId).getGroupId() == 0) {
				query.setIsDeleted(0);
				list = commissionService.queryOtherShopCommissionDOList(query);
				this.addNameO(list);
				jsonObject.put("data", JsonResult.buildPaging(list, query.getsEcho(),
						(long)commissionService.queryOtherShopCommissionDOListCount(query)));
			//经销商查询自己下面的
			}else if(sysUsersService.queryByPrimaryKey(userId).getGroupId() == 1){
				query.setDistributorId(
						distributorService.selectDistributorDOByUserId(userId).get(0).getId());
				query.setIsDeleted(0);
				list = commissionService.queryOtherShopCommissionDOList(query);
				this.addNameO(list);
				jsonObject.put("data", JsonResult.buildPaging(list, query.getsEcho(),
						(long)commissionService.queryOtherShopCommissionDOListCount(query)));
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
	private void addNameO(List<OtherShopCommissionDOCustom> list) throws Exception {
		for (OtherShopCommissionDOCustom bean : list) {
			bean.setDistributorName(
					distributorService.queryDistributorDOById(bean.getDistributorId()).getName());
		}
	}
	/**
	 * 查询异业店铺分成详情
	 */
	@RequestMapping(value = "/queryOtherShopCommissionDetail",method={RequestMethod.GET,RequestMethod.POST})
	public String queryOtherShops(@RequestParam(value = "id") long id) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			//查询基础的数据
			OtherShopCommissionDO oscdo = 
					commissionService.queryOtherShopCommissionDOById(id);
			if (oscdo.getOtherShopId() != null) {
				//查询关联的数据
				List<MakerCommissionDetailDO> list = 
						commissionService.queryMakerCommissionDOByOtherShopId(oscdo.getOtherShopId());
				jsonObject.put("list", JSONObject.toJSON(list));
			}
			jsonObject.put("success", true);
			jsonObject.put("message", "查询成功");
			jsonObject.put("data", JSONObject.toJSON(oscdo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	/**
	 * 查询店铺分成详情.
	 */
	@RequestMapping(value = "/queryShopCommissionDetail",method={RequestMethod.GET,RequestMethod.POST})
	public String queryShops(@RequestParam(value = "id") long id) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			ShopCommissionDO scdo = 
					commissionService.queryShopCommissionDOById(id);
			
			if (scdo.getShopId() != null) {
				//查询关联的数据
				List<MakerCommissionDetailDO> list = 
						commissionService.queryMakerCommissionDOByShopId(scdo.getShopId());
				jsonObject.put("list", JSONObject.toJSON(list));
			}
			jsonObject.put("success", true);
			jsonObject.put("message", "查询成功");
			jsonObject.put("data", JSONObject.toJSON(scdo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	/**
	 * 总部查询经销商分成详细
	 **/
	@RequestMapping(value = "/hqCommissionDetail",method={RequestMethod.GET,RequestMethod.POST})
	public String queryHqcommission(@RequestParam(value = "id") long id) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			HqCommissionDO hqCommissionDO = commissionService.queryHqCommissionDOById(id);
			jsonObject.put("success", true);
			jsonObject.put("message", "查询成功");
			jsonObject.put("data", JSONObject.toJSON(hqCommissionDO));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	/**
	 *删除异业分成 
	 **/
	@RequestMapping(value = "/removeOtherShopCommission",method={RequestMethod.GET,RequestMethod.POST})
	public String removeOtherShopCommission(@RequestParam(value = "id") long id,
								   @RequestParam(value="isDelete") int isDelete) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		try {
			OtherShopCommissionDO result_otherShop = commissionService.queryOtherShopCommissionDOById(id);
			
			if (result_otherShop != null) {
				List<MakerCommissionDetailDO> result_maker_list = 
						commissionService.queryMakerCommissionDOByOtherShopId(result_otherShop.getOtherShopId());
				if (result_maker_list.isEmpty() && result_maker_list.size() <= 0 ) {
					result_otherShop.setIsDelete(isDelete);
					if (commissionService.editOtherShopCommissionDO(result_otherShop)) {
						jsonObject.put("success", true);
						jsonObject.put("message", "删除成功");
					}else{
						jsonObject.put("success", true);
						jsonObject.put("message", "删除失败");
					}
				}else{
					for (MakerCommissionDetailDO makerCommissionDetailDO : result_maker_list) {
						makerCommissionDetailDO.setIsDelete(isDelete);
						commissionService.editMakerCommissionDOShop(makerCommissionDetailDO);
					}
					result_otherShop.setIsDelete(isDelete);
					if (commissionService.editOtherShopCommissionDO(result_otherShop)) {
						jsonObject.put("success", true);
						jsonObject.put("message", "删除成功");
					}else{
						jsonObject.put("success", true);
						jsonObject.put("message", "删除失败");
					}
				}
			}else{
				jsonObject.put("success", true);
				jsonObject.put("message", "删除失败,数据不存在，请核对后重试");
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
	@RequestMapping(value = "/removeShopCommission",method={RequestMethod.GET,RequestMethod.POST})
	public String removeShopCommission(@RequestParam(value = "id") long id,
								   @RequestParam(value="isDelete") int isDelete) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			ShopCommissionDO result_shop = commissionService.queryShopCommissionDOById(id);
			if (result_shop != null) {
				List<MakerCommissionDetailDO> result_maker_list = 
						commissionService.queryMakerCommissionDOByShopId(result_shop.getShopId());
				if (result_maker_list.isEmpty() || result_maker_list.size() <= 0 ) {
					result_shop.setIsDelete(isDelete);
					if (commissionService.editShopCommissionDO(result_shop)) {
						jsonObject.put("success", true);
						jsonObject.put("message", "删除成功");
					}else{
						jsonObject.put("success", true);
						jsonObject.put("message", "删除失败");
					}
				}else{
					for (MakerCommissionDetailDO makerCommissionDetailDO : result_maker_list) {
						makerCommissionDetailDO.setIsDelete(isDelete);
						commissionService.editMakerCommissionDOShop(makerCommissionDetailDO);
					}
					result_shop.setIsDelete(isDelete);
					if (commissionService.editShopCommissionDO(result_shop)) {
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
	@RequestMapping(value = "/removeMakerCommission",method={RequestMethod.GET,RequestMethod.POST})
	public String removeMakerCommission(@RequestParam(value = "id") long id,
								   @RequestParam(value="isDelete") int isDelete) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			MakerCommissionDetailDO mcddo = commissionService.queryMakerCommissionDetailDOById(id);
			if (mcddo != null) {
				mcddo.setIsDelete(isDelete);
				if (commissionService.editMakerCommissionDOShop(mcddo)) {
					jsonObject.put("success", true);
					jsonObject.put("message", "删除成功");
				}else{
					jsonObject.put("success", true);
					jsonObject.put("message", "删除失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	/**
	 * 删除总部分成
	 **/
	@RequestMapping(value = "/removeHqCommission",method={RequestMethod.GET,RequestMethod.POST})
	public String removeHqCommission(@RequestParam(value = "id") long id,
								     @RequestParam(value="isDelete") int isDelete) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			HqCommissionDO hqdo = commissionService.queryHqCommissionDOById(id);
			if (hqdo != null) {
				hqdo.setIsDelete(isDelete);
				if (commissionService.editHqCommissionDO(hqdo)) {
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
	
	@RequestMapping(value="/addHqCommission" ,method={RequestMethod.GET,RequestMethod.POST})
	public String addHqCommission(
			@RequestParam(value = "distributorCommission") int distributorCommission,
			@RequestParam(value = "hQCommission") int hQCommission,
			@RequestParam(value = "userId") long userId,
			@RequestParam(value = "distributorId") long distributorId,
			@RequestParam(value = "distributorName") String distributorName){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		int total = hQCommission + distributorCommission;
		if (total != 100) {
			jsonObject.put("message", "您提交的分成数据不符合规则，请核对后重试");
			return jsonObject.toJSONString();
		}
		try {
			HqCommissionDO HQC = new HqCommissionDO();
			HQC.setCreateId(userId);
			HQC.setHqCommission(hQCommission);
			HQC.setIsDelete(0);
			HQC.setDistributorId(distributorId);
			HQC.setDistributorName(distributorName);
			HQC.setDistributorCommission(distributorCommission);
			if (commissionService.addHqCommissionDO(HQC)) {
				jsonObject.put("success", true);
				jsonObject.put("message", "添加成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toJSONString();
	}
	
	/**
	 * 添加异业店铺分成
	 */
	
	@RequestMapping(value="/addOtherShopCommission" ,method={RequestMethod.GET,RequestMethod.POST})
	public String addOtherShopCommission(
			@RequestParam(value = "otherShopCommission") int otherShopCommission,
			@RequestParam(value = "makerCommission") int makerCommission,
			@RequestParam(value = "barbershopCommission") int barbershopCommission,
			@RequestParam(value = "distributorCommission") int distributorCommission,
			@RequestParam(value = "distributorId",required=false,defaultValue="0") long distributorId,
			@RequestParam(value = "distributorName",required=false,defaultValue="") String distributorName,
			@RequestParam(value = "type") int type,
			@RequestParam(value = "otherShopId") long otherShopId,
			@RequestParam(value = "userId") long userId,
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
		//针对用户提交的数据，判断是否已经存在，如果已经存在的话，就返回禁止添加
		//先根据异业店铺ID查询是否已经存在分成的数据
		try {
			if (sysUsersService.queryByPrimaryKey(userId).getGroupId()
					.longValue() == 0) {
				if (distributorId == 0) {
					jsonObject.put("message", "请输入一级绑定人");
					return jsonObject.toString();
				}
				OtherShopCommissionDO oscdo = commissionService
						.queryOtherShopCommissionDOByOtherShopId(otherShopId);
				if (oscdo != null) {
					if (oscdo.getType() == type) {
						jsonObject.put("success", true);
						jsonObject.put("message", "对不起，数据已经存在。请核对后再添加");
						return jsonObject.toJSONString();
					}
				}
				oscdo = new OtherShopCommissionDO();

				oscdo.setBarbershopCommission(barbershopCommission);
				oscdo.setCreateId(userId);
				oscdo.setType(type);// 服务的类型
				oscdo.setIsDelete(0);
				oscdo.setShopId(shopId);
				oscdo.setShopName(shopName);
				oscdo.setOtherShopId(otherShopId);
				oscdo.setOtherShopCommission(otherShopCommission);
				oscdo.setOtherShopName(otherShopName);
				oscdo.setMakerCommission(makerCommission);
				oscdo.setDistributorId(distributorId);
				oscdo.setDistributorName(distributorName);
				oscdo.setDistributorCommission(distributorCommission);
				if (makerValue != null && "".equals(makerValue)
						&& commissionService.insertOtherShopCommissionDO(oscdo)) {
					commissionService.insertMakerCommissionDetailDOOtherShop(
							makerValue, otherShopId, userId);
				}
			} else if (sysUsersService.queryByPrimaryKey(userId).getGroupId()
					.longValue() == 1) {
				OtherShopCommissionDO oscdo = commissionService
						.queryOtherShopCommissionDOByOtherShopId(otherShopId);
				if (oscdo != null) {
					if (oscdo.getType() == type) {
						jsonObject.put("success", true);
						jsonObject.put("message", "对不起，数据已经存在。请核对后再添加");
						return jsonObject.toJSONString();
					}
				}
				oscdo = new OtherShopCommissionDO();

				oscdo.setBarbershopCommission(barbershopCommission);
				oscdo.setCreateId(userId);
				oscdo.setType(type);// 服务的类型
				oscdo.setIsDelete(0);
				oscdo.setShopId(shopId);
				oscdo.setShopName(shopName);
				oscdo.setOtherShopId(otherShopId);
				oscdo.setOtherShopCommission(otherShopCommission);
				oscdo.setOtherShopName(otherShopName);
				oscdo.setMakerCommission(makerCommission);
				
				oscdo.setDistributorId(distributorService.selectDistributorDOByUserId(userId).get(0).getId());
				oscdo.setDistributorName(distributorService.selectDistributorDOByUserId(userId).get(0).getName());
				oscdo.setDistributorCommission(distributorCommission);
				if (makerValue != null && "".equals(makerValue)
						&& commissionService.insertOtherShopCommissionDO(oscdo)) {
					commissionService.insertMakerCommissionDetailDOOtherShop(
							makerValue, otherShopId, userId);
				}
			} else {
				jsonObject.put("message", "查询失败，您的身份不对，请核实后重试");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toJSONString();
	}
	
	
	@RequestMapping(value="/addShopCommission" ,method={RequestMethod.GET,RequestMethod.POST})
	public String addShopCommission(
			@RequestParam(value = "makerCommission") int makerCommission,
			@RequestParam(value = "barbershopCommission") int barbershopCommission,
			@RequestParam(value = "distributorCommission") int distributorCommission,
			@RequestParam(value = "distributorId",required=false,defaultValue="0") long distributorId,
			@RequestParam(value = "distributorName",required=false,defaultValue="") String distributorName,
			@RequestParam(value = "type") int type,
			@RequestParam(value = "shopId") long shopId,
			@RequestParam(value = "userId") long userId,
			@RequestParam(value = "shopName") String shopName,
			@RequestParam(value = "makerValue",required = false) String makerValue){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		int total = distributorCommission + makerCommission+barbershopCommission;
		
		if (total != 100) {
			jsonObject.put("message", "您提交的分成数据不合理，请检查后提交。");
			return jsonObject.toJSONString();
		}
		try {
			if (sysUsersService.queryByPrimaryKey(userId).getGroupId().longValue() == 0) {
				if (distributorId == 0) {
					jsonObject.put("message", "请输入一级绑定人");
					return jsonObject.toString();
				}
				ShopCommissionDO sdo = commissionService.queryShopCommissionDOByShopId(shopId);
				if (sdo != null) {
					if (sdo.getType() == type ) {
						jsonObject.put("success", true);
						jsonObject.put("message", "对不起，数据已经存在。请核对后再添加");
						return jsonObject.toJSONString();
					}
				}
				sdo = new ShopCommissionDO();
				sdo.setBarbershopCommission(barbershopCommission);
				sdo.setCreateId(userId);
				sdo.setType(type);
				sdo.setIsDelete(0);
				sdo.setShopId(shopId);
				sdo.setShopName(shopName);
				sdo.setMakerCommission(makerCommission);
				sdo.setDistributorId(distributorId);
				sdo.setDistributorName(distributorName);
				sdo.setDistributorCommission(distributorCommission);
				if (makerValue != null && "".equals(makerValue) 
						&& commissionService.insertShopCommissionDO(sdo)) {
					commissionService.insertMakerCommissionDetailDOShop(makerValue, shopId,userId);
				}
			}else if (sysUsersService.queryByPrimaryKey(userId).getGroupId().longValue() == 1) {
				ShopCommissionDO sdo = commissionService.queryShopCommissionDOByShopId(shopId);
				if (sdo != null) {
					if (sdo.getType() == type ) {
						jsonObject.put("success", true);
						jsonObject.put("message", "对不起，数据已经存在。请核对后再添加");
						return jsonObject.toJSONString();
					}
				}
				sdo = new ShopCommissionDO();
				sdo.setBarbershopCommission(barbershopCommission);
				sdo.setCreateId(userId);
				sdo.setType(type);
				sdo.setIsDelete(0);
				sdo.setShopId(shopId);
				sdo.setShopName(shopName);
				sdo.setMakerCommission(makerCommission);
				sdo.setDistributorId(distributorService.selectDistributorDOByUserId(userId).get(0).getId());
				sdo.setDistributorName(distributorService.selectDistributorDOByUserId(userId).get(0).getName());
				sdo.setDistributorCommission(distributorCommission);
				if (makerValue != null && "".equals(makerValue) 
						&& commissionService.insertShopCommissionDO(sdo)) {
					commissionService.insertMakerCommissionDetailDOShop(makerValue, shopId,userId);
				}
			}else {
				jsonObject.put("message", "查询失败，您的身份不对，请核实后重试");
				return jsonObject.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "添加成功");
		return jsonObject.toJSONString();
	}
	
	/**
	 * 经销商修改异业店铺的分成
	 */
	
	@RequestMapping(value="/editOtherShopcommission" ,method={RequestMethod.GET,RequestMethod.POST})
	public String editOtherShopcommission(
			@RequestParam(value = "id") long id,
			@RequestParam(value = "otherShopCommission") int otherShopCommission,
			@RequestParam(value = "makerValue",required=false) String makerValue,
			@RequestParam(value = "barbershopCommission") int barbershopCommission,
			@RequestParam(value = "distributorCommission") int distributorCommission,
			@RequestParam(value="makerCommission") int makerCommission,
			@RequestParam(value = "userId") long userId){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		int total = distributorCommission + makerCommission+barbershopCommission+otherShopCommission;
		
		if (total != 100) {
			jsonObject.put("message", "您提交的分成数据不合理，请检查后提交");
			return jsonObject.toJSONString();
		}
		try {
			OtherShopCommissionDO oscd = commissionService.queryOtherShopCommissionDOById(id);
			List<MakerCommissionDetailDO> list = commissionService.queryMakerCommissionDOByOtherShopId(oscd.getOtherShopId());
			
			oscd.setBarbershopCommission(barbershopCommission);
			oscd.setCreateId(userId);
			oscd.setOtherShopCommission(otherShopCommission);
			oscd.setDistributorCommission(distributorCommission);
			oscd.setMakerCommission(makerCommission);
			
			if ("".equals(makerValue) && makerValue == null) {
				if (list.isEmpty() && list.size()<=0
						&& commissionService.editOtherShopCommissionDO(oscd)) {
					jsonObject.put("success", true);
					jsonObject.put("message", "修改成功");
					return jsonObject.toJSONString();
				}else{
					for (MakerCommissionDetailDO makerCommissionDetailDO : list) {
						makerCommissionDetailDO.setIsDelete(1);
						commissionService.editMakerCommissionDOShop(makerCommissionDetailDO);
					}
					if (commissionService.editOtherShopCommissionDO(oscd)) {
						jsonObject.put("success", true);
						jsonObject.put("message", "修改成功");
						return jsonObject.toJSONString();
					}else{
						jsonObject.put("message", "修改失败");
						return jsonObject.toJSONString();
					}
				}
			}else{
				if (list.isEmpty() && list.size()<=0
						&& commissionService.editOtherShopCommissionDO(oscd)) {
					
					commissionService.insertMakerCommissionDetailDOOtherShop(makerValue, oscd.getOtherShopId(),userId);
					jsonObject.put("success", true);
					jsonObject.put("message", "修改成功");
					return jsonObject.toJSONString();
				}else{
					for (MakerCommissionDetailDO makerCommissionDetailDO : list) {
						commissionService.removeMakerCommissionDetailDO(makerCommissionDetailDO.getId());
					}
					commissionService.insertMakerCommissionDetailDOOtherShop(makerValue, oscd.getOtherShopId(),userId);
					if (commissionService.editOtherShopCommissionDO(oscd)) {
						jsonObject.put("success", true);
						jsonObject.put("message", "修改成功");
						return jsonObject.toJSONString();
					}else{
						jsonObject.put("message", "修改失败");
						return jsonObject.toJSONString();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	  return jsonObject.toJSONString();
	}
	/**
	 * 修改店铺的分成
	 * @return
	 */
	
	@RequestMapping(value="/editShopcommission" ,method={RequestMethod.GET,RequestMethod.POST})
	public String editShopcommission(
			@RequestParam(value = "id") long id,
			@RequestParam(value = "makerValue",required = false) String makerValue,
			@RequestParam(value = "barbershopCommission") int barbershopCommission,
			@RequestParam(value = "distributorCommission") int distributorCommission,
			@RequestParam(value = "makerCommission") int makerCommission,
			@RequestParam(value = "userId") long userId){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		int total = distributorCommission + makerCommission + barbershopCommission;
		
		if (total != 100) {
			jsonObject.put("message", "您提交的分成数据不合理，请检查后提交");
			return jsonObject.toJSONString();
		}
		
		try {
			ShopCommissionDO scdo = commissionService.queryShopCommissionDOById(id);
			List<MakerCommissionDetailDO> list = commissionService.queryMakerCommissionDOByShopId(scdo.getShopId());
			
			scdo.setBarbershopCommission(barbershopCommission);
			scdo.setCreateId(userId);
			scdo.setDistributorCommission(distributorCommission);
			scdo.setMakerCommission(makerCommission);
			
			if ("".equals(makerValue) && makerValue == null) {
				if (list.isEmpty() && list.size()<=0
						&& commissionService.editShopCommissionDO(scdo)) {
					jsonObject.put("success", true);
					jsonObject.put("message", "修改成功");
					return jsonObject.toJSONString();
				}else{
					for (MakerCommissionDetailDO makerCommissionDetailDO : list) {
						makerCommissionDetailDO.setIsDelete(1);
						commissionService.editMakerCommissionDOShop(makerCommissionDetailDO);
					}
					if (commissionService.editShopCommissionDO(scdo)) {
						jsonObject.put("success", true);
						jsonObject.put("message", "修改成功");
						return jsonObject.toJSONString();
					}else{
						jsonObject.put("message", "修改失败");
						return jsonObject.toJSONString();
					}
				}
			}else{
				if (list.isEmpty() && list.size()<=0
						&& commissionService.editShopCommissionDO(scdo)) {
					
					commissionService.insertMakerCommissionDetailDOShop(makerValue, scdo.getShopId(),userId);
					jsonObject.put("success", true);
					jsonObject.put("message", "修改成功");
					return jsonObject.toJSONString();
				}else{
					for (MakerCommissionDetailDO makerCommissionDetailDO : list) {
						
						commissionService.removeMakerCommissionDetailDO(makerCommissionDetailDO.getId());
					}
					commissionService.insertMakerCommissionDetailDOShop(makerValue, scdo.getShopId(),userId);
					if (commissionService.editShopCommissionDO(scdo)) {
						jsonObject.put("success", true);
						jsonObject.put("message", "修改成功");
						return jsonObject.toJSONString();
					}else{
						jsonObject.put("message", "修改失败");
						return jsonObject.toJSONString();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toJSONString();	
	}
	
	/**
	 * 总部修改经销商分成
	 * @return
	 */
	
	@RequestMapping(value="/editHqCommission" ,method={RequestMethod.GET,RequestMethod.POST})
	public String editHqCommission(
			@RequestParam(value = "id") long id,
			@RequestParam(value = "distributorCommission") int distributorCommission,
			@RequestParam(value = "hqCommission") int hqCommission,
			@RequestParam(value = "userId") long userId){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		try {
			HqCommissionDO HCD = commissionService.queryHqCommissionDOById(id);
			HCD.setDistributorCommission(distributorCommission);
			HCD.setCreateId(userId);
			HCD.setUpdated(new Date());
			HCD.setHqCommission(hqCommission);
			if (commissionService.editHqCommissionDO(HCD)) {
				jsonObject.put("success", true);
				jsonObject.put("message", "修改成功");
			} else {
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
