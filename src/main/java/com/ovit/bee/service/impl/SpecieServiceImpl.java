package com.ovit.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.SpeciesMapper;
import com.ovit.bee.pojo.Species;
import com.ovit.bee.service.SpecieService;
@Service
public class SpecieServiceImpl implements SpecieService{
	@Autowired
	private SpeciesMapper dao;
	@Override
	public int insert(List<Species> record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

}
