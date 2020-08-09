package com.boss.rbac_learning.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PremissionPo {
    private int id;

    private String permissionname;

    private String permissionurl;

}
