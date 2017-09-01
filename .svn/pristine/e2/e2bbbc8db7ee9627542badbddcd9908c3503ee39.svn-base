package com.ovit.bee.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ovit.bee.pojo.BankAccount;
import com.ovit.bee.pojo.LoginUser;
import com.ovit.bee.pojo.MyApp;
import com.ovit.bee.service.BankAccountService;
import com.ovit.bee.service.MyAppService;

@Controller
@RequestMapping("/bank")
public class BankAccountController {
	@Autowired
	private BankAccountService bankAccountService;
	
	@Autowired
	private MyAppService myAppService;
	
	@ResponseBody
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public Integer insert(@RequestBody Map<String, Object> params,HttpServletRequest request){
		String name=(String)params.get("name");
		String idcard=(String)params.get("idcard");
		String bank=(String)params.get("bank");
		String phone=(String)params.get("phone");
		BankAccount bank1=new BankAccount();
		BankAccount bank2=new BankAccount();
		int num=0;
		try{
			LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
			String account=loginUser.getLoginAccount();
			if(null!=account){
				bank1=bankAccountService.selectByAccount(account);
				if(bank1!=null){
					bank1.setBankaccount(bank);
					bank1.setCreateTime(new Date());
					bank1.setIdcard(idcard);
					bank1.setPhone(phone);
					bank1.setRealname(name);
					num=bankAccountService.insert(bank1);
				}else{
					bank2.setBankaccount(bank);
					bank2.setCreateTime(new Date());
					bank2.setIdcard(idcard);
					bank2.setPhone(phone);
					bank2.setRealname(name);
					bank2.setAccount(account);
					num=bankAccountService.insert(bank2);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	/**
	 * 支付密码设置
	 * 
	 * @param params
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/password",method=RequestMethod.POST)
	public Integer password(@RequestBody Map<String, Object> params,HttpServletRequest request){
		String pwd=(String)params.get("pwd");
		String secpwd=(String)params.get("secpwd");
		BankAccount bank1=new BankAccount();
		BankAccount bank2=new BankAccount();
		int num=0;
		if(null!=pwd&null!=secpwd){
			if(!pwd.equals(secpwd)){
				num=1;
			}else{
				try{
					LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
					String account=loginUser.getLoginAccount();
					if(null!=account){
						bank1=bankAccountService.selectByAccount(account);
						if(bank1!=null){
							bank1.setCreateTime(new Date());
							bank1.setPassword(pwd);
							num=bankAccountService.insert(bank1);
						}else{
							bank2.setCreateTime(new Date());
							bank2.setPassword(pwd);
							bank2.setAccount(account);
							num=bankAccountService.insert(bank2);
						}
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return num;
	}
	
	/**
	 * 应用设置
	 * @param params
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/setapp",method=RequestMethod.POST)
	public Integer setApp(@RequestBody Map<String, Object> params,HttpServletRequest request){
		List<String> appname = (ArrayList) params.get("appname");
		int level = (Integer) params.get("level");
		MyApp app = new MyApp();
		MyApp app1 = new MyApp();
		List<String> result = new ArrayList<>();
		List<String> name = new ArrayList<>();
		int num = 0;
		try {
			if (appname.size()!=0) {
				List<MyApp> list = myAppService.selectByLevel(level);
				if (list.size() != 0) {
					for (MyApp m : list) {
						name.add(m.getAppid());
					}
					
					result = listToStr(appname, name);
					
				} else {
					result = appname;
				}
			}
			LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
			String account = loginUser.getLoginAccount();
			if (null != account) {
				List<MyApp> myApps = new ArrayList<>();
				for (String s : result) {
					MyApp app2 = new MyApp();
					app2.setAppid(s);
					app2.setCreateTime(new Date());
					app2.setLevel(level);
					app2.setAccount(account);
					myApps.add(app2);
				}
				num = myAppService.insert(myApps);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	public static List<String> listToStr(List<String> list,List<String> list1){
		Set<String> set=new HashSet<String>(); 
		set.addAll(list);
		Set<String> set1=new HashSet<String>(); 
		set1.addAll(list1);
		set.removeAll(set1);
		List<String> result=new ArrayList<>();
		result.addAll(set);
		 return result;
	}
}
