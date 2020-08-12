package com.skillstorm.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.validation.constraints.Null;



@Entity
public class Customer {
	
	//customer - customer_id, customer_firstname, customer_lastname, customer address, email, city, state, 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;
	

	private String customerFirstname;
	@Column(name = "customerLastname")
	private String customerLastname;
	@Column(name = "customerAddress")
	private String customerAddress;
	@Column(name = "customerEmail")
	private String customerEmail;
	@Column(name = "customerCity")
	private String customerCity;
	@Column(name = "customerState")
	private String customerState;
	
	@Column(name= "customerPhoneNumber")
	private String customerPhoneNumber;
	private String customerPicture;
	
	
	public String getCustomerPicture() {
		return customerPicture;
	}

	public void setCustomerPicture(String customerPicture) {
		this.customerPicture = customerPicture;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	public User user;

	
	@JsonIgnore
	@JsonBackReference(value = "invoice-customer")
	@OneToMany(mappedBy = "customer")
	private Set<Invoice> invoice;
	

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstname() {
		return customerFirstname;
	}

	public void setCustomerFirstname(String customerFirstname) {
		this.customerFirstname = customerFirstname;
	}


	public String getCustomerLastname() {
		return customerLastname;
	}

	public void setCustomerLastname(String customerLastname) {
		this.customerLastname = customerLastname;

	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerFirstname=" + customerFirstname + ", customerLastname="
				+ customerLastname + ", customerAddress=" + customerAddress + ", customerEmail=" + customerEmail
				+ ", customerCity=" + customerCity + ", customerState=" + customerState + ", customerPhoneNumber="
				+ customerPhoneNumber + ", user=" + user + "]";
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
}
