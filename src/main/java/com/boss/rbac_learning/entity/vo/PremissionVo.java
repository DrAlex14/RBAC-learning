package com.boss.rbac_learning.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PremissionVo {
    private int id;

    private String permissionname;

    private String permissionurl;

}
