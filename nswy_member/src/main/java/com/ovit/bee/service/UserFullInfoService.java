package com.ovit.bee.service;

import com.ovit.bee.pojo.UserFullInfo;

public interface UserFullInfoService {

	public UserFullInfo findUserFullInfo(UserFullInfo user);

	public int updateUserFullInfo(UserFullInfo user);
	
	public int insert(UserFullInfo user);

}
