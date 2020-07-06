package com.amazing.store.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.amazing.store.enums.Availability;

@Entity
@Table(name="TB_PRODUCT")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PRODUCT_ID")
    private Long id;
 
	@Column(name="PRODUCT_DATE_CREATION")
    private LocalDateTime dateCreated;
    
	@Column(name="PRODUCT_NAME")
	private String name;
    
	@Column(name="PRODUCT_PRICE")
    private Float price;
    
	@Column(name = "ORDER_AVAILABILITY")
	private Availability availability;

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
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public Float getPrice() {
    	return price;
    }
    
    public void setPrice(Float price) {
    	this.price = price;
    }

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
}
