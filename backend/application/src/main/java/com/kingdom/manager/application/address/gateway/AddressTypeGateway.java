package com.kingdom.manager.application.address.gateway;

import com.kingdom.manager.domain.address.models.AddressType;

import java.util.List;
import java.util.Optional;

public interface AddressTypeGateway {
    AddressType save(AddressType addressType);
    Boolean existingById(Integer id);
    AddressType getReferenceById(Integer id);
    Optional<AddressType> findById(Integer id);
    AddressType findByTitle(String title);
    List<AddressType> findAll();
    void delete(Integer id);
}
