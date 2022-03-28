package com.ty.krazyadda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.krazyadda.dao.ResponseStructure;
import com.ty.krazyadda.dto.Person;
import com.ty.krazyadda.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;

	@ApiOperation(value = "Save person ", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Person is saved"),
			@ApiResponse(code = 404, message = "Incorrect formate")

	})

	@PostMapping("/person")
	public ResponseStructure<Person> savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@ApiOperation(value = "Find person by email", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Person details"),
			@ApiResponse(code = 404, message = "invalid email id")

	})

	@GetMapping("/personemail")
	public ResponseStructure<Person> findPersonByEmail(@RequestParam String email) {
		return personService.getPersonByEmail(email);
	}
	
	@ApiOperation(value = "Find person by phone Number", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "Person details"),
			@ApiResponse(code = 404, message = "invalid phone number")

	})
		@GetMapping("/personphone")
	public ResponseStructure<Person> findPersonByPhoneNumber(@RequestParam long phoneNumber) {
		return personService.getPersonByPhone(phoneNumber);
	}

}
