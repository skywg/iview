package com.ovit.bee.service;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.BrowseLog;

public interface BrowseLogService {

	public PageInfo<BrowseLog> findBrowseLog(int pageNum, int pageSize, BrowseLog info);

	public void insertBrowseLog(BrowseLog info);

}
