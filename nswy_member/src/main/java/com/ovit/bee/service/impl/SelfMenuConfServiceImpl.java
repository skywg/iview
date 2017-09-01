package com.ovit.bee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.SelfMenuConfMapper;
import com.ovit.bee.pojo.SelfMenuConf;
import com.ovit.bee.service.SelfMenuConfService;
@Service
public class SelfMenuConfServiceImpl implements SelfMenuConfService {
	
	@Autowired
	private SelfMenuConfMapper selfMCMDao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return selfMCMDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SelfMenuConf record) {
		// TODO Auto-generated method stub
		return selfMCMDao.insert(record);
	}

	@Override
	public SelfMenuConf selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return selfMCMDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(SelfMenuConf record) {
		// TODO Auto-generated method stub
		return selfMCMDao.updateByPrimaryKey(record);
	}

	@Override
	public void deleteByAccount(String account) {
		// TODO Auto-generated method stub
		selfMCMDao.deleteByAccount(account);
	}

	@Override
	public SelfMenuConf findByAccount(String account) {
		// TODO Auto-generated method stub
		return selfMCMDao.findByAccount(account);
	}

}
