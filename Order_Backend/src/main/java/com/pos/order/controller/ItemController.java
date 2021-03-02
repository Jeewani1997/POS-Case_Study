package com.pos.order.controller;

import java.util.List;

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
import com.pos.order.dto.ItemDto;
import com.pos.order.service.CustomerService;
import com.pos.order.service.ItemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ItemController {

	@Autowired ItemService itemService;

	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public ResponseEntity<Object> save(@RequestBody ItemDto itemDto) {
		System.out.println(itemDto.toString());
		try {
			return itemService.save(itemDto);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("500", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/getitem")
	public List<ItemDto> get() throws Exception {
		return itemService.fetch();
	}
	
	@GetMapping(value = "/getitem/{pId}")
	public ResponseEntity<?> getbyId(@PathVariable String pId) throws Exception {
		List<ItemDto> itemDto= itemService.fetchbyId(pId);
        return ResponseEntity.ok(itemDto);
	}
	
	@PutMapping("/editItem/{pId}")

    public ResponseEntity<?> editItem(@RequestBody ItemDto itemDto, @PathVariable String pId) {

        try {
            return itemService.editItems(itemDto, pId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object> (e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }
	
	@PutMapping("/deleteItem/{pId}")

    public ResponseEntity<?> deleteItem(@RequestBody ItemDto itemDto, @PathVariable String pId) {

        try {
            return itemService.deleteItem(itemDto, pId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object> (e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }
	

}
