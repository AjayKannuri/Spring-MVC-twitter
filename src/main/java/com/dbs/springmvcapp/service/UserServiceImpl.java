package com.dbs.springmvcapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbs.springmvcapp.model.User;
import com.dbs.springmvcapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	@Override
	@Transactional
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public List<User> listAll() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<>();
    	this.userRepository.findAll().forEach(user -> list.add(user));
    	return list;
	}

	@Override
	@Transactional
	public User findById(long userId) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(userId).get();
	}

	@Override
	@Transactional
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub
		
		this.userRepository.deleteById(userId);
		
	}
	
	@Override
	@Transactional
	public void addTweetToId(long userId) {
		User user = this.userRepository.findById(userId).get();
		
		
	}
	

}
