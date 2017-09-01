package com.ovit.bee.IDao;

import java.util.List;

import com.ovit.bee.pojo.Friend;

public interface FriendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Friend record);

    List<Friend> findByName(String name);

    Friend selectByPrimaryKey(Integer id);

    List<Friend> findAll();

    int updateByPrimaryKey(Friend record);
}