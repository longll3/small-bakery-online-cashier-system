package com.javen;


import javax.annotation.Resource;  

import org.apache.log4j.Logger;  
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import com.alibaba.fastjson.JSON;
import com.javen.model.Product;
import com.javen.model.User;
import com.javen.service.IUserService;
import com.javen.service.QueryService;
import com.javen.util.PagedResult;
  
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
  
public class queryTest {  
    private static Logger logger = Logger.getLogger(queryTest.class);  
//  private ApplicationContext ac = null;  
    @Resource  
    private QueryService userService = null;  
  
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
    @Test
    public void queryByPage(){  
        PagedResult<Product>  pagedResult = userService.queryByPage(null,1,10);//null表示查全部    
        logger.debug("查找结果" + pagedResult);  
   };  
}