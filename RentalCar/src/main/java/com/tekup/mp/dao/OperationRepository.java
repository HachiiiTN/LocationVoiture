package com.tekup.mp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.mp.jpa.entities.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

}
