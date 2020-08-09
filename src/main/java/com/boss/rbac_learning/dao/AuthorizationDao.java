package com.boss.rbac_learning.dao;

import com.boss.rbac_learning.entity.dto.AuthorizationDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface AuthorizationDao {

    int add(int roleid, int permissionid);

    int delete(int id);

    List<AuthorizationDto> queryAll();
}
