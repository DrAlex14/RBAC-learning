package com.boss.rbac_learning.service;

import com.boss.rbac_learning.entity.vo.PremissionVo;
import java.util.List;

public interface PremissionService {

    List<PremissionVo> queryAll();

    int addPermission(int id, String name, String permissionurl);

    int deletePermission(String name);

    List<PremissionVo> queryPermissions(String name);
}
