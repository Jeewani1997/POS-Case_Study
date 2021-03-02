package com.pos.order.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pos.order.dto.CustomerDto;

public interface CustomerService {

	ResponseEntity<Object> save(CustomerDto customerDto);

	List<CustomerDto> fetch();

	ResponseEntity<?> editCustomers(CustomerDto customerDto, String pId);

	List<CustomerDto> fetchbyId(String pId);

	ResponseEntity<?> deleteCustomers(CustomerDto customerDto, String pId);

}
