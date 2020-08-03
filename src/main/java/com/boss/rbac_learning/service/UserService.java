package com.boss.rbac_learning.service;


import com.boss.rbac_learning.entity.User;
import com.boss.rbac_learning.entity.UserForHighLevel;
import java.util.List;

public interface UserService {

    void updateAuthority(int authority, int id);

    void delById(int id);

    void add(UserForHighLevel user);

    List<UserForHighLevel> queryAllHighLevel();

    List<User> queryAll();
}
