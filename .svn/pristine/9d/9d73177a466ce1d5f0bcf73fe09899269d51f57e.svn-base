package com.ovit.bee.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ovit.bee.pojo.LoginUser;
import com.ovit.bee.service.SearchService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/search")
public class SearchController {

	@Autowired 
	private SearchService searchService;
	
	@RequestMapping(value = "/findSearch", method = RequestMethod.GET)
	@ResponseBody
	public Object findSearch(HttpServletRequest request){
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		Map<String,Object> map = new HashMap<String, Object>();
		return null;
	}
}
