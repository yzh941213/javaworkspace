package com.aishidai.app.controller;


import java.math.BigDecimal;
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

@RequestMapping(value="/manage/statemen")
@RestController
public class StatementHqController {

	private static final Logger logger = LoggerFactory.getLogger(StatementHqController.class);

	//报表的计算类
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
	 * 总部查看的总报表
	 */
	@RequestMapping(value = { "/hq/showStatemen" }, method = {RequestMethod.POST, RequestMethod.GET })
	public String showStatemenList(
			@RequestParam(value = "userId", required = true) long userId,
			@RequestParam(value="beginDate" ,required =false,defaultValue="") String beginDate,
			@RequestParam(value="endDate",required =false,defaultValue="") String endDate,
			@RequestParam(value="shopsId" ,required=false,defaultValue="0")long shopsId) throws Exception {
			
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		//获取注册用户总数
		List<UsersDO> result_users = usersService.queryAll();
		int users_count = result_users.size();
		jsonObject.put("users_count", users_count);
		//new日期对象
		//转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		//向前推24小时新增用户数量  
		int users_register_24H_count = 0;
		
		//通过日期类，将日期时间向前推一天
	    Calendar calendar = new GregorianCalendar();
	    calendar.setTime(new Date());
	    calendar.add(calendar.DATE,-1);
	    //现在的时间就是向前推一天的时间
	    String date_time = dateFormat.format(calendar.getTime());
		for (int i = 0; i < result_users.size(); i++) {
		    if (date_time.equals(dateFormat.format(result_users.get(i).getRegisterTime()))) {
		    	users_register_24H_count++;
			}
		}
		jsonObject.put("users_register_24H_count",users_register_24H_count );
		
		//商品消费总额
		double money_total_item = 0.0;
		List<TradeOrderDO> order_list = orderService.queryItems();
		
		for (int i = 0; i < order_list.size(); i++) {
				String item_price = order_list.get(i).getTotalPrice();
				money_total_item += Double.parseDouble(item_price);
		}
		
		jsonObject.put("money_total_item", money_total_item);
		
		//服务消费总额
		double money_total_service = 0.0;
		List<TradeOrderDO> service_list = orderService.queryService();
		for (int i = 0; i < service_list.size(); i++) {
			String service_price = service_list.get(i).getTotalPrice();
			money_total_service += Double.parseDouble(service_price);
		}
		jsonObject.put("money_total_service", money_total_service);
		//平台交易额
		double money_total_hq = 0.0;
		money_total_hq = money_total_service + money_total_item;
		jsonObject.put("money_total_hq", money_total_hq);
		
		
		//付费人员总人数
		int member_count = 0;
		List<MemberDO> member_List = usersService.queryMemberAll();
		for (MemberDO memberDO : member_List) {
			if (memberDO.getMemberType() == 0 ) {
				member_count++;
			}
		}
		jsonObject.put("member_count",member_count );
		
		List<StatementHqDO> list_detail = new ArrayList<StatementHqDO>();
		
		//查询的列表数据
		//先查询出全部的注册用户,上面已经完成，
		//下面遍历全部用户     result_users
		if (beginDate.equals("") || beginDate == null ||
				endDate.equals("") || endDate== null) {
			//代表正常查询,不进行筛选
			if (shopsId == 0) {
				for (int i = 0; i < result_users.size(); i++) {
					StatementHqDO shdo = new StatementHqDO();
					//1、设置用户ID
					shdo.setUserId(result_users.get(i).getUserId());
					//2、设置用户名
					if (result_users.get(i).getUnick() != null || !"".equals(result_users.get(i).getUnick())) {
						shdo.setMemberName(result_users.get(i).getUnick());
					}else{
						shdo.setMemberName("未设置");
					}
					//3、设置注册时间
					if (result_users.get(i).getRegisterTime() != null) {
						SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						shdo.setRegistertime(dft.format(result_users.get(i).getRegisterTime()));
					}else{
						shdo.setRegistertime(null);
					}
					//4、设置手机号
					if (result_users.get(i).getPhone() != null && !"".equals(result_users.get(i).getPhone())) {
						shdo.setUsername(result_users.get(i).getPhone());
					}else{
						shdo.setUsername("未填写");
					}
					//5、设置注册设备号
					shdo.setDeviceNum(result_users.get(i).getRegisterIp());
					//下面为设置用户的店铺和经销商
					DeviceDO device = deviceService.queryDeviceDOByProductNo(result_users.get(i).getRegisterIp());
					if (device != null) {
						//6.1   设置注册店铺   通过设备号查询到相关联的店铺
						ShopsDO shopsdo =shopService.queryShopsDOByDeviceId(device.getId());
						//6、2设置店铺名臣
						if (shopsdo != null) {
							if (shopsdo.getShopsName() != null && !"".equals(shopsdo.getShopsName())) {
								shdo.setRegisterShopName(shopsdo.getShopsName());
							}else{
								shdo.setRegisterShopName("无数据");
							}
							//7、1  设置所属经销商   根据经销商ID查询经销商名称
							DistributorDO distributorDO = distributorService.queryDistributorDOById(shopsdo.getDistributorId());
							//7、2 设置经销商名臣
							if (distributorDO.getName() != null && !"".equals(distributorDO.getName())) {
								shdo.setDistributorName(distributorDO.getName());
							}else{
								shdo.setDistributorName("无数据");
							}
						}else{
							shdo.setRegisterShopName("无数据");
							shdo.setDistributorName("无数据");
						}
					}else{
						shdo.setRegisterShopName("无数据");
						shdo.setDistributorName("无数据");
					}
					List<MakerDO> list_maker = new ArrayList<MakerDO>();
					//8、设置创客
					if (device != null) {
						List<DeviceMakerDO> deviceMaker_list = deviceMakerServiec.selectBydeviceId(device.getId());
						for (int j = 0; j < deviceMaker_list.size(); j++) {
							MakerDO maker = makerService.queryMakerDOById(deviceMaker_list.get(j).getMakerId());
							list_maker.add(maker);
						}
					}
					shdo.setMakers(list_maker);
					
					if (result_users.get(i).getMember() == 0) {
						shdo.setMemberType("不是会员");
					}else{
						MemberDO memberDO = usersService.queryMemberDOByUserId(result_users.get(i).getUserId());
						if (memberDO != null) {
							if (memberDO.getMemberType() == 0) {
								shdo.setMemberType("是");
							}else{
								shdo.setMemberType("否");
							}
						}else{
							shdo.setMemberType("否");
						}
					}
					
					//8、设置用户的商品消费额度
					double user_money_item = 0.0;
					//8.1先通过用户的ID查询出来，用户所有的商品订单
					List<TradeOrderDO> user_order_list_item = orderService.queryOrderByBuyerUserItem(result_users.get(i).getUserId());
					for (int j = 0; j < user_order_list_item.size(); j++) {
						user_money_item += Double.parseDouble(user_order_list_item.get(j).getTotalPrice());
					}
					shdo.setItemMoney(user_money_item);
					
					//9、设置用户的服务消费额
					//9.1、先通过用户的ID查询出来，用户所有的服务订单
					double user_money_service = 0.0;
					List<TradeOrderDO> user_order_list_service = orderService.queryOrderByBuyerUserService(result_users.get(i).getUserId());
					for (int k = 0; k < user_order_list_service.size();k++) {
						user_money_service += Double.parseDouble(user_order_list_service.get(k).getTotalPrice());
					}
					
					shdo.setServiceMoney(user_money_service);
					//设置用户总的消费额度
					shdo.setTotalMoney(user_money_service + user_money_item);
					list_detail.add(shdo);
				}
				double sorl_total_money = 0.0;
				
				for (int j = 0; j < list_detail.size(); j++) {
					sorl_total_money += list_detail.get(j).getTotalMoney();
				}
				
				jsonObject.put("sorl_total_money", sorl_total_money);
				jsonObject.put("list_detail", JSONObject.toJSON(list_detail));
				jsonObject.put("message", "查询成功");
				jsonObject.put("success", true);
			}else{//根据店铺进行赛选
				for (int i = 0; i < result_users.size(); i++) {
					DeviceDO device_ = deviceService.queryDeviceDOByProductNo(result_users.get(i).getRegisterIp());
					ShopsDO sdo = null;
					if (device_ != null) {
						//6、设置注册店铺
						//6.1通过设备号查询到相关联的店铺
						sdo = shopService.queryShopsDOByDeviceId(device_.getId());
					}
					if (sdo != null) {
						//如果传入的店铺的ID,和查出来的一样。
						if (shopsId == sdo.getShopsId()) {
							StatementHqDO shdo = new StatementHqDO();
							//1、设置用户ID
							shdo.setUserId(result_users.get(i).getUserId());
							//2、设置用户名
							if (result_users.get(i).getUnick() != null || !"".equals(result_users.get(i).getUnick())) {
								shdo.setMemberName(result_users.get(i).getUnick());
							}else{
								shdo.setMemberName("未设置");
							}
							//3、设置注册时间
							if (result_users.get(i).getRegisterTime() != null) {
								SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								shdo.setRegistertime(dft.format(result_users.get(i).getRegisterTime()));
							}else{
								shdo.setRegistertime(null);
							}
							//4、设置手机号
							if (result_users.get(i).getPhone() != null && !"".equals(result_users.get(i).getPhone())) {
								shdo.setUsername(result_users.get(i).getPhone());
							}else{
								shdo.setUsername("未填写");
							}
							//5、设置注册设备号
							shdo.setDeviceNum(result_users.get(i).getRegisterIp());
							//下面为设置用户的店铺和经销商
							DeviceDO device = deviceService.queryDeviceDOByProductNo(result_users.get(i).getRegisterIp());
							if (device != null) {
								//6.1   设置注册店铺   通过设备号查询到相关联的店铺
								ShopsDO shopsdo =shopService.queryShopsDOByDeviceId(device.getId());
								//6、2设置店铺名臣
								if (shopsdo != null) {
									if (shopsdo.getShopsName() != null && !"".equals(shopsdo.getShopsName())) {
										shdo.setRegisterShopName(shopsdo.getShopsName());
									}else{
										shdo.setRegisterShopName("无数据");
									}
									//7、1  设置所属经销商   根据经销商ID查询经销商名称
									DistributorDO distributorDO = distributorService.queryDistributorDOById(shopsdo.getDistributorId());
									//7、2 设置经销商名臣
									if (distributorDO.getName() != null && !"".equals(distributorDO.getName())) {
										shdo.setDistributorName(distributorDO.getName());
									}else{
										shdo.setDistributorName("无数据");
									}
								}else{
									shdo.setRegisterShopName("无数据");
									shdo.setDistributorName("无数据");
								}
							}else{
								shdo.setRegisterShopName("无数据");
								shdo.setDistributorName("无数据");
							}
							List<MakerDO> list_maker = new ArrayList<MakerDO>();
							//8、设置创客
							if (device != null) {
								List<DeviceMakerDO> deviceMaker_list = deviceMakerServiec.selectBydeviceId(device.getId());
								for (int j = 0; j < deviceMaker_list.size(); j++) {
									MakerDO maker = makerService.queryMakerDOById(deviceMaker_list.get(j).getMakerId());
									list_maker.add(maker);
								}
							}
							shdo.setMakers(list_maker);
							
							if (result_users.get(i).getMember() == 0) {
								shdo.setMemberType("不是会员");
							}else{
								MemberDO memberDO = usersService.queryMemberDOByUserId(result_users.get(i).getUserId());
								if (memberDO != null) {
									if (memberDO.getMemberType() == 0) {
										shdo.setMemberType("是");
									}else{
										shdo.setMemberType("否");
									}
								}else{
									shdo.setMemberType("否");
								}
							}
							//8、设置用户的商品消费额度
							double user_money_item = 0.0;
							//8.1先通过用户的ID查询出来，用户所有的商品订单
							List<TradeOrderDO> user_order_list_item = orderService.queryOrderByBuyerUserItem(result_users.get(i).getUserId());
							for (int j = 0; j < user_order_list_item.size(); j++) {
								user_money_item += Double.parseDouble(user_order_list_item.get(j).getTotalPrice());
							}
							shdo.setItemMoney(user_money_item);
							//9、设置用户的服务消费额
							//9.1、先通过用户的ID查询出来，用户所有的服务订单
							double user_money_service = 0.0;
							List<TradeOrderDO> user_order_list_service = orderService.queryOrderByBuyerUserService(result_users.get(i).getUserId());
							for (int k = 0; k < user_order_list_service.size();k++) {
								user_money_service += Double.parseDouble(user_order_list_service.get(k).getTotalPrice());
							}
							
							shdo.setServiceMoney(user_money_service);
							//设置用户总的消费额度
							shdo.setTotalMoney(user_money_service + user_money_item);
							list_detail.add(shdo);
						}
					}
				}
				double sorl_total_money = 0.0;
				
				for (int j = 0; j < list_detail.size(); j++) {
					sorl_total_money+=list_detail.get(j).getTotalMoney();
				}
				jsonObject.put("sorl_total_money", sorl_total_money);
				jsonObject.put("list_detail", JSONObject.toJSON(list_detail));
				jsonObject.put("message", "查询成功");
				jsonObject.put("success", true);
			}
			//输入的时间不为null
		}else{
			if (shopsId == 0) {
				Date date_beginDate = dateFormat.parse(beginDate);
				long long_beginDate = date_beginDate.getTime();
				Date date_endDate = dateFormat.parse(endDate);
				long long_endDate = date_endDate.getTime();
				
				for (int i = 0; i < result_users.size(); i++) {
					//将用户的注册时间转化为date类型
					Date date_registertime = result_users.get(i).getRegisterTime();
					long long_registertime = date_registertime.getTime();
					if (long_registertime >= long_beginDate && long_registertime <= long_endDate ) {
						StatementHqDO shdo = new StatementHqDO();
						//1、设置用户ID
						shdo.setUserId(result_users.get(i).getUserId());
						//2、设置用户名
						if (result_users.get(i).getUnick() != null || !"".equals(result_users.get(i).getUnick())) {
							shdo.setMemberName(result_users.get(i).getUnick());
						}else{
							shdo.setMemberName("未设置");
						}
						//3、设置注册时间
						if (result_users.get(i).getRegisterTime() != null) {
							SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							shdo.setRegistertime(dft.format(result_users.get(i).getRegisterTime()));
						}else{
							shdo.setRegistertime(null);
						}
						//4、设置手机号
						if (result_users.get(i).getPhone() != null && !"".equals(result_users.get(i).getPhone())) {
							shdo.setUsername(result_users.get(i).getPhone());
						}else{
							shdo.setUsername("未填写");
						}
						//5、设置注册设备号
						shdo.setDeviceNum(result_users.get(i).getRegisterIp());
						//下面为设置用户的店铺和经销商
						DeviceDO device = deviceService.queryDeviceDOByProductNo(result_users.get(i).getRegisterIp());
						if (device != null) {
							//6.1   设置注册店铺   通过设备号查询到相关联的店铺
							ShopsDO shopsdo =shopService.queryShopsDOByDeviceId(device.getId());
							//6、2设置店铺名臣
							if (shopsdo != null) {
								if (shopsdo.getShopsName() != null && !"".equals(shopsdo.getShopsName())) {
									shdo.setRegisterShopName(shopsdo.getShopsName());
								}else{
									shdo.setRegisterShopName("无数据");
								}
								//7、1  设置所属经销商   根据经销商ID查询经销商名称
								DistributorDO distributorDO = distributorService.queryDistributorDOById(shopsdo.getDistributorId());
								//7、2 设置经销商名臣
								if (distributorDO.getName() != null && !"".equals(distributorDO.getName())) {
									shdo.setDistributorName(distributorDO.getName());
								}else{
									shdo.setDistributorName("无数据");
								}
							}else{
								shdo.setRegisterShopName("无数据");
								shdo.setDistributorName("无数据");
							}
						}else{
							shdo.setRegisterShopName("无数据");
							shdo.setDistributorName("无数据");
						}
						List<MakerDO> list_maker = new ArrayList<MakerDO>();
						//8、设置创客
						if (device != null) {
							List<DeviceMakerDO> deviceMaker_list = deviceMakerServiec.selectBydeviceId(device.getId());
							for (int j = 0; j < deviceMaker_list.size(); j++) {
								MakerDO maker = makerService.queryMakerDOById(deviceMaker_list.get(j).getMakerId());
								list_maker.add(maker);
							}
						}
						shdo.setMakers(list_maker);
						
						if (result_users.get(i).getMember() == 0) {
							shdo.setMemberType("不是会员");
						}else{
							MemberDO memberDO = usersService.queryMemberDOByUserId(result_users.get(i).getUserId());
							if (memberDO != null) {
								if (memberDO.getMemberType() == 0) {
									shdo.setMemberType("是");
								}else{
									shdo.setMemberType("否");
								}
							}else{
								shdo.setMemberType("否");
							}
						}
						
						//8、设置用户的商品消费额度
						double user_money_item = 0.0;
						//8.1先通过用户的ID查询出来，用户所有的商品订单
						List<TradeOrderDO> user_order_list_item = orderService.queryOrderByBuyerUserItem(result_users.get(i).getUserId());
						for (int j = 0; j < user_order_list_item.size(); j++) {
							user_money_item += Double.parseDouble(user_order_list_item.get(j).getTotalPrice());
						}
						shdo.setItemMoney(user_money_item);
						
						//9、设置用户的服务消费额
						//9.1、先通过用户的ID查询出来，用户所有的服务订单
						double user_money_service = 0.0;
						List<TradeOrderDO> user_order_list_service = orderService.queryOrderByBuyerUserService(result_users.get(i).getUserId());
						for (int k = 0; k < user_order_list_service.size();k++) {
							user_money_service += Double.parseDouble(user_order_list_service.get(k).getTotalPrice());
						}
						
						shdo.setServiceMoney(user_money_service);
						//设置用户总的消费额度
						shdo.setTotalMoney(user_money_service + user_money_item);
						list_detail.add(shdo);
					}
				}
				double sorl_total_money = 0.0;
				
				for (int j = 0; j < list_detail.size(); j++) {
					sorl_total_money+=list_detail.get(j).getTotalMoney();
				}
				jsonObject.put("sorl_total_money", sorl_total_money);
				jsonObject.put("list_detail", JSONObject.toJSON(list_detail));
				jsonObject.put("message", "查询成功");
				jsonObject.put("success", true);
			}else{//根据时间及店铺进行赛选
				Date date_beginDate = dateFormat.parse(beginDate);
				long long_beginDate = date_beginDate.getTime();
				Date date_endDate = dateFormat.parse(endDate);
				long long_endDate = date_endDate.getTime();
				
				for (int i = 0; i < result_users.size(); i++) {
					//将用户的注册时间转化为date类型
					Date date_registertime = result_users.get(i).getRegisterTime();
					long long_registertime = date_registertime.getTime();
					if (long_registertime >= long_beginDate && long_registertime <= long_endDate ) {
						
						DeviceDO device_ = deviceService.queryDeviceDOByProductNo(result_users.get(i).getRegisterIp());
						ShopsDO sdo = null;
						if (device_ != null) {
							//6、设置注册店铺
							//6.1通过设备号查询到相关联的店铺
							sdo = shopService.queryShopsDOByDeviceId(device_.getId());
						}
						
						if (sdo != null && sdo.getShopsId()== shopsId) {
							StatementHqDO shdo = new StatementHqDO();
							//1、设置用户ID
							shdo.setUserId(result_users.get(i).getUserId());
							//2、设置用户名
							if (result_users.get(i).getUnick() != null || !"".equals(result_users.get(i).getUnick())) {
								shdo.setMemberName(result_users.get(i).getUnick());
							}else{
								shdo.setMemberName("未设置");
							}
							//3、设置注册时间
							if (result_users.get(i).getRegisterTime() != null) {
								SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								shdo.setRegistertime(dft.format(result_users.get(i).getRegisterTime()));
							}else{
								shdo.setRegistertime(null);
							}
							//4、设置手机号
							if (result_users.get(i).getPhone() != null && !"".equals(result_users.get(i).getPhone())) {
								shdo.setUsername(result_users.get(i).getPhone());
							}else{
								shdo.setUsername("未填写");
							}
							//5、设置注册设备号
							shdo.setDeviceNum(result_users.get(i).getRegisterIp());
							//下面为设置用户的店铺和经销商
							DeviceDO device = deviceService.queryDeviceDOByProductNo(result_users.get(i).getRegisterIp());
							if (device != null) {
								//6.1   设置注册店铺   通过设备号查询到相关联的店铺
								ShopsDO shopsdo =shopService.queryShopsDOByDeviceId(device.getId());
								//6、2设置店铺名臣
								if (shopsdo != null) {
									if (shopsdo.getShopsName() != null && !"".equals(shopsdo.getShopsName())) {
										shdo.setRegisterShopName(shopsdo.getShopsName());
									}else{
										shdo.setRegisterShopName("无数据");
									}
									//7、1  设置所属经销商   根据经销商ID查询经销商名称
									DistributorDO distributorDO = distributorService.queryDistributorDOById(shopsdo.getDistributorId());
									//7、2 设置经销商名臣
									if (distributorDO.getName() != null && !"".equals(distributorDO.getName())) {
										shdo.setDistributorName(distributorDO.getName());
									}else{
										shdo.setDistributorName("无数据");
									}
								}else{
									shdo.setRegisterShopName("无数据");
									shdo.setDistributorName("无数据");
								}
							}else{
								shdo.setRegisterShopName("无数据");
								shdo.setDistributorName("无数据");
							}
							List<MakerDO> list_maker = new ArrayList<MakerDO>();
							//8、设置创客
							if (device != null) {
								List<DeviceMakerDO> deviceMaker_list = deviceMakerServiec.selectBydeviceId(device.getId());
								for (int j = 0; j < deviceMaker_list.size(); j++) {
									MakerDO maker = makerService.queryMakerDOById(deviceMaker_list.get(j).getMakerId());
									list_maker.add(maker);
								}
							}
							shdo.setMakers(list_maker);
							
							if (result_users.get(i).getMember() == 0) {
								shdo.setMemberType("不是会员");
							}else{
								MemberDO memberDO = usersService.queryMemberDOByUserId(result_users.get(i).getUserId());
								if (memberDO != null) {
									if (memberDO.getMemberType() == 0) {
										shdo.setMemberType("是");
									}else{
										shdo.setMemberType("否");
									}
								}else{
									shdo.setMemberType("否");
								}
							}
							
							//8、设置用户的商品消费额度
							double user_money_item = 0.0;
							//8.1先通过用户的ID查询出来，用户所有的商品订单
							List<TradeOrderDO> user_order_list_item = orderService.queryOrderByBuyerUserItem(result_users.get(i).getUserId());
							for (int j = 0; j < user_order_list_item.size(); j++) {
								user_money_item += Double.parseDouble(user_order_list_item.get(j).getTotalPrice());
							}
							shdo.setItemMoney(user_money_item);
							
							//9、设置用户的服务消费额
							//9.1、先通过用户的ID查询出来，用户所有的服务订单
							double user_money_service = 0.0;
							List<TradeOrderDO> user_order_list_service = orderService.queryOrderByBuyerUserService(result_users.get(i).getUserId());
							for (int k = 0; k < user_order_list_service.size();k++) {
								user_money_service += Double.parseDouble(user_order_list_service.get(k).getTotalPrice());
							}
							
							shdo.setServiceMoney(user_money_service);
							//设置用户总的消费额度
							shdo.setTotalMoney(user_money_service + user_money_item);
							list_detail.add(shdo);
							}
						double sorl_total_money = 0.0;
						
						for (int j = 0; j < list_detail.size(); j++) {
							sorl_total_money+=list_detail.get(j).getTotalMoney();
						}
						jsonObject.put("sorl_total_money", sorl_total_money);
						jsonObject.put("list_detail", JSONObject.toJSON(list_detail));
						jsonObject.put("message", "查询成功");
						jsonObject.put("success", true);
					}
				}
			}
		}
		return jsonObject.toString();
	}
	
	/**
	 * 总部查看用户消费详情
	 */
	@RequestMapping(value = { "/hq/showStatemenDetail" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	public String showStatemenDetailList(
			@RequestParam(value = "userId", required = true) long userId,
			@RequestParam(value = "buyUserId", required = true) long buyUserId,
			@RequestParam(value = "beginDate", required = false, defaultValue = "") String beginDate,
			@RequestParam(value = "endDate", required = false, defaultValue = "") String endDate)
			throws Exception {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);

		List<StatementHqDetailDO> list = new ArrayList<StatementHqDetailDO>();

		// 拿着购买人ID，从数据库中查出该用户所有的商品订单
		List<TradeOrderDO> list_order_by_buyUser = orderService
				.queryOrderByBuyerUserItem(buyUserId);
		List<TradeOrderDO> list_service_by_buyUser = orderService
				.queryOrderByBuyerUserService(buyUserId);
		// 不根据时间查询
		if (beginDate.equals("") || beginDate == null || endDate.equals("")
				|| endDate == null) {

			for (int i = 0; i < list_service_by_buyUser.size(); i++) {
				StatementHqDetailDO detailDO = new StatementHqDetailDO();
				// 1、用户信息
				detailDO.setUserId(buyUserId);
				// 2、订单编号
				detailDO.setOrderNum(list_service_by_buyUser.get(i)
						.getOrderId());
				// 3、订单创建时间
				detailDO.setOrderCreatTime(list_service_by_buyUser.get(i)
						.getCreated());
				// 4、购买渠道
				if (list_service_by_buyUser.get(i).getOrderSource() != null
						&& !"".equals(list_service_by_buyUser.get(i)
								.getOrderSource())) {
					switch (Integer.valueOf(list_service_by_buyUser.get(i)
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
						.parseDouble(list_service_by_buyUser.get(i)
								.getTotalPrice()));
				// 根据订单ID，查询各个的分成
				CommissionMoneyDO cmd = orderService
						.queryCommissionMoneyByOrderId(list_service_by_buyUser
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
						.queryShopsDOById(list_service_by_buyUser.get(i)
								.getSellerUserId());
				if (shops != null) {
					detailDO.setOthersName(shops.getShopsName());
				} else {
					detailDO.setOthersName("无数据");
				}
				list.add(detailDO);
			}

			for (int i = 0; i < list_order_by_buyUser.size(); i++) {
				StatementHqDetailDO detailDO = new StatementHqDetailDO();

				detailDO.setUserId(buyUserId);
				// 2、设置订单编号
				detailDO.setOrderNum(list_order_by_buyUser.get(i).getOrderId());
				// 3、设置购买时间
				detailDO.setOrderCreatTime(list_order_by_buyUser.get(i)
						.getCreated());
				// 4、购买渠道
				if (list_order_by_buyUser.get(i).getOrderSource() != null
						&& !"".equals(list_order_by_buyUser.get(i)
								.getOrderSource())) {
					switch (Integer.valueOf(list_order_by_buyUser.get(i)
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
						.queryChildOrderItemsList(list_order_by_buyUser.get(i)
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
								- Double.parseDouble(list_order_by_buyUser.get(
										i).getTotalPrice()));
						list_item_list.add(itemsDetail);
					}
					detailDO.setDetails(list_item_list);
				}
				// 8消费总额
				detailDO.setTotalMoney(Double.parseDouble(list_order_by_buyUser
						.get(i).getTotalPrice()));

				// 根据订单ID，查询各个的分成
				CommissionMoneyDO cmd = orderService
						.queryCommissionMoneyByOrderId(list_order_by_buyUser
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
						.queryShopsDOById(list_order_by_buyUser.get(i)
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
			for (int i = 0; i < list_service_by_buyUser.size(); i++) {
				if (list_service_by_buyUser.get(i).getCreated() >= long_beginDate
						&& list_service_by_buyUser.get(i).getCreated() <= long_endDate) {
					StatementHqDetailDO detailDO = new StatementHqDetailDO();
					// 1、用户信息
					detailDO.setUserId(buyUserId);
					// 2、订单编号
					detailDO.setOrderNum(list_service_by_buyUser.get(i)
							.getOrderId());
					// 3、订单创建时间
					detailDO.setOrderCreatTime(list_service_by_buyUser.get(i)
							.getCreated());
					// 4、购买渠道
					if (list_service_by_buyUser.get(i).getOrderSource() != null
							&& !"".equals(list_service_by_buyUser.get(i)
									.getOrderSource())) {
						switch (Integer.valueOf(list_service_by_buyUser.get(i)
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
							.parseDouble(list_service_by_buyUser.get(i)
									.getTotalPrice()));
					// 根据订单ID，查询各个的分成
					CommissionMoneyDO cmd = orderService
							.queryCommissionMoneyByOrderId(list_service_by_buyUser
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
							.queryShopsDOById(list_service_by_buyUser.get(i)
									.getSellerUserId());
					if (shops != null) {
						detailDO.setOthersName(shops.getShopsName());
					} else {
						detailDO.setOthersName("无数据");
					}
					list.add(detailDO);
				}
			}

			for (int i = 0; i < list_order_by_buyUser.size(); i++) {

				if (list_order_by_buyUser.get(i).getCreated() >= long_beginDate
						&& list_order_by_buyUser.get(i).getCreated() <= long_endDate) {
					StatementHqDetailDO detailDO = new StatementHqDetailDO();

					detailDO.setUserId(buyUserId);
					// 2、设置订单编号
					detailDO.setOrderNum(list_order_by_buyUser.get(i)
							.getOrderId());
					// 3、设置购买时间
					detailDO.setOrderCreatTime(list_order_by_buyUser.get(i)
							.getCreated());
					// 4、购买渠道
					if (list_order_by_buyUser.get(i).getOrderSource() != null
							&& !"".equals(list_order_by_buyUser.get(i)
									.getOrderSource())) {
						switch (Integer.valueOf(list_order_by_buyUser.get(i)
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
							.queryChildOrderItemsList(list_order_by_buyUser
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
							itemsDetail.setDiscountsMoney(Double
									.parseDouble(item.getPrice())
									* list_item.get(j).getNumber()
									- Double.parseDouble(list_order_by_buyUser
											.get(i).getTotalPrice()));
							list_item_list.add(itemsDetail);
						}
						detailDO.setDetails(list_item_list);
					}
					// 8消费总额
					detailDO.setTotalMoney(Double
							.parseDouble(list_order_by_buyUser.get(i)
									.getTotalPrice()));

					// 根据订单ID，查询各个的分成
					CommissionMoneyDO cmd = orderService
							.queryCommissionMoneyByOrderId(list_order_by_buyUser
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
							.queryShopsDOById(list_order_by_buyUser.get(i)
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
		//jsonObject.toJSON
		return jsonObject.toJSONString();
	}
}
