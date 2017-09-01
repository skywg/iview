package com.ovit.bee.service;

import java.util.List;

import com.ovit.bee.pojo.CmsArticle;

public interface CmsArticleService {
	public List<CmsArticle> findArticle() throws Exception;
}
