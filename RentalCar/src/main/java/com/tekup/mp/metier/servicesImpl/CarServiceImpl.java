package com.tekup.mp.metier.servicesImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.mp.dao.CarRepository;
import com.tekup.mp.jpa.entities.Car;
import com.tekup.mp.metier.services.ICarService;

@Service
@Transactional
public class CarServiceImpl implements ICarService {

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
