package com.ovit.bee.IDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ovit.bee.pojo.CmsArticle;
@Mapper
public interface CmsArticleMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(CmsArticle record);

    int insertSelective(CmsArticle record);

    List<CmsArticle> findArticle(CmsArticle cm);

    int updateByPrimaryKeySelective(CmsArticle record);
    
    int updateByPrimaryKey(CmsArticle record);
}