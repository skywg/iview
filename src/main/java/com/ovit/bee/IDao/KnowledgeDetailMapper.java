package com.ovit.bee.IDao;

import java.util.List;

import com.ovit.bee.pojo.KnowledgeDetail;

public interface KnowledgeDetailMapper {
   
    int insert(KnowledgeDetail record);

    KnowledgeDetail selectByPrimaryKey(Integer id);
    
    List<KnowledgeDetail> findColumnKnow(KnowledgeDetail record);
    
    void updateThumbUpNum(KnowledgeDetail record);
}