package com.taoge.zxstbg.database.webtls.dao;

import com.taoge.zxstbg.database.webtls.entity.PoliceStation;

import java.util.List;

public interface PoliceStationMapper {
    int deleteByPrimaryKey(String id);

    int insert(PoliceStation record);

    int insertSelective(PoliceStation record);

    PoliceStation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PoliceStation record);

    int updateByPrimaryKey(PoliceStation record);

    List<PoliceStation> listAllStations();
}