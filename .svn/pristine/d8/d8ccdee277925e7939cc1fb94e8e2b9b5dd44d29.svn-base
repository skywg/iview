package com.ovit.bee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.UserWorkExperienceMapper;
import com.ovit.bee.pojo.UserWorkExperience;
import com.ovit.bee.service.UserWorkExperienceService;

@Service
public class UserWorkExperienceServiceImpl implements UserWorkExperienceService {
	
	@Autowired
	private UserWorkExperienceMapper userWorkExperienceMapper;
	
	@Override
	public UserWorkExperience findUserWork(UserWorkExperience info){
		UserWorkExperience  userWork = userWorkExperienceMapper.findUserWork(info);
		return userWork;
		
	}
	
	@Override
	public void updateUserWork(UserWorkExperience info){
		userWorkExperienceMapper.updateUserWork(info);
	}
}
