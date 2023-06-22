package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.User;
import com.rest.service.IUserService;

@RestController
@RequestMapping("api/v1")
public class UserController 
{
	@Autowired
	private IUserService userService;

//	http://localhost:8080/api/v1/
	
//	http://localhost:8080/api/v1/adduser
//	http://localhost:8080/api/v1/getalluser
//	http://localhost:8080/api/v1/deluser
//	http://localhost:8080/api/v1/updateuser
//	http://localhost:8080/api/v1/getuserbyid

	private ResponseEntity<?> responseEntity;
	
	@PostMapping("/adduser")
	public ResponseEntity<?> saveUserHandler(@RequestBody User uobj)
	{
		User newUser = this.userService.saveUser(uobj);
		responseEntity = new ResponseEntity<>(newUser,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/getAllusers")
	public ResponseEntity<?> getAllUsersHandler()
	{
		List<User> allUsers = this.userService.getAllUsers();
		responseEntity = new ResponseEntity<>(allUsers,HttpStatus.OK);
		return responseEntity;
	}
	
	
}
