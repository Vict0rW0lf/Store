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

import com.amazing.store.entity.Client;
import com.amazing.store.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
	public List<Client> getClients() {
		return clientService.getAllClients();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public Client saveClient(@RequestBody Client Client) {
		return clientService.saveClient(Client);
	}
	
	@PatchMapping
    @ResponseStatus(HttpStatus.OK)
	public Client updateClient(@RequestBody Client Client) {
		return clientService.updateClient(Client);
	}
	
}
