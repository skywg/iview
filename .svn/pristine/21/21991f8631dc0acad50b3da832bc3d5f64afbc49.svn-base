package com.ovit.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ovit.bee.IDao.GovInfoMapper;
import com.ovit.bee.pojo.GovInfo;
import com.ovit.bee.service.GovInfoService;
@Service
public class GovInfoServiceImpl implements GovInfoService{
	@Autowired
	private GovInfoMapper govInfoDao;

	@Override
	public List<GovInfo> findAll() {
		// TODO Auto-generated method stub
		return govInfoDao.findAll();
	}

	@Override
	public PageInfo<GovInfo> query(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<GovInfo> list=govInfoDao.findAll();
		return new PageInfo<GovInfo>(list);
	}
	
	@Override
	public void insert(GovInfo govInfo){
		govInfoDao.insert(govInfo);
	}
	

}
