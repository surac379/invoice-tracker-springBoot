package com.skillstorm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.beans.Customer;
import com.skillstorm.beans.Invoice;
import com.skillstorm.beans.InvoiceLine;
import com.skillstorm.beans.User;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
	
	public List<Invoice> findAll();
	
	public Invoice findById(int id);
	
	public Invoice save(Invoice inv);
	
	
	public List<Invoice> findByUser(User user);
	public List<Invoice> findByUserUserIdOrderByDueDateDesc(int id);
	public List<Invoice> findByCustomer(int id);
	
	public List<Invoice> findByUserUserIdAndCustomerCustomerId(int uId, int cId);
	
	public List<InvoiceLine> findByInvoiceId(int id);
	

}
