package com.amazing.store.repository;

import org.springframework.data.repository.CrudRepository;

import com.amazing.store.entity.Product;

public interface ProductRepository  extends CrudRepository<Product, Long> {

	
}
