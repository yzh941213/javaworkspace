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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aishidai.app.model.pojo.CommissionMoneyDO;
import com.aishidai.app.model.pojo.DeviceDO;
import com.aishidai.app.model.pojo.DeviceMakerDO;
import com.aishidai.app.model.pojo.DistributorDO;
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
public class StatementDistributorController {

	private static final Logger logger = LoggerFactory
			.getLogger(StatementDistributorController.class);

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
	@RequestMapping(value = { "/db/showStatemen" }, method = { RequestMethod.POST,
			RequestMethod.GET })
	public String showStatemenList(
			@RequestParam(value = "userId", required = true) long userId,
			@RequestParam(value = "beginDate", required = false, defaultValue = "") String beginDate,
			@RequestParam(value = "endDate", required = false, defaultValue = "") String endDate,
			@RequestParam(value = "shopsId", required = false, defaultValue = "0") long shopsId)
			throws Exception {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		DistributorDO distributorDO = new DistributorDO();

		// 检测登录的用户是否是经销商
		List<DistributorDO> user_list_logon = distributorService
				.selectDistributorDOByUserId(userId);
		if (user_list_logon.isEmpty() && user_list_logon.size() <= 0) {
			jsonObject.put("message", "身份不对，请切换账号重试");
			return jsonObject.toString();
		}
		distributorDO = user_list_logon.get(0);

		List<UsersDO> list_users_all = usersService.queryAll();
		List<UsersDO> list_users_distributor = new ArrayList<UsersDO>();

		// 通过经销商下面的机器码，查询用户注册是否其下面的
		List<DeviceDO> list_device = deviceService
				.queryDeviceDOByDistributorId(distributorDO.getId());

		for (int i = 0; i < list_device.size(); i++) {
			for (int j = 0; j < list_users_all.size(); j++) {
				if (list_device.get(i).getProductNo()
						.equals(list_users_all.get(j).getRegisterIp())) {
					list_users_distributor.add(list_users_all.get(j));
				}
			}
		}

		// 设置注册在该经销商下面的用户总数
		jsonObject
				.put("users_count_distributor", list_users_distributor.size());
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

		for (int i = 0; i < list_users_distributor.size(); i++) {
			if (date_time.equals(dateFormat.format(list_users_distributor
					.get(i).getRegisterTime()))) {
				users_register_24H_count++;
			}
		}

		jsonObject.put("users_register_24H_count", users_register_24H_count);

		// 该经销商下面的商品消费总额
		double money_total_item_distributor = 0.0;
		List<TradeOrderDO> order_list = orderService.queryItems();
		// 所有属于该经销商的商品订单
		List<TradeOrderDO> order_list_distributor = new ArrayList<TradeOrderDO>();
		// 1、先查询出来，该经销商下面所有的店铺
		// 2、拿着该经销商下面的所有店铺的订单，计算商品消费额度
		List<ShopsDO> list_shop_distributor = shopService.selectShopBydistributorId(distributorDO.getId());
		// 1、遍历所有订单
		for (int i = 0; i < order_list.size(); i++) {
			for (int j = 0; j < list_shop_distributor.size(); j++) {
				// 判断卖家ID是否属于该店铺的
				if (order_list.get(i).getSellerUserId().longValue() == list_shop_distributor
						.get(j).getShopsId().longValue()) {
					order_list_distributor.add(order_list.get(i));
					money_total_item_distributor += Double
							.parseDouble(order_list.get(i).getTotalPrice());
				}
			}
		}

		jsonObject.put("money_total_item_distributor",
				money_total_item_distributor);

		// 服务消费总额
		double money_total_service_distributor = 0.0;
		List<TradeOrderDO> service_list = orderService.queryService();
		// 属于该经销商下面的服务订单
		List<TradeOrderDO> service_list_distributor = new ArrayList<TradeOrderDO>();

		for (int i = 0; i < service_list.size(); i++) {
			for (int j = 0; j < list_shop_distributor.size(); j++) {
				if (service_list.get(i).getSellerUserId().longValue() == list_shop_distributor
						.get(j).getShopsId().longValue()) {
					service_list_distributor.add(service_list.get(i));
					money_total_service_distributor += Double
							.parseDouble(service_list.get(i).getTotalPrice());
				}
			}
		}

		jsonObject.put("money_total_service_distributor",
				money_total_service_distributor);
		// 平台交易额
		jsonObject.put("money_total_distributor",
				money_total_service_distributor + money_total_item_distributor);

		// 付费人员总人数
		int member_count_distributor = 0;
		List<MemberDO> member_List = usersService.queryMemberAll();
		for (int i = 0; i < member_List.size(); i++) {
			for (int j = 0; j < list_users_distributor.size(); j++) {
				if (member_List.get(i).getUserId().longValue() == list_users_distributor
						.get(j).getUserId().longValue()) {
					if (member_List.get(i).getMemberType() == 0) {
						member_count_distributor++;
					}
				}
			}
		}

		jsonObject.put("member_count_distributor", member_count_distributor);

		List<StatementHqDO> list_detail = new ArrayList<StatementHqDO>();

		// 查询的列表数据
		// 先查询出全部的注册用户,上面已经完成，
		// 下面遍历全部用户 result_users
		if (beginDate.equals("") || beginDate == null || endDate.equals("")
				|| endDate == null) {
			if (shopsId == 0) {
				// 代表正常查询,不进行筛选
				for (int i = 0; i < list_users_all.size(); i++) {
					// 要显示首先满足两点1、在该经销商下注册的，2、在该经销商下有订单
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

					List<MakerDO> list_maker = new ArrayList<MakerDO>();
					// 8、设置创客
					if (device != null) {
						List<DeviceMakerDO> deviceMaker_list = deviceMakerServiec
								.selectBydeviceId(device.getId());
						for (int j = 0; j < deviceMaker_list.size(); j++) {
							MakerDO maker = makerService
									.queryMakerDOById(deviceMaker_list.get(j)
											.getMakerId());
							list_maker.add(maker);
						}
					}
					shdo.setMakers(list_maker);

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

					// 8、设置用户的商品服务总额
					double user_money_item = 0.0;
					List<TradeOrderDO> user_order_list_item = orderService
							.queryOrderByBuyerUserItem(list_users_all.get(i)
									.getUserId());
					for (int j = 0; j < order_list_distributor.size(); j++) {
						for (int k = 0; k < user_order_list_item.size(); k++) {
							if (order_list_distributor.get(j).getOrderId()
									.longValue() == user_order_list_item.get(i)
									.getOrderId().longValue()) {
								user_money_item += Double
										.parseDouble(order_list_distributor
												.get(j).getTotalPrice());
							}
						}
					}
					shdo.setItemMoney(user_money_item);
					// 9、设置用户的服务消费额
					// 9.1、先通过用户的ID查询出来，用户所有的服务订单
					double user_money_service = 0.0;
					List<TradeOrderDO> user_order_list_service = orderService
							.queryOrderByBuyerUserService(list_users_all.get(i)
									.getUserId());
					for (int k = 0; k < service_list_distributor.size(); k++) {
						for (int j = 0; j < user_order_list_service.size(); j++) {
							if (service_list_distributor.get(k).getOrderId()
									.longValue() == user_order_list_service
									.get(i).getOrderId().longValue()) {
								user_money_service += Double
										.parseDouble(user_order_list_service
												.get(k).getTotalPrice());
							}
						}
					}
					shdo.setServiceMoney(user_money_service);
					// 设置用户总的消费额度
					shdo.setTotalMoney(user_money_service + user_money_item);

					if ((user_money_service + user_money_item) == 0.0) {
						for (int j = 0; j < list_users_distributor.size(); j++) {
							if (list_users_all.get(i).getUserId().longValue() == list_users_distributor
									.get(j).getUserId().longValue()) {
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
				// 代表按照店铺进行筛选查询
				for (int i = 0; i < list_users_all.size(); i++) {
					DeviceDO device_ = deviceService
							.queryDeviceDOByProductNo(list_users_all.get(i)
									.getRegisterIp());
					ShopsDO sdo = null;
					if (device_ != null) {
						// 通过设备号查询到相关联的店铺
						sdo = shopService.queryShopsDOByDeviceId(device_
								.getId());
					}
					if (sdo != null) {
						// 要显示首先满足两点1、在该经销商下注册的，2、在该经销商下有订单
						if (shopsId == sdo.getShopsId()) {
							// 要显示首先满足两点1、在该经销商下注册的，2、在该经销商下有订单
							StatementHqDO shdo = new StatementHqDO();
							// 1、设置用户ID
							shdo.setUserId(list_users_all.get(i).getUserId());
							// 2、设置用户名
							if (list_users_all.get(i).getUnick() != null
									|| !"".equals(list_users_all.get(i)
											.getUnick())) {
								shdo.setMemberName(list_users_all.get(i)
										.getUnick());
							} else {
								shdo.setMemberName("未设置");
							}
							// 3、设置注册时间
							if (list_users_all.get(i).getRegisterTime() != null) {
								SimpleDateFormat dft = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss");
								shdo.setRegistertime(dft.format(list_users_all
										.get(i).getRegisterTime()));
							} else {
								shdo.setRegistertime(null);
							}
							// 4、设置手机号
							if (list_users_all.get(i).getPhone() != null
									&& !"".equals(list_users_all.get(i)
											.getPhone())) {
								shdo.setUsername(list_users_all
										.get(i)
										.getPhone()
										.replace(
												list_users_all.get(i)
														.getPhone()
														.substring(4, 8),
												"****"));
							} else {
								shdo.setUsername("未填写");
							}
							// 5、设置注册设备号
							shdo.setDeviceNum(list_users_all.get(i)
									.getRegisterIp());

							DeviceDO device = deviceService
									.queryDeviceDOByProductNo(list_users_all
											.get(i).getRegisterIp());
							if (device != null) {
								// 6.1 设置注册店铺 通过设备号查询到相关联的店铺
								ShopsDO shopsdo = shopService
										.queryShopsDOByDeviceId(device.getId());
								// 6、2设置店铺名臣
								if (shopsdo != null) {
									if (shopsdo.getShopsName() != null
											&& !"".equals(shopsdo
													.getShopsName())) {
										shdo.setRegisterShopName(shopsdo
												.getShopsName());
									} else {
										shdo.setRegisterShopName("无数据");
									}

								} else {
									shdo.setRegisterShopName("无数据");
								}
							} else {
								shdo.setRegisterShopName("无数据");
							}

							List<MakerDO> list_maker = new ArrayList<MakerDO>();
							// 8、设置创客
							if (device != null) {
								List<DeviceMakerDO> deviceMaker_list = deviceMakerServiec
										.selectBydeviceId(device.getId());
								for (int j = 0; j < deviceMaker_list.size(); j++) {
									MakerDO maker = makerService
											.queryMakerDOById(deviceMaker_list
													.get(j).getMakerId());
									list_maker.add(maker);
								}
							}
							shdo.setMakers(list_maker);

							// 7、设置用户的会员状态
							if (list_users_all.get(i).getMember() == 0) {
								shdo.setMemberType("不是会员");
							} else {
								MemberDO memberDO = usersService
										.queryMemberDOByUserId(list_users_all
												.get(i).getUserId());
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

							// 8、设置用户的商品服务总额
							double user_money_item = 0.0;
							List<TradeOrderDO> user_order_list_item = orderService
									.queryOrderByBuyerUserItem(list_users_all
											.get(i).getUserId());
							for (int j = 0; j < order_list_distributor.size(); j++) {
								for (int k = 0; k < user_order_list_item.size(); k++) {
									if (order_list_distributor.get(j)
											.getOrderId().longValue() == user_order_list_item
											.get(i).getOrderId().longValue()) {
										user_money_item += Double
												.parseDouble(order_list_distributor
														.get(j).getTotalPrice());
									}
								}
							}
							shdo.setItemMoney(user_money_item);
							// 9、设置用户的服务消费额
							// 9.1、先通过用户的ID查询出来，用户所有的服务订单
							double user_money_service = 0.0;
							List<TradeOrderDO> user_order_list_service = orderService
									.queryOrderByBuyerUserService(list_users_all
											.get(i).getUserId());
							for (int k = 0; k < service_list_distributor.size(); k++) {
								for (int j = 0; j < user_order_list_service
										.size(); j++) {
									if (service_list_distributor.get(k)
											.getOrderId().longValue() == user_order_list_service
											.get(i).getOrderId().longValue()) {
										user_money_service += Double
												.parseDouble(user_order_list_service
														.get(k).getTotalPrice());
									}
								}
							}
							shdo.setServiceMoney(user_money_service);
							// 设置用户总的消费额度
							shdo.setTotalMoney(user_money_service
									+ user_money_item);

							if ((user_money_service + user_money_item) == 0.0) {
								for (int j = 0; j < list_users_distributor
										.size(); j++) {
									if (list_users_all.get(i).getUserId()
											.longValue() == list_users_distributor
											.get(j).getUserId().longValue()) {
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
							sorl_total_money += list_detail.get(j)
									.getTotalMoney();
						}
						jsonObject.put("sorl_total_money", sorl_total_money);
						jsonObject.put("list_detail",
								JSONObject.toJSON(list_detail));
						jsonObject.put("message", "查询成功");
						jsonObject.put("success", true);
					}
				}
			}
			// 输入的时间不为null
		} else {
			// 只根据时间进行筛选
			Date date_beginDate = dateFormat.parse(beginDate);
			long long_beginDate = date_beginDate.getTime();
			Date date_endDate = dateFormat.parse(endDate);
			long long_endDate = date_endDate.getTime();
			if (shopsId == 0) {
				// 只根据时间进行搜索

				for (int i = 0; i < list_users_all.size(); i++) {
					// 将用户的注册时间转化为date类型
					Date date_registertime = list_users_all.get(i)
							.getRegisterTime();
					long long_registertime = date_registertime.getTime();
					if (long_registertime >= long_beginDate
							&& long_registertime <= long_endDate) {
						// 要显示首先满足两点1、在该经销商下注册的，2、在该经销商下有订单
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
							shdo.setRegistertime(dft.format(list_users_all.get(
									i).getRegisterTime()));
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
									shdo.setRegisterShopName(shopsdo
											.getShopsName());
								} else {
									shdo.setRegisterShopName("无数据");
								}

							} else {
								shdo.setRegisterShopName("无数据");
							}
						} else {
							shdo.setRegisterShopName("无数据");
						}

						List<MakerDO> list_maker = new ArrayList<MakerDO>();
						// 8、设置创客
						if (device != null) {
							List<DeviceMakerDO> deviceMaker_list = deviceMakerServiec
									.selectBydeviceId(device.getId());
							for (int j = 0; j < deviceMaker_list.size(); j++) {
								MakerDO maker = makerService
										.queryMakerDOById(deviceMaker_list.get(
												j).getMakerId());
								list_maker.add(maker);
							}
						}
						shdo.setMakers(list_maker);

						// 7、设置用户的会员状态
						if (list_users_all.get(i).getMember() == 0) {
							shdo.setMemberType("不是会员");
						} else {
							MemberDO memberDO = usersService
									.queryMemberDOByUserId(list_users_all
											.get(i).getUserId());
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

						// 8、设置用户的商品服务总额
						double user_money_item = 0.0;
						List<TradeOrderDO> user_order_list_item = orderService
								.queryOrderByBuyerUserItem(list_users_all
										.get(i).getUserId());
						for (int j = 0; j < order_list_distributor.size(); j++) {
							for (int k = 0; k < user_order_list_item.size(); k++) {
								if (order_list_distributor.get(j).getOrderId()
										.longValue() == user_order_list_item
										.get(i).getOrderId().longValue()) {
									user_money_item += Double
											.parseDouble(order_list_distributor
													.get(j).getTotalPrice());
								}
							}
						}
						shdo.setItemMoney(user_money_item);
						// 9、设置用户的服务消费额
						// 9.1、先通过用户的ID查询出来，用户所有的服务订单
						double user_money_service = 0.0;
						List<TradeOrderDO> user_order_list_service = orderService
								.queryOrderByBuyerUserService(list_users_all
										.get(i).getUserId());
						for (int k = 0; k < service_list_distributor.size(); k++) {
							for (int j = 0; j < user_order_list_service.size(); j++) {
								if (service_list_distributor.get(k)
										.getOrderId().longValue() == user_order_list_service
										.get(i).getOrderId().longValue()) {
									user_money_service += Double
											.parseDouble(user_order_list_service
													.get(k).getTotalPrice());
								}
							}
						}
						shdo.setServiceMoney(user_money_service);
						// 设置用户总的消费额度
						shdo.setTotalMoney(user_money_service + user_money_item);

						if ((user_money_service + user_money_item) == 0.0) {
							for (int j = 0; j < list_users_distributor.size(); j++) {
								if (list_users_all.get(i).getUserId()
										.longValue() == list_users_distributor
										.get(j).getUserId().longValue()) {
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
					jsonObject.put("list_detail",
							JSONObject.toJSON(list_detail));
					jsonObject.put("message", "查询成功");
					jsonObject.put("success", true);
				}
			} else {
				// 根据时间和店铺进行搜索
				for (int i = 0; i < list_users_all.size(); i++) {
					// 将用户的注册时间转化为date类型
					Date date_registertime = list_users_all.get(i)
							.getRegisterTime();
					long long_registertime = date_registertime.getTime();
					if (long_registertime >= long_beginDate
							&& long_registertime <= long_endDate) {
						// 要显示首先满足两点1、在该经销商下注册的，2、在该经销商下有订单
						DeviceDO device_ = deviceService
								.queryDeviceDOByProductNo(list_users_all.get(i)
										.getRegisterIp());
						ShopsDO sdo = null;
						if (device_ != null) {
							// 6、设置注册店铺
							// 6.1通过设备号查询到相关联的店铺
							sdo = shopService.queryShopsDOByDeviceId(device_
									.getId());
						}

						if (sdo != null && sdo.getShopsId() == shopsId) {

							// 要显示首先满足两点1、在该经销商下注册的，2、在该经销商下有订单
							StatementHqDO shdo = new StatementHqDO();
							// 1、设置用户ID
							shdo.setUserId(list_users_all.get(i).getUserId());
							// 2、设置用户名
							if (list_users_all.get(i).getUnick() != null
									|| !"".equals(list_users_all.get(i)
											.getUnick())) {
								shdo.setMemberName(list_users_all.get(i)
										.getUnick());
							} else {
								shdo.setMemberName("未设置");
							}
							// 3、设置注册时间
							if (list_users_all.get(i).getRegisterTime() != null) {
								SimpleDateFormat dft = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss");
								shdo.setRegistertime(dft.format(list_users_all
										.get(i).getRegisterTime()));
							} else {
								shdo.setRegistertime(null);
							}
							// 4、设置手机号
							if (list_users_all.get(i).getPhone() != null
									&& !"".equals(list_users_all.get(i)
											.getPhone())) {
								shdo.setUsername(list_users_all
										.get(i)
										.getPhone()
										.replace(
												list_users_all.get(i)
														.getPhone()
														.substring(4, 8),
												"****"));
							} else {
								shdo.setUsername("未填写");
							}
							// 5、设置注册设备号
							shdo.setDeviceNum(list_users_all.get(i)
									.getRegisterIp());

							DeviceDO device = deviceService
									.queryDeviceDOByProductNo(list_users_all
											.get(i).getRegisterIp());
							if (device != null) {
								// 6.1 设置注册店铺 通过设备号查询到相关联的店铺
								ShopsDO shopsdo = shopService
										.queryShopsDOByDeviceId(device.getId());
								// 6、2设置店铺名臣
								if (shopsdo != null) {
									if (shopsdo.getShopsName() != null
											&& !"".equals(shopsdo
													.getShopsName())) {
										shdo.setRegisterShopName(shopsdo
												.getShopsName());
									} else {
										shdo.setRegisterShopName("无数据");
									}

								} else {
									shdo.setRegisterShopName("无数据");
								}
							} else {
								shdo.setRegisterShopName("无数据");
							}

							List<MakerDO> list_maker = new ArrayList<MakerDO>();
							// 8、设置创客
							if (device != null) {
								List<DeviceMakerDO> deviceMaker_list = deviceMakerServiec
										.selectBydeviceId(device.getId());
								for (int j = 0; j < deviceMaker_list.size(); j++) {
									MakerDO maker = makerService
											.queryMakerDOById(deviceMaker_list
													.get(j).getMakerId());
									list_maker.add(maker);
								}
							}
							shdo.setMakers(list_maker);

							// 7、设置用户的会员状态
							if (list_users_all.get(i).getMember() == 0) {
								shdo.setMemberType("不是会员");
							} else {
								MemberDO memberDO = usersService
										.queryMemberDOByUserId(list_users_all
												.get(i).getUserId());
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

							// 8、设置用户的商品服务总额
							double user_money_item = 0.0;
							List<TradeOrderDO> user_order_list_item = orderService
									.queryOrderByBuyerUserItem(list_users_all
											.get(i).getUserId());
							for (int j = 0; j < order_list_distributor.size(); j++) {
								for (int k = 0; k < user_order_list_item.size(); k++) {
									if (order_list_distributor.get(j)
											.getOrderId().longValue() == user_order_list_item
											.get(i).getOrderId().longValue()) {
										user_money_item += Double
												.parseDouble(order_list_distributor
														.get(j).getTotalPrice());
									}
								}
							}
							shdo.setItemMoney(user_money_item);
							// 9、设置用户的服务消费额
							// 9.1、先通过用户的ID查询出来，用户所有的服务订单
							double user_money_service = 0.0;
							List<TradeOrderDO> user_order_list_service = orderService
									.queryOrderByBuyerUserService(list_users_all
											.get(i).getUserId());
							for (int k = 0; k < service_list_distributor.size(); k++) {
								for (int j = 0; j < user_order_list_service
										.size(); j++) {
									if (service_list_distributor.get(k)
											.getOrderId().longValue() == user_order_list_service
											.get(i).getOrderId().longValue()) {
										user_money_service += Double
												.parseDouble(user_order_list_service
														.get(k).getTotalPrice());
									}
								}
							}
							shdo.setServiceMoney(user_money_service);
							// 设置用户总的消费额度
							shdo.setTotalMoney(user_money_service
									+ user_money_item);

							if ((user_money_service + user_money_item) == 0.0) {
								for (int j = 0; j < list_users_distributor
										.size(); j++) {
									if (list_users_all.get(i).getUserId()
											.longValue() == list_users_distributor
											.get(j).getUserId().longValue()) {
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
							sorl_total_money += list_detail.get(j)
									.getTotalMoney();
						}
						jsonObject.put("sorl_total_money", sorl_total_money);
						jsonObject.put("list_detail",
								JSONObject.toJSON(list_detail));
						jsonObject.put("message", "查询成功");
						jsonObject.put("success", true);
					}
				}
			}
		}
		return jsonObject.toString();
	}

	/**
	 * 查看用户消费详情
	 */
	@GetMapping("/db/showStatemenDetail")
	public String showStatemenDetailList(
			@RequestParam(value = "userId", required = true) long userId,
			@RequestParam(value = "buyUserId", required = true) long buyUserId,
			@RequestParam(value = "beginDate", required = false, defaultValue = "") String beginDate,
			@RequestParam(value = "endDate", required = false, defaultValue = "") String endDate)
			throws Exception {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		// 检测登录的用户是否是经销商
		DistributorDO distributorDO = new DistributorDO();

		// 检测登录的用户是否是经销商
		List<DistributorDO> user_list_logon = distributorService
				.selectDistributorDOByUserId(userId);
		if (user_list_logon.isEmpty() && user_list_logon.size() <= 0) {
			jsonObject.put("message", "身份不对，请切换账号重试");
			return jsonObject.toString();
		}
		distributorDO = user_list_logon.get(0);

		List<StatementHqDetailDO> list = new ArrayList<StatementHqDetailDO>();

		// 拿着购买人ID，遍历数据库查出该用户所有的商品订单
		List<TradeOrderDO> list_order_by_buyUser = orderService
				.queryOrderByBuyerUserItem(buyUserId);
		// 查询出来所有的商品订单 要在里面筛选出来，属于该经销商的订单
		List<TradeOrderDO> order_list = orderService.queryItems();
		// 所有属于该用户该经销商的商品订单
		List<TradeOrderDO> order_list_distributor_user = new ArrayList<TradeOrderDO>();
		// 查询出来所有属于该经销商的商品订单
		List<TradeOrderDO> order_list_distributor = new ArrayList<TradeOrderDO>();

		// 1、先查询出来，该经销商下面所有的店铺
		// 2、拿着该经销商下面的所有店铺的订单，计算商品消费额度
		List<ShopsDO> list_shop_distributor = shopService
				.selectShopBydistributorId(distributorDO.getId());
		// 1、遍历所有订单
		for (int i = 0; i < order_list.size(); i++) {
			for (int j = 0; j < list_shop_distributor.size(); j++) {
				if (order_list.get(i).getSellerUserId().longValue() == list_shop_distributor
						.get(j).getShopsId().longValue()) {
					order_list_distributor.add(order_list.get(i));
				}
			}
		}
		for (int k = 0; k < list_order_by_buyUser.size(); k++) {
			for (int i = 0; i < order_list_distributor.size(); i++) {
				if (list_order_by_buyUser.get(k).getBuyerUserId().longValue() == order_list_distributor
						.get(i).getBuyerUserId().longValue()) {
					order_list_distributor_user.add(list_order_by_buyUser
							.get(k));// 这样得到的就是该用户在，该经销商下面的所有的订单
				}
			}
		}

		// 拿着购买人token，查询出该用户所有的服务订单
		List<TradeOrderDO> service_list_user = orderService
				.queryOrderByBuyerUserService(buyUserId);
		// 查询出来，所有的所有的服务订单
		List<TradeOrderDO> service_list_all = orderService.queryService();
		// 所有属于该经销商的服务订单
		List<TradeOrderDO> service_order_list_distributor = new ArrayList<TradeOrderDO>();
		// 所有该用户属于该经销商的订单
		List<TradeOrderDO> service_user_distributor = new ArrayList<TradeOrderDO>();

		for (int i = 0; i < service_list_all.size(); i++) {
			for (int j = 0; j < list_shop_distributor.size(); j++) {
				if (service_list_all.get(i).getSellerUserId().longValue() == list_shop_distributor
						.get(j).getShopsId().longValue()) {
					service_order_list_distributor.add(service_list_all.get(i));
				}
			}
		}

		for (int k = 0; k < service_list_user.size(); k++) {
			for (int i = 0; i < service_order_list_distributor.size(); i++) {
				if (service_list_user.get(k).getBuyerUserId().longValue() == service_order_list_distributor
						.get(i).getBuyerUserId().longValue()) {
					service_user_distributor.add(service_list_user.get(k));// 这样得到的就是该用户在，该经销商下面的所有的订单
				}
			}
		}

		// 不根据时间查询
		if (beginDate.equals("") || beginDate == null || endDate.equals("")
				|| endDate == null) {
			for (int i = 0; i < service_user_distributor.size(); i++) {
				// 代表订单已经完成
				StatementHqDetailDO detailDO = new StatementHqDetailDO();
				// 1、用户信息
				detailDO.setUserId(buyUserId);
				// 2、订单编号
				detailDO.setOrderNum(service_user_distributor.get(i)
						.getOrderId());
				// 3、订单创建时间
				detailDO.setOrderCreatTime(service_user_distributor.get(i)
						.getCreated());
				// 4、购买渠道
				if (service_user_distributor.get(i).getOrderSource() != null
						&& !"".equals(service_user_distributor.get(i)
								.getOrderSource())) {
					switch (Integer.valueOf(service_user_distributor.get(i)
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
						.parseDouble(service_user_distributor.get(i)
								.getTotalPrice()));
				// 根据订单ID，查询各个的分成
				CommissionMoneyDO cmd = orderService
						.queryCommissionMoneyByOrderId(service_user_distributor
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
				ShopsDO shops = shopService
						.queryShopsDOById(service_user_distributor.get(i)
								.getSellerUserId());
				if (shops != null) {
					detailDO.setOthersName(shops.getShopsName());
				} else {
					detailDO.setOthersName("无数据");
				}
				list.add(detailDO);
			}

			for (int i = 0; i < order_list_distributor_user.size(); i++) {
				StatementHqDetailDO detailDO = new StatementHqDetailDO();

				detailDO.setUserId(buyUserId);
				// 2、设置订单编号
				detailDO.setOrderNum(order_list_distributor_user.get(i)
						.getOrderId());
				// 3、设置购买时间
				detailDO.setOrderCreatTime(order_list_distributor_user.get(i)
						.getCreated());
				// 4、购买渠道
				if (order_list_distributor_user.get(i).getOrderSource() != null
						&& !"".equals(order_list_distributor_user.get(i)
								.getOrderSource())) {
					switch (Integer.valueOf(order_list_distributor_user.get(i)
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
						.queryChildOrderItemsList(order_list_distributor_user
								.get(i).getOrderId());
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
						itemsDetail
								.setDiscountsMoney(Double.parseDouble(item
										.getPrice())
										* list_item.get(j).getNumber()
										- Double.parseDouble(order_list_distributor_user
												.get(i).getTotalPrice()));
						list_item_list.add(itemsDetail);
					}
					detailDO.setDetails(list_item_list);
				}
				// 8消费总额
				detailDO.setTotalMoney(Double
						.parseDouble(order_list_distributor_user.get(i)
								.getTotalPrice()));

				// 根据订单ID，查询各个的分成
				CommissionMoneyDO cmd = orderService
						.queryCommissionMoneyByOrderId(order_list_distributor_user
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
						.queryShopsDOById(order_list_distributor_user.get(i)
								.getSellerUserId());
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

			for (int i = 0; i < service_user_distributor.size(); i++) {

				if (service_user_distributor.get(i).getCreated() >= long_beginDate
						&& service_user_distributor.get(i).getCreated() <= long_endDate) {
					// 代表订单已经完成
					StatementHqDetailDO detailDO = new StatementHqDetailDO();
					// 1、用户信息
					detailDO.setUserId(buyUserId);
					// 2、订单编号
					detailDO.setOrderNum(service_user_distributor.get(i)
							.getOrderId());
					// 3、订单创建时间
					detailDO.setOrderCreatTime(service_user_distributor.get(i)
							.getCreated());
					// 4、购买渠道
					if (service_user_distributor.get(i).getOrderSource() != null
							&& !"".equals(service_user_distributor.get(i)
									.getOrderSource())) {
						switch (Integer.valueOf(service_user_distributor.get(i)
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
							.parseDouble(service_user_distributor.get(i)
									.getTotalPrice()));
					// 根据订单ID，查询各个的分成
					CommissionMoneyDO cmd = orderService
							.queryCommissionMoneyByOrderId(service_user_distributor
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
					ShopsDO shops = shopService
							.queryShopsDOById(service_user_distributor.get(i)
									.getSellerUserId());
					if (shops != null) {
						detailDO.setOthersName(shops.getShopsName());
					} else {
						detailDO.setOthersName("无数据");
					}
					list.add(detailDO);
				}
			}

			for (int i = 0; i < order_list_distributor_user.size(); i++) {

				if (order_list_distributor_user.get(i).getCreated() >= long_beginDate
						&& order_list_distributor_user.get(i).getCreated() <= long_endDate) {
					StatementHqDetailDO detailDO = new StatementHqDetailDO();

					detailDO.setUserId(buyUserId);
					// 2、设置订单编号
					detailDO.setOrderNum(order_list_distributor_user.get(i)
							.getOrderId());
					// 3、设置购买时间
					detailDO.setOrderCreatTime(order_list_distributor_user.get(
							i).getCreated());
					// 4、购买渠道
					if (order_list_distributor_user.get(i).getOrderSource() != null
							&& !"".equals(order_list_distributor_user.get(i)
									.getOrderSource())) {
						switch (Integer.valueOf(order_list_distributor_user
								.get(i).getOrderSource())) {
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
							.queryChildOrderItemsList(order_list_distributor_user
									.get(i).getOrderId());
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
							itemsDetail
									.setDiscountsMoney(Double.parseDouble(item
											.getPrice())
											* list_item.get(j).getNumber()
											- Double.parseDouble(order_list_distributor_user
													.get(i).getTotalPrice()));
							list_item_list.add(itemsDetail);
						}
						detailDO.setDetails(list_item_list);
					}
					// 8消费总额
					detailDO.setTotalMoney(Double
							.parseDouble(order_list_distributor_user.get(i)
									.getTotalPrice()));

					// 根据订单ID，查询各个的分成
					CommissionMoneyDO cmd = orderService
							.queryCommissionMoneyByOrderId(order_list_distributor_user
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
							.queryShopsDOById(order_list_distributor_user
									.get(i).getSellerUserId());
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
