package com.boss.rbac_learning.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.boss.rbac_learning.entity.UserForHighLevel;
import com.boss.rbac_learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/update/authority")
    public String update(int authority,int roleid,int id){
        if(roleid == 2 || roleid == 3){
            userService.updateAuthority(authority,id);
            return JSON.toJSONString("success");
        }
        return JSON.toJSONString("权限不足");
    }

    @RequestMapping("/del")
    public String del(int id,int roleid){
        if(roleid == 3){
            userService.delById(id);
            return JSON.toJSONString("success");
        }
        return JSON.toJSONString("权限不足");
    }

    @RequestMapping("/add")
    public String add(@RequestBody UserForHighLevel user){
            user.setRoleid(1);
            userService.add(user);
            String jsonOutPut = JSON.toJSONString("success");
            return jsonOutPut;
    }

    @RequestMapping("/queryall")
    public String  queryAll(int roleid){
        String jsonOutPut = null;
        if(roleid == 2 || roleid == 3){
            jsonOutPut = JSON.toJSONString(userService.queryAllHighLevel(), SerializerFeature.PrettyFormat);
        }else if (roleid == 1){
            jsonOutPut = JSON.toJSONString(userService.queryAll(), SerializerFeature.PrettyFormat);
        }
        return jsonOutPut;
    }



}
