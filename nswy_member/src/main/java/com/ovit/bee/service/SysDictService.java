package com.ovit.bee.service;

import java.util.List;

import com.ovit.bee.pojo.SysDict;

public interface SysDictService {
	
	List<SysDict> findByName(String name);

}
