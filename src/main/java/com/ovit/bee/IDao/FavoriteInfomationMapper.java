package com.ovit.bee.IDao;

import com.ovit.bee.pojo.FavoriteInfomation;

public interface FavoriteInfomationMapper {
   
    int insert(FavoriteInfomation record);

    FavoriteInfomation selectByAccount(String account);

  

   
}