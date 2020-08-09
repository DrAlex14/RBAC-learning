package com.boss.rbac_learning.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationPo {
    private int id;

    private int roleid;

    private int permissionid;
}
