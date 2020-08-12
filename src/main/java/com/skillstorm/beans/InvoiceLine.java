package com.skillstorm.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class InvoiceLine {
	
	//Invoice_line - invoice_line_id, invoice_id, order_id(foreign key), quantity
	
	public InvoiceLine() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceLineId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id")
	@JsonBackReference
	private Invoice invoiceId; //foreign key 
	
	private String invoiceLineItemDescription;
	private int quantity;
	private float cost;
	public int getInvoiceLineId() {
		return invoiceLineId;
	}
	public void setInvoiceLineId(int invoiceLineId) {
		this.invoiceLineId = invoiceLineId;
	}

	public String getInvoiceLineitemDescription() {
		return invoiceLineItemDescription;
	}
	public void setInvoiceLineitemDescription(String invoiceLineitemDescription) {
		this.invoiceLineItemDescription = invoiceLineitemDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public Invoice getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Invoice invoiceId) {
		this.invoiceId = invoiceId;
	}
	@Override
	public String toString() {
		return "InvoiceLine [invoiceLineId=" + invoiceLineId + ", invoiceId=" + invoiceId
				+ ", invoiceLineitemDescription=" + invoiceLineItemDescription + ", quantity=" + quantity + ", cost="
				+ cost + "]";
	}
	
	
	
	

}
