package com.aishidai.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhezhuo.biz.dao.CraftsmenDAO;
import com.zhezhuo.biz.dao.DistributorDAO;
import com.zhezhuo.biz.dao.MakerDAO;
import com.zhezhuo.biz.dao.OrderPercentageDAO;
import com.zhezhuo.biz.dao.ShopDAO;
import com.zhezhuo.biz.dao.UsersDAO;
import com.zhezhuo.biz.manager.ReportManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.ReportDTO;
import com.zhezhuo.model.entity.ShopDO;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class ReportServiceImpl implements ReportManager {
	@Autowired
	private OrderPercentageDAO orderPercentageDAO;
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private DistributorDAO distributorDAO;
	@Autowired
	private ShopDAO shopDAO;
	@Autowired
	private MakerDAO makerDAO;
	@Autowired
	private CraftsmenDAO craftsmenDAO;

	
	public Result<ReportDTO> querySysReport() {
		Result<ReportDTO> result = new Result<ReportDTO>();
		try {
			ReportDTO dto = new ReportDTO();
			ReportDTO reportOrderDTO = orderPercentageDAO.queryStatOrderSys();
			dto.setOrderCount(reportOrderDTO.getOrderCount());
			dto.setSalesAmount(reportOrderDTO.getSalesAmount());
			dto.setMySalesAmount(reportOrderDTO.getMySalesAmount());

			ReportDTO reportServiceDTO = orderPercentageDAO.queryStatServiceSys();
			dto.setOrderCountServices(reportServiceDTO.getOrderCountServices());
			dto.setServicesAmount(reportServiceDTO.getServicesAmount());
			dto.setMyServicesAmount(reportServiceDTO.getMyServicesAmount());

			dto.setAmount(dto.getMySalesAmount().add(dto.getMyServicesAmount()));
			dto.setUserCount(usersDAO.queryUsersCount());
			dto.setDistributorCount(distributorDAO.queryDistributorCount());
			dto.setShopCount(shopDAO.queryShopAndOtherShopCount());
			dto.setMakerCount(makerDAO.queryMakerCount());
			dto.setCraftsmenCount(craftsmenDAO.queryCraftsmenCount());
			result.setResult(dto);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Result<ReportDTO> queryDistributorReport(Long id) {
		Result<ReportDTO> result = new Result<ReportDTO>();
		try {
			ReportDTO dto = new ReportDTO();
			ReportDTO reportOrderDTO = orderPercentageDAO.queryStatOrderByDistributor(id);
			dto.setOrderCount(reportOrderDTO.getOrderCount());
			dto.setSalesAmount(reportOrderDTO.getSalesAmount());
			dto.setMySalesAmount(reportOrderDTO.getMySalesAmount());

			ReportDTO reportServiceDTO = orderPercentageDAO.queryStatServiceByDistributor(id);
			dto.setOrderCountServices(reportServiceDTO.getOrderCountServices());
			dto.setServicesAmount(reportServiceDTO.getServicesAmount());
			dto.setMyServicesAmount(reportServiceDTO.getMyServicesAmount());
			dto.setAmount(dto.getMySalesAmount().add(dto.getMyServicesAmount()));

			dto.setUserCount(usersDAO.queryUsersCountByDistributor(id));
			// dto.setDistributorCount(distributorDAO.queryDistributorCount());
			dto.setShopCount(shopDAO.queryShopAndOtherShopCountBydistributorId(id));
			dto.setMakerCount(makerDAO.queryMakerCountByDistributor(id));
			dto.setCraftsmenCount(craftsmenDAO.queryCraftsmenCountByDistributor(id));
			result.setResult(dto);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Result<ReportDTO> queryShopReport(ShopDO shopDO) {
		Result<ReportDTO> result = new Result<ReportDTO>();
		try {
			ReportDTO dto = new ReportDTO();
			ReportDTO reportOrderDTO = orderPercentageDAO.queryStatOrderByShop(shopDO.getShopsId());
			dto.setOrderCount(reportOrderDTO.getOrderCount());
			if(reportOrderDTO.getSalesAmount()!=null){
				dto.setSalesAmount(reportOrderDTO.getSalesAmount());
			}
			if(reportOrderDTO.getMySalesAmount()!=null){
				dto.setMySalesAmount(reportOrderDTO.getMySalesAmount());
			}

			ReportDTO reportServiceDTO = orderPercentageDAO.queryStatServiceByShop(shopDO.getShopsId());
			dto.setOrderCountServices(reportServiceDTO.getOrderCountServices());
			if(reportServiceDTO.getServicesAmount()!=null){
				dto.setServicesAmount(reportServiceDTO.getServicesAmount());
			}
			if(reportServiceDTO.getMyServicesAmount()!=null){
				dto.setMyServicesAmount(reportServiceDTO.getMyServicesAmount());
			}
			dto.setAmount(dto.getMySalesAmount().add(dto.getMyServicesAmount()));

			dto.setUserCount(usersDAO.queryUsersCountByShop(shopDO.getShopsId()));
			// dto.setDistributorCount(distributorDAO.queryDistributorCount());
			// dto.setShopCount(shopDAO.queryShopCountByDistributor(id));
			// dto.setMakerCount(makerDAO.queryMakerCountByDistributor(id));
			dto.setCraftsmenCount(craftsmenDAO.queryCraftsmenCountByShop(shopDO.getShopsId()));
			result.setResult(dto);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Result<ReportDTO> queryMakerReport(Long id) {
		Result<ReportDTO> result = new Result<ReportDTO>();
		try {
			ReportDTO dto = new ReportDTO();
			ReportDTO reportOrderDTO = orderPercentageDAO.queryStatOrderByMaker(id);
			dto.setOrderCount(reportOrderDTO.getOrderCount());
			if(reportOrderDTO.getSalesAmount()!=null){
				dto.setSalesAmount(reportOrderDTO.getSalesAmount());
			}
			if(reportOrderDTO.getMySalesAmount()!=null){
				dto.setMySalesAmount(reportOrderDTO.getMySalesAmount());
			}

			ReportDTO reportServiceDTO = orderPercentageDAO.queryStatServiceByMaker(id);
			dto.setOrderCountServices(reportServiceDTO.getOrderCountServices());
			if(reportServiceDTO.getServicesAmount()!=null){
				dto.setServicesAmount(reportServiceDTO.getServicesAmount());
			}
			if(reportServiceDTO.getMyServicesAmount()!=null){
				dto.setMyServicesAmount(reportServiceDTO.getMyServicesAmount());
			}
			dto.setAmount(dto.getMySalesAmount().add(dto.getMyServicesAmount()));

			dto.setUserCount(usersDAO.queryUsersCountByMaker(id));
			// dto.setDistributorCount(distributorDAO.queryDistributorCount());
			// dto.setShopCount(shopDAO.queryShopCountByDistributor(id));
			// dto.setMakerCount(makerDAO.queryMakerCountByDistributor(id));
			dto.setCraftsmenCount(craftsmenDAO.queryCraftsmenCountByMaker(id));
			result.setResult(dto);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Result<ReportDTO> queryCraftsmenReport(Long id) {
		Result<ReportDTO> result = new Result<ReportDTO>();
		try {
			ReportDTO dto = new ReportDTO();
//			ReportDTO reportOrderDTO = orderPercentageDAO.queryStatOrderByCraftsmen(id);
//			dto.setOrderCount(reportOrderDTO.getOrderCount());
//			dto.setSalesAmount(reportOrderDTO.getSalesAmount());
//			dto.setMySalesAmount(reportOrderDTO.getMySalesAmount());

			ReportDTO reportServiceDTO = orderPercentageDAO.queryStatServiceByCraftsmen(id);
			dto.setOrderCountServices(reportServiceDTO.getOrderCountServices());
			dto.setServicesAmount(reportServiceDTO.getServicesAmount());
			dto.setMyServicesAmount(reportServiceDTO.getMyServicesAmount());
			dto.setAmount(dto.getMySalesAmount().add(dto.getMyServicesAmount()));

			// dto.setUserCount(usersDAO.queryUsersCountByCraftsmen(id));
			// dto.setDistributorCount(distributorDAO.queryDistributorCount());
			// dto.setShopCount(shopDAO.queryShopCountByDistributor(id));
			// dto.setMakerCount(makerDAO.queryMakerCountByDistributor(id));
			// dto.setCraftsmenCount(craftsmenDAO.queryCraftsmenCountByCraftsmen(id));
			result.setResult(dto);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

}
