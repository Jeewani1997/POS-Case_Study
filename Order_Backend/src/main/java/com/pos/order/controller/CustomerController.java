package com.pos.order.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pos.order.dto.CustomerDto;
import com.pos.order.service.CustomerService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {
	
	@Autowired CustomerService customerService;

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public ResponseEntity<Object> save(@RequestBody CustomerDto customerDto) {
		System.out.println(customerDto.toString());
		try {
			return customerService.save(customerDto);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("500", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping(value = "/getcustomer")
	public List<CustomerDto> get() throws Exception {
		return customerService.fetch();
	}
	
	@GetMapping(value = "/getcustomer/{pId}")
	public ResponseEntity<?> getbyId(@PathVariable String pId) throws Exception {
		List<CustomerDto> customerDto= customerService.fetchbyId(pId);
        return ResponseEntity.ok(customerDto);
	}
	
	@PutMapping("/editCustomer/{pId}")
    public ResponseEntity<?> editCustomer(@RequestBody CustomerDto customerDto, @PathVariable String pId) {
     System.out.println("dsff");
	        try {
	            return customerService.editCustomers(customerDto, pId);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<Object> (e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
	        }
	    }
	
	
	@PutMapping("/deleteCustomer/{pId}")
    public ResponseEntity<?> deleteCustomer(@RequestBody CustomerDto customerDto, @PathVariable String pId) {
     System.out.println("dsff");
	        try {
	            return customerService.deleteCustomers(customerDto, pId);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<Object> (e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
	        }
	    }
	 

	   
}
