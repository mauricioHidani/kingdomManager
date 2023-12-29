package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.gateway.AddressTypeGateway;
import com.kingdom.manager.application.address.out.AddressTypeOutput;
import com.kingdom.manager.application.address.usecases.AddressTypeFindAll;
import com.kingdom.manager.domain.exceptions.ResourceNotFoundException;

import java.util.List;

public class AddressTypeFindAllImpl implements AddressTypeFindAll {

    private final AddressTypeGateway gateway;

    public AddressTypeFindAllImpl(AddressTypeGateway gateway) {
        this.gateway = gateway;
    }

    @Override public List<AddressTypeOutput> execute() {
        var result = gateway.findAll();
        if (result.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Address types were not found"
            );
        }

        return result.stream()
                .map(AddressTypeOutput::from)
                .toList();
    }

}
