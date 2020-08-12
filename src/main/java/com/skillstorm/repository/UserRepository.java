package com.skillstorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.skillstorm.beans.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsernameAndPassword(String username, String password);
	public User findByUserId(int id);
	
	

}
