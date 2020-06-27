package com.taoge.zxstbg.quartz.controller;

import com.alibaba.fastjson.JSONObject;
import com.taoge.zxstbg.admin.util.AjaxResult;
import com.taoge.zxstbg.database.zxstbg.entity.SysJob;
import com.taoge.zxstbg.database.zxstbg.service.impl.SysJobServiceImpl;
import com.taoge.zxstbg.quartz.service.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author TXF
 * @date 2019/01/11
 */
@Controller
@RequestMapping("/schedule")
public class JobController {

    @Autowired
    private SysJobServiceImpl sysJobService;

    @Autowired
    private JobServiceImpl jobService;

    @GetMapping("/addJob")
    public String addJobPage(){
        return "pages/schedule/addJob";
    }

    @GetMapping("/editJob")
    public String toEditJobPage(){
        return "pages/schedule/editJob";
    }

    @GetMapping("/listAllJobs")
    @ResponseBody
    public String listAllJobs(int pageNo,int pageSize){
        List<SysJob> jobs=sysJobService.listAllJobs(pageNo,pageSize);
        JSONObject object=new JSONObject();
        object.put("code",0);
        object.put("msg","");
        object.put("count",jobs.size());
        object.put("data",jobs);
        return object.toJSONString();
    }

    /**
     * 创建cron任务
     * @param jobName
     * @param jobGroup
     * @return
     */
    @RequestMapping(value = "/addJob",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult startCronJob(@RequestParam("jobName") String jobName, @RequestParam("jobGroup") String jobGroup){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SysJob job = new SysJob();
        job.setJobName(jobName);
        job.setJobGroup(jobGroup);
        job.setStatus("1");
        job.setCreateBy("admin");
        job.setCreateTime(sdf.format(new Date()));
        int result=sysJobService.insert(job);
        if(result>0){
            SysJob job1=sysJobService.selectSysJobByNameAndGroup(jobName,jobGroup);
            jobService.addCronJob(job1);
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    /**
     * 暂停任务
     * @param jobName
     * @param jobGroup
     * @return
     */
    @RequestMapping(value = "/stopJob",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult pauseJob(@RequestParam("jobId")int jobId, @RequestParam("jobName") String jobName, @RequestParam("jobGroup") String jobGroup){
        SysJob job=new SysJob();
        job.setJobId(jobId);
        job.setStatus("0");
        int result=sysJobService.update(job);
        if(result>0){
            try{
                jobService.pauseJob(jobName,jobGroup);
                return AjaxResult.success();
            }catch (Exception e){

            }

        }
        return AjaxResult.error();
    }

    /**
     * 恢复任务
     * @param jobName
     * @param jobGroup
     * @return
     */
    @RequestMapping(value = "/startJob",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult resumeJob(@RequestParam("jobId")int jobId,@RequestParam("jobName") String jobName, @RequestParam("jobGroup") String jobGroup){
        SysJob job=new SysJob();
        job.setJobId(jobId);
        job.setStatus("1");
        int result=sysJobService.update(job);
        if(result>0){
            try {
                jobService.resumeJob(jobName,jobGroup);
                return AjaxResult.success();
            }catch (Exception e){
            }
        }

        return AjaxResult.error();
    }

    /**
     * 删除定时任务
     * @param jobName
     * @param jobGroup
     * @return
     */
    @RequestMapping(value = "/deleteJob",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxResult deleteJob(@RequestParam("jobId")int jobId,@RequestParam("jobName") String jobName, @RequestParam("jobGroup") String jobGroup){
        int result=sysJobService.deleteJobById(jobId);
        if(result>0){
            jobService.deleteJob(jobName,jobGroup);
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }
}
