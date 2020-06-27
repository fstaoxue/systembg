package com.taoge.zxstbg.admin.usermanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.taoge.zxstbg.admin.usermanage.util.EncryptUtil;
import com.taoge.zxstbg.admin.util.AjaxResult;
import com.taoge.zxstbg.database.webtls.entity.BisUser;
import com.taoge.zxstbg.database.webtls.service.impl.BisUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bisuser")
public class BisUserController {

    @Autowired
    private BisUserServiceImpl bisUserService;

    @GetMapping("/editPassword")
    public String toEditPasswordPage(Model model,String id){
        BisUser user=bisUserService.selectUserById(id);
        model.addAttribute("user",user);
        return "pages/member/password";
    }

    @PostMapping("/editPassword")
    @ResponseBody
    public AjaxResult postEditPassword(String userAccount,String oldPwd,String newPwd){
        BisUser user=bisUserService.selectUserByAccount(userAccount);
        if(EncryptUtil.EncodeByMd5ForWebtls(oldPwd).equals(user.getUserPwd())){
            user.setUserPwd(EncryptUtil.EncodeByMd5ForWebtls(newPwd));
            int result=bisUserService.updateBisUser(user);
            if(result>0){
                return AjaxResult.success();
            }
        }
        return AjaxResult.error();
    }

    @GetMapping("/addUser")
    public String toAddUserPage(){
        return "pages/member/addUser";
    }

    @PostMapping("/addUser")
    @ResponseBody
    public String toAddUser(BisUser user){
        user.setUserPwd(EncryptUtil.EncodeByMd5ForWebtls(user.getUserPwd()));
        int result=bisUserService.insert(user);
        JSONObject obj=new JSONObject();
        obj.put("code","500");
        obj.put("status","failed");
        if(result>0){
            obj.put("code","200");
            obj.put("status","success");
        }
        return obj.toJSONString();
    }

    @GetMapping("/getUserList")
    @ResponseBody
    public String listAllBisUser(Integer pageNo,Integer pageSize){
        List<BisUser> users=bisUserService.listUsers(pageNo,pageSize);
        int count=bisUserService.countAllUsers();
        JSONObject object=new JSONObject();
        object.put("code",0);
        object.put("msg","");
        object.put("count",count);
        object.put("data",users);
        return object.toJSONString();
    }

    @GetMapping("/deleteUserId")
    @ResponseBody
    public AjaxResult deleteUserById(String id){
        int result=bisUserService.deleteUserById(id);
        if(result>0){
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

}
