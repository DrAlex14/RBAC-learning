package com.boss.rbac_learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class role_premission {
    private int roleid;

    private int premissionid;
}
