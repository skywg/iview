package com.ovit.bee.service.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.service.RemarkService;
@Service
public class RemarkServiceImpl implements RemarkService {
	@Autowired
	private SqlSession sqlsession;
	@Override
	public int insert(Map<String, Object> map) {
		int num=sqlsession.insert("RemarkMapper.insert", map);
		return num;
	}

	@Override
	public Map<String, Object> selectByAccount(String account) {
		return sqlsession.selectMap("RemarkMapper.selectByAccount", account);
	}

}
