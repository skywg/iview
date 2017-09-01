package com.ovit.bee.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ovit.bee.service.CmsArticleService;
import com.ovit.bee.web.base.BaseController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/cmsArticle")
public class CmsArticleController extends BaseController{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5422984752180686233L;
	@Autowired
	private CmsArticleService cmsArticleService;
	
	
	@RequestMapping(value = "/article", method = RequestMethod.GET)
	@ResponseBody
	public Object article() throws Exception{
		return cmsArticleService.findArticle();
	}

}
