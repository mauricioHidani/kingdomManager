package com.kingdom.manager.address.impls;

import com.kingdom.manager.address.AddressTypeFindById;
import com.kingdom.manager.address.responses.AddressTypeResponse;
import com.kingdom.manager.exceptions.InvalidRequestException;
import com.kingdom.manager.exceptions.ResourceNotFoundException;
import com.kingdom.manager.models.AddressType;
import com.kingdom.manager.persists.AddressTypeRepository;

public class AddressTypeFindByIdImpl implements AddressTypeFindById {

    private final AddressTypeRepository repository;

    public AddressTypeFindByIdImpl(AddressTypeRepository repository) {
        this.repository = repository;
    }

    @Override public AddressTypeResponse execute(Integer id) {
        if (id == null || id < 1) {
            throw new InvalidRequestException("Unable to perform query operation");
        }

        AddressType found = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "There not possible to find address type by id"
                ));

        return AddressTypeResponse.from(found);
    }
}
