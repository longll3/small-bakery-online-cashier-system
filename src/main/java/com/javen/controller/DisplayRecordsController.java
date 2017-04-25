package com.javen.controller;  

import java.io.IOException;
//import java.lang.reflect.Array;
//import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;  
import com.javen.model.Product;
import com.javen.model.SalesRecord;
//import com.javen.service.QueryService;
import com.javen.service.ProductService;
import com.javen.service.SalesRecordService;
import com.javen.util.PagedResult;
//import com.mysql.fabric.xmlrpc.base.Array;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//import com.google.gson.JsonObject;


@Controller
public class DisplayRecordsController extends PagingBaseController{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private ProductService productService;
	
	@Resource
	private SalesRecordService recService;
	
	@RequestMapping("/salesRecord")
	public String SalesRecord() {
		return "showSalesRecord";
	}
	
	@RequestMapping(value="/listRecord", method = RequestMethod.POST)
	@ResponseBody
	public String listRecord(String date_id, String method, HttpServletResponse response) throws IOException {
		logger.info("查询日期或id为 "+ date_id);
		logger.info("method :"+method);
		
		
		List<SalesRecord> ss = new ArrayList<SalesRecord>();
		if (method.equals("0")) {
			Date _date = Date.valueOf(date_id); 
			logger.info("date"+_date.toString());
			ss = recService.selectByDateOrderByContDesc(_date);
		}
		
		if (method.equals("1")) {
			Integer id = Integer.valueOf(date_id).intValue();
			logger.info("id+"+id.toString());
			ss = recService.selectByProductID(id);
		}
			
		//return responseSuccess(ss);
		logger.info(ss.toString()); //ok
        JSONArray jsonArray = JSONArray.fromObject(ss.toArray());
//        JSONArray array = JSONArray.fromObject(this.users.toArray());
        logger.info(jsonArray.toString());
//		String json = JSONObject.fromObject(map).toString(); 		
		//将数据返回
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");//设置响应的编码格式，不然会出现中文乱码现象 
		response.flushBuffer();
		response.getWriter().write(jsonArray.toString());
		response.getWriter().flush();  
		response.getWriter().close();
//		return null;
		return null;
	}
	
	@RequestMapping(value="/getProductById", method = RequestMethod.GET)
	@ResponseBody
	public String getProductById(String productId, HttpServletResponse response) throws IOException {
		logger.info("productId is "+ productId);
		Integer i = Integer.valueOf(productId).intValue();
		Product pro = productService.getProductById(i);
		JSONObject json = JSONObject.fromObject(pro);
        logger.info(json.toString());
		//将数据返回
		response.setContentType("text/html;charset=utf-8");//设置响应的编码格式，不然会出现中文乱码现象 
		response.flushBuffer();
		response.getWriter().write(json.toString());
		response.getWriter().flush();  
		response.getWriter().close();
//		return null;
		return null;
	}
	
	

}