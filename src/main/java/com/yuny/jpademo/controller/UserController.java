package com.yuny.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yuny.jpademo.pojo.User;
import com.yuny.jpademo.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/comp")
	public User deleteUsers(@RequestBody String username) {
		User n=userRepository.findByUsername(username);
		return n;
	}
	//修改数据
	@PostMapping("/put")
	public void putUsers(@RequestBody User n) {
		userRepository.save(n);
	}
	//测试获取全部的数据
	/* @GetMapping(path="/all")
	// public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	} */
	@PostMapping("/getName")
	public User personByName(@RequestBody String name) {
	User n = userRepository.findByName(name);
	return n;
	}
}