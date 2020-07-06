package com.amazing.store.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazing.store.entity.Order;
import com.amazing.store.repository.OrderRepository;


@Service
public class OrderService {

	@Autowired
	private OrderRepository OrderRepo;
	
	public List<Order> getAllOrders() {
		List<Order> itens = new ArrayList<>();
		
		OrderRepo.findAll()
			.forEach(itens::add);
		
		return itens;
	}
	
	public Order saveOrder(Order order) {
		
		order.setDateCreated(LocalDateTime.now());
		
		return OrderRepo.save(order);
	}
	
	public Order updateOrder(Order order) {
		return OrderRepo.save(order);
	}
	
}
