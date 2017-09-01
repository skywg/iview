package com.ovit.bee.IDao;

import com.ovit.bee.pojo.FavoriteService;

public interface FavoriteServiceMapper {
    
    int insert(FavoriteService record);

    

    FavoriteService selectByPrimaryKey(Integer id);

    

    int updateByPrimaryKey(FavoriteService record);
}