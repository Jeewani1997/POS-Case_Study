package com.pos.order.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class CustomerDto {

	private String pId;
	private String name;
	private String adress;
	private String mobile;
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
