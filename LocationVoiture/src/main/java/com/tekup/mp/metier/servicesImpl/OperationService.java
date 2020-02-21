package com.tekup.mp.metier.servicesImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.mp.dao.OperationRepository;
import com.tekup.mp.jpa.entities.Operation;
import com.tekup.mp.metier.services.OperationInterface;

@Service
@Transactional
public class OperationService implements OperationInterface{

	@Autowired
	private OperationRepository operationRepository;
	
	@Override
	public Iterable<Operation> getAllOperations() {
		return operationRepository.findAll();
	}

	@Override
	public Operation getOperationById(Long id) {
		return operationRepository.findById(id).orElse(null);
	}

	@Override
	public Operation saveOperation(Operation operation) {
		return operationRepository.save(operation);
	}
	
	@Override
	public void deleteOperationById(Long id) {
		operationRepository.deleteById(id);
	}

}
