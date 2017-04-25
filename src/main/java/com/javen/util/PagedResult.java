package com.javen.util;  
  
import java.util.List;  
  
import com.javen.dto.BaseEntity;  
  
/** 
 * 功能概要： 

 */  
public class PagedResult<T> extends BaseEntity {  
      
    /*serialVersionUID*/  
    private static final long serialVersionUID = 1L;  
  
    private List<T> dataList;//数据  
      
    private long pageNo;//当前页  
      
    private long pageSize;//条数  
      
    private long total;//总条数  
      
    private long pages;//总页面数目  
  
    public List<T> getDataList() {  
        return dataList;  
    }  
  
    public void setDataList(List<T> dataList) {
    	int from = (int) (((int)pageNo-1)*pageSize);
    	int end = (int)(from+pageSize);
    	if (end > dataList.size()) end = dataList.size();
    	List<T> data_l = dataList.subList(from, end);
        this.dataList = data_l;  
    }  
  
    public long getPageNo() {  
        return pageNo;  
    }  
  
    public void setPageNo(long pageNo) {  
        this.pageNo = pageNo;  
    }  
  
    public long getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(long pageSize) {  
        this.pageSize = pageSize;  
    }  
  
    public long getTotal() {  
        return total;  
    }  
  
    public void setTotal(long total) {  
        this.total = total;  
    }  
  
    public long getPages() {  
        return pages;  
    }  
  
    public void setPages(long pages) {  
        this.pages = pages;  
    }  
      
}  