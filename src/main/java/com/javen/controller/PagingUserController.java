package com.javen.controller;  
  
  
import java.io.IOException;
import java.util.HashMap;  
import java.util.Map;  
  
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.data.domain.Pageable;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.ResponseBody;  
import org.springframework.web.servlet.ModelAndView;  
  
import com.github.pagehelper.Page;  
import com.javen.model.Product;  
import com.javen.service.QueryService;
import com.javen.service.ProductService;
import com.javen.util.PagedResult;

import net.sf.json.JSONObject;  
  
 
@Controller  
public class PagingUserController extends PagingBaseController {  
      
    private Logger logger = LoggerFactory.getLogger(getClass());  
      
    @Resource  
    private QueryService userService;  
    
    @Resource  
    private ProductService proService;
      
/*    @RequestMapping("/")    
    public ModelAndView getIndex(){      
        ModelAndView mav = new ModelAndView("index");   
        Product user = userService.getProductById(1);  
        mav.addObject("user", user);   
        return mav;    
    } */   
      
    /** 
     * 显示首页 
     */  
    @RequestMapping("/bootstrapTest1")    
    public String bootStrapTest1(){  
        return "bootstrapTest1";  
    }  
      
    /** 
     * 分页查询用户信息 
     * @param page 
     * @return 
     */  
    @RequestMapping(value="/list", method= RequestMethod.POST)  
    @ResponseBody  
    public String list(Integer pageNumber,Integer pageSize ,String userName) {  
        logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);  
        try {  
            PagedResult<Product> pageResult = (userService.queryByPage(userName, pageNumber,pageSize));  
            return responseSuccess(pageResult);  
        } catch (Exception e) {  
            return responseFail(e.getMessage());  
        }  
    }  

} 
