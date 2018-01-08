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

@RequestMapping(value="/statemen/maker")
@Controller
public class StatementMakerController {

	private static final Logger logger = LoggerFactory.getLogger(StatementMakerController.class);

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
	 * 查看的总报表
	 */
	@RequestMapping(value = { "/showStatemen.do" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String showStatemenList(
			@RequestParam(value = "sYSUserId", required = true) long sYSUserId,
			@RequestParam(value="beginDate" ,required =false,defaultValue="") String beginDate,
			@RequestParam(value="endDate",required =false,defaultValue="") String endDate
			) throws Exception {
			
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		MakerDO makerDO = new MakerDO();
		
		//先判断登录的用户是否是创客，如果不是就返回
		Result<MakerDO> maker_result = makerManager.queryMakerDOBySysUserId(sYSUserId);
		makerDO = maker_result.getResult();
		
		if (makerDO == null) {
			jsonObject.put("message", "身份不对，请换账号重试");
			return jsonObject.toString();
		}
		
		//获取注册用户总数
		UsersQuery query = new UsersQuery();
		List<UsersDO> result_users_all = usersManager.queryUserDOlist(query);
		//获取和本创客想关联的用户数
		List<UsersDO> result_users_maker = new ArrayList<UsersDO>();
		//将用户的信息，和创客关联起来
		DeviceMakerQuery query_maker = new DeviceMakerQuery();
		
		query_maker.setMakerId(makerDO.getId());//将设备号找到
		List<DeviceMakerDO> maker_device_list = makerManager.queryDeviceMaker(query_maker);
		
		for (int i = 0; i < result_users_all.size(); i++) {
			for (int j = 0; j < maker_device_list.size(); j++) {
				Result<DeviceDO> deviceDO = deviceManager.queryDeviceDOById(maker_device_list.get(j).getDeviceId());
				if (deviceDO.getResult() != null) {
					if (result_users_all.get(i).getRegisterip().equals(deviceDO.getResult().getProductNo())) {
						result_users_maker.add(result_users_all.get(i));
					}
				}
			}
		}
		
		int users_count_maker = result_users_maker.size();
		jsonObject.put("users_count_maker", users_count_maker);
		
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
	    
		for (int i = 0; i < result_users_maker.size(); i++) {
		    String register_time = result_users_maker.get(i).getRegistertime();
		    String[] register_date =  register_time.split(" ");
		    String year_time = register_date[0];
		    if (date_time.equals(year_time)) {
		    	users_register_24H_count++;
			}
		}
		
		jsonObject.put("users_register_24H_count",users_register_24H_count );

		
		List<TradeOrderDO> tradeOrder_list_maker = new ArrayList<TradeOrderDO>();
		//商品消费总额
		double money_total_shops_maker = 0.0;
		List<TradeOrderDO> tradeOrderDO_list = tradeOrderManager.queryTraderOrderList();
		for (int i = 0; i < tradeOrderDO_list.size(); i++) {
			for (int j = 0; j < result_users_maker.size(); j++) {
				if (tradeOrderDO_list.get(i).getBuyerUserId().longValue() 
						== result_users_maker.get(j).getUserId()
						&& tradeOrderDO_list.get(i).getStatus() == 4) {
					tradeOrder_list_maker.add(tradeOrderDO_list.get(i));
					String price = tradeOrderDO_list.get(i).getPrice();
					money_total_shops_maker += Double.parseDouble(price);
				}
			}
		}
		
		jsonObject.put("money_total_shops_maker", money_total_shops_maker);
		
		//服务消费总额
		double money_total_service_maker = 0.0;
		List<ServicesOrdersDO> servicesOrdersDO_list = tradeOrderDAO.selectServicesOrederDOList();
		
		List<ServicesOrdersDO> servicesOrdersDO_list_maker = new ArrayList<ServicesOrdersDO>();
		
		for (int i = 0; i < servicesOrdersDO_list.size(); i++) {
			for (int j = 0; j < result_users_maker.size(); j++) {
				if (servicesOrdersDO_list.get(i).getBuyerUserId().longValue() 
						== result_users_maker.get(j).getUserId()
						&& servicesOrdersDO_list.get(i).getStatus() == 2) {
					servicesOrdersDO_list_maker.add(servicesOrdersDO_list.get(i));
					String price = servicesOrdersDO_list.get(i).getPrice();
					money_total_service_maker += Double.parseDouble(price);
				}
			}
		}
		
		jsonObject.put("money_total_service_maker", money_total_service_maker);
		//平台交易额
		double money_total_maker = 0.0;
		money_total_maker = money_total_service_maker+money_total_shops_maker;
		jsonObject.put("money_total_maker", money_total_maker);
		
		
		//付费人员总人数
		int member_count_maker = 0;
		MemberQuery memberQuery = new MemberQuery();
		List<MemberDO> memberDOList = usersManager.queryMemberList(memberQuery);
		for (int i = 0; i < memberDOList.size(); i++) {
			for (int j = 0; j < result_users_maker.size(); j++) {
				if (memberDOList.get(i).getUserId() == result_users_maker.get(j).getUserId()) {
					if (memberDOList.get(i).getMemberType() ==0) {
						member_count_maker++;
					}
				}
			}
		}
		jsonObject.put("member_count_maker",member_count_maker );
		
		List<StatementHqDO> list_detail = new ArrayList<StatementHqDO>();
		
		//查询的列表数据
		//先查询出全部的注册用户,上面已经完成，
		//下面遍历全部用户     result_users
		if (beginDate.equals("") || beginDate == null ||
				endDate.equals("") || endDate== null) {
			//代表正常查询,不进行筛选
			for (int i = 0; i < result_users_all.size(); i++) {
				StatementHqDO shdo = new StatementHqDO();
				//1、设置用户ID
				shdo.setUserId(result_users_all.get(i).getUserId());
				//2、设置用户名
				shdo.setMemberName(result_users_all.get(i).getUnick());
				//3、设置注册时间
				shdo.setRegistertime(result_users_all.get(i).getRegistertime());
				//4、设置手机号
				shdo.setUsername(result_users_all.get(i).getUsername() == 
						null?"无":result_users_all.get(i).getUsername().replace(result_users_all.get(i).getUsername().substring(4, 8), "****"));
				//5、设置注册设备号
				shdo.setDeviceNum(result_users_all.get(i).getRegisterip());
				
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
				
				//8、设置用户的商品消费总额
				double user_money_shops = 0.0;
				
				//将用户的订单和创客关联上
				
				for (int j = 0; j < tradeOrder_list_maker.size(); j++) {
					if (tradeOrder_list_maker.get(j).getBuyerUserId().longValue() == result_users_all
							.get(i).getUserId()) {
						user_money_shops += Double.parseDouble(tradeOrder_list_maker
								.get(j).getPrice());
					}
				}
				
				shdo.setShopsMoney(user_money_shops);
				//9、设置用户的服务消费额
				//9.1、先通过用户的ID查询出来，用户所有的服务订单
				double user_money_services = 0.0;
				
				for (int k = 0; k < servicesOrdersDO_list_maker.size();k++) {
					
					if (servicesOrdersDO_list_maker.get(k).getBuyerUserId().longValue() == result_users_all.get(i).getUserId()) {
						user_money_services += Double.parseDouble(servicesOrdersDO_list_maker.get(k).getPrice());
					}
				}
				
				shdo.setServiceMoney(user_money_services);
				//设置用户总的消费额度
				shdo.setTotalMoney(user_money_services + user_money_shops);
				
				if ((user_money_services + user_money_shops) == 0) {
					for (int j = 0; j < result_users_maker.size(); j++) {
						if (result_users_maker.get(j).getUserId() == result_users_all.get(i).getUserId()) {
							shdo.setServiceMoney(0.0);
							shdo.setShopsMoney(0.0);
							shdo.setTotalMoney(0.0);
							list_detail.add(shdo);
						}
					}
					
				}else{
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
			Date date_beginDate = dateFormat.parse(beginDate);
			long long_beginDate = date_beginDate.getTime();
			Date date_endDate = dateFormat.parse(endDate);
			long long_endDate = date_endDate.getTime();
			
			for (int i = 0; i < result_users_all.size(); i++) {
				//将用户的注册时间转化为date类型
				Date date_registertime = dateFormat.parse(result_users_all.get(i).getRegistertime());
				long long_registertime = date_registertime.getTime();
				if (long_registertime >= long_beginDate && long_registertime <= long_endDate ) {
					StatementHqDO shdo = new StatementHqDO();
					//1、设置用户ID
					shdo.setUserId(result_users_all.get(i).getUserId());
					//2、设置用户名
					shdo.setMemberName(result_users_all.get(i).getUnick());
					//3、设置注册时间
					shdo.setRegistertime(result_users_all.get(i).getRegistertime());
					//4、设置手机号
					shdo.setUsername(result_users_all.get(i).getUsername() == 
							null?"无":result_users_all.get(i).getUsername().replace(result_users_all.get(i).getUsername().substring(4, 8), "****"));
					//5、设置注册设备号
					shdo.setDeviceNum(result_users_all.get(i).getRegisterip());
					
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
					
					//8、设置用户的商品消费总额
					double user_money_shops = 0.0;
					
					//将用户的订单和创客关联上
					
					for (int j = 0; j < tradeOrder_list_maker.size(); j++) {
						if (tradeOrder_list_maker.get(j).getBuyerUserId().longValue() == result_users_all
								.get(i).getUserId()) {
							user_money_shops += Double.parseDouble(tradeOrder_list_maker
									.get(j).getPrice());
						}
					}
					
					shdo.setShopsMoney(user_money_shops);
					//9、设置用户的服务消费额
					//9.1、先通过用户的ID查询出来，用户所有的服务订单
					double user_money_services = 0.0;
					
					for (int k = 0; k < servicesOrdersDO_list_maker.size();k++) {
						
						if (servicesOrdersDO_list_maker.get(k).getBuyerUserId().longValue() == result_users_all.get(i).getUserId()) {
							user_money_services += Double.parseDouble(servicesOrdersDO_list_maker.get(k).getPrice());
						}
					}
					
					shdo.setServiceMoney(user_money_services);
					//设置用户总的消费额度
					shdo.setTotalMoney(user_money_services + user_money_shops);
					
					if ((user_money_services + user_money_shops) == 0) {
						for (int j = 0; j < result_users_maker.size(); j++) {
							if (result_users_maker.get(j).getUserId() == result_users_all.get(i).getUserId()) {
								shdo.setServiceMoney(0.0);
								shdo.setShopsMoney(0.0);
								shdo.setTotalMoney(0.0);
								list_detail.add(shdo);
							}
						}
						
					}else{
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
		
		//先判断登录的用户是否是创客，如果不是就返回
		Result<MakerDO> maker_result = makerManager.queryMakerDOBySysUserId(sYSUserId);
		MakerDO makerDO = maker_result.getResult();
		
		if (makerDO == null) {
			jsonObject.put("message", "身份不对，请换账号重试");
			return jsonObject.toString();
		}
		//获取注册用户总数
		UsersQuery query = new UsersQuery();
		List<UsersDO> result_users_all = usersManager.queryUserDOlist(query);
		//获取和本创客想关联的用户
		List<UsersDO> result_users_maker = new ArrayList<UsersDO>();
		//将用户的信息，和创客关联起来
		DeviceMakerQuery query_maker = new DeviceMakerQuery();
		
		query_maker.setMakerId(makerDO.getId());//将设备号找到
		List<DeviceMakerDO> maker_device_list = makerManager.queryDeviceMaker(query_maker);
		
		for (int i = 0; i < result_users_all.size(); i++) {
			for (int j = 0; j < maker_device_list.size(); j++) {
				Result<DeviceDO> deviceDO = deviceManager.queryDeviceDOById(maker_device_list.get(j).getDeviceId());
				if (deviceDO.getResult() != null) {
					if (result_users_all.get(i).getRegisterip().equals(deviceDO.getResult().getProductNo())) {
						result_users_maker.add(result_users_all.get(i));
					}
				}
			}
		}
		
		List<StatementHqDetailDO> list = new ArrayList<StatementHqDetailDO>();
		
		TradeOrderQuery query_ = new TradeOrderQuery();
		query_.setBuyerUserId(buyUserId);
		
		//拿着购买人ID，在数据库中查出该用户所有的商品订单
		List<TradeOrderDO> list_order_by_buyUser = tradeOrderManager.queryTraderOrder(query_);
		
		//要在里面筛选出来，属于该创客的订单
		List<TradeOrderDO> tradeOrderDO_list = tradeOrderManager.queryTraderOrderList();
		//所有属于该创客的商品订单
		List<TradeOrderDO> tradeOrder_list_maker = new ArrayList<TradeOrderDO>();
		
		
		
		for (int i = 0; i < tradeOrderDO_list.size(); i++) {
			for (int j = 0; j < result_users_maker.size(); j++) {
				if (tradeOrderDO_list.get(i).getBuyerUserId().longValue() 
						== list_order_by_buyUser.get(j).getBuyerUserId().longValue()) {
					tradeOrder_list_maker.add(tradeOrderDO_list.get(i));
				}
			}
		}
		
		//拿着购买人token，查询出该用户所有的服务订单
		ServicesOrdersQuery serviceOrdersQuery = new ServicesOrdersQuery();
		serviceOrdersQuery.setBuyerUserId(buyUserId);
		List<ServicesOrdersDO> ServicesOrdersDO_list_user = tradeOrderManager.queryServicesOrdersDO(serviceOrdersQuery);
		
		
		List<ServicesOrdersDO> ServicesOrdersDO__maker_list_user = new ArrayList<ServicesOrdersDO>();
		
		for (int i = 0; i < ServicesOrdersDO_list_user.size(); i++) {
			for (int j = 0; j < result_users_maker.size(); j++) {
				if (ServicesOrdersDO_list_user.get(i).getBuyerUserId().longValue() 
						== list_order_by_buyUser.get(j).getBuyerUserId().longValue()) {
					ServicesOrdersDO__maker_list_user.add(ServicesOrdersDO_list_user.get(i));
				}
			}
		}
		
		
		
		//不根据时间查询
		if (beginDate.equals("") || beginDate == null ||
		endDate.equals("") || endDate== null) {
			
			 for (int i = 0; i < ServicesOrdersDO__maker_list_user.size(); i++) {
					//代表订单已经完成
					if (ServicesOrdersDO__maker_list_user.get(i).getStatus() == 2) {
						StatementHqDetailDO detailDO = new StatementHqDetailDO();
						//1、
						detailDO.setUserId(buyUserId);
						//2、
						detailDO.setOrderNum(ServicesOrdersDO__maker_list_user.get(i).getId());
						//3、
						detailDO.setOrderCreatTime(ServicesOrdersDO__maker_list_user.get(i).getCreated());
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
						detailDO.setTotalMoney(Double.parseDouble(ServicesOrdersDO__maker_list_user.get(i).getPrice()));
						//根据订单ID，查询各个的分成
						CommissionMoneyDO cmd = 
								tradeOrderManager.queryCommissionMoneyMoneyByOrederId(ServicesOrdersDO__maker_list_user.get(i).getId());
						if (cmd != null) {
							//10、设置店铺分成
							detailDO.setMakerMoney(Double.parseDouble(cmd.getMakerAmount()));
						}else{
							//10、设置店铺分成
							detailDO.setMakerMoney(0.0);
						}
						//13、设置店铺名称
						Result<ShopDO> shop_result = shopManager.queryShopDOById(ServicesOrdersDO__maker_list_user.get(i).getSellerUserId());
						if (shop_result.getResult() != null) {
							detailDO.setOthersName(shop_result.getResult().getShopsName());
						}else{
							detailDO.setOthersName("无");
						}
						list.add(detailDO);
					}
		         }
			
			
			
			for (int i = 0; i < tradeOrder_list_maker.size(); i++) {
				//这是订单下面包含子订单的做法
				if (tradeOrder_list_maker.get(i).getLevel() == 0  
						&& tradeOrder_list_maker.get(i).getStatus() == 4) {
					 //这样判断之后就是一级订单
					StatementHqDetailDO detailDO = new StatementHqDetailDO();
					
					detailDO.setUserId(buyUserId);
					//1、设置订单编号
					detailDO.setOrderNum(tradeOrder_list_maker.get(i).getOrderId());
					//2、设置购买时间
					detailDO.setOrderCreatTime(tradeOrder_list_maker.get(i).getCreated());
					
					Result<List<TradeOrderDO>> list_result = 
							tradeOrderManager.queryChildOrderList(tradeOrder_list_maker.get(i).getOrderId());
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
					detailDO.setTotalMoney(Double.parseDouble(tradeOrder_list_maker.get(i).getPrice()));
					
					//根据订单ID，查询各个的分成
					CommissionMoneyDO cmd = tradeOrderManager.queryCommissionMoneyMoneyByOrederId(tradeOrder_list_maker.get(i).getOrderId());
					if (cmd != null) {
						//11、设置创客分成
						detailDO.setMakerMoney(Double.parseDouble(cmd.getMakerAmount()));
					}else{
						//11、设置创客分成
						detailDO.setMakerMoney(0.0);
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
			
            for (int i = 0; i < ServicesOrdersDO__maker_list_user.size(); i++) {
				
				if (ServicesOrdersDO__maker_list_user.get(i).getCreated() >= long_beginDate 
						&&  ServicesOrdersDO__maker_list_user.get(i).getCreated()<= long_endDate) {
				
				//代表订单已经完成
				if (ServicesOrdersDO__maker_list_user.get(i).getStatus() == 2) {
					StatementHqDetailDO detailDO = new StatementHqDetailDO();
					//1、
					detailDO.setUserId(buyUserId);
					//2、
					detailDO.setOrderNum(ServicesOrdersDO__maker_list_user.get(i).getId());
					//3、
					detailDO.setOrderCreatTime(ServicesOrdersDO__maker_list_user.get(i).getCreated());
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
					detailDO.setTotalMoney(Double.parseDouble(ServicesOrdersDO__maker_list_user.get(i).getPrice()));
					//根据订单ID，查询各个的分成
					CommissionMoneyDO cmd = 
							tradeOrderManager.queryCommissionMoneyMoneyByOrederId(ServicesOrdersDO__maker_list_user.get(i).getId());
					if (cmd != null) {
						//10、设置店铺分成
						detailDO.setMakerMoney(Double.parseDouble(cmd.getMakerAmount()));
					}else{
						//10、设置店铺分成
						detailDO.setMakerMoney(0.0);
					}
					//13、设置店铺名称
					Result<ShopDO> shop_result = shopManager.queryShopDOById(ServicesOrdersDO__maker_list_user.get(i).getSellerUserId());
					if (shop_result.getResult() != null) {
						detailDO.setOthersName(shop_result.getResult().getShopsName());
					}else{
						detailDO.setOthersName("无");
					}
					list.add(detailDO);
				}
			}
	     }
			
			for (int i = 0; i < tradeOrder_list_maker.size(); i++) {
				
				if (tradeOrder_list_maker.get(i).getCreated() >= long_beginDate 
						&&  tradeOrder_list_maker.get(i).getCreated() <= long_endDate) {
					//这是订单下面包含子订单的做法
					if (tradeOrder_list_maker.get(i).getLevel() == 0  
							&& tradeOrder_list_maker.get(i).getStatus() == 4) {
						 //这样判断之后就是一级订单
						StatementHqDetailDO detailDO = new StatementHqDetailDO();
						
						detailDO.setUserId(buyUserId);
						//1、设置订单编号
						detailDO.setOrderNum(tradeOrder_list_maker.get(i).getOrderId());
						//2、设置购买时间
						detailDO.setOrderCreatTime(tradeOrder_list_maker.get(i).getCreated());
						
						
						Result<List<TradeOrderDO>> list_result = 
								tradeOrderManager.queryChildOrderList(tradeOrder_list_maker.get(i).getOrderId());
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
						detailDO.setTotalMoney(Double.parseDouble(tradeOrder_list_maker.get(i).getPrice()));
						
						//根据订单ID，查询各个的分成
						CommissionMoneyDO cmd = tradeOrderManager.queryCommissionMoneyMoneyByOrederId(tradeOrder_list_maker.get(i).getOrderId());
						if (cmd != null) {
							//11、设置创客分成
							detailDO.setMakerMoney(Double.parseDouble(cmd.getMakerAmount()));
						}else{
							//11、设置创客分成
							detailDO.setMakerMoney(0.0);
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
