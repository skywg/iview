package com.ovit.bee.IDao;

import com.ovit.bee.pojo.SignIn;

public interface SignInMapper {
    int deleteByPrimaryKey(int id);

    int insert(SignIn record);

    SignIn selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(SignIn record);

    int updateByPrimaryKey(SignIn record);
    
    int findCountSignIn(String userId);
}