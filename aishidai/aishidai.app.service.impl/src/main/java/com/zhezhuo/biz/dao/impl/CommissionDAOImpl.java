package com.zhezhuo.biz.dao.impl;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.CommissionDAO;
import com.zhezhuo.model.entity.HqCommissionDO;
import com.zhezhuo.model.entity.MakerCommissionDetailDO;
import com.zhezhuo.model.entity.OtherShopCommissionDO;
import com.zhezhuo.model.entity.ShopCommissionDO;
import com.zhezhuo.model.query.HqCommissionQuery;
import com.zhezhuo.model.query.OtherShopCommissionQuery;
import com.zhezhuo.model.query.ShopCommissionQuery;

import java.util.List;


public class CommissionDAOImpl extends BaseDAO implements CommissionDAO {

    public OtherShopCommissionDO selectOtherShopCommissionDOByOtherShopId(long otherShopId) throws Exception {
        return null;
    }

    public ShopCommissionDO selectShopCommissionDOByShopId(long shopId) throws Exception {
        return null;
    }

    public List<MakerCommissionDetailDO> selectMakerCommissionDetailDOListByShopId(long makerId) throws Exception {
        return null;
    }

    public int updateMakerCommissionDetailDOByShopId(long makerId) throws Exception {
        return 0;
    }

    public void insetOtherShopCommissionDO(OtherShopCommissionDO otherShopCommissionDO) throws Exception {

    }

    public void insetShopCommissionDO(ShopCommissionDO shopCommissionDO) throws Exception {

    }

    public void insetMakerCommissionDetailDO(MakerCommissionDetailDO makerCommissionDetailDO) throws Exception {

    }

    public List<ShopCommissionDO> selectShopCommissionDOList(ShopCommissionQuery query) throws Exception {
        return null;
    }

    public List<OtherShopCommissionDO> selectOtherShopCommissionDOList(OtherShopCommissionQuery query) throws Exception {
        return null;
    }

    public int selectShopCommissionCount(ShopCommissionQuery query) throws Exception {
        return 0;
    }

    public int selectOtherShopCommissionCount(OtherShopCommissionQuery query) throws Exception {
        return 0;
    }

    public OtherShopCommissionDO selectOtherShopCommissionDOById(String id) throws Exception {
        return null;
    }

    public ShopCommissionDO selectShopCommissionDOById(String id) throws Exception {
        return null;
    }

    public List<MakerCommissionDetailDO> selectMakerCommissionDOByOtherShopId(Long otherShopId) throws Exception {
        return null;
    }

    public List<MakerCommissionDetailDO> selectMakerCommissionDOByShopId(Long shopId) throws Exception {
        return null;
    }

    public List<OtherShopCommissionDO> selectHqCommissionList(HqCommissionQuery query) throws Exception {
        return null;
    }

    public int selectHqCommissionListCount(HqCommissionQuery query) throws Exception {
        return 0;
    }

    public HqCommissionDO selectHqCommissionDOById(String id) throws Exception {
        return null;
    }

    public void insetHqCommissionDO(HqCommissionDO hQC) throws Exception {

    }

    public int updateHqCommissionDO(HqCommissionDO hCD) throws Exception {
        return 0;
    }

    public int delHqCommissionDO(HqCommissionDO hqd) throws Exception {
        return 0;
    }

    public MakerCommissionDetailDO selectMakerCommissionDetailDOById(String id) throws Exception {
        return null;
    }

    public int delMakerCommissionDetailDO(MakerCommissionDetailDO result) throws Exception {
        return 0;
    }

    public int delShopCommissionDO(ShopCommissionDO result_shop) throws Exception {
        return 0;
    }

    public int delOtherShopCommissionDO(OtherShopCommissionDO result_otherShop) throws Exception {
        return 0;
    }

    public int updateShopCommissionDO(ShopCommissionDO sCDO) throws Exception {
        return 0;
    }

    public int updateOtherShopCommissionDO(OtherShopCommissionDO oSCD) throws Exception {
        return 0;
    }

    public int removeMakerCommissionDetailDO(MakerCommissionDetailDO make) throws Exception {
        return 0;
    }

    public List<ShopCommissionDO> selectShopCommissionListbByHq(ShopCommissionQuery query) throws Exception {
        return null;
    }

    public int selectShopCommissionCountByHq(ShopCommissionQuery query) throws Exception {
        return 0;
    }

    public List<OtherShopCommissionDO> selectOtherShopCommissionListByHq(OtherShopCommissionQuery query) throws Exception {
        return null;
    }

    public int selectOtherShopCommissionCountByHq(OtherShopCommissionQuery query) throws Exception {
        return 0;
    }

    public OtherShopCommissionDO selectOtherShopCommissionDOByShopId(long otherShopId) throws Exception {
        return null;
    }
}
