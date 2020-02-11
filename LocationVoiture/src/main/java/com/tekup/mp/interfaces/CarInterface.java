package com.tekup.mp.interfaces;

import com.tekup.mp.models.Car;

public interface CarInterface {

	Iterable<Car> getAllCars();
	
	Car getCarById(Long id);
	
	Car saveCar(Car car);
	
}
