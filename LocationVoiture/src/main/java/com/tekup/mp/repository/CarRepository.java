package com.tekup.mp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tekup.mp.models.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
	List<Car> findByEtat(String etat);
}
