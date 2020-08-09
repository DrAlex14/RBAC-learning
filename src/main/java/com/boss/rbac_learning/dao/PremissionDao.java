package com.boss.rbac_learning.dao;

import com.boss.rbac_learning.entity.dto.PremissionDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface PremissionDao {

     List<PremissionDto> queryAll();

     int addPermission(int id, String name, String permissionurl);

     int delete(String name);
}
