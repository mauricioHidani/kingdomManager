package com.kingdom.manager.application.address.usecases.impls;

import com.kingdom.manager.application.address.gateway.AddressGateway;
import com.kingdom.manager.application.address.in.AddressInput;
import com.kingdom.manager.application.address.out.AddressOutput;
import com.kingdom.manager.application.address.usecases.AddressCreate;
import com.kingdom.manager.domain.exceptions.DatabaseException;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;

public class AddressCreateImpl implements AddressCreate {

    private final AddressGateway gateway;

    public AddressCreateImpl(AddressGateway gateway) {
        this.gateway = gateway;
    }

    @Override public AddressOutput execute(AddressInput input) {
        if (input == null) {
            throw new InvalidArgumentException(
                    "Unable to proceed with the operation with the address being null"
            );
        }

        var result = gateway.save(AddressInput.toModel(input));
        if (result == null) {
            throw new DatabaseException(
                    "The operation was not carried out successfully"
            );
        }
        return AddressOutput.from(result);
    }

}
