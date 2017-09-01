package com.ovit.bee.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.ovit.bee.service.UserFullInfoService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/userFullInfo")
public class UserFullInfoController {
	
	@Autowired
	private UserFullInfoService userFullInfoService;
	
	@RequestMapping(value = "/findUserFullInfo", method = RequestMethod.GET)
	@ResponseBody
	public Object findUserFullInfo(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		UserFullInfo userFullInfo = new UserFullInfo();
		try {
			String account = loginUser.getLoginAccount();
			if (account != null) {
				userFullInfo.setAccount(account);
			}
		} catch (Exception e) {

		}
		UserFullInfo user = userFullInfoService.findUserFullInfo(userFullInfo);
		if (user != null) {
			map.put("userFullInfo", user);
			return map;
		} else {
			map.put("userFullInfo", null);
			return map;
		}
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public int insertFullInfo(@RequestBody Map<String, Object> params,HttpServletRequest request) throws Exception{
		String edu=null;
		String edu1=null;
		String work=null;
		String work1=null;
		String plant=null;
		String plant1=null;
		String  honor=null;
		String honor1=null;
		String content=(String)params.get("content");
		String content1=(String)params.get("con");
		String contract=(String)params.get("contract");
		String contract1=(String)params.get("contract1");
		String political1=(String)params.get("political1");
		String political=(String)params.get("political");
		String religion=(String)params.get("religion");
		String religion1=(String)params.get("religion1");
		Object obj = params.get("education");
		if (obj != null) {
			ArrayList<Map<String, String>> education = (ArrayList<Map<String, String>>) obj;
			if (education != null & education.size() != 0) {
				for (int i = 0; i < education.size(); i++) {
					Map<String, String> m = education.get(i);
					if (i == 0) {
						edu = m.get("content") + ";";
						edu1 = m.get("content1") + ";";
					} else {
						edu += m.get("content") + ";";
						edu1 += m.get("content1") + ";";
					}
				}
			}
		}
		Object obj1 = params.get("work");
		if (obj1 != null) {
			ArrayList<Map<String, String>> works = (ArrayList<Map<String, String>>) obj1;
			if (works != null & works.size() != 0) {
				for (int i = 0; i < works.size(); i++) {
					Map<String, String> m = works.get(i);
					if (i == 0) {
						work = m.get("content") + ";";
						work1 = m.get("content1") + ";";
					} else {
						work += m.get("content") + ";";
						work1 += m.get("content1") + ";";
					}
				}
			}
		}
		Object obj2 = params.get("plant");
		if (obj2 != null) {
			List<Map<String, String>> plants = (ArrayList<Map<String, String>>) obj2;
			if (plants != null & plants.size() != 0) {
				for (int i = 0; i < plants.size(); i++) {
					Map<String, String> m = plants.get(i);
					if (i == 0) {
						plant = m.get("content") + ";";
						plant1 = m.get("content1") + ";";
					} else {
						plant += m.get("content") + ";";
						plant1 += m.get("content1") + ";";
					}
				}
			}
		}
		Object obj3=params.get("honor");
		if(obj3!=null){
			ArrayList<Map<String, String>> honors=(ArrayList<Map<String, String>>)obj3;
			if(honors!=null&honors.size()!=0){
				for(int i=0;i<honors.size();i++){
					Map<String, String> m=honors.get(i);
					if(i==0){
						honor=m.get("content")+";";
						honor1=m.get("content1")+";";
					}else{
						honor+=m.get("content")+";";
						honor1+=m.get("content1")+";";
					}
				}
			}
		}
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		UserFullInfo userFullInfo = new UserFullInfo();
		int num = 0;
		try {
			String account = loginUser.getLoginAccount();
			userFullInfo.setAccount(account);
			if (account != null) {
				UserFullInfo user = userFullInfoService.findUserFullInfo(userFullInfo);
				if (user != null) {
					user.setBasic(content);
					user.setBasic1(content1);
					user.setContract(contract);
					user.setContract1(contract1);
					user.setEducation(edu);
					user.setEducation1(edu1);
					user.setWork(work);
					user.setWork1(work1);
					user.setFarmlan(plant);
					user.setFarmlan1(plant1);
					user.setHonor(honor);
					user.setHonor1(honor1);
					user.setPolicial(political);
					user.setPolicial1(political1);
					user.setReligion(religion);
					user.setReligion1(religion1);
					num=userFullInfoService.updateUserFullInfo(user);
				}else{
					UserFullInfo newuser=new UserFullInfo();
					newuser.setAccount(account);
					if(content!=null){
						newuser.setBasic(content);
					}
					if(content1!=null){
						newuser.setBasic1(content1);
					}
					if(contract!=null){
						newuser.setContract(contract);
					}
					if(contract1!=null){
						newuser.setContract1(contract1);
					}
					if(edu!=null){
						newuser.setEducation(edu);
					}
					if(edu1!=null){
						newuser.setEducation(edu1);
					}
					if(work!=null){
						newuser.setWork(work);
					}
					if(work1!=null){
						newuser.setWork1(work1);
					}
					if(plant!=null){
						newuser.setFarmlan(plant);
					}
					if(plant1!=null){
						newuser.setFarmlan1(plant1);
					}
					if(honor!=null){
						newuser.setHonor(honor);
					}
					if(honor1!=null){
						newuser.setHonor1(honor1);
					}
					if(political!=null){
						newuser.setPolicial(political);
					}
					if(political1!=null){
						newuser.setPolicial1(political1);
					}
					if(religion!=null){
						newuser.setReligion(religion);
					}
					if(religion1!=null){
						newuser.setReligion(religion1);
					}
					num=userFullInfoService.insert(newuser);
				}
			}
		}catch(Exception e){
			
		}
		return num;
	}
}
