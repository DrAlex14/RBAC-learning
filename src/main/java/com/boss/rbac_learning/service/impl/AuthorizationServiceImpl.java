package com.boss.rbac_learning.service.impl;

import com.boss.rbac_learning.dao.AuthorizationDao;
import com.boss.rbac_learning.entity.dto.AuthorizationDto;
import com.boss.rbac_learning.entity.vo.AuthorizationVo;
import com.boss.rbac_learning.service.AuthorizationService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Resource
    AuthorizationDao authorizationDao;

    @Override
    public List<AuthorizationVo> queryAll() {
        List<AuthorizationDto> authorizationDtoList = authorizationDao.queryAll();
        List<AuthorizationVo> authorizationVoList = new ArrayList<AuthorizationVo>();
        if(authorizationDtoList != null){
            for(AuthorizationDto authorizationDto : authorizationDtoList){
                AuthorizationVo authorizationVo = new AuthorizationVo();
                BeanUtils.copyProperties(authorizationDto,authorizationVo);
                authorizationVoList.add(authorizationVo);
            }
        }
        return authorizationVoList;
    }

    @Override
    public int add(int roleid, int permissionid) {
        int result = authorizationDao.add(roleid,permissionid);
        return result;
    }

    @Override
    public int delete(int id) {
        int result = authorizationDao.delete(id);
        return result;
    }


}
