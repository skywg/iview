package com.ovit.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ovit.bee.IDao.MyDyNamicMapper;
import com.ovit.bee.IDao.MyFollowMapper;
import com.ovit.bee.IDao.MydynamicCommentMapper;
import com.ovit.bee.service.MydynamicService;
import com.ovit.bee.pojo.MyDyNamic;
import com.ovit.bee.pojo.MyFollow;
import com.ovit.bee.pojo.MydynamicComment;

@Service
public class MydynamicServiceImpl implements MydynamicService {

	@Autowired
	private MyDyNamicMapper myDyNamicMapper;
	
	@Autowired
	private MydynamicCommentMapper mydynamicCommentMapper;
	
	@Autowired
	private MyFollowMapper myFollowMapper;
	
	@Override
	public void saveMyDyNamic(MyDyNamic info){
			myDyNamicMapper.insert(info);
	}
	
	
	@Override
	public PageInfo<MyDyNamic> findMyDyNamic(int pageNum, int pageSize,String account){
		PageHelper.startPage(pageNum, pageSize);
		List<MyDyNamic> list  = myDyNamicMapper.findMyDyNamic(account);
		return new PageInfo<MyDyNamic>(list);
		
	}
	
	@Override
	public MyDyNamic updateMyDyNamic(Integer id){
		MyDyNamic info = myDyNamicMapper.findThumbUpNum(String.valueOf(id));
		if(info!=null){
			info.setThumbUpNum(info.getThumbUpNum()+1);
			myDyNamicMapper.updateThumbUpNum(info);
			return info;
		}
		
		return null;
	}
	
	/**
	 * 回复
	 * @param info
	 */
	@Override
	public void saveMyDyNamicComment(MydynamicComment info){
		mydynamicCommentMapper.insert(info);
	}
	
	
	@Override
	public PageInfo<MyFollow> findFollowInforMation(int pageNum, int pageSize,String account){
		PageHelper.startPage(pageNum, pageSize);
		List<MyFollow> list  = myFollowMapper.findFollowInforMation(account);
		return new PageInfo<MyFollow>(list);
		
	}
	
	@Override
	public PageInfo<MyFollow> findFollowKnowLedge(int pageNum, int pageSize,String account){
		PageHelper.startPage(pageNum, pageSize);
		List<MyFollow> list  = myFollowMapper.findFollowKnowLedge(account);
		return new PageInfo<MyFollow>(list);
		
	}
	
	@Override
	public PageInfo<MyFollow> findFollowPolicy(int pageNum, int pageSize,String account){
		PageHelper.startPage(pageNum, pageSize);
		List<MyFollow> list  = myFollowMapper.findFollowPolicy(account);
		return new PageInfo<MyFollow>(list);
		
	}
	
	
}
