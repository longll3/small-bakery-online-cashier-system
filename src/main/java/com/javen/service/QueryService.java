/* 
 * @param userName 查询条件，可为空  
 * @param pageNo 查询条件，可为空，默认取1  
 * @param pageSize 查询条件，可为空，默认取10  
 * @return  
 */

package com.javen.service; 

import com.javen.model.Product;
import com.javen.util.PagedResult;

public interface QueryService {
	PagedResult<Product> queryByPage(String productName,Integer pageNo,Integer pageSize);
	Product getProductById(int id);
};