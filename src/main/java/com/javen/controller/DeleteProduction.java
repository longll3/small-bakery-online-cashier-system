package com.javen.controller;  
  
import java.io.IOException;
import java.util.HashMap;  
import java.util.Map;  
  
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
import com.javen.model.Product;  
import com.javen.service.ProductService;

import net.sf.json.JSONObject;  

@Controller  
public class DeleteProduction extends PagingBaseController {  
      
    private Logger logger = LoggerFactory.getLogger(getClass());  
    
    @Resource  
    private ProductService proService;
    
    @RequestMapping(value="/bootstrapTest1/delPro")
    public String deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String id = request.getParameter("id");
   		logger.info(id);
   		int ID = Integer.valueOf(id).intValue();
   		Product del_pro = proService.getProductById(ID);
   		logger.info(del_pro.getDescription());
   		Map<String,Object> map = new HashMap<String,Object>();
   		Integer i = proService.deleteProductByPrimaryKey(ID);
   		if(i > 0 ) {
   			map.put("flag", true);
   		} else {
   			map.put("flag", false);
   		}   		
   		logger.info("delete");
   		map.put("flag", true);
   		String json = JSONObject.fromObject(map).toString();
   		
   		//将数据返回
		response.setCharacterEncoding("UTF-8");
		response.flushBuffer();
		response.getWriter().write(json);
		response.getWriter().flush();  
		response.getWriter().close();
   		return null;
    }
}
    