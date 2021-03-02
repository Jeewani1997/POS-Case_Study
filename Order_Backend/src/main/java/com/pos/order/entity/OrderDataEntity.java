package com.pos.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "ORDERDATA")
public class OrderDataEntity {

	@Id
	@Column(name = "PID",nullable = false,length = 50)
	private String pId;
	
	@Column(name = "UPRICE",nullable = false,length = 255)
	private String uPrice;
	
	@Column(name = "Qtity",nullable = false,length = 255)
	private String qtity;
	
	@Column(name = "STOTAL",nullable = false,length = 255)
	private Double stotal;
	
	@Column(name = "STATUS",nullable = false,length = 20)
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDID", nullable = false)
	private OrdersEntity orderEntity;
	
	@OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "ITMID",nullable = false)
	private ItemEntity itemEntity;

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getuPrice() {
		return uPrice;
	}

	public void setuPrice(String uPrice) {
		this.uPrice = uPrice;
	}

	public String getQtity() {
		return qtity;
	}

	public void setQtity(String qtity) {
		this.qtity = qtity;
	}

	public Double getStotal() {
		return stotal;
	}

	public void setStotal(Double stotal) {
		this.stotal = stotal;
	}

	public OrdersEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrdersEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

	public ItemEntity getItemEntity() {
		return itemEntity;
	}

	public void setItemEntity(ItemEntity itemEntity) {
		this.itemEntity = itemEntity;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderDataEntity [pId=" + pId + ", uPrice=" + uPrice + ", qtity=" + qtity + ", stotal=" + stotal
				+ ", status=" + status + ", orderEntity=" + orderEntity + ", itemEntity=" + itemEntity + "]";
	}

	
	
	
	
	
}
