package com.ty.krazyadda.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.krazyadda.dto.Person;
import com.ty.krazyadda.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepository personRepository;

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public Person getPersonByEmail(String email) {
		Person person = personRepository.findByEmail(email);
		if (person != null) {
			return person;
		}
		return null;
	}

	public Person getPersonByPhoneNumber(long phoneNumbre) {
		Person person = personRepository.finfByPhoneNumber(phoneNumbre);
		if (person != null) {
			return person;
		}
		return null;

	}

	

	

}
