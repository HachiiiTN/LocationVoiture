package com.tekup.mp.metier.servicesImpl;

import com.tekup.mp.dao.CarRepository;
import com.tekup.mp.dao.UserRepository;
import com.tekup.mp.jpa.entities.Car;
import com.tekup.mp.jpa.entities.User;
import com.tekup.mp.metier.services.CarInterface;
import com.tekup.mp.metier.services.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserInterface {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
}
