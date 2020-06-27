package com.taoge.zxstbg.admin.usermanage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taoge.zxstbg.admin.util.AjaxResult;
import com.taoge.zxstbg.database.webtls.entity.BisRole;
import com.taoge.zxstbg.database.webtls.entity.BisUser;
import com.taoge.zxstbg.database.webtls.entity.PoliceStation;
import com.taoge.zxstbg.database.webtls.service.impl.BisRoleServiceImpl;
import com.taoge.zxstbg.database.webtls.service.impl.BisUserServiceImpl;
import com.taoge.zxstbg.database.webtls.service.impl.PoliceStationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/role")
public class BisRoleController {

    @Autowired
    private BisUserServiceImpl bisUserService;

    @Autowired
    private BisRoleServiceImpl bisRoleService;

    @Autowired
    private PoliceStationServiceImpl policeStationService;

    @GetMapping("/addRole")
    public String addRole(Model model){
        List<PoliceStation> stations=policeStationService.listAllStations();
        if(stations!=null){
            model.addAttribute("stations",stations);
        }else{
            model.addAttribute("stations",new ArrayList<PoliceStation>());
        }
        return "pages/member/addRole";
    }

    @PostMapping("/newRole")
    @ResponseBody
    public AjaxResult newRole(String name,String isOpenProcess,String stationId){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BisRole role=new BisRole();
        role.setIsOpenProcess(isOpenProcess);
        role.setStationId(stationId);
        role.setName(name);
        role.setCreateTime(sdf.format(new Date()));
        int result=bisRoleService.insertRole(role);
        if(result>0){
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    @GetMapping("/updateRoleInfo")
    public String toEditRolePage(Model model,String id){
        BisRole role=bisRoleService.selectRoleById(id);
        model.addAttribute("role",role);
        List<PoliceStation> stations=policeStationService.listAllStations();
        if(stations!=null){
            model.addAttribute("stations",stations);
        }else{
            model.addAttribute("stations",new ArrayList<PoliceStation>());
        }
        return "pages/member/updateRoleInfo";

    }

    @PostMapping("/updateRoleInfo")
    @ResponseBody
    public AjaxResult updateRoleInfo(String id,String name,String isOpenProcess,String stationId){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BisRole role=new BisRole();
        role.setId(id);
        role.setName(name);
        role.setIsOpenProcess(isOpenProcess);
        role.setStationId(stationId);
        role.setModifyTime(sdf.format(new Date()));
        int result=bisRoleService.updateRole(role);
        if(result>0){
            return AjaxResult.success();
        }
        return AjaxResult.error();

    }

    @GetMapping("/listAllRoles")
    @ResponseBody
    public String listAllRoles(Integer pageNo,Integer pageSize){
        List<BisRole> roles=bisRoleService.listAllRoles(pageNo,pageSize);
        int count=bisRoleService.countAllRoles();
        JSONObject object=new JSONObject();
        object.put("code",0);
        object.put("msg","");
        object.put("count",count);
        object.put("data",roles);
        return object.toJSONString();
    }

    @GetMapping("/listRolesByRoleId")
    @ResponseBody
    public String listRolesByUserId(String roleId,String type)  {

        List<BisRole> roles=null;
        if(type.equals("removeRole")){
            roles=bisUserService.listRolesByRoleId(roleId);
        }else if(type.equals("addRole")){
            roles=bisUserService.listNoAuthRoles(roleId);
        }
        JSONObject object=new JSONObject();
        object.put("code",0);
        object.put("msg","");
        object.put("count",roles.size());
        object.put("data",roles);

        return object.toJSONString();
    }

    @GetMapping("/editRole")
    public String toEditRole(Model model, String type, String userId){
        BisUser user=bisUserService.selectUserById(userId);
        model.addAttribute("user",user);
        if(type.equals("hasAuth")){
            model.addAttribute("ischecked",false);
            model.addAttribute("type","removeRole");
        }else{
            model.addAttribute("ischecked",true);
            model.addAttribute("type","addRole");
        }
        return "pages/member/editRole";
    }


    @PostMapping("/updateRole")
    @ResponseBody
    public String updateRole(String userId,String type,String updateInfo){
        JSONObject result=new JSONObject();
        result.put("code","404");
        result.put("status","failed");
        JSONObject updateRoles= JSON.parseObject(updateInfo);
        Set<String> set=updateRoles.keySet();
        List<String> roleIds=new ArrayList<String>();
        for(String temp:set){
            roleIds.add(temp);
        }
        int rs=0;
        if(type.equals("addRole")){
            rs=bisUserService.updateUserHasRoles(userId,roleIds);
        }else if(type.equals("removeRole")){
            rs=bisUserService.deleteUserHasRoles(userId,roleIds);
        }
        if(rs>0){
            result.put("code","200");
            result.put("status","success");
        }else{

        }
        return result.toJSONString();
    }

}
