package com.ovit.bee.IDao;

import java.util.List;

import com.ovit.bee.pojo.SysDict;

public interface SysDictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(Integer id);
    
    List<SysDict> findByName(String name);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);
}