package com.javen.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

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

import com.javen.model.Product;
import com.javen.service.ProductService;

@Controller
public class AddProductController {
	private static Logger logger = Logger.getLogger(RegisterController.class);    
	@Resource
	private ProductService productService;
	
	@RequestMapping("/add")
	public String register() {  
		return "addProduct";
	}
	
	@RequestMapping(value="/add/successed")
	public ModelAndView successAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String productName = (String)request.getParameter("productType");
		String price_str = request.getParameter("price");
		double productPrice = Double.valueOf((String)request.getParameter("price")).doubleValue();
		String period = (String)request.getParameter("period");
		String productDescription = (String)request.getParameter("description");
		
		logger.info(productName);
		
		
		/*if(productName==null||price_str==null||period==null||productDescription==null){
			return new ModelAndView("redirect:/add"); 
		}*/
		
		Product pro = new Product();
		pro.setDescription(productDescription);
		pro.setPrice(productPrice);
		pro.setProductName(productName);
		pro.setQualityGuaranteePeriod(period);
		
		Product n_pro = productService.selectProduct(pro);
		//product already exits
		if (n_pro != null) {
			logger.info(pro.getProductName());
			logger.info(n_pro.getDescription());
			
		}
		
		ModelAndView model = new ModelAndView("/addProduct");
		if (productService.selectProduct(pro) != null) {
			model.addObject("error", "the product has already exit");
		} else {
			productService.insertProduct(pro);
			model.setViewName("/bootstrapTest1");
		}
		
		return model;
		
	}

	
	
	
}
