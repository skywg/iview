package com.ovit.bee.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ovit.bee.web.base.BaseController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class ManageController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5334104538440495356L;
	/*@Autowired
	private ManageService manageService;*/

	@Override
	protected void doMyService(String serviceName) throws Exception {
		if (serviceName.equals("register")) {
			/*manageService.saveRegister(reqPageData);*/
			result = "true";
		}
	}

	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	@ResponseBody
	public boolean login(HttpServletRequest request) {
		String name = request.getParameter("loginName");
		String password = request.getParameter("password");
		boolean result = Boolean.FALSE;
		if (!(StringUtils.isEmpty(name) || StringUtils.isEmpty(password))) {
			request.getSession().setAttribute(name, result);
		}
		return result;
	}

	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public String Test(){
		String str="hello axios";
		return str;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@ResponseBody
	public Object register() throws Exception {
		return doMyRequest("register", "");
	}
}