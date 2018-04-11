package com.cni.mapper;

import com.cni.entity.SysUserinfo;

import java.util.List;

public interface SysUserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserinfo record);

    int insertSelective(SysUserinfo record);

    SysUserinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserinfo record);

    int updateByPrimaryKey(SysUserinfo record);
    
    List<SysUserinfo> findByAll(SysUserinfo record);
}