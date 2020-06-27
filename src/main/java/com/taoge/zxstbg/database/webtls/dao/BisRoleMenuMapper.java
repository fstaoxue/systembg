package com.taoge.zxstbg.database.webtls.dao;

import com.taoge.zxstbg.database.webtls.entity.BisRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BisRoleMenuMapper {

    int insert(BisRoleMenu record);

    List<String> selectMenuIdsByRoleId(String roleId);

    int deleteByRoleIdAndMenuId(@Param("roleId") String roleId, @Param("menuId") String menuId);

    int deleteByRoleId(String roleId);

    int batchRoleMenu(List<BisRoleMenu> roleMenus);

    int batchDeleteByRoleIdAndMenuIds(Map<String, Object> map);
}