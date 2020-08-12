package com.skillstorm.beans;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Invoice {
	
	//invoice - invoice_id, customer_id ( foreign key) , invoice_details,  paid_status, invoice_date, paid_date, sent_status, user_id (foreign key)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invoice_id")
	private int invoiceId;
	
	private String invoiceDetails;
	
	private boolean paidStatus;
	private Date createDate;
	private Date dueDate;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonManagedReference
	private Customer customer;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonBackReference(value = "invoice-user")
	private User user;
	
	@OneToMany(mappedBy = "invoiceId")
	@JsonManagedReference
	private Set<InvoiceLine> invoiceLine;
	
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getInvoiceDetails() {
		return invoiceDetails;
	}
	public void setInvoiceDetails(String invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	} 
	public boolean isPaidStatus() {
		return paidStatus;
	}
	public void setPaidStatus(boolean paidStatus) {
		this.paidStatus = paidStatus;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<InvoiceLine> getInvoiceLine() {
		return invoiceLine;
	}
	public void setInvoiceLine(Set<InvoiceLine> invoiceLine) {
		this.invoiceLine = invoiceLine;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	
	
	
	
	
	
	
	
}
