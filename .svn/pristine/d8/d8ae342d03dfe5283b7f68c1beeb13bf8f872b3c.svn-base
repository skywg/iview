package com.ovit.bee.web;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ovit.bee.pojo.LoginUser;
import com.ovit.bee.pojo.SelfMenuConf;
import com.ovit.bee.service.LoginUserService;
import com.ovit.bee.service.SelfMenuConfService;
import com.ovit.bee.util.Const;
import com.ovit.bee.util.UuidUtil;
import com.ovit.bee.web.base.BaseController;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;

@Controller
@RequestMapping("/login")
public class LoginUserController extends BaseController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4721537153182987096L;
	@Autowired
	private LoginUserService loginUserService;
	@Autowired
	private SelfMenuConfService selfConfService;
	@Autowired
    private RedisTemplate<String, String> redisTemplate;
	@Value("${jwt.key}")
	private String key;
	
	@ResponseBody
	@RequestMapping("/")
	public List<LoginUser> findById() {
		List<LoginUser> logins = loginUserService.findAll();
		return logins;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findbyid/{id}")
	public LoginUser findById(@PathVariable int id) {
		LoginUser login = loginUserService.selectByPrimaryKey(id);
		return login;
	}

	@ResponseBody
	@RequestMapping("/findbyname/{name}")
	public LoginUser findByName(@PathVariable String name) {
		LoginUser user = loginUserService.findByLoginName(name);
		return user;
	}

	/**
	 * 好友展示
	 * 
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/friend_list/{page}")
	public PageInfo<LoginUser> findByName(HttpServletRequest request,@PathVariable String page) {
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser) session.getAttribute("currentUser");
		PageInfo<LoginUser> list=new PageInfo<>();
		try{
			String username = loginUser.getLoginAccount();
			int currentPage = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(page);
			list =loginUserService.query(currentPage, 5, username);
		}catch (Exception e) {
			logger.error(e);
		}
		return list;
	}
	
	/**
	 * 推荐好友
	 * 
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/friends/{page}")
	public PageInfo<LoginUser> showFriends(@PathVariable String page) {
		int currentPage = StringUtils.isEmpty(page) ? 0 : Integer.parseInt(page);
		PageInfo<LoginUser> list =loginUserService.query(currentPage, 10);
		return list;
	}
	/**
	 * 注册
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Map<String,Object> insert(@RequestBody Map<String, Object> params,HttpServletRequest request) throws Exception {
		String username = params.get("username").toString();
		String pwd = params.get("pwd").toString();
		LoginUser user = new LoginUser();
		Map<String,Object> map=new HashMap<>();	
		LoginUser users = loginUserService.findByLoginName(username);
		if (users != null) {
			map.put("msg", Const.EXISTS);
			return map;
		} else {
			user.setLoginAccount(username);
			user.setUniqueId(UuidUtil.get32UUID());
			user.setRegisterTime(new Date());
			user.setLoginPasswd(new SimpleHash("SHA-1", Const.SESSION_SALT, pwd).toString());
			loginUserService.insert(user);
			HttpSession session = request.getSession();
			session.setAttribute("currentUser",user);
			map.put("msg", user);
			return map;
		}
	}
	
	
	/**
	 * 登录
	 * @param params
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(@RequestBody Map<String, Object> params, HttpServletRequest request)
			throws Exception {
		String userName = params.get("username").toString();
		String pwd = params.get("pwd").toString();
		String pwdMD5 = new SimpleHash("SHA-1", Const.SESSION_SALT, pwd).toString();
		LoginUser user = loginUserService.login(userName, pwdMD5);
		Map<String, Object> map = new HashMap<>();
		if (null != user) {
			HttpSession session = request.getSession();
//			String compactJws = Jwts.builder().setSubject(userName).signWith(SignatureAlgorithm.HS512, key.getBytes())
//					.compact();
//			user.setToken(compactJws);
			session.setAttribute("currentUser", user);
			map.put("user", user);
			Map<String, Object> shopMap = new HashMap<String, Object>();
			shopMap.put("member_id", String.valueOf(user.getId()));
			shopMap.put("name", user.getDisplayName());
			shopMap.put("gateway_is_check", "true");
			String avatar = null!=user.getAvatar()?user.getAvatar():"";
			shopMap.put("face_image", avatar);
			//gateway_type":1,//门户类型   1：//商城  2：//博客类  3：//混合  商城+博客
			shopMap.put("gateway_type", "1");
			redisTemplate.opsForValue().set(user.getUniqueId(), JSONObject.toJSONString(shopMap), 30,TimeUnit.MINUTES);
//			redisTemplate.opsForHash().putAll(user.getUniqueId(), shopMap);
//			System.out.println(redisTemplate.opsForHash().entries(user.getUniqueId()));
		}
		return map;
	}
	
	/**
	 * 用户自定义设置
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws NumberFormatException 
	 */
	@ResponseBody
	@RequestMapping(value = "/selfConf", method = RequestMethod.POST)
	public void CustomSet(HttpServletRequest request,
			@RequestBody Map<String, Object> params) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		SelfMenuConf selfs = new SelfMenuConf();
		String conf = (String) params.get("self");
		String str = conf.substring(1, conf.length() - 1);
		String[] confs = str.split(",");
		SelfMenuConf selfMenuConf = evaluate(confs, selfs);
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser) session.getAttribute("currentUser");
		String username = loginUser.getLoginAccount();
		SelfMenuConf self = selfConfService.findByAccount(username);
		if (self != null) {
			selfConfService.deleteByAccount(username);
			selfMenuConf.setUserAccount(username);
			selfConfService.insert(selfMenuConf);
		} else {
			selfMenuConf.setUserAccount(username);
			selfConfService.insert(selfMenuConf);
		}
	}
	/**
	 * 和前台传的参数进行比较
	 * @param array
	 * @param pojo
	 * @return
	 * @throws NumberFormatException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static SelfMenuConf evaluate(String[] array,SelfMenuConf pojo)  
			throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] f = SelfMenuConf.class.getDeclaredMethods();
		for (Method method : f) {
			if (method.getName().startsWith("set")) {
				for (String str : array) {
					String news = str.substring(1, str.length() - 1);
					if ((news).equalsIgnoreCase(method.getName().substring(3))) {
						method.invoke(pojo, 1);
					}
				}
			}
		}
		return pojo;
	}
	
	/**
	 * 登出
	 * @param request
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public int logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("currentUser");
		return 0;
	}

	public static void main(String[] args) throws NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String[] str={"personalInfo","circle","service","studio"};
		SelfMenuConf selfs=new SelfMenuConf();
		SelfMenuConf selfMenuConf=evaluate(str,selfs);
		System.out.println(selfMenuConf.toString());	
	}
}
