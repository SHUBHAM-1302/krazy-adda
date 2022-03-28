package com.ty.krazyadda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.krazyadda.dao.OrderDao;
import com.ty.krazyadda.dao.ResponseStructure;
import com.ty.krazyadda.dto.Item;
import com.ty.krazyadda.dto.OrdersFood;
import com.ty.krazyadda.exception.EmptyListException;
import com.ty.krazyadda.exception.NoIdFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderDao dao;

	public ResponseStructure<OrdersFood> saveOrder(int id, int gst, OrdersFood order) {
//		OrdersFood order2 = dao.saveOrder( id,order);
//		if(order2 != null) {
		ResponseStructure<OrdersFood> responseStructure = new ResponseStructure<OrdersFood>();
		double totalcost = 0;
		List<Item> items = order.getItem();
		for (Item item : items) {
			totalcost += item.getCost()*item.getQuantity();		}

		totalcost = totalcost + ((totalcost * gst) / 100);
		order.setTotalCost(totalcost);
		OrdersFood order2 = dao.saveOrder(id, order);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(order2);
		return responseStructure;

	}

	public ResponseStructure<OrdersFood> updateStatus(int id, String status) {
		OrdersFood food = dao.updateStatus(id, status);
		ResponseStructure<OrdersFood> responseStructure = new ResponseStructure<OrdersFood>();

		if (food != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(food);
			return responseStructure;
		}
		throw new NoIdFoundException("invalid id to update status " + id);

	}

	public ResponseStructure<OrdersFood> getOrderById(int id) {
		OrdersFood food = dao.getOrderById(id);
		ResponseStructure<OrdersFood> responseStructure = new ResponseStructure<OrdersFood>();
		if (food != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(food);
			return responseStructure;
		}
		throw new NoIdFoundException("invalid id  " + id);

	}

	public ResponseStructure<Boolean> deleteOrderById(int id) {
		ResponseStructure<Boolean> responseStructure = new ResponseStructure<Boolean>();
		boolean status = dao.deleteOrder(id);
		if (status) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(status);
			return responseStructure;
		}
		throw new NoIdFoundException(" Can not delete the Order for the given id  " + id);
	}

	public ResponseStructure<List<OrdersFood>> getAllProduct() {
		List<OrdersFood> list = dao.getAllOrders();
		ResponseStructure<List<OrdersFood>> responseStructure = new ResponseStructure<List<OrdersFood>>();
		if (list != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(list);
			return responseStructure;
		}
		throw new EmptyListException(" No Record found  ");
	}
}
