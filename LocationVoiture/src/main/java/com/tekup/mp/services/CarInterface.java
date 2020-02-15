package com.tekup.mp.services;

import java.util.List;

import com.tekup.mp.jpa.entities.Car;

public interface CarInterface {

	Iterable<Car> getAllCars();
	
	Car getCarById(Long id);
	
	Car saveCar(Car car);
	
	void deleteCarById(Long id);
	
	List<Car> findByEtat(String etat);
}
