package com.javen.util;  
  
import java.util.List;  
  
import com.github.pagehelper.Page;  
import com.javen.util.PagedResult;  
  
/**  
 * ¹¦ÄÜ¸ÅÒª£º  
 */  
  
  
public class BeanUtil {  
  
    public static <T> PagedResult<T> toPagedResult(List<T> datas, int pageNo) {  
        PagedResult<T> result = new PagedResult<T>();  
        if (datas instanceof Page) {        
            Page page = (Page) datas;  
            result.setPageNo(page.getPageNum()); 
            result.setPageSize(page.getPageSize());
            result.setDataList(page.getResult());
            result.setTotal(page.getTotal());
            result.setPages(page.getPages());
            
            System.out.println("getTotal() "+page.getTotal());
            System.out.println("getResult() "+page.getResult());
            System.out.println("getPageSize() "+page.getPageSize());
            System.out.println("getPageNum() "+page.getPageNum());
            System.out.println("getPages() "+page.getPages());
        } else {    
            result.setPageNo(pageNo);  
            result.setPageSize(datas.size()>5?5:datas.size());
//            result.setPageSize(datas.size()>10?10:datas.size());
            result.setDataList(datas);  
            result.setTotal(datas.size());
            
            /*********/
            result.setPages(datas.size()%5==0?datas.size()/5:(datas.size()/5 + 1));
//            result.setPages(datas.size()%10==0?datas.size()/10:(datas.size()/10 + 1));
            
            System.out.println("total"+result.getTotal());
            System.out.println("datas total"+datas.size());
            System.out.println("setDataList"+result.getDataList());
            System.out.println("Size"+result.getPageSize());
            System.out.println("no"+result.getPageNo());
            System.out.println("pages"+result.getPages());
        }  
  
        return result;  
    }  
  
}  