package com.javen.service.impl;

import com.javen.model.SalesRecord;
import com.javen.service.SalesRecordService;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.dao.SalesRecordMapper;

@Service("SalesRecordService")
public class SalesRecordServiceImpl implements SalesRecordService {
	@Resource
	private SalesRecordMapper SalesRecordDao;
	
	public int insertRecord(SalesRecord record) {
		// TODO Auto-generated method stub
		try {
			return SalesRecordDao.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
//		return this.SalesRecordDao.insert(record);
	}
	
	public SalesRecord selectRecord(SalesRecord record) {
		return this.SalesRecordDao.selectByRecord(record);
	}
	
	public int updateRecord(SalesRecord record) {
		return this.SalesRecordDao.updateByPrimaryKey(record);
	}

	public List<SalesRecord> selectBydate(Date date) {
		// TODO Auto-generated method stub
		
		return this.SalesRecordDao.selectByDateOrderByRecordId(date);
	}

	public List<SalesRecord> selectByDateOrderByCount(Date date) {
		// TODO Auto-generated method stub
		return this.SalesRecordDao.selectByDateOrderByCount(date);
	}

	public List<SalesRecord> selectByDateOrderByContDesc(Date date) {
		// TODO Auto-generated method stub
		return this.SalesRecordDao.selectByDateOrderByCountDesc(date);
	}

	public List<SalesRecord> selectByProductID(Integer id) {
		// TODO Auto-generated method stub
		return this.SalesRecordDao.selectByProductId(id);
	}
	
}