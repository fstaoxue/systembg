package com.taoge.zxstbg.database.zxstbg.dao;

import com.taoge.zxstbg.database.zxstbg.entity.SysUserRoleKey;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(SysUserRoleKey key);

    int insert(SysUserRoleKey record);

    int insertSelective(SysUserRoleKey record);
}