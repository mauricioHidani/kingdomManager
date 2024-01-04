package com.kingdom.manager.infrastructure.address.services;

import com.kingdom.manager.application.address.gateway.AddressGateway;
import com.kingdom.manager.application.address.in.AddressInput;
import com.kingdom.manager.application.address.out.AddressOutput;
import com.kingdom.manager.application.address.usecases.AddressCreate;
import com.kingdom.manager.application.address.usecases.AddressFindById;
import com.kingdom.manager.application.address.usecases.impls.AddressCreateImpl;
import com.kingdom.manager.application.address.usecases.impls.AddressFindByIdImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AddressService {

    private final AddressCreate create;
    private final AddressFindById findById;

    public AddressService(AddressGateway gateway) {
        this.create = new AddressCreateImpl(gateway);
        this.findById = new AddressFindByIdImpl(gateway);
    }

    @Transactional
    public AddressOutput create(AddressInput input) {
        return create.execute(input);
    }

    @Transactional(readOnly = true)
    public AddressOutput findById(UUID id) {
        return findById(id);
    }

}
