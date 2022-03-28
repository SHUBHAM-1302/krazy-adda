package com.ty.krazyadda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.krazyadda.dao.ItemDao;
import com.ty.krazyadda.dao.ResponseStructure;
import com.ty.krazyadda.dto.Item;
import com.ty.krazyadda.exception.EmptyListException;
import com.ty.krazyadda.exception.NoIdFoundException;

@Service
public class ItemService {
	@Autowired
	private ItemDao dao;
	public  ResponseStructure<Item> saveItem(int id,Item item) {
		
		Item item2= dao.saveItem(id, item);
		ResponseStructure<Item> responseStructure = new ResponseStructure<Item>();
		if(item2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(item2);
			return responseStructure;	
		}
		throw new  NoIdFoundException("Order Id invalid");
	}
	public ResponseStructure<Item> getItemById(int id) {
		Item item1 = dao.getItemById(id);
		ResponseStructure<Item> responseStructure = new ResponseStructure<Item>();
		if(item1 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(item1);
			return responseStructure;
		}
		
		
		throw new NoIdFoundException("Invalid id "+id);
			
		
	}
	public ResponseStructure<Boolean> deleteItemById(int id) {
		ResponseStructure<Boolean>  responseStructure= new ResponseStructure<Boolean>();
		boolean status = dao.deleteItemById(id);
		if(status) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(status);
			return responseStructure;
		}
		throw new NoIdFoundException(" Invalid id "+id);
	}
	public ResponseStructure<Item> updateItem(int id,Item item) {
		Item item1 = dao.updateItem(id, item);
		ResponseStructure<Item> responseStructure = new ResponseStructure<Item>();
		
		if(item1 != null) {
			
			
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("success");
				responseStructure.setData(item1);
				return responseStructure;
			}
			
			throw new NoIdFoundException(" Invalid id to update  "+id);
				
		
	}
	public ResponseStructure<List<Item>> getAllItem(){
		List<Item> list = dao.getAllItem();
		ResponseStructure<List<Item>>  responseStructure= new ResponseStructure<List<Item>>();
		if(list != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(list);
			return  responseStructure;
		}
		throw new EmptyListException(" No Record found !!!! ");
	}

}
