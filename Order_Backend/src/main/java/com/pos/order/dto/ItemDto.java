package com.pos.order.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class ItemDto {

	private String pId;
	private String name;
	private String uPrice;
	private String qtity;
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
