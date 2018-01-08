package com.zhezhuo.web.home.module.screen.manager;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import com.zhezhuo.biz.dao.TradeOrderDAO;
import com.zhezhuo.biz.manager.DeviceManager;
import com.zhezhuo.biz.manager.DistributorManager;
import com.zhezhuo.biz.manager.ItemManager;
import com.zhezhuo.biz.manager.MakerManager;
import com.zhezhuo.biz.manager.ShopManager;
import com.zhezhuo.biz.manager.TradeOrderManager;
import com.zhezhuo.biz.manager.UsersManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.CommissionMoneyDO;
import com.zhezhuo.model.entity.DeviceDO;
import com.zhezhuo.model.entity.DeviceMakerDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.ItemDO;
import com.zhezhuo.model.entity.ItemsDetail;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.entity.MemberDO;
import com.zhezhuo.model.entity.ServicesOrdersDO;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.entity.StatementHqDO;
import com.zhezhuo.model.entity.StatementHqDetailDO;
import com.zhezhuo.model.entity.TradeOrderDO;
import com.zhezhuo.model.entity.UsersDO;
import com.zhezhuo.model.query.DeviceMakerQuery;
import com.zhezhuo.model.query.MemberQuery;
import com.zhezhuo.model.query.ServicesOrdersQuery;
import com.zhezhuo.model.query.TradeOrderQuery;
import com.zhezhuo.model.query.UsersQuery;

@RequestMapping(value="/statemen/hq")
@Controller
public class StatementHqController {

	private static final Logger logger = LoggerFactory.getLogger(StatementHqController.class);

	//报表的计算类
	@Autowired
	private UsersManager usersManager;
	@Autowired
	private TradeOrderManager tradeOrderManager;
	@Autowired
	private ShopManager shopManager; 
	@Autowired
	private DistributorManager distributorManager;
	@Autowired
	private MakerManager makerManager;
	@Autowired
	private TradeOrderDAO tradeOrderDAO;
	@Autowired
	private ItemManager itemManager;
	@Autowired
	private DeviceManager deviceManager;
	
	/**
	 * 总部查看的总报表
	 */
	@RequestMapping(value = { "/showStatemen.do" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String showStatemenList(
			@RequestParam(value = "sYSUserId", required = true) long sYSUserId,
			@RequestParam(value="beginDate" ,required =false,defaultValue="") String beginDate,
			@RequestParam(value="endDate",required =false,defaultValue="") String endDate,
			@RequestParam(value="shopId" ,required=false,defaultValue="0")long shopId) throws Exception {
			
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		//获取注册用户总数
		UsersQuery query = new UsersQuery();
				
		List<UsersDO> result_users = usersManager.queryUserDOlist(query);
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
	    System.out.println(date_time);
	    
		for (int i = 0; i < result_users.size(); i++) {
		    String register_time = result_users.get(i).getRegistertime();
		    String[] register_date =  register_time.split(" ");
		    String year_time = register_date[0];
		    if (date_time.equals(year_time)) {
		    	users_register_24H_count++;
			}
		}
		
		jsonObject.put("users_register_24H_count",users_register_24H_count );
		
		//商品消费总额
		double money_total_shops = 0.0;
		List<TradeOrderDO> tradeOrderDO_list = tradeOrderManager.queryTraderOrderList();
		
		for (int i = 0; i < tradeOrderDO_list.size(); i++) {
			if (tradeOrderDO_list.get(i).getLevel() == 0 && tradeOrderDO_list.get(i).getStatus() == 4) {
				String price = tradeOrderDO_list.get(i).getPrice();
				money_total_shops += Double.parseDouble(price);
			}
		}
		
		jsonObject.put("money_total_shops", money_total_shops);
		
		//服务消费总额
		double money_total_service = 0.0;
		List<ServicesOrdersDO> servicesOrdersDO_list = tradeOrderDAO.selectServicesOrederDOList();
		
		for (int i = 0; i < servicesOrdersDO_list.size(); i++) {
			//只统计已经完成的订单
			if (servicesOrdersDO_list.get(i).getStatus() == 2) {
				String price = servicesOrdersDO_list.get(i).getPrice();
				money_total_service += Double.parseDouble(price);
			}
		}
		jsonObject.put("money_total_service", money_total_service);
		//平台交易额
		double money_total_hq = 0.0;
		money_total_hq = money_total_service+money_total_shops;
		jsonObject.put("money_total_hq", money_total_hq);
		
		
		//付费人员总人数
		int member_count = 0;
		MemberQuery memberQuery = new MemberQuery();
		List<MemberDO> memberDOList = usersManager.queryMemberList(memberQuery);
		for (MemberDO memberDO : memberDOList) {
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
			if (shopId == 0) {
				for (int i = 0; i < result_users.size(); i++) {
					StatementHqDO shdo = new StatementHqDO();
					//1、设置用户ID
					shdo.setUserId(result_users.get(i).getUserId());
					//2、设置用户名
					shdo.setMemberName(result_users.get(i).getUnick());
					//3、设置注册时间
					shdo.setRegistertime(result_users.get(i).getRegistertime());
					//4、设置手机号
					shdo.setUsername(result_users.get(i).getUsername() == null?"无":result_users.get(i).getUsername());
					//5、设置注册设备号
					shdo.setDeviceNum(result_users.get(i).getRegisterip());
					
					Result<DeviceDO> list_result_device = deviceManager.queryDeviceDOByProductNo(result_users.get(i).getRegisterip());
					
					if (list_result_device.getResult() != null) {
						//6、设置注册店铺
						//6.1通过设备号查询到相关联的店铺
						ShopDO shopdo =shopManager.queryByDeviceId(list_result_device.getResult().getId());
						//6、2设置店铺名臣
						if (shopdo != null) {
							shdo.setRegisterShopName(shopdo.getShopsName());
							//7、设置所属经销商
							//7、1根据经销商ID查询经销商名称
							Result<DistributorDO> result_distributorDO = distributorManager.queryDistributorDOById(shopdo.getDistributorId());
							//7、2设置经销商名臣
							shdo.setDistributorName(result_distributorDO.getResult().getName());
						}else{
							shdo.setRegisterShopName("无");
							shdo.setDistributorName("无");
						}
					}else{
						shdo.setRegisterShopName("无");
						shdo.setDistributorName("无");
					}
					List<MakerDO> list_maker = new ArrayList<MakerDO>();
					//8、设置创客
					Result<DeviceDO> result_device = list_result_device;
					if (result_device.getResult() != null) {
						DeviceMakerQuery query_maker = new DeviceMakerQuery();
						query_maker.setDeviceId(result_device.getResult().getId());
						List<DeviceMakerDO> queryDeviceMaker_list = makerManager.queryDeviceMaker(query_maker);
						for (int j = 0; j < queryDeviceMaker_list.size(); j++) {
							Result<MakerDO> maker = makerManager.queryMakerDOById(queryDeviceMaker_list.get(j).getMakerId());
							list_maker.add(maker.getResult());
						}
					}
					shdo.setMakers(list_maker);
					
					if (result_users.get(i).getMember() == 0) {
						shdo.setMemberType("不是会员");
					}else{
						MemberDO memberDO = usersManager.queryMemberDOByUserId(result_users.get(i).getUserId());
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
					
					//8、
					double user_money_shops = 0.0;
					//8.1先通过用户的ID查询出来，用户所有的商品订单
					TradeOrderQuery orderQuery = new TradeOrderQuery();
					orderQuery.setBuyerUserId((long)result_users.get(i).getUserId());
					List<TradeOrderDO> traderOrder_list = tradeOrderManager.queryTraderOrder(orderQuery);
					
					for (int j = 0; j < traderOrder_list.size(); j++) {
						if (traderOrder_list.get(j).getStatus() == 4) {
							user_money_shops += Double.parseDouble(traderOrder_list.get(j).getPrice());
						}
					}
					
					shdo.setShopsMoney(user_money_shops);
					//9、设置用户的服务消费额
					//9.1、先通过用户的ID查询出来，用户所有的服务订单
					double user_money_services = 0.0;
					ServicesOrdersQuery serviceQuery = new ServicesOrdersQuery();
					serviceQuery.setBuyerUserId((long)result_users.get(i).getUserId());
					List<ServicesOrdersDO> ServicesOrders_list = tradeOrderManager.queryServicesOrdersDO(serviceQuery);
					for (int k = 0; k < ServicesOrders_list.size();k++) {
						if (ServicesOrders_list.get(k).getStatus() == 2) {
							user_money_services += Double.parseDouble(ServicesOrders_list.get(k).getPrice());
						}
					}
					
					shdo.setServiceMoney(user_money_services);
					//设置用户总的消费额度
					shdo.setTotalMoney(user_money_services+user_money_shops);
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
			}else{//根据店铺进行赛选
				for (int i = 0; i < result_users.size(); i++) {
					Result<DeviceDO> list_result_device = deviceManager.queryDeviceDOByProductNo(result_users.get(i).getRegisterip());
					ShopDO shopdo = null;
					if (list_result_device.getResult() != null) {
						//6、设置注册店铺
						//6.1通过设备号查询到相关联的店铺
						shopdo = shopManager.queryByDeviceId(list_result_device.getResult().getId());
					}
					if (shopdo != null) {
						//如果传入的店铺的ID,和查出来的一样。
						if (shopId == shopdo.getShopsId()) {
							StatementHqDO shdo = new StatementHqDO();
							//1、设置用户ID
							shdo.setUserId(result_users.get(i).getUserId());
							//2、设置用户名
							shdo.setMemberName(result_users.get(i).getUnick());
							//3、设置注册时间
							shdo.setRegistertime(result_users.get(i).getRegistertime());
							//4、设置手机号
							shdo.setUsername(result_users.get(i).getUsername() == null?"无":result_users.get(i).getUsername());
							//5、设置注册设备号
							shdo.setDeviceNum(result_users.get(i).getRegisterip());
							//6、设置注册店铺
							//6.1通过设备号查询到相关联的店铺
							//6、2设置店铺名臣
							shdo.setRegisterShopName(shopdo.getShopsName());
							//7、设置所属经销商
							//7、1根据经销商ID查询经销商名称
							Result<DistributorDO> result_distributorDO = distributorManager.queryDistributorDOById(shopdo.getDistributorId());
							//7、2设置经销商名臣
							shdo.setDistributorName(result_distributorDO.getResult().getName() == null?"无":result_distributorDO.getResult().getName());
							
							List<MakerDO> list_maker = new ArrayList<MakerDO>();
							//8、设置创客
							Result<DeviceDO> result_device = deviceManager.queryDeviceDOByProductNo(result_users.get(i).getRegisterip());
							if (result_device.getResult() != null) {
								DeviceMakerQuery query_maker = new DeviceMakerQuery();
								query_maker.setDeviceId(result_device.getResult().getId());
								List<DeviceMakerDO> queryDeviceMaker_list = makerManager.queryDeviceMaker(query_maker);
								for (int j = 0; j < queryDeviceMaker_list.size(); j++) {
									Result<MakerDO> maker = makerManager.queryMakerDOById(queryDeviceMaker_list.get(j).getMakerId());
									list_maker.add(maker.getResult());
								}
							}
							shdo.setMakers(list_maker);
							if (result_users.get(i).getMember() == 0) {
								shdo.setMemberType("不是会员");
							}else{
								MemberDO memberDO = usersManager.queryMemberDOByUserId(result_users.get(i).getUserId());
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
							//8、设置用户的消费服务总额
							double user_money_shops = 0.0;
							//8.1先通过用户的ID查询出来，用户所有的商品订单
							TradeOrderQuery orderQuery = new TradeOrderQuery();
							orderQuery.setBuyerUserId(Long.valueOf(result_users.get(i).getUserId()));
							List<TradeOrderDO> traderOrder_list = tradeOrderManager.queryTraderOrder(orderQuery);
							
							for (int j = 0; j < traderOrder_list.size(); j++) {
								if (traderOrder_list.get(j).getStatus() == 4) {
									user_money_shops += Double.parseDouble(traderOrder_list.get(j).getPrice());
								}
							}
							
							shdo.setShopsMoney(user_money_shops);
							//9、设置用户的服务消费额
							//9.1、先通过用户的ID查询出来，用户所有的服务订单
							double user_money_services = 0.0;
							ServicesOrdersQuery serviceQuery = new ServicesOrdersQuery();
							serviceQuery.setBuyerUserId(Long.valueOf(result_users.get(i).getUserId()));
							List<ServicesOrdersDO> ServicesOrders_list = tradeOrderManager.queryServicesOrdersDO(serviceQuery);
							
							for (int k = 0; k < ServicesOrders_list.size();k++) {
								if (ServicesOrders_list.get(k).getStatus() == 2) {
									user_money_services += Double.parseDouble(ServicesOrders_list.get(k).getPrice());
								}
							}
							
							shdo.setServiceMoney(user_money_services);
							//设置用户总的消费额度
							shdo.setTotalMoney(user_money_services+user_money_shops);
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
			if (shopId == 0) {
				Date date_beginDate = dateFormat.parse(beginDate);
				long long_beginDate = date_beginDate.getTime();
				Date date_endDate = dateFormat.parse(endDate);
				long long_endDate = date_endDate.getTime();
				
				for (int i = 0; i < result_users.size(); i++) {
					//将用户的注册时间转化为date类型
					Date date_registertime = dateFormat.parse(result_users.get(i).getRegistertime());
					long long_registertime = date_registertime.getTime();
					if (long_registertime >= long_beginDate && long_registertime <= long_endDate ) {
						StatementHqDO shdo = new StatementHqDO();
						//1、设置用户ID
						shdo.setUserId(result_users.get(i).getUserId());
						//2、设置用户名
						shdo.setMemberName(result_users.get(i).getUnick());
						//3、设置注册时间
						shdo.setRegistertime(result_users.get(i).getRegistertime());
						//4、设置手机号
						shdo.setUsername(result_users.get(i).getUsername() == null?"无":result_users.get(i).getUsername());
						//5、设置注册设备号
						shdo.setDeviceNum(result_users.get(i).getRegisterip());
						//6、设置注册店铺
						Result<DeviceDO> list_result_device = deviceManager.queryDeviceDOByProductNo(result_users.get(i).getRegisterip());
						
						if (list_result_device.getResult() != null) {
							//6、设置注册店铺
							//6.1通过设备号查询到相关联的店铺
							ShopDO shopdo =shopManager.queryByDeviceId(list_result_device.getResult().getId());
							//6、2设置店铺名臣
							if (shopdo != null) {
								shdo.setRegisterShopName(shopdo.getShopsName());
								//7、设置所属经销商
								//7、1根据经销商ID查询经销商名称
								Result<DistributorDO> result_distributorDO = distributorManager.queryDistributorDOById(shopdo.getDistributorId());
								//7、2设置经销商名臣
								shdo.setDistributorName(result_distributorDO.getResult().getName());
							}else{
								shdo.setRegisterShopName("无");
								shdo.setDistributorName("无");
							}
						}else{
							shdo.setRegisterShopName("无");
							shdo.setDistributorName("无");
						}
						List<MakerDO> list_maker = new ArrayList<MakerDO>();
						//8、设置创客
						Result<DeviceDO> result_device = deviceManager.queryDeviceDOByProductNo(result_users.get(i).getRegisterip());
						if (result_device.getResult() != null) {
							DeviceMakerQuery query_maker = new DeviceMakerQuery();
							query_maker.setDeviceId(result_device.getResult().getId());
							List<DeviceMakerDO> queryDeviceMaker_list = makerManager.queryDeviceMaker(query_maker);
							for (int j = 0; j < queryDeviceMaker_list.size(); j++) {
								Result<MakerDO> maker = makerManager.queryMakerDOById(queryDeviceMaker_list.get(j).getMakerId());
								list_maker.add(maker.getResult());
							}
						}
						shdo.setMakers(list_maker);
						if (result_users.get(i).getMember() == 0) {
							shdo.setMemberType("不是会员");
						}else{
							MemberDO memberDO = usersManager.queryMemberDOByUserId(result_users.get(i).getUserId());
							if (memberDO != null) {
								if (memberDO.getMemberType() == 0) {
									shdo.setMemberType("是");
								}else{
									shdo.setMemberType("否");
								}
							}
						}
						//8、设置用户的消费服务总额
						double user_money_shops = 0.0;
						//8.1先通过用户的ID查询出来，用户所有的商品订单
						TradeOrderQuery orderQuery = new TradeOrderQuery();
						orderQuery.setBuyerUserId(Long.valueOf(result_users.get(i).getUserId()));
						List<TradeOrderDO> traderOrder_list = tradeOrderManager.queryTraderOrder(orderQuery);
						
						for (int j = 0; j < traderOrder_list.size(); j++) {
							if (traderOrder_list.get(j).getStatus() == 4) {
								user_money_shops += Double.parseDouble(traderOrder_list.get(j).getPrice());
							}
						}
						
						shdo.setShopsMoney(user_money_shops);
						//9、设置用户的服务消费额
						//9.1、先通过用户的ID查询出来，用户所有的服务订单
						double user_money_services = 0.0;
						ServicesOrdersQuery serviceQuery = new ServicesOrdersQuery();
						serviceQuery.setBuyerUserId(Long.valueOf(result_users.get(i).getUserId()));
						List<ServicesOrdersDO> ServicesOrders_list = tradeOrderManager.queryServicesOrdersDO(serviceQuery);
						
						for (int k = 0; k < ServicesOrders_list.size();k++) {
							if (ServicesOrders_list.get(k).getStatus() == 2) {
								user_money_services += Double.parseDouble(ServicesOrders_list.get(k).getPrice());
							}
						}
						
						shdo.setServiceMoney(user_money_services);
						//设置用户总的消费额度
						shdo.setTotalMoney(user_money_services+user_money_shops);
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
					Date date_registertime = dateFormat.parse(result_users.get(i).getRegistertime());
					long long_registertime = date_registertime.getTime();
					if (long_registertime >=long_beginDate && long_registertime <= long_endDate ) {
						
						Result<DeviceDO> list_result_device = deviceManager.queryDeviceDOByProductNo(result_users.get(i).getRegisterip());
						ShopDO shopdo = null;
						if (list_result_device.getResult() != null) {
							//6、设置注册店铺
							//6.1通过设备号查询到相关联的店铺
							shopdo = shopManager.queryByDeviceId(list_result_device.getResult().getId());
						}
						
						if (shopdo != null && shopdo.getShopsId()== shopId) {
							StatementHqDO shdo = new StatementHqDO();
							//1、设置用户ID
							shdo.setUserId(result_users.get(i).getUserId());
							//2、设置用户名
							shdo.setMemberName(result_users.get(i).getUnick());
							//3、设置注册时间
							shdo.setRegistertime(result_users.get(i).getRegistertime());
							//4、设置手机号
							shdo.setUsername(result_users.get(i).getUsername() == null?"无":result_users.get(i).getUsername());
							//5、设置注册设备号
							shdo.setDeviceNum(result_users.get(i).getRegisterip());
							//6、设置注册店铺
							//6.1通过设备号查询到相关联的店铺
							//6、2设置店铺名臣
							shdo.setRegisterShopName(shopdo.getShopsName());
							//7、设置所属经销商
							//7、1根据经销商ID查询经销商名称
							Result<DistributorDO> result_distributorDO = distributorManager.queryDistributorDOById(shopdo.getDistributorId());
							//7、2设置经销商名臣
							shdo.setDistributorName(result_distributorDO.getResult().getName() == null?"无":result_distributorDO.getResult().getName());
							
							List<MakerDO> list_maker = new ArrayList<MakerDO>();
							//8、设置创客
							Result<DeviceDO> result_device = deviceManager.queryDeviceDOByProductNo(result_users.get(i).getRegisterip());
							if (result_device.getResult() != null) {
								DeviceMakerQuery query_maker = new DeviceMakerQuery();
								query_maker.setDeviceId(result_device.getResult().getId());
								List<DeviceMakerDO> queryDeviceMaker_list = makerManager.queryDeviceMaker(query_maker);
								for (int j = 0; j < queryDeviceMaker_list.size(); j++) {
									Result<MakerDO> maker = makerManager.queryMakerDOById(queryDeviceMaker_list.get(j).getMakerId());
									list_maker.add(maker.getResult());
								}
							}
							shdo.setMakers(list_maker);
							if (result_users.get(i).getMember() == 0) {
								shdo.setMemberType("不是会员");
							}else{
								MemberDO memberDO = usersManager.queryMemberDOByUserId(result_users.get(i).getUserId());
								if (memberDO != null) {
									if (memberDO.getMemberType() == 0) {
										shdo.setMemberType("是");
									}else{
										shdo.setMemberType("否");
									}
								}
							}
							//8、设置用户的消费服务总额
							double user_money_shops = 0.0;
							//8.1先通过用户的ID查询出来，用户所有的商品订单
							TradeOrderQuery orderQuery = new TradeOrderQuery();
							orderQuery.setBuyerUserId(Long.valueOf(result_users.get(i).getUserId()));
							List<TradeOrderDO> traderOrder_list = tradeOrderManager.queryTraderOrder(orderQuery);
							
							for (int j = 0; j < traderOrder_list.size(); j++) {
								if (traderOrder_list.get(j).getStatus() == 4) {
									user_money_shops += Double.parseDouble(traderOrder_list.get(j).getPrice());
								}
							}
							
							shdo.setShopsMoney(user_money_shops);
							//9、设置用户的服务消费额
							//9.1、先通过用户的ID查询出来，用户所有的服务订单
							double user_money_services = 0.0;
							ServicesOrdersQuery serviceQuery = new ServicesOrdersQuery();
							serviceQuery.setBuyerUserId(Long.valueOf(result_users.get(i).getUserId()));
							List<ServicesOrdersDO> ServicesOrders_list = tradeOrderManager.queryServicesOrdersDO(serviceQuery);
							
							for (int k = 0; k < ServicesOrders_list.size();k++) {
								if (ServicesOrders_list.get(k).getStatus() == 2) {
									user_money_services += Double.parseDouble(ServicesOrders_list.get(k).getPrice());
								}
							}
							
							shdo.setServiceMoney(user_money_services);
							//设置用户总的消费额度
							shdo.setTotalMoney(user_money_services+user_money_shops);
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
	@RequestMapping(value = { "/showStatemenDetail.do" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String showStatemenDetailList(
			@RequestParam(value = "sYSUserId", required = true) long sYSUserId,
			@RequestParam(value="buyUserId",required = true) long buyUserId,
			@RequestParam(value="beginDate" ,required =false,defaultValue="") String beginDate,
			@RequestParam(value="endDate",required =false,defaultValue="") String endDate) throws Exception{
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);	
		
		List<StatementHqDetailDO> list = new ArrayList<StatementHqDetailDO>();
		
		TradeOrderQuery query = new TradeOrderQuery();
		query.setBuyerUserId(buyUserId);
		ServicesOrdersQuery serviceQuery = new ServicesOrdersQuery();
		serviceQuery.setBuyerUserId(buyUserId);
		//拿着购买人ID，打破数据库中查出该用户所有的商品订单
		List<TradeOrderDO> list_order_by_buyUser = tradeOrderManager.queryTraderOrder(query);
		List<ServicesOrdersDO> list_serviceOrder_by_buyUser = tradeOrderManager.queryServicesOrdersDO(serviceQuery);
			//不根据时间查询
			if (beginDate.equals("") || beginDate == null ||
			endDate.equals("") || endDate== null) {
				for (int i = 0; i < list_serviceOrder_by_buyUser.size(); i++) {
					//代表订单已经完成
					if (list_serviceOrder_by_buyUser.get(i).getStatus() == 2) {
						StatementHqDetailDO detailDO = new StatementHqDetailDO();
						//1、
						detailDO.setUserId(buyUserId);
						//2、
						detailDO.setOrderNum(list_serviceOrder_by_buyUser.get(i).getId());
						//3、
						detailDO.setOrderCreatTime(list_serviceOrder_by_buyUser.get(i).getCreated());
						//4、购买渠道
						detailDO.setBuyDitch("无");
						
						List<ItemsDetail> list_items_list = new ArrayList<ItemsDetail>();
						ItemsDetail itemsDetail = new ItemsDetail();
						itemsDetail.setItemName("无");
						//设置商品的购买数量
						itemsDetail.setBuyNum(0);
						//设置实付单价
						itemsDetail.setPaymentMoney(0.0);
						//设置优惠金额
						itemsDetail.setDiscountsMoney(0.0);
						list_items_list.add(itemsDetail);
						detailDO.setDetails(list_items_list);
						
						//消费总额
						detailDO.setTotalMoney(Double.parseDouble(list_serviceOrder_by_buyUser.get(i).getPrice()));
						//根据订单ID，查询各个的分成
						CommissionMoneyDO cmd = tradeOrderManager.queryCommissionMoneyMoneyByOrederId(list_serviceOrder_by_buyUser.get(i).getId());
						if (cmd != null) {
							//9、设置经销商分成
							detailDO.setDistributorMonry(Double.parseDouble(cmd.getDistributorAmount()));
							//10、设置店铺分成
							detailDO.setShopMoney(Double.parseDouble(cmd.getShopAmount()));
							//11、设置创客分成
							detailDO.setMakerMoney(Double.parseDouble(cmd.getMakerAmount()));
							//12、设置异业分成
							detailDO.setOthershopMoney(Double.parseDouble(cmd.getOthershopAmount()));
						}else{
							//9、设置经销商分成
							detailDO.setDistributorMonry(0.0);
							//10、设置店铺分成
							detailDO.setShopMoney(0.0);
							//11、设置创客分成
							detailDO.setMakerMoney(0.0);
							//12、设置异业分成
							detailDO.setOthershopMoney(0.0);
						}
						//13、设置店铺名称
						Result<ShopDO> shop_result = shopManager.queryShopDOById(list_serviceOrder_by_buyUser.get(i).getSellerUserId());
						if (shop_result.getResult() != null) {
							detailDO.setOthersName(shop_result.getResult().getShopsName());
						}else{
							detailDO.setOthersName("无");
						}
						list.add(detailDO);
					}
				}
				
				
				for (int i = 0; i < list_order_by_buyUser.size(); i++) {
						//这是订单下面包含子订单的做法
						if (list_order_by_buyUser.get(i).getLevel() == 0  && list_order_by_buyUser.get(i).getStatus() == 4) {
							 //这样判断之后就是一级订单
							StatementHqDetailDO detailDO = new StatementHqDetailDO();
							
							detailDO.setUserId(buyUserId);
							//1、设置订单编号
							detailDO.setOrderNum(list_order_by_buyUser.get(i).getOrderId());
							//2、设置购买时间
							detailDO.setOrderCreatTime(list_order_by_buyUser.get(i).getCreated());
							//3、购买渠道
							detailDO.setBuyDitch("无");
							
							
							Result<List<TradeOrderDO>> list_result = tradeOrderManager.queryChildOrderList(list_order_by_buyUser.get(i).getOrderId());
							//4、商品名称。通过商品Id,找到商品
							if (list_result.getResult().isEmpty() || list_result.getResult().size() <= 0) {
								List<ItemsDetail> list_items_list = new ArrayList<ItemsDetail>();
								ItemsDetail itemsDetail = new ItemsDetail();
								itemsDetail.setItemName("无");
								//设置商品的购买数量
								itemsDetail.setBuyNum(0);
								//设置实付单价
								itemsDetail.setPaymentMoney(0.0);
								//设置优惠金额
								itemsDetail.setDiscountsMoney(0.0);
								list_items_list.add(itemsDetail);
								detailDO.setDetails(list_items_list);
							}else{
								List<ItemsDetail> list_items_list = new ArrayList<ItemsDetail>();
								for (int j = 0; j < list_result.getResult().size(); j++) {
									
									ItemsDetail itemsDetail = new ItemsDetail();
									Result<ItemDO> item = itemManager.queryItemDOById(list_result.getResult().get(j).getItemId());
									//设置商品名称
									itemsDetail.setItemName(item.getResult().getItemName());
									//设置商品的购买数量
									itemsDetail.setBuyNum(list_result.getResult().get(j).getNumber());
									//设置实付单价
									itemsDetail.setPaymentMoney(Double.parseDouble(list_result.getResult().get(j).getPrice()));
									//设置优惠金额
									itemsDetail.setDiscountsMoney(Double.parseDouble(item.getResult().getPrice())*list_result.getResult().get(j).getNumber() 
											- Double.parseDouble(list_result.getResult().get(j).getPrice()));
									list_items_list.add(itemsDetail);
								}
								detailDO.setDetails(list_items_list);
							}
							//8消费总额
							detailDO.setTotalMoney(Double.parseDouble(list_order_by_buyUser.get(i).getPrice()));
							
							//根据订单ID，查询各个的分成
							CommissionMoneyDO cmd = tradeOrderManager.queryCommissionMoneyMoneyByOrederId(list_order_by_buyUser.get(i).getOrderId());
							if (cmd != null) {
								//9、设置经销商分成
								detailDO.setDistributorMonry(Double.parseDouble(cmd.getDistributorAmount()));
								//10、设置店铺分成
								detailDO.setShopMoney(Double.parseDouble(cmd.getShopAmount()));
								//11、设置创客分成
								detailDO.setMakerMoney(Double.parseDouble(cmd.getMakerAmount()));
								//12、设置异业分成
								detailDO.setOthershopMoney(Double.parseDouble(cmd.getOthershopAmount()));
							}else{
								//9、设置经销商分成
								detailDO.setDistributorMonry(0.0);
								//10、设置店铺分成
								detailDO.setShopMoney(0.0);
								//11、设置创客分成
								detailDO.setMakerMoney(0.0);
								//12、设置异业分成
								detailDO.setOthershopMoney(0.0);
							}
							//13、设置店铺名称
							Result<ShopDO> shop_result = shopManager.queryShopDOById(list_order_by_buyUser.get(i).getSellerUserId());
							if (shop_result.getResult() != null) {
								detailDO.setOthersName(shop_result.getResult().getShopsName());
							}else{
								detailDO.setOthersName("无");
							}
							list.add(detailDO);
						}
					}
			}else{
				SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
				Date date_beginDate = dateFormat.parse(beginDate);
				long long_beginDate = date_beginDate.getTime()/1000;
				Date date_endDate = dateFormat.parse(endDate);
				long long_endDate = date_endDate.getTime()/1000;
				
				for (int i = 0; i < list_serviceOrder_by_buyUser.size(); i++) {
					
					if (list_serviceOrder_by_buyUser.get(i).getCreated() >= long_beginDate 
							&&  list_serviceOrder_by_buyUser.get(i).getCreated()<= long_endDate) {
					
					//代表订单已经完成
					if (list_serviceOrder_by_buyUser.get(i).getStatus() == 2) {
						StatementHqDetailDO detailDO = new StatementHqDetailDO();
						//1、
						detailDO.setUserId(buyUserId);
						//2、
						detailDO.setOrderNum(list_serviceOrder_by_buyUser.get(i).getId());
						//3、
						detailDO.setOrderCreatTime(list_serviceOrder_by_buyUser.get(i).getCreated());
						//4、购买渠道
						detailDO.setBuyDitch("无");
						
						List<ItemsDetail> list_items_list = new ArrayList<ItemsDetail>();
						ItemsDetail itemsDetail = new ItemsDetail();
						itemsDetail.setItemName("无");
						//设置商品的购买数量
						itemsDetail.setBuyNum(0);
						//设置实付单价
						itemsDetail.setPaymentMoney(0.0);
						//设置优惠金额
						itemsDetail.setDiscountsMoney(0.0);
						list_items_list.add(itemsDetail);
						detailDO.setDetails(list_items_list);
						
						//消费总额
						detailDO.setTotalMoney(Double.parseDouble(list_serviceOrder_by_buyUser.get(i).getPrice()));
						//根据订单ID，查询各个的分成
						CommissionMoneyDO cmd = tradeOrderManager.queryCommissionMoneyMoneyByOrederId(list_serviceOrder_by_buyUser.get(i).getId());
						if (cmd != null) {
							//9、设置经销商分成
							detailDO.setDistributorMonry(Double.parseDouble(cmd.getDistributorAmount()));
							//10、设置店铺分成
							detailDO.setShopMoney(Double.parseDouble(cmd.getShopAmount()));
							//11、设置创客分成
							detailDO.setMakerMoney(Double.parseDouble(cmd.getMakerAmount()));
							//12、设置异业分成
							detailDO.setOthershopMoney(Double.parseDouble(cmd.getOthershopAmount()));
						}else{
							//9、设置经销商分成
							detailDO.setDistributorMonry(0.0);
							//10、设置店铺分成
							detailDO.setShopMoney(0.0);
							//11、设置创客分成
							detailDO.setMakerMoney(0.0);
							//12、设置异业分成
							detailDO.setOthershopMoney(0.0);
						}
						//13、设置店铺名称
						Result<ShopDO> shop_result = shopManager.queryShopDOById(list_serviceOrder_by_buyUser.get(i).getSellerUserId());
						if (shop_result.getResult() != null) {
							detailDO.setOthersName(shop_result.getResult().getShopsName());
						}else{
							detailDO.setOthersName("无");
						}
						list.add(detailDO);
					}
				}
		     }
				
				for (int i = 0; i < list_order_by_buyUser.size(); i++) {
					
					if (list_order_by_buyUser.get(i).getCreated() >= long_beginDate 
							&&  list_order_by_buyUser.get(i).getCreated()<= long_endDate) {
						//这是订单下面包含子订单的做法
						if (list_order_by_buyUser.get(i).getLevel() == 0 && list_order_by_buyUser.get(i).getStatus() == 4) {
							
							 //这样判断之后就是一级订单
							StatementHqDetailDO detailDO = new StatementHqDetailDO();
							
							detailDO.setUserId(buyUserId);
							//1、设置订单编号
							detailDO.setOrderNum(list_order_by_buyUser.get(i).getOrderId());
							//2、设置购买时间
							detailDO.setOrderCreatTime(list_order_by_buyUser.get(i).getCreated());
							//3、购买渠道
							detailDO.setBuyDitch("无");
							
							
							Result<List<TradeOrderDO>> list_result = tradeOrderManager.queryChildOrderList(list_order_by_buyUser.get(i).getOrderId());
							//4、商品名称。通过商品Id,找到商品
							if (list_result.getResult().isEmpty() || list_result.getResult().size() <= 0) {
								List<ItemsDetail> list_items_list = new ArrayList<ItemsDetail>();
								ItemsDetail itemsDetail = new ItemsDetail();
								itemsDetail.setItemName("无");
								//设置商品的购买数量
								itemsDetail.setBuyNum(0);
								//设置实付单价
								itemsDetail.setPaymentMoney(0.0);
								//设置优惠金额
								itemsDetail.setDiscountsMoney(0.0);
								list_items_list.add(itemsDetail);
								detailDO.setDetails(list_items_list);
							}else{
								List<ItemsDetail> list_items_list = new ArrayList<ItemsDetail>();
								for (int j = 0; j < list_result.getResult().size(); j++) {
									
									ItemsDetail itemsDetail = new ItemsDetail();
									Result<ItemDO> item = itemManager.queryItemDOById(list_result.getResult().get(j).getItemId());
									//设置商品名称
									itemsDetail.setItemName(item.getResult().getItemName());
									//设置商品的购买数量
									itemsDetail.setBuyNum(list_result.getResult().get(j).getNumber());
									//设置实付单价
									itemsDetail.setPaymentMoney(Double.parseDouble(list_result.getResult().get(j).getPrice()));
									//设置优惠金额，先查出来总的价格
									
									
									//设置优惠金额
									itemsDetail.setDiscountsMoney(Double.parseDouble(item.getResult().getPrice())*list_result.getResult().get(j).getNumber() 
											- Double.parseDouble(list_result.getResult().get(j).getPrice()));
									list_items_list.add(itemsDetail);
								}
								detailDO.setDetails(list_items_list);
							}
							//8消费总额
							detailDO.setTotalMoney(Double.parseDouble(list_order_by_buyUser.get(i).getPrice()));
							
							//根据订单ID，查询各个的分成
							CommissionMoneyDO cmd = tradeOrderManager.queryCommissionMoneyMoneyByOrederId(list_order_by_buyUser.get(i).getOrderId());
							if (cmd != null) {
								//9、设置经销商分成
								detailDO.setDistributorMonry(Double.parseDouble(cmd.getDistributorAmount()));
								//10、设置店铺分成
								detailDO.setShopMoney(Double.parseDouble(cmd.getShopAmount()));
								//11、设置创客分成
								detailDO.setMakerMoney(Double.parseDouble(cmd.getMakerAmount()));
								//12、设置异业分成
								detailDO.setOthershopMoney(Double.parseDouble(cmd.getOthershopAmount()));
							}else{
								//9、设置经销商分成
								detailDO.setDistributorMonry(0.0);
								//10、设置店铺分成
								detailDO.setShopMoney(0.0);
								//11、设置创客分成
								detailDO.setMakerMoney(0.0);
								//12、设置异业分成
								detailDO.setOthershopMoney(0.0);
							}
							//13、设置店铺名称
							Result<ShopDO> shop_result = shopManager.queryShopDOById(list_order_by_buyUser.get(i).getSellerUserId());
							if (shop_result.getResult() != null) {
								detailDO.setOthersName(shop_result.getResult().getShopsName());
							}else{
								detailDO.setOthersName("无");
							}
							list.add(detailDO);
						 }
					}
				}
			}
		jsonObject.put("success", true);
		jsonObject.put("message", "查询成功");
		jsonObject.put("data", jsonObject.toJSON(list));	
		return jsonObject.toString();
	}
}
