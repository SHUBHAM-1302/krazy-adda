package com.ty.krazyadda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.krazyadda.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	public Person findByEmail(String email);
	
	
	@Query("select p from Person p where p.phoneNumber=?1")
	public Person finfByPhoneNumber(long phoneNumber);
}
