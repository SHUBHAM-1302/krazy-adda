package com.ty.krazyadda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.krazyadda.dao.ProductDao;
import com.ty.krazyadda.dao.ResponseStructure;
import com.ty.krazyadda.dto.Product;
import com.ty.krazyadda.exception.EmptyListException;
import com.ty.krazyadda.exception.FormatMissMatchException;
import com.ty.krazyadda.exception.NoIdFoundException;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;
	public ResponseStructure<Product> savePerson(Product product) {

		Product product1 = dao.saveProduct(product);
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		if(product1 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(product1);
			return responseStructure;
		}
		throw new FormatMissMatchException();
	}
	public ResponseStructure<Product> getProductById(int id) {
		Product product1 = dao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		if(product1 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(product1);
			return responseStructure;
		}
		
		
		throw new NoIdFoundException("No Person found for the given id  "+id);
			
		
	}
	public ResponseStructure<Boolean> deleteProductById(int id) {
		ResponseStructure<Boolean>  responseStructure= new ResponseStructure<Boolean>();
		boolean status = dao.deleteProductById(id);
		if(status) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(status);
			return responseStructure;
		}
		throw new NoIdFoundException(" Can not delete the Product for the given id  "+id);
	}
	public ResponseStructure<Product> updateProduct(int id,Product product) {
		Product person2 = dao.updateProduct(id, product);
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		
		if(person2 != null) {
			
			
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("success");
				responseStructure.setData(person2);
				return responseStructure;
			}
			
			throw new NoIdFoundException(" We can not update the Product for the given id  "+id);
				
		
	}
	public ResponseStructure<List<Product>> getAllProduct(){
		List<Product> list = dao.getProductList();
		ResponseStructure<List<Product>>  responseStructure= new ResponseStructure<List<Product>>();
		if(list != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(list);
			return  responseStructure;
		}
		throw new EmptyListException(" No Record found in Product ");
	}

}
