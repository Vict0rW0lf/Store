package com.amazing.store.service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazing.store.entity.Client;
import com.amazing.store.repository.ClientRepository;
import com.amazing.store.util.MD5;

@Service
public class ClientService {

	@Autowired
	private ClientRepository ClientRepo;
	
	public List<Client> getAllClients() {
		List<Client> itens = new ArrayList<>();
		
		ClientRepo.findAll()
			.forEach(itens::add);
		
		return itens;
	}
	
	public Client saveClient(Client client) {
		
		client.setDateCreated(LocalDateTime.now());
		
		try {
			client.setPassword(MD5.turnIntoMD5(client.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return ClientRepo.save(client);
	}
	
	public Client updateClient(Client client) {
		return ClientRepo.save(client);
	}
	
	public Client findByUsername(String userName) {
		return ClientRepo.findByUserName(userName);
	}
	
}
