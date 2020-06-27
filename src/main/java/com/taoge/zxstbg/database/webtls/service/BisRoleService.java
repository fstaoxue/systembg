package com.taoge.zxstbg.database.webtls.service;

import com.taoge.zxstbg.database.webtls.entity.BisMenu;
import com.taoge.zxstbg.database.webtls.entity.BisRole;

import java.util.List;

public interface BisRoleService {

    List<BisRole> listAllRoles(int pageNo, int pageSize);

    int countAllRoles();

    List<BisMenu> listRoleHasMenus(String roleId);

    List<BisMenu> listRoleNoHasMenus(String roleId);

    BisRole selectRoleById(String roleId);

    int addRoleHasMenus(String roleId, List<String> addMenuIds);

    int removeRoleHasMenus(String roleId, List<String> removeMenuIds);

    int insertRole(BisRole role);

    int deleteRole(String roleId);

    int updateRole(BisRole role);

}
