package com.taoge.zxstbg.database.zxstbg.dao;

import com.taoge.zxstbg.database.zxstbg.entity.SysJobLog;

import java.util.List;

public interface SysJobLogMapper {

    int insert(SysJobLog record);

    List<SysJobLog> listJobLogsByJobId(int jobId);

}