package com.boss.rbac_learning.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailDto {
    private int id;

    private String username;

    private int roleid;

    private List<String> premissions;
}
