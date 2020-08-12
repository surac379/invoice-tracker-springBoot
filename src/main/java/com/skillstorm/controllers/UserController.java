package com.skillstorm.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.beans.User;
import com.skillstorm.repository.UserRepository;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	
	
	@Autowired
	private UserRepository userRepo;
	
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*") 
	@RequestMapping(value = "/invoiceTracker/api/newUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User save(@RequestBody User user) {
		
		return userRepo.save(user);
		
	}
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*") 
	@RequestMapping(value = "/invoiceTracker/api/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> logIn(@RequestBody User user, HttpServletResponse response) {
		
		
		
		if( userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null   ) {
			User loggedInUser = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
			response.addCookie(new Cookie("userId", "" + loggedInUser.getUserId() ) ) ;
			return new ResponseEntity<User>(userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword()), HttpStatus.OK);
			
		}else {
			
			return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
			
		}

	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*") 
	@GetMapping(value = "/invoiceTracker/api/user",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@RequestParam int userId) {
		
		return new ResponseEntity<User>(userRepo.findByUserId(userId), HttpStatus.OK);
		
	}
	
	
	
	

}
