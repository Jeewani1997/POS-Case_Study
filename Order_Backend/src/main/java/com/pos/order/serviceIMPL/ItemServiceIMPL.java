package com.pos.order.serviceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pos.order.dao.ItemDao;
import com.pos.order.dto.CustomerDto;
import com.pos.order.dto.ItemDto;
import com.pos.order.entity.CustomerEntity;
import com.pos.order.entity.ItemEntity;
import com.pos.order.service.ItemService;

@Service
public class ItemServiceIMPL implements ItemService{
	
	private static final String ACTIVE = "ACTIVE";
	@Autowired ItemDao itemDao;

	@Override
	@Transactional
	public ResponseEntity<Object> save(ItemDto itemDto) {

		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setpId(UUID.randomUUID().toString());
		itemEntity.setName(itemDto.getName());
		itemEntity.setQtity(itemDto.getQtity());
		itemEntity.setuPrice(itemDto.getuPrice());
		itemEntity.setStatus("ACTIVE");
		
		if(itemDao.save(itemEntity)!=null) {
			return new ResponseEntity<Object>("200", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("204", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	@Transactional
	public List<ItemDto> fetch() {
       List<ItemDto> itemDtos = new ArrayList<ItemDto>();
		
		try {
			
			List<ItemEntity> itemEntitys = itemDao.findAllByStatus(ACTIVE); 
              if(itemEntitys != null) {
				
            	  itemEntitys.forEach(pc -> {
					
            		ItemDto itemDto = new ItemDto();
            		itemDto.setpId(pc.getpId());
            		itemDto.setName(pc.getName());
            		itemDto.setQtity(pc.getQtity());
            		itemDto.setuPrice(pc.getuPrice());
					
					
            		itemDtos.add(itemDto);
				});
				
				return itemDtos;
				
			}else {
				return null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return itemDtos;
	}

	@Override
	@Transactional
	public ResponseEntity<?> editItems(ItemDto itemDto, String pId) {
		ItemEntity itemEntity = itemDao.findBypIdAndStatus(itemDto.getpId(),ACTIVE);

		itemEntity.setpId(itemDto.getpId());
		itemEntity.setName(itemDto.getName());
		itemEntity.setQtity(itemDto.getQtity());
		itemEntity.setuPrice(itemDto.getuPrice());
	      
		if(itemDao.save(itemEntity)!=null) {
			return new ResponseEntity<Object>("200", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("204", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional
	public List<ItemDto> fetchbyId(String pId) {
       List<ItemDto> itemDtos = new ArrayList<ItemDto>();
		
        ItemEntity itemEntitys = itemDao.findBypIdAndStatus(pId,ACTIVE);
        ItemDto itemDto = new ItemDto();
        itemDto.setpId(itemEntitys.getpId());
        itemDto.setName(itemEntitys.getName());
        itemDto.setQtity(itemEntitys.getQtity());
        itemDto.setuPrice(itemEntitys.getuPrice());
		
        itemDtos.add(itemDto);
		
		return itemDtos;
	}


	@Override
	@Transactional
	public ResponseEntity<?> deleteItem(ItemDto itemDto, String pId) {
		ItemEntity itemEntity = itemDao.findBypIdAndStatus(itemDto.getpId(),ACTIVE);

		itemEntity.setStatus("INACTIVE");
	      
		if(itemDao.save(itemEntity)!=null) {
			return new ResponseEntity<Object>("200", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("204", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	
	

}
