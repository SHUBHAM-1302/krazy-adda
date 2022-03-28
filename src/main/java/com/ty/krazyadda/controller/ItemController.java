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
import com.ty.krazyadda.dto.Item;
import com.ty.krazyadda.service.ItemService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	
	@ApiOperation(value = "Save item ", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Item is successfull"),
			@ApiResponse(code = 404, message = "Item is not saved")

	})
	@PostMapping("/item")
	public ResponseStructure<Item>  saveItem(@RequestParam int id,@RequestBody Item item) {
		return itemService.saveItem(id, item);
	}
	
	@ApiOperation(value = "Update Item ", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Item is successfull"),
			@ApiResponse(code = 404, message = "Invalid Id")

	})
	@PutMapping("/item")
	public ResponseStructure<Item> updateItem(@RequestParam int id,@RequestBody Item item) {
		return itemService.updateItem(id, item);
	}
	
	@ApiOperation(value = "Delete  Order ", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Delete item is successfull"),
			@ApiResponse(code = 404, message = "invalid id to delete")

	})
	@DeleteMapping("/item")
	public ResponseStructure<Boolean> deleteId(@RequestParam int id) {
		return itemService.deleteItemById(id);
	}
	
	@ApiOperation(value = "Get Item By Id ", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Given Id Item"),
			@ApiResponse(code = 404, message = "Invalid Id")

	})
	@GetMapping("/item")
	public ResponseStructure<Item> getItemById(@RequestParam int id) {
		return itemService.getItemById(id);
	}
	@ApiOperation(value = "Total Item ", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Total Item"),
			@ApiResponse(code = 404, message = "List Is Empty ")

	})
	@GetMapping("/allitem")
	public ResponseStructure<List<Item>> getAllItem() {
		return itemService.getAllItem();
	}
}
