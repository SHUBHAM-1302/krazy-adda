package com.ty.krazyadda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.krazyadda.dao.ResponseStructure;
import com.ty.krazyadda.dto.OrdersFood;
import com.ty.krazyadda.service.OrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@ApiOperation(value = "Save Order ", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Order is successfull"),
			@ApiResponse(code = 404, message = "Order is not saved")

	})
	
	@PostMapping("/orders")
	public ResponseStructure<OrdersFood> saveOrder(@RequestParam int userId,@RequestParam int  gst,@RequestBody OrdersFood order) {
		return orderService.saveOrder(userId, gst, order);
		
	}
	
	
	@ApiOperation(value = "Update Order Status", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Status is updated"),
			@ApiResponse(code = 404, message = "User id is incorrect")

	})

	@PutMapping("/orderstatus")
	public ResponseStructure<OrdersFood> updateStatus(@RequestParam int id,@RequestParam String status) {
		return orderService.updateStatus(id, status);
	}
	
	
	@ApiOperation(value = "Get Order by id", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Order for given id"),
			@ApiResponse(code = 404, message = "invalid given id")

	})

	@GetMapping("/order")
	public ResponseStructure<OrdersFood> getOrderById(@RequestParam int id) {
		return orderService.getOrderById(id);
		
	}
	

	@ApiOperation(value ="View order", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Order details"),
			@ApiResponse(code = 404, message = "Empty List")

	})
	@GetMapping("/allorder")
	public ResponseStructure<List<OrdersFood>> getAllOrder() {
		return orderService.getAllProduct();
	}
	
	
	@ApiOperation(value ="Delete  order", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Order is deleted"),
			@ApiResponse(code = 404, message = "Invalid order id")

	})
	@DeleteMapping("/order")
	public ResponseStructure<Boolean> deletOrderById(@RequestParam int id) {
		return orderService.deleteOrderById(id);
	}
	
	
}
