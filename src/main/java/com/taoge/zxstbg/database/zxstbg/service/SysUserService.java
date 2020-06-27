package com.taoge.zxstbg.database.zxstbg.service;

import com.taoge.zxstbg.database.zxstbg.entity.SysUser;

import java.util.List;

public interface SysUserService {

    SysUser findUserByAccount(String account);

    List<SysUser> listAllUsers(int PageNo, int pageSize);
}
