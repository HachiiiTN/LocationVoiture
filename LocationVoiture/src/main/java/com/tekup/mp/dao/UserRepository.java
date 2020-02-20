package com.tekup.mp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.mp.jpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);

}
