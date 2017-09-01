package com.ovit.bee.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ovit.bee.pojo.LoginUser;
import com.ovit.bee.pojo.UserFarmInfo;
import com.ovit.bee.pojo.UserFullInfo;
import com.ovit.bee.service.UserFarmInfoService;
import com.ovit.bee.service.UserFullInfoService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/userFarmInfo")
public class UserFarmInfoController {
	
	@Autowired
	private UserFarmInfoService userFarmInfoService;
	
	@Autowired
	private UserFullInfoService userFullInfoService;
	
	@RequestMapping(value = "/findUserFarmInfo", method = RequestMethod.GET)
	@ResponseBody
	public Object findUserFarmInfo(HttpServletRequest request){
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		UserFarmInfo userFarmInfo = new UserFarmInfo();
		userFarmInfo.setAccount(loginUser.getLoginAccount());
		return userFarmInfoService.findUserFarmInfo(userFarmInfo);
	}
	
	/**
	 * 修改种养情况
	 * @param params
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateUserFarmInfo", method = RequestMethod.POST)
	@ResponseBody
	public Object updateUserFarmInfo(@RequestBody Map<String, Object> params,HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		UserFarmInfo userFarmInfo = new UserFarmInfo();
		try {
			userFarmInfo.setAccount(loginUser.getLoginAccount());
			userFarmInfo.setFarmlan(params.get("farmlan").toString());
			userFarmInfo.setSpecies(params.get("species").toString());
			userFarmInfoService.updateUserFarmInfo(userFarmInfo);
			UserFullInfo userFullInfo = new UserFullInfo();
			userFullInfo.setAccount(loginUser.getLoginAccount());
			userFullInfo.setFarmlan(params.get("userFarmInfoContent").toString());
			userFullInfoService.updateUserFullInfo(userFullInfo);
			map.put("flag", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  map;
	}
}
