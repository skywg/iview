package com.ovit.bee.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.ovit.bee.entity.system.User;



public class shiroUtil {
	
	private static Subject getSubject() {
		return SecurityUtils.getSubject();
	}
	
	private static Session getSession() {
		return getSubject().getSession();
	}
	
	public static boolean isAuthenticated() {
		return getSubject().isAuthenticated();
	}
	
	public static User getUser() {
		return (User) getSession().getAttribute(Const.SESSION_USER);
	}
}
