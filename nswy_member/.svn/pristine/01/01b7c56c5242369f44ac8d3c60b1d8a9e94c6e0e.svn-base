package com.ovit.bee.IDao;

import java.util.List;

import com.ovit.bee.pojo.InfoComment;

public interface InfoCommentMapper {
    int deleteByPrimaryKey(Integer id);

    void insert(InfoComment record);

    int insertSelective(InfoComment record);

    InfoComment selectByPrimaryKey(Integer id);
    
    void updateThumbUpNum(InfoComment record);

    int updateByPrimaryKeySelective(InfoComment record);

    int updateByPrimaryKey(InfoComment record);
    
    List<InfoComment> findInfoComment(InfoComment record);
    
    List<InfoComment> findInfoCommentId(InfoComment record);
    
    List<InfoComment> findMyComment(InfoComment record);
}