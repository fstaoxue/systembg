package com.taoge.zxstbg.admin.logmanage.controller;

import com.taoge.zxstbg.admin.util.AjaxResult;
import com.taoge.zxstbg.database.zxstbg.entity.SysJobLog;
import com.taoge.zxstbg.database.zxstbg.service.impl.SysJobLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/jobLog")
public class JobLogController {

    @Autowired
    private SysJobLogServiceImpl sysJobLogService;

    @PostMapping("/listJobLogsByJobId")
    @ResponseBody
    public AjaxResult listJobLogsByJobId(int jobId){
        try {
            List<SysJobLog> logs=sysJobLogService.listJobLogsByJobId(jobId);
            AjaxResult success=AjaxResult.success();
            success.put("data",logs);
            return success;
        }catch (Exception e){

        }

        return AjaxResult.error();
    }
}
