package com.boss.rbac_learning.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailPo {
    private int id;

    private String username;

    private int roleid;

    private List<String> premissions;
}
