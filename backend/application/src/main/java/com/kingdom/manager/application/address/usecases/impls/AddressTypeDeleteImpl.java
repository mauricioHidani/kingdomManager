package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.gateway.AddressTypeGateway;
import com.kingdom.manager.application.address.usecases.AddressTypeDelete;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import com.kingdom.manager.domain.exceptions.ResourceNotFoundException;

public class AddressTypeDeleteImpl implements AddressTypeDelete {

    private final AddressTypeGateway gateway;

    public AddressTypeDeleteImpl(AddressTypeGateway gateway) {
        this.gateway = gateway;
    }

    @Override public void execute(Integer id) {
        if (id == null || id < 1) {
            throw new InvalidArgumentException(
                    "It is not possible to perform the operation with information provided in the request"
            );
        }
        if (!gateway.existingById(id)) {
            throw new ResourceNotFoundException(
                    "The address type with the specified id was not found"
            );
        }
        gateway.delete(id);
    }

}
