package com.javen.model;

//import java.sql.Date;
import java.util.Date;

public class SalesRecord {
    private Integer recordId;

    private Date date;

    private Integer count;

    private Integer productId;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Date getDate() {
//    	java.util.Date d=new java.util.Date (date.getTime());
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}