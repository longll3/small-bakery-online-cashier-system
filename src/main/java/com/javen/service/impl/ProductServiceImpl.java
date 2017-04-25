package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;

//import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.javen.dao.ProductMapper;
import com.javen.model.Product;
import com.javen.service.ProductService;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{
	@Resource
	private ProductMapper productDao;
	
//	@Override
	public int insertProduct(Product pro) {
		try {
			return productDao.insert(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Product getProductById(int productId) {
		return this.productDao.selectByPrimaryKey(productId);
	}
	
    public Product selectProduct(Product pro) {
    	return this.productDao.selectByProduct(pro);
    }
    
    public List<Product> selectProductByType(String productTypeName) {
    	return this.productDao.selectByProductName(productTypeName);
    }

    public int updateProduct(Product pro) {
    	return this.productDao.updateByPrimaryKey(pro);
    }
    
    public int deleteProductByPrimaryKey(Integer productId) {
    	return this.productDao.deleteByPrimaryKey(productId);
    }

}