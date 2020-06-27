package com.taoge.zxstbg.database.zxstbg.service.impl;

import com.taoge.zxstbg.database.zxstbg.dao.SysUserMapper;
import com.taoge.zxstbg.database.zxstbg.entity.SysUser;
import com.taoge.zxstbg.database.zxstbg.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserByAccount(String account) {
        return sysUserMapper.selectByLoginName(account);
    }

    @Override
    public List<SysUser> listAllUsers(int PageNo, int pageSize) {
        return null;
    }
}
