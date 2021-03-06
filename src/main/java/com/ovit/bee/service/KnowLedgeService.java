package com.ovit.bee.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.Knowledge;
import com.ovit.bee.pojo.KnowledgeComment;
import com.ovit.bee.pojo.KnowledgeDetail;

public interface KnowLedgeService {

	public PageInfo<Knowledge> findKnowLedge(int pageNum, int pageSize);

	public KnowledgeDetail findKnowLedgeDetail(String id);

	public PageInfo<Knowledge> findKnowLedgeTitle(int pageNum, int pageSize,String title);

	public PageInfo<KnowledgeComment> findKnowledgeComment(int pageNum, int pageSize,
			Integer id);

	public Integer findKnowledgeCommentCount(Integer id);

	public List<KnowledgeComment> findMyComment(int pageNum, int pageSize,
			KnowledgeComment info);

	public KnowledgeComment update(KnowledgeComment info);

	public void insert(KnowledgeComment info);

	public KnowledgeDetail upvote(Integer id);
	
	List<Map<String, Object>> findShow();

}
