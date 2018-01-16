package com.aishidai.app.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aishidai.app.model.pojo.CommissionMoneyDO;
import com.aishidai.app.model.pojo.DeviceDO;
import com.aishidai.app.model.pojo.DeviceMakerDO;
import com.aishidai.app.model.pojo.ItemDO;
import com.aishidai.app.model.pojo.ItemsDetail;
import com.aishidai.app.model.pojo.MakerDO;
import com.aishidai.app.model.pojo.MemberDO;
import com.aishidai.app.model.pojo.ShopsDO;
import com.aishidai.app.model.pojo.StatementHqDO;
import com.aishidai.app.model.pojo.StatementHqDetailDO;
import com.aishidai.app.model.pojo.TradeOrderDO;
import com.aishidai.app.model.pojo.TradeOrderItemDO;
import com.aishidai.app.model.pojo.UsersDO;
import com.aishidai.app.service.DeviceMakerServiec;
import com.aishidai.app.service.DeviceService;
import com.aishidai.app.service.DistributorService;
import com.aishidai.app.service.ItemService;
import com.aishidai.app.service.MakerService;
import com.aishidai.app.service.OrderService;
import com.aishidai.app.service.ShopService;
import com.aishidai.app.service.UsersService;
import com.alibaba.fastjson.JSONObject;

@RequestMapping(value = "/manage/statemen")
@RestController
public class StatementMakerController {

	private static final Logger logger = LoggerFactory
			.getLogger(StatementMakerController.class);
	// 报表的计算类
	@Autowired
	private UsersService usersService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private DistributorService distributorService;
	@Autowired
	private MakerService makerService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private DeviceMakerServiec deviceMakerServiec;

	/**
	 * 查看的总报表
	 */
	@RequestMapping(value = { "/maker/showStatemen" })
	public String showStatemenList(
			@RequestParam(value = "userId", required = true) long userId,
			@RequestParam(value = "beginDate", required = false, defaultValue = "") String beginDate,
			@RequestParam(value = "endDate", required = false, defaultValue = "") String endDate)
			throws Exception {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		// 先判断登录的用户是否是创客，如果不是就返回
		List<MakerDO> maker_list = makerService.queryMakerDOByUserId(userId);

		if (maker_list.isEmpty() && maker_list.size() <= 0) {
			jsonObject.put("message", "身份不对，请切换账号重试");
			return jsonObject.toString();
		}
		MakerDO makerDO = maker_list.get(0);

		// 获取注册用户总数
		List<UsersDO> list_users_all = usersService.queryAll();
		// 获取和本创客关联的用户数
		List<UsersDO> list_users_maker = new ArrayList<UsersDO>();
		// 将用户的信息，和创客关联起来

		List<DeviceMakerDO> maker_device_list = deviceMakerServiec
				.selectByMakerId(makerDO.getId());

		for (int i = 0; i < list_users_all.size(); i++) {
			for (int j = 0; j < maker_device_list.size(); j++) {
				DeviceDO device = deviceService
						.queryDeviceDOById(maker_device_list.get(j)
								.getDeviceId());
				if (device != null) {
					if (list_users_all.get(i).getRegisterIp()
							.equals(device.getProductNo())) {
						list_users_maker.add(list_users_all.get(i));
					}
				}
			}
		}
		jsonObject.put("users_count_maker", list_users_maker.size());

		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 向前推24小时新增用户数量
		int users_register_24H_count = 0;

		// 通过日期类，将日期时间向前推一天
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		calendar.add(calendar.DATE, -1);
		// 现在的时间就是向前推一天的时间
		String date_time = dateFormat.format(calendar.getTime());

		for (int i = 0; i < list_users_maker.size(); i++) {
			if (date_time.equals(dateFormat.format(list_users_maker.get(i)
					.getRegisterTime()))) {
				users_register_24H_count++;
			}
		}

		jsonObject.put("users_register_24H_count", users_register_24H_count);

		List<TradeOrderDO> order_list_maker = new ArrayList<TradeOrderDO>();
		// 将创客的设备和相应的店铺关联起来
		List<ShopsDO> list_shop = new ArrayList<ShopsDO>();

		for (int i = 0; i < maker_device_list.size(); i++) {
			DeviceDO device = deviceService.queryDeviceDOById(maker_device_list
					.get(i).getDeviceId());
			if (device != null) {
				ShopsDO do1 = shopService
						.queryShopsDOByDeviceId(device.getId());
				list_shop.add(do1);
			}
		}

		// 商品消费总额
		double money_total_item_maker = 0.0;
		List<TradeOrderDO> order_list = orderService.queryItems();

		for (int i = 0; i < order_list.size(); i++) {
			for (int j = 0; j < list_shop.size(); j++) {
				if (order_list.get(i).getSellerUserId().longValue() == list_shop
						.get(j).getShopsId().longValue()) {
					order_list_maker.add(order_list.get(i));
					money_total_item_maker += Double.parseDouble(order_list
							.get(i).getTotalPrice());
				}
			}
		}

		jsonObject.put("money_total_item_maker", money_total_item_maker);

		// 服务消费总额
		double money_total_service_maker = 0.0;
		List<TradeOrderDO> service_list = orderService.queryService();

		List<TradeOrderDO> service_list_maker = new ArrayList<TradeOrderDO>();

		for (int i = 0; i < service_list.size(); i++) {
			for (int j = 0; j < list_shop.size(); j++) {
				if (service_list.get(i).getSellerUserId().longValue() == list_shop
						.get(j).getShopsId().longValue()) {
					service_list_maker.add(service_list.get(i));
					money_total_service_maker += Double
							.parseDouble(service_list.get(i).getTotalPrice());
				}
			}
		}

		jsonObject.put("money_total_service_maker", money_total_service_maker);
		// 平台交易额
		double money_total_maker = 0.0;
		money_total_maker = money_total_service_maker + money_total_item_maker;
		jsonObject.put("money_total_maker", money_total_maker);

		// 付费人员总人数
		int member_count_maker = 0;
		List<MemberDO> member_List = usersService.queryMemberAll();
		for (int i = 0; i < member_List.size(); i++) {
			for (int j = 0; j < list_users_maker.size(); j++) {
				if (member_List.get(i).getUserId() == list_users_maker.get(j)
						.getUserId()) {
					if (member_List.get(i).getMemberType() == 0) {
						member_count_maker++;
					}
				}
			}
		}
		jsonObject.put("member_count_maker", member_count_maker);

		List<StatementHqDO> list_detail = new ArrayList<StatementHqDO>();

		// 查询的列表数据
		// 先查询出全部的注册用户,上面已经完成，
		// 下面遍历全部用户 result_users
		if (beginDate.equals("") || beginDate == null || endDate.equals("")
				|| endDate == null) {
			// 代表正常查询,不进行筛选
			for (int i = 0; i < list_users_all.size(); i++) {
				StatementHqDO shdo = new StatementHqDO();
				// 1、设置用户ID
				shdo.setUserId(list_users_all.get(i).getUserId());
				// 2、设置用户名
				if (list_users_all.get(i).getUnick() != null
						|| !"".equals(list_users_all.get(i).getUnick())) {
					shdo.setMemberName(list_users_all.get(i).getUnick());
				} else {
					shdo.setMemberName("未设置");
				}
				// 3、设置注册时间
				if (list_users_all.get(i).getRegisterTime() != null) {
					SimpleDateFormat dft = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					shdo.setRegistertime(dft.format(list_users_all.get(i)
							.getRegisterTime()));
				} else {
					shdo.setRegistertime(null);
				}
				// 4、设置手机号
				if (list_users_all.get(i).getPhone() != null
						&& !"".equals(list_users_all.get(i).getPhone())) {
					shdo.setUsername(list_users_all
							.get(i)
							.getPhone()
							.replace(
									list_users_all.get(i).getPhone()
											.substring(4, 8), "****"));
				} else {
					shdo.setUsername("未填写");
				}
				// 5、设置注册设备号
				shdo.setDeviceNum(list_users_all.get(i).getRegisterIp());

				// 7、设置用户的会员状态
				if (list_users_all.get(i).getMember() == 0) {
					shdo.setMemberType("不是会员");
				} else {
					MemberDO memberDO = usersService
							.queryMemberDOByUserId(list_users_all.get(i)
									.getUserId());
					if (memberDO != null) {
						if (memberDO.getMemberType() == 0) {
							shdo.setMemberType("是");
						} else {
							shdo.setMemberType("否");
						}
					} else {
						shdo.setMemberType("否");
					}
				}

				DeviceDO device = deviceService
						.queryDeviceDOByProductNo(list_users_all.get(i)
								.getRegisterIp());
				if (device != null) {
					// 6.1 设置注册店铺 通过设备号查询到相关联的店铺
					ShopsDO shopsdo = shopService.queryShopsDOByDeviceId(device
							.getId());
					// 6、2设置店铺名臣
					if (shopsdo != null) {
						if (shopsdo.getShopsName() != null
								&& !"".equals(shopsdo.getShopsName())) {
							shdo.setRegisterShopName(shopsdo.getShopsName());
						} else {
							shdo.setRegisterShopName("无数据");
						}

					} else {
						shdo.setRegisterShopName("无数据");
					}
				} else {
					shdo.setRegisterShopName("无数据");
				}

				// 8、设置用户的商品消费总额
				double user_money_item = 0.0;

				// 将用户的订单和创客关联上

				for (int j = 0; j < order_list_maker.size(); j++) {
					if (order_list_maker.get(j).getBuyerUserId().longValue() == list_users_all
							.get(i).getUserId()) {
						user_money_item += Double.parseDouble(order_list_maker
								.get(j).getTotalPrice());
					}
				}

				shdo.setItemMoney(user_money_item);
				// 9、设置用户的服务消费额
				// 9.1、先通过用户的ID查询出来，用户所有的服务订单
				double user_money_services = 0.0;

				for (int k = 0; k < service_list_maker.size(); k++) {

					if (service_list_maker.get(k).getBuyerUserId().longValue() == list_users_all
							.get(i).getUserId()) {
						user_money_services += Double
								.parseDouble(service_list_maker.get(k)
										.getTotalPrice());
					}
				}

				shdo.setServiceMoney(user_money_services);
				// 设置用户总的消费额度
				shdo.setTotalMoney(user_money_services + user_money_item);

				if ((user_money_services + user_money_item) == 0) {
					for (int j = 0; j < list_users_maker.size(); j++) {
						if (list_users_maker.get(j).getUserId() == list_users_all
								.get(i).getUserId()) {
							shdo.setServiceMoney(0.0);
							shdo.setItemMoney(0.0);
							shdo.setTotalMoney(0.0);
							list_detail.add(shdo);
						}
					}

				} else {
					list_detail.add(shdo);
				}
			}
			double sorl_total_money = 0.0;

			for (int j = 0; j < list_detail.size(); j++) {
				sorl_total_money += list_detail.get(j).getTotalMoney();
			}
			jsonObject.put("sorl_total_money", sorl_total_money);
			jsonObject.put("list_detail", JSONObject.toJSON(list_detail));
			jsonObject.put("message", "查询成功");
			jsonObject.put("success", true);

		} else {
			Date date_beginDate = dateFormat.parse(beginDate);
			long long_beginDate = date_beginDate.getTime();
			Date date_endDate = dateFormat.parse(endDate);
			long long_endDate = date_endDate.getTime();

			for (int i = 0; i < list_users_all.size(); i++) {
				// 将用户的注册时间转化为date类型
				Date date_registertime = list_users_all.get(i)
						.getRegisterTime();
				long long_registertime = date_registertime.getTime();
				if (long_registertime >= long_beginDate
						&& long_registertime <= long_endDate) {
					StatementHqDO shdo = new StatementHqDO();
					// 1、设置用户ID
					shdo.setUserId(list_users_all.get(i).getUserId());
					// 2、设置用户名
					if (list_users_all.get(i).getUnick() != null
							|| !"".equals(list_users_all.get(i).getUnick())) {
						shdo.setMemberName(list_users_all.get(i).getUnick());
					} else {
						shdo.setMemberName("未设置");
					}
					// 3、设置注册时间
					if (list_users_all.get(i).getRegisterTime() != null) {
						SimpleDateFormat dft = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						shdo.setRegistertime(dft.format(list_users_all.get(i)
								.getRegisterTime()));
					} else {
						shdo.setRegistertime(null);
					}
					// 4、设置手机号
					if (list_users_all.get(i).getPhone() != null
							&& !"".equals(list_users_all.get(i).getPhone())) {
						shdo.setUsername(list_users_all
								.get(i)
								.getPhone()
								.replace(
										list_users_all.get(i).getPhone()
												.substring(4, 8), "****"));
					} else {
						shdo.setUsername("未填写");
					}
					// 5、设置注册设备号
					shdo.setDeviceNum(list_users_all.get(i).getRegisterIp());

					// 7、设置用户的会员状态
					if (list_users_all.get(i).getMember() == 0) {
						shdo.setMemberType("不是会员");
					} else {
						MemberDO memberDO = usersService
								.queryMemberDOByUserId(list_users_all.get(i)
										.getUserId());
						if (memberDO != null) {
							if (memberDO.getMemberType() == 0) {
								shdo.setMemberType("是");
							} else {
								shdo.setMemberType("否");
							}
						} else {
							shdo.setMemberType("否");
						}
					}

					DeviceDO device = deviceService
							.queryDeviceDOByProductNo(list_users_all.get(i)
									.getRegisterIp());
					if (device != null) {
						// 6.1 设置注册店铺 通过设备号查询到相关联的店铺
						ShopsDO shopsdo = shopService
								.queryShopsDOByDeviceId(device.getId());
						// 6、2设置店铺名臣
						if (shopsdo != null) {
							if (shopsdo.getShopsName() != null
									&& !"".equals(shopsdo.getShopsName())) {
								shdo.setRegisterShopName(shopsdo.getShopsName());
							} else {
								shdo.setRegisterShopName("无数据");
							}

						} else {
							shdo.setRegisterShopName("无数据");
						}
					} else {
						shdo.setRegisterShopName("无数据");
					}

					// 8、设置用户的商品消费总额
					double user_money_item = 0.0;

					// 将用户的订单和创客关联上

					for (int j = 0; j < order_list_maker.size(); j++) {
						if (order_list_maker.get(j).getBuyerUserId()
								.longValue() == list_users_all.get(i)
								.getUserId()) {
							user_money_item += Double
									.parseDouble(order_list_maker.get(j)
											.getTotalPrice());
						}
					}

					shdo.setItemMoney(user_money_item);
					// 9、设置用户的服务消费额
					// 9.1、先通过用户的ID查询出来，用户所有的服务订单
					double user_money_services = 0.0;

					for (int k = 0; k < service_list_maker.size(); k++) {

						if (service_list_maker.get(k).getBuyerUserId()
								.longValue() == list_users_all.get(i)
								.getUserId()) {
							user_money_services += Double
									.parseDouble(service_list_maker.get(k)
											.getTotalPrice());
						}
					}

					shdo.setServiceMoney(user_money_services);
					// 设置用户总的消费额度
					shdo.setTotalMoney(user_money_services + user_money_item);

					if ((user_money_services + user_money_item) == 0) {
						for (int j = 0; j < list_users_maker.size(); j++) {
							if (list_users_maker.get(j).getUserId() == list_users_all
									.get(i).getUserId()) {
								shdo.setServiceMoney(0.0);
								shdo.setItemMoney(0.0);
								shdo.setTotalMoney(0.0);
								list_detail.add(shdo);
							}
						}

					} else {
						list_detail.add(shdo);
					}
				}
			}
			double sorl_total_money = 0.0;

			for (int j = 0; j < list_detail.size(); j++) {
				sorl_total_money += list_detail.get(j).getTotalMoney();
			}
			jsonObject.put("sorl_total_money", sorl_total_money);
			jsonObject.put("list_detail", JSONObject.toJSON(list_detail));
			jsonObject.put("message", "查询成功");
			jsonObject.put("success", true);
		}
		return jsonObject.toString();
	}

	/**
	 * 查看用户消费详情
	 */
	@RequestMapping(value = { "/maker/showStatemenDetail" })
	public String showStatemenDetailList(
			@RequestParam(value = "userId", required = true) long userId,
			@RequestParam(value = "buyUserId", required = true) long buyUserId,
			@RequestParam(value = "beginDate", required = false, defaultValue = "") String beginDate,
			@RequestParam(value = "endDate", required = false, defaultValue = "") String endDate)
			throws Exception {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		// 先判断登录的用户是否是创客，如果不是就返回
		List<MakerDO> maker_list = makerService.queryMakerDOByUserId(userId);

		if (maker_list.isEmpty() && maker_list.size() <= 0) {
			jsonObject.put("message", "身份不对，请切换账号重试");
			return jsonObject.toString();
		}
		MakerDO makerDO = maker_list.get(0);

		// 获取注册用户总数
		List<UsersDO> list_users_all = usersService.queryAll();

		// 将用户的信息，和创客关联起来
		List<DeviceMakerDO> maker_device_list = deviceMakerServiec
				.selectByMakerId(makerDO.getId());

		// 将创客的设备和相应的店铺关联起来
		List<ShopsDO> list_shop = new ArrayList<ShopsDO>();

		for (int i = 0; i < maker_device_list.size(); i++) {
			DeviceDO device = deviceService.queryDeviceDOById(maker_device_list
					.get(i).getDeviceId());
			if (device != null) {
				ShopsDO do1 = shopService
						.queryShopsDOByDeviceId(device.getId());
				list_shop.add(do1);
			}
		}

		// 拿着购买人ID，在数据库中查出该用户所有的商品订单
		List<TradeOrderDO> list_order_by_buyUser = orderService
				.queryOrderByBuyerUserItem(buyUserId);
		// 要在里面筛选出来，属于该创客的订单

		// 所有属于该创客的商品订单
		List<TradeOrderDO> order_list_maker = new ArrayList<TradeOrderDO>();

		for (int i = 0; i < list_order_by_buyUser.size(); i++) {
			for (int j = 0; j < list_shop.size(); j++) {
				if (list_order_by_buyUser.get(i).getSellerUserId().longValue() == list_shop
						.get(j).getShopsId().longValue()) {
					order_list_maker.add(list_order_by_buyUser.get(i));
				}
			}
		}

		// 拿着购买人token，查询出该用户所有的服务订单
		List<TradeOrderDO> service_list_user = orderService
				.queryOrderByBuyerUserService(buyUserId);

		List<TradeOrderDO> service_maker_list_user = new ArrayList<TradeOrderDO>();

		for (int i = 0; i < service_list_user.size(); i++) {
			for (int j = 0; j < list_shop.size(); j++) {
				if (service_list_user.get(i).getBuyerUserId().longValue() == list_shop
						.get(j).getShopsId().longValue()) {
					service_maker_list_user.add(service_list_user.get(i));
				}
			}
		}

		List<StatementHqDetailDO> list = new ArrayList<StatementHqDetailDO>();

		// 不根据时间查询
		if (beginDate.equals("") || beginDate == null || endDate.equals("")
				|| endDate == null) {

			for (int i = 0; i < service_maker_list_user.size(); i++) {
				// 代表订单已经完成
				StatementHqDetailDO detailDO = new StatementHqDetailDO();
				// 1、用户信息
				detailDO.setUserId(buyUserId);
				// 2、订单编号
				detailDO.setOrderNum(service_maker_list_user.get(i)
						.getOrderId());
				// 3、订单创建时间
				detailDO.setOrderCreatTime(service_maker_list_user.get(i)
						.getCreated());
				// 4、购买渠道
				if (service_maker_list_user.get(i).getOrderSource() != null
						&& !"".equals(service_maker_list_user.get(i)
								.getOrderSource())) {
					switch (Integer.valueOf(service_maker_list_user.get(i)
							.getOrderSource())) {
					case 1:
						detailDO.setBuyDitch("IOS");
						break;
					case 2:
						detailDO.setBuyDitch("Android");
						break;
					case 3:
						detailDO.setBuyDitch("WeChat Shop");
						break;
					default:
						detailDO.setBuyDitch("无");
						break;
					}
				}
				List<ItemsDetail> list_result_list = new ArrayList<ItemsDetail>();
				ItemsDetail itemsDetail = new ItemsDetail();
				itemsDetail.setItemName("服务类商品");
				// 设置商品的购买数量
				itemsDetail.setBuyNum(0);
				// 设置实付单价
				itemsDetail.setPaymentMoney(0.0);
				// 设置优惠金额
				itemsDetail.setDiscountsMoney(0.0);
				list_result_list.add(itemsDetail);
				detailDO.setDetails(list_result_list);

				// 消费总额
				detailDO.setTotalMoney(Double
						.parseDouble(service_maker_list_user.get(i)
								.getTotalPrice()));
				// 根据订单ID，查询各个的分成
				CommissionMoneyDO cmd = orderService
						.queryCommissionMoneyByOrderId(service_maker_list_user
								.get(i).getOrderId());
				if (cmd != null) {
					// 9、设置经销商分成
					detailDO.setDistributorMonry(Double.parseDouble(cmd
							.getDistributorAmount()));
					// 10、设置店铺分成
					detailDO.setShopMoney(Double.parseDouble(cmd
							.getShopAmount()));
					// 11、设置创客分成
					detailDO.setMakerMoney(Double.parseDouble(cmd
							.getMakerAmount()));
					// 12、设置异业分成
					detailDO.setOthershopMoney(Double.parseDouble(cmd
							.getOthershopAmount()));
				} else {
					// 9、设置经销商分成
					detailDO.setDistributorMonry(0.0);
					// 10、设置店铺分成
					detailDO.setShopMoney(0.0);
					// 11、设置创客分成
					detailDO.setMakerMoney(0.0);
					// 12、设置异业分成
					detailDO.setOthershopMoney(0.0);
				}
				// 13、设置店铺名称
				ShopsDO shopsdo = shopService
						.queryShopsDOById(service_maker_list_user.get(i)
								.getSellerUserId());
				if (shopsdo != null) {
					detailDO.setOthersName(shopsdo.getShopsName());
				} else {
					detailDO.setOthersName("无数据");
				}
				list.add(detailDO);

			}

			for (int i = 0; i < order_list_maker.size(); i++) {
				StatementHqDetailDO detailDO = new StatementHqDetailDO();
				detailDO.setUserId(buyUserId);
				// 2、设置订单编号
				detailDO.setOrderNum(order_list_maker.get(i).getOrderId());
				// 3、设置购买时间
				detailDO.setOrderCreatTime(order_list_maker.get(i).getCreated());
				// 4、购买渠道
				if (order_list_maker.get(i).getOrderSource() != null
						&& !"".equals(order_list_maker.get(i).getOrderSource())) {
					switch (Integer.valueOf(order_list_maker.get(i)
							.getOrderSource())) {
					case 1:
						detailDO.setBuyDitch("IOS");
						break;
					case 2:
						detailDO.setBuyDitch("Android");
						break;
					case 3:
						detailDO.setBuyDitch("WeChat Shop");
						break;
					default:
						detailDO.setBuyDitch("无");
						break;
					}
				}

				List<TradeOrderItemDO> list_item = orderService
						.queryChildOrderItemsList(order_list_maker.get(i)
								.getOrderId());
				// 5、商品名称。通过商品Id,找到商品
				if (list_item.isEmpty() && list_item.size() <= 0) {
					List<ItemsDetail> list_item_list = new ArrayList<ItemsDetail>();
					ItemsDetail itemsDetail = new ItemsDetail();
					itemsDetail.setItemName("无商品");
					// 设置商品的购买数量
					itemsDetail.setBuyNum(0);
					// 设置实付单价
					itemsDetail.setPaymentMoney(0.0);
					// 设置优惠金额
					itemsDetail.setDiscountsMoney(0.0);
					list_item_list.add(itemsDetail);
					detailDO.setDetails(list_item_list);
				} else {
					List<ItemsDetail> list_item_list = new ArrayList<ItemsDetail>();
					for (int j = 0; j < list_item.size(); j++) {

						ItemsDetail itemsDetail = new ItemsDetail();
						ItemDO item = itemService.getById(list_item.get(j)
								.getItemId());
						// 设置商品名称
						itemsDetail.setItemName(item.getItemName());
						// 设置商品的购买数量
						itemsDetail.setBuyNum(list_item.get(j).getNumber());
						// 设置实付单价
						itemsDetail.setPaymentMoney(Double
								.parseDouble(list_item.get(j).getPrice()));
						// 设置优惠金额
						itemsDetail.setDiscountsMoney(Double.parseDouble(item
								.getPrice())
								* list_item.get(j).getNumber()
								- Double.parseDouble(order_list_maker.get(i)
										.getTotalPrice()));
						list_item_list.add(itemsDetail);
					}
					detailDO.setDetails(list_item_list);
				}
				// 8消费总额
				detailDO.setTotalMoney(Double.parseDouble(order_list_maker.get(
						i).getTotalPrice()));

				// 根据订单ID，查询各个的分成
				CommissionMoneyDO cmd = orderService
						.queryCommissionMoneyByOrderId(order_list_maker.get(i)
								.getOrderId());
				if (cmd != null) {
					// 9、设置经销商分成
					detailDO.setDistributorMonry(Double.parseDouble(cmd
							.getDistributorAmount()));
					// 10、设置店铺分成
					detailDO.setShopMoney(Double.parseDouble(cmd
							.getShopAmount()));
					// 11、设置创客分成
					detailDO.setMakerMoney(Double.parseDouble(cmd
							.getMakerAmount()));
					// 12、设置异业分成
					detailDO.setOthershopMoney(Double.parseDouble(cmd
							.getOthershopAmount()));
				} else {
					// 9、设置经销商分成
					detailDO.setDistributorMonry(0.0);
					// 10、设置店铺分成
					detailDO.setShopMoney(0.0);
					// 11、设置创客分成
					detailDO.setMakerMoney(0.0);
					// 12、设置异业分成
					detailDO.setOthershopMoney(0.0);
				}
				// 13、设置店铺名称
				ShopsDO shopsDO = shopService.queryShopsDOById(order_list_maker
						.get(i).getSellerUserId());
				if (shopsDO != null) {
					detailDO.setOthersName(shopsDO.getShopsName());
				} else {
					detailDO.setOthersName("无数据");
				}
				list.add(detailDO);
			}
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date_beginDate = dateFormat.parse(beginDate);
			long long_beginDate = date_beginDate.getTime() / 1000;
			Date date_endDate = dateFormat.parse(endDate);
			long long_endDate = date_endDate.getTime() / 1000;

			for (int i = 0; i < service_maker_list_user.size(); i++) {

				if (service_maker_list_user.get(i).getCreated() >= long_beginDate
						&& service_maker_list_user.get(i).getCreated() <= long_endDate) {
					// 代表订单已经完成
					StatementHqDetailDO detailDO = new StatementHqDetailDO();
					// 1、用户信息
					detailDO.setUserId(buyUserId);
					// 2、订单编号
					detailDO.setOrderNum(service_maker_list_user.get(i)
							.getOrderId());
					// 3、订单创建时间
					detailDO.setOrderCreatTime(service_maker_list_user.get(i)
							.getCreated());
					// 4、购买渠道
					if (service_maker_list_user.get(i).getOrderSource() != null
							&& !"".equals(service_maker_list_user.get(i)
									.getOrderSource())) {
						switch (Integer.valueOf(service_maker_list_user.get(i)
								.getOrderSource())) {
						case 1:
							detailDO.setBuyDitch("IOS");
							break;
						case 2:
							detailDO.setBuyDitch("Android");
							break;
						case 3:
							detailDO.setBuyDitch("WeChat Shop");
							break;
						default:
							detailDO.setBuyDitch("无");
							break;
						}
					}
					List<ItemsDetail> list_result_list = new ArrayList<ItemsDetail>();
					ItemsDetail itemsDetail = new ItemsDetail();
					itemsDetail.setItemName("服务类商品");
					// 设置商品的购买数量
					itemsDetail.setBuyNum(0);
					// 设置实付单价
					itemsDetail.setPaymentMoney(0.0);
					// 设置优惠金额
					itemsDetail.setDiscountsMoney(0.0);
					list_result_list.add(itemsDetail);
					detailDO.setDetails(list_result_list);

					// 消费总额
					detailDO.setTotalMoney(Double
							.parseDouble(service_maker_list_user.get(i)
									.getTotalPrice()));
					// 根据订单ID，查询各个的分成
					CommissionMoneyDO cmd = orderService
							.queryCommissionMoneyByOrderId(service_maker_list_user
									.get(i).getOrderId());
					if (cmd != null) {
						// 9、设置经销商分成
						detailDO.setDistributorMonry(Double.parseDouble(cmd
								.getDistributorAmount()));
						// 10、设置店铺分成
						detailDO.setShopMoney(Double.parseDouble(cmd
								.getShopAmount()));
						// 11、设置创客分成
						detailDO.setMakerMoney(Double.parseDouble(cmd
								.getMakerAmount()));
						// 12、设置异业分成
						detailDO.setOthershopMoney(Double.parseDouble(cmd
								.getOthershopAmount()));
					} else {
						// 9、设置经销商分成
						detailDO.setDistributorMonry(0.0);
						// 10、设置店铺分成
						detailDO.setShopMoney(0.0);
						// 11、设置创客分成
						detailDO.setMakerMoney(0.0);
						// 12、设置异业分成
						detailDO.setOthershopMoney(0.0);
					}
					// 13、设置店铺名称
					ShopsDO shopsdo = shopService
							.queryShopsDOById(service_maker_list_user.get(i)
									.getSellerUserId());
					if (shopsdo != null) {
						detailDO.setOthersName(shopsdo.getShopsName());
					} else {
						detailDO.setOthersName("无数据");
					}
					list.add(detailDO);

				}
			}

			for (int i = 0; i < order_list_maker.size(); i++) {

				if (order_list_maker.get(i).getCreated() >= long_beginDate
						&& order_list_maker.get(i).getCreated() <= long_endDate) {
					StatementHqDetailDO detailDO = new StatementHqDetailDO();
					detailDO.setUserId(buyUserId);
					// 2、设置订单编号
					detailDO.setOrderNum(order_list_maker.get(i).getOrderId());
					// 3、设置购买时间
					detailDO.setOrderCreatTime(order_list_maker.get(i)
							.getCreated());
					// 4、购买渠道
					if (order_list_maker.get(i).getOrderSource() != null
							&& !"".equals(order_list_maker.get(i)
									.getOrderSource())) {
						switch (Integer.valueOf(order_list_maker.get(i)
								.getOrderSource())) {
						case 1:
							detailDO.setBuyDitch("IOS");
							break;
						case 2:
							detailDO.setBuyDitch("Android");
							break;
						case 3:
							detailDO.setBuyDitch("WeChat Shop");
							break;
						default:
							detailDO.setBuyDitch("无");
							break;
						}
					}

					List<TradeOrderItemDO> list_item = orderService
							.queryChildOrderItemsList(order_list_maker.get(i)
									.getOrderId());
					// 5、商品名称。通过商品Id,找到商品
					if (list_item.isEmpty() && list_item.size() <= 0) {
						List<ItemsDetail> list_item_list = new ArrayList<ItemsDetail>();
						ItemsDetail itemsDetail = new ItemsDetail();
						itemsDetail.setItemName("无商品");
						// 设置商品的购买数量
						itemsDetail.setBuyNum(0);
						// 设置实付单价
						itemsDetail.setPaymentMoney(0.0);
						// 设置优惠金额
						itemsDetail.setDiscountsMoney(0.0);
						list_item_list.add(itemsDetail);
						detailDO.setDetails(list_item_list);
					} else {
						List<ItemsDetail> list_item_list = new ArrayList<ItemsDetail>();
						for (int j = 0; j < list_item.size(); j++) {

							ItemsDetail itemsDetail = new ItemsDetail();
							ItemDO item = itemService.getById(list_item.get(j)
									.getItemId());
							// 设置商品名称
							itemsDetail.setItemName(item.getItemName());
							// 设置商品的购买数量
							itemsDetail.setBuyNum(list_item.get(j).getNumber());
							// 设置实付单价
							itemsDetail.setPaymentMoney(Double
									.parseDouble(list_item.get(j).getPrice()));
							// 设置优惠金额
							itemsDetail.setDiscountsMoney(Double
									.parseDouble(item.getPrice())
									* list_item.get(j).getNumber()
									- Double.parseDouble(order_list_maker
											.get(i).getTotalPrice()));
							list_item_list.add(itemsDetail);
						}
						detailDO.setDetails(list_item_list);
					}
					// 8消费总额
					detailDO.setTotalMoney(Double.parseDouble(order_list_maker
							.get(i).getTotalPrice()));

					// 根据订单ID，查询各个的分成
					CommissionMoneyDO cmd = orderService
							.queryCommissionMoneyByOrderId(order_list_maker
									.get(i).getOrderId());
					if (cmd != null) {
						// 9、设置经销商分成
						detailDO.setDistributorMonry(Double.parseDouble(cmd
								.getDistributorAmount()));
						// 10、设置店铺分成
						detailDO.setShopMoney(Double.parseDouble(cmd
								.getShopAmount()));
						// 11、设置创客分成
						detailDO.setMakerMoney(Double.parseDouble(cmd
								.getMakerAmount()));
						// 12、设置异业分成
						detailDO.setOthershopMoney(Double.parseDouble(cmd
								.getOthershopAmount()));
					} else {
						// 9、设置经销商分成
						detailDO.setDistributorMonry(0.0);
						// 10、设置店铺分成
						detailDO.setShopMoney(0.0);
						// 11、设置创客分成
						detailDO.setMakerMoney(0.0);
						// 12、设置异业分成
						detailDO.setOthershopMoney(0.0);
					}
					// 13、设置店铺名称
					ShopsDO shopsDO = shopService
							.queryShopsDOById(order_list_maker.get(i)
									.getSellerUserId());
					if (shopsDO != null) {
						detailDO.setOthersName(shopsDO.getShopsName());
					} else {
						detailDO.setOthersName("无数据");
					}
					list.add(detailDO);
				}
			}
		}
		jsonObject.put("success", true);
		jsonObject.put("message", "查询成功");
		jsonObject.put("data", list);
		return jsonObject.toJSONString();
	}
}
