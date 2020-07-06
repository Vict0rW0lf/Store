package com.amazing.store.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="TB_ORDER")
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
    private Long id;
 
	@Column(name="ORDER_DATE_CREATION")
    private LocalDateTime dateCreated;

    @JoinColumn(name = "PRODUCT_PRODUCT_ID")
	@ManyToMany
    private List<Product> orderProducts = new ArrayList<>();

    @JsonBackReference
	@JoinColumn(name="CLIENT_CLIENT_ID")
	@ManyToOne
    private Client client;
	
	@Transient
	private Float total = 0.0f;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<Product> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<Product> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Float getTotal() {
		
		for (Product op : orderProducts) {
			this.total += op.getPrice();
		}
		
		return this.total;
	}
	
}
