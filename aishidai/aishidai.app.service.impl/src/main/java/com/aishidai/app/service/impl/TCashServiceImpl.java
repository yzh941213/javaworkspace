package com.aishidai.app.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.zhezhuo.biz.dao.CraftsmenDAO;
import com.zhezhuo.biz.dao.DistributorDAO;
import com.zhezhuo.biz.dao.MakerDAO;
import com.zhezhuo.biz.dao.PercentageDAO;
import com.zhezhuo.biz.dao.ShopDAO;
import com.zhezhuo.biz.dao.SysUsersDAO;
import com.zhezhuo.biz.dao.TCashDAO;
import com.zhezhuo.biz.dao.TradeOrderDAO;
import com.zhezhuo.biz.manager.TCashManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.TCashDTO;
import com.zhezhuo.model.entity.CraftsmenDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.entity.MakerDO;
import com.zhezhuo.model.entity.PercentageDO;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.entity.SysUsersDO;
import com.zhezhuo.model.entity.TCashDO;
import com.zhezhuo.model.query.TCashQuery;

/**
 * Created by 蝈蝈 on 2016/9/28.
 */
public class TCashServiceImpl implements TCashManager {

	@Autowired
	TCashDAO tCashDAO;

	@Autowired
	SysUsersDAO usersDAO;

	@Autowired
	TradeOrderDAO tradeOrderDAO;

	@Autowired
	DistributorDAO distributorDAO;
	@Autowired
	ShopDAO shopDAO;
	@Autowired
	MakerDAO makerDAO;
	@Autowired
	CraftsmenDAO craftsmenDAO;
	@Autowired
	PercentageDAO percentgeDAO;

	Logger logger = LoggerFactory.getLogger(TCashServiceImpl.class);

	
	@Transactional
	public Result<Integer> updateTCashStatus(TCashDO tCashDO) {
		Result<Integer> result = new Result<Integer>();
		try {

			int row = tCashDAO.updateTCashDOStatus(tCashDO);
			if (row != 1) {
				throw new RuntimeException();
			}
			// 提现后更改余额balance
			SysUsersDO user = usersDAO.querySysUsersById(tCashDO.getUserId());
			if (user.getGroupId() == 0) {
				PercentageDO percentgeDO = percentgeDAO.queryPercentageDOById(1);// TODO
																					// 平台收入及余额
				percentgeDO.setBalance(percentgeDO.getBalance().subtract(new BigDecimal(tCashDO.getCash())));
				percentgeDAO.updatePercentageDOBalance(percentgeDO);
			} else if (user.getGroupId() == 1) {
				DistributorDO distributorDO = distributorDAO.queryDistributorDOBySysUserId(tCashDO.getUserId());
				distributorDO.setBalance(distributorDO.getBalance().subtract(new BigDecimal(tCashDO.getCash())));
				distributorDAO.updateDistributorDOBalance(distributorDO);
			} else if (user.getGroupId() == 2) {
				ShopDO shopDO = shopDAO.queryShopDOBySysUserId(tCashDO.getUserId());
				shopDO.setBalance(shopDO.getBalance().subtract(new BigDecimal(tCashDO.getCash())));
				shopDAO.updateShopDOBalance(shopDO);
			} else if (user.getGroupId() == 3) {
				MakerDO makerDO = makerDAO.queryMakerDOBySysUserId(tCashDO.getUserId());
				makerDO.setBalance(makerDO.getBalance().subtract(new BigDecimal(tCashDO.getCash())));
				makerDAO.updateMakerDOBalance(makerDO);
			} else if (user.getGroupId() == 4) {
				CraftsmenDO craftsmenDO = craftsmenDAO.queryCraftsmenDOBySysUserId(tCashDO.getUserId());
				craftsmenDO.setBalance(craftsmenDO.getBalance().subtract(new BigDecimal(tCashDO.getCash())));
				craftsmenDAO.updateCraftsmanDOBalance(craftsmenDO);
			}
			result.setSuccess(true);
			result.setResult(1);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	
	public Result<List<TCashDTO>> queryTCashList(TCashQuery query) {
		Result<List<TCashDTO>> result = new Result<List<TCashDTO>>();
		try {
			query.setTotalItem(tCashDAO.queryTCashListCount(query));
			List<TCashDTO> list = tCashDAO.queryTCashList(query);
			// if (!list.isEmpty()) {
			// for (TCashDTO t : list) {
			// UsersDO u = usersDAO.queryUserDOById(t.getUserId());
			// t.setCreated(DateTimeUtil.toDataString(t.getCreated()));
			// //t.setTrueName(u.getTrueName());
			// //t.setUname(u.getUname());
			// }
			// }
			result.setResult(list);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			result.setSuccess(false);
			return result;
		}
	}

	
	public Result<TCashDO> queryTcashDOById(long caId) {
		Result<TCashDO> result = null;
		try {
			TCashDO tCashDO = tCashDAO.queryTCashById(caId);
			result = new Result<TCashDO>();
			result.setSuccess(true);
			result.setResult(tCashDO);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(true);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Result<Long> editTCashDO(TCashDO tCashDO) {
		Result<Long> result = null;
		try {
			long row = tCashDAO.editTCashDO(tCashDO);
			result = new Result<Long>();
			result.setSuccess(true);
			result.setResult(row);
			if (row == 0) {
				result.setSuccess(false);
				result.setErrorInfo("数据操作失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}
}
