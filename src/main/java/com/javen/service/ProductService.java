package com.javen.service;

import java.util.List;

import com.javen.model.Product;
import com.javen.model.User;

public interface ProductService {
	
	public int insertProduct(Product pro);
	
	public Product getProductById(int userId);
    public Product selectProduct(Product pro);
    public List<Product> selectProductByType(String productName);
    public int updateProduct(Product pro);
    public int deleteProductByPrimaryKey(Integer productId);
	
}