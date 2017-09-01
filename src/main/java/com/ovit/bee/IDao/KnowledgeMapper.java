package com.ovit.bee.IDao;

import java.util.List;
import java.util.Map;

import com.ovit.bee.pojo.Knowledge;

public interface KnowledgeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Knowledge record);

    int insertSelective(Knowledge record);

    Knowledge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Knowledge record);

    int updateByPrimaryKey(Knowledge record);
    
    List<Knowledge> findKnowLedge();
    
    List<Map<String, Object>> findShow();
    
    List<Knowledge> findKnowLedgeTitle(Knowledge record);
    
}