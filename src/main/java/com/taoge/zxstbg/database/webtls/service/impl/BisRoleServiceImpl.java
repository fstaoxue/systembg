package com.taoge.zxstbg.database.webtls.service.impl;

import com.taoge.zxstbg.database.webtls.dao.BisMenuMapper;
import com.taoge.zxstbg.database.webtls.dao.BisRoleMapper;
import com.taoge.zxstbg.database.webtls.dao.BisRoleMenuMapper;
import com.taoge.zxstbg.database.webtls.entity.BisMenu;
import com.taoge.zxstbg.database.webtls.entity.BisPage;
import com.taoge.zxstbg.database.webtls.entity.BisRole;
import com.taoge.zxstbg.database.webtls.entity.BisRoleMenu;
import com.taoge.zxstbg.database.webtls.service.BisRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BisRoleServiceImpl implements BisRoleService {

    @Autowired
    private BisRoleMapper bisRoleMapper;

    @Autowired
    private BisMenuMapper bisMenuMapper;

    @Autowired
    private BisRoleMenuMapper bisRoleMenuMapper;


    @Override
    public List<BisRole> listAllRoles(int pageNo,int pageSize) {
        BisPage page=new BisPage();
        page.setStart((pageNo-1)*pageSize);
        page.setSize(pageSize);
        return bisRoleMapper.listAllRoles(page);
    }

    @Override
    public int countAllRoles() {
        return bisRoleMapper.countAllRoles();
    }

    @Override
    public List<BisMenu> listRoleHasMenus(String roleId) {
        return bisMenuMapper.selectMenusByRoleId(roleId);
    }

    @Override
    public List<BisMenu> listRoleNoHasMenus(String roleId) {
        List<String> menuIds=bisRoleMenuMapper.selectMenuIdsByRoleId(roleId);
        return bisMenuMapper.selectRoleNotHasMenus(menuIds);
    }

    @Override
    public BisRole selectRoleById(String roleId) {
        return bisRoleMapper.selectById(roleId);
    }

    @Override
    public int addRoleHasMenus(String roleId, List<String> addMenuIds) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<BisRoleMenu> roleMenus=new ArrayList<>();
        for(String menuId:addMenuIds){
            BisRoleMenu temp=new BisRoleMenu();
            temp.setId(roleId+"-"+menuId);
            temp.setRoleId(roleId);
            temp.setMenuId(menuId);
            temp.setCreateTime(sdf.format(new Date()));
            roleMenus.add(temp);
        }
        int result=bisRoleMenuMapper.batchRoleMenu(roleMenus);
        return result;
    }

    @Override
    public int removeRoleHasMenus(String roleId, List<String> removeMenuIds) {
        Map<String,Object> map=new HashMap<>();
        map.put("roleId",roleId);
        map.put("list",removeMenuIds);
        int result=bisRoleMenuMapper.batchDeleteByRoleIdAndMenuIds(map);
        return result;
    }

    @Override
    public int insertRole(BisRole role) {
        int result=bisRoleMapper.insert(role);
        return result;
    }

    @Override
    public int deleteRole(String roleId) {
        int result=bisRoleMapper.deleteById(roleId);
        return result;
    }

    @Override
    public int updateRole(BisRole role) {
        return bisRoleMapper.updateById(role);
    }
}
