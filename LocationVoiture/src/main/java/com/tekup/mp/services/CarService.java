package com.tekup.mp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.mp.interfaces.CarInterface;
import com.tekup.mp.models.Car;
import com.tekup.mp.repository.CarRepository;

@Service
public class CarService implements CarInterface{

	@Autowired
	private CarRepository carRepository;

	@Override
	public Iterable<Car> getAllCars() {
		return carRepository.findAll();
	}

	@Override
	public Car getCarById(Long id) {
		return carRepository.findById(id).orElse(null);
	}

	@Override
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}
	
	@Override
	public void deleteCarById(Long id) {
		carRepository.deleteById(id);
	}

	@Override
	public List<Car> findByEtat(String etat) {
		return carRepository.findByEtat(etat);
	}
}
