package com.boss.rbac_learning.controller;

import com.boss.rbac_learning.entity.vo.AuthorizationVo;
import com.boss.rbac_learning.entity.vo.CommonResult;
import com.boss.rbac_learning.service.AuthorizationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@Log4j2
@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

    @Resource
    private AuthorizationService authorizationService;

    @PostMapping("/add")
    public CommonResult<Integer> add(int roleid,int permissionid){
        int result = authorizationService.add(roleid,permissionid);
        if(result > 0){
            return new CommonResult<Integer>(200,"赋予角色权限成功",result);
        }else{
            return new CommonResult<Integer>(400,"赋予角色权限失败",result);
        }
    }

    @PostMapping("/delete")
    public CommonResult<Integer> delete(int id){
        int result = authorizationService.delete(id);
        if(result > 0){
            return new CommonResult<Integer>(200,"删除角色权限成功",result);
        }else{
            return new CommonResult<Integer>(400,"删除角色权限失败",result);
        }
    }

    @PostMapping("/queryall")
    public CommonResult<List<AuthorizationVo>> queryAll(){
      List<AuthorizationVo> list = authorizationService.queryAll();
      if(list != null){
          return new CommonResult<List<AuthorizationVo>>(200,"查看角色权限",list);
      }else {
          return new CommonResult<List<AuthorizationVo>>(400,"查找角色权限失败",null);
      }
    }

}
