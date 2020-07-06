package com.amazing.store.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.amazing.store.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{
	
    @Query("SELECT c FROM Client c where c.userName = :userName") 
	Client findByUserName(@Param("userName") String userName);

}