package com.boss.rbac_learning.service.impl;

import com.boss.rbac_learning.dao.UserDao;
import com.boss.rbac_learning.entity.User;
import com.boss.rbac_learning.entity.UserForHighLevel;
import com.boss.rbac_learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void updateAuthority(int authority, int id){
        userDao.updateAuthority(authority,id);
    }

    /**
     * 查询显示所有用户
     * @return 用户列表(分角色显示)
     */
    @Override
    public List<UserForHighLevel> queryAllHighLevel(){
        return userDao.queryAllHighLevel();
    }

    @Override
    public List<User> queryAll(){
        return userDao.queryAll();
    }

    @Override
    public void add(UserForHighLevel user){
        userDao.add(user);
    }

    @Override
    public void delById(int id){
        userDao.delById(id);
    }
}
