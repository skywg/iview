package com.ovit.bee.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ovit.bee.pojo.BrowseLog;
import com.ovit.bee.pojo.LoginUser;
import com.ovit.bee.service.BrowseLogService;

public class BrowserFilter implements Filter {

	private static Logger logger = LogManager.getLogger(BrowserFilter.class);
	
	private List<Pattern> includeList = new ArrayList<Pattern>(5);
	
	private BrowseLogService browseLogService;
	/**
	 * @param exclude
	 */
	private void setIncludeList(String include) {
		if (include != null) {
			String[] exStrs = include.split(";");
			if (exStrs != null){
				for (String exStr : exStrs){
					includeList.add(Pattern.compile(exStr.trim()));
				}
			}
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 获得请求的URL
		//String url = req.getRequestURI().toString();
		// 判断是否在排除列表
		String queryStr = req.getQueryString();
		String ctxPath = req.getContextPath();
		String requestUri = req.getRequestURI().replaceFirst(ctxPath, "");
		LoginUser loginUser = (LoginUser) req.getSession().getAttribute("currentUser");
		boolean matcher = false;
		for (Pattern pattern : includeList) {
			matcher = pattern.matcher(requestUri).matches();
			if (matcher) {
				//保存浏览记录，并刷新浏览次数（触发器）
				BrowseLog log = new BrowseLog();
				if(null != loginUser){
					log.setAccount(loginUser.getLoginAccount());
				}
				log.setPath(requestUri+"?"+queryStr);
				log.setCategory(getCatagoryId(requestUri));
				browseLogService.insertBrowseLog(log);
				logger.error("=========>"+req.getQueryString());
			}
		}
		chain.doFilter(req, res);
	}
	
	/**
	 * 类型 1 information 2 policy 3 knowledge 4expert   0 other
	 * @param requestUri
	 * @return
	 */
	private int getCatagoryId(String requestUri){
		int catagoryId = 0;
		if(requestUri.startsWith("/inforMation")){
			catagoryId = 1;
		}else if(requestUri.startsWith("/knowLege")){
			catagoryId = 3;
		}else if(requestUri.startsWith("/policy")){
			catagoryId = 2;
		}else if(requestUri.startsWith("/expert")){
			catagoryId = 4;
		}
		return catagoryId;
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		setIncludeList(filterConfig.getInitParameter("include"));
		ServletContext servletContext = filterConfig.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		browseLogService = (BrowseLogService)ctx.getBean("browseLogService");		
	}
}