package com.ovit.bee.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.CoterieArticleComment;

public interface CoterieArticleCommentService {
		List<CoterieArticleComment> findAll();
		
		PageInfo<CoterieArticleComment> query(int PageNum,int PageSize);
		
}
