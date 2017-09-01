package com.ovit.bee.IDao;

import com.ovit.bee.pojo.UserFarmInfo;

public interface UserFarmInfoMapper {
    
    void insert(UserFarmInfo record);
    
    UserFarmInfo findUserFarmInfo(UserFarmInfo record);

    void updateUserFarmInfo(UserFarmInfo record);
}