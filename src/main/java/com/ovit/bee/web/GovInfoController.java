package com.ovit.bee.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.GovInfo;
import com.ovit.bee.pojo.LoginUser;
import com.ovit.bee.service.GovInfoService;

@Controller
@RequestMapping("/govInfo")
public class GovInfoController {
	@Autowired
	private GovInfoService govInfoService;
	
	@RequestMapping("/")
	@ResponseBody
	public PageInfo<GovInfo> show(){
		PageInfo<GovInfo> list=govInfoService.query(0, 5);
		return list;
	}
	
	/**
	 * 机关展示
	 * @return
	 */
	@RequestMapping("/find/{page}")
	@ResponseBody
	public PageInfo<GovInfo> showExp(@PathVariable String page,HttpServletRequest request){
		int currentPage = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(page);
		int pageSize  = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(request.getParameter("pageSize"));
		PageInfo<GovInfo> list=govInfoService.query(currentPage, pageSize);
		return list;
	}
	
	@RequestMapping(value = "/saveGov", method = RequestMethod.POST)
	@ResponseBody
	public Object saveCorp(@RequestBody Map<String, Object> params,HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		GovInfo govInfo = new GovInfo();
		govInfo.setLoginAccount(loginUser.getLoginAccount());
		govInfo.setGovName(params.get("gov_name").toString());
		govInfo.setAddress(params.get("address").toString());
		govInfo.setLegalPerson(params.get("legal_person").toString());
		govInfo.setGovCode(params.get("gov_code").toString());
		govInfo.setOrganizationCode(params.get("organization_code").toString());
		try {
			govInfoService.insert(govInfo);
			map.put("flag", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	} 
}