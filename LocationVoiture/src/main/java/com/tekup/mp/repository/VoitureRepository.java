package com.tekup.mp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tekup.mp.models.Voiture;

@Repository
public interface VoitureRepository extends CrudRepository<Voiture, Long> {

}
