package com.ty.krazyadda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.krazyadda.dto.OrdersFood;

public interface OrderRepository extends JpaRepository<OrdersFood, Integer>{

}
