package com.kingdom.manager.infrastructure.address.services;

import com.kingdom.manager.application.address.gateway.AddressGateway;
import com.kingdom.manager.application.address.in.AddressInput;
import com.kingdom.manager.application.address.out.AddressOutput;
import com.kingdom.manager.application.address.usecases.AddressCreate;
import com.kingdom.manager.application.address.usecases.impls.AddressCreateImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    private final AddressCreate create;

    public AddressService(AddressGateway gateway) {
        this.create = new AddressCreateImpl(gateway);
    }

    @Transactional
    public AddressOutput create(AddressInput input) {
        return create.execute(input);
    }

}
