package com.taoge.zxstbg.database.webtls.dao;

import com.taoge.zxstbg.database.webtls.entity.BisPage;
import com.taoge.zxstbg.database.webtls.entity.BisRole;

import java.util.List;

public interface BisRoleMapper {
    int deleteById(String id);

    int insert(BisRole record);

    BisRole selectById(String id);

    int updateById(BisRole record);

    List<BisRole> selectRolesByIds(List<String> ids);

    List<BisRole> selectRolesNotInIds(List<String> ids);

    List<BisRole> listAllRoles(BisPage page);

    int countAllRoles();
}