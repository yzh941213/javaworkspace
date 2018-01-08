/*package com.zhezhuo.web.system.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
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
import com.zhezhuo.web.util.HttpUtils;

@DisallowConcurrentExecution
public class TaskLogisticQuery extends QuartzJobBean {

	private TradeOrderManager tradeOrderManager;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// 获取JobExecutionContext中的service对象
		try {
			SchedulerContext skedCtx = context.getScheduler().getContext();
			tradeOrderManager = (TradeOrderManager) skedCtx.get("tradeOrderManager");
			TradeOrderQuery query = new TradeOrderQuery();
			query.setStatuss(4);
			Result<List<TradeOrderListDTO>> result = tradeOrderManager.queryTraderOrderList(query,-1);
			List<TradeOrderListDTO> list = result.getResult();

			ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
			System.out.println("任务名称 = [" + scheduleJob.getName() + "]" + " 在 " + dateFormat.format(new Date())
					+ " 时运行 结果：" + list.size() + "条数数据");
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
*/