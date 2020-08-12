package com.skillstorm.beans;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	
	@JsonIgnore
	@JsonBackReference(value = "user-invoice")
	@OneToMany(mappedBy = "user")
	private Set<Invoice> invoice;
	
	@Column(name = "username")
	@NotBlank
	private String username; 
	
	@Column(name = "password")
	@NotBlank
	private String password; 
	
	@Column(name = "user_address")
	private String userAddress; 
	
	@Column(name = "user_firstname")
	private String userFirstname; 
	
	@Column(name = "user_lastname")
	private String userLastame;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private Set<Customer> customers;
	
	
	public User() {
		
	}


	public int getUserId() {
		return userId;
	}


	public void setUser_id(int userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getUserFirstname() {
		return userFirstname;
	}


	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}


	public String getUserLastame() {
		return userLastame;
	}


	public void setUserLastame(String userLastame) {
		this.userLastame = userLastame;
	}


	@Override
	public String toString() {
		return "User [user_id=" + userId + ", username=" + username + ", password=" + password + ", userAddress="
				+ userAddress + ", userFirstname=" + userFirstname + ", userLastame=" + userLastame + "]";
	}


	public Set<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}


	public Set<Invoice> getInvoice() {
		return invoice;
	}


	public void setInvoice(Set<Invoice> invoice) {
		this.invoice = invoice;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	
	
	
	

	
	
	

}
