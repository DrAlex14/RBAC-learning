package com.boss.rbac_learning.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationDto {
    private int id;

    private int roleid;

    private int permissionid;
}
