package com.ty.krazyadda.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.krazyadda.dto.Item;
import com.ty.krazyadda.dto.OrdersFood;
import com.ty.krazyadda.repository.ItemRepository;

@Repository
public class ItemDao {
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private OrderDao dao;
	
	public Item saveItem(int orederId,Item item) {
		OrdersFood order = dao.getOrderById(orederId);
		if(order != null) {
			item.setOrder(order);
			return itemRepository.save(item);
		}
		return null;
	}
	public Item getItemById(int id) {
		Optional<Item> optional = itemRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	public Item updateItem(int id,Item item) {
		Item item2 = getItemById(id);
		if(item2 != null) {
			itemRepository.save(item);
			return item;
		}
		return null;
		
	}
	public boolean deleteItemById(int id) {
		Item item2 = getItemById(id);
		if(item2 != null) {
			itemRepository.delete(item2);
			return  true;
		}
		return  false;
		
	}
	public List<Item> getAllItem() {
		return itemRepository.findAll();
	}
}
