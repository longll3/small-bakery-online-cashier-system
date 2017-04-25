package com.javen.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
//import com.javen.dao.userMapper;
import com.javen.model.Product;
//import com.javen.model.UserExample;
//import com.javen.service.IRegisterService;
import com.javen.service.QueryService;
import com.javen.util.BeanUtil;
import com.javen.util.PagedResult;
import com.javen.dao.ProductMapper;


import java.util.List;
import com.github.pagehelper.Page;


@Service("queryService")
public class QueryServiceImpl implements QueryService {
	@Resource
	private ProductMapper productMapper;
	
	
	public PagedResult<Product> queryByPage(String productName,Integer pageNo,Integer pageSize ) {
		System.out.println("pageSize first"+pageSize);
	    pageNo = pageNo == null?1:pageNo;
	    System.out.println("pageNo"+pageNo);
	    pageSize = pageSize == null?5:pageSize;  
	    System.out.println("pageSize"+pageSize);
	    PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。  
	    return BeanUtil.toPagedResult(productMapper.selectByProductName(productName), pageNo);  
	}
	
	public Product getProductById(int id) {
		return this.productMapper.selectByPrimaryKey(id);
	}
};
