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

@RequestMapping(value="/statemen/db")
@Controller
public class StatementDistributorController {

	private static final Logger logger = LoggerFactory.getLogger(StatementDistributorController.class);

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
	private DeviceManager deviceManager;;
	/**
	 * 查看的总报表
	 */
	@RequestMapping(value = { "/showStatemen.do" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String showStatemenList(
			@RequestParam(value = "sYSUserId", required = true) long sYSUserId,
			@RequestParam(value="beginDate" ,required =false,defaultValue="") String beginDate,
			@RequestParam(value="endDate",required =false,defaultValue="") String endDate,
			@RequestParam(value="shopId" ,required=false,defaultValue="0")long shopId)
					throws Exception {
			
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		
		DistributorDO distributorDO = new DistributorDO();
		
		//检测登录的用户是否是经销商
		Result<DistributorDO> user_result = distributorManager.queryDistributorDOBySysUserId(sYSUserId);
		if (user_result.getResult() == null) {
			jsonObject.put("message", "身份不对，请换账号重试");
			return jsonObject.toString();
		}
		distributorDO = user_result.getResult();
		
		
		UsersQuery query = new UsersQuery();
		List<UsersDO> result_users_all = usersManager.queryUserDOlist(query);
		List<UsersDO> result_users_distributor = new ArrayList<UsersDO>();
		//通过经销商下面的机器码，查询用户注册是否其下面的
		Result<List<DeviceDO>> result_list_device = 
				deviceManager.queryDeviceDOByDistributorId(distributorDO.getId());
		List<DeviceDO> list_device = result_list_device.getResult();
		
		for (int i = 0; i < list_device.size(); i++) {
			for (int j = 0; j < result_users_all.size(); j++) {
				if (list_device.get(i).getProductNo().equals(result_users_all.get(j).getRegisterip())) {
					result_users_distributor.add(result_users_all.get(j));
				}
			}
		}
		
		//设置注册在该经销商下面的用户总数
		jsonObject.put("users_count_distributor", result_users_distributor.size());
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
	    
		for (int i = 0; i < result_users_distributor.size(); i++) {
		    String register_time = result_users_distributor.get(i).getRegistertime();
		    String[] register_date =  register_time.split(" ");
		    String year_time = register_date[0];
		    if (date_time.equals(year_time)) {
		    	users_register_24H_count++;
			}
		}
		
		jsonObject.put("users_register_24H_count",users_register_24H_count );
	    
		
		//该经销商下面的商品消费总额
		double money_total_shops_distributor = 0.0;
		List<TradeOrderDO> tradeOrderDO_list = tradeOrderManager.queryTraderOrderList();
		//所有属于该经销商的商品订单
		List<TradeOrderDO> tradeOrderDO_list_distributor = new ArrayList<TradeOrderDO>();
		//1、先查询出来，该经销商下面所有的店铺
		//2、拿着该经销商下面的所有店铺的订单，计算商品消费额度
		Result<List<ShopDO>> list_shop_distributor_result = shopManager.queryShopNameBydistributorId(distributorDO.getId());
		List<ShopDO> list_shop_distributor = list_shop_distributor_result.getResult();
		//1、遍历所有订单
		for (int i = 0; i < tradeOrderDO_list.size(); i++) {
			for (int j = 0; j < list_shop_distributor.size(); j++) {
				//判断卖家ID是否属于该店铺的
				if (tradeOrderDO_list.get(i).getSellerUserId().longValue() 
						== list_shop_distributor.get(j).getShopsId().longValue()) {
					if (tradeOrderDO_list.get(i).getStatus() == 4) {
						tradeOrderDO_list_distributor.add(tradeOrderDO_list.get(i));
						String price = tradeOrderDO_list.get(i).getPrice();
						money_total_shops_distributor += Double.parseDouble(price);
					}
				}
			}
		}
		
		jsonObject.put("money_total_shops_distributor", money_total_shops_distributor);
		
		//服务消费总额
		double money_total_service_distributor = 0.0;
		List<ServicesOrdersDO> servicesOrdersDO_list = tradeOrderDAO.selectServicesOrederDOList();
		//属于该经销商下面的服务订单
		List<ServicesOrdersDO> servicesOrdersDO_list_distributor = new ArrayList<ServicesOrdersDO>();
		
		for (int i = 0; i < servicesOrdersDO_list.size(); i++) {
			for (int j = 0; j < list_shop_distributor.size(); j++) {
				if (servicesOrdersDO_list.get(i).getSellerUserId().longValue() 
						== list_shop_distributor.get(j).getShopsId().longValue()) {
					if (servicesOrdersDO_list.get(i).getStatus() == 2) {
						servicesOrdersDO_list_distributor.add(servicesOrdersDO_list.get(i));
						String price = servicesOrdersDO_list.get(i).getPrice();
						money_total_service_distributor += Double.parseDouble(price);
					}
				}
			}
		}
		
		jsonObject.put("money_total_service_distributor", money_total_service_distributor);
		//平台交易额
		jsonObject.put("money_total_distributor", money_total_service_distributor+money_total_shops_distributor);
		
		//付费人员总人数
		int member_count_distributor = 0;
		MemberQuery memberQuery = new MemberQuery();
		List<MemberDO> memberDOList = usersManager.queryMemberList(memberQuery);
		for (int i = 0; i < memberDOList.size(); i++) {
			for (int j = 0; j < result_users_distributor.size(); j++) {
				if (memberDOList.get(i).getUserId() == result_users_distributor.get(j).getUserId()) {
					if (memberDOList.get(i).getMemberType() == 0 ) {
						member_count_distributor++;
					}
				}
			}
		}
		
		jsonObject.put("member_count_distributor",member_count_distributor );
		
		List<StatementHqDO> list_detail = new ArrayList<StatementHqDO>();
	
		
		//查询的列表数据
		//先查询出全部的注册用户,上面已经完成，
		//下面遍历全部用户     result_users
		if (beginDate.equals("") || beginDate == null ||
				endDate.equals("") || endDate== null) {
			if (shopId == 0) {
				//代表正常查询,不进行筛选
				for (int i = 0; i < result_users_all.size(); i++) {
					//要显示首先满足两点1、在该经销商下注册的，2、在该经销商下有订单
					
					StatementHqDO shdo = new StatementHqDO();
					//1、设置用户ID
					shdo.setUserId(result_users_all.get(i).getUserId());
					//2、设置用户名
					shdo.setMemberName(result_users_all.get(i).getUnick());
					//3、设置注册时间
					shdo.setRegistertime(result_users_all.get(i).getRegistertime());
					//4、设置手机号
					shdo.setUsername(result_users_all.get(i).getUsername() 
							== null?"无":result_users_all.get(i).getUsername().replace(result_users_all.get(i).getUsername().substring(4, 8), "****"));

					//5、设置注册设备号
					shdo.setDeviceNum(result_users_all.get(i).getRegisterip());
					//6、设置注册店铺
					
					Result<DeviceDO> list_result_device = deviceManager.queryDeviceDOByProductNo(result_users_all.get(i).getRegisterip());
					
					if (list_result_device.getResult() != null) {
						//6、设置注册店铺
						//6.1通过设备号查询到相关联的店铺
						ShopDO shopdo =shopManager.queryByDeviceId(list_result_device.getResult().getId());
						//6、2设置店铺名臣
						if (shopdo != null) {
							shdo.setRegisterShopName(shopdo.getShopsName());
						}else{
							shdo.setRegisterShopName("无");
						}
					}else{
						shdo.setRegisterShopName("无");
					}
					
					List<MakerDO> list_maker = new ArrayList<MakerDO>();
					//8、设置创客
					Result<DeviceDO> result_device = deviceManager.queryDeviceDOByProductNo(result_users_all.get(i).getRegisterip());
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
					
					//7、设置用户的会员状态
					if (result_users_all.get(i).getMember() == 0) {
						shdo.setMemberType("不是会员");
					}else{
						MemberDO memberDO = usersManager.queryMemberDOByUserId(result_users_all.get(i).getUserId());
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
					
					//8、设置用户的商品服务总额
					double user_money_shops = 0.0;
					for (int j = 0; j < tradeOrderDO_list_distributor.size(); j++) {
						if (tradeOrderDO_list_distributor.get(j).getBuyerUserId().longValue() == (long)result_users_all.get(i).getUserId()) {
							user_money_shops += Double.parseDouble(tradeOrderDO_list_distributor.get(j).getPrice());
						}
					}
					
					shdo.setShopsMoney(user_money_shops);
					//9、设置用户的服务消费额
					//9.1、先通过用户的ID查询出来，用户所有的服务订单
					double user_money_services = 0.0;
					
					for (int k = 0; k < servicesOrdersDO_list_distributor.size(); k++) {
						if (servicesOrdersDO_list_distributor.get(k).getBuyerUserId().longValue() == (long)result_users_all.get(i).getUserId()) {
							user_money_services += Double.parseDouble(servicesOrdersDO_list_distributor.get(k).getPrice());
						}
					}
					shdo.setServiceMoney(user_money_services);
					//设置用户总的消费额度
					shdo.setTotalMoney(user_money_services + user_money_shops);
					
					if ((user_money_services + user_money_shops) == 0.0) {

						for (int j = 0; j < result_users_distributor.size(); j++) {
							if (result_users_all.get(i).getUserId() == result_users_distributor.get(j).getUserId()) {
								shdo.setServiceMoney(0.0);
								shdo.setShopsMoney(0.0);
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
					sorl_total_money+=list_detail.get(j).getTotalMoney();
				}
				jsonObject.put("sorl_total_money", sorl_total_money);
				jsonObject.put("list_detail", JSONObject.toJSON(list_detail));
				jsonObject.put("message", "查询成功");
				jsonObject.put("success", true);
			}else{
				//代表按照店铺进行筛选查询
				for (int i = 0; i < result_users_all.size(); i++) {
					
					Result<DeviceDO> list_result_d = deviceManager.queryDeviceDOByProductNo(result_users_all.get(i).getRegisterip());
					ShopDO shop = null;
					if (list_result_d.getResult() != null) {
						//6、设置注册店铺
						//6.1通过设备号查询到相关联的店铺
						shop = shopManager.queryByDeviceId(list_result_d.getResult().getId());
					}
					if (shop != null) {
						//要显示首先满足两点1、在该经销商下注册的，2、在该经销商下有订单
						if (shopId == shop.getShopsId()) {
						StatementHqDO shdo = new StatementHqDO();
						//1、设置用户ID
						shdo.setUserId(result_users_all.get(i).getUserId());
						//2、设置用户名
						shdo.setMemberName(result_users_all.get(i).getUnick());
						//3、设置注册时间
						shdo.setRegistertime(result_users_all.get(i).getRegistertime());
						//4、设置手机号
						shdo.setUsername(result_users_all.get(i).getUsername() 
								== null?"无":result_users_all.get(i).getUsername().replace(result_users_all.get(i).getUsername().substring(4, 8), "****"));

						//5、设置注册设备号
						shdo.setDeviceNum(result_users_all.get(i).getRegisterip());
						//6、设置注册店铺
						
						Result<DeviceDO> list_result_device = deviceManager.queryDeviceDOByProductNo(result_users_all.get(i).getRegisterip());
						
						if (list_result_device.getResult() != null) {
							//6、设置注册店铺
							//6.1通过设备号查询到相关联的店铺
							ShopDO shopdo =shopManager.queryByDeviceId(list_result_device.getResult().getId());
							//6、2设置店铺名臣
							if (shopdo != null) {
								shdo.setRegisterShopName(shopdo.getShopsName());
							}else{
								shdo.setRegisterShopName("无");
							}
						}else{
							shdo.setRegisterShopName("无");
						}
						
						List<MakerDO> list_maker = new ArrayList<MakerDO>();
						//8、设置创客
						Result<DeviceDO> result_device = deviceManager.queryDeviceDOByProductNo(result_users_all.get(i).getRegisterip());
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
						
						//7、设置用户的会员状态
						if (result_users_all.get(i).getMember() == 0) {
							shdo.setMemberType("不是会员");
						}else{
							MemberDO memberDO = usersManager.queryMemberDOByUserId(result_users_all.get(i).getUserId());
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
						
						//8、设置用户的商品服务总额
						double user_money_shops = 0.0;
						for (int j = 0; j < tradeOrderDO_list_distributor.size(); j++) {
							if (tradeOrderDO_list_distributor.get(j).getBuyerUserId().longValue() == (long)result_users_all.get(i).getUserId()) {
								user_money_shops += Double.parseDouble(tradeOrderDO_list_distributor.get(j).getPrice());
							}
						}
						
						shdo.setShopsMoney(user_money_shops);
						//9、设置用户的服务消费额
						//9.1、先通过用户的ID查询出来，用户所有的服务订单
						double user_money_services = 0.0;
						
						for (int k = 0; k < servicesOrdersDO_list_distributor.size(); k++) {
							if (servicesOrdersDO_list_distributor.get(k).getBuyerUserId().longValue() == (long)result_users_all.get(i).getUserId()) {
								user_money_services += Double.parseDouble(servicesOrdersDO_list_distributor.get(k).getPrice());
							}
						}
						shdo.setServiceMoney(user_money_services);
						//设置用户总的消费额度
						shdo.setTotalMoney(user_money_services + user_money_shops);
						
						if ((user_money_services + user_money_shops) == 0.0) {

							for (int j = 0; j < result_users_distributor.size(); j++) {
								if (result_users_all.get(i).getUserId() == result_users_distributor.get(j).getUserId()) {
									shdo.setServiceMoney(0.0);
									shdo.setShopsMoney(0.0);
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
						sorl_total_money+=list_detail.get(j).getTotalMoney();
					}
					jsonObject.put("sorl_total_money", sorl_total_money);
					jsonObject.put("list_detail", JSONObject.toJSON(list_detail));
					jsonObject.put("message", "查询成功");
					jsonObject.put("success", true);
				}
			}
		  }
			//输入的时间不为null
		}else{
			//只根据时间进行筛选
			Date date_beginDate = dateFormat.parse(beginDate);
			long long_beginDate = date_beginDate.getTime();
			Date date_endDate = dateFormat.parse(endDate);
			long long_endDate = date_endDate.getTime();
			if (shopId == 0) {
				//只根据时间进行搜索
				
				for (int i = 0; i < result_users_all.size(); i++) {
					//将用户的注册时间转化为date类型
					Date date_registertime = dateFormat.parse(result_users_all.get(i).getRegistertime());
					long long_registertime = date_registertime.getTime();
					if (long_registertime >= long_beginDate && long_registertime <= long_endDate ) {
						//要显示首先满足两点1、在该经销商下注册的，2、在该经销商下有订单
						
						StatementHqDO shdo = new StatementHqDO();
						//1、设置用户ID
						shdo.setUserId(result_users_all.get(i).getUserId());
						//2、设置用户名
						shdo.setMemberName(result_users_all.get(i).getUnick());
						//3、设置注册时间
						shdo.setRegistertime(result_users_all.get(i).getRegistertime());
						//4、设置手机号
						shdo.setUsername(result_users_all.get(i).getUsername() 
								== null?"无":result_users_all.get(i).getUsername().replace(result_users_all.get(i).getUsername().substring(4, 8), "****"));

						//5、设置注册设备号
						shdo.setDeviceNum(result_users_all.get(i).getRegisterip());
						//6、设置注册店铺
						
						Result<DeviceDO> list_result_device = deviceManager.queryDeviceDOByProductNo(result_users_all.get(i).getRegisterip());
						
						if (list_result_device.getResult() != null) {
							//6、设置注册店铺
							//6.1通过设备号查询到相关联的店铺
							ShopDO shopdo =shopManager.queryByDeviceId(list_result_device.getResult().getId());
							//6、2设置店铺名臣
							if (shopdo != null) {
								shdo.setRegisterShopName(shopdo.getShopsName());
							}else{
								shdo.setRegisterShopName("无");
							}
						}else{
							shdo.setRegisterShopName("无");
						}
						
						List<MakerDO> list_maker = new ArrayList<MakerDO>();
						//8、设置创客
						Result<DeviceDO> result_device = deviceManager.queryDeviceDOByProductNo(result_users_all.get(i).getRegisterip());
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
						
						//7、设置用户的会员状态
						if (result_users_all.get(i).getMember() == 0) {
							shdo.setMemberType("不是会员");
						}else{
							MemberDO memberDO = usersManager.queryMemberDOByUserId(result_users_all.get(i).getUserId());
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
						
						//8、设置用户的商品服务总额
						double user_money_shops = 0.0;
						for (int j = 0; j < tradeOrderDO_list_distributor.size(); j++) {
							if (tradeOrderDO_list_distributor.get(j).getBuyerUserId().longValue() == (long)result_users_all.get(i).getUserId()) {
								user_money_shops += Double.parseDouble(tradeOrderDO_list_distributor.get(j).getPrice());
							}
						}
						
						shdo.setShopsMoney(user_money_shops);
						//9、设置用户的服务消费额
						//9.1、先通过用户的ID查询出来，用户所有的服务订单
						double user_money_services = 0.0;
						
						for (int k = 0; k < servicesOrdersDO_list_distributor.size(); k++) {
							if (servicesOrdersDO_list_distributor.get(k).getBuyerUserId().longValue() == (long)result_users_all.get(i).getUserId()) {
								user_money_services += Double.parseDouble(servicesOrdersDO_list_distributor.get(k).getPrice());
							}
						}
						shdo.setServiceMoney(user_money_services);
						//设置用户总的消费额度
						shdo.setTotalMoney(user_money_services + user_money_shops);
						
						if ((user_money_services + user_money_shops) == 0.0) {

							for (int j = 0; j < result_users_distributor.size(); j++) {
								if (result_users_all.get(i).getUserId() == result_users_distributor.get(j).getUserId()) {
									shdo.setServiceMoney(0.0);
									shdo.setShopsMoney(0.0);
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
					sorl_total_money+=list_detail.get(j).getTotalMoney();
				}
				jsonObject.put("sorl_total_money", sorl_total_money);
				jsonObject.put("list_detail", JSONObject.toJSON(list_detail));
				jsonObject.put("message", "查询成功");
				jsonObject.put("success", true);
			}else{
				//根据时间和店铺进行搜索
				for (int i = 0; i < result_users_all.size(); i++) {
					//将用户的注册时间转化为date类型
					Date date_registertime = dateFormat.parse(result_users_all.get(i).getRegistertime());
					long long_registertime = date_registertime.getTime();
					if (long_registertime >= long_beginDate && long_registertime <= long_endDate ) {
						//要显示首先满足两点1、在该经销商下注册的，2、在该经销商下有订单
						
						Result<DeviceDO> list_result_d = deviceManager.queryDeviceDOByProductNo(result_users_all.get(i).getRegisterip());
						ShopDO shop = null;
						if (list_result_d.getResult() != null) {
							//6、设置注册店铺
							//6.1通过设备号查询到相关联的店铺
							shop = shopManager.queryByDeviceId(list_result_d.getResult().getId());
						}
						
						if (shop != null && shop.getShopsId()== shopId) {
						
						StatementHqDO shdo = new StatementHqDO();
						//1、设置用户ID
						shdo.setUserId(result_users_all.get(i).getUserId());
						//2、设置用户名
						shdo.setMemberName(result_users_all.get(i).getUnick());
						//3、设置注册时间
						shdo.setRegistertime(result_users_all.get(i).getRegistertime());
						//4、设置手机号
						shdo.setUsername(result_users_all.get(i).getUsername() 
								== null?"无":result_users_all.get(i).getUsername().replace(result_users_all.get(i).getUsername().substring(4, 8), "****"));

						//5、设置注册设备号
						shdo.setDeviceNum(result_users_all.get(i).getRegisterip());
						//6、设置注册店铺
						
						Result<DeviceDO> list_result_device = deviceManager.queryDeviceDOByProductNo(result_users_all.get(i).getRegisterip());
						
						if (list_result_device.getResult() != null) {
							//6、设置注册店铺
							//6.1通过设备号查询到相关联的店铺
							ShopDO shopdo =shopManager.queryByDeviceId(list_result_device.getResult().getId());
							//6、2设置店铺名臣
							if (shopdo != null) {
								shdo.setRegisterShopName(shopdo.getShopsName());
							}else{
								shdo.setRegisterShopName("无");
							}
						}else{
							shdo.setRegisterShopName("无");
						}
						
						List<MakerDO> list_maker = new ArrayList<MakerDO>();
						//8、设置创客
						Result<DeviceDO> result_device = deviceManager.queryDeviceDOByProductNo(result_users_all.get(i).getRegisterip());
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
						
						//7、设置用户的会员状态
						if (result_users_all.get(i).getMember() == 0) {
							shdo.setMemberType("不是会员");
						}else{
							MemberDO memberDO = usersManager.queryMemberDOByUserId(result_users_all.get(i).getUserId());
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
						
						//8、设置用户的商品服务总额
						double user_money_shops = 0.0;
						for (int j = 0; j < tradeOrderDO_list_distributor.size(); j++) {
							if (tradeOrderDO_list_distributor.get(j).getBuyerUserId().longValue() == (long)result_users_all.get(i).getUserId()) {
								user_money_shops += Double.parseDouble(tradeOrderDO_list_distributor.get(j).getPrice());
							}
						}
						
						shdo.setShopsMoney(user_money_shops);
						//9、设置用户的服务消费额
						//9.1、先通过用户的ID查询出来，用户所有的服务订单
						double user_money_services = 0.0;
						
						for (int k = 0; k < servicesOrdersDO_list_distributor.size(); k++) {
							if (servicesOrdersDO_list_distributor.get(k).getBuyerUserId().longValue() == (long)result_users_all.get(i).getUserId()) {
								user_money_services += Double.parseDouble(servicesOrdersDO_list_distributor.get(k).getPrice());
							}
						}
						shdo.setServiceMoney(user_money_services);
						//设置用户总的消费额度
						shdo.setTotalMoney(user_money_services + user_money_shops);
						
						if ((user_money_services + user_money_shops) == 0.0) {

							for (int j = 0; j < result_users_distributor.size(); j++) {
								if (result_users_all.get(i).getUserId() == result_users_distributor.get(j).getUserId()) {
									shdo.setServiceMoney(0.0);
									shdo.setShopsMoney(0.0);
									shdo.setTotalMoney(0.0);
									list_detail.add(shdo);
								}
							}
						} else {
							list_detail.add(shdo);
						}
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
		  }
		return jsonObject.toString();
	}
	
	/**
	 * 查看用户消费详情
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
		
		DistributorDO distributorDO = new DistributorDO();
		
		//检测登录的用户是否是经销商
		Result<DistributorDO> user_result = distributorManager.queryDistributorDOBySysUserId(sYSUserId);
		if (user_result.getResult() == null) {
			jsonObject.put("message", "身份不对，请换账号重试");
			return jsonObject.toString();
		}
		distributorDO = user_result.getResult();
		
		
		List<StatementHqDetailDO> list = new ArrayList<StatementHqDetailDO>();
		
		TradeOrderQuery query = new TradeOrderQuery();
		query.setBuyerUserId(buyUserId);
		
		//拿着购买人ID，遍历数据库查出该用户所有的商品订单
		List<TradeOrderDO> list_order_by_buyUser = tradeOrderManager.queryTraderOrder(query);
		//要在里面筛选出来，属于该经销商的订单
		List<TradeOrderDO> tradeOrderDO_list = tradeOrderManager.queryTraderOrderList();
		//所有属于该用户该经销商的商品订单
		List<TradeOrderDO> tradeOrderDO_list_distributor_user = new ArrayList<TradeOrderDO>();
		//查询出来所有属于该经销商的订单
		List<TradeOrderDO> tradeOrderDO_list_distributor = new ArrayList<TradeOrderDO>();
		
		//1、先查询出来，该经销商下面所有的店铺
		//2、拿着该经销商下面的所有店铺的订单，计算商品消费额度
		Result<List<ShopDO>> list_shop_distributor_result = shopManager.queryShopNameBydistributorId(distributorDO.getId());
		List<ShopDO> list_shop_distributor = list_shop_distributor_result.getResult();
		//1、遍历所有订单
		for (int i = 0; i < tradeOrderDO_list.size(); i++) {
			for (int j = 0; j < list_shop_distributor.size(); j++) {
				if (tradeOrderDO_list.get(i).getSellerUserId().longValue() 
						== list_shop_distributor.get(j).getShopsId().longValue()) {
					tradeOrderDO_list_distributor.add(tradeOrderDO_list.get(i));
				}
			}
		}
		for (int k = 0; k < list_order_by_buyUser.size(); k++) {
			for (int i = 0; i < tradeOrderDO_list_distributor.size(); i++) {
				if (list_order_by_buyUser.get(k).getBuyerUserId().longValue() 
						== tradeOrderDO_list_distributor.get(i).getBuyerUserId().longValue()) {
					tradeOrderDO_list_distributor_user.add(list_order_by_buyUser.get(k));//这样得到的就是该用户在，该经销商下面的所有的订单
				}
			}
		}
		
		//拿着购买人token，查询出该用户所有的服务订单
		ServicesOrdersQuery serviceOrdersQuery = new ServicesOrdersQuery();
		serviceOrdersQuery.setBuyerUserId(buyUserId);
		List<ServicesOrdersDO> ServicesOrdersDO_list_user = tradeOrderManager.queryServicesOrdersDO(serviceOrdersQuery);
		//查询出来，所有的所有的服务订单
		List<ServicesOrdersDO> ServicesOrdersDO_list_all = tradeOrderManager.queryServicesOrdersDOList();
		//所有属于该经销商的服务订单
		List<ServicesOrdersDO> service_OrderDO_list_distributor = new ArrayList<ServicesOrdersDO>();
		//所有该用户属于该经销商的订单
		List<ServicesOrdersDO> ServicesOrdersDO_user_distributor = new ArrayList<ServicesOrdersDO>();
		
		for (int i = 0; i < ServicesOrdersDO_list_all.size(); i++) {
			for (int j = 0; j < list_shop_distributor.size(); j++) {
				if (ServicesOrdersDO_list_all.get(i).getSellerUserId().longValue() 
						== list_shop_distributor.get(j).getShopsId().longValue()) {
					service_OrderDO_list_distributor.add(ServicesOrdersDO_list_all.get(i));
				}
			}
		}
		
		for (int k = 0; k < ServicesOrdersDO_list_user.size(); k++) {
			for (int i = 0; i < service_OrderDO_list_distributor.size(); i++) {
				if (ServicesOrdersDO_list_user.get(k).getBuyerUserId().longValue() 
						== service_OrderDO_list_distributor.get(i).getBuyerUserId().longValue()) {
					ServicesOrdersDO_user_distributor.add(ServicesOrdersDO_list_user.get(k));//这样得到的就是该用户在，该经销商下面的所有的订单
				}
			}
		}
			//不根据时间查询
			if (beginDate.equals("") || beginDate == null ||
			endDate.equals("") || endDate== null) {
                 for (int i = 0; i < ServicesOrdersDO_user_distributor.size(); i++) {
					//代表订单已经完成
					if (ServicesOrdersDO_user_distributor.get(i).getStatus() == 2) {
						StatementHqDetailDO detailDO = new StatementHqDetailDO();
						//1、
						detailDO.setUserId(buyUserId);
						//2、
						detailDO.setOrderNum(ServicesOrdersDO_user_distributor.get(i).getId());
						//3、
						detailDO.setOrderCreatTime(ServicesOrdersDO_user_distributor.get(i).getCreated());
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
						detailDO.setTotalMoney(Double.parseDouble(ServicesOrdersDO_user_distributor.get(i).getPrice()));
						//根据订单ID，查询各个的分成
						CommissionMoneyDO cmd = 
								tradeOrderManager.queryCommissionMoneyMoneyByOrederId(ServicesOrdersDO_user_distributor.get(i).getId());
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
						Result<ShopDO> shop_result = shopManager.queryShopDOById(ServicesOrdersDO_user_distributor.get(i).getSellerUserId());
						if (shop_result.getResult() != null) {
							detailDO.setOthersName(shop_result.getResult().getShopsName());
						}else{
							detailDO.setOthersName("无");
						}
						list.add(detailDO);
					}
		         }
				
				
				
				for (int i = 0; i < tradeOrderDO_list_distributor_user.size(); i++) {
					
					//这是订单下面包含子订单的做法
					if (tradeOrderDO_list_distributor_user.get(i).getLevel() == 0  
							&& tradeOrderDO_list_distributor_user.get(i).getStatus() == 4) {
						 //这样判断之后就是一级订单
						StatementHqDetailDO detailDO = new StatementHqDetailDO();
						
						detailDO.setUserId(buyUserId);
						//1、设置订单编号
						detailDO.setOrderNum(tradeOrderDO_list_distributor_user.get(i).getOrderId());
						//2、设置购买时间
						detailDO.setOrderCreatTime(tradeOrderDO_list_distributor_user.get(i).getCreated());
						//3、购买渠道
						detailDO.setBuyDitch("无");
						
						Result<List<TradeOrderDO>> list_result = tradeOrderManager.queryChildOrderList(tradeOrderDO_list_distributor_user.get(i).getOrderId());
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
						detailDO.setTotalMoney(Double.parseDouble(tradeOrderDO_list_distributor_user.get(i).getPrice()));
						
						//根据订单ID，查询各个的分成
						CommissionMoneyDO cmd = tradeOrderManager.queryCommissionMoneyMoneyByOrederId(tradeOrderDO_list_distributor_user.get(i).getOrderId());
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
						Result<ShopDO> shop_result = shopManager.queryShopDOById(tradeOrderDO_list_distributor_user.get(i).getSellerUserId());
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
				
                 for (int i = 0; i < ServicesOrdersDO_user_distributor.size(); i++) {
					
					if (ServicesOrdersDO_user_distributor.get(i).getCreated() >= long_beginDate 
							&&  ServicesOrdersDO_user_distributor.get(i).getCreated()<= long_endDate) {
					
					//代表订单已经完成
					if (ServicesOrdersDO_user_distributor.get(i).getStatus() == 2) {
						StatementHqDetailDO detailDO = new StatementHqDetailDO();
						//1、
						detailDO.setUserId(buyUserId);
						//2、
						detailDO.setOrderNum(ServicesOrdersDO_user_distributor.get(i).getId());
						//3、
						detailDO.setOrderCreatTime(ServicesOrdersDO_user_distributor.get(i).getCreated());
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
						detailDO.setTotalMoney(Double.parseDouble(ServicesOrdersDO_user_distributor.get(i).getPrice()));
						//根据订单ID，查询各个的分成
						CommissionMoneyDO cmd = 
								tradeOrderManager.queryCommissionMoneyMoneyByOrederId(ServicesOrdersDO_user_distributor.get(i).getId());
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
						Result<ShopDO> shop_result = shopManager.queryShopDOById(ServicesOrdersDO_user_distributor.get(i).getSellerUserId());
						if (shop_result.getResult() != null) {
							detailDO.setOthersName(shop_result.getResult().getShopsName());
						}else{
							detailDO.setOthersName("无");
						}
						list.add(detailDO);
					}
				}
		     }
				
				
				
				for (int i = 0; i < tradeOrderDO_list_distributor_user.size(); i++) {
					
					if (tradeOrderDO_list_distributor_user.get(i).getCreated() >= long_beginDate 
							&&  tradeOrderDO_list_distributor_user.get(i).getCreated() <= long_endDate) {
						//这是订单下面包含子订单的做法
						if (tradeOrderDO_list_distributor_user.get(i).getLevel() == 0  
								&& tradeOrderDO_list_distributor_user.get(i).getStatus() == 4) {
							 //这样判断之后就是一级订单
							StatementHqDetailDO detailDO = new StatementHqDetailDO();
							
							detailDO.setUserId(buyUserId);
							//1、设置订单编号
							detailDO.setOrderNum(tradeOrderDO_list_distributor_user.get(i).getOrderId());
							//2、设置购买时间
							detailDO.setOrderCreatTime(tradeOrderDO_list_distributor_user.get(i).getCreated());
							//3、购买渠道
							detailDO.setBuyDitch("无");
							
							Result<List<TradeOrderDO>> list_result = tradeOrderManager.queryChildOrderList(tradeOrderDO_list_distributor_user.get(i).getOrderId());
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
							detailDO.setTotalMoney(Double.parseDouble(tradeOrderDO_list_distributor_user.get(i).getPrice()));
							
							//根据订单ID，查询各个的分成
							CommissionMoneyDO cmd = tradeOrderManager.queryCommissionMoneyMoneyByOrederId(tradeOrderDO_list_distributor_user.get(i).getOrderId());
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
							Result<ShopDO> shop_result = shopManager.queryShopDOById(tradeOrderDO_list_distributor_user.get(i).getSellerUserId());
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
