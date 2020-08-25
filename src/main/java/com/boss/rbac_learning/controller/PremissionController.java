package com.boss.rbac_learning.controller;

import com.boss.rbac_learning.entity.vo.CommonResult;
import com.boss.rbac_learning.entity.vo.PremissionVo;
import com.boss.rbac_learning.service.PremissionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Log4j2
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/permission")
public class PremissionController {

    @Resource
    PremissionService premissionService;

    @PostMapping("/queryall")
    public CommonResult<List<PremissionVo>> queryAll(){
        List<PremissionVo> premissionVoList = premissionService.queryAll();
        if(premissionVoList != null){
            return new CommonResult<List<PremissionVo>>(200,"查询结果",premissionVoList);
        }else{
            return new CommonResult<List<PremissionVo>>(400,"查询失败",null);
        }
    }

    @PostMapping("/add")
    public CommonResult<Integer> addPermission(int id,String name,String permissionurl){
        int result = premissionService.addPermission(id,name,permissionurl);
        if(result > 0){
            return new CommonResult<Integer>(200,"添加权限成功",result);
        }else {
            return new CommonResult<Integer>(400,"添加权限失败",result);
        }
    }

    @PostMapping("/delete")
    public CommonResult<Integer> deletePermission(String name){
        int result = premissionService.deletePermission(name);
        if(result > 0){
            return new CommonResult<Integer>(200,"删除权限成功",result);
        }else {
            return new CommonResult<Integer>(400,"删除权限失败",result);
        }
    }
}
