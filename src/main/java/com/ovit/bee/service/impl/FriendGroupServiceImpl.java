package com.ovit.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.FriendGroupMapper;
import com.ovit.bee.pojo.FriendGroup;
import com.ovit.bee.service.FriendGroupService;
@Service
public class FriendGroupServiceImpl implements FriendGroupService {
	@Autowired
	private FriendGroupMapper friendGroup;
	@Override
	public int insert(List<FriendGroup> record) {
		
		return friendGroup.insert(record);
	}

}
