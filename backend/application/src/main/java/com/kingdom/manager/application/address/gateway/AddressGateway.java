package com.kingdom.manager.application.address.gateway;

import com.kingdom.manager.domain.address.models.Address;

import java.util.Optional;
import java.util.UUID;

public interface AddressGateway {
    Address save(Address address);
    Optional<Address> findById(UUID id);
}
