package com.ovit.bee.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.InForMationDetail;
import com.ovit.bee.pojo.PolicyComment;
import com.ovit.bee.pojo.LoginUser;
import com.ovit.bee.pojo.Policy;
import com.ovit.bee.pojo.PolicyDetail;
import com.ovit.bee.service.PolicyService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/policy")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	/**
	 * 政策查询分页
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findPolicy/{page}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findPolicy(@PathVariable String page,HttpServletRequest request) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		int currentPage = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(page);
		int pageSize  = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(request.getParameter("pageSize"));
		PageInfo<Policy> lists =  policyService.findPolicy(currentPage, pageSize);
		List<Policy> list = lists.getList();
		for(Policy info:list){
			long newTime = (new Date().getTime())-(info.getCreateTime().getTime());
			long minutes = newTime/(1000* 60); 
			long createTime=0; 
			if(minutes<60){
				createTime=minutes;
				info.setDay(String.valueOf(createTime)+"分钟");
			}else{
				createTime = minutes/60;
				if((minutes/60)<24){
					info.setDay(String.valueOf(createTime)+"小时");
				}else{
					createTime= createTime/24;
					info.setDay(String.valueOf(createTime)+"天");
					
				}
			}
		}
		lists.setList(list);
		map.put("list", lists);
		return map;
	}
	
	/**
	 * 根据ID查询详细信息
	 * @param id
	 */
	@RequestMapping(value = "/findPolicyDetail", method = RequestMethod.GET)
	@ResponseBody
	public PolicyDetail findPolicyDetail(HttpServletRequest request){
		String id  = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			PolicyDetail policyDetail= policyService.findPolicyDetail(id);
			
			return policyDetail;
		}
		return null;
		
	}
	
	/**
	 * 搜索查询分页
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findPolicyTitle/{page}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findPolicyTitle(@PathVariable String page,HttpServletRequest request) throws Exception{
		String title  = request.getParameter("title");
		Map<String,Object> map = new HashMap<String, Object>();
		int currentPage = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(page);
		int pageSize  = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(request.getParameter("pageSize"));
		PageInfo<Policy> lists = policyService.findPolicyTitle(currentPage, title,pageSize);
		List<Policy> list = lists.getList();
		for(Policy info:list){
			long newTime = (new Date().getTime())-(info.getCreateTime().getTime());
			long minutes = newTime/(1000* 60); 
			long createTime=0; 
			if(minutes<60){
				createTime=minutes;
				info.setDay(String.valueOf(createTime)+"分钟");
			}else{
				createTime = minutes/60;
				if((minutes/60)<24){
					info.setDay(String.valueOf(createTime)+"小时");
				}else{
					createTime= createTime/24;
					info.setDay(String.valueOf(createTime)+"天");
					
				}
			}
		}
		lists.setList(list);
		map.put("list", lists);
		map.put("title", title);
		return map;
		
	}
	
	@RequestMapping(value="/findPolicyComment/{page}" , method = RequestMethod.GET)
	@ResponseBody
	public Object findPolicyComment(@PathVariable String page,HttpServletRequest request){
		Integer id = Integer.valueOf(request.getParameter("id")); 
		Map<String,Object> map = new HashMap<String, Object>();
		if(!StringUtils.isEmpty(id)){
			int currentPage = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(page);
			int pageSize  = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(request.getParameter("pageSize"));
			PageInfo<PolicyComment> list = policyService.findPolicyComment(currentPage, pageSize, id);
			Integer tote  = policyService.findPolicyCommentCount(id);
			map.put("list", list);
			map.put("tote", tote);
			return map;
		}
		return null;
	}
	
	@RequestMapping(value="/findMyComment/{page}" , method = RequestMethod.GET)
	@ResponseBody
	public Object findMyComment(@PathVariable String page,HttpServletRequest request){
		Integer id = Integer.valueOf(request.getParameter("id"));
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		if(loginUser==null){
			return null;
		}
		PolicyComment report = new PolicyComment();
		report.setUserAccount(loginUser.getLoginAccount());
		report.setInformationDetailId(id);
		Map<String,Object> map = new HashMap<String, Object>();
		if(!StringUtils.isEmpty(id)){
			int currentPage = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(page);
			int pageSize  = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(request.getParameter("pageSize"));
			List<PolicyComment> list = policyService.findMyComment(currentPage, pageSize, report);
			map.put("myComment", list);
			return map;
		}
		return null;
	}
	
	/**
	 * 点赞
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveZan", method = RequestMethod.GET)
	@ResponseBody
	public Object saveZan(HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		PolicyComment report = new PolicyComment();
		Integer id = Integer.valueOf(request.getParameter("id").toString());
		report.setId(id);
		try {
			PolicyComment policyComment  = policyService.update(report);
			map.put("flag", "1");
			map.put("thumbUpNum",policyComment.getThumbUpNum().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	/**
	 * 回复
	 * @param params
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveHuiFu", method = RequestMethod.POST)
	@ResponseBody
	public Object saveHuiFu(@RequestBody Map<String, Object> params,HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		PolicyComment report = new PolicyComment();
		report.setPostId(Integer.valueOf(params.get("postId").toString()));
		report.setInformationDetailId(Integer.valueOf(params.get("informationDetailId").toString()));
		report.setContent(params.get("content").toString());
		report.setUserAccount(loginUser.getLoginAccount());
		report.setUserName(loginUser.getDisplayName());
		report.setThumbUpNum(0);
		try {
			policyService.insert(report);
			map.put("flag", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	@RequestMapping(value = "/upvote", method = RequestMethod.GET)
	@ResponseBody
	public Object upvote(HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		
		Integer id = Integer.valueOf(request.getParameter("id").toString());
		try {
			PolicyDetail policyDetail  = policyService.upvote(id);
			map.put("flag", "1");
			map.put("number",policyDetail.getThumbUpNum().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	

	@RequestMapping(value="/findIndexPolicy/{page}" , method = RequestMethod.GET)
	@ResponseBody
	public Object findIndexPolicy(@PathVariable String page,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		int currentPage = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(page);
		int pageSize  = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(request.getParameter("pageSize"));
		//政策法规
		PageInfo<Policy>  regulations = policyService.findIndexPolicy(currentPage, pageSize, "030201");
		//政策解读
		PageInfo<Policy>  interpretation = policyService.findIndexPolicy(currentPage, pageSize, "030202");
		//通知公告
		PageInfo<Policy>  notice = policyService.findIndexPolicy(currentPage, pageSize, "030203");
		map.put("regulations", regulations);
		map.put("interpretation", interpretation);
		map.put("notice", notice);
		return map;
	}
	
	
	
}
