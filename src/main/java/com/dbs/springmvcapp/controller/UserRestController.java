package com.dbs.springmvcapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.springmvcapp.model.User;
import com.dbs.springmvcapp.service.UserService;



@RestController
@RequestMapping("/api/v1/")
public class UserRestController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value="/users",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<User> listAll()
	{
		System.out.println("Inside the list all method!!");
		return this.userService.listAll();
	}
	

	@GetMapping("/user/{id}")
	public User findUserById(@PathVariable("id") long id)
	{
		return this.userService.findById(id);
	}
	
	
	@PostMapping("/users")
	public void saveUser(@Valid @RequestBody User User)
	{
		this.userService.saveUser(User);
	}

}
