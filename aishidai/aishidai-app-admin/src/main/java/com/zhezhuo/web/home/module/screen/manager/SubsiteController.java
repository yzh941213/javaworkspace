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
import com.zhezhuo.biz.manager.ShopManager;
import com.zhezhuo.biz.manager.SubsiteManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.entity.SubsiteDO;
import com.zhezhuo.model.query.SubsiteQuery;

@Controller
public class SubsiteController {

	private static final Logger logger = LoggerFactory.getLogger(SubsiteController.class);

	@Autowired
	private SubsiteManager subsiteManager;
	@Autowired
	private ShopManager shopManager;

	/**
	 * 店铺接受优惠券消费
	 * @param subId
	 * @param SYSUserId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/subsite/editSubsite" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String editSubsite(
			@RequestParam(value = "subNUM", required = true) String subNUM,
			@RequestParam(value = "SYSUserId", required = true) long SYSUserId,
			@RequestParam(value = "shopsId", required = false,defaultValue = "0") long shopsId) throws Exception {
		
			// 接口进入时，需要打印出传入的参数
			if (shopsId == 0) {
				if (logger.isInfoEnabled()) {
					logger.info("消费者在店铺使用优惠券，subNUM = {},SYSUserId = {}", subNUM,
							SYSUserId);
				}
			}else{
				if (logger.isInfoEnabled()) {
					logger.info("总部帮助店铺处理用户 消费的优惠券，subNUM = {},SYSUserId = {},shopsId={}", subNUM,
							SYSUserId,shopsId);
				}
			}
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("success", false);
			//先查优惠券是否存在
			SubsiteDO subsiteDO = subsiteManager.querySubsiteBysubNUM(subNUM.toUpperCase());
			if (subsiteDO != null) {
				if (shopsId == 0) {
					Result<ShopDO> resultShopDO = shopManager.queryShopDOBySysUserId(SYSUserId);
					ShopDO shopDO = resultShopDO.getResult();
					
					if (shopDO != null) {
						switch (subsiteDO.getStatus()) {
						case 0:
							// 修改数据的最后更新时间
							subsiteDO.setUpdated(String.valueOf(System.currentTimeMillis() / 1000L));
							
							// 修改优惠券的状态为已使用
							subsiteDO.setStatus(2);
							//将优惠券的ID传进去
							subsiteDO.setSubId(subsiteDO.getSubId());
							// 将商户的ID和优惠券进行绑定
							subsiteDO.setShopsId(shopDO.getShopsId());
							// 更新优惠券的状态
							Result<Integer> result = subsiteManager.editSubsite(subsiteDO);
							
							if (!result.isSuccess()) {
								jsonObject.put("message", "操作失败！");
								return jsonObject.toString();
							}
							
							jsonObject.put("message", "使用成功");
							jsonObject.put("success", true);
							// 业务完成时，需要打印改变的结果
							if (logger.isInfoEnabled()) {
								logger.info("优惠券使用完毕，subNUM = {},shopsId = {}",
										subNUM, shopDO.getShopsId());
							}
							break;
						case 1:
							jsonObject.put("message", "卡券已过期，已不可使用！");
							// 业务完成时，需要打印改变的结果
							if (logger.isInfoEnabled()) {
								logger.info("卡券已过期，已不可使用，subNUM = {}", subNUM);
							}
							
							break;
						case 2:
							jsonObject.put("message", "卡券已被使用，请仔细核对！");
							// 业务完成时，需要打印改变的结果
							if (logger.isInfoEnabled()) {
								logger.info("卡券已被使用，请仔细核对，subNUM = {}", subNUM);
							}
							break;
						}
					}else{
						
					}
					
					
				}else{
					Result<ShopDO> result = shopManager.queryShopDOById(shopsId);
					ShopDO shopDO = result.getResult();
					if (shopDO != null) {
						switch (subsiteDO.getStatus()) {
						case 0:
							// 修改数据的最后更新时间
							subsiteDO.setUpdated(String.valueOf(System.currentTimeMillis() / 1000L));
							// 修改优惠券的状态为已使用
							subsiteDO.setStatus(2);
							//将优惠券的ID传进去
							subsiteDO.setSubId(subsiteDO.getSubId());
							// 将商户的ID和优惠券进行绑定
							subsiteDO.setShopsId(shopDO.getShopsId());
							// 更新优惠券的状态
							Result<Integer> resultSubsite = subsiteManager.editSubsite(subsiteDO);
							
							if (!resultSubsite.isSuccess()) {
								jsonObject.put("message", "操作失败！");
								return jsonObject.toString();
							}
							
							jsonObject.put("message", "使用成功");
							jsonObject.put("success", true);
							// 业务完成时，需要打印改变的结果
							if (logger.isInfoEnabled()) {
								logger.info("优惠券使用完毕，subNUM = {},shopsId = {}",
										subNUM, shopDO.getShopsId());
							}
							break;
						case 1:
							jsonObject.put("message", "卡券已过期，已不可使用！");
							// 业务完成时，需要打印改变的结果
							if (logger.isInfoEnabled()) {
								logger.info("卡券已过期，已不可使用，subNUM = {}", subNUM);
							}
							
							break;
						case 2:
							jsonObject.put("message", "卡券已被使用，请仔细核对！");
							// 业务完成时，需要打印改变的结果
							if (logger.isInfoEnabled()) {
								logger.info("卡券已被使用，请仔细核对，subNUM = {}", subNUM);
							}
							break;
						}
					}
				}
			} else {
				// 优惠券不存在
				jsonObject.put("message", "优惠券不存在，请核实后重试！");
				// 业务完成时，需要打印改变的结果
				if (logger.isInfoEnabled()) {
					logger.info("优惠券不存在，请核实后重试！，SYSUserId = {}", SYSUserId);
				}
				return jsonObject.toString();
			}
			return jsonObject.toString();
	}
	
	
	/**
	 * 店铺查询，有多少优惠券在本店铺使用了
	 * @param SYSUserId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/subsite/querySubsiteList" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String querySubsiteList(
			@RequestParam(value = "SYSUserId", required = true) long SYSUserId,
			@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData) throws Exception{
		
			// 业务完成时，需要打印改变的结果
			if (logger.isInfoEnabled()) {

			}
			
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
			
			SubsiteQuery query = new SubsiteQuery();
			
			//设置起始页
			query.setStartRow(iDisplayStart);
			//设置每页的个数
			query.setPageSize(iDisplayLength);
			Result<ShopDO> resultShopDO = shopManager.queryShopDOBySysUserId(SYSUserId);
			ShopDO shopDO = resultShopDO.getResult();
			
			if (shopDO != null) {
				//设置店铺的ID
				query.setShopsId(shopDO.getShopsId());
				Result<List<SubsiteDO>> result = subsiteManager.querySubsiteByshopsIdList(query);
				List<SubsiteDO> list = subsiteManager.selectSubsiteByShopIds(shopDO.getShopsId());
				if (result == null || !result.isSuccess()) {
					if (logger.isInfoEnabled(
							)) {
						logger.info("查询在本店铺中消费的优惠券失败，SYSUserId={}",SYSUserId);
					}
					jsonObject.put("message", "没有数据");
					jsonObject.put("iTotalRecords", 0); //实际的行数
				    jsonObject.put("iTotalDisplayRecords", 0); //显示的行数
					return jsonObject.toString();
				}
				jsonObject.put("iTotalRecords", list.size()); //实际的行数
	            jsonObject.put("iTotalDisplayRecords", list.size()); //显示的行数
//	            jsonObject.put("data", JSONArray.toJSON(result.getResult()));
	            jsonObject.put("data", result.getResult());
	            jsonObject.put("success", true);
	            jsonObject.put("type", 1);
				jsonObject.put("message", "查询成功");
				
			} else if(SYSUserId == 14){
				List<SubsiteDO> list = subsiteManager.selectSubsiteList(query);
				List<SubsiteDO> count = subsiteManager.selectSubsiteByStatus(2);
				jsonObject.put("iTotalRecords", count.size()); //实际的行数
	            jsonObject.put("iTotalDisplayRecords",count.size()); //显示的行数
	            jsonObject.put("data", list);
	            jsonObject.put("success", true);
	            jsonObject.put("type", 0);
				jsonObject.put("message", "查询成功");
			}
			else {
				// 如果根据前端传过来的SYSUserId，得到的店铺信息数据为空，直接返回。
				jsonObject.put("data", JSONArray.toJSON(null));
				jsonObject.put("message", "您的店铺信息不正确,请稍后重试");
				if (logger.isInfoEnabled()) {
					logger.info("您的信息维护不完整，请联系管理员，SYSUserId = {}", SYSUserId);
				}
				return jsonObject.toString();
			}
		return jsonObject.toString();
	}
}
