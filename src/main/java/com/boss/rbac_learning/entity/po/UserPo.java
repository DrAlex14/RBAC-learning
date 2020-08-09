package com.boss.rbac_learning.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPo {
    private int id;

    private String username;

    private String password;

    private int roleid;
}
