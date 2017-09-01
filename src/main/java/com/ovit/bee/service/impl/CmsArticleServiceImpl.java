package com.ovit.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.CmsArticleMapper;
import com.ovit.bee.pojo.CmsArticle;
import com.ovit.bee.service.CmsArticleService;

@Service
public class CmsArticleServiceImpl implements CmsArticleService{
	@Autowired
	private CmsArticleMapper cmsArticleMapper;

	@Override
	public List<CmsArticle> findArticle() throws Exception {
		CmsArticle cms = new CmsArticle();
		List<CmsArticle> cm  = cmsArticleMapper.findArticle(cms);
		return cm;
	}
}
