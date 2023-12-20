package com.kingdom.manager.persists;

import com.kingdom.manager.models.AddressType;

import java.util.List;

public interface AddressTypeRepository {
    AddressType save(AddressType addressType);
    Boolean existingByTitle(String title);
    AddressType findByTitle(String title);
    List<AddressType> findByTitles(List<String> titles);
}
