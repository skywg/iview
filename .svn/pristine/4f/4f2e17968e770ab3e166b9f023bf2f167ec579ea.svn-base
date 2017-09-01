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
import com.ovit.bee.pojo.UserEducationExperience;
import com.ovit.bee.pojo.UserFullInfo;
import com.ovit.bee.service.UserEducationExperienceService;
import com.ovit.bee.service.UserFullInfoService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/userEducation")
public class UserEducationExperienceController {
	
	@Autowired
	private UserEducationExperienceService userEducationExperienceService;
	
	@Autowired
	private UserFullInfoService userFullInfoService;
	
	@RequestMapping(value = "/findUserEducation", method = RequestMethod.GET)
	@ResponseBody
	public UserEducationExperience findUserEducation(HttpServletRequest request) throws Exception{
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		UserEducationExperience userEducationExperience = new UserEducationExperience();
		userEducationExperience.setAccount(loginUser.getLoginAccount());
		UserEducationExperience user = userEducationExperienceService.findUserEducation(userEducationExperience);
		return user;
	}
	
	/**
	 * 修改教育经历
	 * @param params
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateUserEducation", method = RequestMethod.POST)
	@ResponseBody
	public Object updateUserEducation(@RequestBody Map<String, Object> params,HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		UserEducationExperience userEducationExperience = new UserEducationExperience();
		try {
			userEducationExperience.setAccount(loginUser.getLoginAccount());
			userEducationExperience.setShcoolName(params.get("shcoolName").toString());
			userEducationExperience.setProfession(params.get("profession").toString());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			userEducationExperience.setEntranceDate(sdf.parse(params.get("entranceDate").toString()));
			userEducationExperience.setGraduationDate(sdf.parse(params.get("graduationDate").toString()));
			userEducationExperience.setStatus(Integer.valueOf(params.get("status").toString()));
			userEducationExperience.setDegree(params.get("degree").toString());
			UserFullInfo userFullInfo = new UserFullInfo();
			userFullInfo.setAccount(loginUser.getLoginAccount());
			userFullInfo.setEducation(params.get("userEducaitonContent").toString());
			userFullInfoService.updateUserFullInfo(userFullInfo);
			userEducationExperienceService.updateUserEducation(userEducationExperience);
			map.put("flag", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  map;
	}
}
