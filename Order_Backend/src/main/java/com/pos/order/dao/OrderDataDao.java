package com.pos.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.order.entity.OrderDataEntity;
import com.pos.order.entity.OrdersEntity;

public interface OrderDataDao extends JpaRepository<OrderDataEntity, String> {

}
