package com.taoge.zxstbg.quartz.job;

import com.taoge.zxstbg.database.zxstbg.entity.SysJobLog;
import com.taoge.zxstbg.database.zxstbg.service.impl.SysJobLogServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author TXF
 * @date 2019/01/16
 */
public class CronJob implements Job {

    @Autowired
    private SysJobLogServiceImpl sysJobLogService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String jobId=(String)jobExecutionContext.getJobDetail().getJobDataMap().get("jobId");
        String jobName=jobExecutionContext.getJobDetail().getKey().getName();
        String jobGroup=jobExecutionContext.getJobDetail().getKey().getGroup();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result="jobId==>"+jobId;
        result+="jobName==>"+jobName;
        result+="jobGroup==>"+jobGroup;
        result+="当前时间是"+sdf.format(new Date());
        SysJobLog log=new SysJobLog();
        log.setJobId(Integer.parseInt(jobId));
        log.setRequest(UUID.randomUUID().toString());
        log.setResponse(result);
        log.setRequestTime(sdf.format(new Date()));
        log.setResponseTime(sdf.format(new Date()));
        System.out.println(result);
        sysJobLogService.insert(log);
    }
}
