package com.tcs.user.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.user.DTO.UserDTO;
import com.tcs.user.entity.User;
import com.tcs.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/user")
	void Create(@RequestBody UserDTO userDTO)
	{
		userservice.saveUser(userDTO);
		System.out.println("User Created....");
	}
	
	@GetMapping("/user")
	List<User> getAllUsers()
	{
		return userservice.findAll();
	}
	
	@GetMapping("/user/bank/{userId}")
	UserDTO getUserAccountDetails(@PathVariable int userId)
	{
		return userservice.getUserAccountDetails(userId);
	}
	
	@GetMapping("/user/{userId}")
	User getUserDetails(@PathVariable int userId)
	{
		return userservice.getUserById(userId);
	}
	
	@PutMapping("/user")
	void updateUserAndBank(@RequestBody UserDTO userDTO)
	{
		System.out.println(userDTO);
		userservice.updateUserAndBank(userDTO);
		System.out.println("User Updated....");
	}
	
	
	@DeleteMapping("/user/{id}")
	void deleteUserAndAccount(@PathVariable int id)
	{
		userservice.deleteUserAndAccount(id);
		System.out.println("User Deleted.....");
	}

}

