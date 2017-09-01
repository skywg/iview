package com.ovit.bee.IDao;

import com.ovit.bee.pojo.JuBao;

public interface JuBaoMapper {
    int deleteByPrimaryKey(Integer id);

    void insert(JuBao record);

    int insertSelective(JuBao record);

    JuBao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JuBao record);

    int updateByPrimaryKey(JuBao record);
}