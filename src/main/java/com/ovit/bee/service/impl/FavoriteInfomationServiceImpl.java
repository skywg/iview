package com.ovit.bee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.FavoriteInfomationMapper;
import com.ovit.bee.pojo.FavoriteInfomation;
import com.ovit.bee.service.FavoriteInfomationService;
@Service
public class FavoriteInfomationServiceImpl implements FavoriteInfomationService {
	@Autowired
	private  FavoriteInfomationMapper dao;
	@Override
	public int insert(FavoriteInfomation record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public FavoriteInfomation selectByAccount(String account) {
		// TODO Auto-generated method stub
		return dao.selectByAccount(account);
	}

}
