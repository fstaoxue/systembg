package com.taoge.zxstbg.database.zxstbg.dao;

import com.taoge.zxstbg.database.zxstbg.entity.SysMenu;

public interface SysMenuMapper {
    int deleteByMenuId(Integer menuId);

    int insert(SysMenu record);

    SysMenu selectByMenuId(Integer menuId);

    int updateByMenuId(SysMenu record);

}