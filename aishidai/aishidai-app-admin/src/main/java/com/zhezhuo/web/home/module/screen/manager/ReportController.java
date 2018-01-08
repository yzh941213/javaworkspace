package com.zhezhuo.web.home.module.screen.manager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.ReportManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.ReportDTO;
import com.zhezhuo.model.entity.CraftsmenDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.entity.SysUsersDO;
import com.zhezhuo.web.home.common.LoginConstant;

/**
 * 报表 aborted
 * 
 * @author adrian
 *
 */
@Controller
@RequestMapping("/manager/report")
public class ReportController {

	@Autowired
	ReportManager reportManager;

	@RequestMapping("/detail.do")
	@ResponseBody
	public String queryReportDetail(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		SysUsersDO userDO = (SysUsersDO) request.getSession().getAttribute(LoginConstant.USER_SESSION_KEY);
		Result<ReportDTO> result = null;
		if (userDO.getGroupId() == 0) {
			result = reportManager.querySysReport();
		} else if (userDO.getGroupId() == 1) {
			DistributorDO distributorDO = (DistributorDO) request.getSession()
					.getAttribute(LoginConstant.USER_DISTRIBUTOR_SESSION_KEY);
			result = reportManager.queryDistributorReport(distributorDO.getId());
		} else if (userDO.getGroupId() == 2) {
			ShopDO shopDO = (ShopDO) request.getSession().getAttribute(LoginConstant.USER_SHOP_SESSION_KEY);
			result = reportManager.queryShopReport(shopDO);
		} else if (userDO.getGroupId() == 3) {
			MakerDO makerDO = (MakerDO) request.getSession().getAttribute(LoginConstant.USER_MAKER_SESSION_KEY);
			result = reportManager.queryMakerReport(makerDO.getId());
		} else if (userDO.getGroupId() == 4) {
			CraftsmenDO craftsmenDO = (CraftsmenDO) request.getSession()
					.getAttribute(LoginConstant.USER_CRAFTSMEN_SESSION_KEY);
			result = reportManager.queryCraftsmenReport(craftsmenDO.getId());
		}
		if (result == null || !result.isSuccess()) {
			jsonObject.put("message", "查询失败");
			return jsonObject.toString();
		}

		jsonObject.put("success", true);
		jsonObject.put("message", "成功");
		jsonObject.put("data", JSONObject.toJSON(result.getResult()));
		return jsonObject.toString();
	}

}
