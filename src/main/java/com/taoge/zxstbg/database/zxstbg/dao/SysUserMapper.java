package com.taoge.zxstbg.database.zxstbg.dao;

import com.taoge.zxstbg.database.zxstbg.entity.SysUser;

public interface SysUserMapper {

    int deleteByUserId(Integer userId);

    int insert(SysUser record);

    SysUser selectByUserId(Integer userId);

    SysUser selectByLoginName(String loginName);

    int deleteByUserId(String userId);

    int updateByUserId(SysUser record);
}