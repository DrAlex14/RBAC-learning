package com.boss.rbac_learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class UserForHighLevel {
    private int id;

    private String username;

    private String password;

    private int roleid;
}
