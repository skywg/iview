package com.ovit.bee.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.Expert;
import com.ovit.bee.service.ExpertService;

@Controller
@RequestMapping("/expert")
public class ExpertController {
	@Autowired
	private ExpertService expertService;
	
	@RequestMapping("/")
	@ResponseBody
	public PageInfo<Expert> showExp(){
		PageInfo<Expert> list=expertService.query(0, 9);
		return list;
	}
	
	/**
	 * 专家展示
	 * @return
	 */
	@RequestMapping("/find/{page}")
	@ResponseBody
	public Map<String,Object> showExp(@PathVariable String page,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		int currentPage = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(page);
		int pageSize  = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(request.getParameter("pageSize"));
		PageInfo<Expert> list=expertService.query(currentPage, pageSize);
		map.put("list", list);
		return map;
	}
	
	
	/**
	 * 搜索查询分页
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findExpertTitle/{page}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findExpertTitle(@PathVariable String page,HttpServletRequest request) throws Exception{
		String title  = request.getParameter("title");
		Map<String,Object> map = new HashMap<String, Object>();
		int currentPage = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(page);
		int pageSize  = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(request.getParameter("pageSize"));
		PageInfo<Expert> list = expertService.findExpertTitle(currentPage, pageSize,title);
		map.put("list", list);
		map.put("title", title);
		return map;
	}
}
