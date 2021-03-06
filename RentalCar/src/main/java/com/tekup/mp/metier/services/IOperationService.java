package com.tekup.mp.metier.services;

import com.tekup.mp.jpa.entities.Operation;

public interface IOperationService {

    Iterable<Operation> getAllOperations();

    Operation getOperationById(Long id);

    Operation saveOperation(Operation operation);

    void deleteOperationById(Long id);

}
