package com.zhezhuo.web.home.module.screen.manager;

import java.util.List;

import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.ScheduleJobService;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ScheduleJob;

/**
 * 定时任务 controller
 * 
 */
@Controller
@RequestMapping("/manager/scheduleJob")
public class ScheduleJobController {

	@Autowired
	private ScheduleJobService scheduleJobService;

	/**
	 * 获取任务
	 * 
	 * @return
	 */
	@RequestMapping("/list.do")
	@ResponseBody
	public String getAllScheduleJob() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		List<ScheduleJob> scheduleJobs = scheduleJobService.getAllScheduleJob();
		Result<List<ScheduleJob>> result = new Result<List<ScheduleJob>>();
		result.setResult(scheduleJobs);
		jsonObject.put("success", true);
		jsonObject.put("data", JSONArray.toJSON(result.getResult()));
		return jsonObject.toString();
	}
	
	@RequestMapping("/detail.do")
	@ResponseBody
	public String getJobDetail(@RequestParam(value = "name") String name, @RequestParam String group) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		ScheduleJob scheduleJob = scheduleJobService.getScheduleJob(name,group);
		Result<ScheduleJob> result = new Result<ScheduleJob>();
		result.setResult(scheduleJob);
		jsonObject.put("success", true);
		jsonObject.put("data", JSONArray.toJSON(result.getResult()));
		return jsonObject.toString();
	}

	/**
	 * 获取正在运行的定时任务
	 */
	@RequestMapping("/running.do")
	@ResponseBody
	public String getAllJobsRun() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		List<ScheduleJob> scheduleJobs = scheduleJobService.getAllRuningScheduleJob();
		Result<List<ScheduleJob>> result = new Result<List<ScheduleJob>>();
		result.setResult(scheduleJobs);
		jsonObject.put("success", true);
		jsonObject.put("data", JSONArray.toJSON(result.getResult()));
		return jsonObject.toString();
	}

	/**
	 * 添加
	 * 
	 * @param user
	 * @param model
	 */
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam(value = "name") String name, @RequestParam String group,
			@RequestParam String className, @RequestParam String cronExpression, @RequestParam String description) {
		ScheduleJob scheduleJob = new ScheduleJob();
		scheduleJob.setClassName(className);
		scheduleJob.setCronExpression(cronExpression);
		scheduleJob.setDescription(description);
		scheduleJob.setGroup(group);
		scheduleJob.setName(name);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		scheduleJob.setStatus("1");
		scheduleJobService.add(scheduleJob);
		jsonObject.put("success", true);
		jsonObject.put("message", "任务添加成功");
		return jsonObject.toString();
	}

	/**
	 * 暂停任务
	 */
	@RequestMapping("/stop.do")
	@ResponseBody
	public String stop(@RequestParam String name, @RequestParam String group) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		scheduleJobService.stopJob(name, group);
		jsonObject.put("success", true);
		jsonObject.put("message", "任务暂停成功");
		return jsonObject.toString();
	}

	/**
	 * 删除任务
	 */
	@RequestMapping("/del.do")
	@ResponseBody
	public String delete(@RequestParam String name, @RequestParam String group) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		scheduleJobService.delJob(name, group);
		jsonObject.put("success", true);
		jsonObject.put("message", "任务删除成功");
		return jsonObject.toString();
	}

	/**
	 * 修改表达式
	 */
	@RequestMapping("/update.do")
	@ResponseBody
	public String update(@RequestParam String name, @RequestParam String group, @RequestParam String cronExpression) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		// 验证cron表达式
		if (CronExpression.isValidExpression(cronExpression)) {
			scheduleJobService.modifyTrigger(name, group, cronExpression);
			jsonObject.put("success", true);
			jsonObject.put("message", "表达式修改成功");
			return jsonObject.toString();
		} else {
			jsonObject.put("message", "Cron表达式不正确");
			return jsonObject.toString();
		}
	}

	/**
	 * 立即运行一次
	 */
	@RequestMapping("/startNow.do")
	@ResponseBody
	public String stratNow(@RequestParam String name, @RequestParam String group) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		scheduleJobService.startNowJob(name, group);
		jsonObject.put("success", true);
		jsonObject.put("message", "任务运行成功");
		return jsonObject.toString();
	}

	/**
	 * 恢复
	 */
	@RequestMapping("/resume.do")
	@ResponseBody
	public String resume(@RequestParam String name, @RequestParam String group) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", false);
		scheduleJobService.restartJob(name, group);
		jsonObject.put("success", true);
		jsonObject.put("message", "任务恢复成功");
		return jsonObject.toString();
	}

	/**
	 * 获取所有trigger
	 */
	// public void getTriggers(HttpServletRequest request) {
	// List<ScheduleJob> scheduleJobs = scheduleJobService.getTriggersInfo();
	// System.out.println(scheduleJobs.size());
	// request.setAttribute("triggers", scheduleJobs);
	// }

}
