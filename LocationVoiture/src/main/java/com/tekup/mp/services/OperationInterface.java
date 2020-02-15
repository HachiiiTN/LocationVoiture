package com.tekup.mp.services;

import com.tekup.mp.jpa.entities.Operation;

public interface OperationInterface {
	
Iterable<Operation> getAllOperations();
	
	Operation getOperationById(Long id);
	
	Operation saveOperation(Operation operation);
	
	void deleteOperationById(Long id);

}
