package com.ovit.bee.IDao;

import java.util.List;

import com.ovit.bee.pojo.KnowledgeComment;

public interface KnowledgeCommentMapper {

    void insert(KnowledgeComment record);
    
    KnowledgeComment selectByPrimaryKey(Integer id);
    
    List<KnowledgeComment> findKnowledgeComment(KnowledgeComment record);
    
    List<KnowledgeComment> findKnowledgeCommentId(KnowledgeComment record);
    
    List<KnowledgeComment> findMyComment(KnowledgeComment record);
    
    void updateThumbUpNum(KnowledgeComment record);
}