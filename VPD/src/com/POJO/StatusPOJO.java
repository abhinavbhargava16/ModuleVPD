package com.POJO;

import java.util.Date;

public class StatusPOJO {

	private int customerid;
	private Date datestamp;
	private String status;
	private String remark;
	
	
	public StatusPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatusPOJO(int customerid, Date datestamp, String status, String remark) {
		super();
		this.customerid = customerid;
		this.datestamp = datestamp;
		this.status = status;
		this.remark = remark;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public Date getDatestamp() {
		return datestamp;
	}
	public void setDatestamp(Date datestamp) {
		this.datestamp = datestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
