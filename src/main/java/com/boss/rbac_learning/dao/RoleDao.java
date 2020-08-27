package com.boss.rbac_learning.dao;

import com.boss.rbac_learning.entity.dto.PremissionDto;
import com.boss.rbac_learning.entity.dto.RoleDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleDao {
    List<RoleDto> queryAll();

    int addRole(int id, String name);

    int deleteByName(String name);

    int update(int id,String name);

    List<String> queryPremissions(String name);
}
