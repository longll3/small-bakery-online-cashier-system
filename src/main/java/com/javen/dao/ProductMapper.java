package com.javen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.javen.model.Product;
import com.javen.util.PagedResult;

public interface ProductMapper {
	Product selectByProduct(Product pro);
	
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);
    
    List<Product> selectByProductName(@Param("productName") String name);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}