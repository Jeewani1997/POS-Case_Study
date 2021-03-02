package com.pos.order.dao;
import com.pos.order.dto.CustomerDto;
import com.pos.order.entity.CustomerEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity, String>{

	CustomerEntity findBypId(String getpId);

	List<CustomerEntity> findAllByStatus(String status);

	CustomerEntity findBypIdAndStatus(String getpId, String status);

	

}
