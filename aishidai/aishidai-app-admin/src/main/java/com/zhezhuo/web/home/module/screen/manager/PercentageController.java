package com.zhezhuo.web.home.module.screen.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.PercentageManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.PercentageDO;

/**
 * Created by 蝈蝈 on 2016/8/17.
 */
@Controller
@RequestMapping("/manager/percentage")
public class PercentageController {

	@Autowired
	PercentageManager percentageManager;

	/**
	 * 特征详情接口.
	 * 
	 * @param percentageId
	 *            id
	 * @return string
	 */
	@RequestMapping("/detail.do")
	@ResponseBody
	public String queryPercentages(@RequestParam(value = "percentageId") long percentageId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<PercentageDO> result = percentageManager.queryPercentageDOById(percentageId);
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
	 * @param percentageId
	 * @param attrName
	 * @param alias
	 * @param imgPath
	 * @param description
	 * @param parentId
	 * @param hot
	 * @param feature
	 * @return string
	 */
	@RequestMapping(value = { "/edit.do", "/occasion/edit.do", "/occasion/save.do", "/category/save.do",
			"/category/edit.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String editPercentageDO(@RequestParam(value = "id") Long id,
			@RequestParam(value = "sys", required = false) Integer sys,
			@RequestParam(value = "distributor", required = false) Integer distributor,
			@RequestParam(value = "maker", required = false) Integer maker,
			@RequestParam(value = "shop", required = false) Integer shop,
			@RequestParam(value = "craftsman") Integer craftsman,
			@RequestParam(value = "sysSer", required = false) Integer sysSer,
			@RequestParam(value = "distributorSer", required = false) Integer distributorSer,
			@RequestParam(value = "makerSer", required = false) Integer makerSer,
			@RequestParam(value = "shopSer", required = false) Integer shopSer,
			@RequestParam(value = "craftsmanSer") Integer craftsmanSer,
			@RequestParam(value = "status") Integer status) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		PercentageDO percentageDO = new PercentageDO();
		percentageDO.setCraftsman(craftsman);
		percentageDO.setCraftsmanSer(craftsmanSer);
		percentageDO.setDistributor(distributor);
		percentageDO.setDistributorSer(distributorSer);
		percentageDO.setId(id);
		percentageDO.setMaker(maker);
		percentageDO.setMakerSer(makerSer);
		percentageDO.setShop(shop);
		percentageDO.setShopSer(shopSer);
		percentageDO.setStatus(status);
		percentageDO.setSys(sys);
		percentageDO.setSysSer(sysSer);
		Result<Long> result = percentageManager.editPercentageDO(percentageDO);
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
	 * @param percentageId
	 *            id
	 * @param status
	 *            状态
	 * @return success/fail
	 */
	@RequestMapping(value = { "/status.do","/del.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updatePercentageDOStatus(@RequestParam("id") Long id, @RequestParam("status") int status) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		PercentageDO percentageDO = new PercentageDO();
		percentageDO.setId(id);
		percentageDO.setStatus(status);

		Result<Integer> result = percentageManager.updatePercentageStatus(percentageDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

}
