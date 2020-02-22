package com.tekup.mp.metier.services;

import com.tekup.mp.jpa.entities.User;

public interface UserInterface {

	Iterable<User> getAllUsers();
	
	User getUserById(Long id);
	
	User saveUser(User user);
	
	void deleteUserById(Long id);
}
