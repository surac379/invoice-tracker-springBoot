package com.skillstorm.controllers;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.beans.Customer;
import com.skillstorm.beans.User;
import com.skillstorm.repository.CustomerRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
	

	private static final Logger log = Logger.getLogger(CustomerController.class); 
	
	@Autowired
	private CustomerRepository repo;
	
	@GetMapping(value = "/invoiceTracker/api/customers" )
	public ResponseEntity<List<Customer>> Customers(@RequestParam int userId)
	{
		log.info("inside get request customer controller");
		return new ResponseEntity<List<Customer>>(repo.findByUserUserId(userId),HttpStatus.OK);
	}
	
	
	@PostMapping(value= "/invoiceTracker/api/addcustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> Save(@RequestBody Customer customer )
	{
		log.info("inside put request of customer controller");
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(repo.save(customer),HttpStatus.CREATED);
		
		return response;
	}
	

	

}
