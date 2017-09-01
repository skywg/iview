package com.ovit.bee.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.LoginUser;

public interface LoginUserService {
	PageInfo<LoginUser> query(int pageNum, int pageSize,String loginName);
	
	PageInfo<LoginUser> query(int pageNum, int pageSize);
	
    void deleteByPrimaryKey(Integer id);

    void insert(LoginUser record) ;

    LoginUser selectByPrimaryKey(Integer id);
    
    List<Map<String, Object>> findModeratorById(int id);
    
    LoginUser findByLoginName(String loginName);
    
    List<LoginUser> findFriendByLoginName(String loginName);
    
    List<LoginUser> findAll();

    void updateByPrimaryKey(LoginUser record);
    
    LoginUser login(String username,String pwd);

    LoginUser findTourNumber();
}