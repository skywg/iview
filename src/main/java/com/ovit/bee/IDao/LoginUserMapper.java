package com.ovit.bee.IDao;

import java.util.List;
import java.util.Map;

import com.ovit.bee.pojo.LoginUser;

public interface LoginUserMapper {

    void deleteByPrimaryKey(Integer id);

    int insert(LoginUser record);
    
    List<LoginUser> findAll();
    
    List<Map<String, Object>> findModeratorById(int id);
    
    LoginUser selectByPrimaryKey(Integer id);
    
    LoginUser findByLoginName(String loginName);
    
    List<LoginUser> findFriendByLoginName(String loginName);
    
    int updateByPrimaryKey(LoginUser record);
    
    LoginUser findTourNumber(String userId);

	LoginUser login(Map<String,Object> map);
}