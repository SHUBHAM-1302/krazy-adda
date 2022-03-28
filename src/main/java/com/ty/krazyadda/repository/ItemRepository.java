package com.ty.krazyadda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.krazyadda.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
