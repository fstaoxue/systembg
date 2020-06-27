package com.taoge.zxstbg.admin.usermanage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taoge.zxstbg.admin.util.AjaxResult;
import com.taoge.zxstbg.database.webtls.entity.BisMenu;
import com.taoge.zxstbg.database.webtls.entity.BisRole;
import com.taoge.zxstbg.database.webtls.service.impl.BisMenuServiceImpl;
import com.taoge.zxstbg.database.webtls.service.impl.BisRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/menu")
public class BisMenuController {

    @Autowired
    private BisRoleServiceImpl bisRoleService;

    @Autowired
    private BisMenuServiceImpl bisMenuService;

    @GetMapping("/addMenu")
    public String toAddMenuPage(Model model){
        List<BisMenu> parents=bisMenuService.selectParentMenus();
        model.addAttribute("parentMenus",parents);
        return "pages/member/addMenu";
    }

    @PostMapping("/addMenu")
    @ResponseBody
    public AjaxResult postAddMenu(BisMenu menu){
        int result=bisMenuService.insertMenu(menu);
        if(result>0){
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    @GetMapping("/updateMenuInfo")
    public String toUpdateMenuInfoPage(Model model,String id){
        List<BisMenu> parents=bisMenuService.selectParentMenus();
        model.addAttribute("parentMenus",parents);
        BisMenu menu=bisMenuService.selectMenuById(id);
        model.addAttribute("menu",menu);
        return  "pages/member/updateMenuInfo";
    }

    @PostMapping("/updateMenuInfo")
    @ResponseBody
    public AjaxResult postUpdateMenuInfo(BisMenu menu){
        int result=bisMenuService.updateMenu(menu);
        if(result>0){
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    @PostMapping("/deleteMenuById")
    @ResponseBody
    public AjaxResult deletMenu(String id){
        int result=bisMenuService.deleteMenu(id);
        if(result>0){
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    @GetMapping("/listAllMenus")
    @ResponseBody
    public String listAllMenus(int pageNo,int pageSize){
        List<BisMenu> menus=bisMenuService.listAllMenus(pageNo,pageSize);
        int count=bisMenuService.countAllMenus();
        JSONObject object=new JSONObject();
        object.put("code",0);
        object.put("msg","");
        object.put("count",count);
        object.put("data",menus);

        return object.toJSONString();
    }

    @GetMapping("/listMenusByRoleId")
    @ResponseBody
    public String listMenusByRoleId(String roleId,String type){
        List<BisMenu> menus=null;
        if(type.equals("addMenu")){
            menus=bisRoleService.listRoleNoHasMenus(roleId);
        }else if(type.equals("removeMenu")){
            menus=bisRoleService.listRoleHasMenus(roleId);
        }
        JSONObject object=new JSONObject();
        object.put("code",0);
        object.put("msg","");
        object.put("count",menus.size());
        object.put("data",menus);
        return object.toJSONString();
    }

    @GetMapping("/editMenuByRole")
    public String toEditRole(Model model, String type, String roleId){
        BisRole role=bisRoleService.selectRoleById(roleId);
        model.addAttribute("role",role);
        if(type.equals("hasAuth")){
            model.addAttribute("ischecked",false);
            model.addAttribute("type","removeMenu");
        }else if(type.equals("noAuth")){
            model.addAttribute("ischecked",true);
            model.addAttribute("type","addMenu");
        }
        return "pages/member/editMenuByRole";
    }

    @PostMapping("/updateMenuByRole")
    @ResponseBody
    public String updateRole(String roleId,String type,String updateInfo){
        JSONObject result=new JSONObject();
        JSONObject updateRoles= JSON.parseObject(updateInfo);
        Set<String> set=updateRoles.keySet();
        List<String> menuIds=new ArrayList<String>();
        for(String temp:set){
            menuIds.add(temp);
        }
        int rs=0;
        if(type.equals("addMenu")){
            rs=bisRoleService.addRoleHasMenus(roleId,menuIds);
        }else if(type.equals("removeMenu")){
            rs=bisRoleService.removeRoleHasMenus(roleId,menuIds);
        }
        if(rs>0){
            result.put("code","200");
            result.put("status","success");
        }else{
            result.put("code","404");
            result.put("status","failed");
        }
        return result.toJSONString();
    }

}
