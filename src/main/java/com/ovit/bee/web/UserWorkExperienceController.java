package com.ovit.bee.web;

import java.text.SimpleDateFormat;
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
import com.ovit.bee.pojo.UserFullInfo;
import com.ovit.bee.pojo.UserWorkExperience;
import com.ovit.bee.service.UserFullInfoService;
import com.ovit.bee.service.UserWorkExperienceService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/userWork")
public class UserWorkExperienceController {
	
	@Autowired
	private UserWorkExperienceService userWorkExperienceService;
	
	@Autowired
	private UserFullInfoService userFullInfoService;
	
	/**
	 * 查询联系方式
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findUserWork", method = RequestMethod.GET)
	@ResponseBody
	public UserWorkExperience findUserWork(HttpServletRequest request){
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		UserWorkExperience userWorkExperience = new UserWorkExperience();
		userWorkExperience.setAccount(loginUser.getLoginAccount());
		UserWorkExperience info  = userWorkExperienceService.findUserWork(userWorkExperience);
		return info;
	}
	
	/**
	 * 修改工作经历
	 * @param params
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateUserWork", method = RequestMethod.POST)
	@ResponseBody
	public Object updateUserWork(@RequestBody Map<String, Object> params,HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		UserWorkExperience userWork = new UserWorkExperience();
		try {
			userWork.setAccount(loginUser.getLoginAccount());
			userWork.setOrganazationName(params.get("organazationName").toString());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			userWork.setStartDate(sdf.parse(params.get("startDate").toString()));
			userWork.setEndDate(sdf.parse(params.get("endDate").toString()));
			userWork.setContent(params.get("content").toString());
			UserFullInfo userFullInfo = new UserFullInfo();
			userFullInfo.setAccount(loginUser.getLoginAccount());
			userFullInfo.setWork(params.get("userWorkContent").toString());
			userFullInfoService.updateUserFullInfo(userFullInfo);
			userWorkExperienceService.updateUserWork(userWork);
			map.put("flag", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  map;
	}
}
