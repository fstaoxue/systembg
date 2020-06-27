package com.taoge.zxstbg.database.webtls.dao;

import com.taoge.zxstbg.database.webtls.entity.BisPage;
import com.taoge.zxstbg.database.webtls.entity.BisUser;

import java.util.List;

public interface BisUserMapper {

    BisUser selectById(String id);

    List<BisUser> listAllUsers(BisPage page);

    int deleteById(String id);

    int insert(BisUser record);

    int updateById(BisUser record);

    int deletById(String id);

    BisUser selectUserByAccount(String userAccount);

    int countAllUsers();

}