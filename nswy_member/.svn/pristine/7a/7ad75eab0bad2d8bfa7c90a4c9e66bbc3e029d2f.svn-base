package com.ovit.bee.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ovit.bee.IDao.LoginUserMapper;
import com.ovit.bee.pojo.LoginUser;
import com.ovit.bee.service.LoginUserService;

@Service
public class LoginUserServiceImpl implements LoginUserService {

	@Autowired
	private LoginUserMapper loginUserMapper;
	private Logger logger = Logger.getLogger(LoginUserServiceImpl.class);

	/*
	 * 
	 * 删除
	 */
	@Override
	public void deleteByPrimaryKey(Integer id) {
		loginUserMapper.deleteByPrimaryKey(id);
	}

	// 注册
	@Transactional
	@Override
	public void insert(LoginUser user)  {
			loginUserMapper.insert(user);
	}

	@Override
	public LoginUser selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return loginUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<LoginUser> findAll() {
		return loginUserMapper.findAll();
	}

	@Override
	public void updateByPrimaryKey(LoginUser record) {
		loginUserMapper.updateByPrimaryKey(record);

	}

	@Override
	public LoginUser findByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return loginUserMapper.findByLoginName(loginName);
	}

	/**
	 * 登录
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public LoginUser login(String username, String pwd) {
		logger.info("登录.....");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("login_account", username);
		map.put("login_passwd", pwd);
		LoginUser user = loginUserMapper.login(map);
		return user;
	}

	/**
	 * 退出登录
	 * 
	 * @throws Exception
	 *//*
		 * public void logout() throws Exception { IniSubject();
		 * 
		 * session.removeAttribute(Const.SESSION_USER);
		 * 
		 * currentUser.logout(); }
		 */

	@Override
	public LoginUser findTourNumber() {
		return  null;
	}

	@Override
	public List<LoginUser> findFriendByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return loginUserMapper.findFriendByLoginName(loginName);
	}

	@Override
	public PageInfo<LoginUser> query(int pageNum, int pageSize,String loginName) {
		PageHelper.startPage(pageNum, pageSize);
		List<LoginUser> list=loginUserMapper.findFriendByLoginName(loginName);
		return new PageInfo<LoginUser>(list);
	}

	@Override
	public PageInfo<LoginUser> query(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<LoginUser> list=loginUserMapper.findAll();
		return new PageInfo<LoginUser>(list);
	}

	@Override
	public List<Map<String, Object>> findModeratorById(int id) {
		return loginUserMapper.findModeratorById(id);
	}
}