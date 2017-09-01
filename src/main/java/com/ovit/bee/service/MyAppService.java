package com.ovit.bee.service;

import java.util.List;

import com.ovit.bee.pojo.MyApp;

public interface MyAppService {
	 int insert(List<MyApp> record);
    
    MyApp selectByAccount(String account);
    
    List<MyApp> selectByLevel(Integer level);
   
}