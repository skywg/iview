package com.ovit.bee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.CertificationMapper;
import com.ovit.bee.pojo.Certification;
import com.ovit.bee.service.CertificationService;
@Service
public class CertificationServiceImpl implements CertificationService {
	
	@Autowired
	private CertificationMapper certificationDao;

	@Override
	public int insert(Certification record) {
		
		return certificationDao.insert(record);
	}

	@Override
	public Certification selectByAccount(String account) {
		return certificationDao.selectByAccount(account);
	}

}
