package com.pos.order.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {
	
	@Id
	@Column(name = "PID",nullable = false,length = 50)
	private String pId;
	
	@Column(name = "NAME",nullable = false,length = 255)
	private String name;
	
	@Column(name = "ADRESs",nullable = false,length = 255)
	private String adress;
	
	@Column(name = "MOBILE",nullable = false,length = 20)
	private String mobile;
	
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomerEntity [pId=" + pId + ", name=" + name + ", adress=" + adress + ", mobile=" + mobile
				+ ", status=" + status + "]";
	}

	
	
	
	

}
