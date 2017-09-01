package com.ovit.bee.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.CoterieArticle;

public interface CoterieArticleService {
	 	List<CoterieArticle> findAll();
	    
	    List<CoterieArticle> findDesc();
	    
	    List<CoterieArticle> findHot();
	    
	    List<CoterieArticle> findDay();
	    
	    List<Map<String, Object>> list();
	    
	    List<Map<String, Object>> rank();
	    
	    PageInfo<CoterieArticle> findById(int id,int pageNum,int pageSize);

}
