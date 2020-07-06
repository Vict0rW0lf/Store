package com.amazing.store.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.amazing.store.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="TB_CLIENT")
public class Client {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CLIENT_ID")
    private Long id;
 
	@Column(name="CLIENT_DATE_CREATION")
    private LocalDateTime dateCreated;
    
	@Column(name="CLIENT_NAME", nullable = false)
    private String name;
    
	@Column(name="CLIENT_LASTNAME", nullable = false)
    private String lastName;
    
	@Column(name="CLIENT_BIRTHDAY", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    
	@Column(name="CLIENT_GENDER", nullable = false)
    private Gender gender;
    
	@Column(name="CLIENT_USERNAME", length = 30, nullable = false)
    private String userName;
    
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name="CLIENT_PASSWORD", length = 100, nullable = false)
	private String password;
	
	@Column(name="CLIENT_EMAIL", nullable = false)
	private String email;
	
	@Column(name="CLIENT_COUNTRY", nullable = false)
	private String country;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
