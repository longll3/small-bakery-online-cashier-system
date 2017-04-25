package com.javen.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.javen.service.IUserService;
//import com.javen.service.UserService;
import com.javen.model.User;

@Controller
public class LoginController {
	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	@Resource
	private IUserService userService;
	@RequestMapping(value="/login")
	public String handleRequest(HttpServletRequest request, Model model) throws Exception {
		//TODO Auto-generated method stub
		String name=request.getParameter("userName");
		String password = request.getParameter("password");
		log.info(name);
		log.info(password);
		//System.out.println("name----"+name+"----password----"+password);
		if (name != null){
			log.info("name not null");
		User user = new User();
		user.setUserName(name);
		user.setPassword(password);
		user.setAge(20);
		user.setId(0);
		user.setUserEmail("abs");
		log.info("username"+user.getUserName());
		Boolean a = (user == null);
		log.info(a.toString());
//		Map<String, Object> model=new HashMap<String, Object>();
		if(userService.selectUser(user) != null) {
			user=userService.selectUser(user);
			log.info(user.getUserEmail());
			log.info(user.getPassword());
			System.out.println("能查到信息");
//			model.put("user", user);
			model.addAttribute("user",user);
//			return "main";
			return "redirect:bootstrapTest1";
		} else {
			log.info("errorrrrrr");
			System.out.println("查不到");
			model.addAttribute("error", "用户名或密码错误");
			
			return "Login";
		}} else {
			log.info("name null");
			return "Login";
		}
	}
	
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public IUserService getUserServiceImp() {
		return userService;
	}
}
