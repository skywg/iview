package com.ovit.bee.service;

import com.ovit.bee.pojo.FavoriteInfomation;

public interface FavoriteInfomationService {
	
	 int insert(FavoriteInfomation record);

	 FavoriteInfomation selectByAccount(String account);

}
