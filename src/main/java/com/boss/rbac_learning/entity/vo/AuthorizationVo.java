package com.boss.rbac_learning.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationVo {
    private int id;

    private int roleid;

    private int permissionid;
}
