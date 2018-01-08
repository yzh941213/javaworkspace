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
import com.zhezhuo.biz.manager.BankCardManager;
import com.zhezhuo.biz.manager.CraftsmenManager;
import com.zhezhuo.biz.manager.DistributorManager;
import com.zhezhuo.biz.manager.MakerManager;
import com.zhezhuo.biz.manager.ShopManager;
import com.zhezhuo.biz.manager.SysUsersManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.BankCardDO;
import com.zhezhuo.model.entity.CraftsmenDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.entity.SysUsersDO;
import com.zhezhuo.model.query.BankCardQuery;
import com.zhezhuo.web.home.common.LoginConstant;

/**
 * Created by 蝈蝈 on 2016/8/17.
 */
@Controller
@RequestMapping("/manager/bankCard")
public class BankCardController {

	@Autowired
	BankCardManager bankCardManager;
	@Autowired
	SysUsersManager sysUsersManager;
	@Autowired
	DistributorManager distributorManager;
	@Autowired
	ShopManager shopManager;
	@Autowired
	MakerManager makerManager;
	@Autowired
	CraftsmenManager craftsmenManager;

	/**
	 * 
	 * @param aoData
	 * @return
	 */
	@RequestMapping("/list.do")
	@ResponseBody
	public String queryBankCards(@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,
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

		BankCardQuery query = new BankCardQuery();
		query.setStartRow(iDisplayStart);
		query.setPageSize(iDisplayLength);
		SysUsersDO sysUsersDO = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		if (sysUsersDO.getGroupId() > 0) {
			query.setSysUserId(sysUsersDO.getUserId());
		}
		Result<List<BankCardDO>> result = bankCardManager.queryBankCardDOList(query);
		List<BankCardDO> list = result.getResult();
		for (int i = 0; i < list.size(); i++) {
			BankCardDO bankCardDO = list.get(i);
			Result<SysUsersDO> user = sysUsersManager.querySysUserInfoById(bankCardDO.getUserId());
			if (user.getResult().getGroupId() == 0) {
				bankCardDO.setEntityName(user.getResult().getName());
			} else if (user.getResult().getGroupId() == 1) {
				Result<DistributorDO> distributorDO = distributorManager
						.queryDistributorDOBySysUserId(bankCardDO.getUserId());
				bankCardDO.setEntityName(distributorDO.getResult().getName());
			} else if (user.getResult().getGroupId() == 2) {
				Result<ShopDO> shopDO;
				try {
					shopDO = shopManager.queryShopDOBySysUserId(bankCardDO.getUserId());
					bankCardDO.setEntityName(shopDO.getResult().getShopsName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else if (user.getResult().getGroupId() == 3) {
				Result<MakerDO> makerDO = makerManager.queryMakerDOBySysUserId(bankCardDO.getUserId());
				bankCardDO.setEntityName(makerDO.getResult().getName());
			} else if (user.getResult().getGroupId() == 4) {
				Result<CraftsmenDO> craftsmenDO = craftsmenManager.queryCraftsmenDOBySysUserId(bankCardDO.getUserId());
				bankCardDO.setEntityName(craftsmenDO.getResult().getCraftsmanName());
			}
		}
		return returnString(result, jsonObject, query);
	}

	/**
	 * 特征详情接口.
	 * 
	 * @param BankCardId
	 *            id
	 * @return string
	 */
	@RequestMapping("/detail.do")
	@ResponseBody
	public String queryBankCards(@RequestParam(value = "cardId") long cardId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<BankCardDO> result = bankCardManager.queryBankCardDOById(cardId);
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
	 * @param BankCardId
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
	public String editBankCardDO(@RequestParam(value = "cardId", required = false) Long cardId,
			@RequestParam(value = "bankName") String bankName,
			@RequestParam(value = "branches", defaultValue = "", required = false) String branches,
			@RequestParam(value = "cardNum", defaultValue = "", required = false) String cardNum,
			// @RequestParam(value = "isDefault") String address,
			// @RequestParam(value = "remark") Integer isDefault,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "mobile", required = false) String mobile,
			@RequestParam(value = "userId", required = false) Long userId, HttpServletRequest request) {

		SysUsersDO sysUsersDO = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		BankCardDO bankCardDO = new BankCardDO();
		bankCardDO.setBankName(bankName);
		bankCardDO.setBranches(branches);
		bankCardDO.setStatus(0);
		bankCardDO.setCardId(cardId);
		bankCardDO.setCardNum(cardNum);
		// bankCardDO.setIsDefault(isDefault);
		bankCardDO.setMobile(mobile);
		bankCardDO.setName(name);
		if (userId == null) {
			bankCardDO.setUserId(sysUsersDO.getUserId());
		} else {
			bankCardDO.setUserId(userId);
		}
		Result<Long> result = bankCardManager.editBankCardDO(bankCardDO);
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
	 * @param BankCardId
	 *            id
	 * @param status
	 *            状态
	 * @return success/fail
	 */
	@RequestMapping(value = { "/status.do", "/del.do" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateBankCardDOStatus(@RequestParam("bankCardId") Long cardId,
			@RequestParam("status") Integer status) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		BankCardDO BankCardDO = new BankCardDO();
		BankCardDO.setCardId(cardId);
		BankCardDO.setStatus(status);

		Result<Integer> result = bankCardManager.updateBankCardStatus(BankCardDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "操作成功");
		return jsonObject.toString();
	}

	@RequestMapping("/all.do")
	@ResponseBody
	public String queryBankCardsAll(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		SysUsersDO sysUsersDO = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		BankCardQuery query = new BankCardQuery();
		//if (sysUsersDO.getGroupId() > 0) {
			query.setSysUserId(sysUsersDO.getUserId());
		//}
		Result<List<BankCardDO>> result = bankCardManager.queryBankCardDOByUserId(query);
		List<BankCardDO> list = result.getResult();
		for (int i = 0; i < list.size(); i++) {
			BankCardDO bankCardDO = list.get(i);
			Result<SysUsersDO> user = sysUsersManager.querySysUserInfoById(bankCardDO.getUserId());
			if (user.getResult().getGroupId() == 0) {
				bankCardDO.setEntityName(user.getResult().getName());
			} else if (user.getResult().getGroupId() == 1) {
				Result<DistributorDO> distributorDO = distributorManager
						.queryDistributorDOBySysUserId(bankCardDO.getUserId());
				bankCardDO.setEntityName(distributorDO.getResult().getName());
			} else if (user.getResult().getGroupId() == 2) {
				Result<ShopDO> shopDO;
				try {
					shopDO = shopManager.queryShopDOBySysUserId(bankCardDO.getUserId());
					bankCardDO.setEntityName(shopDO.getResult().getShopsName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else if (user.getResult().getGroupId() == 3) {
				Result<MakerDO> makerDO = makerManager.queryMakerDOBySysUserId(bankCardDO.getUserId());
				bankCardDO.setEntityName(makerDO.getResult().getName());
			} else if (user.getResult().getGroupId() == 4) {
				Result<CraftsmenDO> craftsmenDO = craftsmenManager.queryCraftsmenDOBySysUserId(bankCardDO.getUserId());
				bankCardDO.setEntityName(craftsmenDO.getResult().getCraftsmanName());
			}
		}
		
		jsonObject.put("success", true);
		jsonObject.put("data", JSONArray.toJSON(result.getResult()));
		return jsonObject.toString();
	}

	public String returnString(Result<List<BankCardDO>> result, JSONObject jsonObject, BankCardQuery query) {
		if (result != null && result.isSuccess()) {
			List<BankCardDO> itemDOList = result.getResult();
			JSONArray itemList = new JSONArray();
			for (BankCardDO bankCardDO : itemDOList) {
				JSONObject item = new JSONObject();
				item.put("cardId", bankCardDO.getCardId());
				item.put("userId", bankCardDO.getUserId());
				item.put("bankName", bankCardDO.getBankName());
				item.put("branches", bankCardDO.getBranches());
				item.put("cardNum", bankCardDO.getCardNum());
				item.put("created", bankCardDO.getCreated());
				// item.put("isDefault", bankCardDO.getIsDefault());
				item.put("name", bankCardDO.getName());
				item.put("mobile", bankCardDO.getMobile());
				item.put("status", bankCardDO.getStatus());
				item.put("updated", bankCardDO.getUpdated());
				item.put("entityName", bankCardDO.getEntityName());
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
