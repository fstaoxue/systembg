package com.taoge.zxstbg.database.webtls.service.impl;

import com.taoge.zxstbg.database.webtls.dao.BisRoleMapper;
import com.taoge.zxstbg.database.webtls.dao.BisUserMapper;
import com.taoge.zxstbg.database.webtls.entity.BisPage;
import com.taoge.zxstbg.database.webtls.entity.BisRole;
import com.taoge.zxstbg.database.webtls.entity.BisUser;
import com.taoge.zxstbg.database.webtls.service.BisUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class BisUserServiceImpl implements BisUserService {

    @Autowired
    private BisUserMapper bisUserMapper;

    @Autowired
    private BisRoleMapper bisRoleMapper;


    @Override
    public List<BisUser> listUsers(int pageNo,int pageSize) {
        BisPage page=new BisPage();
        page.setStart((pageNo-1)*pageSize);
        page.setSize(pageSize);
        return bisUserMapper.listAllUsers(page);
    }

    @Override
    public List<BisRole> listRolesByRoleId(String roleId) {
        List<BisRole> result=new ArrayList<BisRole>();
        if(StringUtils.isEmpty(roleId)){
            return result;
        }
        String[] ids=roleId.split("_");
        List<String> roleIds=Arrays.asList(ids);
        Iterator<String> it=roleIds.iterator();
        while(it.hasNext()){
            String temp=it.next();
            if(StringUtils.isEmpty(temp)){
                it.remove();
            }
        }
        result=bisRoleMapper.selectRolesByIds(roleIds);
        return result;
    }

    @Override
    public BisUser selectUserById(String id) {
        return bisUserMapper.selectById(id);
    }

    @Override
    public List<BisRole> listNoAuthRoles(String roleId) {
        List<BisRole> result=new ArrayList<BisRole>();
        if(StringUtils.isEmpty(roleId)){
            BisPage page=new BisPage();
            page.setStart(0);
            page.setSize(1000);
            return bisRoleMapper.listAllRoles(page);
        }
        String[] ids=roleId.split("_");
        List<String> roleIds=Arrays.asList(ids);
        Iterator<String> it=roleIds.iterator();
        while(it.hasNext()){
            String temp=it.next();
            if(StringUtils.isEmpty(temp)){
                it.remove();
            }
        }
        result=bisRoleMapper.selectRolesNotInIds(roleIds);
        return result;
    }

    @Override
    public int updateUserHasRoles(String userId, List<String> addRoleIds) {
        if(StringUtils.isEmpty(userId)){
            return 0;
        }
        BisUser user=bisUserMapper.selectById(userId);
        String updateRoleId=user.getRoleId();
        if(addRoleIds!=null&&addRoleIds.size()>0){
            for(int i=0;i<addRoleIds.size();i++){
                String temp=addRoleIds.get(i);
                if(StringUtils.isNotEmpty(temp)){
                    updateRoleId+="_"+temp;
                }
            }
        }
        user.setRoleId(updateRoleId);
        int result=bisUserMapper.updateById(user);
        return result;
    }

    @Override
    public int deleteUserById(String userId) {
        int result=bisUserMapper.deleteById(userId);
        return result;
    }

    @Override
    public int deleteUserHasRoles(String userId, List<String> removeIds) {
        BisUser user=bisUserMapper.selectById(userId);
        String oldroleId=user.getRoleId();
        if(StringUtils.isEmpty(oldroleId)){
            return 0;
        }
        String[] oldRoles=oldroleId.split("_");
        List<String> oldRoleList=new ArrayList<String>(Arrays.asList(oldRoles));
        oldRoleList.removeAll(removeIds);
        String updateRole="";
        for(int i=0;i<oldRoleList.size();i++){
            if(i>0){
                updateRole+="_";
            }
            updateRole+=oldRoleList.get(i);
        }
        user.setRoleId(updateRole);
        int result=bisUserMapper.updateById(user);
        return result;
    }

    @Override
    public int insert(BisUser user) {
        return bisUserMapper.insert(user);
    }

    @Override
    public BisUser selectUserByAccount(String userAccount) {
        return bisUserMapper.selectUserByAccount(userAccount);
    }

    @Override
    public int updateBisUser(BisUser user) {
        return bisUserMapper.updateById(user);
    }

    @Override
    public int countAllUsers() {
        return bisUserMapper.countAllUsers();
    }

}
