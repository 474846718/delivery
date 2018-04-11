package com.cni.service.impl;

import com.cni.entity.SysMenu;
import com.cni.mapper.SysMenuMapper;
import com.cni.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    private final SysMenuMapper sysMenuMapper;

    @Autowired
    public SysMenuServiceImpl(SysMenuMapper sysMenuMapper) {
        this.sysMenuMapper = sysMenuMapper;
    }

    /**
     * 根据主键muId删除指定菜单
     */
    @Override
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> map = new HashMap<>();
        int res = sysMenuMapper.deleteByPrimaryKey(id);
        if (res > 0) {
            map.put("status", "success");
            map.put("msg", "删除成功");
        } else {
            map.put("status", "fail");
            map.put("msg", "删除失败");
        }
        return map;
    }

    /**
     * 保存数据
     * 主键Id为空时表示保存数据，不为空时表示修改数据
     */
    @Override
    public Map<String, Object> save(SysMenu record) {
        Map<String, Object> map = new HashMap<>();
        int res = 0;
        if (record.getId() == null) {  //id为空表示插入数据
            res = sysMenuMapper.insert(record);
        } else {
            res = sysMenuMapper.updateByPrimaryKey(record);
        }

        if (res > 0) {
            map.put("status", "success");
            map.put("msg", "保存成功");
        } else {
            map.put("status", "fail");
            map.put("msg", "保存失败");
        }

        return map;
    }

    /**
     * 根据用户id加载有权限的菜单
     */
    @Override
    public List<SysMenu> findByUserId(Integer id) {
        List<SysMenu> list = (id == 1) ?
                sysMenuMapper.findByAll() :
                sysMenuMapper.findByUserId(id);
        return getChildrenNode(1, list);
    }



    /**
     * @param pid pid
     * @param treeDataList treeDataList
     * @return
     */
    private static List<SysMenu> getChildrenNode(Integer pid, List<SysMenu> treeDataList) {
        List<SysMenu> newTreeDataList = new ArrayList<>();
        for (SysMenu jsonTreeData : treeDataList) {
            if (jsonTreeData.getParentid() == null) continue;
            //这是一个子节点

            if (jsonTreeData.getParentid().equals(pid)) {
                //递归获取子节点下的子节点
                jsonTreeData.setChildren(getChildrenNode(jsonTreeData.getId(), treeDataList));
                newTreeDataList.add(jsonTreeData);
            }
        }
        return newTreeDataList;
    }

}
