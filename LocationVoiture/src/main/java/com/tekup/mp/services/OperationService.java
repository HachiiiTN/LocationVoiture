package com.tekup.mp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.mp.interfaces.OperationInterface;
import com.tekup.mp.models.Operation;
import com.tekup.mp.repository.OperationRepository;

@Service
public class OperationService implements OperationInterface{

	@Autowired
	private OperationRepository operationRepository;
	
	@Override
	public Iterable<Operation> getAllOperations() {
		// TODO Auto-generated method stub
		return operationRepository.findAll();
	}

	@Override
	public Operation getOperationById(Long id) {
		// TODO Auto-generated method stub
		return operationRepository.findById(id).orElse(null);
	}

	@Override
	public Operation saveOperation(Operation operation) {
		// TODO Auto-generated method stub
		return operationRepository.save(operation);
	}

}
