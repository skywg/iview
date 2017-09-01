package com.ovit.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ovit.bee.IDao.CorpInfoMapper;
import com.ovit.bee.pojo.CorpInfo;
import com.ovit.bee.service.CorpInfoService;
@Service
public class CorpInfoServiceImpl implements CorpInfoService{

	@Autowired
	private CorpInfoMapper corpInfoMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(CorpInfo record) {
		corpInfoMapper.insert(record);
	}

	@Override
	public CorpInfo selectByPrimaryKey(Integer id) {
		return corpInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(CorpInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CorpInfo> findAll() {
		
		return corpInfoMapper.findAll();
	}

	@Override
	public PageInfo<CorpInfo> query(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<CorpInfo> list=corpInfoMapper.findAll();
		return new PageInfo<CorpInfo>(list);
	}
	
	

}
