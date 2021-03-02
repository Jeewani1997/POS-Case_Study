package com.pos.order.serviceIMPL;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pos.order.dao.CustomerDao;
import com.pos.order.dao.ItemDao;
import com.pos.order.dao.OrderDao;
import com.pos.order.dao.OrderDataDao;
import com.pos.order.dto.OrderDataDto;
import com.pos.order.dto.OrderDto;
import com.pos.order.entity.CustomerEntity;
import com.pos.order.entity.ItemEntity;
import com.pos.order.entity.OrderDataEntity;
import com.pos.order.entity.OrdersEntity;
import com.pos.order.service.CustomerService;
import com.pos.order.service.OrderService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceIMPL implements OrderService {
	
	private static final String ACTIVE = "ACTIVE";
	@Autowired CustomerDao customerDao;
	@Autowired OrderDao orderDao;
	@Autowired OrderDataDao orderDataDao;
	@Autowired ItemDao itemDao;

	@Override
	@Transactional
	public ResponseEntity<Object> save(OrderDto orderDto) {
		
		OrdersEntity orderEntitys =orderDao.save(saveOrder(orderDto));
		
		if(orderEntitys!=null) {
			if(saveOrderData(orderDto,orderEntitys)){
				return new ResponseEntity<Object>("200", HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>("204", HttpStatus.INTERNAL_SERVER_ERROR);
			}		
		}else {
			return new ResponseEntity<Object>("204", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	
	@Transactional
	public boolean saveOrderData(OrderDto orderDto,OrdersEntity orderEntitys) {
		if(orderDataDao.saveAll(setOrderData(orderDto.getOrderDataDto(),orderDto,orderEntitys)) != null) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	@Transactional
	public List<OrderDataEntity> setOrderData(List<OrderDataDto> orderDataList, OrderDto orderDto,OrdersEntity orderEntitys){
		List<OrderDataEntity> orderDataEntitys = new ArrayList<OrderDataEntity>();
	    
        for (OrderDataDto orderDataDto :orderDataList) {
        	
        	ItemEntity itemEntity = itemDao.findBypIdAndStatus(orderDataDto.getItem(),ACTIVE);
        	if(itemEntity!=null) {
        	
        	OrderDataEntity orderDataEntity =  new OrderDataEntity();
        	orderDataEntity.setpId(UUID.randomUUID().toString());
        	orderDataEntity.setQtity(orderDataDto.getQtity());
        	orderDataEntity.setuPrice(itemEntity.getuPrice());
        	orderDataEntity.setStotal(orderDataDto.getStotal());
        	orderDataEntity.setOrderEntity(orderEntitys);
        	orderDataEntity.setItemEntity(itemEntity);
        	orderDataEntity.setStatus(ACTIVE);
        	
        	
        	itemEntity.setQtity(orderDataDto.getFqtity());
        	if(itemDao.save(itemEntity)!=null) {
        		orderDataEntitys.add(orderDataEntity);
        	}
        	
        	
          }
        	
        }
    	
    	return orderDataEntitys;
	
	}

	@Transactional
	public OrdersEntity saveOrder(OrderDto orderDto) {
		CustomerEntity customerEntity = customerDao.findBypIdAndStatus(orderDto.getCustomer(),ACTIVE);
		OrdersEntity orderEntity = new OrdersEntity();
		
		if(customerEntity!=null) {
			
			orderEntity.setCustomerEntity(customerEntity);
			orderEntity.setpId(UUID.randomUUID().toString());
			orderEntity.setOrddt(getDate());
			orderEntity.setTamount(orderDto.getTamount());
			orderEntity.setTdiscount(orderDto.getTdiscount());
			orderEntity.setStatus(ACTIVE);
		}
		
		return orderEntity;
	}
	
	public static Date getDate() {
		//TimeZone.setDefault(TimeZone.getTimeZone("Asia/Colombo"));
		return new Date();
	}



}
