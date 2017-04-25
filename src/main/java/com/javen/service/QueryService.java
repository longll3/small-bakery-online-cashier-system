/* 
 * @param userName ��ѯ��������Ϊ��  
 * @param pageNo ��ѯ��������Ϊ�գ�Ĭ��ȡ1  
 * @param pageSize ��ѯ��������Ϊ�գ�Ĭ��ȡ10  
 * @return  
 */

package com.javen.service; 

import com.javen.model.Product;
import com.javen.util.PagedResult;

public interface QueryService {
	PagedResult<Product> queryByPage(String productName,Integer pageNo,Integer pageSize);
	Product getProductById(int id);
};