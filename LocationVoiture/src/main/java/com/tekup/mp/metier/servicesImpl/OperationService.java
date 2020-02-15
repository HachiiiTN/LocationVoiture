package com.tekup.mp.metier.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.mp.dao.OperationRepository;
import com.tekup.mp.jpa.entities.Operation;
import com.tekup.mp.services.OperationInterface;

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
	
	@Override
	public void deleteOperationById(Long id) {
		operationRepository.deleteById(id);
	}

}
