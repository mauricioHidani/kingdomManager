package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.gateway.AddressGateway;
import com.kingdom.manager.application.address.out.AddressOutput;
import com.kingdom.manager.application.address.usecases.AddressFindById;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import com.kingdom.manager.domain.exceptions.ResourceNotFoundException;

import java.util.UUID;

public class AddressFindByIdImpl implements AddressFindById {

    private final AddressGateway gateway;

    public AddressFindByIdImpl(AddressGateway gateway) {
        this.gateway = gateway;
    }

    @Override public AddressOutput execute(UUID id) {
        if (id == null) {
            throw new InvalidArgumentException(
                    "It is not possible to perform the operation with information provided in the request"
            );
        }

        var result = gateway.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The address with the specified id was not found"
                ));

        return AddressOutput.from(result);
    }

}
