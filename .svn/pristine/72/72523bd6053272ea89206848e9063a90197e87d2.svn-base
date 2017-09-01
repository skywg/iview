package com.ovit.bee.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.CoterieArticleComment;
import com.ovit.bee.service.CoterieArticleCommentService;

@Controller
@RequestMapping("/cAComment")
public class CoterieArticleCommentController {
	@Autowired
	private CoterieArticleCommentService coterieArticleCommentService;
	
	@ResponseBody
	@RequestMapping("/")
	public List<CoterieArticleComment> list(){
		
		return coterieArticleCommentService.findAll();
	}
	
	
	@ResponseBody
	@RequestMapping("/query")
	public PageInfo<CoterieArticleComment> query(){
		
		return coterieArticleCommentService.query(0, 10);
	}

}
