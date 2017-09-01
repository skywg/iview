package com.ovit.bee.web;

import java.util.HashMap;
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
import com.ovit.bee.pojo.LoginUser;
import com.ovit.bee.pojo.MyDyNamic;
import com.ovit.bee.pojo.MyFollow;
import com.ovit.bee.pojo.MydynamicComment;
import com.ovit.bee.service.MydynamicService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/mydynamic")
public class MydynamicController {
	
	@Autowired
	private MydynamicService mydynamicService;
	
	@RequestMapping(value = "/findMydynamic/{page}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findMydynamic(@PathVariable String page,HttpServletRequest request) throws Exception{
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		Map<String,Object> map = new HashMap<String, Object>();
		int currentPage = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(page);
		int pageSize  = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(request.getParameter("pageSize"));
		PageInfo<MyDyNamic> list =  mydynamicService.findMyDyNamic(currentPage, pageSize,loginUser.getLoginAccount());
		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value = "/saveMydynamic", method = RequestMethod.POST)
	@ResponseBody
	public void saveMydynamic(@RequestBody Map<String, Object> params,HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		MyDyNamic myDynamic = new MyDyNamic();
		myDynamic.setAccount(loginUser.getLoginAccount());
		myDynamic.setTitle(params.get("title").toString());
		myDynamic.setType(params.get("type").toString());
		myDynamic.setCategory(params.get("category").toString());
		myDynamic.setSource(params.get("source").toString());
		myDynamic.setDistrict(params.get("district").toString());
		myDynamic.setGoodsname(params.get("goodsname").toString());
		myDynamic.setServicename(params.get("servicename").toString());
		myDynamic.setSpecies(params.get("species").toString());
		myDynamic.setSummary(params.get("summary").toString());
		myDynamic.setIndustry(params.get("industry").toString());
		myDynamic.setContent(params.get("content").toString());
		myDynamic.setLabel(params.get("label").toString());
		myDynamic.setSecurity(params.get("security").toString());
		try {
			mydynamicService.saveMyDyNamic(myDynamic);
			map.put("flag", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		Integer id = Integer.valueOf(request.getParameter("id").toString());
		try {
			MyDyNamic comment  = mydynamicService.updateMyDyNamic(id);
			map.put("flag", "1");
			map.put("thumbUpNum",comment.getThumbUpNum().toString());
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
		MydynamicComment report = new MydynamicComment();
		report.setAccount(loginUser.getLoginAccount());
		report.setDynamicId(Integer.valueOf(params.get("dynamicId").toString()));
		report.setComment(params.get("comment").toString());
		try {
			mydynamicService.saveMyDyNamicComment(report);
			map.put("flag", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value = "/findFollow/{page}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findFollow(@PathVariable String page,HttpServletRequest request) throws Exception{	
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		Map<String,Object> map = new HashMap<String, Object>();
		int currentPage = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(page);
		int pageSize  = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(request.getParameter("pageSize"));
		PageInfo<MyFollow> inforMation =  mydynamicService.findFollowInforMation(currentPage, pageSize,loginUser.getLoginAccount());
		PageInfo<MyFollow> knowLedge =  mydynamicService.findFollowKnowLedge(currentPage, pageSize,loginUser.getLoginAccount());
		PageInfo<MyFollow> policy =  mydynamicService.findFollowPolicy(currentPage, pageSize,loginUser.getLoginAccount());
		map.put("inforMation", inforMation);
		map.put("knowLedge", knowLedge);
		map.put("policy", policy);
		return map;
	}
}
