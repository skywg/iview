package com.ovit.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ovit.bee.IDao.ExpertMapper;
import com.ovit.bee.pojo.Expert;
import com.ovit.bee.service.ExpertService;
@Service
public class ExpertServiceImpl implements ExpertService {
	@Autowired
	private ExpertMapper expertDao;

	@Override
	public List<Expert> findAll() {
		return expertDao.findAll();
	}

	@Override
	public PageInfo<Expert> query(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Expert> lists=expertDao.findAll();
		return new PageInfo<Expert>(lists);
	}
	
	@Override
	public  PageInfo<Expert> findExpertTitle(int pageNum, int pageSize,String title){
		PageHelper.startPage(pageNum, pageSize);
		Expert info = new Expert();
		info.setExpertName(title);
		List<Expert> list = expertDao.findExpertTitle(info);
		return new PageInfo<Expert>(list);
	}


}
