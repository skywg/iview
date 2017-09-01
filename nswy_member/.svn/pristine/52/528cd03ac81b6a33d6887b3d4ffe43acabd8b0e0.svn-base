package com.ovit.bee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ovit.bee.IDao.UserFullInfoMapper;
import com.ovit.bee.pojo.UserFullInfo;
import com.ovit.bee.service.UserFullInfoService;

@Service
public class UserFullInfoServiceImpl implements UserFullInfoService {
	
	@Autowired
	private UserFullInfoMapper userFullInfoMapper;
	
	@Override
	public UserFullInfo findUserFullInfo(UserFullInfo user){
		UserFullInfo userFullInfo  = userFullInfoMapper.findUserFullInfo(user);
		
		return userFullInfo;
	}
	@Transactional
	@Override
	public int updateUserFullInfo(UserFullInfo user){
		return userFullInfoMapper.updateUserFullInfo(user);
	}
	@Transactional
	@Override
	public int insert(UserFullInfo user) {
		return userFullInfoMapper.insert(user);
	}
}
