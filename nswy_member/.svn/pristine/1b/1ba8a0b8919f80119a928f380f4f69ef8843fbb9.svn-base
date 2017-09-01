package com.ovit.bee.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.InForMation;
import com.ovit.bee.pojo.InForMationDetail;
import com.ovit.bee.pojo.InfoComment;

public interface InForMationService {

	public PageInfo<InForMation> findInForMation(int pageNum, int pageSize);

	public InForMationDetail findInForMationDetail(String id);

	public PageInfo<InForMation> findInforMationTitle(int pageNum, int pageSize,
			String title);

	public PageInfo<InfoComment> findInfoComment(int pageNum, int pageSize,Integer informationDetailId);

	public InfoComment update(InfoComment info);

	public void insert(InfoComment info);

	public Integer findInfoCommentCount(Integer informationDetailId);
	
	List<InForMation> find();

	public List<InfoComment> findMyComment(int pageNum, int pageSize, InfoComment info);

	public InForMationDetail upvote(Integer id);

	public void updateBrowse(Map<String, Object> map);
}
