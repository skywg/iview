package com.ovit.bee.IDao;

import java.util.List;

import com.ovit.bee.pojo.Expert;

public interface ExpertMapper {

    int insert(Expert record);

    Expert selectByPrimaryKey(Integer id);
    
    List<Expert> findAll();
    
    List<Expert> findExpertTitle(Expert record);

    int updateByPrimaryKey(Expert record);
}