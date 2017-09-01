package com.ovit.bee.IDao;

import com.ovit.bee.pojo.MydynamicComment;

public interface MydynamicCommentMapper {
   
    int insert(MydynamicComment record);

    MydynamicComment findMydynamicComment(Integer id);

    int updateByMydynamicComment(MydynamicComment record);
}