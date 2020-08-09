package com.boss.rbac_learning.controller;


import com.boss.rbac_learning.entity.vo.CommonResult;
import com.boss.rbac_learning.entity.vo.UserVo;
import com.boss.rbac_learning.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/login")
    public CommonResult<UserVo> login(String username, String password, HttpServletRequest request){
        UserVo userVo = userService.login(username,password);
        if(userVo !=null){
            List<String> list= userService.getUserDetail(userVo.getId());
            HttpSession session = request.getSession();
            session.setAttribute("permission",list);
            log.info(list);
            log.info(session.getAttribute("permission"));
            return new CommonResult<UserVo>(200,"登录成功",userVo);
        }else{
            return new CommonResult<UserVo>(400,"登录失败",userVo);
        }
    }

    @PostMapping("/adduser")
    public CommonResult<Integer> addUser(int id,String username,String password){
        int result = userService.addUser(id, username, password);
        if(result > 0){
            return new CommonResult<Integer>(200,"添加用户成功",result);
        }else {
            return new CommonResult<Integer>(400,"添加用户失败",null);
        }
    }

    @PostMapping("/delete")
    public CommonResult<Integer> deleteByName(String username){
        int result = userService.deleteByName(username);
        if(result > 0){
            return new CommonResult<Integer>(200,"删除用户成功",result);
        }else {
            return new CommonResult<Integer>(400,"删除用户失败",null);
        }
    }

    @PostMapping("/updaterole")
    public CommonResult<Integer> updateRole(String username,Integer roleid){
        int result = userService.updateRole(username,roleid);
        if(result > 0){
            return new CommonResult<Integer>(200,"更新用户成功",result);
        }else {
            return new CommonResult<Integer>(400,"更新用户失败",null);
        }
    }

    @PostMapping("/queryall")
    public CommonResult<List<UserVo>> queryAll(){
        List<UserVo> userVoList = userService.queryAll();
        if(userVoList.size()!=0){
            return new CommonResult<List<UserVo>>(200,"显示所有用户成功",userVoList);
        }else {
            return new CommonResult<List<UserVo>>(400,"显示所有用户失败",null);
        }
    }

}
