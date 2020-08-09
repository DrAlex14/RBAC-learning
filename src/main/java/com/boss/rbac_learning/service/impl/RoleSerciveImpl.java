package com.boss.rbac_learning.service.impl;

import com.boss.rbac_learning.dao.RoleDao;
import com.boss.rbac_learning.entity.dto.RoleDto;
import com.boss.rbac_learning.entity.po.RolePo;
import com.boss.rbac_learning.entity.vo.RoleVo;
import com.boss.rbac_learning.service.RoleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class RoleSerciveImpl implements RoleService {

    @Resource
    RoleDao roleDao;

    @Override
    public List<RoleVo> queryAll() {
        List<RoleDto> roleDtoList = roleDao.queryAll();
        List<RoleVo> roleVoList = new ArrayList<RoleVo>();
        if(roleDtoList.size()!=0){
            for(RoleDto roleDto:roleDtoList){
                RoleVo roleVo = new RoleVo();
                BeanUtils.copyProperties(roleDto,roleVo);
                roleVoList.add(roleVo);
            }
        }
        if(roleVoList !=null ){
            return roleVoList;
        }else{
            return null;
        }
    }

    @Override
    public int addRole(int id, String name) {
        RolePo rolePo = new RolePo(id,name);
        int result = roleDao.addRole(id,name);
            return result;
    }

    @Override
    public int deleteByName(String name) {
        int result = roleDao.deleteByName(name);
        return result;
    }

    @Override
    public int update(int id,String name) {
        int result = roleDao.update(id,name);
        return result;
    }

    @Override
    public List<String> queryPremissions(String name) {
        List<String> list = roleDao.queryPremissions(name);
        log.info(list);

        return list;
    }


}
