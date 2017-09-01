package com.ovit.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ovit.bee.IDao.BrowseLogMapper;
import com.ovit.bee.pojo.BrowseLog;
import com.ovit.bee.service.BrowseLogService;

@Service(value="browseLogService")
public class BrowseLogServiceImpl implements BrowseLogService {
		
	@Autowired
	private BrowseLogMapper browseLogMapper;
	
	@Override
	public PageInfo<BrowseLog> findBrowseLog(int pageNum, int pageSize,BrowseLog info){
		PageHelper.startPage(pageNum, pageSize);
		List<BrowseLog> list = browseLogMapper.findBrowseLog(info);
		return new PageInfo<>(list);
	}
	
	@Override
	public void insertBrowseLog(BrowseLog info){
		browseLogMapper.insert(info);
	}
}
