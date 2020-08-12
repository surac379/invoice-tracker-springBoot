package com.skillstorm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.beans.Customer;
import com.skillstorm.beans.User;

@Repository
public interface CustomerRepository extends  JpaRepository<Customer, Integer>{
	
	//public List<Customer> findAllUser(User user);
	public List<Customer> findByUserUserId(int userId);
	
	

}
