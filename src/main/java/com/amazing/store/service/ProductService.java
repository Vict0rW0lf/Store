package com.amazing.store.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazing.store.entity.Product;
import com.amazing.store.enums.Availability;
import com.amazing.store.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository ProductRepo;
	
	public List<Product> getAllProducts() {
		List<Product> itens = new ArrayList<>();
		
		ProductRepo.findAll()
			.forEach(itens::add);
		
		return itens;
	}
	
	public Product saveProduct(Product product) {
		
		product.setDateCreated(LocalDateTime.now());
		product.setAvailability(Availability.AVAILABLE);
		
		return ProductRepo.save(product);
	}
	
	public Product replaceProduct(Product product) {
		return ProductRepo.save(product);
	}
	
	public Product updateProduct(Product product) {
		return ProductRepo.save(product);
	}
	
	public void deleteProductById(Long id) {
		ProductRepo.deleteById(id);
	}

}
