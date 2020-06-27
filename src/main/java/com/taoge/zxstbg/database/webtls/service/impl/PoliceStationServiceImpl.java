package com.taoge.zxstbg.database.webtls.service.impl;

import com.taoge.zxstbg.database.webtls.dao.PoliceStationMapper;
import com.taoge.zxstbg.database.webtls.entity.PoliceStation;
import com.taoge.zxstbg.database.webtls.service.PoliceStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliceStationServiceImpl implements PoliceStationService {

    @Autowired
    private PoliceStationMapper policeStationMapper;

    @Override
    public List<PoliceStation> listAllStations() {
        return policeStationMapper.listAllStations();
    }
}
