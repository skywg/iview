package com.ovit.bee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ovit.bee.IDao.UserInfoMapper;
import com.ovit.bee.pojo.UserInfo;
import com.ovit.bee.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public void updateUserInfo(UserInfo userInfo){
		userInfoMapper.updateUserInfo(userInfo);
	}
	
	@Override
	public UserInfo findUserInfo(UserInfo userInfo){
		UserInfo info  = userInfoMapper.findUserInfo(userInfo);
		return info;
	}
	
}
