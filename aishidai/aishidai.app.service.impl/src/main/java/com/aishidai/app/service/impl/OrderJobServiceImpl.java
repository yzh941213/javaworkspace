package com.aishidai.app.service.impl;

import com.aishidai.app.dao.CommentDOMapper;
import com.aishidai.app.dao.TradeOrderDOCustomMapper;
import com.aishidai.app.dao.TradeOrderDOMapper;
import com.aishidai.app.model.pojo.CommentDO;
import com.aishidai.app.model.pojo.TradeOrderDO;
import com.aishidai.app.model.pojo.TradeOrderDOExample;
import com.aishidai.app.service.OrderJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderJobServiceImpl implements OrderJobService {

    @Autowired
    TradeOrderDOCustomMapper tradeOrderDOCustomMapper;

    @Autowired
    TradeOrderDOMapper tradeOrderDOMapper;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    CommentDOMapper commentDOMapper;

    public void ordersStatusCanning() {
        List<Integer> list=new ArrayList<Integer>();
        list.add(0);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        TradeOrderDOExample tradeOrderDOExample=new TradeOrderDOExample();
        tradeOrderDOExample.createCriteria().andStatusIn(list);
      List<TradeOrderDO> list1=  tradeOrderDOMapper.selectByExample(tradeOrderDOExample);
      for (TradeOrderDO tradeOrderDO:list1) {
          int status = tradeOrderDO.getStatus();
          //订单状态:0待付款1待发货2待收货3待评价4交易成功5交易关闭6取消交易7删除交易
          switch (status) {
              case 0:

                  logger.info("待付款 超过30分钟 取消 订单编号"+tradeOrderDO.getOrderNum());
                  if(differenceMin(new Date(tradeOrderDO.getCreated()),new Date())>30){

                      tradeOrderDO.setStatus(6);
                      tradeOrderDO.setCancelReason("超时取消");
                      tradeOrderDO.setCancelTime(Integer.valueOf((new Date().getTime()/1000)+""));
                      tradeOrderDO.setUpdated(Integer.valueOf((new Date().getTime()/1000)+""));

                      tradeOrderDOMapper.updateByPrimaryKeySelective(tradeOrderDO);
                  }

              case 1:
                  System.out.println("待发货");
              case 2:
                  System.out.println("待收货"+tradeOrderDO.getOrderNum());
                  if(differenceDay(new Date(tradeOrderDO.getCreated()),new Date())>15){

                      tradeOrderDO.setStatus(3);
                      tradeOrderDO.setReceiveTime(Integer.valueOf((new Date().getTime()/1000)+""));
                      tradeOrderDO.setUpdated(Integer.valueOf((new Date().getTime()/1000)+""));

                      tradeOrderDO.setReceiveType((byte)2);
                      tradeOrderDOMapper.updateByPrimaryKeySelective(tradeOrderDO);
                  }
              case 3:
                  System.out.println("待评价 超过30天 自动好评"+tradeOrderDO.getOrderNum());
                  if(differenceDay(new Date(tradeOrderDO.getCreated()),new Date())>30){

                      tradeOrderDO.setStatus(4);
                      tradeOrderDO.setUpdated(Integer.valueOf((new Date().getTime()/1000)+""));
                      tradeOrderDOMapper.updateByPrimaryKeySelective(tradeOrderDO);

                      if (tradeOrderDO.getOrderType()==2||tradeOrderDO.getOrderType()==3){
                          CommentDO commentDO=new CommentDO();
                          commentDO.setCreated(new Date());
                          commentDO.setComment("自动好评！");
                          commentDO.setType(1l);
                          commentDO.setStatus(1);
                          commentDO.setUpdated(new Date());
                          commentDO.setStar(5);
                          commentDOMapper.insert(commentDO);
                      }
                  }
              case 4:
                  System.out.println("交易成功");
              case 5:
                  System.out.println("关闭交易");
              case 6:
                  System.out.println("取消交易 超过15");
              case 7:
                  System.out.println("删除交易");

          }
      }
    }
    public Long differenceMin(Date endDate, Date nowDate){
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return min;
    };
    public Long differenceDay(Date endDate, Date nowDate){
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day;
    };
    public static String getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

}
