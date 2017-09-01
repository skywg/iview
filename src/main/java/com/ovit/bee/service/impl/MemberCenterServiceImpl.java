package com.ovit.bee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.MyFavoriteMapper;
import com.ovit.bee.IDao.SignInMapper;
import com.ovit.bee.pojo.SignIn;
import com.ovit.bee.service.MemberCenterService;

@Service
public class MemberCenterServiceImpl implements MemberCenterService {
	
	@Autowired
	private MyFavoriteMapper myfavoriteMapper;
	
	@Autowired
	private SignInMapper signInMapper;
	
	@Override
	public Integer findMyMessage(String userId) throws Exception{
		Integer count= myfavoriteMapper.findMyMessage(userId);
		return  count;
	}
	
	@Override
	public Integer insertSignIn(String account){ 
		SignIn signIn = new SignIn();
		signIn.setAccount(account);
		Integer count = signInMapper.insert(signIn);
		return count;
	}
	
	@Override
	public Integer findCountSignIn(String account){
		Integer signNum = signInMapper.findCountSignIn(account);
		return signNum;
	}
}
