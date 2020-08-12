package com.skillstorm.controllers;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Parameter;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.beans.Invoice;
import com.skillstorm.beans.InvoiceLine;
import com.skillstorm.beans.User;
import com.skillstorm.repository.InvoiceRepository;
import com.skillstorm.repository.UserRepository;




@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InvoiceController {
	
	private static final Logger log = Logger.getLogger(InvoiceController.class);
	
	private final String uri = "/invoiceTracker/api/invoice";
	
	@Autowired
	private InvoiceRepository invoiceRepo;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*") 
	@GetMapping(value = uri + "")
	public ResponseEntity<List<Invoice>> getByUserIdOrCustomer(@RequestParam int userId, @RequestParam(required = false) String custId) {
		log.info("userId " + userId);
		//System.out.println("uid " + userId);
		
		if(custId != null && userId > 0) {
			return new ResponseEntity<List<Invoice>>(invoiceRepo.findByUserUserIdAndCustomerCustomerId(userId,Integer.parseInt(custId) ), HttpStatus.OK ); 
			
		}
		else {
			return new ResponseEntity<List<Invoice>>(invoiceRepo.findByUserUserIdOrderByDueDateDesc(userId), HttpStatus.OK);
		}
		
		
		
	}

	
	public ResponseEntity<List<InvoiceLine>> getInvoiceLines(){
		
		
		return new ResponseEntity<List<InvoiceLine>>(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*") 
	@PostMapping(value = uri + "" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invo){
		log.info("InvoceBody" + invo);
		return new ResponseEntity<Invoice>(invoiceRepo.save(invo), HttpStatus.CREATED);
		
		
	}

	

	
	
	
	
	
//	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*") 
//	@GetMapping(value = uri)
//	public ResponseEntity<List<Invoice>> findAll(HttpSession session){
//		session.getAttribute("user");
//
//		return new ResponseEntity<List<Invoice>>(invoiceRepo.findAll(), HttpStatus.OK);
//	}
	
	

}
