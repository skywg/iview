package com.ovit.bee.service.impl;

import java.util.List;

import com.ovit.bee.IDao.IndustrialclassifiedMapper;
import com.ovit.bee.pojo.Industrialclassified;
import com.ovit.bee.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	private IndustrialclassifiedMapper industrialclassifiedMapper;

	public void findIndu(Industrialclassified info) {
		List<Industrialclassified> list  = industrialclassifiedMapper.findIndu();
		/*TreeUtil util = new TreeUtil(list);
		List<Industrialclassified> lists = util.createTreeList();*/
	}
	
}
