package com.javen.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
//import net.sf.json.*;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import com.javen.model.Product;
import com.javen.service.SalesRecordService;
import com.javen.model.SalesRecord;
//import com.javen.util.BeanUtil;

@Controller
public class CheckOutController {
	private static Logger log = LoggerFactory.getLogger(CheckOutController.class);
	@Resource
	private SalesRecordService salesRecordService;

//	private static double total_price;
//	private static List<Product> pro_list = new ArrayList<Product>();
	
	
	@RequestMapping(value="/bootstrapTest1/additem")
    public String addItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		
		log.info(id);
		
		
		Map<String,Object> map = new HashMap<String,Object>();
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
	
	@RequestMapping(value="/checkout")
	public String CheckOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String productId = request.getParameter("product_id");
		String count = request.getParameter("count");
		
		
		log.info(productId);
		log.info(count);
		
		String[] p_id_list = productId.split(" ");
		String[] count_list = count.split(" ");
		
		log.info(p_id_list.toString());
		log.info(count_list.toString());
		
		Date date = new Date(System.currentTimeMillis());
		log.info(date.toString());
		
		Integer l = p_id_list.length;
		int i = 0;
		for (i = 0; i < l; i++) {
			SalesRecord record = new SalesRecord();
			int c = Integer.valueOf(count_list[i]).intValue();
			int id = Integer.valueOf(p_id_list[i]).intValue();
			record.setCount(c);
			record.setProductId(id);
			record.setDate(date);
			record.setRecordId(0);
			
			SalesRecord _record = salesRecordService.selectRecord(record);
			if (_record != null) {
				log.info("not none");
				int count_1 = _record.getCount();
				Integer new_count = count_1 + c;
				_record.setCount(count_1 + c);
				salesRecordService.updateRecord(_record);
				log.info(new_count.toString());
			} else {
				log.info("new record");
				salesRecordService.insertRecord(record);
			}
			
		}
		
		
		Map<String,Object> map = new HashMap<String,Object>();
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