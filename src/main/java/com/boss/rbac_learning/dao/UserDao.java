package com.boss.rbac_learning.dao;

import com.boss.rbac_learning.entity.User;
import com.boss.rbac_learning.entity.UserForHighLevel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {

    void updateAuthority(int authority, int id);

    List<UserForHighLevel> queryAllHighLevel();

    List<User> queryAll();

    void delById(int id);

    void add(UserForHighLevel user);
}
