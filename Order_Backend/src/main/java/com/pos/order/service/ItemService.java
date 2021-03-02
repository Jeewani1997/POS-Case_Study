package com.pos.order.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pos.order.dto.CustomerDto;
import com.pos.order.dto.ItemDto;

public interface ItemService {

	ResponseEntity<Object> save(ItemDto itemDto);

	List<ItemDto> fetch();

	ResponseEntity<?> editItems(ItemDto itemDto, String pId);

	List<ItemDto> fetchbyId(String pId);

	ResponseEntity<?> deleteItem(ItemDto itemDto, String pId);

	

}
