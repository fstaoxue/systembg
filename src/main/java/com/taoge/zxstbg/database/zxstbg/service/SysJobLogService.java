package com.taoge.zxstbg.database.zxstbg.service;

import com.taoge.zxstbg.database.zxstbg.entity.SysJobLog;

import java.util.List;

public interface SysJobLogService {

    int insert(SysJobLog log);

    List<SysJobLog> listJobLogsByJobId(int jobId);

}
