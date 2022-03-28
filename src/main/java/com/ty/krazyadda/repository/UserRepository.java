package com.ty.krazyadda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.krazyadda.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
