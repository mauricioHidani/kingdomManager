package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.gateway.AddressTypeGateway;
import com.kingdom.manager.application.address.in.AddressTypeInput;
import com.kingdom.manager.application.address.out.AddressTypeOutput;
import com.kingdom.manager.application.address.usecases.AddressTypeUpdate;
import com.kingdom.manager.domain.address.models.AddressType;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import com.kingdom.manager.domain.exceptions.ResourceNotFoundException;

public class AddressTypeUpdateImpl implements AddressTypeUpdate {

    private final AddressTypeGateway gateway;

    public AddressTypeUpdateImpl(AddressTypeGateway gateway) {
        this.gateway = gateway;
    }

    @Override public AddressTypeOutput execute(Integer id, AddressTypeInput input) {
        if (id == null || id < 1) {
            throw new InvalidArgumentException(
                    "It is not possible to perform the operation with information provided in the request"
            );
        }
        if (input == null) {
            throw new InvalidArgumentException(
                    "It is not possible to perform the operation without providing the information to update"
            );
        }

        var reference = gateway.getReferenceById(id);
        if (reference == null) {
            throw new ResourceNotFoundException(
                    "The address type with the specified id was not found"
            );
        }

        var updated = new AddressType(
                reference.id(),
                input.title().isBlank() ? reference.title() : input.title(),
                input.description().isBlank() ? reference.description() : input.description()
        );
        var result = gateway.save(updated);
        return AddressTypeOutput.from(result);
    }

}
