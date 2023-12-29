package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.gateway.AddressTypeGateway;
import com.kingdom.manager.application.address.out.AddressTypeOutput;
import com.kingdom.manager.application.address.usecases.AddressTypeFindById;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import com.kingdom.manager.domain.exceptions.ResourceNotFoundException;

public class AddressTypeFindByIdImpl implements AddressTypeFindById {

    private final AddressTypeGateway gateway;

    public AddressTypeFindByIdImpl(AddressTypeGateway gateway) {
        this.gateway = gateway;
    }

    @Override public AddressTypeOutput execute(Integer id) {
        if (id == null || id < 1) {
            throw new InvalidArgumentException(
                    "It is not possible to perform the operation with information provided in the request"
            );
        }

        var result = gateway.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The address type with the specified id was not found"
                ));
        return AddressTypeOutput.from(result);
    }

}
