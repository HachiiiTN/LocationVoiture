package com.tekup.mp.interfaces;

import com.tekup.mp.models.Operation;

public interface OperationInterface {
	
Iterable<Operation> getAllOperations();
	
	Operation getOperationById(Long id);
	
	Operation saveOperation(Operation operation);
	
	void deleteOperationById(Long id);

}
