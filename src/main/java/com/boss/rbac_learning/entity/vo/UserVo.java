package com.boss.rbac_learning.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    private int id;

    private String username;

    private int roleid;
}
