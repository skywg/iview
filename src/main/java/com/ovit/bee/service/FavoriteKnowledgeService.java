package com.ovit.bee.service;

import com.ovit.bee.pojo.FavoriteKnowledge;

public interface FavoriteKnowledgeService {
	int insert(FavoriteKnowledge record);
	
	FavoriteKnowledge selectByAccount(String account);
}
