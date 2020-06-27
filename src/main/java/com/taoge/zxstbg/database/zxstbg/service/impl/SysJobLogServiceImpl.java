package com.taoge.zxstbg.database.zxstbg.service.impl;

import com.taoge.zxstbg.database.zxstbg.dao.SysJobLogMapper;
import com.taoge.zxstbg.database.zxstbg.entity.SysJobLog;
import com.taoge.zxstbg.database.zxstbg.service.SysJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SysJobLogServiceImpl implements SysJobLogService {

    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    @Override
    public int insert(SysJobLog log) {
        int result=sysJobLogMapper.insert(log);
        return result;
    }

    @Override
    public List<SysJobLog> listJobLogsByJobId(int jobId) {
        return sysJobLogMapper.listJobLogsByJobId(jobId);
    }
}
