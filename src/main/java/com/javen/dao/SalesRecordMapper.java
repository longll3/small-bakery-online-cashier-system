package com.javen.dao;

import com.javen.model.SalesRecord;

import java.sql.Date;
import java.util.List;

public interface SalesRecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(SalesRecord record);

    int insertSelective(SalesRecord record);
    
    List<SalesRecord> selectByDateOrderByRecordId(Date date);
    List<SalesRecord> selectByProductId(int id);
    SalesRecord selectByRecord(SalesRecord record);
    List<SalesRecord> selectByDateOrderByCount(Date date);
    List<SalesRecord> selectByDateOrderByCountDesc(Date date);

    SalesRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(SalesRecord record);

    int updateByPrimaryKey(SalesRecord record);
}