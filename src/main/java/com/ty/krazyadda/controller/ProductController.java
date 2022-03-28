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
import com.ty.krazyadda.dto.Product;
import com.ty.krazyadda.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value = "save product", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "product details"),
			@ApiResponse(code = 404, message = "invalid format")

	})
	@PostMapping("/product")
	public ResponseStructure<Product> saveProduct(@RequestBody Product product) {
		return productService.savePerson(product);
	}
	
	@ApiOperation(value = "Find product by id", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "product details"),
			@ApiResponse(code = 404, message = "invalid product id")

	})
	@GetMapping("/product")
	public ResponseStructure<Product> getProductByid(@RequestParam int id) {
		return productService.getProductById(id);
	}
	@ApiOperation(value = "Total product", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "product details"),
			@ApiResponse(code = 404, message = "Empty List")

	})
	@GetMapping("/allproduct")
	public ResponseStructure<List<Product>> getProductList()
	{
		return productService.getAllProduct();
	}
	@ApiOperation(value = "Delete product", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "product  is deeted"),
			@ApiResponse(code = 404, message = "Product not found for the given id")

	})
	
	@DeleteMapping("/product")
	public ResponseStructure<Boolean> deleteProductById(@RequestParam int id) {
		return  productService.deleteProductById(id);
	}
	
	@ApiOperation(value = "Update  product", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "product details are updated"),
			@ApiResponse(code = 404, message = "Invalid product id")

	})
	@PutMapping("/product")
	public ResponseStructure<Product> updateProduct(@RequestParam int id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

}
