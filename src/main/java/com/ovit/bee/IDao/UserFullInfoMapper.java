package com.ovit.bee.IDao;

import com.ovit.bee.pojo.UserFullInfo;

public interface UserFullInfoMapper {
    UserFullInfo findUserFullInfo(UserFullInfo record);
    
    int updateUserFullInfo(UserFullInfo record);
    
    int  insert(UserFullInfo record);

}