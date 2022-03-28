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
import com.ty.krazyadda.dto.User;
import com.ty.krazyadda.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	 // i m deliting this
	
	
	@GetMapping("/user")
	public ResponseStructure<User> getUserById( @RequestParam int id)
	{
		return service.getUserById(id);
	}
	@DeleteMapping("/user")
	public ResponseStructure<Boolean> deleteUserById(@RequestParam int id)
	{
		return service.deleteUserById(id);
	}
	@GetMapping("/alluser")
	public ResponseStructure<List<User>> getUserList()
	{
		return service.getAllUser();
	}
	@PutMapping("/user")
	public ResponseStructure<User> updateUser(@RequestParam int id,@RequestBody User user) {
		return service.updateUser(id, user);
	}
	
	

}
