package com.ovit.bee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.FavoritePolicyMapper;
import com.ovit.bee.pojo.FavoritePolicy;
import com.ovit.bee.service.FavoritePolicyService;
@Service
public class FavoritePolicyServiceImpl implements FavoritePolicyService {
	@Autowired
	private FavoritePolicyMapper dao;
	@Override
	public int insert(FavoritePolicy record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public FavoritePolicy selectByAccount(String account) {
		// TODO Auto-generated method stub
		return dao.selectByAccount(account);
	}

}
