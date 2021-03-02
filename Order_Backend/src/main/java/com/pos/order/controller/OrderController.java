package com.pos.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pos.order.dto.CustomerDto;
import com.pos.order.dto.OrderDto;
import com.pos.order.service.CustomerService;
import com.pos.order.service.OrderService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class OrderController {
	
	@Autowired OrderService orderService;
	
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public ResponseEntity<Object> save(@RequestBody OrderDto orderDto) {
		System.out.println(orderDto.toString());
		try {
			return orderService.save(orderDto);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("500", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
