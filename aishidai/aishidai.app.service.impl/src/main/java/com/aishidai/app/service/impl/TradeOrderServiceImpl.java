package com.aishidai.app.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.zhezhuo.biz.dao.DeviceDAO;
import com.zhezhuo.biz.dao.DistributorDAO;
import com.zhezhuo.biz.dao.ItemDAO;
import com.zhezhuo.biz.dao.MakerDAO;
import com.zhezhuo.biz.dao.PercentageDAO;
import com.zhezhuo.biz.dao.PropertyDAO;
import com.zhezhuo.biz.dao.ReturnOrderDAO;
import com.zhezhuo.biz.dao.ShopDAO;
import com.zhezhuo.biz.dao.SkuDAO;
import com.zhezhuo.biz.dao.TradeOrderDAO;
import com.zhezhuo.biz.dao.UsersDAO;
import com.zhezhuo.biz.manager.TradeOrderManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.OrderItemDetailDTO;
import com.zhezhuo.model.domain.TradeOrderDetailDTO;
import com.zhezhuo.model.domain.TradeOrderListDTO;
import com.zhezhuo.model.domain.TradeOrderReadonlyDTO;
import com.zhezhuo.model.entity.CommissionMoneyDO;
import com.zhezhuo.model.entity.DeviceDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.ItemDO;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.entity.PercentageDO;
import com.zhezhuo.model.entity.ServicesOrdersDO;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.entity.TradeOrderDO;
import com.zhezhuo.model.entity.UsersDO;
import com.zhezhuo.model.enums.OrderStatusEnum;
import com.zhezhuo.model.query.ServicesOrdersQuery;
import com.zhezhuo.model.query.TradeOrderQuery;

/**
 * Created by 蝈蝈 on 2016/9/28.
 */
public class TradeOrderServiceImpl implements TradeOrderManager {

	@Autowired
	private TradeOrderDAO tradeOrderDAO;
	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private SkuDAO skuDAO;
	@Autowired
	private PropertyDAO propertyDAO;
	@Autowired
	private ReturnOrderDAO returnOrderDAO;
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private DistributorDAO distributorDAO;
	@Autowired
	private MakerDAO makerDAO;
	@Autowired
	private ShopDAO shopDAO;
	@Autowired
	private PercentageDAO percentageDAO;
	@Autowired
	private DeviceDAO deviceDAO;

	Logger logger = LoggerFactory.getLogger(TradeOrderServiceImpl.class);

	
	public Result<List<TradeOrderListDTO>> queryTraderOrderList(TradeOrderQuery query,long userId) {
		Result<List<TradeOrderListDTO>> result = new Result<List<TradeOrderListDTO>>();
		try {
			query.setTotalItem(tradeOrderDAO.queryTradeOrderListCount(query));
			System.out.println("query======================"+query);
			List<TradeOrderListDTO> orders = tradeOrderDAO.queryTradeOrderList(query);
			if (!orders.isEmpty()) {
				for (TradeOrderListDTO listDTO : orders) {
					listDTO.setCreated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.format(new Date(Long.valueOf(listDTO.getCreated()) * 1000)));
					System.out.println("OrderStatusEnum----------"+OrderStatusEnum.getDescriptionByValue(listDTO.getStatus()));
					listDTO.setStatusDesc(OrderStatusEnum.getDescriptionByValue(listDTO.getStatus()));
					System.out.println("listDTO.get----------"+listDTO.getStatusDesc());
					List<TradeOrderDO> chileOrder = tradeOrderDAO.queryChildOrder(listDTO.getOrderId());
					List<OrderItemDetailDTO> items = new ArrayList<OrderItemDetailDTO>();
					if (chileOrder == null || chileOrder.isEmpty()) {
						ItemDO itemDO = itemDAO.queryItemDOById(listDTO.getItemId());
						OrderItemDetailDTO item = new OrderItemDetailDTO();
						if (itemDO != null) {
							System.out.println("itemDO======================="+itemDO);
							item.setItemName(itemDO.getItemName());
							item.setItemId(itemDO.getItemId());
							item.setSupplier(itemDO.getSupplier());
							item.setNumber(listDTO.getNumber());
							item.setSalesPrice(itemDO.getSalesPrice());
							if (itemDO.getImage().contains(";")) {
								item.setThumbnail(itemDO.getImage().split(";")[0]);
							} else {
								item.setThumbnail(itemDO.getImage());
							}

						}
						items.add(item);
					} else {
						for (TradeOrderDO order : chileOrder) {
							ItemDO itemDO = itemDAO.queryItemDOById(order.getItemId());
							OrderItemDetailDTO item = new OrderItemDetailDTO();
							if (itemDO != null) {
								item.setItemName(itemDO.getItemName());
								item.setItemId(order.getItemId());
								item.setNumber(order.getNumber());
								item.setSalesPrice(itemDO.getSalesPrice());
								if (itemDO.getImage().contains(";")) {
									item.setThumbnail(itemDO.getImage().split(";")[0]);
								} else {
									item.setThumbnail(itemDO.getImage());
								}
							}
							items.add(item);
						}
					}
					listDTO.setItems(items);
				}
			}
			if(userId!=-1||userId==14){
				orders = queryListById(orders,userId);
			}
			result.setResult(orders);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("TradeOrderListError----->" + e.getMessage());
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
	}
	
	public List<TradeOrderListDTO> queryListById(List<TradeOrderListDTO> orders,long userId){
		System.out.println("userId========================"+userId);
		List<TradeOrderListDTO> list = new ArrayList<TradeOrderListDTO>();
		for(TradeOrderListDTO dto : orders){
			try {
				long supplier = itemDAO.queryItemDOById(dto.getItemId()).getSupplier();
				System.out.println("OrderId============"+dto.getOrderId());
				System.out.println("supplier============"+supplier);
				if(supplier==userId){
					System.out.println("supplier============"+supplier);
					list.add(dto);
				}
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
		return list;
	}

	
	public Result<List<TradeOrderReadonlyDTO>> queryTraderOrderReadonly(TradeOrderQuery query) {
		Result<List<TradeOrderReadonlyDTO>> result = new Result<List<TradeOrderReadonlyDTO>>();
		try {
			query.setTotalItem(tradeOrderDAO.queryTradeOrderReadonlyCount(query));
			List<TradeOrderReadonlyDTO> orders = tradeOrderDAO.queryTradeOrderReadonly(query);
			result.setResult(orders);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("TradeOrderListError----->" + e.getMessage());
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
	}

	
	public Result<List<TradeOrderDO>> queryChildOrderList(long parentOrderId) {
		Result<List<TradeOrderDO>> result = new Result<List<TradeOrderDO>>();
		try {
			List<TradeOrderDO> orderDOs = tradeOrderDAO.queryChildOrder(parentOrderId);
			result.setResult(orderDOs);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("ChildTradeOrderError----->" + e.getMessage());
			result.setSuccess(false);
			return result;
		}
	}

	
	public Result<TradeOrderDetailDTO> queryTradeOrderDO(long orderId) {
		Result<TradeOrderDetailDTO> result = new Result<TradeOrderDetailDTO>();
		try {
			TradeOrderDetailDTO detailDTO = tradeOrderDAO.queryTradeOrder(orderId);
			if (detailDTO == null) {
				result.setSuccess(false);
				return result;
			}
			detailDTO.setStatusDesc(OrderStatusEnum.getDescriptionByValue(detailDTO.getStatus()));
			List<OrderItemDetailDTO> items = new ArrayList<OrderItemDetailDTO>();
			if (null == detailDTO.getItemId() || detailDTO.getItemId() <= 0) {
				List<TradeOrderDO> chileOrder = tradeOrderDAO.queryChildOrder(orderId);
				for (TradeOrderDO order : chileOrder) {
					ItemDO itemDO = itemDAO.queryItemDOById(order.getItemId());
					OrderItemDetailDTO item = new OrderItemDetailDTO();
					if (itemDO != null) {
						item.setItemName(itemDO.getItemName());
						item.setItemId(order.getItemId());
						item.setNumber(order.getNumber());
						item.setItemCode(itemDO.getItemCode());
						item.setSalesPrice(itemDO.getSalesPrice());
						item.setReturnOrderStatus(returnOrderDAO.queryReturnOrderStatus(order.getOrderId()));
						if (itemDO.getImage().contains(";")) {
							item.setThumbnail(itemDO.getImage().split(";")[0]);
						} else {
							item.setThumbnail(itemDO.getImage());
						}

						item.setColor(propertyDAO.queryPropertyNameById(order.getColorId()));
						item.setSize(propertyDAO.queryPropertyNameById(order.getSizeId()));
					}
					items.add(item);
				}
			} else {
				ItemDO itemDO = itemDAO.queryItemDOById(detailDTO.getItemId());
				OrderItemDetailDTO item = new OrderItemDetailDTO();
				if (itemDO != null) {
					item.setItemName(itemDO.getItemName());
					item.setItemId(detailDTO.getItemId());
					item.setNumber(detailDTO.getNumber());
					item.setSalesPrice(itemDO.getSalesPrice());
					item.setItemCode(itemDO.getItemCode());
					item.setReturnOrderStatus(returnOrderDAO.queryReturnOrderStatus(detailDTO.getOrderId()));
					if (itemDO.getImage().contains(";")) {
						item.setThumbnail(itemDO.getImage().split(";")[0]);
					} else {
						item.setThumbnail(itemDO.getImage());
					}
					item.setColor(propertyDAO.queryPropertyNameById(detailDTO.getColorId()));
					item.setSize(propertyDAO.queryPropertyNameById(detailDTO.getSizeId()));
				}
				items.add(item);
			}
			detailDTO.setItems(items);
			result.setResult(detailDTO);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("TradeOrderError----->" + e.getMessage());
			result.setSuccess(false);
			return result;
		}
	}

	
	
	
	
	@Transactional
	public Result<Long> updateTradeOrderStatus(TradeOrderQuery query) {
		Result<Long> result = new Result<Long>();
		TradeOrderDO queryOrder = tradeOrderDAO.queryTradeOrderDetail(query.getOrderId());
		if (StringUtils.isNotEmpty(queryOrder.getRemarks()) && StringUtils.isNotEmpty(query.getRemarks())) {
			query.setRemarks(queryOrder.getRemarks() + "," + query.getRemarks());
		}
		try {
			//TODO
			if (query.getStatuss() == 4) {// 订单完成
				// 计算分成
				UsersDO usesDO = usersDAO.queryUserDOById(queryOrder.getBuyerUserId());
				System.out.println("usesDO==null:"+(usesDO==null));
				query.setDeviceNo(usesDO.getRegisterip());
				DeviceDO deviceDO = deviceDAO.queryDeviceDOByProductNo(usesDO.getRegisterip());

				DistributorDO distributorDO = distributorDAO.queryDistributorDOById(deviceDO.getDistributorId());
				query.setDistributorId(deviceDO.getDistributorId());
				if (deviceDO == null) {
					throw new Exception("找不到绑定设备");
				}
				if (shopDAO == null) {
					throw new Exception("对象不存在");
				}


				String s = "100";// 改成百分之
				query.setSysAmount(new BigDecimal(queryOrder.getPrice()).multiply(
						new BigDecimal(s).subtract(new BigDecimal(String.valueOf(distributorDO.getOrderPercentage())))
								.divide(new BigDecimal(s))));
				PercentageDO percentageDO = percentageDAO.queryPercentageDOById(1);
				percentageDO.setId(new Long(1));
				percentageDO.setAmount(percentageDO.getAmount().add(query.getSysAmount()));
				percentageDO.setBalance(percentageDO.getBalance().add(query.getSysAmount()));
				percentageDAO.updatePercentageDOAmount(percentageDO);

				/*if (makerDO.getOrderPercentage() == 0) {
					query.setMakerAmount(new BigDecimal(0));
				} else {
					query.setMakerAmount(new BigDecimal(queryOrder.getPrice())
							.multiply(new BigDecimal(String.valueOf(distributorDO.getOrderPercentage()))
									.divide(new BigDecimal(s)))
							.multiply(new BigDecimal(String.valueOf(makerDO.getOrderPercentage()))
									.divide(new BigDecimal(s))));
					makerDO.setAmount(makerDO.getAmount().add(query.getMakerAmount()));
					makerDO.setBalance(makerDO.getBalance().add(query.getMakerAmount()));
					makerDAO.updateMakerDOAmount(makerDO);
				}*/

			/*	if (shopDO != null && shopDO.getOrderPercentage() > 0) {
					query.setShopAmount(new BigDecimal(queryOrder.getPrice())
							.multiply(new BigDecimal(String.valueOf(distributorDO.getOrderPercentage()))
									.divide(new BigDecimal(s)))
							.multiply(new BigDecimal(String.valueOf(shopDO.getOrderPercentage()))
									.divide(new BigDecimal(s))));
					shopDO.setAmount(shopDO.getAmount().add(query.getShopAmount()));
					shopDO.setBalance(shopDO.getBalance().add(query.getShopAmount()));
					shopDAO.updateShopDOAmount(shopDO);
				} else {
					query.setShopAmount(new BigDecimal(0));
				}
*/
				if (distributorDO.getOrderPercentage() == 0) {
					query.setDistributorAmount(new BigDecimal(0));
				} else {
					query.setDistributorAmount(new BigDecimal(queryOrder.getPrice())
							.multiply(new BigDecimal(String.valueOf(distributorDO.getOrderPercentage()))
									.divide(new BigDecimal(s)))
							.subtract(query.getMakerAmount()));
					distributorDO.setAmount(distributorDO.getAmount().add(query.getDistributorAmount()));
					distributorDO.setBalance(distributorDO.getBalance().add(query.getDistributorAmount()));
					distributorDAO.updateDistributorDOAmount(distributorDO);
				}
			}

			long row = tradeOrderDAO.updateTradeOrderStatus(query);
			if (row > 0) {
				// TODO: 2016/9/28 sendnotice
				result.setResult(row);
				result.setSuccess(true);
			} else {
				throw new RuntimeException();
			}
			if (query.getStatuss() == 1 || query.getStatuss() == 4) { // 取消订单增加库存
				TradeOrderDO orderDO = tradeOrderDAO.queryTradeOrderDetail(query.getOrderId());
				if (orderDO == null) {
					result.setResult(-1l);
					result.setErrorInfo("该订单不存在");
					return result;
				}
				List<TradeOrderDO> orderDOs = tradeOrderDAO.queryChildOrder(query.getOrderId());
				if (query.getStatuss() == 1) { // 取消订单
					if (orderDOs == null || orderDOs.isEmpty()) {
						// 没有子订单
						int i = skuDAO.updateStock(orderDO);
						if (i != 1) {
							throw new RuntimeException();
						}

					} else {
						// 有子订单
						for (TradeOrderDO order : orderDOs) {
							int i = skuDAO.updateStock(order);
							if (i != 1) {
								throw new RuntimeException();
							}
						}
					}
				} else { // 确认收货
					if (orderDOs == null || orderDOs.isEmpty()) {
						// 没有子订单
						int i = skuDAO.updateSalseVolume(orderDO);
						if (i != 1) {
							throw new RuntimeException();
						}

					} else {
						// 有子订单
						for (TradeOrderDO order : orderDOs) {
							int i = skuDAO.updateSalseVolume(order);
							if (i != 1) {
								throw new RuntimeException();
							}
						}
					}
				}

			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("UpdateTradeOrderStatus----->" + e.getMessage());
			throw new RuntimeException();
		}
	}

	
	
	
	public Result<TradeOrderReadonlyDTO> queryTradeOrderStat(TradeOrderQuery query) {
		Result<TradeOrderReadonlyDTO> result = new Result<TradeOrderReadonlyDTO>();
		try {
			TradeOrderReadonlyDTO stat = tradeOrderDAO.queryTradeOrderStat(query);
			if (stat == null) {
				result.setSuccess(false);
				return result;
			} else {
				result.setResult(stat);
				result.setSuccess(true);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("queryTradeOrderStat----->" + e.getMessage());
			throw new RuntimeException();
		}
	}

	
	public int editOrderStatus(TradeOrderDO tradeOrderDO) {
		int result = tradeOrderDAO.updateOrderDOStatus(tradeOrderDO);
		return result;
	}

	
	public TradeOrderDO queryOrderDOByOrderId(long orderId) {
		// TODO Auto-generated method stub
		TradeOrderDO resulr = tradeOrderDAO.queryOrderDOByOrderId(orderId);
		return resulr;
	}
	
	public int editOrderDOCancel(TradeOrderDO tradeOrderDO) {
		// TODO Auto-generated method stub
		int result = tradeOrderDAO.editOrderDOCancel(tradeOrderDO);
		return result;
	}

	
	public List<TradeOrderDO> queryTraderOrderList() throws Exception {
		// TODO Auto-generated method stub
		return tradeOrderDAO.selectTraderOrderList();
	}

	
	public List<ServicesOrdersDO> queryServicesOrdersDOList()throws Exception {
		// TODO Auto-generated method stub
		List<ServicesOrdersDO> list = tradeOrderDAO.selectServicesOrederDOList();
		System.out.println(list.toString());
		return list;
	}

	
	public List<TradeOrderDO> queryTraderOrder(TradeOrderQuery orderQuery)throws Exception {
		// TODO Auto-generated method stub
		return tradeOrderDAO.selectTraderOrder(orderQuery);
	}

	
	public List<ServicesOrdersDO> queryServicesOrdersDO(
			ServicesOrdersQuery serviceQuery) throws Exception {
		// TODO Auto-generated method stub
		return tradeOrderDAO.selectServicesOrdersDO(serviceQuery);
	}

	
	public CommissionMoneyDO queryCommissionMoneyMoneyByOrederId(Long orderId)
			throws Exception {
		// TODO Auto-generated method stub
		return tradeOrderDAO.selectCommissionMoneyMoneyByOrederId(orderId);
	}
}
