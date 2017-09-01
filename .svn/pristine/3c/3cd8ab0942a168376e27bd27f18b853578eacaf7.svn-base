package com.ovit.bee.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ovit.bee.pojo.JuBao;
import com.ovit.bee.pojo.LoginUser;
import com.ovit.bee.pojo.MyFavorite;
import com.ovit.bee.pojo.MyFollow;
import com.ovit.bee.pojo.MyFriend;
import com.ovit.bee.pojo.MyNoTitle;
import com.ovit.bee.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController {
	@Autowired
	private ReportService reportService;
	
	@RequestMapping(value = "/saveReport", method = RequestMethod.POST)
	@ResponseBody
	public Object saveReport(@RequestBody Map<String, Object> params,HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		JuBao report = new JuBao();
		if(null != loginUser){
			report.setCreator(loginUser.getLoginAccount());
		}
		report.setType(params.get("type").toString());
		String  url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		url.substring(0, url.length()-1);
		url = url+params.get("link").toString();
		report.setLink(url);
		report.setDescription(params.get("description").toString());
		try {
			reportService.insert(report);
			map.put("flag", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return map;
	}
	/**
	 *查询我的无忧TITLE
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/findMyTitle", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findMyTitle(HttpServletRequest request) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		if(null == loginUser){
			return null;
		}
		MyNoTitle myNoTitle = new MyNoTitle();
		myNoTitle.setEditer(loginUser.getLoginAccount());
		MyFriend myFriend = new MyFriend();
		myFriend.setAccount(loginUser.getLoginAccount());
		MyNoTitle list = reportService.findMyTitle(myNoTitle);
		Integer counts  = reportService.findMyFriend(myFriend);
		map.put("list", list);
		map.put("counts", counts);
		return map;
		
	}
	
	/**
	 * 查询收藏
	 * @param params
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findCollect", method = RequestMethod.GET)
	@ResponseBody
	public Object findCollect(@RequestBody Map<String, Object> params,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		MyFavorite report = new MyFavorite();
		if(loginUser == null){
			return null;
		}
		report.setAccount(loginUser.getLoginAccount());
		try {
			List<MyFavorite> list  = reportService.findCollect(report);
			map.put("list", list);
			map.put("flag", "1");
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return map;
	}
	
	/**
	 * 收藏
	 * @param params
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveCollect", method = RequestMethod.POST)
	@ResponseBody
	public Object saveCollect(@RequestBody Map<String, Object> params,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		MyFavorite report = new MyFavorite() ;
		if(loginUser == null){
			return null;
		}
		report.setAccount(loginUser.getLoginAccount());
		report.setType(params.get("type").toString());
		String  url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		url.substring(0, url.length()-1);
		url = url+params.get("link").toString();
		report.setPath(url);
		report.setTitle(params.get("title").toString());
		try {
			String string  = reportService.saveCollect(report);
			if(string.equals("success")){ 
				map.put("flag", "1");
			}else{
				map.put("flag", "2");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return map;
	}
	
	/**
	 * 收藏
	 * @param params
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveFollow", method = RequestMethod.POST)
	@ResponseBody
	public Object saveFollow(@RequestBody Map<String, Object> params,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("currentUser");
		MyFollow report = new MyFollow() ;
		if(loginUser == null){
			return null;
		}
		report.setAccount(loginUser.getLoginAccount());
		report.setType(params.get("type").toString());
		String  url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		url.substring(0, url.length()-1);
		url = url+params.get("link").toString();
		report.setPath(url);
		report.setLabel(params.get("label").toString());
		try {
			String string  = reportService.saveFollow(report);
			if(string.equals("success")){ 
				map.put("flag", "1");
			}else{
				map.put("flag", "2");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return map;
	}
	
	
	
	
}