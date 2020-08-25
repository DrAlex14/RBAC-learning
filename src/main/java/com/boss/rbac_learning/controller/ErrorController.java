package com.boss.rbac_learning.controller;

import com.boss.rbac_learning.entity.vo.CommonResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ErrorController {
    @RequestMapping("/nopermission")
    public CommonResult<Integer> noPermission(){
        return new CommonResult<Integer>(400,"权限不足",0);
    }
}
