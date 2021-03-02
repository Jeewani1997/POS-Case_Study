package com.pos.order.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;


public class OrderDto {
	
	private String pId;
	private Date ordDt;
	private Double tamount;
	private Double tdiscount;
	private String customer;
	private List<OrderDataDto> orderDataDto;
	private String status;
	
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public Date getOrdDt() {
		return ordDt;
	}
	public void setOrdDt(Date ordDt) {
		this.ordDt = ordDt;
	}
	public Double getTamount() {
		return tamount;
	}
	public void setTamount(Double tamount) {
		this.tamount = tamount;
	}
	public Double getTdiscount() {
		return tdiscount;
	}
	public void setTdiscount(Double tdiscount) {
		this.tdiscount = tdiscount;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public List<OrderDataDto> getOrderDataDto() {
		return orderDataDto;
	}
	public void setOrderDataDto(List<OrderDataDto> orderDataDto) {
		this.orderDataDto = orderDataDto;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderDto [pId=" + pId + ", ordDt=" + ordDt + ", tamount=" + tamount + ", tdiscount=" + tdiscount
				+ ", customer=" + customer + ", orderDataDto=" + orderDataDto + ", status=" + status + "]";
	}

	
	
	
	
	
	
	

}
