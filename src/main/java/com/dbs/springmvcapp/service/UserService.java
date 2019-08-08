package com.dbs.springmvcapp.service;

import java.util.List;

import com.dbs.springmvcapp.model.User;


public interface UserService {
			
	
	User saveUser(User user);

	   List<User> listAll();

	   User findById(long userId);

	   void deleteUser(long userId);
	   
	   void addTweetToId(long userId);
}
