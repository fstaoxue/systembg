package com.taoge.zxstbg.database.webtls.service;

import com.taoge.zxstbg.database.webtls.entity.BisRole;
import com.taoge.zxstbg.database.webtls.entity.BisUser;

import java.util.List;

public interface BisUserService {

    List<BisUser> listUsers(int pageNo, int pageSize);

    List<BisRole> listRolesByRoleId(String roleId);

    BisUser selectUserById(String id);

    List<BisRole> listNoAuthRoles(String roleId);

    int updateUserHasRoles(String userId, List<String> removeIds);

    int deleteUserById(String userId);

    int deleteUserHasRoles(String userId, List<String> removeIds);

    int insert(BisUser user);

    BisUser selectUserByAccount(String userAccount);

    int updateBisUser(BisUser user);

    int countAllUsers();

}
