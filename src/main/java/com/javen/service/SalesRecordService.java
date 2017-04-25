package com.javen.service;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

//import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

//import com.javen.dao.SalesRecordMapper;
import com.javen.model.SalesRecord;

@Service("ProductService")
public interface SalesRecordService {
	public int insertRecord(SalesRecord record);
	public SalesRecord selectRecord(SalesRecord record);
	public int updateRecord(SalesRecord record);
	//order by recordId
	public List<SalesRecord> selectBydate(Date date);
	//asc ÕýÐò
	public List<SalesRecord> selectByDateOrderByCount(Date date);
	//desc ÄæÐò
	public List<SalesRecord> selectByDateOrderByContDesc(Date date);
	//order by count desc
	public List<SalesRecord> selectByProductID(Integer id);
}