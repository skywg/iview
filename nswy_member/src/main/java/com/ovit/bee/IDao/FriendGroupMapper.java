package com.ovit.bee.IDao;

import java.util.List;

import com.ovit.bee.pojo.FriendGroup;

public interface FriendGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(List<FriendGroup> record);


    FriendGroup selectByPrimaryKey(Integer id);


    int updateByPrimaryKey(FriendGroup record);
}