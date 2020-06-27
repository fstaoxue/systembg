package com.taoge.zxstbg.quartz.service;

import com.taoge.zxstbg.database.zxstbg.entity.SysJob;

public interface JobService {

    /**
     * 添加一个定时任务
     * @param job
     */
    void addCronJob(SysJob job);

    /**
     * 添加异步任务
     * @param jobName
     * @param jobGroup
     */
    void addAsyncJob(String jobName, String jobGroup);

    /**
     * 暂停任务
     * @param jobName
     * @param jobGroup
     */
    void pauseJob(String jobName, String jobGroup);

    /**
     * 恢复任务
     * @param triggerName
     * @param triggerGroup
     */
    void resumeJob(String triggerName, String triggerGroup);

    /**
     * 删除job
     * @param jobName
     * @param jobGroup
     */
    void deleteJob(String jobName, String jobGroup);


}
