package com.ovit.bee.IDao;

import java.util.List;
import java.util.Map;

import com.ovit.bee.pojo.CoterieArticle;

public interface CoterieArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CoterieArticle record);
    
    List<CoterieArticle> findAll();
    
    List<CoterieArticle> findDesc();
    
    List<CoterieArticle> findHot();
    
    List<CoterieArticle> findDay();
    
    List<CoterieArticle> findById(int id);
    
    List<Map<String, Object>> list();
    
    List<Map<String, Object>> rank();


    CoterieArticle selectByPrimaryKey(Integer id);



    int updateByPrimaryKey(CoterieArticle record);
}