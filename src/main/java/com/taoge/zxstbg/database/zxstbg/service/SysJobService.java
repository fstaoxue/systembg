package com.taoge.zxstbg.database.zxstbg.service;

import com.taoge.zxstbg.database.zxstbg.entity.SysJob;

import java.util.List;

public interface SysJobService {

    List<SysJob> listAllJobs(int pageNo, int pageSize);

    int insert(SysJob job);

    int update(SysJob job);

    int deleteJobById(int jobId);

    SysJob selectSysJobByNameAndGroup(String jobName, String jobGroup);

}
