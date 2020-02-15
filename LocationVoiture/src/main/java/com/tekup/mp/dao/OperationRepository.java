package com.tekup.mp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tekup.mp.jpa.entities.Operation;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

}
