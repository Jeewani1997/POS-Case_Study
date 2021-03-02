package com.pos.order.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.pos.order.entity.ItemEntity;
import com.pos.order.entity.OrdersEntity;

public class OrderDataDto {

	private String pId;
	private String uPrice;
	private String qtity;
	private Double stotal;
	private OrderDto orderDto;
	private ItemDto itemDto;
	private String item;
	private String fqtity;
	private String status;

	

	public String getFqtity() {
		return fqtity;
	}

	public void setFqtity(String fqtity) {
		this.fqtity = fqtity;
	}

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

	public OrderDto getOrderDto() {
		return orderDto;
	}

	public void setOrderDto(OrderDto orderDto) {
		this.orderDto = orderDto;
	}

	public ItemDto getItemDto() {
		return itemDto;
	}

	public void setItemDto(ItemDto itemDto) {
		this.itemDto = itemDto;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderDataDto [pId=" + pId + ", uPrice=" + uPrice + ", qtity=" + qtity + ", stotal=" + stotal
				+ ", orderDto=" + orderDto + ", itemDto=" + itemDto + ", item=" + item + ", fqtity=" + fqtity
				+ ", status=" + status + "]";
	}

	
	

	
	
}
