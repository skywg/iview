package com.ovit.bee.IDao;

import com.ovit.bee.pojo.ProxySetting;

public interface ProxySettingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProxySetting record);

    int insertSelective(ProxySetting record);

    ProxySetting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProxySetting record);

    int updateByPrimaryKey(ProxySetting record);
}