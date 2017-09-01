package com.ovit.bee.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ovit.bee.pojo.Friend;
import com.ovit.bee.service.FriendService;

@Controller
@RequestMapping("/friends")
public class FriendController {
	@Autowired
	private FriendService friendService;
	
	
	@ResponseBody
	@RequestMapping("/")
	public List<Friend> findFriends(){
		return friendService.findAll();
	}
}
