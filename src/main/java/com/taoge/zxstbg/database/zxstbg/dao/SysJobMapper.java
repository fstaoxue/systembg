package com.taoge.zxstbg.database.zxstbg.dao;

import com.taoge.zxstbg.database.zxstbg.entity.SysJob;
import com.taoge.zxstbg.database.zxstbg.entity.SysPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysJobMapper {

    int deleteByJobId(int jobId);

    int insert(SysJob record);

    int updateByJobId(SysJob record);

    List<SysJob> listAllJobs(SysPage page);

    SysJob selectByJobNameAndGroup(@Param("jobName") String jobName, @Param("jobGroup") String jobGroup);
}