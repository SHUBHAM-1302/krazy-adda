package com.ty.krazyadda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.krazyadda.dao.ResponseStructure;
import com.ty.krazyadda.dao.UserDao;
import com.ty.krazyadda.dto.User;
import com.ty.krazyadda.exception.EmptyListException;
import com.ty.krazyadda.exception.FormatMissMatchException;
import com.ty.krazyadda.exception.NoIdFoundException;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	public ResponseStructure<User> saveUser(User user){
		User user2= userDao.saveUser(user);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if(user2!= null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(user2);
			return responseStructure;
		}
		throw new FormatMissMatchException();
	}
	public ResponseStructure<User> getUserById(int id) {
		User user2= userDao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if(user2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(user2);
			return responseStructure;		
		}
		throw new NoIdFoundException("No User found for the given id  "+id);
		
	
			
		
	}
	public ResponseStructure<Boolean> deleteUserById(int id) {
		ResponseStructure<Boolean>  responseStructure= new ResponseStructure<Boolean>();
		boolean status = userDao.deleteUserById(id);
		if(status) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(status);
			return responseStructure;
		}
		throw new NoIdFoundException(" Can not delete the User for the given id  "+id);
	}
	public ResponseStructure<User> updateUser(int id,User user) {
		User user2= userDao.updateUser(id, user);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if(user2 != null) {
			
			
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("success");
				responseStructure.setData(user2);
				return responseStructure;
			}
			
			throw new NoIdFoundException(" We can not update the user for the given id  "+id);
				
		
	}
	public ResponseStructure<List<User>> getAllUser(){
		List<User> users = userDao.getAllUser();
		ResponseStructure<List<User>>  responseStructure= new ResponseStructure<List<User>>();
		if(users != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(users);
			return  responseStructure;
		}
		throw new EmptyListException(" No Record found in user ");
	}

}
