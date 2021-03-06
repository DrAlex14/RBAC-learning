package com.boss.rbac_learning.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PremissionDto {
    private int id;

    private String permissionname;

    private String permissionurl;

}
