package com.taoge.zxstbg.database.webtls.dao;

import com.taoge.zxstbg.database.webtls.entity.BisPage;
import com.taoge.zxstbg.database.webtls.entity.BisUseLog;

import java.util.List;

public interface BisUseLogMapper {

    BisUseLog selectById(Integer id);

    List<BisUseLog> listAllUseLogs(BisPage page);

    int countAllUseLogs();
}