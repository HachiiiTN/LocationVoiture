package com.tekup.mp.metier.services;

import java.util.List;

import com.tekup.mp.jpa.entities.Car;

public interface ICarService {

	Iterable<Car> getAllCars();
	
	Car getCarById(Long id);
	
	Car saveCar(Car car);
	
	void deleteCarById(Long id);
	
	List<Car> findByEtat(String etat);
}
