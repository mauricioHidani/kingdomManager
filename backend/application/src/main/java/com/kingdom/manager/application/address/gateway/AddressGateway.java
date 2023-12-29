package com.kingdom.manager.application.address.gateway;

import com.kingdom.manager.domain.address.models.Address;

public interface AddressGateway {
    Address save(Address address);
}
