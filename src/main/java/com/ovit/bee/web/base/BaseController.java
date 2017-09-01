package com.ovit.bee.web.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ovit.bee.entity.Page;
import com.ovit.bee.util.AppUtil;
import com.ovit.bee.util.PageData;
import com.ovit.bee.util.UuidUtil;

public class BaseController  implements Serializable{

	protected Logger logger = LogManager.getLogger(this.getClass());

	private static final long serialVersionUID = 6357869213649815390L;
	
	protected PageData reqPageData = null;
	protected String result = "false";
	protected String msg = "";
	protected Map<String, Object> map = null;
	
	protected void doMyService(String serviceName) throws Exception {
		
	}
	
	protected JSONObject doMyRequest(String requestString) throws Exception {
		return doMyRequest(requestString, "");
	}
	
	protected void putMap(String key, Object value) {
		if (value != null) {
			map.put(key, value);
		}
	}
	
	protected JSONObject doMyRequest(String requestString, String checkParam) throws Exception {
		map = new HashMap<String, Object>();
	    reqPageData = this.getPageData();
	   /* if (shiroUtil.isAuthenticated()) {
	    	reqPageData.put("GYSID", shiroUtil.getUser().getUSER_ID());
	    }*/
	    result = "false";
	    msg = "";
		try {
			//检查参数
			if (checkParam.equals("")) {
				doMyService(requestString);
			} else {
				if (AppUtil.checkParam(checkParam, reqPageData))
				{
					doMyService(requestString);
				} else {
					msg = "请求参数错误";
				}
			}
		} catch (Exception e) {
			msg = "操作失败";
			logger.error(e.toString(), e);
		} finally {
			map.put("result", result);
			if (msg != "") {
				map.put("msg", msg);
			}
			logAfter(logger);
		}
		return JSONObject.fromObject(map);
	}	
	
	/**
	 * 得到PageData
	 */
	public PageData getPageData(){
		return new PageData(this.getRequest());
	}
	
	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}
	
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}

	/**
	 * 得到32位的uuid
	 * @return
	 */
	public String get32UUID(){
		return UuidUtil.get32UUID();
	}
	
	/**
	 * 得到分页列表的信息 
	 */
	public Page getPage(){
		return new Page();
	}
	
	public static void logBefore(Logger logger, String interfaceName){
		logger.info("");
		logger.info("start");
		logger.info(interfaceName);
	}
	
	public static void logAfter(Logger logger){
		logger.info("end");
		logger.info("");
	}
}
