package com.ovit.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.MyAppMapper;
import com.ovit.bee.pojo.MyApp;
import com.ovit.bee.service.MyAppService;
@Service
public class MyAppServiceImpl implements MyAppService {
	@Autowired
	private MyAppMapper MyAppIDao;
	@Override
	
	public int insert(List<MyApp> record){
		return MyAppIDao.insert(record);
	}

	@Override
	public MyApp selectByAccount(String account) {
		return MyAppIDao.selectByAccount(account);
	}


	@Override
	public List<MyApp> selectByLevel(Integer level) {
		return MyAppIDao.selectByLevel(level);
	}

}
