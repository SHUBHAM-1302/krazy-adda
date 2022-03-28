package com.ty.krazyadda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.krazyadda.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
