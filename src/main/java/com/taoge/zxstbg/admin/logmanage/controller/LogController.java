package com.taoge.zxstbg.admin.logmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.taoge.zxstbg.database.webtls.entity.BisUseLog;
import com.taoge.zxstbg.database.webtls.service.impl.BisUseLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private BisUseLogServiceImpl bisUseLogService;

    @GetMapping("/getUseLog")
    @ResponseBody
    public String getUseLog(int pageNo,int pageSize){
        List<BisUseLog> logs=bisUseLogService.listAllUseLogs(pageNo,pageSize);
        int count=bisUseLogService.countAllUseLogs();
        JSONObject object=new JSONObject();
        object.put("code",0);
        object.put("msg","");
        object.put("count",count);
        object.put("data",logs);
        return object.toJSONString();
    }



}
