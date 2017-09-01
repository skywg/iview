package com.ovit.bee.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ovit.bee.pojo.FriendGroup;
import com.ovit.bee.pojo.LoginUser;
import com.ovit.bee.service.FriendGroupService;

@Controller
@RequestMapping("/friendGroup")
public class FriendGroupController {
	
	@Autowired
	private FriendGroupService service;
	
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public int  insert(@RequestBody Map<String, Object> params,HttpServletRequest request){
		HttpSession session=request.getSession();
		LoginUser loginUser = (LoginUser) session.getAttribute("currentUser");
		List<FriendGroup> list=new ArrayList<>();
		String username=loginUser.getLoginAccount();
			List<HashMap<String, String>>  object=(ArrayList) params.get("friend");
			int num=0;
			if(object.size()!=0){
				for(int i=0;i<object.size();i++){
					Map<String, String> map=object.get(i);
					FriendGroup friendGroup=new FriendGroup();
					friendGroup.setGroupName(map.get("name"));
					friendGroup.setLoginAccount(username);
					list.add(friendGroup);
				}
				num=service.insert(list);
			}
		return num;
	}
}