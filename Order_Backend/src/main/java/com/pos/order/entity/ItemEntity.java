package com.pos.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class ItemEntity {
	
	@Id
	@Column(name = "PID",nullable = false,length = 50)
	private String pId;
	
	@Column(name = "NAME",nullable = false,length = 255)
	private String name;
	
	@Column(name = "UPRICE",nullable = false,length = 255)
	private String uPrice;
	
	@Column(name = "Qtity",nullable = false,length = 255)
	private String qtity;
	
	@Column(name = "STATUS",nullable = false,length = 20)
	private String status;

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ItemEntity [pId=" + pId + ", name=" + name + ", uPrice=" + uPrice + ", qtity=" + qtity + ", status="
				+ status + "]";
	}


	
	
	

}
