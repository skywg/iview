package com.ovit.bee.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.Expert;

public interface ExpertService {
	List<Expert> findAll();
	
	PageInfo<Expert> query(int pageNum, int pageSize);

	PageInfo<Expert> findExpertTitle(int pageNum, int pageSize, String title);
	
	
	

}
