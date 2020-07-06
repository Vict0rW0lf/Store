package com.amazing.store.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.amazing.store.dto.Login;
import com.amazing.store.entity.Client;
import com.amazing.store.service.ClientService;
import com.amazing.store.util.Security;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private ClientService cs;

	@GetMapping
    @ResponseStatus(HttpStatus.OK)
	public String loginPage(Model model) {
	    model.addAttribute("login", new Login()); 
		return "login";
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.OK)
	public String login(@ModelAttribute Login login, BindingResult errors, Model model) throws NoSuchAlgorithmException {
		
		Client c = cs.findByUsername(login.getUserName());
		
		if (c != null && Security.authenticate(login.getPassword(), c.getPassword())) {
			model.addAttribute("client", c);
			return "client-info";
		}
		
		return "failed-authentication";
	}
	
	
}
