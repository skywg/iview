package com.ovit.bee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.ContactInfoMapper;
import com.ovit.bee.pojo.ContactInfo;
import com.ovit.bee.service.ContactInfoService;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {
	
	@Autowired
	private ContactInfoMapper contactInfoMapper;
	
	@Override
	public ContactInfo findContactInfo(ContactInfo info){
		ContactInfo contactInfo  = contactInfoMapper.findContactInfo(info);
		return contactInfo;
	}
	
	@Override
	public void updateContactInfo(ContactInfo info){
		contactInfoMapper.updateContactInfo(info);
	}
}
