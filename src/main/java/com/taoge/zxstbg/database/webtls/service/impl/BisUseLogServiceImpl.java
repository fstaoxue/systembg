package com.taoge.zxstbg.database.webtls.service.impl;

import com.taoge.zxstbg.database.webtls.dao.BisUseLogMapper;
import com.taoge.zxstbg.database.webtls.entity.BisPage;
import com.taoge.zxstbg.database.webtls.entity.BisUseLog;
import com.taoge.zxstbg.database.webtls.service.BisUseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BisUseLogServiceImpl implements BisUseLogService {

    @Autowired
    private BisUseLogMapper bisUseLogMapper;

    @Override
    public List<BisUseLog> listAllUseLogs(int pageNo, int pageSize) {
        BisPage page=new BisPage();
        page.setStart((pageNo-1)*pageSize);
        page.setSize(pageSize);
        return bisUseLogMapper.listAllUseLogs(page);
    }

    @Override
    public int countAllUseLogs() {
        return bisUseLogMapper.countAllUseLogs();
    }
}
