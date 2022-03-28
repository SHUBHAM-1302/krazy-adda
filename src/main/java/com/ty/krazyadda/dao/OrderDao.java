package com.ty.krazyadda.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.krazyadda.dto.Item;
import com.ty.krazyadda.dto.OrdersFood;
import com.ty.krazyadda.dto.User;
import com.ty.krazyadda.repository.OrderRepository;

@Repository
public class OrderDao {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserDao dao;

	public OrdersFood saveOrder(int uid, OrdersFood order) {
		User user = dao.getUserById(uid);
		if (user != null) {
			List<Item> itemList = order.getItem();
			if (itemList != null) {
				for (Item item : itemList) {
					item.setOrder(order);
				}
			}
			order.setUser(user);
			return orderRepository.save(order);
		}
		return null;
		
	}

	public OrdersFood getOrderById(int id) {
		Optional<OrdersFood> optional = orderRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();

	}
	
	public OrdersFood updateStatus(int oid,String status) {
		OrdersFood food = getOrderById(oid);
		if(food != null) {
			food.setItem(food.getItem());
			food.setCustomerId(food.getCustomerId());
			food.setCustomerPhone(food.getCustomerPhone());
			food.setDateTime(food.getDateTime());
			food.setOrderid(food.getOrderid());
			food.setTotalCost(food.getTotalCost());
			food.setUser(food.getUser());
			food.setStatus(status);
			return orderRepository.save(food);
			
		}
		return null;
	}
	public List<OrdersFood> getAllOrders(){
		return orderRepository.findAll();
	}
	public boolean deleteOrder(int id) {
		OrdersFood food = getOrderById(id);
		if(food != null) {
			orderRepository.delete(food);
			return true;
		}
		return false;
	}

}
