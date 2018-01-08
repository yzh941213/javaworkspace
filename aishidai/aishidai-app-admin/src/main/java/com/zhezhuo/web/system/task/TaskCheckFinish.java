
/*package com.zhezhuo.web.system.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.zhezhuo.biz.manager.TradeOrderManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.TradeOrderListDTO;
import com.zhezhuo.model.entity.ScheduleJob;
import com.zhezhuo.model.query.TradeOrderQuery;

@DisallowConcurrentExecution
public class TaskCheckFinish extends QuartzJobBean {

	private TradeOrderManager tradeOrderManager;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// 获取JobExecutionContext中的service对象
		try {
			SchedulerContext skedCtx = context.getScheduler().getContext();
			tradeOrderManager = (TradeOrderManager) skedCtx.get("tradeOrderManager");
			TradeOrderQuery query = new TradeOrderQuery();
			query.setStatuss(3);
			int days = -10;
			Date date = new Date();// 取时间
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(calendar.DATE, days);// 把日期往后增加一天.整数往后推,负数往前移动
			date = calendar.getTime();
			query.setShipTime(date.getTime());
			Result<List<TradeOrderListDTO>> result = tradeOrderManager.queryTraderOrderList(query,-1);// TODO
																									// 订单量大的时候需要注意
			List<TradeOrderListDTO> list = result.getResult();
			TradeOrderQuery query1 = new TradeOrderQuery();
			query1.setStatuss(6);

			for (int i = 0; i < list.size(); i++) {
				TradeOrderListDTO dto = list.get(i);
				query1.setOrderId(dto.getOrderId());
				try {
					Result<Long> rs = tradeOrderManager.updateTradeOrderStatus(query1);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
			int row = 0;
			if (list != null) {
				row = list.size();
			}
			System.out.println("任务名称 = [" + scheduleJob.getName() + "]" + " 在 " + dateFormat.format(new Date())
					+ " 时运行 结果：" + row + "条数据影响");
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
*/