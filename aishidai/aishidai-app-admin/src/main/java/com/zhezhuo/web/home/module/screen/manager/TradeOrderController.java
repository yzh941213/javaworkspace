package com.zhezhuo.web.home.module.screen.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.zhezhuo.biz.manager.DistributorManager;
import com.zhezhuo.biz.manager.MakerManager;
import com.zhezhuo.biz.manager.ShopManager;
import com.zhezhuo.biz.manager.TradeOrderManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.TradeOrderDetailDTO;
import com.zhezhuo.model.domain.TradeOrderListDTO;
import com.zhezhuo.model.domain.TradeOrderReadonlyDTO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.entity.SysUsersDO;
import com.zhezhuo.model.entity.TradeOrderDO;
import com.zhezhuo.model.query.TradeOrderQuery;
import com.zhezhuo.web.home.common.LoginConstant;

@Controller
@RequestMapping("/manager/order")
public class TradeOrderController {

	private static final Logger log = LoggerFactory.getLogger(TradeOrderController.class);

	@Autowired
	private TradeOrderManager tradeOrderManager;
	@Autowired
	private DistributorManager distributorManager;
	@Autowired
	private MakerManager makerManager;
	@Autowired
	private ShopManager shopManager;

	@RequestMapping("/list.do")
	@ResponseBody
	public String queryTradeOrders(
			@RequestParam(value = "status", required = false, defaultValue = "-1") int status,
			@RequestParam(value = "statusEx", required = false, defaultValue = "-1") int statusEX,
			@RequestParam(value = "reverseStatus", required = false, defaultValue = "-1") int reverseStatus,
			@RequestParam(value = "orderNum", required = false, defaultValue = "0") String orderNum,
			@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,
			@RequestParam(value = "sort", defaultValue = "orderId", required = false) String sort,
			@RequestParam(value = "order", defaultValue = "desc", required = false) String order,
			@RequestParam(value = "sellerUserId", defaultValue = "", required = false) String search,
			@RequestParam(value = "userId", defaultValue = "-1", required = false) long userId) {

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

		TradeOrderQuery query = new TradeOrderQuery();
		query.setStatuss(status);
		query.setStatusEx(statusEX);
		query.setReverseStatus(reverseStatus);
		// query.setOrderId(orderNum);
		query.setOrderNum(orderNum);
		query.setSortField(sort);
		query.setOrder(order);
		query.setStartRow(iDisplayStart);
		query.setPageSize(iDisplayLength);
		query.setSearch(search);

		Result<List<TradeOrderListDTO>> result = tradeOrderManager
				.queryTraderOrderList(query, userId);
		System.out.println("result===================" + result);
		if (result != null && result.isSuccess()) {
			jsonObject.put("success", true);
			jsonObject.put("aaData", result.getResult());
			jsonObject.put("iTotalRecords", query.getTotalItem()); // 实际的行数
			jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); // 显示的行数,这个要和上面
			jsonObject.put("message", "query success");
			return jsonObject.toString();
		}
		jsonObject.put("iTotalRecords", query.getTotalItem()); // 实际的行数
		jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); // 显示的行数,这个要和上面
		jsonObject.put("message", "出现错误，请稍后重试！");
		return jsonObject.toString();
	}

	@RequestMapping("/query.do")
	@ResponseBody
	public String queryTradeOrdersReadonly(
			@RequestParam(value = "status", required = false, defaultValue = "-1") int status,
			@RequestParam(value = "orderNum", required = false, defaultValue = "0") String orderNum,
			@RequestParam(value = "distributorId", required = false) Long distributorId,
			@RequestParam(value = "makerId", required = false) Long makerId,
			@RequestParam(value = "shopId", required = false) Long shopId,
			@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,
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

		TradeOrderQuery query = new TradeOrderQuery();
		query.setStatuss(status);
		// query.setStatusEx(statusEX);
		// query.setReverseStatus(reverseStatus);
		query.setOrderNum(orderNum);
		// query.setSortField(sort);
		// query.setOrder(order);
		query.setStartRow(iDisplayStart);
		query.setPageSize(iDisplayLength);
		// query.setSearch(search);
		SysUsersDO sysUsersDO = (SysUsersDO) request.getSession().getAttribute(
				LoginConstant.USER_SESSION_KEY);
		if (distributorId == null) {
			if (sysUsersDO.getGroupId() == 1) {
				DistributorDO distributorDO = (DistributorDO) request
						.getSession().getAttribute(
								LoginConstant.USER_DISTRIBUTOR_SESSION_KEY);
				distributorId = distributorDO.getId();
			}
		}
		if (makerId == null) {
			if (sysUsersDO.getGroupId() == 3) {
				MakerDO makerDO = (MakerDO) request.getSession().getAttribute(
						LoginConstant.USER_MAKER_SESSION_KEY);
				makerId = makerDO.getId();
			}
		}
		if (shopId == null) {
			if (sysUsersDO.getGroupId() == 2) {
				ShopDO shopDO = (ShopDO) request.getSession().getAttribute(
						LoginConstant.USER_SHOP_SESSION_KEY);
				shopId = shopDO.getShopsId();
			}
		}
		query.setDistributorId(distributorId);
		query.setMakerId(makerId);
		query.setShopId(shopId);

		Result<List<TradeOrderReadonlyDTO>> result = tradeOrderManager
				.queryTraderOrderReadonly(query);
		List<TradeOrderReadonlyDTO> list = result.getResult();
		for (int i = 0; i < list.size(); i++) {
			TradeOrderReadonlyDTO dto = list.get(i);
			if (dto.getDistributorId() != null) {
				Result<DistributorDO> r = distributorManager
						.queryDistributorDOById(dto.getDistributorId());
				if (r != null && r.getResult() != null)
					dto.setDistributorIdName(r.getResult().getName());
			}

			if (dto.getMakerId() != null) {
				Result<MakerDO> r = makerManager.queryMakerDOById(dto
						.getMakerId());
				if (r != null && r.getResult() != null)
					dto.setMakerIdName(r.getResult().getName());
			}
			if (dto.getShopId() != null) {
				Result<ShopDO> r;
				try {
					r = shopManager.queryShopDOById(dto.getShopId());
					if (r != null && r.getResult() != null) {
						dto.setShopIdName(r.getResult().getShopsName());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

		Result<TradeOrderReadonlyDTO> result1 = tradeOrderManager
				.queryTradeOrderStat(query);
		if (result != null && result.isSuccess()) {
			jsonObject.put("success", true);
			jsonObject.put("aaData", result.getResult());
			jsonObject.put("iTotalRecords", query.getTotalItem()); // 实际的行数
			jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); // 显示的行数,这个要和上面
			jsonObject.put("message", "query success");
			jsonObject.put("stat", result1.getResult());
			return jsonObject.toString();
		}
		jsonObject.put("iTotalRecords", query.getTotalItem()); // 实际的行数
		jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); // 显示的行数,这个要和上面
		jsonObject.put("message", "出现错误，请稍后重试！");
		return jsonObject.toString();
	}

	@RequestMapping("/detail.do")
	@ResponseBody
	public String queryTradeOrders(@RequestParam(value = "orderId") long orderId) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		Result<TradeOrderDetailDTO> result = tradeOrderManager
				.queryTradeOrderDO(orderId);
		if (result != null && result.isSuccess()) {
			jsonObject.put("success", true);
			jsonObject.put("data", result.getResult());
			jsonObject.put("message", "query success");
			return jsonObject.toString();
		}
		jsonObject.put("data", "");
		jsonObject.put("message", "出现错误，请稍后重试！");
		return jsonObject.toString();
	}

	/**
	 * 修改订单状态的接口
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/editStatus.do","/send.do","/cancel.do"}, method = { RequestMethod.GET,RequestMethod.POST })
	@ResponseBody
	public String updateOrderStatus(
			@RequestParam(value = "status", required = true) int status,
			@RequestParam(value = "orderId", required = true) long orderId,
			@RequestParam(value = "sysUserId", required = true) long sysUserId,
			@RequestParam(value = "trackingNum", required = false) String trackingNum,
			@RequestParam(value = "expressCompany", required = false) String expressCompany,
			@RequestParam(value = "cancelReason", required = false) String cancelReason) {

		if (log.isDebugEnabled()) {
			log.info("修改订单状态,orderId={},sysUserId={},status={}", orderId,
					sysUserId, status);
		}
		// 订单状态:0代付款1代发货2待收货3待评价4交易成功5交易关闭6取消交易7删除交易

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		TradeOrderDO tradeOrderDO = tradeOrderManager
				.queryOrderDOByOrderId(orderId);

		if (tradeOrderDO == null) {
			jsonObject.put("message", "修改失败");
		} else {
			// 如果传过来的状态为6的话，就代表要取消订单
			if (status == 6) {
				// 订单只有在未付款的状态下，才能取消订单
				if (tradeOrderDO.getStatus() == 0) {
					tradeOrderDO.setOrderId(orderId);
					tradeOrderDO.setStatus(status);
					tradeOrderDO.setUpdated(System.currentTimeMillis() / 1000);
					tradeOrderDO.setCancelTime(System.currentTimeMillis() / 1000);
					tradeOrderDO.setCancelReason(cancelReason);//取消订单的原因
					int result = tradeOrderManager
							.editOrderDOCancel(tradeOrderDO);
					if (result <= 0) {
						jsonObject.put("message", "修改失败");
						return jsonObject.toString();
					}
					jsonObject.put("message", "修改成功");

					if (log.isDebugEnabled()) {
						log.info("取消未付款订单,orderId={},sysUserId={},status={}",
								orderId, sysUserId, tradeOrderDO.getStatus());
					}

				} else {
					jsonObject.put("message", "修改失败");
				}
				//下面为发货
			} else if (status == 2) {

				tradeOrderDO.setOrderId(orderId);
				tradeOrderDO.setStatus(status);
				tradeOrderDO.setTrackingNum(trackingNum);
				tradeOrderDO.setExpressCompany(expressCompany);
				tradeOrderDO.setUpdated(System.currentTimeMillis() / 1000);
				int result = tradeOrderManager.editOrderStatus(tradeOrderDO);
				if (result <= 0) {
					jsonObject.put("message", "修改失败");
					return jsonObject.toString();
				}
				jsonObject.put("message", "修改成功");

				if (log.isDebugEnabled()) {
					log.info("订单发货,orderId={},sysUserId={},status={}", orderId,
							sysUserId, tradeOrderDO.getStatus());
				}
			} else {
				tradeOrderDO.setOrderId(orderId);
				tradeOrderDO.setStatus(status);
				int result = tradeOrderManager.editOrderStatus(tradeOrderDO);
				tradeOrderDO.setUpdated(System.currentTimeMillis() / 1000);
				if (result <= 0) {
					jsonObject.put("message", "修改失败");
					return jsonObject.toString();
				}
				jsonObject.put("message", "修改成功");

				if (log.isDebugEnabled()) {
					log.info("修改状态,orderId={},sysUserId={},status={}", orderId,
							sysUserId, tradeOrderDO.getStatus());
				}
			}

		}
		jsonObject.put("success", true);
		return jsonObject.toString();
	}
}
