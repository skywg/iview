package com.ovit.bee.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.CoterieArticle;
import com.ovit.bee.service.CoterieArticleService;
import com.ovit.bee.service.LoginUserService;

@Controller
@RequestMapping("/CoterieArticle")
public class CoterieArticleController {
	@Autowired
	private CoterieArticleService coterieArticleService;
	@Autowired
	private LoginUserService loginUserService;
	
	@ResponseBody
	@RequestMapping("/")
	public List<CoterieArticle> list(){
		
		return coterieArticleService.findAll();
	}
	
	/**
	 * 最新帖子
	 * @return
	 * @throws ParseException 
	 */
	@ResponseBody
	@RequestMapping("/query")
	public List<CoterieArticle> query() throws ParseException{
		System.out.println("最新帖子。。。。。。。。。。。。。");
		List<CoterieArticle> cArticles=coterieArticleService.findDesc();
		for(CoterieArticle c:cArticles){
			System.out.println("create="+c.getCreateTime().getTime()+"time="+c.getTime());
		}
		return coterieArticleService.findDesc();
	}
	
	/**
	 * 本周热门
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/weekHot")
	public List<CoterieArticle> weekHot(){
		
		return coterieArticleService.findHot();
	}
	
	/**
	 * 今日之星
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dayStar")
	public List<CoterieArticle> dayStar(){
		
		return coterieArticleService.findDay();
	}
	
	/**
	 * 圈体
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/circle/")
	public Map<String,List<Map<String, Object>>> circle(){
		List<Map<String, Object>> list=coterieArticleService.list();
		Map<String,List<Map<String, Object>>> circle=new HashMap<>();
		for(Map<String, Object> l:list){
				String value = (String) l.get("category");
				if(!circle.containsKey(value)){
					List<Map<String, Object>> tmp = new ArrayList<>();
					tmp.add(l);
					circle.put(value, tmp);
				}else{
					List<Map<String, Object>> tmp=circle.get(value);
					tmp.add(l);
				}
		}
		return circle;
	}

	
	/**
	 * 排行榜
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/rank/")
	public List<Map<String, Object>> rank(){
		List<Map<String, Object>> list=coterieArticleService.rank();
		return list;
	}

	/**
	 * 通过id查找圈子详情
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/circleDetail/{id}/{page}")
	public PageInfo<CoterieArticle> showFriends(@PathVariable String  id,@PathVariable String page) {
		int currentPage = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(page);
		int coterieId=StringUtils.isEmpty(id) ? 0 : Integer.parseInt(id);
		PageInfo<CoterieArticle> list =coterieArticleService.findById(coterieId, currentPage, 2);
		return list;
	}
	
	/**
	 * 根据圈子主题id查询副版主信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/moderator/{id}")
	public List<Map<String, Object>> findModeratorById(@PathVariable String  id) {
		int coterieId=StringUtils.isEmpty(id) ? 0 : Integer.parseInt(id);
		List<Map<String, Object>> list=loginUserService.findModeratorById(coterieId);
		return list;
	}	
}
