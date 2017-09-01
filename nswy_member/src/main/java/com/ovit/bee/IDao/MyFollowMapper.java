package com.ovit.bee.IDao;

import java.util.List;

import com.ovit.bee.pojo.MyFollow;

public interface MyFollowMapper {
 

    int insertMyFollow(MyFollow record);

    List<MyFollow> findMyFollow(MyFollow record);
    
    List<MyFollow> findFollowInforMation(String account);
    
    List<MyFollow> findFollowKnowLedge(String account);
    
    List<MyFollow> findFollowPolicy(String account);

    int updateMyFollow(MyFollow record);

  
}