package com.boss.rbac_learning.service.impl;

import com.boss.rbac_learning.dao.UserDao;
import com.boss.rbac_learning.entity.dto.UserDto;
import com.boss.rbac_learning.entity.po.UserPo;
import com.boss.rbac_learning.entity.vo.UserVo;
import com.boss.rbac_learning.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public UserVo login(String username, String password) {
        UserDto userDto = userDao.login(username,password);
        if(userDto == null){
            return null;
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userDto,userVo);
        return userVo;
    }

    @Override
    public int addUser(int id, String username, String password) {
        UserPo userPo = new UserPo(id,username,password,1);
        int result = 0;
        try{
            result = userDao.addUser(id,username,password);
        } catch (Exception e) {
           return 0;
        }
        return result;
    }

    @Override
    public int deleteByName(String username) {
        int result =  userDao.deleteByName(username);
        return result;
    }

    @Override
    public int updateRole(String username,Integer roleid) {
        int result = userDao.updateRole(username,roleid);
        return result;
    }

    @Override
    public List<UserVo> queryAll() {
        List<UserVo> userVoList = new ArrayList<UserVo>();
        List<UserDto> userDtoList = userDao.queryAll();
        if(userDtoList.size()!=0){
            for(UserDto userDto:userDtoList){
                UserVo userVo = new UserVo();
                BeanUtils.copyProperties(userDto,userVo);
                userVoList.add(userVo);
            }
        }

      if(userDtoList !=null){
         return userVoList;
      }else{
          return null;
      }
    }

    @Override
    public List<String> getUserDetail(int id) {
        List<String> list = userDao.getUserDetail(id);
        return list;
    }


}
