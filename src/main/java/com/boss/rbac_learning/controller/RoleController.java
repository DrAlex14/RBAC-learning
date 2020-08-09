package com.boss.rbac_learning.controller;

import com.boss.rbac_learning.entity.vo.CommonResult;
import com.boss.rbac_learning.entity.vo.RoleVo;
import com.boss.rbac_learning.service.RoleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    RoleService roleService;

    @PostMapping("/queryall")
    public CommonResult<List<RoleVo>> queryAll(){
        List<RoleVo> roleVoList = roleService.queryAll();
        if(roleVoList.size() != 0){
            return new CommonResult<List<RoleVo>>(200,"显示所有角色成功",roleVoList);
        }else{
            return new CommonResult<List<RoleVo>>(400,"显示所有角色失败",null);
        }
    }

    @PostMapping("/addrole")
    public CommonResult<Integer> addRole(int id,String name){
        int result = roleService.addRole(id,name);
        if(result > 0){
            return new CommonResult<Integer>(200,"添加角色成功",result);
        }else{
            return new CommonResult<Integer>(400,"添加角色失败",null);
        }
    }

    @PostMapping("/delete")
    public CommonResult<Integer> deleteByName(String name){
        int result = roleService.deleteByName(name);
        if(result > 0){
            return new CommonResult<Integer>(200,"删除角色成功",result);
        }else{
            return new CommonResult<Integer>(400,"删除角色失败",null);
        }
    }

    @PostMapping("/update")
    public CommonResult<Integer> update(int id,String name){
        int result = roleService.update(id,name);
        if(result > 0){
            return new CommonResult<Integer>(200,"更新角色成功",result);
        }else{
            return new CommonResult<Integer>(400,"更新角色失败",null);
        }
    }

    /**
     * 查询角色权限
     */
    @PostMapping("/querypremissions")
    public CommonResult<List<String>> queryPremissions(String name){
        List<String> list = roleService.queryPremissions(name);
        if(list != null){
            return new CommonResult<List<String>>(200,"权限查询结果",list);
        }else {
            return new CommonResult<List<String>>(400,"权限查询失败",null);
        }
    }
}
