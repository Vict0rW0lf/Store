package com.amazing.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.amazing.store.entity.Product;
import com.amazing.store.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public Product saveProduct(@RequestBody Product Product) {
		return productService.saveProduct(Product);
	}
	
	@PutMapping
    @ResponseStatus(HttpStatus.OK)
	public Product replaceProduct(@RequestBody Product Product) {
		return productService.replaceProduct(Product);
	}
	
	@PatchMapping
    @ResponseStatus(HttpStatus.OK)
	public Product updateProduct(@RequestBody Product Product) {
		return productService.updateProduct(Product);
	}
	
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProductbyId(@PathVariable Long id) {
		productService.deleteProductById(id);
	}
	
}
