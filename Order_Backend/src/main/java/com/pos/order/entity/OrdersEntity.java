package com.pos.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class OrdersEntity {
	
	@Id
	@Column(name = "PID",nullable = false,length = 50)
	private String pId;
	
	@Column(name = "TAMOUNT",length = 255)
	private Double tamount;
	
	@Column(name = "TDISCOUNT",length = 255)
	private Double tdiscount;
	
	@Column(name = "ORDDT",columnDefinition="DATETIME")
	private Date orddt;
	
	@Column(name = "STATUS",nullable = false,length = 20)
	private String status;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CUSID",nullable = false)
	private CustomerEntity customerEntity;
	
	@OneToMany(mappedBy = "orderEntity" ,targetEntity = OrderDataEntity.class)
	private List<OrderDataEntity> orderDataEntitys;
	
	

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
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

	public Date getOrddt() {
		return orddt;
	}

	public void setOrddt(Date orddt) {
		this.orddt = orddt;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	public List<OrderDataEntity> getOrderDataEntitys() {
		return orderDataEntitys;
	}

	public void setOrderDataEntitys(List<OrderDataEntity> orderDataEntitys) {
		this.orderDataEntitys = orderDataEntitys;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrdersEntity [pId=" + pId + ", tamount=" + tamount + ", tdiscount=" + tdiscount + ", orddt=" + orddt
				+ ", status=" + status + ", customerEntity=" + customerEntity + ", orderDataEntitys=" + orderDataEntitys
				+ "]";
	}

	
	
	
	
	

}
