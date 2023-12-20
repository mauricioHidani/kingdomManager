package com.kingdom.manager.persists;

import com.kingdom.manager.models.AddressType;

import java.util.List;
import java.util.Optional;

public interface AddressTypeRepository {
    AddressType save(AddressType addressType);
    Optional<AddressType> findById(Integer id);
    Boolean existingByTitle(String title);
    AddressType findByTitle(String title);
    List<AddressType> findByTitles(List<String> titles);
}
