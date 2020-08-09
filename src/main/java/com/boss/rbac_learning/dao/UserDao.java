package com.boss.rbac_learning.dao;


import com.boss.rbac_learning.entity.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    UserDto login(String username, String password);

    int addUser(int id, String username, String password);

    int deleteByName(String username);

    int updateRole(String username,Integer roleid);

    List<UserDto> queryAll();

    List<String> getUserDetail(int id);
}
