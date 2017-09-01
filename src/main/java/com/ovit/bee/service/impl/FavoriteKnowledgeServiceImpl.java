package com.ovit.bee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.FavoriteKnowledgeMapper;
import com.ovit.bee.pojo.FavoriteKnowledge;
import com.ovit.bee.service.FavoriteKnowledgeService;
@Service
public class FavoriteKnowledgeServiceImpl implements FavoriteKnowledgeService {
	@Autowired
	private FavoriteKnowledgeMapper dao;
	@Override
	public int insert(FavoriteKnowledge record) {
		return dao.insert(record);
	}
	@Override
	public FavoriteKnowledge selectByAccount(String account) {
		return dao.selectByAccount(account);
	}

}
