package com.boss.rbac_learning.service;

import com.boss.rbac_learning.entity.vo.AuthorizationVo;

import java.util.List;

public interface AuthorizationService {

    List<AuthorizationVo> queryAll();

    int add(int roleid, int permissionid);

    int delete(int id);
}
