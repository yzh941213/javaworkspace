package com.aishidai.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aishidai.app.model.pojo.ShopsDO;
import com.aishidai.app.model.pojo.SubsiteDO;
import com.aishidai.app.service.ShopService;
import com.aishidai.app.service.SubsiteService;
import com.aishidai.app.service.SysUsersService;
import com.alibaba.fastjson.JSONObject;

@RequestMapping(value="/manage/subsite")
@Controller
public class SubsiteController {

	private static final Logger logger = LoggerFactory.getLogger(SubsiteController.class);

	@Autowired
	private SubsiteService subsiteService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private SysUsersService sysUsersService;

	@RequestMapping(value = { "/editSubsite" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String editSubsite(
			@RequestParam(value = "subNum", required = true) String subNum,
			@RequestParam(value = "userId", required = true) long userId,
			@RequestParam(value = "shopsId", required = true) long shopsId) throws Exception {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		SubsiteDO subsiteDO = subsiteService.querySubsiteBysubNum(subNum
				.toUpperCase());

		if (subsiteDO != null) {
			if (sysUsersService.queryByPrimaryKey(userId) != null
					&& sysUsersService.queryByPrimaryKey(userId).getGroupId() == 0) {
				switch (subsiteDO.getStatus()) {
				case 0:
					subsiteDO.setUpdated(Integer.valueOf((System
							.currentTimeMillis() / 1000) + ""));
					subsiteDO.setStatus(2);
					subsiteDO.setSubId(subsiteDO.getSubId());
					subsiteDO.setShopsId(shopsId);
					if (!subsiteService.editSubsite(subsiteDO)) {
						jsonObject.put("message", "操作失败！");
						return jsonObject.toString();
					}
					jsonObject.put("message", "使用成功");
					jsonObject.put("success", true);
					break;
				case 1:
					jsonObject.put("message", "卡券已过期，已不可使用！");
					break;
				case 2:
					jsonObject.put("message", "卡券已被使用，请仔细核对！");
					break;
				}

			} else if (sysUsersService.queryByPrimaryKey(userId) != null
					&& sysUsersService.queryByPrimaryKey(userId).getGroupId() == 1) {

			} else if (sysUsersService.queryByPrimaryKey(userId) != null
					&& sysUsersService.queryByPrimaryKey(userId).getGroupId() == 2) {
				List<ShopsDO> shopsDO_lsit = shopService
						.queryShopsDOByUserId(userId);

				if (shopsDO_lsit.isEmpty() && shopsDO_lsit.size() <= 0) {
					jsonObject.put("message", "操作失败,店铺信息不正确");
					return jsonObject.toString();
				}
				switch (subsiteDO.getStatus()) {
				case 0:
					subsiteDO.setUpdated(Integer.valueOf((System
							.currentTimeMillis() / 1000) + ""));
					subsiteDO.setStatus(2);
					subsiteDO.setSubId(subsiteDO.getSubId());
					subsiteDO.setShopsId(shopsDO_lsit.get(0).getShopsId());
					if (!subsiteService.editSubsite(subsiteDO)) {
						jsonObject.put("message", "操作失败！");
						return jsonObject.toString();
					}
					jsonObject.put("message", "使用成功");
					jsonObject.put("success", true);
					break;
				case 1:
					jsonObject.put("message", "卡券已过期，已不可使用！");
					break;
				case 2:
					jsonObject.put("message", "卡券已被使用，请仔细核对！");
					break;
				}
			}
		}else{
			jsonObject.put("message", "卡券不存在，请仔细核对");
		}
		return jsonObject.toString();
	}
}
