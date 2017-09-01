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
import com.ovit.bee.pojo.UserCertification;
import com.ovit.bee.service.UserCertificationService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/userCertification")
public class UserCertificationController {
	
	@Autowired
	private UserCertificationService userCertificationService;
	
	@RequestMapping(value = "/findUserCertification", method = RequestMethod.GET)
	@ResponseBody
	public Object findUserCertification(HttpServletRequest request){
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		if(null == loginUser){
			return null;
		}
		UserCertification user = new UserCertification();
		user.setAccount(loginUser.getLoginAccount());
		return userCertificationService.findUserCertification(user);
	}
	
	/**
	 * 修改教育经历
	 * @param params
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateUserCertification", method = RequestMethod.POST)
	@ResponseBody
	public Object updateUserCertification(@RequestBody Map<String, Object> params,HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		if(null == loginUser){
			return null;
		}
		UserCertification userCertification = new UserCertification();
		try {
			userCertification.setAccount(loginUser.getLoginAccount());
			userCertification.setSex(params.get("sex").toString());
			userCertification.setProfession(params.get("profession").toString());
			userCertification.setField(params.get("field").toString());
			userCertification.setTitle(params.get("title").toString());
			/*userCertification.setStatus(Integer.valueOf(params.get("title").toString()));*/
/*			UserFullInfo userFullInfo = new UserFullInfo();
			userFullInfo.setAccount(loginUser.getLoginAccount());
			userFullInfo.setEducation(params.get("userEducaitonContent").toString());
			userFullInfoService.updateUserFullInfo(userFullInfo)*/;
			userCertificationService.updateUserCertificaiton(userCertification);
			map.put("flag", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  map;
	}
}
