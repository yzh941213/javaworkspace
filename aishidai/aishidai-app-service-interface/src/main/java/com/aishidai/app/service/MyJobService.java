package com.aishidai.app.service;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJobService implements Job {
	// public class EBankJob extends QuartzJobBean {
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("now:" + new Date().getTime());
		//org.springframework.scheduling.
		
	}

}
