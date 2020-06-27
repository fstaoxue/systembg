package com.taoge.zxstbg.database.webtls.dao;

import com.taoge.zxstbg.database.webtls.entity.BisMenu;
import com.taoge.zxstbg.database.webtls.entity.BisPage;

import java.util.List;

public interface BisMenuMapper {
    int deleteById(String id);

    int insert(BisMenu record);

    BisMenu selectById(String id);

    int updateById(BisMenu record);

    List<BisMenu> listAllMenus(BisPage page);

    int countAllMenus();

    List<BisMenu> selectMenusByRoleId(String roleId);

    List<BisMenu> selectRoleNotHasMenus(List<String> menuIds);

    List<BisMenu> selectParentMenus();
}