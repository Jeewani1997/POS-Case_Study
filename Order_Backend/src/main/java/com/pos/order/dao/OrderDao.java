package com.pos.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.order.entity.CustomerEntity;
import com.pos.order.entity.OrdersEntity;

public interface OrderDao extends JpaRepository<OrdersEntity, String>{

}
