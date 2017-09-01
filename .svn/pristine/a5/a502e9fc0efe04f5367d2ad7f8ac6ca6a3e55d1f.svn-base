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

import com.ovit.bee.pojo.ContactInfo;
import com.ovit.bee.pojo.LoginUser;
import com.ovit.bee.pojo.UserFullInfo;
import com.ovit.bee.service.ContactInfoService;
import com.ovit.bee.service.UserFullInfoService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/contactInfo")
public class ContactInfoController {
	
	@Autowired
	private ContactInfoService contactInfoService;
	
	@Autowired
	private UserFullInfoService userFullInfoService;
	
	/**
	 * 查询联系方式
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findContactInfo", method = RequestMethod.GET)
	@ResponseBody
	public ContactInfo findContactInfo(HttpServletRequest request){
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setUserAccount(loginUser.getLoginAccount());
		ContactInfo info  = contactInfoService.findContactInfo(contactInfo);
		return info;
	}
	
	/**
	 * 修改联系方式
	 * @param params
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateContactInfo", method = RequestMethod.POST)
	@ResponseBody
	public Object updateContactInfo(@RequestBody Map<String, Object> params,HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		ContactInfo contactInfo = new ContactInfo();
		try {
			contactInfo.setUserAccount(loginUser.getLoginAccount());
			contactInfo.setMobile(params.get("mobile").toString());
			contactInfo.setPhone(params.get("phone").toString());
			contactInfo.setQq(params.get("qq").toString());
			contactInfo.setPostcode(params.get("postcode").toString());
			contactInfo.setEmail(params.get("email").toString());
			contactInfo.setLocation(params.get("location").toString());
			contactInfo.setAddress(params.get("address").toString());
			contactInfo.setPosition(params.get("position").toString());
			UserFullInfo userFullInfo = new UserFullInfo();
			userFullInfo.setAccount(loginUser.getLoginAccount());
			userFullInfo.setContract(params.get("contactInfoContent").toString());
			userFullInfoService.updateUserFullInfo(userFullInfo);
			contactInfoService.updateContactInfo(contactInfo);
			map.put("flag", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  map;
	}
}
