package com.kingdom.manager.infrastructure.address.persists.repositories;

import com.kingdom.manager.application.address.gateway.AddressGateway;
import com.kingdom.manager.domain.address.models.Address;
import com.kingdom.manager.infrastructure.address.mappers.AddressMapper;

import java.util.Optional;
import java.util.UUID;

public class AddressGatewayImpl implements AddressGateway {

    private final JpaAddressRepository repository;

    public AddressGatewayImpl(JpaAddressRepository repository) {
        this.repository = repository;
    }

    @Override public Address save(Address address) {
        var result = repository.save(
                AddressMapper.toEntity(address)
        );
        return AddressMapper.toModel(result);
    }

    @Override public Optional<Address> findById(UUID id) {
        var result = repository.findById(id);
        return AddressMapper.toModel(result);
    }

}
