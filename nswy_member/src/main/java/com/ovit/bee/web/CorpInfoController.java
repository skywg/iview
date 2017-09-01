package com.ovit.bee.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.CorpInfo;
import com.ovit.bee.pojo.LoginUser;
import com.ovit.bee.service.CorpInfoService;

@RestController
@RequestMapping("/corpInfo")
public class CorpInfoController{
	@Autowired
	private CorpInfoService corpInfoService;
	
	@ResponseBody
	@RequestMapping("/find/{id}")
	public CorpInfo findById(@PathVariable int id){
		CorpInfo cInfo=corpInfoService.selectByPrimaryKey(id);
		System.out.println(cInfo.getCorpName());
		return cInfo;
	}
	
	@RequestMapping("/")
	@ResponseBody
	public PageInfo<CorpInfo> findById(){
		PageInfo<CorpInfo> list=corpInfoService.query(0, 5);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/findPage/{page}")
	public PageInfo<CorpInfo> find(@PathVariable String page,HttpServletRequest request){
		int currentPage = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(page);
		int pageSize  = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(request.getParameter("pageSize"));
		PageInfo<CorpInfo> cInfos=corpInfoService.query(currentPage, pageSize);
		return cInfos;
	}
	
	
	@RequestMapping(value = "/saveCorp", method = RequestMethod.POST)
	@ResponseBody
	public Object saveCorp(@RequestBody Map<String, Object> params,HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		CorpInfo corpInfo = new CorpInfo();
		corpInfo.setLoginAccount(loginUser.getLoginAccount());
		corpInfo.setCorpName(params.get("corp_name").toString());
		corpInfo.setBusinessScope(params.get("business_scope").toString());
		corpInfo.setLegalPerson(params.get("legal_person").toString());
		corpInfo.setCorpCode(params.get("corp_code").toString());
		corpInfo.setCreditCode(params.get("credit_code").toString());
		corpInfo.setOperator(params.get("operator").toString());
		corpInfo.setPhone(params.get("phone").toString());
		corpInfo.setEmail(params.get("email").toString());
		corpInfo.setIdentificationCard(params.get("identification_card").toString());
		try {
			corpInfoService.insert(corpInfo);
			map.put("flag", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	} 
}
