package com.tekup.mp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tekup.mp.models.Operation;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

}
