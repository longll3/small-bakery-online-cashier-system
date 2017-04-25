package com.javen.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
//import net.sf.json.*;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javen.model.User;
import com.javen.model.UserExample;
import com.javen.model.UserExample.Criteria;
import com.javen.service.IRegisterService;
import com.javen.service.IUserService;

@Controller
public class RegisterController {
	private static Logger logger = Logger.getLogger(RegisterController.class);    
	@Resource
	private IRegisterService registerService;
	
	@Resource
	private IUserService userService;
	
//	@RequestMapping({"/register","/"})
	@RequestMapping("/register")
	public String register(){  
		return "register";
	}
	
	/*一般查询服务的时候用get，向后台提交数据时用post，如注册等等。
	这个说白了就是http里面get和post的差别了，post安全点，提交的数据多点，数据是放在http头信息里面的，get的参数是在URL后面的。*/
	
	/*在Spring MVC 中使用 @RequestMapping 来映射请求，也就是通过它来指定控制器可以处理哪些URL请求，相当于Servlet中在web.xml中配置*/
	
	@RequestMapping(value="/register/checkUserName",method = RequestMethod.POST)
//	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String checkUserName(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String userName=(String)request.getParameter("userName");	
		logger.info(userName);
		//检验用户名是否存在
		boolean flag=false;
		User user_exist = userService.selectUserByUsername(userName);
		
		if(user_exist != null) {
			//user exist
			logger.info(user_exist.getUserName());
			logger.info("lllllll");
			flag = true;
		}
		Map<String,Object> map = new HashMap<String,Object>();
//		logger.info(user_exist.getUserName());
		map.put("flag", flag);  		  
//		logger.info(user_exist.getUserName());
		JSONObject.fromObject(user_exist);
		String json = JSONObject.fromObject(map).toString();
//		logger.info(user_exist.getUserName());
		//将数据返回
		response.setCharacterEncoding("UTF-8");
		response.flushBuffer();
		response.getWriter().write(json);
		response.getWriter().flush();  
		response.getWriter().close();
		return null;
		
		/*UserExample userExample=new UserExample();
		Criteria conditionCri = userExample.createCriteria();
		conditionCri.andUserNameEqualTo(userName);		
	    int num=registerService.countByExample(userExample);
	    //用户名是否存在的标志
	    boolean flag=false;
	    if(num>0){
	    	flag=true;
	    }		
		//将数据转换成json
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("flag", flag);  		  
		String json = JSONObject.fromObject(map).toString(); 		
		//将数据返回
		response.setCharacterEncoding("UTF-8");
		response.flushBuffer();
		response.getWriter().write(json);
		response.getWriter().flush();  
		response.getWriter().close();
		return null;*/
	}
	
	@RequestMapping(value="/register/checkEmail",method = RequestMethod.POST)
//	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String checkEmail(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String email=(String)request.getParameter("email");
		
		//检验邮箱是否存在
		
		User user_email = userService.selectUserByEmail(email);
		
		/*UserExample userExample=new UserExample();
		Criteria conditionCri = userExample.createCriteria();
		conditionCri.andUserEmailEqualTo(email);		
	    int num=registerService.countByExample(userExample);*/
	    //用户名是否存在的标志
	    boolean flag=false;
	    if(user_email != null){
	    	logger.info(user_email.getUserName());
	    	flag=true;
	    }		
		//将数据转换成json
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("flag", flag);  		  
		String json = JSONObject.fromObject(map).toString(); 		
		//将数据返回
		response.setCharacterEncoding("UTF-8");
		response.flushBuffer();
		response.getWriter().write(json);
		response.getWriter().flush();  
		response.getWriter().close();
		return null;
	}
	
	//ModelAndView构造函数可以指定返回页面的名称，也可以通过setViewName方法来设置所需要跳转的页面
	//返回的是一个包含模型和视图的ModelAndView对象
	//ModelAndView model = new ModelAndView("/register");  //ModelAndView(String viewName);
	//model.setViewName("/user/index");
	//model.addObject("***", "***");
	
	//ModelAndView(String viewName, Map model)
	//如果您要返回呈现画面时所需的Model资料，则可以使用Map来收集呈现View时所需的资料，然后在建构ModelAndView作为建构时的参数。
	
	/*ModelMap model = new ModelMap();  
    if(courtName != null){  
        model.addAttribute("courtName",courtName);  
        model.addAttribute("reservations",reservationService.query(courtName));  
    }  
    return new ModelAndView("reservationQuery",model); */
	
	@RequestMapping(value="/register/successed")
	public ModelAndView  successed(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username=(String)request.getParameter("username");	
		String email=(String)request.getParameter("email");		
		String password=(String)request.getParameter("password");
		if(username==null||email==null||password==null){
			return new ModelAndView("redirect:/register"); 
		}
		//新增用户插入数据库
		User user=new User();
		user.setUserName(username);
		user.setUserEmail(email);
		user.setPassword(password);
		registerService.insert(user);		
		/*//将数据转换成
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("username", username);  
		map.put("email", email);  
		map.put("password", password);  
		String json = JSONObject.fromObject(map).toString(); 		
		//将数据返回
		response.setCharacterEncoding("UTF-8");
		response.flushBuffer();
		response.getWriter().write(json);
		response.getWriter().flush();  
		response.getWriter().close();*/
		return new ModelAndView("redirect:/login");  
	}
	

}