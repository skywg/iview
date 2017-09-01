package com.ovit.bee.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.CorpInfo;

public interface CorpInfoService {
    int deleteByPrimaryKey(Integer id);

    void insert(CorpInfo record);

    CorpInfo selectByPrimaryKey(Integer id);
    
    List<CorpInfo> findAll();
    
    PageInfo<CorpInfo> query(int PageNum,int PageSize);

    int updateByPrimaryKey(CorpInfo record);
}