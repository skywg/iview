package com.ovit.bee.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ovit.bee.IDao.CoterieArticleMapper;
import com.ovit.bee.pojo.CoterieArticle;
import com.ovit.bee.service.CoterieArticleService;
@Service
public class CoterieArticleServiceImpl implements CoterieArticleService {
	@Autowired
	private CoterieArticleMapper CoterieArticleDao;

	@Override
	public List<CoterieArticle> findAll() {
		return CoterieArticleDao.findAll();
	}

	@Override
	public List<CoterieArticle> findDesc() {
		return CoterieArticleDao.findDesc();
	}

	/**
	 *
	 */
	@Override
	public List<CoterieArticle> findHot() {
		return CoterieArticleDao.findHot();
	}

	@Override
	public List<CoterieArticle> findDay() {
		// TODO Auto-generated method stub
		return CoterieArticleDao.findDay();
	}

	@Override
	public List<Map<String, Object>> list() {
		// TODO Auto-generated method stub
		return CoterieArticleDao.list();
	}

	@Override
	public List<Map<String, Object>> rank() {
		// TODO Auto-generated method stub
		return CoterieArticleDao.rank();
	}

	@Override
	public PageInfo<CoterieArticle> findById(int id,int pageNum,int pageSize ) {
		PageHelper.startPage(pageNum, pageSize);
		List<CoterieArticle> list=CoterieArticleDao.findById(id);
		return new PageInfo<CoterieArticle>(list);
	}

}
