package com.amazing.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.amazing.store.entity.Order;
import com.amazing.store.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService OrderService;
	
	@GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
	public List<Order> getOrders() {
		return OrderService.getAllOrders();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public Order saveOrder(@RequestBody Order Order) {
		return OrderService.saveOrder(Order);
	}
	
	@PatchMapping
    @ResponseStatus(HttpStatus.OK)
	public Order updateOrder(@RequestBody Order Order) {
		return OrderService.updateOrder(Order);
	}
	
}
