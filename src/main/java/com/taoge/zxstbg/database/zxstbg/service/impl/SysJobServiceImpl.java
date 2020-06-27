package com.taoge.zxstbg.database.zxstbg.service.impl;

import com.taoge.zxstbg.database.zxstbg.dao.SysJobMapper;
import com.taoge.zxstbg.database.zxstbg.entity.SysJob;
import com.taoge.zxstbg.database.zxstbg.entity.SysPage;
import com.taoge.zxstbg.database.zxstbg.service.SysJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysJobServiceImpl implements SysJobService {

    @Autowired
    private SysJobMapper sysJobMapper;

    @Override
    public List<SysJob> listAllJobs(int pageNo, int pageSize) {
        SysPage page=new SysPage();
        page.setStart((pageNo-1)*pageSize);
        page.setSize(pageSize);
        return sysJobMapper.listAllJobs(page);
    }

    @Override
    public int insert(SysJob job) {
        int result=sysJobMapper.insert(job);
        return result;
    }

    @Override
    public int update(SysJob job) {
        int result=sysJobMapper.updateByJobId(job);
        return result;
    }

    @Override
    public int deleteJobById(int jobId) {
        return sysJobMapper.deleteByJobId(jobId);
    }

    @Override
    public SysJob selectSysJobByNameAndGroup(String jobName, String jobGroup) {
        return sysJobMapper.selectByJobNameAndGroup(jobName,jobGroup);
    }
}
