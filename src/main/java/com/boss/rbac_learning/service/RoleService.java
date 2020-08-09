package com.boss.rbac_learning.service;


import com.boss.rbac_learning.entity.vo.RoleVo;

import java.util.List;

public interface RoleService {
    List<RoleVo> queryAll();

    int addRole(int id, String name);

    int deleteByName(String name);

    int update(int id,String name);

    List<String> queryPremissions(String name);
}
