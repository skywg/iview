package com.ovit.bee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.UserCertificationMapper;
import com.ovit.bee.pojo.UserCertification;
import com.ovit.bee.service.UserCertificationService;

@Service
public class UserCertificationServiceImpl implements UserCertificationService{
	
	@Autowired
	private UserCertificationMapper userCertificationMapper;
	
	@Override
	public UserCertification findUserCertification(UserCertification info){
		
		return userCertificationMapper.findUserCertification(info);
	}
	
	@Override
	public void updateUserCertificaiton(UserCertification info){
		
		userCertificationMapper.updateUserCertification(info);
	}
}
