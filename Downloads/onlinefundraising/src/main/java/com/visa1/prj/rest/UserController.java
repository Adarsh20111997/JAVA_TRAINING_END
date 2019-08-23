package com.visa1.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa1.prj.entity.User;
import com.visa1.prj.service.DonationService;

@RestController
public class UserController {
	@Autowired
	private DonationService ds;
	
	@GetMapping("users")
	public List<User> getUsers(){
		return ds.getUsers();
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User u){
		ds.saveUser(u);
		return new ResponseEntity<>(u,HttpStatus.CREATED);
	}
}
