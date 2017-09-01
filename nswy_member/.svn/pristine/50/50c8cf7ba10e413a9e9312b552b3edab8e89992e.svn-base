package com.ovit.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.FriendMapper;
import com.ovit.bee.pojo.Friend;
import com.ovit.bee.service.FriendService;
@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendMapper friendDao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return friendDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Friend record) {
		// TODO Auto-generated method stub
		return friendDao.insert(record);
	}

	@Override
	public List<Friend> findByName(String name) {
		// TODO Auto-generated method stub
		return friendDao.findByName(name);
	}

	@Override
	public Friend selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return friendDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Friend> findAll() {
		// TODO Auto-generated method stub
		return friendDao.findAll();
	}

	@Override
	public int updateByPrimaryKey(Friend record) {
		// TODO Auto-generated method stub
		return friendDao.updateByPrimaryKey(record);
	}

}
