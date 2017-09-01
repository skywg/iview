package com.ovit.bee.IDao;

import java.util.List;

import com.ovit.bee.pojo.Policy;

public interface PolicyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Policy record);

    int insertSelective(Policy record);

    Policy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Policy record);

    int updateByPrimaryKey(Policy record);
    
    List<Policy> findPolicy();
    
    List<Policy> findPolicyTitle(Policy record);
    
    List<Policy> findIndexPolicy(Policy record);
}