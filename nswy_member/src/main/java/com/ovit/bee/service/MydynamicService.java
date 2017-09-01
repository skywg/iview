package com.ovit.bee.service;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.MyDyNamic;
import com.ovit.bee.pojo.MyFollow;
import com.ovit.bee.pojo.MydynamicComment;

public interface MydynamicService {

	public void saveMyDyNamic(MyDyNamic info);

	public PageInfo<MyDyNamic> findMyDyNamic(int pageNum, int pageSize,String account);

	void saveMyDyNamicComment(MydynamicComment info);

	MyDyNamic updateMyDyNamic(Integer id);

	PageInfo<MyFollow> findFollowInforMation(int pageNum, int pageSize,
			String account);

	PageInfo<MyFollow> findFollowKnowLedge(int pageNum, int pageSize,
			String account);

	PageInfo<MyFollow> findFollowPolicy(int pageNum, int pageSize,
			String account);

}
