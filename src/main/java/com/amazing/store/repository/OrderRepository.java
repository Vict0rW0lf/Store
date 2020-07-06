package com.amazing.store.repository;

import org.springframework.data.repository.CrudRepository;

import com.amazing.store.entity.Order;


public interface OrderRepository extends CrudRepository<Order, Long> {

}
