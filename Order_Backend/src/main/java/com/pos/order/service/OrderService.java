package com.pos.order.service;

import org.springframework.http.ResponseEntity;

import com.pos.order.dto.OrderDto;

public interface OrderService {

	ResponseEntity<Object> save(OrderDto orderDto);

}
