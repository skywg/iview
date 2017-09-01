package com.ovit.bee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.UserEducationExperienceMapper;
import com.ovit.bee.pojo.UserEducationExperience;
import com.ovit.bee.service.UserEducationExperienceService;

@Service
public class UserEducationExperienceServiceImpl implements UserEducationExperienceService {
	
	@Autowired
	private UserEducationExperienceMapper userEducationExperienceMapper;
	
	@Override
	public UserEducationExperience findUserEducation(UserEducationExperience info){
		UserEducationExperience user = userEducationExperienceMapper.findUserEducation(info);
		return user;
	}
	
	@Override
	public void updateUserEducation(UserEducationExperience info){
		userEducationExperienceMapper.updateUserEducation(info);
	}
}
