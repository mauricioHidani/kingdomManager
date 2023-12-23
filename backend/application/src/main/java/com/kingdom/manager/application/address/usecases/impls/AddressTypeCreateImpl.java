package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.gateway.AddressTypeGateway;
import com.kingdom.manager.application.address.in.AddressTypeInput;
import com.kingdom.manager.application.address.out.AddressTypeOutput;
import com.kingdom.manager.application.address.usecases.AddressTypeCreate;
import com.kingdom.manager.domain.exceptions.DatabaseException;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;

public class AddressTypeCreateImpl implements AddressTypeCreate {

    private final AddressTypeGateway gateway;

    public AddressTypeCreateImpl(AddressTypeGateway gateway) {
        this.gateway = gateway;
    }

    @Override public AddressTypeOutput execute(AddressTypeInput input) {
        if (input == null) {
            throw new InvalidArgumentException(
                    "Unable to proceed with the operation with the address type being null"
            );
        }

        var result = gateway.save(AddressTypeInput.toModel(input));
        if (result == null) {
            throw new DatabaseException(
                    "The operation was not carried out successfully"
            );
        }

        return AddressTypeOutput.from(result);
    }

}
