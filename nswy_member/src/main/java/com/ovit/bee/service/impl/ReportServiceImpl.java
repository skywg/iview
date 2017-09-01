package com.ovit.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.JuBaoMapper;
import com.ovit.bee.IDao.MyFavoriteMapper;
import com.ovit.bee.IDao.MyFollowMapper;
import com.ovit.bee.IDao.MyFriendMapper;
import com.ovit.bee.IDao.MyNoTitleMapper;
import com.ovit.bee.pojo.JuBao;
import com.ovit.bee.pojo.MyFavorite;
import com.ovit.bee.pojo.MyFollow;
import com.ovit.bee.pojo.MyFriend;
import com.ovit.bee.pojo.MyNoTitle;
import com.ovit.bee.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{
	@Autowired
	private JuBaoMapper juBaoMapper;
	@Autowired
	private MyNoTitleMapper myNoTitleMapper;
	@Autowired
	private MyFriendMapper myFriendMapper;
	@Autowired
	private MyFavoriteMapper myFavoriteMapper;
	@Autowired
	private MyFollowMapper myFollowMapper;
	
	
	@Override
	public void insert(JuBao report){
		juBaoMapper.insert(report);
	}
	
	@Override
	public MyNoTitle findMyTitle(MyNoTitle info){
		return myNoTitleMapper.findMyTitle(info);
	}
	@Override
	public Integer findMyFriend(MyFriend info){
		List<MyFriend> list = myFriendMapper.findMyFriend(info);
		
		return list.size();
	}
	@Override
	public List<MyFavorite> findCollect(MyFavorite info){

		return myFavoriteMapper.findCollect(info);
	}
	@Override
	public String saveCollect(MyFavorite info){
		List<MyFavorite> myFavorite = myFavoriteMapper.findCollect(info);
		if(myFavorite.size()>0){
			return "message";
		}else{
			myFavoriteMapper.insert(info);
			return "success";
			
		}
	}

	@Override
	public String saveFollow(MyFollow info){
		List<MyFollow> myFavorite = myFollowMapper.findMyFollow(info);
		if(myFavorite.size()>0){
			return "message";
		}else{
			myFollowMapper.insertMyFollow(info);
			return "success";
			
		}
	}
	
}
