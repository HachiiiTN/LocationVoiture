package com.tekup.mp.repository;

import org.springframework.data.repository.CrudRepository;

import com.tekup.mp.models.Operation;

public interface OperationRepository extends CrudRepository<Operation, Long> {

}
