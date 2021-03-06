package com.microblog.scheduler.quartz.job;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @program: top-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-20 11:34
 **/
public class HelloJob1 extends AbstractJob implements Job {

    public static String description = "我是HelloJob";


    private  static  final Logger log = LoggerFactory.getLogger(HelloJob1.class);
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("Hello job 1 任务正在运行....，" + "当前时间 = " + new Date().toString());
        JobKey key = jobExecutionContext.getJobDetail().getKey();

        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();

        String jobSays = dataMap.getString("mykey");


    }
}
