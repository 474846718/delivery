package com.cni.mapper;

import com.cni.entity.SysMenu;
import java.util.List;


public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
    
    List<SysMenu> findByUserId(Integer id);
    
    List<SysMenu> findByAll();
}