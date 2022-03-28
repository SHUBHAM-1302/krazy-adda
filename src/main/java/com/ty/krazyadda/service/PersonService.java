package com.ty.krazyadda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.krazyadda.dao.PersonDao;
import com.ty.krazyadda.dao.ResponseStructure;
import com.ty.krazyadda.dto.Person;
import com.ty.krazyadda.dto.User;
import com.ty.krazyadda.exception.FormatMissMatchException;
import com.ty.krazyadda.exception.NoIdFoundException;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao dao;
	
	public ResponseStructure<Person> savePerson(Person person){
		Person person2= dao.savePerson(person);
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		if(person2!= null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(person2);
			return responseStructure;
		}
		throw new FormatMissMatchException();
	}
	public ResponseStructure<Person> getPersonByEmail(String email) {
		Person person2= dao.getPersonByEmail(email);
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		if(person2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(person2);
			return responseStructure;		
		}
		throw new NoIdFoundException("invalid email");
	}
	
	public ResponseStructure<Person> getPersonByPhone(long phone) {
		Person person2= dao.getPersonByPhoneNumber(phone);
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		if(person2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(person2);
			return responseStructure;		
		}
		throw new NoIdFoundException("invalid phone Number");
	}
	

}
