package com.taoge.zxstbg.admin.loginmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/index")
    public String toIndex(){
        return "index";
    }

    @GetMapping("/welcome")
    public String towelcome(){
        return "pages/welcome";
    }

    @GetMapping("/pages/member/list")
    public String toMemberList(){
        return "pages/member/listAllUsers";
    }

    @GetMapping("/menu/showAllMenus")
    public String showAllMenus(){
        return "pages/member/listAllMenus";
    }

    @GetMapping("/role/showAllRoles")
    public String showAllRoles(){
        return "pages/member/listAllRoles";
    }

    @GetMapping("/admin/list")
    public String toAdminList(){
        return "pages/admin/list";
    }

    @GetMapping("/admin/role")
    public String toAdminRole(){
        return "pages/admin/role";
    }

    @GetMapping("/admin/rule")
    public String toAdminRule(){
        return "pages/admin/rule";
    }

    @GetMapping("/admin/cate")
    public String toAdminCate(){
        return "pages/admin/cate";
    }

    @GetMapping("/log/useLog")
    public String toUseLog(){
        return "pages/record/uselog";
    }

    @GetMapping("/schedule/index")
    public String toSchedule(){
        return "pages/schedule/index";
    }



}
