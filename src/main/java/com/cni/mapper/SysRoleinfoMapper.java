package com.cni.mapper;

import com.cni.entity.SysRoleinfo;

import java.util.List;

public interface SysRoleinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleinfo record);

   int insertSelective(SysRoleinfo record);

    SysRoleinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleinfo record);

    int updateByPrimaryKey(SysRoleinfo record);
    
    List<SysRoleinfo> findByAll();
}