package com.boss.rbac_learning.service.impl;

import com.boss.rbac_learning.dao.PremissionDao;
import com.boss.rbac_learning.entity.dto.PremissionDto;
import com.boss.rbac_learning.entity.vo.PremissionVo;
import com.boss.rbac_learning.service.PremissionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class PremissionServiceImpl implements PremissionService {

    @Resource
    PremissionDao premissionDao;

    @Override
    public List<PremissionVo> queryAll() {
        List<PremissionDto> premissionDtoList = premissionDao.queryAll();
        List<PremissionVo> premissionVoList = new ArrayList<PremissionVo>();

        log.info(premissionDtoList);

        if(premissionDtoList != null){
            for(PremissionDto premissionDto : premissionDtoList){
                PremissionVo premissionVo = new PremissionVo();
                BeanUtils.copyProperties(premissionDto,premissionVo);
                premissionVoList.add(premissionVo);
            }
        }
        return premissionVoList;
    }

    @Override
    public int addPermission(int id, String name, String permissionurl) {
        int result = premissionDao.addPermission(id,name,permissionurl);
        return result;
    }

    @Override
    public int deletePermission(String name) {
        int result = premissionDao.delete(name);
        return result;
    }
}
