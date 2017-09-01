package com.ovit.bee.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.ovit.bee.service.MemberCenterService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/memberCenter")
public class MemberCenterController {
	@Autowired
	private MemberCenterService memberCenterService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public Object findIndex(HttpServletRequest request) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		Date date=new Date();
		Date dBefore = new Date();
		Date dBefTwo = new Date();
		Date dBefThree = new Date();
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(date);//把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
		dBefore = calendar.getTime();   //得到前一天的时间
		calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
		dBefTwo= calendar.getTime();   //得到前一天的时间
		calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
		dBefThree= calendar.getTime();   //得到前一天的时间
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String dateOne  = sdf.format(dBefore);
		String dateTwo = sdf.format(dBefTwo);
		String dateThree = sdf.format(dBefThree);
		String weekOne = getWeek(dBefore);
		String weekTwo = getWeek(dBefTwo);
		String weekThree = getWeek(dBefThree);
		map.put("dateOne", dateOne);
		map.put("dateTwo", dateTwo);
		map.put("dateThree", dateThree);
		map.put("weekOne", weekOne);
		map.put("weekTwo", weekTwo);
		map.put("weekThree", weekThree);
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		if(null == loginUser){
			return map;
		}
		Integer favorite = memberCenterService.findMyMessage(loginUser.getLoginAccount());
		map.put("favorite", String.valueOf(favorite));
		map.put("number", String.valueOf(loginUser.getTourNumber()));
		map.put("signature", loginUser.getSignaTure());
		map.put("avatar", loginUser.getAvatar());
		map.put("displayName", loginUser.getDisplayName());
		Integer signNum = memberCenterService.findCountSignIn(loginUser.getLoginAccount());
		map.put("signNum", String.valueOf(signNum));
		return map;
	}
	
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	@ResponseBody
	public Object signIn(HttpServletRequest request) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		Integer count  = memberCenterService.insertSignIn(loginUser.getLoginAccount());
		map.put("count", String.valueOf(count));
		return map;
	}
	
	private static String getWeek(Date date){
		String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if(week_index<0){
			week_index = 0;
		} 
		return weeks[week_index];
	}
}