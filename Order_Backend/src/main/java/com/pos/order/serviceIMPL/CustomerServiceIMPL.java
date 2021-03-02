package com.pos.order.serviceIMPL;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pos.order.dao.CustomerDao;
import com.pos.order.dao.OrderDataDao;
import com.pos.order.dto.CustomerDto;
import com.pos.order.entity.CustomerEntity;
import com.pos.order.service.CustomerService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceIMPL implements CustomerService{
	
	private static final String ACTIVE = "ACTIVE";
	@Autowired CustomerDao customerDao;
	

	@Override
	@Transactional
	public ResponseEntity<Object> save(CustomerDto customerDto) {
		
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setpId(UUID.randomUUID().toString());
		customerEntity.setName(customerDto.getName());
		customerEntity.setAdress(customerDto.getAdress());
		customerEntity.setMobile(customerDto.getMobile());
		customerEntity.setStatus("ACTIVE");
		
		if(customerDao.save(customerEntity)!=null) {
			return new ResponseEntity<Object>("200", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("204", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	@Transactional
	public List<CustomerDto> fetch() {
		
		List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
		
		try {
			
			List<CustomerEntity> customerEntitys = customerDao.findAllByStatus(ACTIVE); 
              if(customerEntitys != null) {
				
            	  customerEntitys.forEach(pc -> {
					
            		CustomerDto customerDto = new CustomerDto();
            		customerDto.setpId(pc.getpId());
            		customerDto.setName(pc.getName());
            		customerDto.setAdress(pc.getAdress());
            		customerDto.setMobile(pc.getMobile());
					
					
            		customerDtos.add(customerDto);
				});
				
				return customerDtos;
				
			}else {
				return null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return customerDtos;
	}

	@Override
	@Transactional
	public ResponseEntity<?> editCustomers(CustomerDto customerDto, String pId) {

		CustomerEntity customerEntity = customerDao.findBypIdAndStatus(customerDto.getpId(),ACTIVE);

		customerEntity.setpId(customerDto.getpId());
		customerEntity.setName(customerDto.getName());
		customerEntity.setAdress(customerDto.getAdress());
		customerEntity.setMobile(customerDto.getMobile());
	      
		if(customerDao.save(customerEntity)!=null) {
			return new ResponseEntity<Object>("200", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("204", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@Override
	@Transactional
	public List<CustomerDto> fetchbyId(String pId) {
		List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
		
		CustomerEntity customerEntitys = customerDao.findBypIdAndStatus(pId,ACTIVE);
		CustomerDto customerDto = new CustomerDto();
		customerDto.setpId(customerEntitys.getpId());
		customerDto.setName(customerEntitys.getName());
		customerDto.setAdress(customerEntitys.getAdress());
		customerDto.setMobile(customerEntitys.getMobile());
		
		customerDtos.add(customerDto);
		
		return customerDtos;
	}

	@Override
	@Transactional
	public ResponseEntity<?> deleteCustomers(CustomerDto customerDto, String pId) {
		CustomerEntity customerEntity = customerDao.findBypIdAndStatus(customerDto.getpId(),ACTIVE);
		customerEntity.setStatus("INACTIVE");
		
		if(customerDao.save(customerEntity)!=null) {
			return new ResponseEntity<Object>("200", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("204", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	



}
