package com.taoge.zxstbg.database.webtls.service;

import com.taoge.zxstbg.database.webtls.entity.BisUseLog;

import java.util.List;

public interface BisUseLogService {

    List<BisUseLog> listAllUseLogs(int pageNo, int pageSize);

    int countAllUseLogs();

}
