package com.ovit.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ovit.bee.IDao.CoterieArticleCommentMapper;
import com.ovit.bee.pojo.CoterieArticleComment;
import com.ovit.bee.service.CoterieArticleCommentService;
@Service
public class CoterieArticleCommentServiceImpl implements CoterieArticleCommentService {
	@Autowired
	private CoterieArticleCommentMapper  coterieArticleCommentDao;
	@Override
	public List<CoterieArticleComment> findAll() {
		
		return coterieArticleCommentDao.findAll();
	}

	@Override
	public PageInfo<CoterieArticleComment> query(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<CoterieArticleComment> list=coterieArticleCommentDao.findAll();
		return new PageInfo<>(list);
	}

}
