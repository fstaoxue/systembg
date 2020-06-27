package com.taoge.zxstbg.database.webtls.service;

import com.taoge.zxstbg.database.webtls.entity.BisMenu;

import java.util.List;

public interface BisMenuService {

    List<BisMenu> listAllMenus(int pageNo, int pageSize);

    int countAllMenus();

    int updateMenu(BisMenu menu);

    int deleteMenu(String menuId);

    int addMenu(BisMenu menu);

    BisMenu selectMenuById(String id);

    int insertMenu(BisMenu menu);

    List<BisMenu> selectParentMenus();

}
