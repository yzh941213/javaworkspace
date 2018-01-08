package com.zhezhuo.web.home.module.screen.manager;

import java.math.BigDecimal;
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
import com.zhezhuo.biz.manager.PercentageManager;
import com.zhezhuo.biz.manager.ShopManager;
import com.zhezhuo.biz.manager.TCashManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.TCashDTO;
import com.zhezhuo.model.entity.BankCardDO;
import com.zhezhuo.model.entity.CraftsmenDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.entity.PercentageDO;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.entity.SysUsersDO;
import com.zhezhuo.model.entity.TCashDO;
import com.zhezhuo.model.query.TCashQuery;
import com.zhezhuo.web.home.common.LoginConstant;

/**
 * Created by 蝈蝈 on 2016/9/26.
 */
@Controller
@RequestMapping("/manager/tcash")
public class TCashController {

	@Autowired
	TCashManager tCashManager;
	@Autowired
	BankCardManager bankCardManager;
	@Autowired
	PercentageManager percentageManager;
	@Autowired
	DistributorManager distributorManager;
	@Autowired
	MakerManager makerManager;
	@Autowired
	ShopManager shopManager;
	@Autowired
	CraftsmenManager craftsmenManager;

	@RequestMapping(value = { "/status.do", "/del.do", "/doCash.do" })
	@ResponseBody
	public String updateTCashStatus(@RequestParam(value = "caId") long caId,
			@RequestParam(value = "status", defaultValue = "-1") int status,
			@RequestParam(value = "isDeleted", defaultValue = "0") int isDeleted) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		TCashDO tCashDO = new TCashDO();
		tCashDO.setCaId(caId);
		tCashDO.setUpdated(String.valueOf(System.currentTimeMillis() / 1000));
		tCashDO.setStatus(status);
		tCashDO.setIsDeleted(isDeleted);
		Result<TCashDO> r = tCashManager.queryTcashDOById(caId);
		tCashDO.setUserId(r.getResult().getUserId());
		tCashDO.setCash(r.getResult().getCash());
		Result<Integer> result = null;
		try {
			result = tCashManager.updateTCashStatus(tCashDO);
		} catch (Exception e) {
			jsonObject.put("data", -1);
			jsonObject.put("message", "update failed");
			return jsonObject.toString();
		}
		if (result != null && result.isSuccess()) {
			jsonObject.put("data", result.getResult());
			jsonObject.put("message", "update success");
			jsonObject.put("success", true);
			return jsonObject.toString();
		}
		jsonObject.put("data", -1);
		jsonObject.put("message", "update failed");
		return jsonObject.toString();
	}

	@RequestMapping("/list.do")
	@ResponseBody
	public String queryTCashList(@RequestParam(value = "status", defaultValue = "0", required = false) int status,
			@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,
			HttpServletRequest request) {

		JSONArray jsonarray = JSONArray.parseArray(aoData);
		String sEcho = null;
		int iDisplayStart = 0; // 起始索引
		int iDisplayLength = 0; // 每页显示的行数
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

		TCashQuery query = new TCashQuery();
		query.getStatus().add(0);
		query.setStartRow(iDisplayStart);
		query.setPageSize(iDisplayLength);
		SysUsersDO user = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		if (user.getGroupId() > 0) {
			query.setUserId(user.getUserId());
		}
		Result<List<TCashDTO>> result = tCashManager.queryTCashList(query);
		if (result != null && result.isSuccess()) {
			jsonObject.put("iTotalRecords", query.getTotalItem()); // 实际的行数
			jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); // 显示的行数,这个要和上面
			jsonObject.put("aaData", result.getResult());
			jsonObject.put("success", true);
			jsonObject.put("message", "update success");
			jsonObject.put("success", true);
			return jsonObject.toString();
		}
		jsonObject.put("data", -1);
		jsonObject.put("message", "update failed");
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
	public String queryTcashs(@RequestParam(value = "caId") long caId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		Result<TCashDO> result = tCashManager.queryTcashDOById(caId);
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
	public String editTCashDO(@RequestParam(value = "caId", required = false) Long caId,
			@RequestParam(value = "cardId", required = false) Long cardId,
			// @RequestParam(value = "bankName", defaultValue = "", required =
			// false) String bankName,
			// @RequestParam(value = "branches", defaultValue = "", required =
			// false) String branches,
			// @RequestParam(value = "cardNum", defaultValue = "", required =
			// false) String cardNum,
			@RequestParam(value = "cash", defaultValue = "", required = false) String cash,
			// @RequestParam(value = "name", defaultValue = "", required =
			// false) String name,
			// @RequestParam(value = "trueName", defaultValue = "0", required =
			// false) String trueName,
			// @RequestParam(value = "uname", defaultValue = "", required =
			// false) String uname,
			@RequestParam(value = "status", defaultValue = "0", required = false) Integer status,
			HttpServletRequest request) {// ,HttpServletRequest
		// request

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		SysUsersDO user = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		BigDecimal balance = new BigDecimal(0);
		if (user.getGroupId() == 0) {
			Result<PercentageDO> r = percentageManager.queryPercentageDOById(1);// TODO
																				// 写死了
			balance = r.getResult().getBalance();
		} else if (user.getGroupId() == 1) {
			Result<DistributorDO> r = distributorManager.queryDistributorDOBySysUserId(user.getUserId());
			balance = r.getResult().getBalance();
		} else if (user.getGroupId() == 2) {
			Result<ShopDO> r;
			try {
				r = shopManager.queryShopDOBySysUserId(user.getUserId());
				balance = r.getResult().getBalance();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (user.getGroupId() == 3) {
			Result<MakerDO> r = makerManager.queryMakerDOBySysUserId(user.getUserId());
			balance = r.getResult().getBalance();
		} else if (user.getGroupId() == 4) {
			Result<CraftsmenDO> r = craftsmenManager.queryCraftsmenDOBySysUserId(user.getUserId());
			balance = r.getResult().getBalance();
		}
		if (new BigDecimal(cash).compareTo(balance) == 1) {
			jsonObject.put("message", "超出可提现金额");
			return jsonObject.toString();
		}
		Result<BankCardDO> r = bankCardManager.queryBankCardDOById(cardId);
		BankCardDO bankCardDO = r.getResult();
		TCashDO tCashDO = new TCashDO();
		tCashDO.setCaId(caId);
		tCashDO.setBankName(bankCardDO.getBankName());
		tCashDO.setBranches(bankCardDO.getBranches());
		tCashDO.setCardNum(bankCardDO.getCardNum());
		tCashDO.setCash(cash);
		tCashDO.setName(bankCardDO.getName());
		tCashDO.setUname(bankCardDO.getMobile());
		tCashDO.setTrueName(bankCardDO.getName());
		tCashDO.setStatus(status);
		// SysUsersDO user =
		// (SysUsersDO)request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		// if(user.getGroupId()>0){
		tCashDO.setUserId(bankCardDO.getUserId());
		tCashDO.setCashEx(String.valueOf(cardId));
		// }
		Result<Long> result = tCashManager.editTCashDO(tCashDO);
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "数据操作失败");
			return jsonObject.toString();
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "数据更新成功");
		return jsonObject.toString();
	}

	@RequestMapping("/balance.do")
	@ResponseBody
	public String queryTcashBalance(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		SysUsersDO user = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		if (user.getGroupId() == 0) {
			Result<PercentageDO> r = percentageManager.queryPercentageDOById(1);// TODO
																				// 写死了
			jsonObject.put("data", JSONObject.toJSON(r.getResult().getBalance()));
		} else if (user.getGroupId() == 1) {
			Result<DistributorDO> r = distributorManager.queryDistributorDOBySysUserId(user.getUserId());
			jsonObject.put("data", JSONObject.toJSON(r.getResult().getBalance()));
		} else if (user.getGroupId() == 2) {
			Result<ShopDO> r;
			try {
				r = shopManager.queryShopDOBySysUserId(user.getUserId());
				jsonObject.put("data", JSONObject.toJSON(r.getResult().getBalance()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} else if (user.getGroupId() == 3) {
			Result<MakerDO> r = makerManager.queryMakerDOBySysUserId(user.getUserId());
			jsonObject.put("data", JSONObject.toJSON(r.getResult().getBalance()));
		} else if (user.getGroupId() == 4) {
			Result<CraftsmenDO> r = craftsmenManager.queryCraftsmenDOBySysUserId(user.getUserId());
			jsonObject.put("data", JSONObject.toJSON(r.getResult().getBalance()));
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "成功");
		return jsonObject.toString();
	}

}
