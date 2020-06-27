package com.taoge.zxstbg.database.webtls.service.impl;

import com.taoge.zxstbg.database.webtls.dao.BisMenuMapper;
import com.taoge.zxstbg.database.webtls.entity.BisMenu;
import com.taoge.zxstbg.database.webtls.entity.BisPage;
import com.taoge.zxstbg.database.webtls.service.BisMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BisMenuServiceImpl implements BisMenuService {

    @Autowired
    private BisMenuMapper bisMenuMapper;

    @Override
    public List<BisMenu> listAllMenus(int pageNo,int pageSize) {

        BisPage page=new BisPage();
        page.setStart((pageNo-1)*pageSize);
        page.setSize(pageSize);
        return bisMenuMapper.listAllMenus(page);
    }

    @Override
    public int countAllMenus() {
        return bisMenuMapper.countAllMenus();
    }

    @Override
    public int updateMenu(BisMenu menu) {
        int result=bisMenuMapper.updateById(menu);
        return result;
    }

    @Override
    public int deleteMenu(String menuId) {
        int result=bisMenuMapper.deleteById(menuId);
        return result;
    }

    @Override
    public int addMenu(BisMenu menu) {
        int result=bisMenuMapper.insert(menu);
        return result;
    }

    @Override
    public BisMenu selectMenuById(String id) {
        return bisMenuMapper.selectById(id);
    }

    @Override
    public int insertMenu(BisMenu menu) {
        return bisMenuMapper.insert(menu);
    }

    @Override
    public List<BisMenu> selectParentMenus() {
        return bisMenuMapper.selectParentMenus();
    }
}
