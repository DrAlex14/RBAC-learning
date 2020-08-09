package com.boss.rbac_learning.service;

import com.boss.rbac_learning.entity.vo.UserVo;

import java.util.List;

public interface UserService {

   UserVo login(String username,String password);

   int addUser(int id,String username,String password);

   int deleteByName(String username);

    int updateRole(String username,Integer roleid);

    List<UserVo> queryAll();

    List<String> getUserDetail(int id);
}
