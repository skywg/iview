package com.ovit.bee.IDao;

import java.util.List;

import com.ovit.bee.pojo.MyFriend;

public interface MyFriendMapper {

    void insert(MyFriend record);

    MyFriend selectByPrimaryKey(Integer id);
    
    List<MyFriend> findMyFriend(MyFriend record);

    void updateByPrimaryKey(MyFriend record);
}