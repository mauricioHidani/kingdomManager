package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.gateway.AddressTypeGateway;
import com.kingdom.manager.application.address.out.AddressTypeOutput;
import com.kingdom.manager.application.address.usecases.AddressTypeFindByTitle;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import com.kingdom.manager.domain.exceptions.ResourceNotFoundException;

public class AddressTypeFindByTitleImpl implements AddressTypeFindByTitle {

    private final AddressTypeGateway gateway;

    public AddressTypeFindByTitleImpl(AddressTypeGateway gateway) {
        this.gateway = gateway;
    }

    @Override public AddressTypeOutput execute(String title) {
        if (title.isBlank()) {
            throw new InvalidArgumentException(
                    "It is not possible to perform the operation with information provided in the request"
            );
        }
        var result = gateway.findByTitle(title);
        if (result == null) {
            throw new ResourceNotFoundException(
                    "The type of address provided was not found"
            );
        }
        return AddressTypeOutput.from(result);
    }

}
