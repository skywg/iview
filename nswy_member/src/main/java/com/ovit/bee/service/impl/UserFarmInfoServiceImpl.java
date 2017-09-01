package com.ovit.bee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.UserFarmInfoMapper;
import com.ovit.bee.pojo.UserFarmInfo;
import com.ovit.bee.service.UserFarmInfoService;

@Service
public class UserFarmInfoServiceImpl implements UserFarmInfoService{
	
	@Autowired
	private UserFarmInfoMapper userFarmInfoMapper;
	
	@Override
	public UserFarmInfo findUserFarmInfo(UserFarmInfo info){
		UserFarmInfo userFarmInfo = userFarmInfoMapper.findUserFarmInfo(info);
		return userFarmInfo;
		
	}
	@Override
	public void updateUserFarmInfo(UserFarmInfo info){
		
		userFarmInfoMapper.updateUserFarmInfo(info);
	}
}
