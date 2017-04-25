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
	
	/*һ���ѯ�����ʱ����get�����̨�ύ����ʱ��post����ע��ȵȡ�
	���˵���˾���http����get��post�Ĳ���ˣ�post��ȫ�㣬�ύ�����ݶ�㣬�����Ƿ���httpͷ��Ϣ����ģ�get�Ĳ�������URL����ġ�*/
	
	/*��Spring MVC ��ʹ�� @RequestMapping ��ӳ������Ҳ����ͨ������ָ�����������Դ�����ЩURL�����൱��Servlet����web.xml������*/
	
	@RequestMapping(value="/register/checkUserName",method = RequestMethod.POST)
//	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String checkUserName(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String userName=(String)request.getParameter("userName");	
		logger.info(userName);
		//�����û����Ƿ����
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
		//�����ݷ���
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
	    //�û����Ƿ���ڵı�־
	    boolean flag=false;
	    if(num>0){
	    	flag=true;
	    }		
		//������ת����json
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("flag", flag);  		  
		String json = JSONObject.fromObject(map).toString(); 		
		//�����ݷ���
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
		
		//���������Ƿ����
		
		User user_email = userService.selectUserByEmail(email);
		
		/*UserExample userExample=new UserExample();
		Criteria conditionCri = userExample.createCriteria();
		conditionCri.andUserEmailEqualTo(email);		
	    int num=registerService.countByExample(userExample);*/
	    //�û����Ƿ���ڵı�־
	    boolean flag=false;
	    if(user_email != null){
	    	logger.info(user_email.getUserName());
	    	flag=true;
	    }		
		//������ת����json
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("flag", flag);  		  
		String json = JSONObject.fromObject(map).toString(); 		
		//�����ݷ���
		response.setCharacterEncoding("UTF-8");
		response.flushBuffer();
		response.getWriter().write(json);
		response.getWriter().flush();  
		response.getWriter().close();
		return null;
	}
	
	//ModelAndView���캯������ָ������ҳ������ƣ�Ҳ����ͨ��setViewName��������������Ҫ��ת��ҳ��
	//���ص���һ������ģ�ͺ���ͼ��ModelAndView����
	//ModelAndView model = new ModelAndView("/register");  //ModelAndView(String viewName);
	//model.setViewName("/user/index");
	//model.addObject("***", "***");
	
	//ModelAndView(String viewName, Map model)
	//�����Ҫ���س��ֻ���ʱ�����Model���ϣ������ʹ��Map���ռ�����Viewʱ��������ϣ�Ȼ���ڽ���ModelAndView��Ϊ����ʱ�Ĳ�����
	
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
		//�����û��������ݿ�
		User user=new User();
		user.setUserName(username);
		user.setUserEmail(email);
		user.setPassword(password);
		registerService.insert(user);		
		/*//������ת����
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("username", username);  
		map.put("email", email);  
		map.put("password", password);  
		String json = JSONObject.fromObject(map).toString(); 		
		//�����ݷ���
		response.setCharacterEncoding("UTF-8");
		response.flushBuffer();
		response.getWriter().write(json);
		response.getWriter().flush();  
		response.getWriter().close();*/
		return new ModelAndView("redirect:/login");  
	}
	

}