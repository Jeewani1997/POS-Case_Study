package com.pos.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.order.dto.CustomerDto;
import com.pos.order.entity.CustomerEntity;
import com.pos.order.entity.ItemEntity;

public interface ItemDao extends JpaRepository<ItemEntity, String> {

	ItemEntity findBypId(String getpId);

	List<ItemEntity> findAllByStatus(String active);

	ItemEntity findBypIdAndStatus(String getpId, String active);

	

}
